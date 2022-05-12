package q1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyList<E> implements List<E>, Iterator<E> {
	
	/*	REFERENCES
	Katleman. (n.d.). JDK8/JDK8/JDK: 687FD7C7986D SRC/share/classes/java/UTIL/arraylist.java. 
	Retrieved February 3, 2022, from https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java 
	*/
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private int size;
	transient Object[] elementData;

	public MyList() {
		super();
		this.elementData=EMPTY_ELEMENTDATA;
	}

	public MyList(int size) {
		super();
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
		
		return indexOf(o) >= 0;
	}
	
	@Override
	public boolean add(E e) {
		
        elementData = Arrays.copyOf(elementData, DEFAULT_CAPACITY);
		
		elementData[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
	}

	@Override
	public E get(int index) {
		return (E) elementData[index];
	}

	@Override
	public void add(int index, E element) {
		 System.arraycopy(elementData, index, elementData, index + 1, size - index);
		 elementData[index] = element;
		 size++;
	}

	@Override
	public E remove(int index) {
		E oldValue = (E) elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null; 

        return oldValue;
	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		size = 0;
		return this;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() {
		return (size < elementData.length && elementData[size] != null);
	}

	@Override
	public E next() {
		if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (E) elementData[size++];
	}
}
