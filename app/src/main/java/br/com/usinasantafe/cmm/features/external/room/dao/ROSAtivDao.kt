package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.ROSAtivModel

@Dao
interface ROSAtivDao {

    @Insert
    suspend fun insert(rOSAtivModel: ROSAtivModel): Long

    @Query("DELETE FROM tbrosativest")
    suspend fun deleteAll()

}