package com.example.utilisateur.myfakenews;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AfficheNews extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webwiew_layout);

        //recuperation des infos transmises;
        Bundle bundle = getIntent().getExtras();
        String titre = bundle.getString("Titre");
        String news = bundle.getString("Article");


        //Lancement de l'actionBar
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //mise en place du titre de la news dans l'actionBar
        setTitle(titre);

        // lancement de la webview avec le contenu de l'acticle
        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadData(news, "text/html; charset=UTF-8", null);


    }
}
