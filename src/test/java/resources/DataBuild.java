package resources;

import java.util.ArrayList;

import pojo.AddPlacePayload;
import pojo.Location;

public class DataBuild {
	
	public static AddPlacePayload addPlacePayload(String name)
	{
		AddPlacePayload p=new AddPlacePayload();
		
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress("29, side layout, cohen 09");
		p.setWebsite("http://google.com");
		p.setLanguage("Kannada");
		
		ArrayList<String> t=new ArrayList<String>();
		
		t.add("shoe park");
		t.add("shoe");
		
		p.setTypes(t);
		
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		
		
		return p;
	}

}
