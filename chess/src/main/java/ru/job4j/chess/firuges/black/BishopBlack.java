package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Objects;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Нельзя передвинуть по диагонали от %s до %s", position, dest)
            );
        }
        int size = Math.abs(position().getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position().getX() < dest.getX() ? 1 : -1;
        int deltaY = position().getY() < dest.getX() ? 1 : -1;
        int x = position().getX();
        int y = position().getY();
        for (int i = 0; i < size; i++) {
            x += deltaX;
            y += deltaY;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(dest.getX()) - source.getX() == Math.abs(dest.getY() - source.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
