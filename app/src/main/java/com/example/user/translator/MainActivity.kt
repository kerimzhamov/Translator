package com.example.user.translator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.user.translator.StartApplication.Companion.INSTANCE
import com.example.user.translator.model.Translate
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val key: String = "trnsl.1.1.20180920T113351Z.379c01d44c0fbf54.f9e931c945fe8708fb19f4e5f282e58f212c93eb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val word: String = input.text.toString()

            //if (word.isEmpty())
                getTranslation(word)
        }


    }

    private fun getTranslation(words: String) {

        StartApplication.INSTANCE?.forum?.getData(key, words, "en-ru")?.enqueue(object : Callback<Translate> {
            override fun onFailure(call: Call<Translate>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Translate>?, response: Response<Translate>?) {
                if (response?.isSuccessful!!) {
                    Log.e("________", response.body()?.text!![0])

                }
            }

        })
    }
}
