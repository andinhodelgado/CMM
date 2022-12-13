package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.TB_BOLETIM_FERT
import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimFert
import java.util.*

@Entity(tableName = TB_BOLETIM_FERT)
data class BoletimFertModel (
    @PrimaryKey(autoGenerate = true)
    val idBolFert: Long? = null,
    val matricFuncBolFert: Long,
    val idEquipBolFert: Long,
    val idEquipBombaBolMMFert: Long,
    val idTurnoBolFert: Long,
    val hodometroInicialBolFert: Double,
    val hodometroFinalBolFert: Double? = null,
    val osBolFert: Long,
    val ativPrincBolFert: Long,
    val dthrInicialBolFert: Long,
    val dthrFinalBolFert: Long? = null,
    val statusBolFert: Long,
    val statusConBolFert: Long,
    val longitudeBolFert: Double,
    val latitudeBolFert: Double
)

fun BoletimFert.toBoletimFertModel(): BoletimFertModel{
    return with(this){
        BoletimFertModel(
            matricFuncBolFert = this.matricFuncBol!!,
            idEquipBolFert = this.idEquipBol!!,
            idEquipBombaBolMMFert = this.idEquipBombaBol!!,
            idTurnoBolFert = this.idTurnoBol!!,
            hodometroInicialBolFert = this.hodometroInicialBol!!,
            osBolFert = this.osBol!!,
            ativPrincBolFert = this.ativPrincBol!!,
            dthrInicialBolFert = Date().time,
            statusBolFert = StatusData.ABERTO.ordinal.toLong(),
            statusConBolFert = StatusConnection.ONLINE.ordinal.toLong(),
            longitudeBolFert = 0.0,
            latitudeBolFert = 0.0
        )
    }
}