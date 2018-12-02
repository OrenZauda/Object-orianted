package File_format;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import GIS.element;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;


public class Csv2kml {
	
	public String csvFile;
	File kmlLoc;
	element y;
	int u;

	public Csv2kml(String s, int i) {
		csvFile=s;
		u=i;
		kmlLoc=new File("C:\\temp\\final.kml");
	}
	
	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}

	public File getKmlLoc() {
		return kmlLoc;
	}

	public void setKmlLoc(File kmlLoc) {
		this.kmlLoc = kmlLoc;
	}

	public Csv2kml (String newCSVfile,File newKmlFile) {
		csvFile=newCSVfile;
		kmlLoc=newKmlFile;
	}
	
	/**
	 * This function get the new merge CSV file and converting it to a KML file
	 * @throws IOException
	 */
	public void CsvToKml() throws IOException {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("csvToKml "+u).withOpen(true);		
		String line = "";
		String cvsSplitBy = ",";


		// create a Folder
		Folder folder = doc.createAndAddFolder();
		folder.withName("CSV to KML").withOpen(true);

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			br.readLine(); // this will read the first line
			br.readLine();
		
			while ((line = br.readLine())!=null) {
				String[] column = line.split(cvsSplitBy);
				element u=new element();
				u.getpoint(Double.parseDouble(column[7]), Double.parseDouble(column[8]), Double.parseDouble(column[6]));
				Point3D T=(Point3D)u.getGeom();
				double lat=T.gety();
				double lon=T.getx();
				double alt=T.getz();
				String Frequency=column[5];
				String BSSID = column[0];
				String Capabilities = column[2];
			    String time=column [3];
				// create Placemark elements
				createPlacemark(doc, folder, time, column[1], column[1],  
						BSSID, Frequency, Capabilities, lon
						, lat, alt);

			}
		}	

		// print and save
		kml.marshal(kmlLoc);

	}

	
	

	/**
	 * This function create a new placemark
	 * @param document
	 * @param folder
	 * @param Time
	 * @param ID
	 * @param SSID
	 * @param MAC
	 * @param Frequency
	 * @param Capabilities
	 * @param longitude
	 * @param latitude
	 * @param Alt
	 */
	public static void createPlacemark(Document document,
			Folder folder, String Time, String ID, String SSID,  
			String MAC, String Frequency,String Capabilities,
			double longitude, double latitude, double Alt ) {
		
		Icon icon = new Icon()
				.withHref("http://maps.google.com/mapfiles/ms/icons/blue-dot.png");//set the placemark icon
		Style style = document.createAndAddStyle();
		style.withId("style_" + ID) // set the stylename to use this style from the placemark
		.createAndSetIconStyle().withScale(0.8).withIcon(icon); // set size and icon
		style.createAndSetLabelStyle().withColor("5000FF14").withScale(1.0); // set color and size for the name

		Placemark placemark = folder.createAndAddPlacemark();
		// use the style for each placemark
		placemark.withName(ID)
		.withStyleUrl("#style_" + ID)
		.withDescription(
				"Time: <b>"+ Time +"</b><br/>ID: <b>"+ ID +"</b><br/>SSID: <b>"+ SSID +"</b><br/>"
						+ "MAC: <b>"+ MAC +"</b><br/>Frequency: <b>"+ Frequency +"</b><br/>"
						+ "Capabilities: <b>"+ Capabilities +"</b>")

		// coordinates and distance (zoom level) of the viewer
		.createAndSetLookAt().withLongitude(longitude).withLatitude(latitude).withAltitude(Alt);
		
		//Add TimeStamp
		placemark.createAndSetTimeStamp().setWhen(Time.replace(" ", "T")+"Z");
		
		placemark.createAndSetPoint().addToCoordinates(longitude, latitude); // set coordinates
	}

	public static void main(String[] args) throws IOException {
		Csv2kml a= new Csv2kml("C:\\temp\\file0.csv",1);
		a.CsvToKml();
	}
	
}