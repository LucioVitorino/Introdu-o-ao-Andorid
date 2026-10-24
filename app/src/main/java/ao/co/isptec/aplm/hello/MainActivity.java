package ao.co.isptec.aplm.hello;



import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Tarefa> tarefas = new ArrayList<>();
    private TarefaAdapter adaptador;

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

            Tarefa tarefa = new Tarefa(nome, prioridade, "");
            tarefas.add(tarefa);
            adaptador.notifyDataSetChanged();

            campoTarefas.setText("");
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}