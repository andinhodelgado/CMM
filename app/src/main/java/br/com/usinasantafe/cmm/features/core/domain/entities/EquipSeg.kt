package br.com.usinasantafe.cmm.features.core.domain.entities

data class EquipSeg(
    val idEquip: Long,
    val nroEquip: Long,
    val codClasseEquip: Long,
    val descrClasseEquip: String,
    val tipoEquip: Long //1 - Carretel; 2 - Transbordo; 3 - Implemento
)
