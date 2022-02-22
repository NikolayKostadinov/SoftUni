import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(21);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(23);
    }

    @Test
    public void testLeftSideBST() {
        BinarySearchTree.Node<Integer> root = bst.getRoot();

        assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree.Node<Integer> left = root.getLeft();

        assertEquals(Integer.valueOf(5), left.getValue());

        BinarySearchTree.Node<Integer> left_left = left.getLeft();
        BinarySearchTree.Node<Integer> left_right = left.getRight();

        assertEquals(Integer.valueOf(1), left_left.getValue());
        assertEquals(Integer.valueOf(8), left_right.getValue());
    }

    @Test
    public void testRightSideBST() {
        BinarySearchTree.Node<Integer> root = bst.getRoot();

        assertEquals(Integer.valueOf(12), root.getValue());

        BinarySearchTree.Node<Integer> right = root.getRight();

        assertEquals(Integer.valueOf(21), right.getValue());

        BinarySearchTree.Node<Integer> right_left = right.getLeft();
        BinarySearchTree.Node<Integer> right_right = right.getRight();

        assertEquals(Integer.valueOf(18), right_left.getValue());
        assertEquals(Integer.valueOf(23), right_right.getValue());
    }

    @Test
    public void testSearchCheckReturnedTreeStructure() {
        BinarySearchTree<Integer> searched = bst.search(5);

        BinarySearchTree.Node<Integer> root = searched.getRoot();
        assertEquals(Integer.valueOf(5), root.getValue());

        BinarySearchTree.Node<Integer> left = root.getLeft();
        BinarySearchTree.Node<Integer> right = root.getRight();

        assertEquals(Integer.valueOf(1), left.getValue());
        assertEquals(Integer.valueOf(8), right.getValue());
    }

    @Test
    public void testEachInOrder() {
        // arrange
        List<Integer> expected = List.of(1, 5, 8, 12, 18, 21, 23);
        List<Integer> actual = new ArrayList<>();

        // act
        bst.eachInOrder(actual::add);

        // assert
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testContainsTrue() {
        assertTrue(bst.contains(5));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(bst.contains(100));
    }

    @Test
    public void testSearchFound() {
        List<Integer> expected = List.of(1, 5, 8);
        BinarySearchTree<Integer> result = bst.search(5);

        List<Integer> actual = new ArrayList<>();
        result.eachInOrder(actual::add);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }

        bst.insert(3);
        assertTrue(bst.contains(3));
        assertFalse(result.contains(3));
    }

    @Test
    public void testSearchNotFound() {
        BinarySearchTree<Integer> result = bst.search(100);
        assertNull(result);
    }

    @Test
    public void testRange() {
        // arrange
        List<Integer> expected = List.of(5, 8, 12, 18);
        // act
        List<Integer> actual = bst.range(5, 19);
        // assert
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testDeleteMin() {
        assertTrue(bst.contains(1));
        // act
        bst.deleteMin();
        // assert
        assertFalse(bst.contains(1));
    }

    @Test
    public void testDeleteMax() {
        assertTrue(bst.contains(23));
        // act
        bst.deleteMax();
        // assert
        assertFalse(bst.contains(23));
    }

    @Test
    public void testCount() {
        assertEquals(7, bst.count());
    }

    @Test
    public void testCounIncreaseAfterinsert() {
        bst.insert(100);
        assertEquals(8, bst.count());
    }

    @Test
    public void testCountDecreaseAfterDeleteMin() {
        bst.deleteMin();
        assertEquals(6, bst.count());
    }

    @Test
    public void testCountDecreaseAfterDeleteMax() {
        bst.deleteMax();
        assertEquals(6, bst.count());
    }

    @Test
    public void testRangeRoot(){
        assertEquals(3, bst.rank(12));
    }

    @Test
    public void testRangeEqualToSubNode(){
        assertEquals(5, bst.rank(21));
    }

    @Test
    public void testRangeBetweenNodes(){
        assertEquals(2, bst.rank(7));
    }

    @Test
    public void testRangeMaxLeave(){
        assertEquals(6, bst.rank(23));
    }

    @Test
    public void testRangeMinLeave(){
        assertEquals(0, bst.rank(1));
    }

    @Test
    public void testFloor(){
        assertEquals(Integer.valueOf(8), bst.floor(9));
    }

    @Test
    public void testCeil(){
        assertEquals(Integer.valueOf(12), bst.ceil(9));
    }
}