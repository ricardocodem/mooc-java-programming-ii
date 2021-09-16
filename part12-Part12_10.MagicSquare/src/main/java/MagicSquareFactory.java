
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm here
        //starting position for the m.square
        int row = 0;
        //first value is in the middle box of the top row
        int column = size / 2;
        //put number 1 int in the middle box of the top row
        int number = 1;
        square.placeValue(row, column, number);

        while (number <= size * size) {
            number++;
            int currentRow = row;
            int currentColumn = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = size - 1;
            }
            if (column == size) {
                column = 0;
            }
            if (square.readValue(row, column) != 0) {
                row = currentRow + 1;
                column = currentColumn;
                if (row == -1) {
                    row = size - 1;
                }
            }
            square.placeValue(row, column, number);
        }
        return square;
    }
}
