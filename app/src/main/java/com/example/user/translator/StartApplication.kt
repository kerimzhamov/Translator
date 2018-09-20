package com.example.user.translator

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kerimzhanov_a on 9/20/2018.
 */
class StartApplication : Application(){
    var forum: ForumService? = null
    private var retrofit: Retrofit? = null
    private val baseUrl: String = "https://translate.yandex.net/api/v1.5/tr.json/"

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build()

        INSTANCE = this
        forum = retrofit!!.create(ForumService::class.java) //Создаем объект, при помощи которого будем выполнять запросы
    }

    companion object {
        @Volatile var INSTANCE: StartApplication? = null
    }

}