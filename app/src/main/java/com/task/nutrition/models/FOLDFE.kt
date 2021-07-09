package com.task.nutrition.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class FOLDFE(
    val label: String,
    val quantity: Double,
    val unit: String
): Serializable