package org.example;

import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Board {

    public ArrayList<ArrayList<Tile>> setBoard(){
        ArrayList<ArrayList<Tile>> mineField = new ArrayList<>();

        for (int i=0; i <8; i++){

            ArrayList<Tile> rowOfMines = new ArrayList<>();
            mineField.add(i,rowOfMines);

            for (int j=0; j <8; j++){
                Tile currentTile = new Tile();
                rowOfMines.add(j, currentTile);
                currentTile.setxCoord(i);
                currentTile.setyCoord(j);

            }

        }
        return addBombs(mineField);

    }

    public ArrayList<ArrayList<Tile>> addBombs (ArrayList<ArrayList<Tile>> field){
        int var= 0;

        do {
            Random r = new Random();
            int x = r.nextInt(8);
            int y = r.nextInt(8);
            //check if it's already a mine
            if (!(field.get(x).get(y).getBomb())) {
                field.get(x).get(y).setBomb(true);
                field.get(x).get(y).setValue(100);
                var++;
            }
        }
        while (var<=10);
        setTileValues(field);//assign field values
        return field;
    }

    public void printBoard (ArrayList<ArrayList<Tile>> field){

        for (int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(field.get(i).get(j).toString() + " ");
            }
            System.out.println(" ||" + i);// prints right index
        }

        for(int j=0;j<8;j++) {
            System.out.print("___ ");

        }
        System.out.println();
        System.out.println("___ ___ ___ ___ ___ ___ ___ ___ ");

        for (int j=0; j<8 ;j++){// prints bottom index
            System.out.print(" " +j + " ");
            if (j<7){
                System.out.print(" ");
            }
        }
        System.out.println();

    }

    public void setTileValues (ArrayList<ArrayList<Tile>> field){
    for (int i =0; i<8;i++){
        for (int j=0;j<8; j++){
            if (!(field.get(i).get(j).getBomb())){
                int noOfBombs =0;

                if (i!=0){// top row
                    if (field.get(i-1).get(j).getBomb()) {
                        noOfBombs++;//checkTop
                    }
                    if (j!=0){//topLeft corner
                        if (field.get(i-1).get(j-1).getBomb()) {
                            noOfBombs++;//topLeft
                        }
                    }
                }

                if (i!=7){//bottomRow
                    if (field.get(i+1).get(j).getBomb()) {
                        noOfBombs++;//checkBottom
                    }
                    if (j!=7){//bottomRight corner
                        if (field.get(i+1).get(j+1).getBomb()) {
                            noOfBombs++;//bottomRight
                        }
                    }
                }

                if (j!=0){// left row
                    if (field.get(i).get(j-1).getBomb()) {
                        noOfBombs++;//checkLeft
                    }
                    if (i!=7){//bottomLeft corner
                        if (field.get(i+1).get(j-1).getBomb()) {
                            noOfBombs++;//bottomLeft
                        }
                    }
                }

                if (j!=7){// Right row
                    if (field.get(i).get(j+1).getBomb()) {
                        noOfBombs++;//checkRight
                    }
                    if (i!=0){//TopRight corner
                        if (field.get(i-1).get(j+1).getBomb()) {
                            noOfBombs++;//checkTopRight
                        }
                    }
                }
                field.get(i).get(j).setValue(noOfBombs);

            }
        }
    }


    }

    public String player (ArrayList<ArrayList<Tile>> field, int x, int y) {
        if (field.get(x).get(y).getBomb()) {
            return "Bomb";

        } else {
            field.get(x).get(y).setCover(false);
        }
        for (int i = 0; i < 8; i++) {//checking if all tiles that aren't bombs have been revealed
            for (int j = 0; j < 8; j++) {
                if (!(field.get(x).get(y).getBomb())) {
                    if ((field.get(x).get(y).getCover())) {
                        field.get(x).get(y).setCover(false);
                    } else {
                        return "Carry-On";
                    }
                }
            }
        }
        return "Winner";
    }

    public void setAllRevealed(ArrayList<ArrayList<Tile>> field){
        for (int i =0; i<8;i++){
            for (int j=0;j<8; j++) {
                field.get(i).get(j).setCover(false);
            }

        }


    }

    }


