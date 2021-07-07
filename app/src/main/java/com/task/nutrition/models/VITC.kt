package com.task.nutrition.models

import java.io.Serializable

data class VITC(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable