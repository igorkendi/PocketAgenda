package com.exemplo.pocketagenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirCadastro;
    private TextView txtCompromissos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirCadastro = findViewById(R.id.btnAbrirCadastro);
        txtCompromissos = findViewById(R.id.txtCompromissos);

        btnAbrirCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista() {
        List<Compromisso> lista = CompromissoRepository.listar();
        if (lista.isEmpty()) {
            txtCompromissos.setText(R.string.lista_vazia);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            Compromisso c = lista.get(i);
            sb.append(i + 1).append(". ").append(c.getTitulo()).append(" — ").append(c.getData());
            if (i < lista.size() - 1) {
                sb.append('\n');
            }
        }
        txtCompromissos.setText(sb.toString());
    }
}
