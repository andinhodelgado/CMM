package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckSendData {

    suspend operator fun invoke(): Boolean

}