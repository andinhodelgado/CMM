package br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common.GetEquipConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EquipBolViewModel @Inject constructor (
    private val getEquipConfig: GetEquipConfig
): ViewModel() {

    private val _uiStateFlow = MutableStateFlow<EquipBolFragmentState>(EquipBolFragmentState.Init)
    val uiStateFlow: StateFlow<EquipBolFragmentState> get() = _uiStateFlow

    private fun getEquipNro(equip: Equip){
        _uiStateFlow.value = EquipBolFragmentState.GetNroEquip(equip)
    }

    fun recoverNroEquip() = viewModelScope.launch {
        getEquipNro(getEquipConfig())
    }

}

sealed class EquipBolFragmentState {
    object Init : EquipBolFragmentState()
    data class GetNroEquip(val equip: Equip) : EquipBolFragmentState()
}