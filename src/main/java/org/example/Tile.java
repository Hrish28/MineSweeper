package org.example;

public class Tile {
    Boolean cover;
    int value;
    Boolean bomb;
    boolean flag;
     int xCoord;
     int yCoord;

    public Tile() {

        value = 0;
        cover =true;
        bomb =false;
        flag= false;

    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void incValue() {value++;}

    public Boolean getBomb() {
        return bomb;
    }

    public void setBomb(Boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String toString(){
        if (!cover){
            if (bomb){
                return " B ";
            }else {
                return " "+value +" ";
            }
        }else {
            return "(X)";
        }
    }

}
