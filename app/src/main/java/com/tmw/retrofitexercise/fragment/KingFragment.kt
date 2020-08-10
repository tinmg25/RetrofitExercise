package com.tmw.retrofitexercise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.retrofitexercise.R
import com.tmw.retrofitexercise.adapter.KingAdapter
import com.tmw.retrofitexercise.api.ApiKingClient
import com.tmw.retrofitexercise.model.KingItem
import kotlinx.android.synthetic.main.fragment_king.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_king, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPostKing()
    }

    fun getPostKing() {
        var apikingClient = ApiKingClient()
        var apikingCall = apikingClient.kingApiService.getPost1()

        apikingCall.enqueue(object : Callback<ArrayList<KingItem>>{
            override fun onFailure(call: Call<ArrayList<KingItem>>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(
                call: Call<ArrayList<KingItem>>,
                response: Response<ArrayList<KingItem>>
            ) {
                recyclerview_king.apply{
                    layoutManager=LinearLayoutManager(context)
                    adapter=KingAdapter(response.body()!!)
                }

                Toast.makeText(
                    context,
                    response.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
    })
}
}