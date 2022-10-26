package com.polish.alertnews.feature.domain.usecase

import com.polish.alertnews.common.utils.resource.Resource
import com.polish.alertnews.feature.data.network.model.newsarticle.NewsResponse
import com.polish.alertnews.feature.domain.repository.BreakingNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BreakingNewsListUsecase @Inject constructor(
    private val breakingNewsRepository: BreakingNewsRepository
) {

    operator fun invoke(countryCode: String, pageNumber: Int): Flow<Resource<NewsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = breakingNewsRepository.getAllBreakingNews(countryCode, pageNumber)
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}
