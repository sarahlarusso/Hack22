package general;

import java.util.*;

/**
 * Maintains a doubly-linked List- and HashSet-organized data structure
 * @param <Value> the target object
 */
public class HashList<Value> implements Iterable<Value> {
    private final HashMap<Value, HashNode<Value>> map;
    private HashNode<Value> head, tail;

    /**
     * Creates a HashList
     */
    public HashList() {
        this.map = new HashMap<>();
    }

    /**
     * Creates a HashList
     * @param values the list of starter values for this HashList
     */
    public HashList(Iterable<Value> values) {
        HashList<Value> hashList = new HashList<>();
        hashList.addAll(values);
        this.map = hashList.map;
        this.head = hashList.head;
        this.tail = hashList.tail;
    }

    /**
     * Adds a HashNode into this HashList
     * @param value the target Value
     */
    public boolean add(Value value) {
        if(this.map.containsKey(value)) {
            return false;
        }
        HashNode<Value> hashNode = new HashNode<>(value);
        if(this.head == null) {
            this.head = hashNode;
        } else {
            this.tail.next = hashNode;
            hashNode.prev = this.tail;
        }
        this.tail = hashNode;
        this.map.put(value, hashNode);
        return true;
    }

    /**
     * Adds a List of HashNodes into this HashList
     * @param iterable the target Iterable
     * @return true if all new elements were not previously contained in this HashList, else false
     */
    public boolean addAll(Iterable<Value> iterable) {
        boolean allElementsAreOriginal = true;
        for(Value value : iterable) {
            allElementsAreOriginal &= add(value);
        }
        return allElementsAreOriginal;
    }

    /**
     * Inserts a HashNode into this HashList at the specified index
     * @param index the index of this HashList
     * @param value the target Value
     * @throws IndexOutOfBoundsException if the insertion index is not included in the HashList
     */
    public boolean insert(int index, Value value) {
        if(this.map.containsKey(value)) {
            return false;
        }
        int size = size();
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if(index == size) {
            add(value);
        } else {
            final int iterations = Math.min(index, size - index + 1);
            HashNode<Value> cursor = (iterations == index) ? this.head : this.tail;
            for(int i = 0; i < iterations; i++) {
                cursor = (iterations == index) ? cursor.next : cursor.prev;
            }
            HashNode<Value> hashNode = new HashNode<>(value);
            hashNode.prev = cursor.prev;
            if(cursor.prev == null) {
                this.head = hashNode;
            } else {
                hashNode.prev.next = hashNode;
            }
            cursor.prev = hashNode;
            hashNode.next = cursor;
            this.map.put(value, hashNode);
        }
        return true;
    }

    /**
     * Checks if this HashList contains a Key
     * @param value the target value
     * @return true if this HashList contains the target Key, else false
     */
    public boolean contains(Value value) {
        return this.map.containsKey(value);
    }

    /**
     * Gets the Value located in the HashNode of a specific Key
     * @return the desired Value
     */
    public Value get(Value value) {
        return this.map.get(value).value;
    }

