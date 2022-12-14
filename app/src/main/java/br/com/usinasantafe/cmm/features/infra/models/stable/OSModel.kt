package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_OS
import br.com.usinasantafe.cmm.features.domain.entities.stable.OS
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_OS)
data class OSModel(
    @PrimaryKey val idOS: Long,
    val nroOS: Long,
    val idLibOS: Long?,
    val idProprAgr: Long?,
    val areaProgrOS: Double?,
    val tipoOS: Long?,
    val idEquip: Long?
)

fun OS.toOSModel(): OSModel{
    return with(this){
        OSModel(
            idOS = this.idOS,
            nroOS = this.nroOS,
            idLibOS = this.idLibOS,
            idProprAgr = this.idProprAgr,
            areaProgrOS = this.areaProgrOS,
            tipoOS = this.tipoOS
            ,
            idEquip = this.idEquip
        )
    }
}

fun OSModel.toOS(): OS {
    return with(this){
        OS(
            idOS = this.idOS,
            nroOS = this.nroOS,
            idLibOS = this.idLibOS,
            idProprAgr = this.idProprAgr,
            areaProgrOS = this.areaProgrOS,
            tipoOS = this.tipoOS
            ,
            idEquip = this.idEquip
        )
    }
}
