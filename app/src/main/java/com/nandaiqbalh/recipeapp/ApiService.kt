package com.nandaiqbalh.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Make sure the base URL ends with a trailing slash
private val retrofit = Retrofit.Builder()
	.baseUrl("https://www.themealdb.com/api/json/v1/1/")
	.addConverterFactory(GsonConverterFactory.create())
	.build()

val recipeService: ApiService = retrofit.create(ApiService::class.java)

interface ApiService {
	@GET("categories.php") // Remove the leading slash
	suspend fun getCategories(): CategoryResponse
}
