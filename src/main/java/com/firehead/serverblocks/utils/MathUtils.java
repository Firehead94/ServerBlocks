package com.firehead.serverblocks.utils;

import com.firehead.serverblocks.utils.geometry.Point;
import com.firehead.serverblocks.utils.geometry.Rectangle;

public class MathUtils {
	
	public MathUtils() {
	}

	public static boolean doRectanglesOverlap(int minX, int maxX, int minY,	int maxY, int minZ, int maxZ, int newMinX, int newMaxX,
			int newMinY, int newMaxY, int newMinZ, int newMaxZ) {
		Point p1 = new Point(minX, minY, minZ);
		Point p2 = new Point(maxX, maxY, maxZ);
		Point p3 = new Point(newMinX, newMinY, newMinZ);
		Point p4 = new Point(newMaxX, newMaxY, newMaxZ);
		
		Rectangle rect1 = new Rectangle(p1, p2);
		Rectangle rect2 = new Rectangle(p3, p4);
		
		return doOverlap(rect1, rect2);
	}
	
	public static boolean doOverlap(Rectangle rect1, Rectangle rect2) {
		if (rect1.p1.x > rect2.p2.x || rect1.p2.x < rect2.p1.x)
			return false;
		if (rect1.p2.z < rect2.p1.z || rect1.p1.z > rect2.p2.z)
			return false;
		if (rect1.p1.y > rect2.p2.y || rect1.p2.y < rect2.p1.y)
			return false;
		return true;
		
	}
	
}