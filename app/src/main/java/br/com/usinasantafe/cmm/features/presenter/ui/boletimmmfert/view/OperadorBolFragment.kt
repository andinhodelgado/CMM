package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.BackPressHandler
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGeneric
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentOperadorBolBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OperadorBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OperadorBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.config.view.ConfigActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class OperadorBolFragment : BaseFragment<FragmentOperadorBolBinding>(
    R.layout.fragment_operador_bol,
    FragmentOperadorBolBinding::bind
) {

    private val viewModel: OperadorBolViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    var backPressHandler: BackPressHandler? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()

    }

    private fun observe() {
        observeState()
        observeResult()
    }

    private fun observeState(){
        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeResult(){
        viewModel.resultUpdateDataBase.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStatusUpdate(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGeneric(layoutNovoBotoes, editTextPadrao)
            layoutNovoBotoes.buttonOkPadrao.setOnClickListener {
                if(editTextPadrao.text.isNotEmpty()){
                    viewModel.checkMatricFunc(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "MATRICULA DO OPERADOR"), requireContext())
                }
            }
            layoutNovoBotoes.buttonAtualPadrao.setOnClickListener {

            }
        }

    }

    private fun handleStateChange(state: OperadorBolFragmentState){
        when(state){
            is OperadorBolFragmentState.Init -> Unit
            is OperadorBolFragmentState.CheckMatricFunc -> handleCheckMatricOperador(state.checkMatricOperador)
            is OperadorBolFragmentState.CheckSetMatricFunc -> handleCheckSetMatricOperador(state.checkSetMatricOperador)
            is OperadorBolFragmentState.IsUpdateFunc -> handleUpdate(state.isUpdateFunc)
        }
    }

    private fun handleCheckMatricOperador(checkMatricOperador: Boolean) {
        if(checkMatricOperador){
            viewModel.setMatricFunc(binding.editTextPadrao.text.toString())
        } else {
            showGenericAlertDialog(getString(R.string.texto_dado_invalido_com_atual, "MATRICULA DO OPERADOR"), requireContext())
        }
    }

    private fun handleCheckSetMatricOperador(checkSetMatricOperador: Boolean) {
        if(checkSetMatricOperador){
            findNavController().navigate(R.id.action_operadorBolFragment_to_equipBolFragment)
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "MATRICULA DO OPERADOR"), requireContext())
        }
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?){
        with(binding) {
            resultUpdateDataBase?.let {
                genericDialogProgressBar.setValue(resultUpdateDataBase)
            }
        }
    }

    private fun handleUpdate(isUpdate: Boolean){
        if(isUpdate){
            genericDialogProgressBar = GenericDialogProgressBar(requireContext())
            genericDialogProgressBar.show()
            genericDialogProgressBar.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
            )
        } else {
            genericDialogProgressBar.cancel()
            findNavController().navigate(R.id.action_configFragment_to_menuInicialFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent(requireContext(), ConfigActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, callback
        )
    }

}
