package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {

        if(!checkInputNumbers(inputNumbers)) {
            throw new CannotBuildPyramidException("The pyramid cannot be build with given input");
        }


        int rows = getRows(inputNumbers);
        int columns = 2 * rows - 1;
        int[][] pyramid = new int[rows][columns];


        Collections.sort(inputNumbers);
        List<Integer> numbers = new LinkedList<>(inputNumbers);

        // define the start top index of the pyramid
        int top = (pyramid[0].length) / 2;

        for(int i = 0; i < pyramid.length; i++) {

            int start = top;

            // getting current element for pyramid and do step for the next element

            for(int j = 0; j <= i; j++) {
                pyramid[i][start] = numbers.remove(0);
                start += 2;
            }

            top --;
        }
        return pyramid;
    }

    // count the pyramid rows
    private static int getRows(List<Integer> inputNumbers){
        int rows = 0;
        double result = 0.5 * (Math.sqrt(1 + 8 * inputNumbers.size()) - 1);
        if(result == Math.ceil(result)) {
            rows = (int) result;
        }
        return rows;
    }

    // check the opportunity of getting pyramid
    private static boolean checkInputNumbers(List<Integer> inputNumbers) {
        int rows = getRows(inputNumbers);
        return !inputNumbers.contains(null) && rows != 0;
    }


}
