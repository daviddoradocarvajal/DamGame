package dam.gala.damgame.fragments;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.example.damgame.R;

/**
 * Cuadro de diálogo para las preferencias de la aplicación
 * @author 2º DAM - IES Antonio Gala
 * @version 1.0
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
        ListPreference listPreference = (ListPreference) findPreference("theme_setting");
        SharedPreferences pref = getDefaultSharedPreferences(listPreference.getContext());


        listPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                switch (listPreference.getEntry().toString()){
                    case "Selva":
                        pref.edit().putString("theme_setting","104");
                        listPreference.setValue("104");
                        break;
                    case "Hielo":
                        pref.edit().putString("theme_setting","103");
                        listPreference.setValue("103");
                        break;
                    default:
                        pref.edit().putString("theme_setting","103");
                        listPreference.setValue("103");
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onDisplayPreferenceDialog(Preference preference) {
        super.onDisplayPreferenceDialog(preference);
    }
}