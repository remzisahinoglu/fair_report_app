package arfesan.remzi;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GirisekraniActivity extends AppCompatActivity {

    public File root = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "Arfesan IAA2018");
    public File raporlar = new File(root, "rapordata.txt");     // klasörün içine dosyayı oluştur
    public File idname = new File(root, "idname.txt");          // kullanıcı adının tutulduğu klasör


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.girisekrani);

        Button GirisButonu = (Button)findViewById(R.id.btnGiris);
        final EditText KullaniciAdi = (EditText)findViewById(R.id.txtKullanici);

        if (!root.exists())
        {
            root.mkdirs();      // klasörü oluştur eğer yok ise

            if (!raporlar.exists())
            {
                try {
                    FileWriter writer = new FileWriter(raporlar);
                    writer.append("*");
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        // dosyayı oku edittexte yaz
        try {
            BufferedReader br = new BufferedReader(new FileReader(idname));
            KullaniciAdi.setText(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        GirisButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileWriter writer = new FileWriter(idname);
                    writer.append(KullaniciAdi.getText().toString());
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // seçim ekranına geç
                Intent raporekrani = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(raporekrani);


            }
        });



    }
}




