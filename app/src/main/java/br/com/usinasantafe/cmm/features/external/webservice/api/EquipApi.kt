package br.com.usinasantafe.cmm.features.external.webservice.api

import br.com.usinasantafe.cmm.features.infra.models.EquipModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface EquipApi {

    @FormUrlEncoded
    @POST("find-equip.php")
    suspend fun get(@Field("nroEquip") nroEquip: String): Response<List<EquipModel>>

}