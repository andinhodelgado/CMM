package br.com.usinasantafe.cmm.features.external.room.datasource.stable

import br.com.usinasantafe.cmm.features.infra.models.stable.PressaoBocalModel
import br.com.usinasantafe.cmm.features.external.room.dao.stable.PressaoBocalDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.stable.PressaoBocalDatasourceRoom
import javax.inject.Inject

class PressaoBocalDatasourceRoomImpl @Inject constructor (
    private val pressaoBocalDao: PressaoBocalDao
): PressaoBocalDatasourceRoom {

    override suspend fun addAllPressaoBocal(vararg pressaoBocalModels: PressaoBocalModel) {
        pressaoBocalDao.insertAll(*pressaoBocalModels)
    }

    override suspend fun deleteAllPressaoBocal() {
        pressaoBocalDao.deleteAll()
    }

}