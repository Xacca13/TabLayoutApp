package com.example.tablayout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManViewModel: ViewModel() {
    val plant = MutableLiveData<PlantModel>()
}