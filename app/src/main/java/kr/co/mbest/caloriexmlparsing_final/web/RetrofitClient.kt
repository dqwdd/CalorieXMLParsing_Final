package kr.co.mbest.caloriexmldatapractice.web

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

object RetrofitClient {
    private var instance: Retrofit? = null
    fun getInstance(): Retrofit {

        if (instance == null)
            instance = Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(
                    TikXmlConverterFactory.create(
                        TikXml.Builder().exceptionOnUnreadXml(false).build()
                    )
                )
                .build()
        return instance!!
    }
}

//"http://apis.data.go.kr"