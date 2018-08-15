package com.example.xuzg.litepaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createBtn = (Button) findViewById(R.id.create_database);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                Toast.makeText(MainActivity.this, "数据库已创建", Toast.LENGTH_SHORT).show();
            }
        });

        Button goAddPage = (Button) findViewById(R.id.go_add_page);
        goAddPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
            }
        });

        Button goUpdatePage = (Button) findViewById(R.id.go_update_page);
        goUpdatePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(it);
            }
        });

        Button goDeletePage = (Button) findViewById(R.id.go_delete_page);
        goDeletePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(it);
            }
        });

        Button goQueryPage = (Button) findViewById(R.id.go_query_page);
        goQueryPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, QueryActivity.class);
                startActivity(it);
            }
        });

    }
}
