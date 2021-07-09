package com.task.nutrition.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


data class TotalNutrients(
    val CA: CAX,
    val CHOCDF: CHOCDFX,
    val CHOLE: CHOLEX,
    val ENERC_KCAL: ENERCKCALX,
    val FAMS: FAMS,
    val FAPU: FAPU,
    val FASAT: FASATX,
    val FAT: FATX,
    val FE: FEX,
    val FIBTG: FIBTGX,
    val FOLAC: FOLAC,
    val FOLDFE: FOLDFEX,
    val FOLFD: FOLFD,
    val K: KX,
    val MG: MGX,
    val NA: NAX,
    val NIA: NIAX,
    val P: PX,
    val PROCNT: PROCNTX,
    val RIBF: RIBFX,
    val SUGAR: SUGAR,
    val THIA: THIAX,
    val TOCPHA: TOCPHAX,
    val VITA_RAE: VITARAEX,
    val VITB12: VITB12X,
    val VITB6A: VITB6AX,
    val VITC: VITCX,
    val VITD: VITDX,
    val VITK1: VITK1X,
    val WATER: WATER,
    val ZN: ZNX
): Serializable