package com.example.arrob.appquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RespostaActivity extends AppCompatActivity {

    ImageView imgResposta = (ImageView)findViewById(R.id.imgResposta);
    TextView resposta = (TextView)findViewById(R.id.resposta);

    Intent intent = getIntent();
    boolean acertou = intent.getBooleanExtra("acertou", false);
        if(acertou){
        imgResposta.setImageResource(R.drawable.acertou);
        resposta.setText("Acertou!");
    }
        else{
        imgResposta.setImageResource(R.drawable.errou);
        resposta.setText("Errou!");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
        thread.start();
    }


}
