package com.example.braingame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    int numOfImage, column,levelNo,row;
    ArrayList<String> imgList=new ArrayList<>();
    List<String> arrayList;
    ImageAdapter imageAdapter;
    RelativeLayout relativeLayout;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.re_img);
        Config.seekBar=findViewById(R.id.seekbar);

        if (Config.outerLevel == 1) {
            Config.seekBar.setVisibility(View.GONE);
            levelNo = getIntent().getIntExtra("level", 0);
            if (levelNo > 0 && levelNo <= 3) {
                numOfImage = 6;
                column = 3;
                System.out.println("1-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            } else if (levelNo > 3 && levelNo <= 7) {
                numOfImage = 8;
                column = 4;
                System.out.println("2-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            } else if (levelNo > 7) {
                numOfImage = 10;
                column = 5;
                row = 5;
                System.out.println("3-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            }
            String[] images = new String[0];
            try {
                images = getAssets().list("");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                e.printStackTrace();
            }

            arrayList = imgList.subList(0, numOfImage);
            arrayList.addAll(arrayList);

            Collections.shuffle(arrayList);
            imageAdapter = new ImageAdapter(this, arrayList);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity3.this, column);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(imageAdapter);
        }
        if (Config.outerLevel == 2) {

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                Config.seekBar.setMin(0);
//            }
            if (getIntent().getExtras()!=null)
            {
                Config.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        seekBar.setMin(0);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
            Config.seekBar.setMax(120);
            Config.seekBar.setVisibility(View.VISIBLE);
            Timer timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run()
                {
                    Config.t++;
                    Config.seekBar.setProgress(Config.t);
                }
            }, 1000, 100);
            if(Config.seekBar.getProgress()==120)
            {
                relativeLayout.setClickable(false);


            }

            levelNo = getIntent().getIntExtra("level", 0);
            if (levelNo > 0 && levelNo <= 3) {
                numOfImage = 6;
                column = 3;
                System.out.println("1-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            } else if (levelNo > 3 && levelNo <= 7) {
                numOfImage = 8;
                column = 4;
                System.out.println("2-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            } else if (levelNo > 7) {
                numOfImage = 10;
                column = 5;
                row = 5;
                System.out.println("3-No of images=" + numOfImage + "\t" + "num of Columns=" + column);
            }

            String[] images = new String[0];
            try {
                images = getAssets().list("");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                e.printStackTrace();
            }

            arrayList = imgList.subList(0, numOfImage);
            arrayList.addAll(arrayList);

            Collections.shuffle(arrayList);
            imageAdapter = new ImageAdapter(this, arrayList);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity3.this, column);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(imageAdapter);
        }
    }

}