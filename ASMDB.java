import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * this is the runner class
 */
public class ASMDB {
	MovieManager m = new MovieManager();
	/**
	 * display main menu
	 */
	public void mainMenu(){
		System.out.println("I) Import Movie <Title>" );
		System.out.println("D) Delete Movie <Title>" );
		System.out.println("M) Sort Movies" );
		System.out.println("A) Sort Actors" );
		System.out.println("Q) Quit" );
		this.menuOperate();
	}
	/**
	 * operate menu options
	 */
	
	public void menuOperate(){
		
		Scanner scan = new Scanner(System.in);
		switch(scan.next().toUpperCase()){
		case "I":System.out.println("Please enter the title");
		String url = scan.next();
		Movie movie = new Movie(url);
		m.movieList.add(movie);// add the movie
		for(int i =0; i<movie.getActors().size();i++){
			for(int j =0; j< this.m.actorList.size();j++){
				if(this.m.actorList.get(j).getName().equals(movie.getActors().get(i))){
					this.m.actorList.get(j).setCount(this.m.actorList.get(j).getCount()+1);
				}// if the actor already exists then increase movie count
			}
		}
		m.actorList.addAll(movie.getActors());// add the new actors
System.out.println("Movie added: "+movie.getTitle());
this.menuOperate();
break;
		case"D": //remove movie
			System.out.println(" Please enter title of movie to be removed");
		String title = scan.next();
		
			m.movieList.remove(m.findMovie(title));// remove the object if it exists
		System.out.println(title + " removed");
		this.menuOperate();
		break;
		case"M": this.sortMovies();
		this.menuOperate();
		break;
		case"A":
			this.sortActors();
		break;
		case"Q":System.out.println("Exiting..."); break; // quit
		}
		
	
		
	}
	/**
	 * display menu
	 */
	private void sortMovies() {
		System.out.println("TA) Title Ascending (A-Z)" );
		System.out.println("TD) Title Descending (Z-A)" );
		System.out.println("YA) Year Ascending" );
		System.out.println("YD) Year Descending" );
		this.sortMoviesOperate();
	}
	/**
	 * display menu
	 */
	public void sortActors(){
		System.out.println("AA) Alphabetically Ascending (A-Z)" );
		System.out.println("AD) Alphabetically (Z-A)" );
		System.out.println("NA) Number of movies they are in Ascending" );
		System.out.println("ND) Number of movies they are in Descending" );
		this.sortActorsOperate();
	}
	private void sortActorsOperate() {
		Scanner scan = new Scanner(System.in);
		switch(scan.next().toUpperCase()){
		case"AA": Comparator c = new NameComparator();
		// sort by specific comparator
			Collections.sort(m.actorList, c);
			System.out.println("Actors            Movies");
			System.out.println("---------------------");
		
		for(int i =0; i< m.actorList.size();i++){
			System.out.println(m.actorList.get(i).getName()+"\t"+ "  "+ m.actorList.get(i).getCount());
		}
		this.mainMenu();
		break;
		case"AD": Comparator cD = new NameComparator();
		// sort in reverse
		cD= Collections.reverseOrder(cD);
		Collections.sort(m.actorList, cD);
		for(int i =0; i< m.actorList.size();i++){
			System.out.println(m.actorList.get(i).getName()+"\t"+ "  "+ m.actorList.get(i).getCount());
		}
		this.mainMenu();
		break;
		case"NA": Comparator count = new CountComparator();
		// sort by comparator
		m.getSortedActors(count);
		for(int i =0; i< m.actorList.size();i++){
			System.out.println(m.actorList.get(i).getName()+"\t"+ "  "+ m.actorList.get(i).getCount());
		}
		this.mainMenu();
		break;
		case"ND": Comparator countD = new CountComparator();
		// sort in reverse
		m.descendingActors(countD);
		for(int i =0; i< m.actorList.size();i++){
			System.out.println(m.actorList.get(i).getName()+"\t"+ "  "+ m.actorList.get(i).getCount());
		}
		this.mainMenu();
		break;
		}
		
	}
	private void sortMoviesOperate() {
	Scanner scan = new Scanner(System.in);
	switch(scan.next().toUpperCase()){
	case"TA":
		Comparator n = new TitleComparator();
		// sort by title
	Collections.sort(this.m.movieList,n);
	System.out.println("Title "+"\t"+"\t"+ "\t"+ "Year"+ "\t"+ "Actors");
	System.out.println("-------------------------------------------");
	for(int i =0; i<m.movieList.size();i++){
		// print out
		System.out.print(m.movieList.get(i).getTitle()+"\t"+"\t"+ "\t"+ m.movieList.get(i).getYear()+"\t");
		m.movieList.get(i).printActors();
		System.out.println();
	}
		this.mainMenu();
		break;
	case"TD": 
		Comparator nD = new TitleComparator();
		// sort by title in reverse
		nD= Collections.reverseOrder(nD);
		Collections.sort(m.movieList, nD);
		System.out.println("Title "+"\t"+"\t"+ "\t"+ "Year"+ "\t"+ "Actors");
		System.out.println("-------------------------------------------");
		for(int i =0; i<m.movieList.size();i++){
			// print out
			System.out.print(m.movieList.get(i).getTitle()+"\t"+"\t"+ "\t"+ m.movieList.get(i).getYear()+"\t");
			m.movieList.get(i).printActors();
			System.out.println();
		}
		this.mainMenu();
		break;
	case"YA": 
		Comparator y = new YearComparator();
		m.getSortedMovies(y);
		System.out.println("Title "+"\t"+"\t"+ "\t"+ "Year"+ "\t"+ "Actors");
		System.out.println("-------------------------------------------");
		for(int i =0; i<m.movieList.size();i++){
			System.out.print(m.movieList.get(i).getTitle()+"\t"+"\t"+ "\t"+ m.movieList.get(i).getYear()+"\t");
			m.movieList.get(i).printActors();
			System.out.println();
		}
		this.mainMenu();
		break;
	case"YD":
		Comparator yD = new YearComparator();
		m.descendingMovies(yD);
		System.out.println("Title "+"\t"+"\t"+ "\t"+ "Year"+ "\t"+ "Actors");
		System.out.println("-------------------------------------------");
		for(int i =0; i<m.movieList.size();i++){
			System.out.print(m.movieList.get(i).getTitle()+"\t"+"\t"+ "\t"+ m.movieList.get(i).getYear()+"\t");
			m.movieList.get(i).printActors();
			System.out.println();
		}
		this.mainMenu();
		break;
		
		
		
	}
		
	}
	public static void main(String [] args){
		ASMDB runner = new ASMDB();
		runner.mainMenu();
		

		
	}

}
