package com.task.nutrition.api
import com.task.nutrition.api.body.NutritionRequest
import com.task.nutrition.models.NutritionResponse
import com.task.nutrition.utils.Constants.Companion.APP_ID
import com.task.nutrition.utils.Constants.Companion.APP_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NutritionApi {

    @GET("/api/nutrition-data")
    suspend fun getNutritionData(
        @Query("app_id")
        appId: String = APP_ID,
        @Query("app_key")
        appKey: String = APP_KEY,
        @Query("ingr")
        apikey: String
    ): Response<NutritionResponse>

    @POST("/api/nutrition-details")
    suspend fun getNutritionDetails(
        @Query("app_id")
        appId: String = APP_ID,
        @Query("app_key")
        appKey: String = APP_KEY,
        @Body()
        nutritionRequest: NutritionRequest
    ): Response<NutritionResponse>

}