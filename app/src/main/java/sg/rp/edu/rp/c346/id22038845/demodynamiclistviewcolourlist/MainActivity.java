package sg.rp.edu.rp.c346.id22038845.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement =findViewById(R.id.editTextColour);
        etIndexElement =findViewById(R.id.editTextInt);
        btnAdd =findViewById(R.id.buttonAddItem);
        btnRemove =findViewById(R.id.buttonRItem);
        btnUpdate =findViewById(R.id.buttonUItem);
        lvColour =findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColour);

        String colorInpt = etElement.getText().toString();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(etIndexElement.getText().toString())){
                    alColours.add(colorInpt);
                }else if(TextUtils.isEmpty(colorInpt)){
                    Toast.makeText(MainActivity.this, "You need to enter a color to proceed", Toast.LENGTH_SHORT).show();
                }else{
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.add(pos,colorInpt);
                }
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etIndexElement.getText().toString())){
                    Toast.makeText(MainActivity.this,"You need to enter a index position to proceed", Toast.LENGTH_SHORT).show();
                }else{
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.remove(pos);
                    aaColour.notifyDataSetChanged();
                }

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(etIndexElement.getText().toString())){
                    Toast.makeText(MainActivity.this,"You need to enter a index position as well", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(colorInpt)) {
                    Toast.makeText(MainActivity.this, "You need to enter a color to proceed", Toast.LENGTH_SHORT).show();
                } else {
                    int pos = Integer.parseInt(etIndexElement.getText().toString());
                    alColours.set(pos, colorInpt);
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }
}