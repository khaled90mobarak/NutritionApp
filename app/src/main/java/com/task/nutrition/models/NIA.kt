package com.task.nutrition.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class NIA(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable