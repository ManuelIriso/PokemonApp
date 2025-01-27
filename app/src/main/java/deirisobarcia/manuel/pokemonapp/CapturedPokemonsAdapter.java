package deirisobarcia.manuel.pokemonapp;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class CapturedPokemonsAdapter extends RecyclerView.Adapter<CapturedPokemonsAdapter.PokemonViewHolder> {

    private Context context;
    private List<Pokemon> pokemonList;

    public CapturedPokemonsAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.textPokemonName.setText(pokemon.getName());
        holder.textPokemonDetails.setText(
                "Tipo: " + pokemon.getType() + "\nPeso: " + pokemon.getWeight() + "kg\nAltura: " + pokemon.getHeight() + "m"
        );
        Glide.with(context).load(pokemon.getImageUrl()).into(holder.imagePokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView textPokemonName, textPokemonDetails;
        ImageView imagePokemon;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            textPokemonName = itemView.findViewById(R.id.textPokemonName);
            textPokemonDetails = itemView.findViewById(R.id.textPokemonDetails);
            imagePokemon = itemView.findViewById(R.id.imagePokemon);
        }
    }
}
