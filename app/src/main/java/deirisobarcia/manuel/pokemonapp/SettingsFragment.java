package deirisobarcia.manuel.pokemonapp;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import deirisobarcia.manuel.pokemonapp.LoginActivity;
import deirisobarcia.manuel.pokemonapp.R;

import java.util.Locale;

public class SettingsFragment extends Fragment {

    private Switch switchDelete;
    private Spinner spinnerLanguage;
    private Button buttonLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Referenciar vistas
        switchDelete = view.findViewById(R.id.switchDelete);
        spinnerLanguage = view.findViewById(R.id.spinnerLanguage);
        buttonLogout = view.findViewById(R.id.buttonLogout);

        // Configurar Switch
        configureDeleteSwitch();

        // Configurar selector de idioma
        configureLanguageSpinner();

        // Configurar botón de cerrar sesión
        configureLogoutButton();

        return view;
    }

    private void configureDeleteSwitch() {
        SharedPreferences preferences = requireContext().getSharedPreferences("SettingsPrefs", requireContext().MODE_PRIVATE);
        boolean allowDelete = preferences.getBoolean("allowDelete", false);
        switchDelete.setChecked(allowDelete);

        switchDelete.setOnCheckedChangeListener((buttonView, isChecked) -> {
            preferences.edit().putBoolean("allowDelete", isChecked).apply();
            Toast.makeText(getContext(), isChecked ? "Eliminación habilitada" : "Eliminación deshabilitada", Toast.LENGTH_SHORT).show();
        });
    }

    private void configureLanguageSpinner() {
        // Crear un adaptador para el Spinner
        String[] languages = {"Español", "Inglés"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(adapter);

        SharedPreferences preferences = requireContext().getSharedPreferences("SettingsPrefs", requireContext().MODE_PRIVATE);
        String currentLanguage = preferences.getString("language", "Español");
        spinnerLanguage.setSelection(currentLanguage.equals("Español") ? 0 : 1);

        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = languages[position];
                preferences.edit().putString("language", selectedLanguage).apply();

                Locale locale = new Locale(selectedLanguage.equals("Español") ? "es" : "en");
                Locale.setDefault(locale);

                Toast.makeText(getContext(), "Idioma cambiado a " + selectedLanguage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void configureLogoutButton() {
        buttonLogout.setOnClickListener(v -> {
            // Redirigir al LoginActivity y limpiar las preferencias
            SharedPreferences preferences = requireContext().getSharedPreferences("SettingsPrefs", requireContext().MODE_PRIVATE);
            preferences.edit().clear().apply();

            Intent intent = new Intent(getContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
