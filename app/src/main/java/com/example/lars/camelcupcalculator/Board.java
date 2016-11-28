package com.example.lars.camelcupcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Lars on 27.11.2016.
 */
public class Board {
    //declare properties
    private static final int HEIGHT = 5;
    private static final int LENGHT = 17;
    private Field[][] field;

    enum Field {
        EMPTY, YELLOW, GREEN, WHITE, ORANGE, BLUE
    }

    enum SpecialField {
        EMPTY, BACK, FORWARD
    }

    HashMap<Integer, SpecialField> hm = new HashMap<>();

    void setExtraField(int col, SpecialField sp) {
        hm.put(col,sp);
    }




    public int getHeight() {
        return HEIGHT;
    }
    public int getLenght() {
        return LENGHT;
    }
    public Field[][] getField() {
        return field;
    }


    //create constructor
    public Board(){
        field =  createEmptyBoard();
    }

    private Board(Field[][] field) {
        this.field = field;
    }

    //creates a method that visualizes the field with the ships
    Field[][] createEmptyBoard(){
        Field[][] field = new Field[LENGHT][HEIGHT];
        for(int col = 0; col < this.getLenght(); col++){
            for(int row = 0; row < this.getHeight(); row++){
                field[col][row] = Field.EMPTY;
            }
        }
        return field;
    }


    Field roundWinner() {
        for(int col = LENGHT-1; col >= 0; col--){
            if(field[col][0]!=Field.EMPTY) {
                for(int row = HEIGHT-1; row >= 0; row--){
                    if(field[col][row]!=Field.EMPTY) {
                        return field[col][row];
                    }

                }
            }
        }

        return Field.EMPTY;
    }


    Field endWinner() {
        for(int row = HEIGHT-1;row >= 0 ;row--) {
            if (field[LENGHT-1][row] != Field.EMPTY) {
                return field[LENGHT-1][row];
            }
        }

        return null;
    }

    void set(Field camel, int pos,int height) {
        field[pos][height] = camel;

    }



    void movePlayer(Field player, int zug) {
        for(int col = 0; col < this.getLenght(); col++){
            for(int row = 0; row < this.getHeight(); row++) {
                if(field[col][row]==player) {
                    int startColumn = col;
                    int destinationColumn = Math.min(col + zug, LENGHT - 1);
                    if(hm.get(destinationColumn)==SpecialField.FORWARD) {
                        destinationColumn = Math.min(col + zug + 1, LENGHT - 1);
                    } else if(hm.get(destinationColumn)==null){

                    } else {
                        destinationColumn = Math.min(col + zug -1, LENGHT - 1);
                        int isda = 0;
                        for(int row2 = HEIGHT-1;row2 >= 0; row2--){
                            if(field[destinationColumn][row2]!=Field.EMPTY) {
                                field[destinationColumn][4-isda]= field[destinationColumn][row2];
                                field[destinationColumn][row2] = Field.EMPTY;

                                isda++;
                            }
                        }

                    }



                    int startRow = row;
                    int destinationRow = 0;
                    for(destinationRow = 0;destinationRow < this.getHeight();destinationRow++) {
                        if(field[destinationColumn][destinationRow]==Field.EMPTY) {
                            break;
                        }
                    }
                    while(field[startColumn][startRow]!=Field.EMPTY) {
                        field[destinationColumn][destinationRow] = field[startColumn][startRow];
                        field[startColumn][startRow] = Field.EMPTY;
                        destinationRow = Math.min( destinationRow++, 4);
                        startRow = Math.min( startRow++, 4);



                    }

                    for(int i = 4;i >= 0;i--) {
                        aplyGravity();

                    }





                    return;
                }
            }
        }

    }


    void aplyGravity() {
        for(int col = 0; col < LENGHT-1;col++) {
            for(int row = 1; row < HEIGHT;row++) {
                if(field[col][row]!=Field.EMPTY&&field[col][row-1]==Field.EMPTY) {
                        field[col][row-1]= field[col][row];
                        field[col][row]= Field.EMPTY;
                }
            }
        }
    }


    void playRound() {
        List<Field> reihenfolge = Arrays.asList(Field.YELLOW, Field.WHITE, Field.BLUE,Field.GREEN, Field.ORANGE);
        Collections.shuffle(reihenfolge);

        Random rnd = new Random();

        int zug = 1 + rnd.nextInt(3);
        movePlayer(reihenfolge.get(0), zug);

        zug = 1 + rnd.nextInt(3);
        movePlayer(reihenfolge.get(1), zug);

        zug = 1 + rnd.nextInt(3);
        movePlayer(reihenfolge.get(2), zug);

        zug = 1 + rnd.nextInt(3);
        movePlayer(reihenfolge.get(3), zug);

        zug = 1 + rnd.nextInt(3);
        movePlayer(reihenfolge.get(4), zug);

        roundWinner();
        endWinner();



    }

    public Board clone() {
        Field[][] field = new Field[LENGHT][HEIGHT];
        for (int row = 0; row < LENGHT; row++) {
            System.arraycopy(this.field[row], 0, field[row], 0, HEIGHT);
        }
        return new Board(field);
    }



}


