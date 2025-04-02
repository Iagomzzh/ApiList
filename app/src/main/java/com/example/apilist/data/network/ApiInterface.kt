import com.example.apilist.data.Data
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface {
    @GET("search")
    suspend fun searchProducts(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("geo") geo: String
    ): Response<Data>

    companion object {
        private const val BASE_URL = "https://amazon-online-data-api.p.rapidapi.com/"
        private const val API_KEY = "a57b2c44ddmshea25ad0c07bf7bfp120c06jsnf09ec259f0d1"

        fun create(): ApiInterface {
            val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-RapidAPI-Key", API_KEY)
                        .addHeader("X-RapidAPI-Host", "amazon-online-data-api.p.rapidapi.com")
                        .build()
                    chain.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }

    @GET()
    suspend fun getData(@Url url: String): Response<Data>

}