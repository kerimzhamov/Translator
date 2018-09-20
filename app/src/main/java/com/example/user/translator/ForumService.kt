package com.example.user.translator

import com.example.user.translator.model.Translate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kerimzhanov_a on 9/20/2018.
 */
interface ForumService {
    @GET("translate?")
    fun getData(@Query("key") key: String, @Query("text") text: String, @Query("lang") lang: String): Call<Translate>
}