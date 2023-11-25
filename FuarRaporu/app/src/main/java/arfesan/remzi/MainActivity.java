package arfesan.remzi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button raporYazButonu = (Button)findViewById(R.id.btnRaporYaz);
        Button grafiklerButonu = (Button)findViewById(R.id.btnGrafikler);


        raporYazButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // rapor kayıt sayfasına geç
                Intent raporyazekrani = new Intent(getApplicationContext(), RaporYaz.class);
                startActivity(raporyazekrani);
            }
        });


        grafiklerButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grafiklerekrani = new Intent(getApplicationContext(), Grafikler.class);
                startActivity(grafiklerekrani);
            }
        });





    }
}
