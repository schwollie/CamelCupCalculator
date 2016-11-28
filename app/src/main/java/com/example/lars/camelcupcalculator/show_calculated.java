package com.example.lars.camelcupcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lars on 28.11.2016.
 */
public class show_calculated extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculated_show);


        TextView Yround = (TextView)findViewById(R.id.Yround);
        TextView Yend = (TextView)findViewById(R.id.Yend);
        TextView Wround = (TextView)findViewById(R.id.Wround);
        TextView Wend = (TextView)findViewById(R.id.Wend);
        TextView Bround = (TextView)findViewById(R.id.blueround);
        TextView Bend = (TextView)findViewById(R.id.blueend);
        TextView Ground = (TextView)findViewById(R.id.Ground);
        TextView Gend = (TextView)findViewById(R.id.Gend);
        TextView Oround = (TextView)findViewById(R.id.Oround);
        TextView Oend = (TextView)findViewById(R.id.Oend);

        Intent mIntent = getIntent();
        double Yr = mIntent.getIntExtra("Yr", 1);
        double Ye = mIntent.getIntExtra("Ye", 1);
        double Wr = mIntent.getIntExtra("Wr", 1);
        double We = mIntent.getIntExtra("We", 1);
        double Gr = mIntent.getIntExtra("Gr", 1);
        double Ge = mIntent.getIntExtra("Ge", 1);
        double Br = mIntent.getIntExtra("Br", 1);
        double Be = mIntent.getIntExtra("Be", 1);
        double Or = mIntent.getIntExtra("Or", 1);
        double Oe = mIntent.getIntExtra("Oe", 1);






        double allRound = Yr+Wr+Or+Br+Gr;
        double allend = Ye+We+Oe+Be+Ge;


        Yround.setText(Yr/allRound*100 + "%");
        Wround.setText(Wr/allRound*100 + "%");
        Bround.setText(Br/allRound*100 + "%");
        Ground.setText(Gr/allRound*100 + "%");
        Oround.setText(Or/allRound*100 + "%");

        Yend.setText(Ye/allend*100 + "%");
        Wend.setText(We/allend*100 + "%");
        Bend.setText(Be/allend*100 + "%");
        Gend.setText(Ge/allend*100 + "%");
        Oend.setText(Oe/allend*100 + "%");








    }


    @Override
    public void onClick(View view) {

    }

}
