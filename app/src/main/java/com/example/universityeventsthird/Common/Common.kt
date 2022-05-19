object Common {
    private val BASE_URL = "https://open.istu.edu/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}