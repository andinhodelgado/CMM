package br.com.usinasantafe.cmm.features.core.infra.datasource.web

import br.com.usinasantafe.cmm.features.core.infra.models.FuncModel

interface FuncDatasourceWeb {

    suspend fun getAllFunc(): List<FuncModel>

}