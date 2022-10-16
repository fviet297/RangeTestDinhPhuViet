package io.napa.interview_challenges;

public class RangeGeneric<T extends Comparable<T>>  {

    private final T lowerbound;
    private final T upperbound;
    RangeGeneric(T lowerbound, T upperbound) {
        if((lowerbound ==null)||(upperbound==null)){
            throw new NullPointerException("Invalid value");
        }
        if(lowerbound.compareTo(upperbound)>0){
            throw new IllegalArgumentException();
        }else{
            this.lowerbound = lowerbound;
            this.upperbound = upperbound;
        }
    }

    /**
     * Creates a new <b>closed</b> {@code Range} that includes both bounds.
     */
    public static RangeGeneric of(Comparable lowerbound, Comparable upperbound) {

        if (lowerbound.compareTo(upperbound)<=0 ) {
            return new RangeGeneric(lowerbound, upperbound);
        } else {
            throw new IllegalArgumentException();
        }
    }


  /**
   * Returns the {@code lowerbound} of this {@code Range}.
   */
    public T lowerbound() {
        return this.lowerbound;
    }

    /**
     * Returns the {@code upperbound} of this {@code Range}.
     */
    public T upperbound() {
        return this.upperbound;
    }

    /**
     * Returns {@code true} on if the given {@code value} is contained in this
     * {@code Range}.
     */
    public boolean contains(T value) {
        if (this.isBigger(value,lowerbound) && this.isSmaller(value,upperbound)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBigger(T t1,T t2){
        return t1.compareTo(t2) >= 0;
    }
    public boolean isSmaller(T t1,T t2){
        return t1.compareTo(t2) <= 0;
    }


}

