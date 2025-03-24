import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;


public class MyArrayList<E> {
  private final int DEFAULT_INITIAL_CAPACITY = 16;
  private Object[] data;
  private int size = 0;

  MyArrayList() {
    this.data = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  MyArrayList(int initialCapacity) {
    this.data = new Object[initialCapacity];
  }

  MyArrayList(Collection<? extends E> collection) {
    this.data = collection.toArray();
    this.size = collection.size();
  }


  public int size() {
    return size;
  }

  private void grow(int minCapacity) {
    if (data.length < minCapacity) {
      data = Arrays.copyOf(data, minCapacity);
    }
  }

  public void add(E element) {
    grow(size + 1);
    data[size] = element;
    size++;
  }

  public void add(int index, E element) {
    grow(size + 1);
    System.arraycopy(data, index,
        data, index + 1,
        size - index);
    data[index] = element;
    size++;
  }

  public E get(int index) {
    Objects.checkIndex(index, size);
    return (E) data[index];
  }

  public E remove(int index) {
    Objects.checkIndex(index, size);
    final E elementToRemove = (E) data[index];
    size--;
    if (size > index) {
      System.arraycopy(data, index + 1, data, index, size - index);
    }
    data[size] = null;

    return elementToRemove;
  }

  public boolean remove(Object o) {
    boolean found = false;
    int i = 0;

    if (o == null) {
      for (; i < size; i++) {
        if (data[i] == null) {
          found = true;
          break;
        }
      }
    } else {
      for (; i < size; i++) {
        if (o.equals(data[i])) {
          found = true;
          break;
        }
      }
    }

    if (found) remove(i);

    return found;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      result.append(data[i].toString());
      if (i < size - 1) {
        result.append(", ");
      }
    }
    result.append("]");
    return result.toString();
  }
}
