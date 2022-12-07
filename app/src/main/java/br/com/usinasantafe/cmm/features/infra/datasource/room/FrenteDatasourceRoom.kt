package br.com.usinasantafe.cmm.features.infra.datasource.room

import br.com.usinasantafe.cmm.features.infra.models.FrenteModel

interface FrenteDatasourceRoom {

    suspend fun addAllFrente(vararg frenteModels: FrenteModel)

    suspend fun deleteAllFrente()

}