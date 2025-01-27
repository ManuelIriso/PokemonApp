package deirisobarcia.manuel.pokemonapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // URL base de la PokéAPI
                    .addConverterFactory(GsonConverterFactory.create()) // Convertidor de JSON a Java
                    .build();
        }
        return retrofit;
    }
}

