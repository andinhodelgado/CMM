package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ParadaApi
import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ParadaDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ParadaDatasourceWebServiceImpl @Inject constructor(
    private val paradaApi: ParadaApi
): ParadaDatasourceWebService {

    override suspend fun getAllParada(): Flow<Result<List<ParadaModel>>> {
        return flow{
            val response = paradaApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}