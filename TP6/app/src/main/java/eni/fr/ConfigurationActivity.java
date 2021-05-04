package eni.fr;

import android.content.SharedPreferences;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurationActivity extends AppCompatActivity {

    public final static String CLE_TRI = "CLE_TRI";
    public final static String CLE_PRIX = "CLE_PRIX";

    private EditText prix;
    private android.widget.Switch tri;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuration);

        SharedPreferences spIntra = getSharedPreferences("configuration",MODE_PRIVATE);
        String valeurPrixDefaut = spIntra.getString(CLE_PRIX,"");
        Boolean valeurTri = spIntra.getBoolean(CLE_TRI,false);

        prix = findViewById(R.id.prixDefaut);
        tri =  findViewById(R.id.triParPrix);

        prix.setText(valeurPrixDefaut);
        tri.setChecked(valeurTri);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editeur = sp.edit();

        editeur.putInt(CLE_PRIX, Integer.valueOf(prix.getText().toString()));
        editeur.putBoolean(CLE_TRI, tri.isChecked());
        editeur.commit();
    }
}
