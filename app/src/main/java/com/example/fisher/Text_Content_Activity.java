package com.example.fisher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity{
    private TextView text_content;
    private int category = 0;
    private int position = 0;
    private ImageView iContent;
    private int [] array_dog_sluj = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_dog_decorat = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_dog_ohot = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_dog_zdorov = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_image_slujeb = {R.drawable.ovch,R.drawable.hiler,R.drawable.pincher,R.drawable.akita,R.drawable.malam};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.tv_main_content);
        iContent = findViewById(R.id.im_image_content);
        reciveIntent();
    }

    private void reciveIntent()
    {
        Intent i = getIntent();
        if (i != null )
        {
           category = i.getIntExtra("category", 0);
           position = i.getIntExtra("position", 0);
        }
        switch (category)
        {
            case 0:
                text_content.setText(array_dog_sluj[position]);
                iContent.setImageResource(array_image_slujeb[position]);
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
}
