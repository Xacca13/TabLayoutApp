package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.tablayout.databinding.UseCaseFragmentBinding


class UseCaseFragment : Fragment() {
    lateinit var binding: UseCaseFragmentBinding
    private val model: ManViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = UseCaseFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding.tVuseCase.text = it.useCase
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = UseCaseFragment()
    }
}