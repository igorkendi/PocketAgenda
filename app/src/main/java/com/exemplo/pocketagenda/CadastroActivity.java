package com.exemplo.pocketagenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtTitulo;
    private EditText edtData;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        edtTitulo = findViewById(R.id.edtTitulo);
        edtData = findViewById(R.id.edtData);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = edtTitulo.getText().toString().trim();
                String data = edtData.getText().toString().trim();

                if (titulo.isEmpty()) {
                    edtTitulo.setError(getString(R.string.erro_titulo));
                    edtTitulo.requestFocus();
                    Toast.makeText(CadastroActivity.this, R.string.erro_titulo, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (data.isEmpty()) {
                    edtData.setError(getString(R.string.erro_data));
                    edtData.requestFocus();
                    Toast.makeText(CadastroActivity.this, R.string.erro_data, Toast.LENGTH_SHORT).show();
                    return;
                }

                CompromissoRepository.adicionar(new Compromisso(titulo, data));
                Toast.makeText(CadastroActivity.this, R.string.sucesso, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
