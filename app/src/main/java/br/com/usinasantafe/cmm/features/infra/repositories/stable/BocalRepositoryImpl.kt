package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.Bocal
import br.com.usinasantafe.cmm.features.infra.models.toBocal
import br.com.usinasantafe.cmm.features.infra.models.toBocalModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.BocalRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.BocalDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.BocalDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toAtividadeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BocalRepositoryImpl @Inject constructor(
    private val bocalDatasourceRoom: BocalDatasourceRoom,
    private val bocalDatasourceWebService: BocalDatasourceWebService
): BocalRepository {

    override suspend fun addAllBocal(bocalList: List<Bocal>) {
        bocalDatasourceRoom.addAllBocal(*bocalList.map { it.toBocalModel() }.toTypedArray())
    }

    override suspend fun deleteAllBocal() {
        bocalDatasourceRoom.deleteAllBocal()
    }

    override suspend fun recoverAllBocal(): Flow<Result<List<Bocal>>> {
        return flow {
            bocalDatasourceWebService.getAllBocal()
                .collect { result ->
                    result.onSuccess { bocalModelList ->
                        emit(Result.success(bocalModelList.map { it.toBocal() }))
                    }
                }
        }
    }

}