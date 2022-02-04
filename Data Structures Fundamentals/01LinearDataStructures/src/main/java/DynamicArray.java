import java.util.*;

public class DynamicArray<E> implements List<E> {
    public static final int NOT_FOUND = -1;
    public static final int INITIAL_SIZE = 1;
    private Object[] elements;
    private int size;

    public DynamicArray(Object[] elements) {
        this.elements = elements;
        size = this.elements.length;
    }

    public DynamicArray() {
        this(new Object[0]);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        for (Object element : elements) {
            if (element.equals(o)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        a = Arrays.copyOf(a, size);
        for (int i = 0; i < this.size; i++) {
            a[i] = (T) this.elements[i];
        }
        return a;
    }

    @Override
    public boolean add(E t) {
        if (isElementsFull()) {
            this.elements = grow();
        }
        elements[this.size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (Arrays.stream(this.elements)
                    .noneMatch(e -> e.equals(o))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e : c) {
            this.add(index, e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            this.remove(o);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        for (int i = 0; i < this.size; i++) {
            Object element = this.elements[i];
            if (c.stream().noneMatch(e -> e.equals(element))) {
                this.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        this.elements = new Object[INITIAL_SIZE];
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (isElementsFull()) {
            this.elements = grow();
        }
        this.size++;

        for (int i = index; i < this.size; i++) {
            this.elements[index + 1] = this.elements[index];
        }
        this.elements[index] = element;
    }

    private boolean isElementsFull() {
        return this.size >= this.elements.length;
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        this.checkIndex(index);
        return (E) this.elements[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        this.checkIndex(index);
        E oldElement = (E) this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        this.checkIndex(index);
        E removedElement = (E) this.elements[index];
        if (size - index >= 0) {
            System.arraycopy(elements, index - 1, elements, index, size - index);
        }
        elements[size - 1] = null;
        this.size--;
        ensureCapacity();
        return removedElement;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index out of bounds: %d for size: %d", index, this.size)
            );
        }
    }


    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    @Override
    public int indexOf(Object o) {
        int result = NOT_FOUND;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(o)) {
                result = i;
                break;
            }
        }

        return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = NOT_FOUND;
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(o)) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListIterator<>() {
            private int ix = index;

            @Override
            public boolean hasNext() {
                return this.ix < size();
            }

            @Override
            public E next() {
                return get(ix++);
            }

            @Override
            public boolean hasPrevious() {
                return this.ix > 0;
            }

            @Override
            public E previous() {
                return get(ix--);
            }

            @Override
            public int nextIndex() {
                return ix++;
            }

            @Override
            public int previousIndex() {
                return ix--;
            }

            @Override
            public void remove() {
                DynamicArray.this.remove(ix);
            }

            @Override
            public void set(E e) {
                elements[ix] = e;
            }

            @Override
            public void add(E e) {
                DynamicArray.this.add(ix, e);
            }
        };
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return new DynamicArray<>(Arrays.copyOfRange(this.elements, fromIndex, toIndex));
    }


}
