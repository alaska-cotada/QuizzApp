package com.example.arrob.appquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    int respostaCerta = R.id.rbResposta3;
    RadioGroup rgRespostas;
    int pontos;


    List<Questoes> questoes = new ArrayList<Questoes>() {
        {
            add(new Questoes("Qual o maior deserto do mundo ?", R.id.rbResposta3, "Atacama", "Saara", "Antártica", "Kalahari"));
            add(new Questoes("Qual monte está mais próximo do espaço?", R.id.rbResposta3, "Fuji", "Everest", "Chimborazo", "K2"));
            add(new Questoes("O pai do padre é filho do meu pai. O que eu sou do Padre?", R.id.rbResposta1, "Tio", "Filho", "Sobrinho", "Amigo"));
            add(new Questoes("Quantos animais de cada espécie Moisés colocou em sua arca?", R.id.rbResposta1, "0", "1", "2", "3"));
            add(new Questoes("Quantos meses tem 28 dias durante um periodo de 6 anos? ", R.id.rbResposta3, "1", "27", "72", "82"));
            add(new Questoes("Divida 60 por meio e some 20. Qual é o resultado ? ", R.id.rbResposta2, "150", "140", "50", "40"));
            add(new Questoes("Havia 5 pessoas na sala, cheguei e matei 4. Quantas pessoas ficaram na sala ? ", R.id.rbResposta4, "1", "2", "3", "4"));
            add(new Questoes("Você entra em uma sala escura e tem um fósforo no bolso. Há uma lareira e uma vela, o que você acende primeiro ? ", R.id.rbResposta2, "a vela", "o fósforo", "a luz", "a lareira"));
            add(new Questoes("Divida 60 por meio e some 20. Qual é o resultado ? ", R.id.rbResposta2, "150", "140", "50", "40"));


        }
    };


    @Override
    protected void onRestart() {
        super.onRestart();
        carregarQuestao();

        pergunta.setText("Qual monte está mais próximo do espaço?");
        rbResposta1.setText("Fuji");
        rbResposta2.setText("Everest");
        rbResposta3.setText("Chimborazo");
        rbResposta4.setText("K2");
        respostaCerta = R.id.rbResposta2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        pergunta = (TextView) findViewById(R.id.pergunta);
        rbResposta1 = (RadioButton) findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton) findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton) findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton) findViewById(R.id.rbResposta4);
        carregarQuestao();
    }


    public void btnResponderOnClick(View v) {

        RadioButton rb = (RadioButton) findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);
        if (rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
            intent.putExtra("acertou", true);
            pontos++;
        } else intent.putExtra("acertou", false);
        intent.putExtra("pontos", pontos);
        startActivity(intent);
        rb.setChecked(false);
    }


    private void carregarQuestao() {

        if (questoes.size() > 0) {
            Questoes q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rbResposta1.setText(resposta.get(0));
            rbResposta2.setText(resposta.get(1));
            rbResposta3.setText(resposta.get(2));
            rbResposta4.setText(resposta.get(3));
            respostaCerta = q.getRespostaCerta();


        } else { //acabaram as questoes

            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();

        }


    }
}
