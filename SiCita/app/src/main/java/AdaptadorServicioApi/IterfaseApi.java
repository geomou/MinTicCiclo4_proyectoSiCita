package AdaptadorServicioApi;

import Model.ClassUsuario;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public class IterfaseApi {

    private static IterfaseApi API_SERVICE;

    public static IterfaseApi getApiService() {

        ConexionAPI urapi=new ConexionAPI();
        // Creamos un interceptor y le indicamos el log level a usar
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl =urapi.UrlApi() ;

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build();
            API_SERVICE = retrofit.create(IterfaseApi.class);
        }

        return API_SERVICE;
    }
}

