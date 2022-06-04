package com.example.a201b365_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Object Inflater;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.eng:
                  textView.setText("English");
                  sharedPreferences.edit().putString("title","english").apply();

                  return true;

            case R.id.hin:
                textView.setText("Hindi");
                sharedPreferences.edit().putString("title","hindi").apply();  //used to save the preferences
                return true;
            default:
                return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.a201b365_menu",0);//used to show the mode is private
        String pref = sharedPreferences.getString("title","default"); //used to save the default values
        textView.setText(pref); //setting the value for the next time to save as whatever we choosen last time
    }
}