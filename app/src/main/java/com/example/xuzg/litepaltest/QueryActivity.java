package com.example.xuzg.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //查所有的数据
        List<Book> books = DataSupport.findAll(Book.class);
        // 查第一条数据
//        Book firstBook = DataSupport.findFirst(Book.class);
        // 查最后一条数据
//        Book lastBook = DataSupport.findLast(Book.class);

        // 以下为连缀查询，可拼接起来使用
        // 查询指定列的数据
//        List<Book> bookColumns = DataSupport.select("name","author").find(Book.class);
        // 指定约束条件查询数据
//        List<Book> bookLimit = DataSupport.where("price < ?", "30").find(Book.class);
        // 指定排序查询数据
//        List<Book> bookOrder = DataSupport.order("price disc").find(Book.class);
        // 限制数量 指定偏移量 查询数据 （感觉可以做分页加载）
//        List<Book> result = DataSupport.limit(10).offset(10).find(Book.class);


        BookAdaper adaper = new BookAdaper(books);
        recyclerView.setAdapter(adaper);
    }
}
