package kr.co.mbest.caloriexmlparsing_final

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipractice.json.Item
import com.example.apipractice.json.Library
import com.example.apipractice.web.NetWorkInterface
import kr.co.mbest.caloriexmldatapractice.web.RetrofitClient
import kr.co.mbest.caloriexmlparsing_final.databinding.ActivityMainBinding
import retrofit2.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val key =
        "ZttZgKaWHUnvsLX%2FB8UWGVI9d3Uj6PqProTiP2Dnq78CyAgcSK6%2B%2F1r%2FdtmJoWXOTNDBb2G1PxVYeB32Iq6teA%3D%3D"

    private lateinit var retrofit: Retrofit
    lateinit var apiServic: NetWorkInterface

    val mItemList = ArrayList<Item>()

    lateinit var mRecyclerAdapter: ItemRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        retrofit = RetrofitClient.getInstance()
        apiServic = retrofit.create()

        mRecyclerAdapter = ItemRecyclerAdapter(this, mItemList)
        binding.recyclerNews.adapter = mRecyclerAdapter

        binding.recyclerNews.layoutManager = LinearLayoutManager(this)


        binding.tvLine.setOnClickListener {

            binding.progressbar.visibility = View.VISIBLE

            apiServic.getRequestKcalList(key).enqueue(object : Callback<Library> {
                override fun onFailure(call: Call<Library>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "리스트를 읽어오는데 실패하였습니다" + t.message,
                        Toast.LENGTH_LONG
                    ).show()
                    Log.d("TTTaga", "${t.message}")
                }

                override fun onResponse(
                    call: Call<Library>,
                    response: Response<Library>
                ) {
                    if (response.isSuccessful) {

                        Log.d("응답 성공", response.body()!!.toString())
                        val basicResponse = response.body()!!
                        mItemList.clear()
                        mItemList.addAll(basicResponse.body.items.item!!)

                        mRecyclerAdapter.notifyDataSetChanged()
                        binding.progressbar.visibility = View.GONE

                    } else {
                        Log.d("응답 실패", "${call.isCanceled.toString()}")
                        binding.progressbar.visibility = View.GONE
                    }
                }

            })


        }


    }
}