package fr.epita.android.hellogames

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WSInterface {
    @GET("/game/list")
    fun listToDos(): Call<List<ToDoObject>> {

        val data = arrayListOf<ToDoObject>()
        val baseURL = "https://androidlessonsapi.herokuapp.com/api/"
        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(jsonConverter)
            .build()
        val service: WSInterface = retrofit.create(WSInterface::class.java)


        val wsCallback: Callback<List<ToDoObject>> = object : Callback<List<ToDoObject>> {
            override fun onFailure(call: Call<List<ToDoObject>>, t: Throwable) {
                Log.w("TAG", "WebService call failed")
            }
            override fun onResponse(call: Call<List<ToDoObject>>, response: Response<List<ToDoObject>>) {
                if (response.code() == 200) {
                    val responseData = response.body()
                    if (responseData != null) {
                        Log.d("TAG", "WebService success : " + responseData.size)}}
            }
        }
        service.listToDos().enqueue(wsCallback)
    }

}

