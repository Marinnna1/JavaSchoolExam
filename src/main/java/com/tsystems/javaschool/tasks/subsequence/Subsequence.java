package com.tsystems.javaschool.tasks.subsequence;


import java.util.List;


public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {


            if(checkInput(x,y)) {
                return true;
            }

            // define variables for working with lists
            Object currentX;
            Object currentY;
            currentX = x.remove(0);


            while (!y.isEmpty()) {
                currentY = y.remove(0);
                // we will check if current element of x contains in y, until all elements are checked
                if (currentY.equals(currentX)) {
                    if (x.isEmpty()) {
                        return true;
                    }
                    currentX = x.remove(0);
                }
            }

        return false;
    }


    // check if lists are valid or not
    private static boolean checkInput(List x, List y){
        if( x == null || y == null) {
            throw new IllegalArgumentException();
        }
        return x.isEmpty();
    }

}
