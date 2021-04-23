package com.example.fisher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Text_Content_Activity extends AppCompatActivity{
    private TextView text_content;
    private Typeface face1;
    private Toolbar toolbar;
    private int category = 0;
    private int position = 0;
    private ImageView iContent;

    private SharedPreferences def_pref;

    private ActionBar actionBar;

    private int [] array_dog_sluj = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_dog_decorat = {R.string.buldog, R.string.terjer, R.string.griffon, R.string.maltese, R.string.chihua};
    private int [] array_dog_ohot = {R.string.gonchaya, R.string.koker, R.string.setter, R.string.retriver, R.string.bigl};
    private int [] array_dog_zdorov = {R.string.ovcharka, R.string.hiler, R.string.pincher, R.string.akita, R.string.malamut};
    private int [] array_image_slujeb = {R.drawable.ovch,R.drawable.hiler,R.drawable.pincher,R.drawable.akita,R.drawable.malam};
    private int [] array_image_decor = {R.drawable.buldog,R.drawable.terier,R.drawable.griffon,R.drawable.maltese,R.drawable.chihua};
    private int [] array_image_ohota = {R.drawable.gonchaya,R.drawable.koker,R.drawable.setter,R.drawable.retriver,R.drawable.bigl};
  //  private int [] array_image_ohota = {R.drawable.gonchaya,R.drawable.koker,R.drawable.setter,R.drawable.retriver,R.drawable.bigl};
 //   private int [] array_image_ohota = {R.drawable.gonchaya,R.drawable.koker,R.drawable.setter,R.drawable.retriver,R.drawable.bigl};

    private String [] array_title_dog = {"Овчарка","Хилер","Пинчер","Акита","Маламут"};



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        reciveIntent();
    }

    private void init()
    {
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
      //  def_pref.getS
        text_content = findViewById(R.id.tv_main_content);
        iContent = findViewById(R.id.im_image_content);
        //обязательно написать инициализацию шрифта после инициализации текста контента
        face1 = Typeface.createFromAsset(this.getAssets(),"fonts/Lobster-Regular.ttf");
        text_content.setTypeface(face1);
        actionBar = getSupportActionBar();
        String text = def_pref.getString("main_text_size", "Средний");

        if (text != null) {
          switch (text) {
                case "Большой":
                    text_content.setTextSize(24);
                    break;
                case "Средний":
                    text_content.setTextSize(18);
                    break;
                case "Маленький":
                    text_content.setTextSize(14);
                    break;
            }
        }
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
        //        toolbar.setTitle(array_dog_sluj[position]);
                text_content.setText(array_dog_sluj[position]);
                iContent.setImageResource(array_image_slujeb[position]);
                actionBar.setTitle(array_title_dog[position]);
             //   actionBar.setTitle(array_title_dog[position]);

                break;
            case 1:
                text_content.setText(array_dog_decorat[position]);
                iContent.setImageResource(array_image_decor[position]);
                actionBar.setTitle(array_title_dog[position]);
                break;
            case 2:
                text_content.setText(array_dog_ohot[position]);
                iContent.setImageResource(array_image_ohota[position]);
                actionBar.setTitle(array_title_dog[position]);
                break;
            case 3:
                text_content.setText(array_dog_zdorov[position]);
                actionBar.setTitle(array_title_dog[position]);
              //  iContent.setImageResource([position]);
                break;
            case 4:
                text_content.setText(array_dog_ohot[position]);
                actionBar.setTitle(array_title_dog[position]);
             //   iContent.setImageResource(array_image_ohota[position]);
                break;
        }
    }



}
