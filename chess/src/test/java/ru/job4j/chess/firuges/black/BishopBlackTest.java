package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest<expected> {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertEquals(bishopBlack.position(),Cell.C8);
    }

    @Test
    public void way() {
        BishopBlack bp2 = new BishopBlack(Cell.C1);
        assertThat(bp2.way(Cell.G5), is(new Cell[]{ Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void copy() {
       assertEquals(new BishopBlack(Cell.B1).copy(Cell.A2),new BishopBlack(Cell.A2));
    }
}