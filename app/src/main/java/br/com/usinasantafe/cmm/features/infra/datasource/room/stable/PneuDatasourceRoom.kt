package br.com.usinasantafe.cmm.features.infra.datasource.room.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.PneuModel

interface PneuDatasourceRoom {

    suspend fun addAllPneu(vararg pneuModels: PneuModel)

    suspend fun deleteAllPneu()

}