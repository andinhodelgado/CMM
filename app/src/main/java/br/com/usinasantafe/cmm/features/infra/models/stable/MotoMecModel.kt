package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_MOTOMEC
import br.com.usinasantafe.cmm.features.domain.entities.stable.MotoMec
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_MOTOMEC)
data class MotoMecModel(
    @PrimaryKey val idMotoMec: Long,
    val idOperMotoMec: Long,
    val descrOperMotoMec: String,
    val codFuncaoOperMotoMec: Long,
    val posOperMotoMec: Long,
    val tipoOperMotoMec: Long,
    val aplicOperMotoMec: Long,
    val funcaoOperMotoMec: Long
)

fun MotoMec.toMotoMecModel(): MotoMecModel{
    return with(this){
        MotoMecModel(
            idMotoMec = this.idMotoMec,
            idOperMotoMec = this.idOperMotoMec,
            descrOperMotoMec = this.descrOperMotoMec,
            codFuncaoOperMotoMec = this.codFuncaoOperMotoMec,
            posOperMotoMec = this.posOperMotoMec,
            tipoOperMotoMec = this.tipoOperMotoMec,
            aplicOperMotoMec = this.aplicOperMotoMec,
            funcaoOperMotoMec = this.funcaoOperMotoMec
        )
    }
}

fun MotoMecModel.toMotoMec(): MotoMec {
    return with(this){
        MotoMec(
            idMotoMec = this.idMotoMec,
            idOperMotoMec = this.idOperMotoMec,
            descrOperMotoMec = this.descrOperMotoMec,
            codFuncaoOperMotoMec = this.codFuncaoOperMotoMec,
            posOperMotoMec = this.posOperMotoMec,
            tipoOperMotoMec = this.tipoOperMotoMec,
            aplicOperMotoMec = this.aplicOperMotoMec,
            funcaoOperMotoMec = this.funcaoOperMotoMec
        )
    }
}