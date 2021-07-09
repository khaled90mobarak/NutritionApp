package com.task.nutrition.api

import com.task.nutrition.api.body.NutritionRequest
import com.task.nutrition.models.NutritionResponse
import com.task.nutrition.utils.Constants.Companion.APP_ID
import com.task.nutrition.utils.Constants.Companion.APP_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface NutritionApi {


    @POST("/api/nutrition-details")
    suspend fun getNutritionDetails(
        @Query("app_id")
        appId: String = APP_ID,
        @Query("app_key")
        appKey: String = APP_KEY,
        @Body
        nutritionRequest: NutritionRequest
    ): Response<NutritionResponse>

}