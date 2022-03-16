package core;

import model.HardwareOrder;
import model.Order;
import org.junit.Before;
import org.junit.Test;
import shared.Shop;

import static org.junit.Assert.*;

public class OnlineShopTest {

    private OnlineShop shop;

    @Before
    public void setUp() {
        this.shop = new OnlineShop();
        for (int i = 0; i < 10; i++) {
            shop.add(new HardwareOrder(i, "order " + i));
        }
    }

    @Test
    public void addExistIdMustBeSuccessful() {
        this.shop.add(new HardwareOrder(1, "order 1"));
        assertEquals(11, this.shop.size());
    }

    @Test
    public void getIndexCorrect() {
        Order order = this.shop.get(5);
        assertEquals(5, order.getId());
        assertEquals("order 5", order.getDescription());
    }

    @Test
    public void getContains() {
        assertTrue(this.shop.contains(new HardwareOrder(5,"")));
        assertFalse(this.shop.contains(new HardwareOrder(42,"")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexMinus1Correct() {
        Order order = this.shop.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndex100Correct() {
        Order order = this.shop.get(100);
    }

    @Test
    public void removeIndex() {
        assertTrue(this.shop.remove(5));
        assertEquals(this.shop.size(), 9);

        assertTrue(this.shop.remove(0));
        assertEquals(this.shop.size(), 8);

        assertTrue(this.shop.remove(shop.size() - 1));
        assertEquals(this.shop.size(), 7);

        assertFalse(this.shop.remove(42));
        assertEquals(this.shop.size(), 7);
    }

    @Test
    public void removeOrder() {
        assertTrue(this.shop.remove(new HardwareOrder(5,"order 5")));
        assertEquals(this.shop.size(), 9);

        assertTrue(this.shop.remove(new HardwareOrder(0,"order 0")));
        assertEquals(this.shop.size(), 8);

        assertTrue(this.shop.remove(new HardwareOrder(9,"order 9")));
        assertEquals(this.shop.size(), 7);

        assertFalse(this.shop.remove(new HardwareOrder(42,"order 42")));
        assertEquals(this.shop.size(), 7);
    }

    @Test
    public void toList() {
        assertEquals(this.shop.toList().size(), 10);
        this.shop.clear();
        assertEquals(this.shop.toList().size(), 0);
    }



    @Test
    public void testContainsShouldReturnTrue() {
        Shop shop = new OnlineShop();
        for (int i = 0; i < 20; i++) {
            shop.add(new HardwareOrder(i, "hardware_order"));
        }
        Boolean isPresent = shop.contains(new HardwareOrder(13, "hardware_order"));
        assertNotNull(isPresent);
        assertTrue(isPresent);
    }

    @Test
    public void testIndexOfShouldReturnCorrectValue() {
        Shop shop = new OnlineShop();
        for (int i = 0; i < 20; i++) {
            shop.add(new HardwareOrder(i, "hardware_order"));
        }
        int index = shop.indexOf(new HardwareOrder(13, "hardware_order"));
        assertEquals(13, index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByIndexShouldThrow() {
        Shop shop = new OnlineShop();
        for (int i = 0; i < 20; i++) {
            shop.add(new HardwareOrder(i, "hardware_order"));
        }
        shop.get(20);
    }

    @Test
    public void testGetByIndex() {
        Shop shop = new OnlineShop();
        for (int i = 0; i < 20; i++) {
            shop.add(new HardwareOrder(i, "hardware_order"));
        }
        Order order = shop.get(10);
        assertNotNull(order);
        assertEquals(10, order.getId());
    }

    @Test
    public void testAddMultipleElements() {
        Shop shop = new OnlineShop();
        assertEquals(0, shop.size());

        for (int i = 0; i < 100; i++) {
            shop.add(new HardwareOrder(i, "hardware_order"));
        }

        assertEquals(100, shop.size());
    }

    @Test
    public void testAddSingleElement() {
        Shop shop = new OnlineShop();

        Order order = new HardwareOrder(13, "hardware_order");

        assertEquals(0, shop.size());
        shop.add(order);

        assertEquals(1, shop.size());
        assertTrue(shop.contains(order));
    }

    @Test
    public void testSwap(){
        this.shop.swap(new HardwareOrder(2, ""), new HardwareOrder(6,""));
        Order order2 = this.shop.get(2);
        Order order6 = this.shop.get(6);
        assertEquals(6, order2.getId());
        assertEquals("order 6", order2.getDescription());
        assertEquals(2, order6.getId());
        assertEquals("order 2", order6.getDescription());
    }
}
