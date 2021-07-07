package com.task.nutrition.models

import java.io.Serializable

data class TOCPHA(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable