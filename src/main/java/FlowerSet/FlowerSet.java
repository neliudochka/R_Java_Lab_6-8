package FlowerSet;

import flower.Flower;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Represents a collection that contains no duplicate elements. It models the mathematical set abstraction.
 * This implementation uses an array to store elements and provides basic set operations.
 *
 * Flower is the type of elements maintained by this set
 */
public class FlowerSet implements Set<Flower> {
    public int INITIAL_NUMBER_OF_ELEMENTS = 15;
    final private int PERCENTAGE_TO_INCREASE = 30;
    private Flower[] elements;
    private int size;
    /**
     * Constructs an empty FlowerSet with an initial number of elements.
     */
    public FlowerSet() {
        this.elements = new Flower[INITIAL_NUMBER_OF_ELEMENTS];
        this.size = 0;
    }

    /**
     * Constructs a FlowerSet containing the specified flower.
     *
     * @param flower the flower to be added to the set
     */
    public FlowerSet(Flower flower) {
        this.elements = new Flower[INITIAL_NUMBER_OF_ELEMENTS];
        this.size = 0;
        add(flower);
    }

    /**
     * Constructs a FlowerSet containing elements of the specified collection.
     *
     * @param collection the collection whose elements are to be placed into this set
     */
    public FlowerSet(Collection<Flower> collection) {
        this.elements = new Flower[INITIAL_NUMBER_OF_ELEMENTS];
        this.size = 0;
        if(collection.isEmpty()) return;
        addAll(collection);
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if this set contains no elements.
     *
     * @return {@code true} if this set contains no elements, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Checks if this set contains the specified object.
     *
     * @param o the object to be checked for presence in this set
     * @return {@code true} if this set contains the specified object, {@code false} otherwise
     */
    @Override
    public boolean contains(Object o) {
        if (size == 0) return false;
        return Arrays.stream(elements)
                .limit(size)
                .anyMatch(element ->
                        (element == null && o == null)
                                || (element != null && element.equals(o)));}

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator over the elements in this set
     */
    @NotNull
    @Override
    public Iterator<Flower> iterator() {
        return new FlowerSetIterator();
    }

    /**
     * Private inner class that implements the Iterator interface for FlowerSet.
     */
    private class FlowerSetIterator implements Iterator<Flower> {
        private int currentIndex = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Flower next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the set");
            }
            return elements[currentIndex++];
        }

        /**
         * Removes the last element returned by the iterator from the underlying collection.
         *
         * @throws IllegalStateException  if the {@code next} method has not yet been called, or
         *                                  if the {@code remove} method has already been called
         *                                  after the last call to the {@code next} method
         * @throws NoSuchElementException if the iteration has no more elements
         */
        //для ремува
        @Override
        public void remove() {
            if (currentIndex <= 0) {
                throw new IllegalStateException("next() has not been called, or remove() has been called more than once for the current element");
            }
            FlowerSet.this.remove(elements[currentIndex - 1]);
            currentIndex--;
        }
    }

    /**
     * Returns an array containing all the elements in this set.
     *
     * @return an array containing all the elements in this set
     */
    @NotNull
    @Override
    public Object @NotNull [] toArray() {
        return Arrays.copyOf(this.elements, size);
    }

    /**
     * Returns an array containing all the elements in this set.
     *
     * @param a the array into which the elements of this set are to be stored, if it is large enough;
     *          otherwise, a new array of the same runtime type is allocated for this purpose
     * @param <T> the runtime type of the array to contain the collection
     * @return an array containing all the elements in this set
     * @throws ArrayStoreException if the runtime type of the specified array is not a supertype
     *                             of the runtime type of every element in this set
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T @NotNull [] toArray(@NotNull T @NotNull [] a) {
        if (a.length < size) {
            return Arrays.copyOf(elements, size, (Class<? extends T[]>) a.getClass());
        } else {
            System.arraycopy(elements, 0, a, 0, size);
            if (a.length > size) {
                a[size] = null;
            }
            return a;
        }
    }

    /**
     * Adds the specified flower to this set if it is not already present.
     *
     * @param flower the flower to add to this set
     * @return {@code true} if this set did not already contain the specified flower,
     *         {@code false} otherwise (if the flower is already present in the set)
     */

    @Override
    public boolean add(Flower flower) {
        if(contains(flower))
            return false;

        if(size != 0 && size == elements.length) {
            increaseCapacity();
        }

        if (flower != null)
            this.elements[size] = flower;
        size++;
        //System.out.println(elements.length);
        return true;
    }

    private void increaseCapacity() {
        int newCapacity = size + size*PERCENTAGE_TO_INCREASE/100;
        this.elements = Arrays.copyOf(elements, newCapacity);
    }


    /**
     * Removes the specified object from this set.
     *
     * @param o the object to be removed from this set
     * @return {@code true} if this set contained the specified object,
     *         {@code false} otherwise (if the object is not present in the set)
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    removeElementAtIndex(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {

                    removeElementAtIndex(i);
                    return true;
                }
            }
        }
        return false;
    }

    //видалити з індекса
    private void removeElementAtIndex(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size] = null;
        size--;
    }


    /**
     * Checks if all elements in the specified collection are present in this set.
     *
     * @param c collection containing elements to be checked for presence in this set
     * @return {@code true} if this set contains all the elements in the specified collection,
     *         {@code false} otherwise (if any element is not present in the set)
     */
    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all the elements from the specified collection to this set if they are not already in it.
     *
     * @param c the collection containing elements to be added to this set
     * @return {@code true} if this set was modified as a result of the operation,
     *         {@code false} otherwise (if no elements were added)
     */
    @Override
    public boolean addAll(@NotNull Collection<? extends Flower> c) {
        boolean flag = false;
        for (Flower flower : c) {
            if (add(flower)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c the collection of elements to be retained in this set
     * @return {@code true} if this set was modified as a result of the operation,
     *         {@code false} otherwise (if no elements were removed)
     */
    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        boolean flag = false;
        Iterator<Flower> iterator = iterator();
        while (iterator.hasNext()) {
            Flower element = iterator.next();
            if (!c.contains(element)) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Removes from this set all the elements that are contained in the specified collection.
     *
     * @param c the collection containing elements to be removed from this set
     * @return {@code true} if this set was modified as a result of the operation,
     *         {@code false} otherwise
     */
    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        boolean flag = false;
        Iterator<Flower> iterator = iterator();
        while (iterator.hasNext()) {
            Flower element = iterator.next();
            if (c.contains(element)) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Removes all the elements from this set. The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        this.elements = new Flower[INITIAL_NUMBER_OF_ELEMENTS];
        this.size = 0;
    }

    /**
     * Returns a string representation of the elements in this set.
     *
     * @return a string representation of the elements in this set
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("FlowerSet { ");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append(" }");
        return result.toString();
    }
}
