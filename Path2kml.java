package Pacman;

import java.io.File;
import java.util.Iterator;

import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;

public class Path2kml {
	// this field contain the path we working on
	public path a;
	public int u;
	//simple constructor
	
	// field to set kml location
	File kmlLoc; 
	public Path2kml(path x) {
		a=x;	
	}
	//this function converting path to kml file
	public void tokml() {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("csvToKml "+u).withOpen(true);		
		String line = "";
		String cvsSplitBy = ",";
	    String csvFile;
	    Iterator <Point3D> here = a.path.iterator();
	    while (here.hasNext()) {
	    	Point3D temp= here.next();
	    	double longitude=temp.getx();
	    	double latitude=temp.gety();
	    	
	    	
	    }
		
	}
	
}
