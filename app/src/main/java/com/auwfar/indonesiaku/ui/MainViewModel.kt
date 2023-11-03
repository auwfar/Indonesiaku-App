package com.auwfar.indonesiaku.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auwfar.indonesiaku.domain.repositories.AreaRepository
import com.auwfar.indonesiaku.network.model.ProvinceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val areaRepository: AreaRepository
) : ViewModel() {

    private val _provinces = MutableLiveData<List<ProvinceModel>?>()
    val provinces: LiveData<List<ProvinceModel>?> = _provinces

    fun getProvinces() {
        viewModelScope.launch {
            _provinces.value = areaRepository.getProvinces()
        }
    }

}