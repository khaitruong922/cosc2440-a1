package helper;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final String[] labels;
    private final List<String[]> rows = new ArrayList<>();
    private static final String sep = " | ";

    public Table(String[] labels) {
        this.labels = labels;
    }

    public void addRow(String[] row) {
        rows.add(row);
    }

    public void display() {
        printTableBorder();
        printTableRow(labels);
        printTableBorder();
        for (String[] row : rows) {
            printTableRow(row);
        }
        printTableBorder();
    }

    private void printTableRow(String[] row) {
        int[] columnsLength = getColumnsLength();
        System.out.print(sep);
        for (int i = 0; i < row.length; i++) {
            String field = row[i];
            System.out.print(field);
            printMultiple(" ", columnsLength[i] - field.length());
            System.out.print(sep);
        }
        System.out.println();
    }

    private int[] getColumnsLength() {
        int[] length = new int[labels.length];
        for (int i = 0; i < labels.length; i++) {
            length[i] = labels[i].length();
        }

        for (String[] row : rows) {
            for (int i = 0; i < labels.length; i++) {
                length[i] = Math.max(row[i].length(), length[i]);
            }
        }
        return length;
    }

    private void printTableBorder() {
        System.out.print(" ");
        printMultiple("-", getWidth() - 2);
        System.out.print(" ");
        System.out.println();
    }

    private int getWidth() {
        int width = (labels.length + 1) * sep.length();
        for (int columnLength : getColumnsLength()) {
            width += columnLength;
        }
        return width;
    }

    private static void printMultiple(String s, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(s);
        }
    }
}
