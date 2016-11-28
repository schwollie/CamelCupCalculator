package com.example.lars.camelcupcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = new Board();

        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

        TextView txt = (TextView) findViewById(R.id.textView);


    }

    void start() {

        for(int i = 0; i < 20;i++) {
            playgame();
        }

        Intent myIntent = new Intent(this, show_calculated.class);
        myIntent.putExtra("Yr", roundwinnerYellow);
        myIntent.putExtra("Ye", endwinnerYellow);
        myIntent.putExtra("Wr", roundwinnerWhite);
        myIntent.putExtra("We", endwinnerWhite);
        myIntent.putExtra("Br", roundwinnerBlue);
        myIntent.putExtra("Be", endwinnerBlue);
        myIntent.putExtra("Or", roundwinnerOrange);
        myIntent.putExtra("Oe", endwinnerOrange);
        myIntent.putExtra("Gr", roundwinnerGreen);
        myIntent.putExtra("Ge", endwinnerGreen);
        startActivity(myIntent);

    }

    public int roundwinnerYellow = 1;
    public int roundwinnerWhite = 1;
    public int roundwinnerBlue = 1;
    public int roundwinnerOrange = 1;
    public  int roundwinnerGreen = 1;

    public int endwinnerYellow = 1;
    public int endwinnerWhite = 1;
    public  int endwinnerBlue = 1;
    public  int endwinnerOrange = 1;
    public   int endwinnerGreen = 1;


    void setyellow() {
        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        int row2 = Integer.parseInt(stringrow);

        board.set(Board.Field.YELLOW, col2 -1, row2);
    }

    void setwhite() {
        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        int row2 = Integer.parseInt(stringrow);

        board.set(Board.Field.WHITE, col2 -1, row2 );
    }

    void setorange() {
        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        int row2 = Integer.parseInt(stringrow);

        board.set(Board.Field.ORANGE, col2 -1, row2);
    }

    void setgreen() {
        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        int row2 = Integer.parseInt(stringrow);

        board.set(Board.Field.GREEN, col2-1, row2);
    }

    void setblue() {
        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        int row2 = Integer.parseInt(stringrow);

        board.set(Board.Field.BLUE, col2-1, row2);
    }

    void setExtraFeld() {


        TextView txt = (TextView) findViewById(R.id.textView);
        EditText col = (EditText) findViewById(R.id.editText);
        EditText row = (EditText) findViewById(R.id.editText2);

        String stringcol = col.getText().toString();
        int col2 = Integer.parseInt(stringcol);

        String stringrow = row.getText().toString();
        String row2 = stringrow;


        board.setExtraField(col2-1, Board.SpecialField.valueOf(row2));
    }


    void playgame() {

        Board board2 = board.clone();

        board2.playRound();
        if (board2.roundWinner() == Board.Field.YELLOW) {
            roundwinnerYellow++;
        } else if (board2.roundWinner() == Board.Field.GREEN) {
            roundwinnerGreen++;
        } else if (board2.roundWinner() == Board.Field.BLUE) {
            roundwinnerBlue++;
        } else if (board2.roundWinner() == Board.Field.ORANGE) {
            roundwinnerOrange++;
        } else if (board2.roundWinner() == Board.Field.WHITE) {
            roundwinnerWhite++;
        }

        if(board2.endWinner() == null) {
            playgame();
        } else if(board2.endWinner() == Board.Field.YELLOW) {
            endwinnerYellow++;
        } else if(board2.endWinner() == Board.Field.GREEN) {
            endwinnerGreen++;
        } else if(board2.endWinner() == Board.Field.WHITE) {
            endwinnerWhite++;
        } else if(board2.endWinner() == Board.Field.ORANGE) {
            endwinnerOrange++;
        } else if(board2.endWinner() == Board.Field.BLUE) {
            endwinnerBlue++;
        }


    }


    int where = 0;

    @Override
    public void onClick(View view) {

        TextView txt = (TextView) findViewById(R.id.textView);


        if (view.getId() == R.id.button && where == 0) {
            setyellow();
            txt.setText("Camel : White");
            where++;

            return;

        }


        if (view.getId() == R.id.button && where == 1 ) {
            setwhite();
            txt.setText("Camel : Orange");
            where++;

            return;

        }

        if (view.getId() == R.id.button &&where == 2) {
            setorange();
            txt.setText("Camel : Green");
            where++;

            return;

        }

        if (view.getId() == R.id.button && where == 3) {
            setgreen();
            txt.setText("Camel : Blue");
            where++;

            return;

        }

        if (view.getId() == R.id.button && where == 4) {
            setblue();
            txt.setText("Extra Felder");
            EditText col = (EditText) findViewById(R.id.editText);
            EditText row = (EditText) findViewById(R.id.editText2);
            col.setText("Col");
            row.setText("FORWARD , BACK");
            where++;

            return;


        }

        if (view.getId() == R.id.button && where == 5) {
            setExtraFeld();
            EditText col = (EditText) findViewById(R.id.editText);
            EditText row = (EditText) findViewById(R.id.editText2);
            col.setText("Col");
            row.setText("Forward , Back");

            start();


        }

    }


}
