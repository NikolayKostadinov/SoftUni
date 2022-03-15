package core;

import model.Message;
import model.TextMessage;
import org.junit.Before;
import org.junit.Test;
import shared.DataTransferSystem;

import java.util.List;

import static org.junit.Assert.*;

public class MessagingSystemTest {
    private List<Message> messages;

    private DataTransferSystem system;

    @Before
    public void setUp() {
        this.messages = List.of(
                new TextMessage(11, "test_text"),
                new TextMessage(6, "test_text"),
                new TextMessage(19, "test_text"),
                new TextMessage(4, "test_text"),
                new TextMessage(8, "test_text"),
                new TextMessage(17, "test_text")
        );

        this.system = new MessagingSystem();

        assertEquals(0, this.system.size());

        for (Message message : this.messages) {
            this.system.add(message);
        }
        var t = this.system;
    }

    @Test
    public void testAddSingleShouldWorkCorrectly() {
        DataTransferSystem system = new MessagingSystem();

        assertEquals(0, system.size());

        system.add(new TextMessage(12, "test_text"));

        assertEquals(1, system.size());
    }

    @Test
    public void testAddMultipleShouldWorkCorrectly() {
        DataTransferSystem system = new MessagingSystem();

        assertEquals(0, system.size());

        for (Message message : messages) {
            system.add(message);
        }

        assertEquals(messages.size(), system.size());
    }

    @Test
    public void testAddMultipleShouldSetCorrectElements() {
        assertEquals(messages.size(), system.size());
        Message lightest = system.getLightest();
        assertNotNull(lightest);
        assertEquals(4, lightest.getWeight());
        Message heaviest = system.getHeaviest();
        assertNotNull(heaviest);
        assertEquals(19, heaviest.getWeight());
    }

    @Test
    public void testGetPostOrderShouldReturnCorrectSequence() {
        List<Message> postOrder = this.system.getPostOrder();

        int[] expected = {4, 8, 6, 17, 19, 11};
        assertNotNull(postOrder);
        assertEquals(expected.length, postOrder.size());

        for (int i = 0; i < messages.size(); i++) {
            assertEquals(expected[i], postOrder.get(i).getWeight());
        }
    }

    @Test
    public void testGetPreOrderShouldReturnCorrectSequence() {
        List<Message> preOrder = this.system.getPreOrder();

        int[] expected = {11, 6, 4, 8, 19, 17};
        assertNotNull(preOrder);
        assertEquals(expected.length, preOrder.size());

        for (int i = 0; i < messages.size(); i++) {
            assertEquals(expected[i], preOrder.get(i).getWeight());
        }
    }

    @Test
    public void testGetInOrderShouldReturnCorrectSequence() {
        List<Message> inOrder = this.system.getInOrder();

        int[] expected = {4, 6, 8, 11, 17, 19};
        assertNotNull(inOrder);
        assertEquals(expected.length, inOrder.size());

        for (int i = 0; i < messages.size(); i++) {
            assertEquals(expected[i], inOrder.get(i).getWeight());
        }
    }

    @Test
    public void testGetLightestShouldReturnCorrect() {
        Message lightest = this.system.getLightest();
        assertNotNull(lightest);
        assertEquals(4, lightest.getWeight());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetLightestShouldReturnCorrectMany() {
        int[] expected = {4, 6, 8, 11, 17, 19};
        for (int i = 0; i < expected.length; i++) {
            Message lightest = this.system.getLightest();
            assertNotNull(lightest);
            assertEquals(expected[i], lightest.getWeight());
            this.system.deleteLightest();
        }

        this.system.deleteLightest();
    }

    @Test(expected = IllegalStateException.class)
    public void testGetHeaviestShouldReturnCorrectMany() {
        int[] expected = {19, 17, 11, 8, 6, 4};
        for (int i = 0; i < expected.length; i++) {
            Message heaviest = this.system.getHeaviest();
            assertNotNull(heaviest);
            assertEquals(expected[i], heaviest.getWeight());
            this.system.deleteHeaviest();
        }

        this.system.deleteHeaviest();
    }

    @Test
    public void testGetHeaviestShouldReturnCorrect() {
        Message heaviest = this.system.getHeaviest();
        assertNotNull(heaviest);
        assertEquals(19, heaviest.getWeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExistMustThrowException() {
        this.system.add(new TextMessage(17, "test_text"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByWeightMustThrowException() {
        this.system.getByWeight(56);
    }

    @Test
    public void testGetByWeigh() {
        TextMessage expected = new TextMessage(42, "test_text 42");
        this.system.add(expected);
        Message actual = this.system.getByWeight(expected.getWeight());

        assertEquals(expected.getWeight(), actual.getWeight());
        assertEquals(expected.getText(), actual.getText());
    }

    @Test
    public void testDeleteHeaviest() {
        Message message = this.system.deleteHeaviest();
        assertEquals(19, message.getWeight());
        assertEquals(5, this.system.size());

        message = this.system.deleteHeaviest();
        assertEquals(17, message.getWeight());
        assertEquals(4, this.system.size());

    }

    @Test
    public void testDeleteLightest() {
        Message message = this.system.deleteLightest();
        assertEquals(4, message.getWeight());
        assertEquals(5, this.system.size());

        message = this.system.deleteLightest();
        assertEquals(6, message.getWeight());
        assertEquals(4, this.system.size());
    }

    @Test
    public void testOrderByWait() {
        int[] expected = {4, 6, 8, 11, 17, 19};
        Message[] actual = this.system.getOrderedByWeight().toArray(new Message[this.system.size()]);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
           assertEquals(expected[i], actual[i].getWeight());
        }
    }

    @Test
    public void testContainsMustReturnTrueIfContains(){
        assertTrue(this.system.contains(new TextMessage(11, "text message")));
    }

    @Test
    public void testContainsMustReturnFalseIfNotContains(){
        assertFalse(this.system.contains(new TextMessage(42, "text message")));
    }

    @Test
    public void testGetOrderedByWeightMustReturnEmptyList(){
        MessagingSystem messagingSystem = new MessagingSystem();
        List<Message> orderedByWeight = messagingSystem.getOrderedByWeight();
        assertEquals(0, orderedByWeight.size());
    }



}
