package com.example.lars.camelcupcalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class BoardTest {

    @Test
    public void testRoundWinner_selectTopCamel() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);
        board.set(Board.Field.BLUE, 1, 1);
        board.set(Board.Field.GREEN, 2, 0);
        board.set(Board.Field.ORANGE, 3, 0);
        board.set(Board.Field.WHITE, 3, 1);

        assertThat(board.roundWinner(), is(Board.Field.WHITE));
    }

    @Test
    public void testRoundWinner_selectFirst() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);
        board.set(Board.Field.BLUE, 3, 0);
        board.set(Board.Field.GREEN, 4, 0);
        board.set(Board.Field.ORANGE, 5, 0);
        board.set(Board.Field.WHITE, 6, 0);

        assertThat(board.roundWinner(), is(Board.Field.WHITE));
    }

    @Test
    public void testMovePlayer() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);

        board.movePlayer(Board.Field.YELLOW,2);

        assertThat(board.getField()[3][0], is(Board.Field.YELLOW));
        assertThat(board.getField()[1][0], is(Board.Field.EMPTY));
    }

    @Test
    public void testMovePlayer2() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);
        board.set(Board.Field.WHITE, 1, 1);
        board.set(Board.Field.BLUE, 3, 0);

        board.movePlayer(Board.Field.YELLOW,2);

        assertThat(board.getField()[3][1], is(Board.Field.YELLOW));
        assertThat(board.getField()[3][2], is(Board.Field.WHITE));
        assertThat(board.getField()[3][0], is(Board.Field.BLUE));

    }

    @Test
    public void testMovePlayer3() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 15, 0);
        board.set(Board.Field.WHITE, 15, 1);
        board.set(Board.Field.BLUE, 15, 2);

        board.movePlayer(Board.Field.WHITE,3);

        assertThat(board.getField()[15][0], is(Board.Field.YELLOW));
        assertThat(board.getField()[16][0], is(Board.Field.WHITE));
        assertThat(board.getField()[16][1], is(Board.Field.BLUE));
        assertThat(board.endWinner(), is(Board.Field.BLUE));

    }

    @Test
    public void testMovePlayer4() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);
        board.set(Board.Field.GREEN, 1, 1);

        board.setExtraField(4, Board.SpecialField.BACK);
        board.movePlayer(Board.Field.YELLOW,3);


        assertThat(board.getField()[3][0], is(Board.Field.YELLOW));
        assertThat(board.getField()[3][1], is(Board.Field.GREEN));

    }

    @Test
    public void testMovePlayer5() {
        Board board = new Board();
        board.set(Board.Field.YELLOW, 1, 0);
        board.set(Board.Field.GREEN, 1, 1);
        board.set(Board.Field.WHITE, 3, 0);

        board.setExtraField(4, Board.SpecialField.BACK);
        board.movePlayer(Board.Field.YELLOW,3);


        assertThat(board.getField()[3][0], is(Board.Field.YELLOW));
        assertThat(board.getField()[3][1], is(Board.Field.GREEN));
        assertThat(board.getField()[3][2], is(Board.Field.WHITE));

    }


}