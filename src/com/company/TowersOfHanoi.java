package com.company;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The Towers Of Hanoi program implementation.
 * This program shows recursive solution to move n discs from the start tower to the end tower.
 *
 * @author Arnas Grigaliunas
 * @version 1.0
 * @since 2016-09-05
 */
public class TowersOfHanoi {

    // Declaring 3 towers
    private Tower towerA;
    private Tower towerB;
    private Tower towerC;

    private int numberOfSteps;

    public static void main(String[] args){

        System.out.println("\t\t\tWelcome to the Towers of Hanoi program!\n");

        System.out.println("Please write the number of the discs (0 < discs <= 10): ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();

        while (discs <= 0 || discs > 10) {
            System.out.println("Wrong number of the discs!");
            System.out.println("Please write the number of the discs (0 < discs <= 10): ");
            discs = scanner.nextInt();
        }

        // Beginning the solution of the Tower Of Hanoi
        new TowersOfHanoi(discs);

    }

    private TowersOfHanoi(int numberOfDiscs){

        // Initialize 3 towers and array
        towerA = new Tower();
        towerB = new Tower();
        towerC = new Tower();
        HashMap<Character, Tower> arrayOfTowers = new HashMap<>();

        numberOfSteps = 1;

        // Add 3 towers to the ArrayList
        arrayOfTowers.put('A', towerA);
        arrayOfTowers.put('B', towerB);
        arrayOfTowers.put('C', towerC);

        // Add all discs to initial tower A
        for(int counter = numberOfDiscs; counter >= 1; counter--) {
            towerA.placeDisk(counter);
        }

        System.out.println("Initial state:\t" + printTowers() + "\n" );
        moveDiscs(numberOfDiscs, 'A', 'B', 'C', arrayOfTowers);
    }

     private void moveDiscs(int n, Character start, Character intermediate, Character end, HashMap<Character, Tower>  towers){

        if (n == 1){
            moveDiscToTower(towers.get(start), towers.get(end) );

            System.out.println(numberOfSteps++ + ".\t" + "Disc " + n + " from " + start + " move to " + end + "\t\t" +
                    printTowers() );
        } else{
            moveDiscs(n - 1, start, end, intermediate, towers);

            moveDiscToTower(towers.get(start), towers.get(end));

            System.out.println(numberOfSteps++ + ".\t" + "Disc " + n + " from " + start + " move to " + end + "\t\t" +
                    printTowers());

            moveDiscs(n - 1, intermediate, start, end, towers);

        }

    }

    private void moveDiscToTower(Tower start, Tower end) {

        // Remove top disc from the tower
        int topDisc = start.getDisc();

        // Add top disc to the top of the pole
        end.placeDisk(topDisc);

    }

    private StringBuffer printTowers() {

        StringBuffer currentState = new StringBuffer();

        // Append contents from A tower
        currentState.append("A=");
        currentState.append("=");
        currentState.append(towerA.getTowerState());

        currentState.append(", ");

        // Append contents from B tower
        currentState.append("B=");
        currentState.append(towerB.getTowerState());

        currentState.append(", ");

        // Append contents from C tower
        currentState.append("C=");
        currentState.append(towerC.getTowerState());

        currentState.append(".");

        return currentState;

    }


}