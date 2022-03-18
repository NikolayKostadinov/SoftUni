package implementations;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MaxHeapTest {
    private interfaces.Heap<Integer> maxHeap;

    @Before
    public void setUp() {
        this.maxHeap = new Heap<>();
        List<Integer> elements = new ArrayList<>(List.of(15, 25, 6, 9, 5, 8, 17, 16));
        for (Integer element : elements) {
            this.maxHeap.add(element);
        }
    }

    @Test
    public void testHeapifyUpAddOne() {
        interfaces.Heap<Integer> integerHeap = new Heap<>();
        integerHeap.add(13);
        assertEquals(Integer.valueOf(13), integerHeap.peek());
    }

    @Test
    public void testHeapifyUpAddMany() {
        assertEquals(Integer.valueOf(25), maxHeap.peek());
    }

    @Test
    public void testSizeShouldBeCorrect() {
        assertEquals(8, this.maxHeap.size());
    }

}
