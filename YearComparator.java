import java.util.Comparator;

/**
 * 
 * @author Varun
 *This class implements a comparable instance that compares years of movies
 */
public class YearComparator implements Comparator {
/**
 * @param object o1
 * movie object 1
 * @param object o2
 * movie object 2
 * @return int
 * 
 * 1 if object > object 2
 * -1 if object 1 < object 2
 * 0 if equal
 */
	@Override
	public int compare(Object o1, Object o2) {
		Movie m1 = (Movie) o1;
		Movie m2 = (Movie) o2;
		if(m1.getYear()==m2.getYear()){
		return 0;
		}
		else if(m1.getYear()>m2.getYear()){
			return 1;
		}
		else
			return -1;
	}

}
