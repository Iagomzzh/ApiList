import com.example.apilist.data.network.Response.ApiInterface

class Repository {
    val apiInterface = ApiInterface.create()
    suspend fun getAllCharacters() = apiInterface.getData()
}
