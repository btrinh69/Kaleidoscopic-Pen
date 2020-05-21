//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Triangle
// Files:           Triangle
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
 * Represent a triangle created from three points in the Point class and
 * have color fill in
 *
 * @author bon
 */
public class Triangle {
  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
  // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
      -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476 };
  private Point point1;
  private Point point2;
  private Point point3;
  private int colorIndex;

  /**
   * The constructor of the class Triangle
   * @param point1: an object of class point, reference to point 1
   * @param point2: an object of class point, reference to point 2
   * @param point3: an object of class point, reference to point 3
   * @param colorIndex: an integer, represent the index of the color
   * that fill the triangle
   */
  public Triangle(Point point1, Point point2, Point point3, int colorIndex) {
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
    this.colorIndex = colorIndex;
  }

  /**
   * the mutator of the color of the triangle
   * @param newColorIndex: an integer for the index of the color
   */
  public void setColor(int newColorIndex) {
    colorIndex = newColorIndex;
  }

  /**
   * draw a triangle from three points
   * @param drawTo: the PApplet object
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(COLORS[colorIndex]);
    drawTo.triangle(point1.getX(), point1.getY(), point2.getX(), point2.getY(),
        point3.getX(), point3.getY());
  }

  /**
   * check whether the mouse is within the triangle
   * @param x: the x-coordinate of the mouse
   * @param y: the y-coordinate of the mouse
   * @return true if it is in, false otherwise
   */
  public boolean isOver(int x, int y) {
    if (isPointInTriangle(x, y, point1.getX(), point1.getY(), point2.getX(),
        point2.getY(), point3.getX(), point3.getY())) return true;
    else return false;
  }

  /**
   * helper method to check whether the point is in the triangle or not
   * @param the coordinate of the point and three points of the triangle
   * (px, py), (t1x, t1y), (t2x, t2y), (t3x, t3y) are the coordinates of
   * the point needs checking and the coordinates of three points of the
   * triangle respectively
   * @return true if it is in, false otherwise
   */
  private static boolean isPointInTriangle(int px, int py,
      int t1x, int t1y, int t2x, int t2y, int t3x, int t3y) {
      px -= t1x;
      py -= t1y;
      t2x -= t1x;
      t2y -= t1y;
      t3x -= t1x;
      t3y -= t1y;
      double dotp2 = px*t2x+py*t2y;
      double dotp3 = px*t3x+py*t3y;
      double dot22 = t2x*t2x+t2y*t2y;
      double dot23 = t2x*t3x+t2y*t3y;
      double dot33 = t3x*t3x+t3y*t3y;
      double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
      double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
      double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
      return (a >= 0) && (b >= 0) && (a + b < 1);
  }
}
