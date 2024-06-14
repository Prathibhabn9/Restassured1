package pojoFramework;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOClass {
	private String badmintonBrand;
	private String racketName;
	public String getBadmintonBrand() {
		return badmintonBrand;
	}
	public void setBadmintonBrand(String badmintonBrand) {
		this.badmintonBrand = badmintonBrand;
	}
	public String getRacketName() {
		return racketName;
	}
	public void setRacketName(String racketName) {
		this.racketName = racketName;
	}
	
	@Test
	public void BadmintonJsonFromPOJOClass() throws JsonProcessingException {
		POJOClass objpojo=new POJOClass();
		objpojo.setBadmintonBrand("Yonex");
		objpojo.setRacketName("V-50");
		//class object->String (JSON Object Payload)
		ObjectMapper objMapper=new ObjectMapper();
		String objpojojson=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objpojo);
		System.out.println(objpojojson);
		
		//desrialization
		POJOClass objpojo2 = objMapper.readValue(objpojojson, POJOClass.class);
		System.out.println("BadmintonBrand: "+objpojo2.getBadmintonBrand());
		System.out.println("Racket Name: "+objpojo2.getRacketName());
		
	}

}
