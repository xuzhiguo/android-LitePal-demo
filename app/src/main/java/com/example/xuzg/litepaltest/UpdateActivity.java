package com.example.xuzg.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private EditText eLimit;
    private EditText eItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        eLimit = (EditText) findViewById(R.id.update_limit);
        eItem = (EditText) findViewById(R.id.update_item);

        Button updateBtn = (Button) findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String limitInput = eLimit.getText().toString();
                String itemInput = eItem.getText().toString();

                if (limitInput.equals("")) {
                    Toast.makeText(UpdateActivity.this, "请填写限制条件", Toast.LENGTH_SHORT).show();
                    return;
                }

                float price;
                if (!itemInput.equals("")) {
                    price = Float.parseFloat(itemInput);
                } else {
                    Toast.makeText(UpdateActivity.this, "请填写修改内容", Toast.LENGTH_SHORT).show();
                    return;
                }

                Book book = new Book();
                book.setPrice(price);
                book.updateAll("author = ?", limitInput);
//                book.setToDefault("author");   // 把整列设置默认值
//                book.updateAll();
//                book.delete();        // 删除已储存对象
                Toast.makeText(UpdateActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
                clearInput();
            }
        });

    }

    public void clearInput() {
        eLimit.setText("");
        eItem.setText("");
    }
}
