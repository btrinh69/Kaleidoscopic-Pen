//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           TrianglePen
// Files:           TrianglePen
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
 * This is the triangle pen that can draw points and an triangle after each
 * three points are drawn using the class Point and Triangle
 *
 * @author bon
 */
public class TrianglePen {
  private boolean mouseWasPressed = false; // mousePressed from previous update() call
  private char keyWasPressed = '\0'; // keyPressed from previous update() call
  private PApplet processing;
  private boolean showPoints;
  // An array that stores all points drawn
  private ArrayList<Point> point = new ArrayList<Point>();
  // An array that stores all triangle drawn
  private ArrayList<Triangle> triangle = new ArrayList<Triangle>();
  // A point to refer to the point that is being dragged
  private Point pickedPoint = null;

  /**
   * The constructor of the TrianglePen class
   * @param processing: the PApplet object
   * @Param showPoints: a boolean decides whether the point is displayed or not
   */
  public TrianglePen(PApplet processing, boolean showPoints){
      this.processing = processing;
      this.showPoints = showPoints;
  }

  /**
   * the method to update new things being added
   * @param mouseX, mouseY: the coordinates of the mouse
   * @param mousePressed: a boolean represent whether the mouse is being pressed
   * @param keyPressed: the key that is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed){
	// process mouse-based user input
	if(mousePressed != mouseWasPressed) {
      if(mousePressed) handleMousePress(mouseX, mouseY);
      else handleMouseRelease(mouseX, mouseY);
    }
    if(mousePressed) handleMouseDrag(mouseX, mouseY);
      mouseWasPressed = mousePressed;

    // process keyboard-based user input
    if(keyPressed != keyWasPressed) handleKeyPress(mouseX, mouseY, keyPressed);
      keyWasPressed = keyPressed;

    // draw everything in its current state
    draw();
  }

  /**
   * handle the event when mouse is pressed
   * @param mouseX: the x-coordinate of the mouse, an integer
   * @param mouseY: the y-coordinate of the mouse, an integer
   */
  public void handleMousePress(int mouseX, int mouseY) {
    boolean check = false;
    for (int i = (point.size()-1); i >= 0 ; i--) {
      if (point.get(i).isOver(mouseX, mouseY)) {
        pickedPoint = point.get(i);
        check = true;
        break;
        }
    }
    if ((check == false)) {
      point.add(new Point(mouseX, mouseY));
      if ((point.size()%3) == 0) {
        triangle.add(new Triangle(point.get(point.size() -1),
        point.get(point.size() -2), point.get(point.size() -3), 5));
        }
    }
  }

  /**
   * method that handle the event when the mouse is released
   * @param mouseX: the x-coordinate of the mouse, an integer
   * @param mouseY: the y-coordinate of the mouse, an integer
   */
  public void handleMouseRelease (int mouseX, int mouseY) {
    if (pickedPoint != null) {
      pickedPoint.setPosition(mouseX, mouseY);
      pickedPoint = null;
    }
  }

  /**
   * method that handle the event when the mouse is dragged
   * @param mouseX: the x-coordinate of the mouse, an integer
   * @param mouseY: the y-coordinate of the mouse, an integer
   */
  public void handleMouseDrag (int mouseX, int mouseY) {
    if (pickedPoint != null)
      pickedPoint.setPosition(mouseX, mouseY);
  }

  /**
   * method that handle the event when the key is pressed
   * @param mouseX: the x-coordinate of the mouse, an integer
   * @param mouseY: the y-coordinate of the mouse, an integer
   * @param keyPressed: the key that is pressed, a char
   */
  public void handleKeyPress (int mouseX, int mouseY, char keyPressed) {
    int i;
    for (i = 0; i < triangle.size(); i++) {
      if (triangle.get(i).isOver(mouseX, mouseY)) {
        if ((keyPressed < '8') && (keyPressed >= '0'))
          triangle.get(i).setColor(keyPressed - '0');
      }
    }
  }

  /**
   * Draw every point that the boolean showPoints of that point is set
   * to true and draw a triangle after every three points
   */
  public void draw() {
    for (int i = 0; i < point.size(); i++) {
      if (showPoints == true) point.get(i).draw(this.processing);
    }
    for (int i = 0; i < triangle.size(); i++) {
      triangle.get(i).draw(this.processing);
    }
  }
}
