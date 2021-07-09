package com.task.nutrition.api.body

import java.io.Serializable

data class NutritionRequest(
    val cuisine: String,
    val dishtype: String,
    val img: String,
    val ingr: List<String>,
    val mealtype: String,
    val prep: String,
    val summary: String,
    val time: String,
    val title: String,
    val url: String,
    val yield: String
): Serializable