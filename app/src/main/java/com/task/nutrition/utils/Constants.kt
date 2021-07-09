package com.task.nutrition.utils

class Constants {
    companion object{
        const val BASE_URL= "https://api.edamam.com"
        const val APP_ID = "43012ff0"
        const val APP_KEY = "53aa16a2bd660d3a5090246eba6e7d32"
        /* I got this url from parser API, I found it required to perform a request to our
        nutrition-details API
        It was mentioned in the API documentation
         */
        const val URL_FROM_PARSER = "http://www.edamam.com/ontologies/edamam.owl#Measure_serving"
    }
}