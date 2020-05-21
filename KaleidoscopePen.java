//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           KaleidoscopePen
// Files:           KaleidoscopePen
// Course:          CS300 LEC001, Fall, 2019
//
// Author:          Binh Quoc Trinh (Bon)
// Email:           btrinh@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:
// Online Sources:
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import processing.core.PApplet;
import java.util.ArrayList;

/**
 * The Kaleidoscope Pen that uses the TrianglePen draw triangles around
 * the centre point
 *
 * @author bon
 */
public class KaleidoscopePen {
  private ArrayList<TrianglePen> trianglePen = new ArrayList<TrianglePen>();
  private PApplet drawTo;
  private int numberOfTrianglePens;

  /**
   * the constructor of the KaleidoscopePen class
   * @param drawTo: the PApplet object
   * @param numberofTrianglePens: the number of TrianglePens
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    this.drawTo = drawTo;
    this.numberOfTrianglePens = numberOfTrianglePens;
  }

  /**
   * the method to update new things being added
   * @param mouseX, mouseY: the coordinates of the mouse
   * @param mousePressed: a boolean represent whether the mouse is being pressed
   * @param keyPressed: the key that is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    if (numberOfTrianglePens > 0) {
      trianglePen.add(new TrianglePen(drawTo, true));
      trianglePen.get(0).update(mouseX, mouseY, mousePressed, keyPressed);
    }
    for (int i = 1; i < numberOfTrianglePens; i++) {
      trianglePen.add(new TrianglePen(drawTo, false));
      int [] positionRotate = rotate(mouseX, mouseY, ((i*2*3.14)/numberOfTrianglePens));
      trianglePen.get(i).update(positionRotate[0], positionRotate[1], mousePressed, keyPressed);
    }
  }

  /**
    * Rotates a position around the center of an 800x600 screen by the specified
    * amount, and then returns an array containing the resulting position.
    * @param x position of the point to be rotated (0 to 800 pixels)
    * @param y position of the point to be rotated (0 to 600 pixels)
    * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
    * @return the rotated position array: x @ index 0, y @ index 1
    */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int)(x * Math.cos(angle) - y * Math.sin(angle)),
        (int)(x * Math.sin(angle) + y * Math.cos(angle))
	    };
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }
}
