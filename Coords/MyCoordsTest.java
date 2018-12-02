package Coords;

import static org.junit.jupiter.api.Assertions.*;
import Geom.Point3D;
import org.junit.jupiter.api.Test;
import Coords.MyCoords;

class MyCoordsTest {

	@Test
	void testAdd() {
		Point3D a= new Point3D(2,2,2);
		Point3D b= new Point3D(1,0,9);
		MyCoords c=new MyCoords();
		System.out.println(c.add(a,b).getx()+" "+c.add(a,b).gety()+" "+c.add(a,b).getz());
		assertEquals(3,c.add(a,b).getx());
		assertEquals(2,c.add(a,b).gety());
		assertEquals(11,c.add(a,b).getz());

	}

	@Test
	void testDistance3d() {
		Point3D a= new Point3D(2,2,2);
		Point3D b= new Point3D(1,0,9);
		MyCoords c= new MyCoords();
		System.out.println(c.distance3d(a,b));
		assertEquals(Math.sqrt(54), c.distance3d(a,b));
	}

	@Test
	void testVector3D() {
		Point3D a= new Point3D(2,2,2);
		Point3D b= new Point3D(1,0,9);
		MyCoords c= new MyCoords();
		System.out.println(c.vector3D(a,b));
		assertEquals(-1, c.vector3D(a,b).getx());
		assertEquals(-2, c.vector3D(a,b).gety());
		assertEquals(7, c.vector3D(a,b).getz());
	}

	@Test
	void testAzimuth_elevation_dist() {
		Point3D a= new Point3D(2,2,2);
		Point3D b= new Point3D(1,0,9);
		double c[]= new double [3];
		MyCoords D= new MyCoords();
		c=D.azimuth_elevation_dist(a, b);
		assertEquals(Math.toDegrees(Math.asin((7/Math.sqrt(54)))), c[1]);
		assertEquals(Math.sqrt(54), c[2]);
		assertEquals(Math.toDegrees(Math.atan(0.5)), c[0]);



	}
	
	@Test
	void testIsValid_GPS_Point() {
		Point3D b= new Point3D(1,0,9);
		Point3D a= new Point3D(181,0,9);
		MyCoords D= new MyCoords();
		assertEquals(true, D.isValid_GPS_Point(b));
		assertEquals(false, D.isValid_GPS_Point(a));

		
	}
	 
}
