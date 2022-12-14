package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.REquipAtivModel

interface REquipAtivDatasourceRoom {

    suspend fun addAllREquipAtiv(vararg rEquipAtivModels: REquipAtivModel)

    suspend fun deleteAllREquipAtiv()

    suspend fun listREquipAtiv(idEquip: Long): List<REquipAtivModel>

}