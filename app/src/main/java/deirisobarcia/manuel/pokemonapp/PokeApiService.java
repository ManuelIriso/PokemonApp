package deirisobarcia.manuel.pokemonapp;



import deirisobarcia.manuel.pokemonapp.PokemonApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon?limit=100") // Endpoint para obtener 100 Pokémon
    Call<PokemonApiResponse> getPokemonList();
}
