package com.example.chango.ejemplo0701ficheros;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void creaFicheroInterno(View view){
        try{
            OutputStreamWriter fout=
                    new OutputStreamWriter(openFileOutput("prueba_int.txt",
                            Context.MODE_PRIVATE));
            fout.write("Texto interno de prueba.");
            fout.close();
        }
        catch (Exception ex){
            Log.e("Ficheros",
                    "Error al escribir fichero a memoria interna");
        }
    }

    public void leeFicheroInterno(View view){
        try
        {
            BufferedReader fin =new BufferedReader( new
                    InputStreamReader(openFileInput("prueba_int.txt")));
            String texto = fin.readLine();
            Toast.makeText(this,texto, Toast.LENGTH_LONG).show();
            fin.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al leer desde memoria interna");
        }
    }

    public void creaFicheroExterno(View view){
        try
        {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            OutputStreamWriter fout = new OutputStreamWriter(
                    new FileOutputStream(f));
            fout.write("Texto externo de prueba.");
            fout.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
        }

    }

    public void leeFicheroExterno(View view){
        try{
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new
                    InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            fin.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
        }
    }
}
