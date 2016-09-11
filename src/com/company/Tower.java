package com.company;

import java.util.Stack;

/**
 *  Tower of Hanoi implementation
 */
class Tower {

    // The stack of the discs
    private Stack<Integer> discs;

    Tower(){
        discs = new Stack<>();
    }

    /**
     * The equivalent of the push function for a stack.
     * @param disk Integer containing the size of the disk being placed into the tower.
     */
    void placeDisk(int disk){

        discs.push(disk);
    }

    /**
     * The equivalent of the pop function for a stack.
     * @return Integer containing the top value of the disc on the tower.
     */
    int getDisc(){

        return discs.pop();
    }

    /**
     * Gets a string representation of the tower
     * @return String containing the composition of the tower object
     */
    String getTowerState(){

        // Converting stack of integers to array
        Object[] discsArray = discs.toArray();

        int maxLength = discsArray.length - 1;
        if (maxLength == -1)
            return "()";

        StringBuilder builder = new StringBuilder();
        builder.append('(');

        for (int i = 0; ; i++) {
            builder.append(String.valueOf(discsArray[i]));

            if (i == maxLength)
                return builder.append(')').toString();
            builder.append(", ");
        }

    }

}
