package com.example.yannick.devoirmaison;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Button mJsonRequest;
    private Button mbutton1;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mJsonRequest = (Button) findViewById(R.id.Gitlist);
        mJsonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, GithubListActivity.class));

            }
        });
        mbutton1 = (Button) findViewById(R.id.button1);
        mbutton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String value = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("EditText",value);
                startActivity(intent);
                //Log.v("EditText",editText.getText().toString());
                //startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });


    }

    /*public void Go(View v) {
        //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici SecondActivite
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra('',message);
        //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
        startActivity(intent);


    }*/

}
