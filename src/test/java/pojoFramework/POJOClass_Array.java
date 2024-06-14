package pojoFramework;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOClass_Array {
	//Data members
	private String badmintonBrand;
	private String racketName;
	
	//getters and setters
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
	public String allPojoCLassJSONPayload;
	@Test
	public void CreateList() throws JsonProcessingException {
		
		//Badminon Detail 1
		POJOClass_Array yonex = new POJOClass_Array();
		yonex.setBadmintonBrand("Yonex");
		yonex.setRacketName("Y-50");
	
		//Badminon Detail 2
		POJOClass_Array Lining = new POJOClass_Array();
		Lining.setBadmintonBrand("Lining");
		Lining.setRacketName("L-50");
		
		//Badminon Detail 3
		POJOClass_Array Victor = new POJOClass_Array();
		Victor.setBadmintonBrand("Victor");
		Victor.setRacketName("Ryuga");
		
		//Creating List
		List<POJOClass_Array> allBadmintonDetails = new ArrayList<POJOClass_Array>();
		allBadmintonDetails.add(yonex);
		allBadmintonDetails.add(Lining);
		allBadmintonDetails.add(Victor);
		
		//Class Object --> String (JSON Array Payload) -- Serialization
		ObjectMapper objectMapper1 = new ObjectMapper();
		allPojoCLassJSONPayload = objectMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(allBadmintonDetails);
		System.out.println(allPojoCLassJSONPayload);
		
		//String (JSON Object Payload) --> Class Object  - Deserialization
		ObjectMapper objectMapper2 = new ObjectMapper();
		List<POJOClass_Array> allBadmintonDetails2 = objectMapper2.readValue(allPojoCLassJSONPayload, new TypeReference<List<POJOClass_Array>>() {});
		
		for(POJOClass_Array badmin : allBadmintonDetails2) {
			System.out.println("======================================================================");
			System.out.println("BadmintonBrand: "+badmin.getBadmintonBrand());
			System.out.println("RacketName: "+badmin.getRacketName());
		}
	
	}
	
}
