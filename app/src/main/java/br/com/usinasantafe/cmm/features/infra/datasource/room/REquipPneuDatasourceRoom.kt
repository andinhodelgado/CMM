package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipPneuModel

interface REquipPneuDatasourceRoom {

    suspend fun addAllREquipPneu(vararg rEquipPneuModels: REquipPneuModel)

    suspend fun deleteAllREquipPneu()

}