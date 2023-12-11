import java.util.Arrays;

public class Map<Key, Value> {

    private Object[] keys;
    private Object[] values;
    private int count;

    public Map(int length) {
        if (length <= 0) {
            length = 1;
        }
        this.keys = new Object[length];
        this.values = new Object[length];
        this.count = 0;
    }

    private boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null || rightKey == null) {
            return leftKey == rightKey;
        }
        return leftKey.equals(rightKey);
    }

    private int binarySearch(Key key) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (keys[mid] == null) {
                return -mid - 1;  // Special case for null key
            }

            int comparisonResult = ((Comparable<? super Key>) keys[mid]).compareTo(key);

            if (comparisonResult == 0) {
                // Found the key; find the first occurrence
                while (mid > 0 && isEqual((Key) keys[mid], key)) {
                    mid--;
                }
                return mid;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Key not found, return the insertion point
        return -left - 1;
    }

    private int getIndex(Key key) {
        if (key == null) {
            return -1;
        }

        int searchResult = binarySearch(key);
        if (searchResult >= 0) {
            return searchResult;
        }

        return -1;
    }

    public Value get(Key key) {
        int index = getIndex(key);
        if (index != -1) {
            return (Value) values[index];
        }
        return null;
    }

    public boolean containsKey(Key key) {
        return getIndex(key) != -1;
    }

    public void put(Key key, Value value) {
        int index = getIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (count == keys.length) {
                // Double the size of the arrays
                int newSize = keys.length * 2;
                keys = Arrays.copyOf(keys, newSize);
                values = Arrays.copyOf(values, newSize);
            }
            index = -index - 1; // Convert the insertion point to the actual index
            System.arraycopy(keys, index, keys, index + 1, count - index);
            System.arraycopy(values, index, values, index + 1, count - index);
            keys[index] = key;
            values[index] = value;
            count++;
        }
    }

    public int size() {
        return count;
    }
}
