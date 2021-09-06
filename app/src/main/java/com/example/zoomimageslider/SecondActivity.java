package com.example.zoomimageslider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.example.zoomimageslider.zoom.ZoomLayout;


public class SecondActivity extends AppCompatActivity implements ImgItemInteraction {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        RelativeLayout fl_zoom= findViewById(R.id.fl_zoom);
        ZoomLayout myZoomView = new ZoomLayout(this);
        fl_zoom.addView(myZoomView);

//        rv_images.setLayoutManager(new GridLayoutManager(this, 2));

    }

    @Override
    public void imageItemOnClick(ImgModel model) {

    }


}