package br.com.usinasantafe.cmm.features.external.room.datasource

import br.com.usinasantafe.cmm.features.infra.models.TurnoModel
import br.com.usinasantafe.cmm.features.external.room.dao.TurnoDao
import br.com.usinasantafe.cmm.features.infra.datasource.room.TurnoDatasourceRoom
import javax.inject.Inject

class TurnoDatasourceRoomImpl @Inject constructor (
    private val turnoDao: TurnoDao
): TurnoDatasourceRoom {

    override suspend fun addTurno(turnoModel: TurnoModel): Long {
        return turnoDao.insert(turnoModel)
    }

    override suspend fun deleteAllTurno() {
        turnoDao.deleteAll()
    }

    override suspend fun hasTurno(): Boolean {
        return (turnoDao.count() > 0)
    }

}