package com.task.nutrition.models

import java.io.Serializable

data class FAT(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable