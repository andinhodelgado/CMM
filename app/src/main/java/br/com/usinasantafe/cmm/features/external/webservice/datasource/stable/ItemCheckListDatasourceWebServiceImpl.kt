package br.com.usinasantafe.cmm.features.external.webservice.datasource.stable

import br.com.usinasantafe.cmm.features.external.webservice.api.stable.ItemCheckListApi
import br.com.usinasantafe.cmm.features.infra.models.stable.ItemCheckListModel
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.stable.ItemCheckListDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ItemCheckListDatasourceWebServiceImpl @Inject constructor(
    private val itemCheckListApi: ItemCheckListApi
): ItemCheckListDatasourceWebService {

    override suspend fun getAllItemCheckList(): Flow<Result<List<ItemCheckListModel>>> {
        return flow{
            val response = itemCheckListApi.all()
            if (response.isSuccessful) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(Throwable("Erro recebimento de dados")))
            }
        }
    }

}