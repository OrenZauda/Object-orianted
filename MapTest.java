package Pacman;

import static org.junit.jupiter.api.Assertions.*;
import Geom.Point3D;
import org.junit.jupiter.api.Test;

class MapTest {
//
//		@Test
//		void testGps2pixels() {
//	        Map object=new Map();
//			assertEquals(object.gps2pixels(new Point3D(32.101858,35.202574,0))[0], 400);	
//			assertEquals(object.gps2pixels(new Point3D(32.101858,35.202574,0))[1], 400);	
//	
//		}
//
//		@Test
//		void testPixels2gps() {
//	         Map object=new Map();
//			assertEquals((32.106046+32.101858)/2,(object.pixels2gps(200,200).gety()));
//			assertEquals((35.212405+35.202574)/2,(object.pixels2gps(200,200).getx()));
	
//		}
//
//	@Test
//	void testDistance() {
//		Map object=new Map();
//		assertEquals (object.distance(0, 0, 400, 400),1036.481492567678);
//
//	}

		@Test
		void testAngle() {
			Map object=new Map();
			assertEquals(0.40271683487251426, object.angle(400, 400, 0,0));
		}

}
