package com.task.nutrition.repository

import com.task.nutrition.api.RetrofitInstance
import com.task.nutrition.api.body.NutritionRequest
import com.task.nutrition.utils.Constants.Companion.APP_ID
import com.task.nutrition.utils.Constants.Companion.APP_KEY
import javax.inject.Inject

class NutritionRepository @Inject constructor() {


    suspend fun getNutritionDetails(nutritionRequest: NutritionRequest) =
        RetrofitInstance.api.getNutritionDetails(APP_ID, APP_KEY, nutritionRequest)
}