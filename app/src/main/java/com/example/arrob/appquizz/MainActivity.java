package com.example.arrob.appquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnJogarOnClick(View v){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void btnRespostaOnClick(View v){
        RadioGroup rgResposta = (RadioGroup)findViewById(R.id.rgResposta);
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("acertou", rgResposta.getCheckedRadioButtonId() == R.id.rbResposta3);
        startActivity(intent);
    }
}
