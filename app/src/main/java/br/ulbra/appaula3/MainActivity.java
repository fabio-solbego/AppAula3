package br.ulbra.appaula3;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtmetros, edtpes;

    Button btnconvertermp;
    double metros, pes;
    int v2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtmetros = (EditText) findViewById(R.id.edtmetros);
        edtpes = (EditText) findViewById(R.id.edtpes);
        btnconvertermp = (Button) findViewById(R.id.btnconvertermp);
        DecimalFormat f = new DecimalFormat("0.0");


        btnconvertermp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtpes.getText().toString().equals("") && edtmetros.getText().toString().equals("")) {
                    show("Erro", "Preencha um do valores.");
                } else if ((edtpes.getText().toString().equals("")) && !(edtmetros.getText().toString().equals(""))) {
                    metros = Double.parseDouble(edtmetros.getText().toString());
                    pes = metros * 3.28084;
                    edtpes.setText(""+pes);
                } else {

                    pes = Integer.parseInt(edtpes.getText().toString());
                    metros = pes / 3.28084;
                    edtmetros.setText("" + metros);

                }
            }
        });

    }
        public void show (String tit, String men){
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle(tit);
            b.setMessage(men);
            b.show();
        }

}