package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.BocalModel

@Dao
interface BocalDao {

    @Insert
    suspend fun insert(bocalModel: BocalModel): Long

    @Query("DELETE FROM tbbocalest")
    suspend fun deleteAll()

}