package com.rami.taxi.ui.main_screen

import androidx.lifecycle.viewModelScope
import com.rami.domain.usecase.GetListCar
import com.rami.taxi.base.BaseViewModel
import com.rami.taxi.models.CarForListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(private val getListCar: GetListCar) :
    BaseViewModel<CarListState>(CarListState()) {
    fun getListCar(page: Int) {
        isNotLoaded()
        viewModelScope.launch {
            updateState {
                it.copy(
                    listCars = getListCar.getListOfCar(page).map { item ->
                        CarForListModel(
                            id = item.id,
                            name = item.name,
                            urlPhoto = item.urlPhoto,
                        )
                    },
                    page = page,
                    isLoaded = true,
                )
            }
        }
    }

    private fun isNotLoaded() {
        updateState {
            it.copy(
                isLoaded = false,
            )
        }
    }
}
