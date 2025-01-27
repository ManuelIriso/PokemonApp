package deirisobarcia.manuel.pokemonapp;



import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonApiResponse {

    @SerializedName("results")
    private List<PokemonResult> results;

    public List<PokemonResult> getResults() {
        return results;
    }

    public static class PokemonResult {
        @SerializedName("name")
        private String name;

        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
