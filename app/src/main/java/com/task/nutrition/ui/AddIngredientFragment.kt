package com.task.nutrition.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.task.nutrition.R
import com.task.nutrition.databinding.FragmentAddIngredientBinding
import com.task.nutrition.utils.Resource
import com.task.nutrition.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_ingredient.*


@AndroidEntryPoint
class AddIngredientFragment: Fragment(){

    private val mainViewModel: MainViewModel by activityViewModels()
    val TAG = "AddIngredientFragment"
    lateinit var binding: FragmentAddIngredientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_ingredient, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel


        mainViewModel.nutritionLiveData.observe(viewLifecycleOwner, {response ->
            when(response){
                is Resource.Success -> {
                    // Hide progress bar
                    response.data?.let {nutritionResponse ->
                        val action = AddIngredientFragmentDirections.actionAddIngredientFragmentToNutritionDetailsFragment()
                        findNavController().navigate(action)
                    }
                }

                is Resource.Error -> {
//                    Hide Progress Bar
                    response.message?.let {message ->
                        Log.e(TAG, "An error occured ${message}")
                        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()

                    }
                }

                is Resource.Loading -> {
//                    Show Progress Bar
                }

            }
        })

    }


}