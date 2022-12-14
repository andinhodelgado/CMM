package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_ATIVIDADE
import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_ATIVIDADE)
data class AtividadeModel (
    @PrimaryKey val idAtiv: Long,
    val codAtiv: Long,
    val descrAtiv: String
)

fun AtividadeModel.toAtividade(): Atividade {
    return with(this){
        Atividade(
            idAtiv = this.idAtiv,
            codAtiv = this.codAtiv,
            descrAtiv = this.descrAtiv
        )
    }
}

fun Atividade.toAtividadeModel(): AtividadeModel{
    return with(this){
        AtividadeModel(
            idAtiv = this.idAtiv,
            codAtiv = this.codAtiv,
            descrAtiv = this.descrAtiv
        )
    }
}