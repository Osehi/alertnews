package com.polish.alertnews.feature.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polish.alertnews.common.utils.resource.Resource
import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import com.polish.alertnews.feature.domain.usecase.BreakingNewsListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewViewModel @Inject constructor(
    private val breakingNewsListUsecase: BreakingNewsListUsecase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val TAG = "BREAKINGNEWSVIEWMODEL"
    private var breakingNewsPage = 1

    private val _breakingNewsResponse = MutableSharedFlow<Resource<NewsResponse>>()
    val breakingNewsResponse: SharedFlow<Resource<NewsResponse>> get() = _breakingNewsResponse.asSharedFlow()

    fun getBreakingNews(countryCode: String) {
        viewModelScope.launch {
            breakingNewsListUsecase(countryCode, breakingNewsPage).collect {
                _breakingNewsResponse.emit(it)
                Log.d(TAG, "output: ${it}" )
            }
        }
    }
}
