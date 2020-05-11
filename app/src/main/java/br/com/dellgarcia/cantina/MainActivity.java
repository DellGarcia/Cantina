package br.com.dellgarcia.cantina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.dellgarcia.cantina.models.Item;

public class MainActivity extends AppCompatActivity {

    private ListView lvFood;
    private Spinner spnCode;
    private EditText edtQtd;
    private Button btnAdd;
    private TextView txvValorTotal;

    private double total;

    private ArrayList<> items;
    private String[] lanches = {
            "Cachorro Quente",
            "X-Salada",
            "X-Bacon",
            "Torrada simples",
            "Refrigerante"
    };

    private double[] values = {
        4, 4.5, 5, 2, 1.50
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancing();

        putSpnCode();

        btnAdd.setOnClickListener(addToList());
    }

    private void instancing() {
        lvFood = findViewById(R.id.foodList);
        spnCode = findViewById(R.id.spnCode);
        edtQtd = findViewById(R.id.edtQtd);
        btnAdd = findViewById(R.id.btnAdd);
        txvValorTotal = findViewById(R.id.txvValor);

        total = 0;

        items = new ArrayList<>();
    }

    private void putSpnCode() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.codes_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCode.setAdapter(adapter);
    }

    private View.OnClickListener addToList() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Integer.parseInt(spnCode.getSelectedItem().toString()) - 1;
                int qtd = Integer.parseInt(edtQtd.getText().toString());

                items.add(new Item(lanches[index], values[index], qtd));
                ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(MainActivity.this, android.R.layout.simple_list_item_1, items);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                lvFood.setAdapter(adapter);

                txvValorTotal.setText(Double.toString(total += values[index] * qtd));
            }
        };
    }
}
