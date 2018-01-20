package com.example.utilisateur.myfakenews;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;
import java.util.Map;


import static java.security.AccessController.getContext;

/**
 * Created by utilisateur on 19/01/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<FakeNews> list = FakeNewsList.all;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listviewfake, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FakeNews fake = list.get(position);
        holder.display(fake);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private FakeNews currentFake;

        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.ListViewViewName));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // lancer la nouvelle activity
                    Intent intent = new Intent( itemView.getContext(), AfficheNews.class);
                    intent.putExtra("Titre", currentFake.title);
                    intent.putExtra("Article", currentFake.htmlContent);
                    itemView.getContext().startActivity(intent);

                }
            });
        }

        public void display(FakeNews fake) {
            //affichage de la news
            currentFake = fake;
            name.setText(fake.title);

        }
    }
}
