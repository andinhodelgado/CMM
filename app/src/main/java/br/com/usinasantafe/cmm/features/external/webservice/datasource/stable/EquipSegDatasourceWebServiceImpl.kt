package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.EquipSegApi
import br.com.usinasantafe.cmm.features.infra.models.stable.EquipSegModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.EquipSegDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EquipSegDatasourceWebServiceImpl @Inject constructor(
    private val equipSegApi: EquipSegApi
): EquipSegDatasourceWebService {

    override suspend fun getAllEquipSeg(): Flow<Result<List<EquipSegModel>>> {
        return flow{
            val response = equipSegApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}