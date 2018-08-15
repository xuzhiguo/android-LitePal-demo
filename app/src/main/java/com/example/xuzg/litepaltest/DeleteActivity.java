package com.example.xuzg.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

public class DeleteActivity extends AppCompatActivity {
    private EditText eDeleteLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        eDeleteLimit = (EditText) findViewById(R.id.delete_price);
        Button deleteItem = (Button) findViewById(R.id.delete_item);
        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price = eDeleteLimit.getText().toString();
                if (price.equals("")) {
                    Toast.makeText(DeleteActivity.this, "请填写限制金额", Toast.LENGTH_SHORT).show();
                    return;
                }

                DataSupport.deleteAll(Book.class,"price < ?", price);
                Toast.makeText(DeleteActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                eDeleteLimit.setText("");
            }
        });

        Button deleteAll = (Button) findViewById(R.id.delete_all);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class);
                Toast.makeText(DeleteActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                eDeleteLimit.setText("");
            }
        });
    }
}
