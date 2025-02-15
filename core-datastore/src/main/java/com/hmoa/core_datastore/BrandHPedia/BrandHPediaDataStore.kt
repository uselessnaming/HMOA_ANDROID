package com.hmoa.core_datastore.BrandHPedia

import com.hmoa.core_model.response.DataResponseDto

interface BrandHPediaDataStore {
    suspend fun getBrandStoryAll(pageNum: Int): DataResponseDto<Any>
    suspend fun getBrandStory(brandStoryId: Int): DataResponseDto<Any>
    suspend fun deleteBrandStory(brandStoryId: Int): DataResponseDto<Any>
    suspend fun updateBrandStory(brandStoryId: Int, content: String): DataResponseDto<Any>
}