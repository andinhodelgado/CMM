package br.com.usinasantafe.cmm.features.external.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.infra.models.PressaoBocalModel

@Dao
interface PressaoBocalDao {

    @Insert
    suspend fun insert(pressaoBocalModel: PressaoBocalModel): Long

    @Query("DELETE FROM tbpressaobocalest")
    suspend fun deleteAll()

}