    /**
     * Gets the Value located at a specific index in this HashList
     * @param index the target index
     * @return the target Value
     */
    public Value get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            HashNode<Value> cursor = this.head;
            int currentIndex = 0;
            while(currentIndex < index) {
                cursor = cursor.next;
                currentIndex++;
            }
            return cursor.value;
        }
    }

    /**
     * Clears this HashList
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.map.clear();
    }

    /**
     * Determines if this HashList contains all Values in a specified HashList
     * @param c the target HashList
     * @return true if all Values in the HashList are in this HashList, else false
     */
    public boolean containsAll(HashList<? extends Value> c) {
        for(Value value : c) {
            if(contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes a specific element from this HashList
     * @param value the target Value
     * @return true if an element was successfully removed, else false
     */
    public boolean remove(Value value) {
        HashNode<Value> removedItem = this.map.get(value);
        if(removedItem == null) {
            return false;
        }
        if(removedItem.prev == null) {
            this.head = removedItem.next;
        } else {
            removedItem.prev.next = removedItem.next;
        }
        if(removedItem.next == null) {
            this.tail = removedItem.prev;
        } else {
            removedItem.next.prev = removedItem.prev;
        }
        this.map.remove(value);
        return true;
    }

    /**
     * Removes from this HashList an element at a specified index
     * @param index the target index
     * @return the Value removed from this HashList
     */
    public Value remove(int index) {
        if(index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        int cursorIndex = 0;
        HashNode<Value> cursor = this.head;
        while(cursorIndex < index) {
            cursor = cursor.next;
            cursorIndex++;
        }
        Value removedItem = cursor.value;
        remove(removedItem);
        return removedItem;
    }

    /**
     * Inserts a Value before another target Value in this HashList
     * @param target the target Value
     * @param value the new Value to be added to this HashList
     * @return true if the target value exists in this HashList, else false
     */
    public boolean insertBefore(Value target, Value value) {
        HashNode<Value> hashNode = this.map.get(target);
        if(hashNode == null) {
            return false;
        }
        HashNode<Value> newNode = new HashNode<>(value);
        newNode.prev = hashNode.prev;
        newNode.next = hashNode;
        if(hashNode.prev != null) {
            hashNode.prev.next = newNode;
        }
        hashNode.prev = newNode;
        return true;
    }

    /**
     * Inserts a Value after another target Value in this HashList
     * @param target the target Value
     * @param value the new Value to be added to this HashList
     * @return true if the target value exists in this HashList, else false
     */
    public boolean insertAfter(Value target, Value value) {
        HashNode<Value> hashNode = this.map.get(target);
        if(hashNode == null) {
            return false;
        } else if(hashNode.next == null) {
            add(value);
            return true;
        } else {
            return insertBefore(hashNode.next.value, value);
        }
    }

    /**
     * Creates a HashList of consecutive elements from this HashList
     * @param fromIndex the first index (inclusive) where an element is added to the List
     * @param toIndex the last index (exclusive) where an element is added to the List
     * @return the subset List
     */
    public HashList<Value> subList(int fromIndex, int toIndex) {
        HashList<Value> list = new HashList<>();
        if(fromIndex > toIndex || fromIndex < 0 || toIndex > size()) {
            throw new IndexOutOfBoundsException();
        } else {
            HashNode<Value> cursor = this.head;
            int index = 0;
            while(cursor != null) {
                if(fromIndex <= index && toIndex > index) {
                    list.add(cursor.value);
                }
                cursor = cursor.next;
                index++;
            }
        }
        return list;
    }

    /**
     * Finds the size of this HashList
     * @return this.map.size
     */
    public int size() {
        return this.map.size();
    }

    /**
     * Gets the index of a specific Value in this HashList
     * @param value the target Value
     * @return the number of nodes traversed before reaching this Value, else -1 if this Value is not in the List
     */
    public int indexOf(Value value) {
        if(value == null) {
            return -1;
        }
        HashNode<Value> cursor = this.head;
        int index = 0;
        while(cursor != null) {
            if(cursor.value.equals(value)) {
                return index;
            }
            cursor = cursor.next;
            index++;
        }
        return -1;
    }

    /**
     * Determines if this HashList is empty
     * @return true if this.head is a null HashNode, else false
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Converts this HashList to a printable format
     * @return this HashList as a String
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        HashNode<Value> cursor = this.head;
        while(cursor != null) {
            builder.append(", ").append(cursor.value.toString());
            cursor = cursor.next;
        }
        return "[" + (this.head == null ? "" : builder.substring(2)) + "]";
    }

    /**
     * Returns an Iterator over elements
     * @return an Iterator
     */
    @Override
    public Iterator<Value> iterator() {
        return new Iterator<>() {
            private HashNode<Value> cursor = HashList.this.head;
            private HashNode<Value> prevCursor = cursor;

            /**
             * Checks if there is another unchecked element in this Iterator
             * @return true if the Iterator has not reached all HashNodes, else false
             */
            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            /**
             * Gets the Value at the target cursor HashNode
             * @return the target Value if it exists, else null
             */
            @Override
            public Value next() {
                if(this.cursor == null) {
                    throw new NoSuchElementException();
                } else {
                    Value value = this.cursor.value;
                    this.prevCursor = this.cursor;
                    this.cursor = this.cursor.next;
                    return value;
                }
            }

            /**
             * Removes the cursor from this HashList
             * @throws IllegalStateException if remove() was called twice consecutively
             */
            @Override
            public void remove() {
                if(this.prevCursor.equals(this.cursor)) {
                    throw new IllegalStateException();
                }
                this.prevCursor = this.cursor;
                HashList.this.remove(this.prevCursor.value);
            }
        };
    }

    /**
     * Returns an Iterator over elements
     * @return an Iterator
     */
    public ListIterator<Value> listIterator() {
        return new ListIterator<>() {
            private HashNode<Value> cursor = HashList.this.head;
            private HashNode<Value> prevCursor = cursor;
            private int index = 0;
            boolean removeIllegal = true, setIllegal = true;

            /**
             * Determines if this ListIterator has another element
             * @return true if there is another element, else false
             */
            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            /**
             * Gets the next element of this ListIterator if one exists
             * @return the next Value in this ListIterator
             * @throws NoSuchElementException when there is no next element
             */
            @Override
            public Value next() {
                if(this.cursor == null) {
                    throw new NoSuchElementException();
                } else {
                    Value value = this.cursor.value;
                    this.prevCursor = this.cursor;
                    this.cursor = this.cursor.next;
                    this.index++;
                    this.removeIllegal = false;
                    this.setIllegal = false;
                    return value;
                }
            }

            /**
             * Determines whether there is an element in this ListIterator before the one last checked
             * @return true if such a Value exists, else false
             */
            @Override
            public boolean hasPrevious() {
                return (this.cursor == null) ? (this.prevCursor != null) : (this.cursor.prev != null);
            }

            /**
             * Gets the previous element from this ListIterator
             * @return the previous Value if one exists
             * @throws NoSuchElementException if there is no previous element
             */
            @Override
            public Value previous() {
                if(this.cursor == null) {
                    this.cursor = this.prevCursor;
                } else if(this.cursor.prev == null) {
                    throw new NoSuchElementException();
                } else {
                    this.cursor = this.cursor.prev;
                }
                Value value = this.cursor.value;
                this.prevCursor = (this.cursor.prev != null) ? this.cursor.prev : this.cursor;
                this.index--;
                this.removeIllegal = false;
                this.setIllegal = false;
                return value;
            }

            /**
             * Gets the next index in this ListIterator
             * @return this.index + 1
             */
            @Override
            public int nextIndex() {
                return this.index + 1;
            }

            /**
             * Gets the previous index in this ListIterator
             * @return this.index - 1
             */
            @Override
            public int previousIndex() {
                return this.index - 1;
            }

            /**
             * Removes an element from this ListIterator
             * @throws IllegalStateException if add() has been called since the last next() or previous() invocation
             */
            @Override
            public void remove() {
                this.setIllegal = true;
                if(this.removeIllegal) {
                    throw new IllegalStateException();
                }
                this.removeIllegal = true;
                HashList.this.remove(this.cursor.value);
            }

            /**
             * Replaces a Value in this HashList with a different value
             * @param value the new Value for the HashNode
             * @throws IllegalStateException if remove() or add() has been called since the last next() or previous() invocation
             */
            @Override
            public void set(Value value) {
                if(this.setIllegal) {
                    throw new IllegalStateException();
                }
                HashList.this.insertBefore(this.prevCursor.value, value);
                HashList.this.remove(this.prevCursor.value);
            }

            /**
             * Adds an element before the cursor in this HashList
             * @param value the new value
             */
            @Override
            public void add(Value value) {
                this.removeIllegal = true;
                this.setIllegal = true;
                if(this.cursor == null) {
                    HashList.this.add(value);
                    this.prevCursor = this.prevCursor.next;
                } else {
                    HashList.this.insertBefore(this.cursor.value, value);
                }
                this.index++;
            }
        };
    }

    /**
     * The node component of a HashList
     * @param <Value> the item held in the HashNode
     */
    private static class HashNode<Value> {
        Value value;
        HashNode<Value> next, prev;

        /**
         * Creates a new HashNode
         * @param value the item held in the HashNode
         */
        private HashNode(Value value) {
            this.value = value;
        }
    }
}
