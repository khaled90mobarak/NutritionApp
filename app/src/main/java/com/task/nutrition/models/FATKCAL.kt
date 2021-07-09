package com.task.nutrition.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class FATKCAL(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable