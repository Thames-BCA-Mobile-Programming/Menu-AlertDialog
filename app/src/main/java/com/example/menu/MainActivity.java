package com.example.menu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonOne, alertShowButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inilization the view
        iniViewById();

        //On click display alert
        displayAlertClickAction();


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.second_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "Item Selected " + item, Toast.LENGTH_SHORT).show();

                        return false;
                    }
                });
            }
        });

    }
    public  void iniViewById(){
        buttonOne = findViewById(R.id.button_one);

        alertShowButton = findViewById(R.id.alert_button);

    }

    public void displayAlertClickAction() {
        alertShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

    }

    public void showAlertDialog() {


        AlertDialog.Builder customAlertDialog = new AlertDialog.Builder(MainActivity.this);
        customAlertDialog.setTitle("My Alert!!!!!!");
        customAlertDialog.setIcon(R.mipmap.ic_launcher);
        customAlertDialog.setMessage("===== My Message =====");
        customAlertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        customAlertDialog.setNegativeButton("NEGATIVE BUTTON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        customAlertDialog.create();
        customAlertDialog.show();
    }

    private void showPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, popupMenu.getMenu());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater myInflator = getMenuInflater();
        myInflator.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //TODO NAVIGATION
        Toast.makeText(this, "Item Selected " + item.getItemId(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}