package com.example.chango.ejemplo0701ficheros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void creaFichero(View view){
        try{
            OutputStreamWriter fout=
                    new OutputStreamWriter(openFileOutput("prueba_int.txt",
                            Context.MODE_PRIVATE));
            fout.write("Texto de prueba.");
            fout.close();
        }
        catch (Exception ex){
            Log.e("Ficheros",
                    "Error al escribir fichero a memoria interna");
        }

    }
}
