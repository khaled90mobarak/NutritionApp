package com.task.nutrition.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.task.nutrition.R
import com.task.nutrition.databinding.FragmentAddIngredientBinding
import com.task.nutrition.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddIngredientFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentAddIngredientBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_ingredient, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel




        mainViewModel.nutritionLiveData.observe(viewLifecycleOwner, { response ->


//            when(response){
//                is Resource.Success<*> -> {
//                    response.getContentIfNotHandled()?.data.let {
//                        val action =
//                            AddIngredientFragmentDirections.actionAddIngredientFragmentToNutritionDetailsFragment()
//                        findNavController().navigate(action)
//                    }
//                }
//                is Resource.Error<*> ->{
//                    Toast.makeText(requireContext(), resources.getText(R.string.error_message), Toast.LENGTH_LONG).show()
//                }

            if (response?.getContentIfNotHandled()?.data != null)
                response.getContentIfNotHandled()?.data.let {
                    val action =
                        AddIngredientFragmentDirections.actionAddIngredientFragmentToNutritionDetailsFragment()
                    findNavController().navigate(action)
                }
            else {
                response.getContentIfNotHandled()?.message.let {
                    Toast.makeText(
                        requireContext(),
                        resources.getText(R.string.error_message),
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        })


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mainViewModel.saveState()

    }


}