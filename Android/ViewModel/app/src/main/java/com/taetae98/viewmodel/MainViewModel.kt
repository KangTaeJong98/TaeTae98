package com.taetae98.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner

class MainViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle // 생성자로 쉽게 받을 수 있습니다.
) : AndroidViewModel(application) {
//    val text by lazy { MutableLiveData("") } Normal Variable
    val text by lazy { savedStateHandle.getLiveData("TEXT", "") } // SavedStateHandle Variable

    fun functionWithContext() {
        val application = getApplication<Application>()

        // Do Something With Context
    }

//    // No SavedStateHandle ViewModel Factory
//    class Factory(
//        // Parameter Something
//    ) : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return MainViewModel()
//        }
//    }

    class Factory(
        // Parameter Something
        private val application: Application,
        owner: SavedStateRegistryOwner
    ) : AbstractSavedStateViewModelFactory(owner, null) {
        override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
            return MainViewModel(application, handle) as T
        }
    }
}