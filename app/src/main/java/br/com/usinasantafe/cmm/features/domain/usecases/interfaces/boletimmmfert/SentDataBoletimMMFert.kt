package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.boletimmmfert

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

interface SentDataBoletimMMFert {

    suspend operator fun invoke(boletimMMList: List<BoletimMM>)

}