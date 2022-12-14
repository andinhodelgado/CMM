package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_BOCAL
import br.com.usinasantafe.cmm.features.domain.entities.stable.Bocal
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_BOCAL)
data class BocalModel(
    @PrimaryKey val idBocal: Long,
    val codBocal: Long,
    val descrBocal: String
)

fun Bocal.toBocalModel(): BocalModel{
    return with(this){
        BocalModel(
            idBocal = this.idBocal,
            codBocal = this.codBocal,
            descrBocal = this.descrBocal
        )
    }
}

fun BocalModel.toBocal(): Bocal {
    return with(this){
        Bocal(
            idBocal = this.idBocal,
            codBocal = this.codBocal,
            descrBocal = this.descrBocal
        )
    }
}
