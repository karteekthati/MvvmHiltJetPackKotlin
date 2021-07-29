package com.kk.hiltsample.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.hiltsample.Utils.ApiState
import com.kk.hiltsample.Utils.Helper
import com.kk.hiltsample.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject
constructor(
    @ApplicationContext private val context: Context,
    private val mainRepository: MainRepository,
    private val helper: Helper,
    ): ViewModel() {
    private val postStateFlow: MutableStateFlow<ApiState> =   MutableStateFlow(ApiState.Empty)
    val _postStateFlow: StateFlow<ApiState> = postStateFlow

    //data for recyclerview
    fun getViewModelPost() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        mainRepository.getRepoPost().catch {
                e-> postStateFlow.value = ApiState.Failure(e)
        }.collect {
                data-> postStateFlow.value = ApiState.Success(data)
        }
    }
}

