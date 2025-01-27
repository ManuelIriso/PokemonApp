package deirisobarcia.manuel.pokemonapp;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import deirisobarcia.manuel.pokemonapp.R;
import deirisobarcia.manuel.pokemonapp.PokemonApiResponse;
import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {

    private Context context;
    private List<PokemonApiResponse.PokemonResult> pokemonList;

    public PokedexAdapter(Context context, List<PokemonApiResponse.PokemonResult> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokedex_pokemon, parent, false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexViewHolder holder, int position) {
        PokemonApiResponse.PokemonResult pokemon = pokemonList.get(position);
        holder.textPokemonName.setText(pokemon.getName());
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    static class PokedexViewHolder extends RecyclerView.ViewHolder {
        TextView textPokemonName;

        public PokedexViewHolder(@NonNull View itemView) {
            super(itemView);
            textPokemonName = itemView.findViewById(R.id.textPokemonName);
        }
    }
}

