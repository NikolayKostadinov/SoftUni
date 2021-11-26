package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = new Integer[]{1, 2, 3};

    @Test
    public void ctorCreatesDatabase() throws OperationNotSupportedException {
        // Arrange & Act
        Database db = new Database(ELEMENTS);

        // Assert
        Integer[] result = db.getElements();
        assertArrayEquals(ELEMENTS, result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ctorThrowsExceptionIfElementsCountIs0() throws OperationNotSupportedException {
        // Arrange & Act & Assert
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void ctorThrowsExceptionIfElementsCountIs17() throws OperationNotSupportedException {
        // Arrange & Act & Assert
        new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }

    @Test
    public void addAnElementAtTheNextFreeCell() throws OperationNotSupportedException {
        // Arrange
        Database db = new Database(ELEMENTS);
        // Act
        db.add(2);
        // Assert
        assertEquals(ELEMENTS.length + 1, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementThrowsException() throws OperationNotSupportedException {
        // Arrange
        Database db = new Database(ELEMENTS);
        // Act & Assert
        db.add(null);
    }

    @Test
    public void removeRemovesElementAtTheLastIndex() throws OperationNotSupportedException {
        // Arrange
        Database db = new Database(ELEMENTS);

        // Act
        db.remove();


        // Assert
        Integer[] result = db.getElements();
        assertArrayEquals(Arrays.copyOf(ELEMENTS,ELEMENTS.length-1), result);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDbThrowsException() throws OperationNotSupportedException {
        // Arrange
        Database db = new Database(1);

        // Act & Assert
        db.remove();
        db.remove();
    }


}