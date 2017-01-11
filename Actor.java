/**
 * 
 * @author Varun Batra
 * 110256128
 * This class implaements an instance of actor
 *
 */
public class Actor {
	private String name;
	private int count;
	public Actor(String name){
		this.name= name;
	}
	/**
	 * 
	 * @param count
	 * number of movies
	 * set actors number of movies to count
	 */
	public void setCount(int count){
		this.count= count;
	}
	/**
	 * 
	 * @param name
	 * name of actor
	 * set name of actor to name
	 */
	public void setName( String name){
		this.name=name;
		
	}
	/**
	 * 
	 * @return int
	 * return number of movies of actor
	 */
	public int getCount(){
		return this.count;
				
	}
	/**
	 * 
	 * @return String
	 * return name of actor
	 */
	public String getName(){
		return this.name;
				
	}
	

	

}

