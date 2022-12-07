package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.EquipSegModel

interface EquipSegDatasourceRoom {

    suspend fun addAllEquipSeg(vararg equipSegModels: EquipSegModel)

    suspend fun deleteAllEquipSeg()

}