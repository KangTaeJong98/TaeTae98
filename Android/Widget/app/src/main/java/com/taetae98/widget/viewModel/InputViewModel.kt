package com.taetae98.widget.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    stateHandle: SavedStateHandle
) : ViewModel() {
    val input by lazy { stateHandle.getLiveData("INPUT_VIEW_MODEL_INPUT", "") }

    var onAction: ((input: String) -> Unit)? = null
}