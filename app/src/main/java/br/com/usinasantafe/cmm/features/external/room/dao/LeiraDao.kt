package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.LeiraModel

@Dao
interface LeiraDao {

    @Insert
    suspend fun insertAll(vararg leiraModels: LeiraModel)

    @Query("DELETE FROM tbleiraest")
    suspend fun deleteAll()

}