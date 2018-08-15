package com.example.xuzg.litepaltest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookAdaper extends RecyclerView.Adapter<BookAdaper.ViewHolder> {
    private List<Book> bookList;

    public BookAdaper(List<Book> bookList1) {
        bookList = bookList1;
    }

    @NonNull
    @Override
    public BookAdaper.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.query_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdaper.ViewHolder viewHolder, int i) {
        Book book = bookList.get(i);
        String id = Integer.toString(book.getId());
        String pages = Integer.toString(book.getPages());
        String price = Float.toString(book.getPrice());

        viewHolder.itemId.setText(id);
        viewHolder.itemName.setText(book.getName());
        viewHolder.itemAuthor.setText(book.getAuthor());
        viewHolder.itemPress.setText(book.getPress());
        viewHolder.itemPrice.setText(price);
        viewHolder.itemPages.setText(pages);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemId;
        TextView itemName;
        TextView itemAuthor;
        TextView itemPress;
        TextView itemPages;
        TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemId = (TextView) itemView.findViewById(R.id.book_id_item);
            itemName = (TextView) itemView.findViewById(R.id.book_name_item);
            itemAuthor = (TextView) itemView.findViewById(R.id.book_author_item);
            itemPress = (TextView) itemView.findViewById(R.id.book_press_item);
            itemPages = (TextView) itemView.findViewById(R.id.book_pages_item);
            itemPrice = (TextView) itemView.findViewById(R.id.book_price_item);
        }
    }
}
