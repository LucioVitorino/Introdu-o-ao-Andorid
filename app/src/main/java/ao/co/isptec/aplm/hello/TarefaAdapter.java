package ao.co.isptec.aplm.hello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {

    public TarefaAdapter(Context context, List<Tarefa> tarefas)
    {
        super(context, 0, tarefas );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View vista = convertView;

        if (vista == null){
            vista = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_tarefa, parent, false);
        }

        Tarefa tarefa = getItem(position);

        TextView textNome = vista.findViewById(R.id.text_nome_tarefa);
        TextView textPrioridade = vista.findViewById(R.id.text_prioridade_tarefa);

        textNome.setText(tarefa.getNome());
        textPrioridade.setText("Prioridade : " + tarefa.getPrioridade());

        return (vista);
    }
}
