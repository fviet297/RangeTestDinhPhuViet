package src.main.java.io.napa.interview_challenges;

public class Range {

    private final int lowerbound;
    private final int upperbound;

    private Range(int lowerbound, int upperbound) {
        this.lowerbound = lowerbound;
        this.upperbound = upperbound;
    }

    /**
     * Creates a new <b>closed</b> {@code Range} that includes both bounds.
     */
    public static Range of(int lowerbound, int upperbound) {

        if (lowerbound <= upperbound) {
            return new Range(lowerbound, upperbound);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Range open(int lowerbound, int upperbound) {

        if (lowerbound <= upperbound) {
            return new Range(lowerbound + 1, upperbound - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Range openClosed(int lowerbound, int upperbound) {

        if (lowerbound <= upperbound) {
            return new Range(lowerbound + 1, upperbound);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Range closedOpen(int lowerbound, int upperbound) {

        if (lowerbound <= upperbound) {
            return new Range(lowerbound, upperbound - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns {@code true} on if the given {@code value} is contained in this
     * {@code Range}.
     */
    public boolean contains(int value) {
        if (this.lowerbound <= value && this.upperbound >= value) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the {@code lowerbound} of this {@code Range}.
     */
    public int lowerbound() {
        return this.lowerbound;
    }

    /**
     * Returns the {@code upperbound} of this {@code Range}.
     */
    public int upperbound() {
        return this.upperbound;
    }

}
