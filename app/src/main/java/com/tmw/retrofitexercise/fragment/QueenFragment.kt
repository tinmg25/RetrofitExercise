package com.tmw.retrofitexercise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.retrofitexercise.R
import com.tmw.retrofitexercise.adapter.QueenAdapter
import com.tmw.retrofitexercise.api.ApiQueenClient
import com.tmw.retrofitexercise.model.QueenItem
import kotlinx.android.synthetic.main.fragment_queen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_queen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPostQueen()
    }

    fun getPostQueen(){
        var apiqueenClient= ApiQueenClient()
        var apiqueenCall=apiqueenClient.queenApiService.getPost2()

        apiqueenCall.enqueue(object: Callback<ArrayList<QueenItem>>{
            override fun onFailure(call: Call<ArrayList<QueenItem>>, t: Throwable) {
                Toast.makeText(
                    context,
                    t.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onResponse(
                call: Call<ArrayList<QueenItem>>,
                response: Response<ArrayList<QueenItem>>
            ) {
                recyclerview_queen.apply{
                    layoutManager=LinearLayoutManager(context)
                    adapter=QueenAdapter(response.body()!!)
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