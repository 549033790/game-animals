package com.mwc.mygame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    LinearLayout linearLayoutStart;
    LinearLayout linearLayoutGame;
    Button buttonStart;
    Button buttonExit;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    TextView Score;
    TextView Time;
    TextView Question;
    TextView FinalScore;

    int[] images={R.drawable.cat_artboard,R.drawable.bird_artboard,R.drawable.fish_artboard,R.drawable.elephant_artboard,R.drawable.house_artboard,R.drawable.honey_artboard};
    int[] turn1={1,4,5,2};
    int[] turn2={3,0,5,1};
    int[] turn3={1,3,2,4};
    int turnNow=1;
    int score=0;

    CountDownTimer countDownTimer=new CountDownTimer(6000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //Score.setText(score);
            Time.setText(String.valueOf(millisUntilFinished/1000));
        }

        @Override
        public void onFinish() {
            nextTurn();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutStart=findViewById(R.id.linearLayout_start);
        linearLayoutGame=findViewById(R.id.linearLayout_game);
        buttonStart=findViewById(R.id.buttonStart);
        buttonExit=findViewById(R.id.buttonExit);
        imageView1=findViewById(R.id.image1);
        imageView2=findViewById(R.id.image2);
        imageView3=findViewById(R.id.image3);
        imageView4=findViewById(R.id.image4);
        Score=findViewById(R.id.textViewScore);
        Time=findViewById(R.id.textViewTime);
        Question=findViewById(R.id.textViewQuestion);
        FinalScore=findViewById(R.id.finalScore);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutStart.setVisibility(View.GONE);
                nextTurn();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turnNow-1==1){
                    score+=1;
                    nextTurn();
                    Score.setText(String.valueOf(score));
                }else if(turnNow==4) {
                    Toast.makeText(MainActivity.this, "Finished，Score:" + score, Toast.LENGTH_SHORT).show();
                    FinalScore.setText(String.valueOf(score));
                    linearLayoutGame.setVisibility(View.GONE);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    nextTurn();
                }


            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turnNow-1==2){
                    score+=1;
                    nextTurn();
                    Score.setText(String.valueOf(score));
                }else if(turnNow==4) {
                    Toast.makeText(MainActivity.this, "Finished，Score:" + score, Toast.LENGTH_SHORT).show();
                    FinalScore.setText(String.valueOf(score));
                    linearLayoutGame.setVisibility(View.GONE);
                } else{
                    Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    nextTurn();
                }

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turnNow-1==3){
                    score+=1;
                    Score.setText(String.valueOf(score));
                    Toast.makeText(MainActivity.this, "Finished，Score:" + score, Toast.LENGTH_SHORT).show();
                    FinalScore.setText(String.valueOf(score));
                    linearLayoutGame.setVisibility(View.GONE);
                }
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextTurn();
                Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void nextTurn(){
        if(turnNow==1){
            //turn1
            Question.setText("Please choose Bird");
            imageView1.setImageResource(images[turn1[0]]);
            imageView2.setImageResource(images[turn1[1]]);
            imageView3.setImageResource(images[turn1[2]]);
            imageView4.setImageResource(images[turn1[3]]);

            //启动计时
            countDownTimer.start();
            turnNow+=1;

        }else if(turnNow==2){
            //turn2
            Question.setText("Please choose Cat");
            imageView1.setImageResource(images[turn2[0]]);
            imageView2.setImageResource(images[turn2[1]]);
            imageView3.setImageResource(images[turn2[2]]);
            imageView4.setImageResource(images[turn2[3]]);

            //启动计时
            countDownTimer.start();
            turnNow+=1;
        }else if(turnNow==3){
            //turn3
            Question.setText("Please choose Fish");
            imageView1.setImageResource(images[turn3[0]]);
            imageView2.setImageResource(images[turn3[1]]);
            imageView3.setImageResource(images[turn3[2]]);
            imageView4.setImageResource(images[turn3[3]]);
            //启动计时
            countDownTimer.start();
            turnNow+=1;
        }
    }
}
