package com.greatworksinc.concepts.towerofhanoi;

public class Disc {
    private final int size;
    public Disc(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * Checks the size of the disc method is called from and the size of the disc passed in.
     * @param otherDisc
     * @return {@code true} if this is bigger than otherDisc, {@code false} if this is smaller than or equal to otherDisc.
     */
    public boolean isBiggerThan(Disc otherDisc) {
        return size > otherDisc.size;
    }
}
