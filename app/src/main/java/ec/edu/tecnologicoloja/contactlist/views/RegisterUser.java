package ec.edu.tecnologicoloja.contactlist.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.tecnologicoloja.contactlist.R;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {
    private Button guardarbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        guardarbd = (Button) findViewById(R.id.formulario);
        guardarbd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view==guardarbd){

        }

    }
}
