import java.awt.Color;
public class SeamCarver {
	Picture picture;
	double[][] energy;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture pic) {
		picture = new Picture(pic);
		energy = new double[picture.height()][picture.width()];
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x==0 || y == 0 || x == picture.width()-1  ||
			y == picture.height()-1) {
			return 1000;

		}
		else {
			Color top = picture.get(x+1, y);
			Color bottom = picture.get(x-1, y);
			Color left = picture.get(x, y+1);
			Color right = picture.get(x, y-1);
			double deltax = (Math.pow((top.getRed()- bottom.getRed()), 2))+(Math.pow((top.getGreen() - bottom.getGreen()),2)) +
			                (Math.pow((top.getBlue() - bottom.getBlue()), 2));
			double deltay = (Math.pow((left.getRed()- right.getRed()), 2))+
							(Math.pow((left.getGreen() - right.getGreen()),2)) +
			                (Math.pow((left.getBlue() - right.getBlue()), 2));
			  return  Math.sqrt(deltax + deltay);             		
			                		}
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}