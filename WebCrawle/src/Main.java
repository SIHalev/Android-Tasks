import java.net.URI;
import java.net.URISyntaxException;


public class Main {

	public static void main(String[] args) {
		WebCrawler crawler = new WebCrawler();
	    URI startLocation;
	    
		try {
			startLocation = new URI("http://ebusiness.free.bg");
		
		    crawler.crawl(startLocation, "Револвираща"); 
		    //System.out.println("result :" + link.toString()); //=> http://ebusiness.free.bg/cards_bank_cards.html
		        ////////////
		    startLocation = new URI("http://blog.hackbulgaria.com");
		    crawler.crawl(startLocation,
		            "Като страничен ефект, особено при момчетата, може да бъде бързо-растяща брада.");
	
		   // => http://blog.hackbulgaria.com/fall-of-the-hackers/
		        //////
		    startLocation = new URI("http://fmi.wikidot.com");
		    crawler.crawl(startLocation, "Докажете, че:");
	
		    // => http://fmi.wikidot.com/anal-examination-1
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
