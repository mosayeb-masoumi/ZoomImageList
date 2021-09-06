package com.example.zoomimageslider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImgItemInteraction {


      RecyclerView rv_images;
      ImageAdapter adapter;


      Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ImgModel> list = new ArrayList<>();
        list.add(new ImgModel("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/60576840e7d265198541a372_bavassano_homepage_gp.jpg" , null));
        list.add(new ImgModel("https://s3.amazonaws.com/images.seroundtable.com/google-shorts-1522934915.jpg", null ));
        list.add(new ImgModel("https://s3.amazonaws.com/images.seroundtable.com/google-shorts-1522934915.jpg", null ));
        list.add(new ImgModel("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/60576840e7d265198541a372_bavassano_homepage_gp.jpg",  null));
        list.add(new ImgModel("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/60576840e7d265198541a372_bavassano_homepage_gp.jpg",  null));
        list.add(new ImgModel("https://s3.amazonaws.com/images.seroundtable.com/google-shorts-1522934915.jpg",  null));
        list.add(new ImgModel("https://s3.amazonaws.com/images.seroundtable.com/google-shorts-1522934915.jpg",  null));
        list.add(new ImgModel("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/60576840e7d265198541a372_bavassano_homepage_gp.jpg",  null));
        list.add(new ImgModel("https://assets-global.website-files.com/6005fac27a49a9cd477afb63/60576840e7d265198541a372_bavassano_homepage_gp.jpg",  null));
        list.add(new ImgModel("https://s3.amazonaws.com/images.seroundtable.com/google-shorts-1522934915.jpg", null));



        rv_images = findViewById(R.id.rv_images);

        rv_images.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new ImageAdapter(list, this);
        adapter.setListener(this);
        rv_images.setAdapter(adapter);





        btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,SecondActivity.class)));

//        // to zoom all recyclerview
//        ZoomLayout myZoomView = new ZoomLayout(MainActivity.this);
////        rv_images.addView(myZoomView);
//        root.addView(myZoomView);

    }


    @Override
    public void imageItemOnClick(ImgModel model) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
        PhotoView photoView = mView.findViewById(R.id.imageView);
//        photoView.setImageResource(R.drawable.doll);
        photoView.setImageBitmap(model.bitmap);
        mBuilder.setView(mView);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}