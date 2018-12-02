package Coords;

import java.util.ArrayList;

import Geom.Point3D;
import java.util.ArrayList;

public class MyCoords implements coords_converter {
	private ArrayList <Point3D> Coordsarray;

    public MyCoords() {
    }
    
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
        Point3D x=new Point3D(gps.x()+local_vector_in_meter.x(),gps.y()+local_vector_in_meter.y(),gps.z()+local_vector_in_meter.z());
		return x;
		
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double Distance = (Math.sin(Math.toRadians(gps0.x())) *
				Math.sin(Math.toRadians(gps1.x()))) +
				(Math.cos(Math.toRadians(gps0.x())) * Math.cos(Math.toRadians(gps1.x())) *
						Math.cos(Math.toRadians(gps0.y() - gps1.y() )));
		Distance=Math.toDegrees(Math.acos(Distance)) * 69.09* 1.60934 * 1000;
		return Distance;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// entering radius of earth
		double Radius = 6371000;
		// having lon to calculate y in meters
		double Lon = Math.cos(gps0.x() * Math.PI / 180);
		// having the differenses between x's and y's,
		// in degrees
		double deltax = (gps1.x() - gps0.x())* Math.PI / 180;
		double deltay = (gps1.y() - gps0.y()) * Math.PI / 180;
		// having the differenses of z's
		double deltaz = gps1.z() - gps0.z();
		//switching x,y to meters
		double tomX = Math.sin(deltax) * Radius;
		double tomY = Math.sin(deltay) * Radius * Lon;
		//return results
		return new Point3D(tomX, tomY, deltaz);
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
        double x []=new double[3];
        //distance
        x[2]=distance3d(gps0, gps1);
        //elevation
        x[1]=Math.toDegrees(Math.asin((gps1.z()-gps0.z())/x[2]));
        //azimuth
		double x1 = Math.toRadians(gps0.x());
		double x2 = Math.toRadians(gps1.x());
		double yd = Math.toRadians(gps1.y() - gps0.y());
		double s = Math.sin(yd) * Math.cos(x2);
		double y = Math.cos(x1) * Math.sin(x2) - Math.sin(x1) * Math.cos(x2) * Math.cos(yd);
		double azimuth = Math.atan2(s,y);
		azimuth = Math.toDegrees(azimuth) + 360;
        x[0]=azimuth;
		return x;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		return (!(Math.abs(p.x())>180||Math.abs(p.y())>90||p.z()<-450));
	}
public static void main(String[] args) {
	Point3D p1 = new Point3D(32.103315 , 35.209039, 670);
	Point3D p2 = new Point3D(32.106352, 35.205225, 650);
	MyCoords c = new MyCoords();
	double[] p3 = c.azimuth_elevation_dist(p1, p2);
	for (int i = 0; i < p3.length; i++) {
		System.out.println(p3[i]);
	}
	System.out.println();
	System.out.println("vector "+c.vector3D(p1, p2));

}
	
	

}
