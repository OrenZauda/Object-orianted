package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import GIS.data;
public class layer extends ArrayList<GIS_element> implements GIS_layer{
    public data x;
	public void setdata(data b) {
	x=b;	
	}
	public Meta_data get_Meta_data() {
		return x;
	}

	

	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
