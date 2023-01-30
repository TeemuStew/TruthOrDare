package com.teemu.teemu.truth;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
// KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS KIDS
    String[] mTestArray; //Dares
    String[] mTestArray2; //Truth

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    private Button button, button2;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        bottle = findViewById(R.id.bottle);
        button = findViewById(R.id.btnGame);
        button2 = findViewById(R.id.btnGame2);

        mTestArray = getResources().getStringArray(R.array.daresKids);
        mTestArray2 = getResources().getStringArray(R.array.truthsKids);

        button.setVisibility(View.GONE); //DARES
        button2.setVisibility(View.GONE); //TRUTH

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                 int rando = (int) (Math.random() * 37); // * x. X = niin paljon kuin on stringejä

                Toast toast = Toast.makeText(GameActivity.this, mTestArray[rando], Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP |Gravity.CENTER_HORIZONTAL, 0, 0);
                LinearLayout toastLayout = (LinearLayout) toast.getView();
                TextView toastTV = (TextView) toastLayout.getChildAt(0);
                toastTV.setTextSize(30);
                toast.show();
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int rando2 = (int) (Math.random() * 37); // * x. X = niin paljon kuin on stringejä

                Toast toast = Toast.makeText(GameActivity.this, mTestArray2[rando2], Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP |Gravity.CENTER_HORIZONTAL, 0, 0);
                LinearLayout toastLayout = (LinearLayout) toast.getView();
                TextView toastTV = (TextView) toastLayout.getChildAt(0);
                toastTV.setTextSize(30);
                toast.show();
            }
        });
    }

    public void spinBottle(View v) {
        if (!spinning) {
            int newDir = random.nextInt(1800);
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(1950); //2500
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                    button.setVisibility(View.GONE); //DARES
                    button2.setVisibility(View.GONE); //TRUTH

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.spinsound);
                    mediaPlayer.start();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                    button.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastDir = newDir;
            bottle.startAnimation(rotate);
        }
    }
}
