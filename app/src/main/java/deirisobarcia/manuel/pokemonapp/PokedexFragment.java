package deirisobarcia.manuel.pokemonapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import deirisobarcia.manuel.pokemonapp.R;

public class PokedexFragment extends Fragment {
    private RecyclerView recyclerView;
    private PokedexAdapter adapter;


    public PokedexFragment() {
        // Constructor vacío obligatorio
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokedex, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewPokedex);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PokedexAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        fetchPokemonList();

        return view;
    }
    private void fetchPokemonList() {
        PokeApiService apiService = RetrofitInstance.getRetrofitInstance().create(PokeApiService.class);
        apiService.getPokemonList().enqueue(new Callback<PokemonApiResponse>() {
            @Override
            public void onResponse(Call<PokemonApiResponse> call, Response<PokemonApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new PokedexAdapter(getContext(), response.body().getResults());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PokemonApiResponse> call, Throwable t) {
                // Manejar errores
            }
        });
    }
}

