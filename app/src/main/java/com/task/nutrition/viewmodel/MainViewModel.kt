package com.task.nutrition.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.nutrition.api.body.NutritionRequest
import com.task.nutrition.models.NutritionResponse
import com.task.nutrition.repository.NutritionRepository
import com.task.nutrition.utils.Constants.Companion.URL_FROM_PARSER
import com.task.nutrition.utils.Event
import com.task.nutrition.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val nutritionRepository: NutritionRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    var parts: List<String>? = null
    private var nutritionResponse: NutritionResponse? = null
    var nutritionLiveData: MutableLiveData<Event<Resource<NutritionResponse>?>> = MutableLiveData()

    val liveData = savedStateHandle.getLiveData("liveData", "")
    fun saveState() {
        if (parts != null) {
            var string = ""
            for (line in parts!!) {
                string += line + '\n'
            }
            liveData.value = parts.toString()
            savedStateHandle.set("liveData", string)
        }
    }

    fun onAnalyzeClicked() = viewModelScope.launch {
        val nutritionBody = NutritionRequest(
            "", "", URL_FROM_PARSER, parts!!, "", "",
            "", "", "", URL_FROM_PARSER, ""
        )
        val response = nutritionRepository.getNutritionDetails(nutritionBody)
//        nutritionLiveData.postValue(Event(handleNutritionData(response)))
        nutritionLiveData.value = Event(handleNutritionData(response))
    }

    private fun handleNutritionData(response: Response<NutritionResponse>): Resource<NutritionResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(nutritionResponse ?: resultResponse)
            }
        }

        return Resource.Error(response.message())
    }

    var ingredientTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val string = s.toString()
            parts = string.split('\n')
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }


}