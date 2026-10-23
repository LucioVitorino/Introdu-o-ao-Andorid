package ao.co.isptec.aplm.hello;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String CHAVE =
            "ao.co.isptec.aplm.hello.MENSAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText campoMensagem = findViewById(R.id.edit_message);
        Button botaoEnviar = findViewById(R.id.button_send);

        botaoEnviar.setOnClickListener(v ->{
            String mensagem = campoMensagem.getText().toString();
            Intent intent = new Intent(MainActivity.this,
                    DisplayMessageActivity.class);
            intent.putExtra(CHAVE,
                    mensagem);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}