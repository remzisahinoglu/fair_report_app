package arfesan.remzi;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RaporYaz extends AppCompatActivity {

    //Spinner içerisine koyacağımız verileri tanımlıyoruz
    public String[] segment = {" ", "Trailer", "Bus", "Truck", "Silo","DIGER"};
    public String[] FrenSistemiEBS = {" ", "Wabco-EBS", "Haldex-EBS", "Knorr-EBS", "EBS yok"};
    public String[] Dingil = {" ","BPW","SAF","SCHMITZ","JOST","GIANT","ROR","VALX","DIGER"};
    public String[] Kaliper = {" ","MERITOR","KNORR","HALDEX","WABCO","DIGER"};
    public String[] Koruk = {" ","ARFESAN","WABCO","KNORR","TSE","TSE(WABCO)","HALDEX","BENDIX","KANCA","ORSAN","CHINA","DIGER"};
    public String[] Cins = {" ","SFK DISK", "SFK SKAM", "SFK BORULU","DD DISK", "DD SKAM", "DD BORULU", "DP DISK", "DP SKAM", "DP BORULU"};
    public String[] ServisTip = {" ","9","16","20","24","30","42"};
    public String[] ImdatTip = {" ","16","24","24HFL3","30"};


    //Spinner'ları ve Adapter'lerini tanımlıyoruz
    public Spinner spinnerSegment;
    public Spinner spinnerFrenSistemiEBS;

    public Spinner spinnerDingil_1;
    public Spinner spinnerKaliper_1;
    public Spinner spinnerKoruk_1;
    public Spinner spinnerServisTip_1;
    public Spinner spinnerImdatTip_1;
    public Spinner spinnerCins_1;

    public Spinner spinnerDingil_2;
    public Spinner spinnerKaliper_2;
    public Spinner spinnerKoruk_2;
    public Spinner spinnerServisTip_2;
    public Spinner spinnerImdatTip_2;
    public Spinner spinnerCins_2;

    public Spinner spinnerDingil_3;
    public Spinner spinnerKaliper_3;
    public Spinner spinnerKoruk_3;
    public Spinner spinnerServisTip_3;
    public Spinner spinnerImdatTip_3;
    public Spinner spinnerCins_3;

    public Spinner spinnerDingil_4;
    public Spinner spinnerKaliper_4;
    public Spinner spinnerKoruk_4;
    public Spinner spinnerServisTip_4;
    public Spinner spinnerImdatTip_4;
    public Spinner spinnerCins_4;

    public Spinner spinnerDingil_5;
    public Spinner spinnerKaliper_5;
    public Spinner spinnerKoruk_5;
    public Spinner spinnerServisTip_5;
    public Spinner spinnerImdatTip_5;
    public Spinner spinnerCins_5;

    public ArrayAdapter<String> dataAdapterForSegment;
    public ArrayAdapter<String> dataAdapterForFrenSistemiEBS;
    public ArrayAdapter<String> dataAdapterForDingil;
    public ArrayAdapter<String> dataAdapterForKaliper;
    public ArrayAdapter<String> dataAdapterForKoruk;
    public ArrayAdapter<String> dataAdapterForServisTip;
    public ArrayAdapter<String> dataAdapterForImdatTip;
    public ArrayAdapter<String> dataAdapterForCins;

    public File root = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "Arfesan IAA2018");
    public File raporlar = new File(root, "rapordata.txt");     // klasörün içine dosyayı oluştur
    public File idname = new File(root, "idname.txt");          // kullanıcı adının tutulduğu klasör

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapor_yaz);


        Button KaydetButonu = (Button)findViewById(R.id.btnKaydet);
        final EditText Firma = (EditText)findViewById(R.id.editTextFirma);
        final EditText Model = (EditText)findViewById(R.id.editTextModel);
        final EditText Aciklama = (EditText)findViewById(R.id.editTextAciklama);


        //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz
        spinnerSegment = (Spinner)findViewById(R.id.spinnerSegment);
        spinnerFrenSistemiEBS = (Spinner)findViewById(R.id.spinnerFrenSistemi);

        spinnerDingil_1 = (Spinner)findViewById(R.id.spinnerDingil_1);
        spinnerKaliper_1 = (Spinner)findViewById(R.id.spinnerKaliper_1);
        spinnerKoruk_1 = (Spinner)findViewById(R.id.spinnerKoruk_1);
        spinnerCins_1 = (Spinner)findViewById(R.id.spinnerCins_1);
        spinnerServisTip_1 = (Spinner)findViewById(R.id.spinnerServis_1);
        spinnerImdatTip_1 = (Spinner)findViewById(R.id.spinnerImdat_1);

        spinnerDingil_2 = (Spinner)findViewById(R.id.spinnerDingil_2);
        spinnerKaliper_2 = (Spinner)findViewById(R.id.spinnerKaliper_2);
        spinnerKoruk_2 = (Spinner)findViewById(R.id.spinnerKoruk_2);
        spinnerCins_2 = (Spinner)findViewById(R.id.spinnerCins_2);
        spinnerServisTip_2 = (Spinner)findViewById(R.id.spinnerServis_2);
        spinnerImdatTip_2 = (Spinner)findViewById(R.id.spinnerImdat_2);

        spinnerDingil_3 = (Spinner)findViewById(R.id.spinnerDingil_3);
        spinnerKaliper_3 = (Spinner)findViewById(R.id.spinnerKaliper_3);
        spinnerKoruk_3 = (Spinner)findViewById(R.id.spinnerKoruk_3);
        spinnerCins_3 = (Spinner)findViewById(R.id.spinnerCins_3);
        spinnerServisTip_3 = (Spinner)findViewById(R.id.spinnerServis_3);
        spinnerImdatTip_3 = (Spinner)findViewById(R.id.spinnerImdat_3);

        spinnerDingil_4 = (Spinner)findViewById(R.id.spinnerDingil_4);
        spinnerKaliper_4 = (Spinner)findViewById(R.id.spinnerKaliper_4);
        spinnerKoruk_4 = (Spinner)findViewById(R.id.spinnerKoruk_4);
        spinnerCins_4 = (Spinner)findViewById(R.id.spinnerCins_4);
        spinnerServisTip_4 = (Spinner)findViewById(R.id.spinnerServis_4);
        spinnerImdatTip_4 = (Spinner)findViewById(R.id.spinnerImdat_4);

        spinnerDingil_5 = (Spinner)findViewById(R.id.spinnerDingil_5);
        spinnerKaliper_5 = (Spinner)findViewById(R.id.spinnerKaliper_5);
        spinnerKoruk_5 = (Spinner)findViewById(R.id.spinnerKoruk_5);
        spinnerCins_5 = (Spinner)findViewById(R.id.spinnerCins_5);
        spinnerServisTip_5 = (Spinner)findViewById(R.id.spinnerServis_5);
        spinnerImdatTip_5 = (Spinner)findViewById(R.id.spinnerImdat_5);

        //Spinner'lar için adapterleri hazırlıyoruz
        dataAdapterForSegment = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, segment);
        dataAdapterForFrenSistemiEBS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, FrenSistemiEBS);
        dataAdapterForDingil = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Dingil);
        dataAdapterForKaliper = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Kaliper);
        dataAdapterForKoruk = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Koruk);
        dataAdapterForCins = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Cins);
        dataAdapterForServisTip = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ServisTip);
        dataAdapterForImdatTip = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ImdatTip);

        //Listelenecek verilerin görünümünü belirliyoruz
        dataAdapterForSegment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForFrenSistemiEBS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForDingil.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForKaliper.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForKoruk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForCins.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForServisTip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForImdatTip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz
        spinnerSegment.setAdapter(dataAdapterForSegment);
        spinnerFrenSistemiEBS.setAdapter(dataAdapterForFrenSistemiEBS);

        spinnerKaliper_1.setAdapter(dataAdapterForKaliper);
        spinnerDingil_1.setAdapter(dataAdapterForDingil);
        spinnerKoruk_1.setAdapter(dataAdapterForKoruk);
        spinnerServisTip_1.setAdapter(dataAdapterForServisTip);
        spinnerImdatTip_1.setAdapter(dataAdapterForImdatTip);
        spinnerCins_1.setAdapter(dataAdapterForCins);

        spinnerKaliper_2.setAdapter(dataAdapterForKaliper);
        spinnerDingil_2.setAdapter(dataAdapterForDingil);
        spinnerKoruk_2.setAdapter(dataAdapterForKoruk);
        spinnerServisTip_2.setAdapter(dataAdapterForServisTip);
        spinnerImdatTip_2.setAdapter(dataAdapterForImdatTip);
        spinnerCins_2.setAdapter(dataAdapterForCins);

        spinnerKaliper_3.setAdapter(dataAdapterForKaliper);
        spinnerDingil_3.setAdapter(dataAdapterForDingil);
        spinnerKoruk_3.setAdapter(dataAdapterForKoruk);
        spinnerServisTip_3.setAdapter(dataAdapterForServisTip);
        spinnerImdatTip_3.setAdapter(dataAdapterForImdatTip);
        spinnerCins_3.setAdapter(dataAdapterForCins);

        spinnerKaliper_4.setAdapter(dataAdapterForKaliper);
        spinnerDingil_4.setAdapter(dataAdapterForDingil);
        spinnerKoruk_4.setAdapter(dataAdapterForKoruk);
        spinnerServisTip_4.setAdapter(dataAdapterForServisTip);
        spinnerImdatTip_4.setAdapter(dataAdapterForImdatTip);
        spinnerCins_4.setAdapter(dataAdapterForCins);

        spinnerKaliper_5.setAdapter(dataAdapterForKaliper);
        spinnerDingil_5.setAdapter(dataAdapterForDingil);
        spinnerKoruk_5.setAdapter(dataAdapterForKoruk);
        spinnerServisTip_5.setAdapter(dataAdapterForServisTip);
        spinnerImdatTip_5.setAdapter(dataAdapterForImdatTip);
        spinnerCins_5.setAdapter(dataAdapterForCins);


        /*
        // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz
        spinnerSegment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals(segment[0])){

                }
                else if(parent.getSelectedItem().toString().equals(segment[1])){

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

        KaydetButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    BufferedReader br = new BufferedReader(new FileReader(raporlar));
                    String rapordata = br.readLine();

                    br = new BufferedReader(new FileReader(idname));

                    rapordata += br.readLine() + ";";
                    rapordata += Firma.getText().toString() + ";";
                    rapordata += Model.getText().toString() + ";";

                    rapordata += spinnerSegment.getSelectedItem().toString() + ";";
                    rapordata += spinnerFrenSistemiEBS.getSelectedItem().toString() + ";";

                    rapordata += spinnerDingil_1.getSelectedItem().toString() + ";";
                    rapordata += spinnerKaliper_1.getSelectedItem().toString() + ";";
                    rapordata += spinnerKoruk_1.getSelectedItem().toString() + ";";
                    rapordata += spinnerCins_1.getSelectedItem().toString() + ";";
                    rapordata += spinnerServisTip_1.getSelectedItem().toString() + ";";
                    rapordata += spinnerImdatTip_1.getSelectedItem().toString() + ";";

                    rapordata += spinnerDingil_2.getSelectedItem().toString() + ";";
                    rapordata += spinnerKaliper_2.getSelectedItem().toString() + ";";
                    rapordata += spinnerKoruk_2.getSelectedItem().toString() + ";";
                    rapordata += spinnerCins_2.getSelectedItem().toString() + ";";
                    rapordata += spinnerServisTip_2.getSelectedItem().toString() + ";";
                    rapordata += spinnerImdatTip_2.getSelectedItem().toString() + ";";

                    rapordata += spinnerDingil_3.getSelectedItem().toString() + ";";
                    rapordata += spinnerKaliper_3.getSelectedItem().toString() + ";";
                    rapordata += spinnerKoruk_3.getSelectedItem().toString() + ";";
                    rapordata += spinnerCins_3.getSelectedItem().toString() + ";";
                    rapordata += spinnerServisTip_3.getSelectedItem().toString() + ";";
                    rapordata += spinnerImdatTip_3.getSelectedItem().toString() + ";";

                    rapordata += spinnerDingil_4.getSelectedItem().toString() + ";";
                    rapordata += spinnerKaliper_4.getSelectedItem().toString() + ";";
                    rapordata += spinnerKoruk_4.getSelectedItem().toString() + ";";
                    rapordata += spinnerCins_4.getSelectedItem().toString() + ";";
                    rapordata += spinnerServisTip_4.getSelectedItem().toString() + ";";
                    rapordata += spinnerImdatTip_4.getSelectedItem().toString() + ";";

                    rapordata += spinnerDingil_5.getSelectedItem().toString() + ";";
                    rapordata += spinnerKaliper_5.getSelectedItem().toString() + ";";
                    rapordata += spinnerKoruk_5.getSelectedItem().toString() + ";";
                    rapordata += spinnerCins_5.getSelectedItem().toString() + ";";
                    rapordata += spinnerServisTip_5.getSelectedItem().toString() + ";";
                    rapordata += spinnerImdatTip_5.getSelectedItem().toString() + ";";

                    rapordata += Aciklama.getText().toString() + ";" + "*";

                    FileWriter writer = new FileWriter(raporlar);
                    writer.write(rapordata);
                    writer.flush();
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                // seçim ekranına geri dön
                Intent raporekrani = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(raporekrani);
            }
        });


    }
}
