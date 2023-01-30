package com.teemu.teemu.truth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

import java.util.Random;

public class DifficultyActivity extends AppCompatActivity {

  //      private Button button, button2, button3, button4;
        public MainActivity ma;
        private CommonMethod commonMethod;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_difficulty);


            Button button = (Button)findViewById(R.id.btnKids);
            Button button2 = (Button)findViewById(R.id.btnTeens);
            Button button3 = (Button)findViewById(R.id.btnAdults);
            Button button4 = (Button)findViewById(R.id.btnCrazy);


            //Kids
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                startActivity(new Intent(DifficultyActivity.this, GameActivity.class));
                    commonMethod.player.stop();

                }
            });

            //Teens
            button2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DifficultyActivity.this, GameActivity2.class));
                    commonMethod.player.stop();
                }
            });

            //Adults
            button3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DifficultyActivity.this, GameActivity3.class));
                    commonMethod.player.stop();
                }
            });

            //Crazy
            button4.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DifficultyActivity.this, GameActivity4.class));
                    commonMethod.player.stop();
                }
            });
        }
    }
