package com.example.xuzg.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private EditText eName;
    private EditText eAuthor;
    private EditText ePress;
    private EditText ePages;
    private EditText ePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        eName = (EditText) findViewById(R.id.add_name);
        eAuthor = (EditText) findViewById(R.id.add_author);
        ePress = (EditText) findViewById(R.id.add_press);
        ePages = (EditText) findViewById(R.id.add_pages);
        ePrice = (EditText) findViewById(R.id.add_price);

        Button addData = (Button) findViewById(R.id.add_btn);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                String nameInput = eName.getText().toString();
                if (nameInput.equals("")) {
                    Toast.makeText(AddActivity.this, "请填写书名", Toast.LENGTH_SHORT).show();
                    return;
                }
                String authorInput = eAuthor.getText().toString();
                if (authorInput.equals("")) {
                    Toast.makeText(AddActivity.this, "请填写作者名", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pressInput = ePress.getText().toString();
                if (pressInput.equals("")) {
                    Toast.makeText(AddActivity.this, "请填写出版社", Toast.LENGTH_SHORT).show();
                }
                int pagesInput;
                if (!ePages.getText().toString().equals("")) {
                    pagesInput = Integer.parseInt(ePages.getText().toString());
                } else {
                    Toast.makeText(AddActivity.this, "请填写页码", Toast.LENGTH_SHORT).show();
                    return;
                }

                float priceInput;
                if(!ePrice.getText().toString().equals("")) {
                    priceInput = Float.parseFloat(ePrice.getText().toString());
                } else {
                    Toast.makeText(AddActivity.this, "请填写价格", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                book.setName(nameInput);
                book.setAuthor(authorInput);
                book.setPages(pagesInput);
                book.setPress(pressInput);
                book.setPrice(priceInput);
                book.save();
                clearInput();
                Toast.makeText(AddActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clearInput() {
        eName.setText("");
        eAuthor.setText("");
        ePages.setText("");
        ePress.setText("");
        ePrice.setText("");
    }
}
