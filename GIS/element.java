package GIS;

import Geom.Geom_element;
import Geom.Point3D;
import File_format.CSVReader;
import GIS.data;
public class element implements GIS_element {


	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//
	//	}
	data a;
	String color = "";
	long time = 0;
	String Textplace = null;
	CSVReader b;
	public String c[][] = null;
	Point3D d =new Point3D(0,0,0);
	public element() {
		
	}

	public Point3D getpoint(double s,double s2,double s3 ) {
		d.setAlt(s);
		d.setLat(s2);
		d.setLon(s3);
	    return d;
	}

	@Override
	public Geom_element getGeom() {
       return d;
		
	}

	@Override
	public Meta_data getData() {
		return a;
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub

	}

}
