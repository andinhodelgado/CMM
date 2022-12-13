package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.stable.ParadaModel

interface ParadaDatasourceRoom {

    suspend fun addAllParada(vararg paradaModels: ParadaModel)

    suspend fun deleteAllParada()

}