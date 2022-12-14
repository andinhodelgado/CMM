package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PRODUTO
import br.com.usinasantafe.cmm.features.domain.entities.stable.Produto
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PRODUTO)
data class ProdutoModel(
    @PrimaryKey val idProduto: Long,
    val codProduto: String,
    val descrProduto: String
)

fun Produto.toProdutoModel(): ProdutoModel{
    return with(this){
        ProdutoModel(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}

fun ProdutoModel.toProduto(): Produto {
    return with(this){
        Produto(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}