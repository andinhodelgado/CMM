package br.com.usinasantafe.cmm.features.domain.usecases.implementos.database.recover

import br.com.usinasantafe.cmm.features.domain.repositories.stable.EquipRepository
import br.com.usinasantafe.cmm.features.domain.repositories.variable.BoletimMMFertRepository
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverREquipAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover.RecoverROSAtiv
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateAtividade
import br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.update.UpdateRFuncaoAtivParada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecoverAtividadeImpl @Inject constructor(
    private val boletimMMFertRepository: BoletimMMFertRepository,
    private val equipRepository: EquipRepository,
    private val recoverREquipAtiv: RecoverREquipAtiv,
    private val recoverROSAtiv: RecoverROSAtiv,
    private val updateAtividade: UpdateAtividade,
    private val updateRFuncaoAtivParada: UpdateRFuncaoAtivParada
): RecoverAtividade {

    override suspend fun invoke(count: Int, size: Int): Flow<ResultUpdateDataBase> {
        return flow {
            val size = size
            var count = count
            var nroEquip = equipRepository.getEquipId(boletimMMFertRepository.getIdEquip()).nroEquip
            var nroOS = boletimMMFertRepository.getOS()
            recoverREquipAtiv(nroEquip.toString(), count, size).collect{
                emit(it)
                count = it.count;
            }
            recoverROSAtiv(nroOS.toString(), count, size).collect{
                emit(it)
                count = it.count;
            }
            updateAtividade(count, size).collect{
                emit(it)
                count = it.count;
            }
            updateRFuncaoAtivParada(count, size).collect{
                emit(it)
                count = it.count;
            }
            emit(ResultUpdateDataBase(count = size, describe = "Atualização realizada com Sucesso!", size = size))
        }
    }

}