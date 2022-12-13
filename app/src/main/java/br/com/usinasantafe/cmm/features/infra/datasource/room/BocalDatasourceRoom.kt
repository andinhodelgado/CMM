package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.stable.BocalModel

interface BocalDatasourceRoom {

    suspend fun addAllBocal(vararg bocalModels: BocalModel)

    suspend fun deleteAllBocal()

}