import java.util.ArrayList;
import java.util.List;

import big.data.DataSource;
/**
 * 
 * @author Varun Batra
 * 110256128
 *
 */

public class Movie {
	private String title;
	private int year;
	private List<Actor> list= new ArrayList<>();
	public Movie(String title, int year){
		this.title= title;
		this.year= year;
	}
	/**
	 * 
	 * @param url
	 * title of movie
	 * make a movie based on the object recieved from the url
	 */
	public Movie(String url){
		 String prefix= "http://www.omdbapi.com/?t=";
		 String postfix="&y=&plot=short&r=xml";
		 DataSource ds = DataSource.connectXML(prefix+url.
				 replace(' ','+')+postfix);
		ds.load();
		// gettin the information from DB
		String title = ds.fetchString("movie/title");
		int year = ds.fetchInt("movie/year");
		this.title= title;
		this.year= year;
		// sets the title to the title acquired from DB
		//sets the year of this title to the year acquired from DB
		String list= ds.fetchString("movie/actors");
	String[] actors=	list.split(", ");
	for(int i=0; i<actors.length;i++){
	
		
			Actor a = new Actor(actors[i]);
		a.setCount(a.getCount()+1);
		this.list.add(a);
		
		// sets list of actor to this movie to the list acquired from DB
	}
		
	
	}
	/**
	 * 
	 * @return String
	 * title of this movie
	 */
	public String getTitle(){
		return this.title;
	}
	/**
	 * 
	 * @return int
	 * year of this movie
	 */
	public int getYear(){
		return this.year;
	}
	/**
	 * 
	 * @return List
	 * actors of this movie
	 */
	public List getActors(){
		return this.list;
	}
	/**
	 * 
	 * @param title
	 * set title of this movie to title
	 */
	public void setTitle(String title){
		this.title=title;
		
	}
	/**
	 * 
	 * @param year
	 * set year of this movie to year
	 */
	public void setYear(int year){
		this.year= year;
	}
	/**
	 * 
	 * @param list
	 * set actors of this movie to new list of actors
	 */
	public void setActors(List list){
	this.list= list;
}
	/**
	 * Print out the actors in the movie 
	 */
	public void printActors(){
		for(int i =0;i<this.list.size();i++){
			System.out.print(this.list.get(i).getName()+", ");
		}
	}

	public static void main(String []args){
		System.out.println("run");
	}
	
	public boolean findActor(String name){
		boolean m = false;
		for(int i =0; i<this.list.size();i++){
			if(this.list.get(i).getName().equals(name)){
				m=true;
			}
		}
		return m;
	}
	public Actor returnActor(String name){
		Actor m = null;
		for(int i =0; i<this.list.size();i++){
			if(this.list.get(i).getName().equals(name)){
				m=this.list.get(i);
			}
		}
		return m;
	}
	
}

	
	
	
	



