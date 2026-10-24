package ao.co.isptec.aplm.hello;



import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Tarefa> tarefas = new ArrayList<>();
    private TarefaAdapter adaptador;
    private String dataLimiteSelecionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText campoTarefas = findViewById(R.id.edit_tarefa);
        Button botaoAdicionar = findViewById(R.id.button_adicionar);
        ListView listaTarefas = findViewById(R.id.lista_tarefas);
        Spinner spinnerPrioridade = findViewById(R.id.spinner_prioridade);



        adaptador = new TarefaAdapter(this, tarefas);
        listaTarefas.setAdapter(adaptador);

        botaoAdicionar.setOnClickListener(v -> {
            String nome = campoTarefas.getText().toString().trim();
            String prioridade = spinnerPrioridade.getSelectedItem().toString();
            if (nome.isEmpty()){
                campoTarefas.setError("Introdux o nome da tarefas");
                return;
            }

            Tarefa tarefa = new Tarefa(nome, prioridade, dataLimiteSelecionada);
            tarefas.add(tarefa);
            adaptador.notifyDataSetChanged();

            campoTarefas.setText("");
        });

        Button botaoData = findViewById(R.id.button_data);

        botaoData.setOnClickListener(v -> {
            Calendar calendario = Calendar.getInstance();

            int ano = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog selectorData = new DatePickerDialog(
                    MainActivity.this, (datePicker, anoEscolhido, mesEscolhido, diaEscolhido) -> {
                        dataLimiteSelecionada = String.format(
                                java.util.Locale.ROOT,
                                "%02d/%02d/%04d",
                                diaEscolhido,
                                mesEscolhido + 1,
                                anoEscolhido
                        );
                        botaoData.setText(dataLimiteSelecionada);
            },
                    ano, mes, dia
            );

            selectorData.show();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}