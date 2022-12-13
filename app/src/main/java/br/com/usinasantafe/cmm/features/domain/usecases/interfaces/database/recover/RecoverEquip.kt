package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.database.recover

import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import kotlinx.coroutines.flow.Flow

interface RecoverEquip {

    suspend operator fun invoke(nroEquip: String, count: Int = 0, size: Int = 10): Flow<ResultUpdateDataBase>

}