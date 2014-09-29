import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebCrawler {
	public static List<String> visitedLinks;
	
	public void crawl(URI startLocation, String input){
		visitedLinks = new ArrayList<String>();
		//String searchedLink = searchContent(startLocation.toString(), input);
		searchContent(startLocation.toString(), input);
		//if (searchedLink != "404") {
		//	return new URI(searchedLink);
		//}
	
	}
		 	
   //private String searchContent(String location, String input) {
	private void searchContent(String location, String input) {
    
    	Pattern pattern = Pattern.compile(
                "href=\"([^\"]*).html\"");
    	
		URL url;
		try {
			url = new URL(location);
		
            BufferedReader in = new BufferedReader(
            		new InputStreamReader(url.openStream()));

            String inputLine;
            boolean contains = false;
            
            while ((inputLine = in.readLine()) != null) {    
                      
                Matcher matcher = pattern.matcher(inputLine);
                
                while (matcher.find()) {
                	
                	String rawLink = matcher.group().toString();
                	String link = rawLink.substring(6, rawLink.length() - 1);
                	
                	if (!link.contains("../") && !link.contains("index.html") ) {
										                	
	                	boolean isVisited = false;
	                	for (int i = 0; i < visitedLinks.size(); i++) {
							if (visitedLinks.get(i) == link) {
								isVisited = true;
							}
						}
	                	
	                	if (!isVisited) {
	                		visitedLinks.add(link);
	                		//searchContent(location + "/" + link, input);
	                		searchContent(location + "/" + link, input);
						}
                	}
                               	             	
                }
            	           	
            	if(inputLine.contains(input)) {
            		contains = true;
            	}                                	 
            }
            
            if (contains) {	
            	System.out.println(location);
				//return location;		
			}  
            
            in.close();
           	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "404";
	}
}
