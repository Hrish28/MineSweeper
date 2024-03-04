package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("=====Welcome to Minesweeper=======");
        System.out.println("Please note that revealed tiles will display the value of the tile, ");
        System.out.println("where as the covered tiles looks like this (X)");
        Board b1 = new Board();
        ArrayList<ArrayList<Tile>> minefield = b1.setBoard();
        System.out.println(" ");
        b1.printBoard(minefield);
        System.out.println("Let's proceed!!");
        String cond = "Start";
        while (!(cond.equals("Complete"))){
            System.out.println(" ");
            System.out.println("Please select a Row to check");
            int row = in.nextInt();
            System.out.println("Please select a column to check");
            int column = in.nextInt();
            String current = b1.player(minefield,row,column);

            switch (current){

                case "Bomb":
                    System.out.println(" ");
                    System.out.println("Oh NOO!! you've hit a Bomb");
                    System.out.println("==========+++++++Game over+++++++++=======");
                    b1.setAllRevealed(minefield);
                    b1.printBoard(minefield);
                    System.exit(0);
                    break;

                case "Winner":
                    System.out.println(" ");
                    System.out.println("Congratulations you've won!!");
                    System.out.println("==========+++++++Game over (WINNER)+++++++++=======");
                    b1.setAllRevealed(minefield);
                    b1.printBoard(minefield);
                    break;

                case "Carry-On":
                    System.out.println(" ");
                    System.out.println("Current board! ");
                    b1.printBoard(minefield);
                    System.out.println("Please choose your next move carefully!");
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }



        }
    }
