package deirisobarcia.manuel.pokemonapp;





import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import deirisobarcia.manuel.pokemonapp.Pokemon;
import deirisobarcia.manuel.pokemonapp.R;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

class CapturedPokemonsFragment extends PokedexFragment  {

    private RecyclerView recyclerView;
    private List<Pokemon> pokemonList;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_pokemons, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewCapturedPokemons);


        pokemonList = getSamplePokemons();
        CapturedPokemonsAdapter adapter = new CapturedPokemonsAdapter(AccessController.getContext(), pokemonList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Pokemon> getSamplePokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png", "Eléctrico", 6.0, 0.4));
        pokemons.add(new Pokemon("Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png", "Fuego", 8.5, 0.6));
        return pokemons;
    }




}

