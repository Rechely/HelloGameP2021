package fr.epita.android.hellogames

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageInit("a", "a", "a", "a")
    }

    fun imageInit(tl: String, tr: String, bl: String, br: String) {
        Glide.with(this).load(tl).into(TLimage)
        Glide.with(this).load(tr).into(TRimage)
        Glide.with(this).load(bl).into(BLimage)
        Glide.with(this).load(br).into(BRimage)
    }

}
