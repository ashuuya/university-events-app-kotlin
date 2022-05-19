import com.example.universityeventsthird.Model.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitServices {
    @GET("api/get_all_events.php")
    @Headers("Content-Type: application/json")
    fun getAllEvents(): Call<MutableList<Event>>
}