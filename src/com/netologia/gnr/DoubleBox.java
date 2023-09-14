package com.netologia.gnr;

public class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public boolean put(int key, T value) {
        // ваш код
        try {
            if (first.getKey() == key) {
                return true;
            }
        } catch (Exception e) {
            this.first = new RandomBox<>(key, value);
            return true;
        }

        try {
            if (second.getKey() == key) {
                return true;
            }
        } catch (Exception e) {
            this.second = new RandomBox<>(key, value);
            return true;
        }
        return false;
    }

    public T get(int key) {
        // ваш код
        try {
            if (first.getKey() == key) {
                return first.getValue();
            }
        } catch (Exception e) {
            return null;
        }
        try {
            if (second.getKey() == key) {
                return second.getValue();
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public int size() {
        // ваш код
        try {
            if (!second.getValue().equals(null)) {
                return 2;
            }
        } catch (Exception e) {
            try {
                if (!first.getValue().equals(null)) {
                    return 1;
                }
            } catch (Exception f) {
                return 0;
            }
        }
        return 0;
    }
}
