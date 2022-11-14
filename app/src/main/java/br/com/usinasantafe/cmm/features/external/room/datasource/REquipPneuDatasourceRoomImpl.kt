package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.REquipPneuModel
import br.com.usinasantafe.cmm.features.external.room.dao.REquipPneuDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.REquipPneuDatasourceRoom
import javax.inject.Inject

class REquipPneuDatasourceRoomImpl @Inject constructor (
    private val rEquipPneuDao: REquipPneuDao
): REquipPneuDatasourceRoom {

    override suspend fun addREquipPneu(rEquipPneuModel: REquipPneuModel): Long {
        return rEquipPneuDao.insert(rEquipPneuModel)
    }

    override suspend fun deleteAllREquipPneu() {
       rEquipPneuDao.deleteAll()
    }
}