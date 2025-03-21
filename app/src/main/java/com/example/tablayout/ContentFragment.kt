package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayout.databinding.ContentFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator


class ContentFragment : Fragment() {
    lateinit var binding:ContentFragmentBinding
    private val model: ManViewModel by activityViewModels()
    private val fragList = listOf(
        InfoFragment.newInstance(),
        UseCaseFragment.newInstance()
    )
    private val fragListTitle = listOf(
        "Описание",
        "Применение"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContentFragmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner){
            binding.imageView.setImageResource(it.imageId)
        }
        val adapter = VpDapter(activity as AppCompatActivity, fragList)
        binding.placeHolderContent.adapter = adapter
        TabLayoutMediator(binding.tabL, binding.placeHolderContent){
                tab, pos -> tab.text = fragListTitle[pos]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}