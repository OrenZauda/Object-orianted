package GIS;

import Geom.Point3D;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class data implements Meta_data {
	public String []c;
	long time;
	String Textplace;
	String mac;
	String name ,automode,firstseen,channel,RSSI,
	AccuracyMeters,Type;

	public data(String []b) {
    this.c=b;
	}
	public void getdata() {
		mac= c[0];
		name= c[1];
        automode=c[2];
        firstseen = c[3];
        channel= c[4];
        RSSI=c[5];
        AccuracyMeters=c[6];
        Type=c[10];
        
	}

	@Override
	public long getUTC() {
		ZonedDateTime utc =ZonedDateTime.now(ZoneOffset.UTC);
		Long a=utc.toInstant().toEpochMilli();
		return (a);
	}
	@Override
	public String toString(){
		String s="Timestamp: "+time+"";
		return s;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}


}
