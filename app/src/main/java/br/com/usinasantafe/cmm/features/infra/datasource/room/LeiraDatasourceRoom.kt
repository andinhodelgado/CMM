package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.LeiraModel

interface LeiraDatasourceRoom {

    suspend fun addAllLeira(vararg leiraModels: LeiraModel)

    suspend fun deleteAllLeira()

}