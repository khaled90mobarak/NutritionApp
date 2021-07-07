package com.task.nutrition.models

import java.io.Serializable

data class NutritionResponse(
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String,
    val yield: Int
): Serializable