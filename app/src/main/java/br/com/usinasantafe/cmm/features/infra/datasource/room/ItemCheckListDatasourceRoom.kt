package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.ItemCheckListModel

interface ItemCheckListDatasourceRoom {

    suspend fun addAllItemCheckList(vararg itemCheckListModels: ItemCheckListModel)

    suspend fun deleteAllItemCheckList()

}