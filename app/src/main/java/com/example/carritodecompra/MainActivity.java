package com.example.carritodecompra;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public TextView respusta;
    public Button LoadButton;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.respusta = findViewById(R.id.respuesta);
        this.LoadButton = findViewById(R.id.button_send);

        this.addHandlersControls();
    }

    private void addHandlersControls(){
        this.LoadButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "https://swapi.co/api/starships/2";
                        data con = new data();
                        con.getItems(url);
                        respusta.setText(con.getItemsGet());
                    }
                });
            }
        });
    }

    /*private void changeText() throws IOException {
        String url = "https://swapi.co/api/starships/2";
        data con = new data();
        this.respusta.setText(con.getItems(url));
    }*/
}
