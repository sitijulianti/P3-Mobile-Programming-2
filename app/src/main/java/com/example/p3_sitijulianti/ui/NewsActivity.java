package com.example.p3_sitijulianti.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
//import android.support.v4.view.ViewCompat;
import androidx.core.view.ViewCompat;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.p3_sitijulianti.R;
import com.example.p3_sitijulianti.util.Constans;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {

    private WebView mWebView;
    private ImageView imgDetail;
    private TextView txtTitleDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgDetail = findViewById(R.id.imgDetail);
        txtTitleDetail = findViewById(R.id.txtTitleDetail);
        mWebView = findViewById(R.id.wedData);

        //load title
        txtTitleDetail.setText(Constans.TITLE);

        //load image
        Picasso.get().load(Constans.IMAGE).into(imgDetail);

        //load description
        mWebView.loadDataWithBaseURL(null, "<head><style>img{max-width: 90%; width:auto; height: auto;}</style></head>" + Constans.DESCRIPTION, "text/html", "UTF-8", null);
    }
}