package com.greatworksinc.concepts.towerofhanoi;

public class Rung {
    private final int size;
    public Rung(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * Checks the size of the rung method is called from and the size of the rung passed in.
     * @param otherRung
     * @return {@code true} if otherRung is bigger than this, {@code false} if otherRing is smaller than or equal to this.
     */
    public boolean isBigger(Rung otherRung) {
        return otherRung.getSize() > size;
    }
}
