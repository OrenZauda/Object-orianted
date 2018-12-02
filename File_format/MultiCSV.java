package File_format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.io.*; 
import java.util.*; 
import GIS.data;
import File_format.CSVReader;
import GIS.layer;
import GIS.project;



public class MultiCSV {
	String v;
	layer a;
	data b;
	project f;
	public MultiCSV(String s) {	
		v=s;
	}

	public project scan(String s) throws IOException {

		File directory = new File(s+"");
		String [] content = directory.list();
		for(int i=2;i<content.length;i++) {
			if(content[i].substring(content.length-2).equals("csv")) {


				File test =new File (content[i]);
				if(test.isDirectory()) {
					f.array.addAll(scan(content[i]).array);
				}

				// create csv reader "t"
				CSVReader t=new CSVReader(content[i]);
				// layer->data->string= current csv file
				a.x.c=t.layer(i);
				// layer->data->method get data to create string[] full in data
				a.x.getdata();
				f.array.add(a);
			}

		}


		return f;
	}
	public project kml(String s) throws IOException {
		
		File directory = new File(s+"");
		String [] content = directory.list();
		for(int i=2;i<content.length;i++) {
			if(content[i].substring(content.length-2).equals("csv")) {
				File test =new File (content[i]);
				if(test.isDirectory()) {
					f.array.addAll(kml(content[i]).array);
				}
				Csv2kml a=new Csv2kml(content[i],i);
			}
		}
		return null;
	}
}
