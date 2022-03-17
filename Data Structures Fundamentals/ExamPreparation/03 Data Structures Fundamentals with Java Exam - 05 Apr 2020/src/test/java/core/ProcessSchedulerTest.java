package core;

import model.ScheduledTask;
import model.Task;
import org.junit.Before;
import org.junit.Test;
import shared.Scheduler;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessSchedulerTest {
    private ProcessScheduler scheduler;

    @Before
    public void setUp() {
        this.scheduler = new ProcessScheduler();
        for (int i = 1; i <= 20; i++) {
            this.scheduler.add(new ScheduledTask(i, "test_description"));
        }
    }

    @Test
    public void testReverse() {
        this.scheduler.reverse();
        Task[] tasks = this.scheduler.toArray();
        for (int i = 0; i < tasks.length; i++) {
            assertEquals(tasks.length - i, tasks[i].getId());
        }
    }

    @Test
    public void testInsertBefore() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 42, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        this.scheduler.insertBefore(10, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testReschedule() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 11, 10, 13, 14, 15, 16, 17, 18, 19, 20};
        this.scheduler.reschedule(new ScheduledTask(10, ""), new ScheduledTask(12, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testSwap() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{20, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1};
        this.scheduler.reschedule(new ScheduledTask(1, ""), new ScheduledTask(20, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testClear() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{};
        this.scheduler.clear();
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertBeforeHead() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{42, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        this.scheduler.insertBefore(1, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(this.scheduler.peek().getId(), 42);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertBeforeTail() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 42, 20};
        this.scheduler.insertBefore(20, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(20, this.scheduler.getTailValue().getId());
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertAfter() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 42, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        this.scheduler.insertAfter(9, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertAfterHead() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 42, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        this.scheduler.insertAfter(1, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(this.scheduler.peek().getId(), 1);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testInsertAfterTail() {
        //int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 42};
        this.scheduler.insertAfter(20, new ScheduledTask(42, ""));
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(42, this.scheduler.getTailValue().getId());
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testContains() {
        assertTrue(this.scheduler.contains(new ScheduledTask(1, "")));
        assertTrue(this.scheduler.contains(new ScheduledTask(10, "")));
        assertTrue(this.scheduler.contains(new ScheduledTask(20, "")));
        assertFalse(this.scheduler.contains(new ScheduledTask(42, "")));
    }

    @Test
    public void testRemove() {
        assertTrue(this.scheduler.remove(new ScheduledTask(1, "")));
        assertEquals(19, this.scheduler.size());
        assertEquals(2, this.scheduler.peek().getId());

        int[] expected = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

        assertTrue(this.scheduler.remove(new ScheduledTask(10, "")));
        assertEquals(18, this.scheduler.size());

        expected = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

        assertTrue(this.scheduler.remove(new ScheduledTask(20, "")));
        assertEquals(17, this.scheduler.size());

        expected = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        actual = this.scheduler.toList().stream().mapToInt(Task::getId).toArray();
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsExc() {
        this.scheduler.remove(new ScheduledTask(42, ""));
    }


    @Test
    public void testPeekOnSingleElement() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(100, "test_description"));
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(100, task.getId());
    }

    @Test
    public void testPeekOnMultipleElement() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(73, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        scheduler.add(new ScheduledTask(100, "test_description"));
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(73, task.getId());
    }

    @Test
    public void testAddOnMultipleElement() {
        Task task = this.scheduler.peek();
        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals(20, this.scheduler.size());

        int expectedId = 1;
        while (this.scheduler.size() > 0) {
            Task process = this.scheduler.process();
            assertNotNull(process);
            assertEquals(expectedId++, process.getId());
        }
        assertEquals(21, expectedId);
    }

    @Test
    public void testAddOnSingleElement() {
        Scheduler scheduler = new ProcessScheduler();
        assertNull(scheduler.peek());
        assertEquals(0, scheduler.size());

        scheduler.add(new ScheduledTask(1, "test_description"));

        assertNotNull(scheduler.peek());
        assertEquals(1, scheduler.peek().getId());
        assertEquals(1, scheduler.size());
    }

    @Test
    public void testPeekShouldReturnCorrectAndShouldNotRemove() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(42, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        Task task = scheduler.peek();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(21, scheduler.size());
        task = scheduler.peek();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(21, scheduler.size());
    }

    @Test
    public void testProcessShouldReturnCorrectAndShouldRemove() {
        Scheduler scheduler = new ProcessScheduler();
        scheduler.add(new ScheduledTask(42, "test_description"));
        for (int i = 1; i <= 20; i++) {
            scheduler.add(new ScheduledTask(i, "test_description"));
        }
        Task task = scheduler.process();
        assertNotNull(task);
        assertEquals(42, task.getId());
        assertEquals(20, scheduler.size());
        task = scheduler.process();
        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals(19, scheduler.size());
    }

    @Test
    public void testProcessShouldReturnCorrect() {
        for (int i = 1; i <= 21; i++) {
            Task task = this.scheduler.process();
            int id = task != null ? task.getId() : 21;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNotExistingTask() {
        this.scheduler.remove(21);
    }

    private List<Task> generateReverseList() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 20; i > 0; i--) {
            tasks.add(new ScheduledTask(i, "test_description"));
        }
        return tasks;
    }

    @Test
    public void testReverse1() {
        scheduler.reverse();
        List<Task> tasks = scheduler.toList();
        List<Task> expected = generateReverseList();

        assertEquals(expected.size(), scheduler.size());

        for (int i = 0; i < expected.size(); i++) {
            Task actualTask = tasks.get(i);
            Task expectedTask = expected.get(i);
            assertEquals(expectedTask.getId(), actualTask.getId());
            assertEquals(expectedTask.getDescription(), actualTask.getDescription());
        }
    }

    @Test
    public void testFind() {
        Task task = scheduler.find(2);
        assertEquals(2, task.getId());
        assertEquals("test_description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindThrows() {
        Task task = scheduler.find(42);
    }

    @Test
    public void testReschedule1(){
        ProcessScheduler processScheduler = new ProcessScheduler();
        ScheduledTask task1 = new ScheduledTask(1, "task 1");
        ScheduledTask task2 = new ScheduledTask(2, "task 2");
        ScheduledTask task3 = new ScheduledTask(3, "task 3");
        processScheduler.add(task1);
        processScheduler.add(task2);
        processScheduler.add(task3);
        processScheduler.reschedule(task1, task3);

        Task[] tasks = processScheduler.toArray();

        assertEquals(3, tasks.length);

        assertEquals(task3.getDescription(),tasks[0].getDescription());
        assertEquals(task1.getDescription(),tasks[2].getDescription());
    }

    @Test
    public void testInsertAfterMiddle(){
        ProcessScheduler processScheduler = new ProcessScheduler();
        ScheduledTask task1 = new ScheduledTask(1, "task 1");
        ScheduledTask task2 = new ScheduledTask(2, "task 2");
        ScheduledTask task3 = new ScheduledTask(3, "task 3");
        processScheduler.add(task1);
        processScheduler.add(task2);
        processScheduler.add(task3);

        ScheduledTask task4 = new ScheduledTask(4, "task 4");
        processScheduler.insertAfter(2, task4);


        Task[] tasks = processScheduler.toArray();

        assertEquals(4, processScheduler.size());

        assertEquals(task4.getDescription(),tasks[2].getDescription());
    }

    @Test
    public void testInsertBeforeMiddle(){
        ProcessScheduler processScheduler = new ProcessScheduler();
        ScheduledTask task1 = new ScheduledTask(1, "task 1");
        ScheduledTask task2 = new ScheduledTask(2, "task 2");
        ScheduledTask task3 = new ScheduledTask(3, "task 3");
        processScheduler.add(task1);
        processScheduler.add(task2);
        processScheduler.add(task3);

        ScheduledTask task4 = new ScheduledTask(4, "task 4");
        processScheduler.insertBefore(2, task4);


        Task[] tasks = processScheduler.toArray();

        assertEquals(4, processScheduler.size());

        assertEquals(task4.getDescription(),tasks[1].getDescription());
    }


}
