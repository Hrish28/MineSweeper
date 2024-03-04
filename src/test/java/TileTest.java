import org.example.Board;
import org.example.Tile;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class TileTest {
    @Test
    public void testTileReveal(){
        Tile t1 = new Tile();
        Assertions.assertTrue(t1.getCover(),"The tile is constructed with a cover");
       t1.setCover(false);
        Assertions.assertFalse(t1.getCover(),"The tile is now with a cover");
    }

    @Test
    public void testTileOnBoardReveal() {
        Board b1 = new Board();
        ArrayList<ArrayList<Tile>> minefield = b1.setBoard();
        Assertions.assertTrue(minefield.get(5).get(5).getCover(),"The tile is constructed with a cover");
        minefield.get(5).get(5).setCover(false);
        Assertions.assertFalse(minefield.get(5).get(5).getCover(),"The tile is now with a cover");
    }

    @Test
    public void setValueTileTest(){
        Tile t1 = new Tile();
        Assertions.assertEquals(t1.getValue(),0,"The tile is initialised correctly");
        t1.setValue(5);
        Assertions.assertEquals(t1.getValue(),5,"The tile is now correctly valued");


    }

    @Test
    public void testTileOnBoardValue(){
        Board b1 = new Board();
        ArrayList<ArrayList<Tile>> minefield = b1.setBoard();
        minefield.get(5).get(5).setValue(8);
        Assertions.assertEquals(minefield.get(5).get(5).getValue(),8,"The tile value is correctly changed");
        minefield.get(7).get(7).setValue(0);
        Assertions.assertEquals(minefield.get(7).get(7).getValue(),0,"The tile value for a different index is correct");
    }

    @Test
    public void testTileBomb(){
        Tile t1 = new Tile();
        Assertions.assertFalse(t1.getBomb(),"The tile is initialised as not a bomb");
        t1.setBomb(true);
        Assertions.assertTrue(t1.getCover(),"The tile is now with a bomb");
    }

    @Test
    public void testTileFlag(){
        Tile t1 = new Tile();
        Assertions.assertFalse(t1.isFlag(),"The tile is initialised as not a flag");
        t1.setFlag(true);
        Assertions.assertTrue(t1.getCover(),"The tile is now a flag");
    }

    @Test
    public void testTileOnBoardBomb() {
        Board b1 = new Board();
        ArrayList<ArrayList<Tile>> minefield = b1.setBoard();
        minefield.get(5).get(5).setBomb(true);
        Assertions.assertTrue(minefield.get(5).get(5).getBomb(),"The board tile is set with a bomb");
        minefield.get(3).get(4).setBomb(false);
        Assertions.assertFalse(minefield.get(3).get(4).getBomb(),"The tile is now with a set without a bomb");
    }

    @Test
    public void testTileOnBoardFlag() {
        Board b1 = new Board();
        ArrayList<ArrayList<Tile>> minefield = b1.setBoard();
        Assertions.assertFalse(minefield.get(5).get(5).isFlag(),"The board tile is constructed without a flag");
        minefield.get(3).get(4).setFlag(true);
        Assertions.assertTrue(minefield.get(3).get(4).isFlag(),"The tile is now with a set with a flag");
    }



    }


