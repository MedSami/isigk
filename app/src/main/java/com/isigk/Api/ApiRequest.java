package com.isigk.Api;

import com.isigk.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("cin") String cin
    );
    /******************** Reponse Encadrement *******************/
    @GET("SelectDemande.php")
    Call<ResponseDataModel> ReponseEncadrement(@Query("idEtudiant") String idEtudiant
    );
    /******************** Reponse Encadrement *******************/
    @GET("SelectSoutenance.php")
    Call<ResponseDataModel> Soutenance(@Query("idEtudiant") String idEtudiant
    );

    /******************** Encadreurs *******************/
    @GET("selectEncadreurs.php")
    Call<ResponseDataModel> Encadreurs();
/************************* Demande Encadrement*************************/
@FormUrlEncoded
@POST("DemandeEncadrement.php")
    Call<ResponseDataModel> DemandeEncadrement(@Field("id_encadreur") String idEncadreur,
                                               @Field("id_etudiant") String id_etudiant);

@FormUrlEncoded
@POST("FicheEncadrement.php")
    Call<ResponseDataModel> FicheEncadrement(
            @Field("id_encadreur") int idEncadreur,
            @Field("nomEntreprise") String nomEntreprise,
            @Field("nomProjet") String nomProjet,
            @Field("id_etudiant") String id_etudiant);


}
