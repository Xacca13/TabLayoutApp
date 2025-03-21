package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayout.databinding.MainFragmentBinding


class MainFragment : Fragment() {
lateinit var binding: MainFragmentBinding
    private val model: ManViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            model.plant.value = PlantModel(R.drawable.img, "ffffffffffff", "333333333333333")
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.mainAct, ContentFragment.newInstance()).commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}