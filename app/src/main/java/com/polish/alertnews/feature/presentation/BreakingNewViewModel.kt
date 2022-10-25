package com.polish.alertnews.feature.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polish.alertnews.common.utils.resource.Resource
import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import com.polish.alertnews.feature.domain.usecase.BreakingNewsListUsecase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BreakingNewViewModel @Inject constructor(
    private val breakingNewsListUsecase: BreakingNewsListUsecase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _breakingNewsResponse = MutableSharedFlow<Resource<NewsResponse>>()
    val breakingNewsResponse: SharedFlow<Resource<NewsResponse>> get() = _breakingNewsResponse.asSharedFlow()

    fun getBreakingNews(countryCode: String, pageNumber: Int) {
        viewModelScope.launch {
            breakingNewsListUsecase(countryCode, pageNumber).collect {
                _breakingNewsResponse.emit(it)
            }
        }
    }
}
