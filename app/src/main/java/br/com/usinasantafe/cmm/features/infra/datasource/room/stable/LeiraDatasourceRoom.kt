package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.LeiraModel

interface LeiraDatasourceRoom {

    suspend fun addAllLeira(vararg leiraModels: LeiraModel)

    suspend fun deleteAllLeira()

}