//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Point
// Files:           Point
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


/**
 * Represent a point with coordinates and a fixed diameter
 *
 * @author bon
 */
public class Point {
  private int x; // x-coordinate
  private int y; // y-coordinate
  private final static int POINT_DIAMETER = 8;

  /**
   * The contructor of the class
   * @param x: an integer, the x-coordinate of the point
   * @param y: an integer, the y-coordinate of the point
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  /**
   * The mutator of the coordinates
   * @param x, an integer that is the new x-coordinate of the point
   * @param y, an integer that is the new y-coordinate of the point
   */
  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }
  /**
   * the accessor to get the x-coordinate
   * @return the x-coordinate
   */
  public int getX() {
    return x;
  }
  /**
   * the accessor to get the y-coordinate
   * @return the y-coordinate
   */
  public int getY() {
    return y;
  }

  /**
   * draw a white circle at this point position
   * @param drawTo: the PApplet Object
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(-1); // fill the point white initially
    // draw a circle with the diameter put in at the point (x,y)
    drawTo.circle(x, y, POINT_DIAMETER);
  }

  /**
   * check whether the position x, y is in the circle drawn
   * @param x, the integer of the x coordinate
   * @param y, the integer of the y coordinate
   * @return true if it is in the circle drawn, false if not
   */
  public boolean isOver(int x, int y) {
    if (((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y))
        < ((POINT_DIAMETER/2)*(POINT_DIAMETER/2)))
    return true;
    else return false;
  }
}
