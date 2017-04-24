package agileboard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import errorutility.NoSuchStatusExistException;

public class StatusClass {
	
	public static final String START = "starting";
	public static final String inProgress = "inProgress";
	public static final String inReview = "inReview";
	public static final String DONE = "done";
	
	private static final String[] statuses = {START, inProgress, inReview, DONE};
	
	private static Map<String, String> statusName = new HashMap<>();
	
	static{
		for(String status: statuses){
			String name = splitCamelCaseString(status);
			statusName.put(status, name);
		}
	}
	
	public static Set<Column> initializeColumns(){
		Set<Column> boardCloumns = new HashSet<>();
		
		try{
		
			for(String status : statuses){
				boardCloumns.add(new Column(status, getStatusName(status)));
			}

		} catch (Exception ex){
			throw new RuntimeException("Error occured while Column initialization. " + ex.getMessage());
		}
		
		return boardCloumns;
	}
	
	private static String splitCamelCaseString(String s){
	    StringBuilder result = new StringBuilder();	
	    for (String w : s.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
	    	
	    	result.append(String.valueOf(w.charAt(0)).toUpperCase() + w.substring(1)).append(" ");
	    }    
	    return result.toString().trim();
	}
	
	public static String getStatusName(String status) throws NoSuchStatusExistException{
		
		String name = statusName.get(status);
		
		if(name == null){
			throw new NoSuchStatusExistException(status);
		}
		
		return name;
	}
	
}
