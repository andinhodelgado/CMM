package br.com.usinasantafe.cmm.features.domain.usecases.implementos.updatedatabase

import br.com.usinasantafe.cmm.features.domain.repositories.stable.ItemOSMecanRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.updatedatabase.UpdateItemOSMecan
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateItemOSMecanImpl @Inject constructor(
    private val itemOSMecanRepository: ItemOSMecanRepository
): UpdateItemOSMecan {

    override suspend fun invoke(count: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = 3;
            var count = count;
            emit(ResultUpdateDataBase(++count, "Limpando Dados da Tabela ItemOSMecan", size))
            itemOSMecanRepository.deleteAllItemOSMecan()
            emit(ResultUpdateDataBase(++count,"Recebendo Dados da Tabela ItemOSMecan", size))
            itemOSMecanRepository.getAllItemOSMecan()
                .collect{ result ->
                    result.onSuccess { itemOSMecanList ->
                        emit(ResultUpdateDataBase(++count,"Salvandos Dados da Tabela ItemCheckList", size))
                        itemOSMecanRepository.addAllItemOSMecan(itemOSMecanList)
                    }
                }
        }
    }

}