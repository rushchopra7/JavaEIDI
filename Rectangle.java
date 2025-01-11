package pgdp.rectangles;

public class Rectangle {
	private Vector2D topLeft ;
	private Vector2D bottomRight ;

	public Rectangle(Vector2D topLeft, Vector2D bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}


	@Override
	public String toString() {
		return "Rectangle spanned by points" + " " + topLeft + " " + "and" + " " + bottomRight + ".";
	}

	public double calculateArea(){
		//double area ;
		 double breadth;
		 double height;
		 breadth = bottomRight.getX() - topLeft.getX();
		 height = topLeft.getY() - bottomRight.getY();


		return breadth * height ;
	}

	public void shiftBy(Vector2D vector2D){
		double tlX = topLeft.getX();
		double tlY = topLeft.getY();
		double brX = bottomRight.getX();
		double brY = bottomRight.getY();
		tlX += vector2D.getX();
		tlY += vector2D.getY();
		brY += vector2D.getY();
		brX += vector2D.getX();

		//add method can be used
	}

	public static void main(String[] args) {

		/*
		 * This part is only for testing purposes and should not be changed.
		 * 
		 * @TODO: Remove the comment symbols (Eclipse: Ctrl + Shift + C) and run the
		 * main-method for testing. If you have not implemented the constructor and
		 * toString-method, your program won't build!
		 */

      // Vector2D tl = new Vector2D(0.0, 2.0), br = new Vector2D(2.0, 0.5);
//		Rectangle myRectangle = new Rectangle(tl, br);
//		if (myRectangle.toString().equals("Rectangle spanned by points [0.0, 2.0] and [2.0, 0.5]."))
//			System.out.println("The String seems to match. Good Job!");
//		else {
//			System.out.println("This is what you created: " + myRectangle);
//			System.out.println("This is how it should be: Rectangle spanned by points [0.0, 2.0] and [2.0, 0.5].");
//			System.out.println("Better luck next time!");
//		}

		/*
		 * Down here you might want to add code to create your own tests?
		 */

	}

}
