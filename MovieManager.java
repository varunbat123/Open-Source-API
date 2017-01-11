
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 
 * @author Varun
 *110256128
 *this class implements a type MovieManager
 */
public class MovieManager {
	List <Movie> movieList = new ArrayList<>();
	List <Actor> actorList = new ArrayList<>();
	/**
	 * 
	 * @return List<Movie>
	 * return this movieList
	 */
	public List<Movie> getMovies(){
		return this.movieList;
	}
	/**
	 * 
	 * @return List<Actor>
	 * return this actorList
	 */
	public List<Actor> getActors(){
		return this.actorList;
	}
	/**
	 * 
	 * @param comparable
	 * comparator
	 * @return List<Movie>
	 * return sorted list 
	 */
	public List<Movie> getSortedMovies( Comparator comparable){
		
		partition(0,this.movieList.size()-1,this.movieList,comparable);
		return movieList;
		
	}
	/**
	 * 
	 * @param compare
	 * com
	 * @return List<Movie>
	 * 
	 */
	public List<Movie> descendingMovies (Comparator compare){
		compare= Collections.reverseOrder(compare);
		Collections.sort(this.movieList, compare);
		return movieList;
		
	}
	public List<Actor> getSortedActors(Comparator compare){

		partition(0,this.actorList.size()-1,this.actorList,compare);
		return actorList;
		
	}
	public List<Actor> descendingActors(Comparator compare){
	compare=	Collections.reverseOrder(compare);
		Collections.sort(this.actorList, compare);
		return actorList;
	}
	public void partition(int pivot, int n, List list, Comparator comparable){

		
		
		int greater=0;
		int smaller =0;
		if(pivot==n){
		
			return;
		}
		for(int i = 0; i<pivot;i++){
			if(comparable.compare(list.get(i), list.get(pivot))==1){
				greater = i;
				break;
			}			
			
		}
		for(int i =n;i>pivot;i--){
			if(comparable.compare(list.get(i), list.get(pivot))==-1){
				smaller = i;
				break;
			}
		}
		swap(greater,smaller, list);
		partition(smaller, greater, list, comparable);
		
	}
	private void swap(int greater, int smaller, List movieList2) {
		Object temp;
		temp= movieList2.get(smaller);
		movieList2.set(smaller, movieList2.get(greater));
		movieList2.set(greater, temp);
	}
	public Movie findMovie(String name){
		Movie m = null;
		for(int i =0; i<this.movieList.size();i++){
			if(this.movieList.get(i).getTitle().equals(name)){
				m=this.movieList.get(i);
			}
		}
		return m;
	}
	public static void main(String[]args){
		
		MovieManager m = new MovieManager();
		Movie m1 = new Movie("j",4);
		Movie m2 = new Movie("j",7);
		m.movieList.add(m1);
		m.movieList.add(m2);
		YearComparator y = new YearComparator();

		for(int i =0; i<m.movieList.size();i++){
			System.out.println(m.movieList.get(i).getYear());
		}
		
		
	}

}

