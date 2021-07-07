package com.task.nutrition.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.nutrition.api.body.NutritionRequest
import com.task.nutrition.models.NutritionResponse
import com.task.nutrition.repository.NutritionRepository
import com.task.nutrition.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.internal.indexOf
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


@HiltViewModel
class MainViewModel @Inject constructor(
    val nutritionRepository: NutritionRepository
) : ViewModel() {

    var parts: List<String>? = null
    var nutritionResponse: NutritionResponse? = null
    val nutritionLiveData: MutableLiveData<Resource<NutritionResponse>> = MutableLiveData()
    var editTextContentLiveData = MutableLiveData<String>()

    fun onAnalyzeClicked() = viewModelScope.launch {
        nutritionLiveData.postValue(Resource.Loading())
           var  nutritionBody = NutritionRequest("","","http://www.edamam.com/ontologies/edamam.owl#Measure_serving", parts!!,"","",
           "","","","http://www.edamam.com/ontologies/edamam.owl#Measure_serving","")
      val response = nutritionRepository.getNutritionDetails(nutritionBody)
            nutritionLiveData.postValue(handleNutritionData(response))
    }

    private fun handleNutritionData(response: Response<NutritionResponse>): Resource<NutritionResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(nutritionResponse ?: resultResponse)
            }
        }

        return Resource.Error(response.message())
    }

    var ingredientTextWatcher: TextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val string = s.toString()
            parts = string.split('\n')
        }

        override fun afterTextChanged(s: Editable?) {
            Log.d("TextWatcher", s.toString())
        }

    }

}