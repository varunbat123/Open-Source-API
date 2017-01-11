import java.util.Comparator;

/**
 * 
 * @author Varun
 *This class implements a comparable instance that number of movies actors are in
 */
public class CountComparator implements Comparator {
	/**
	 * @param object o1
	 * actor object 1
	 * @param object o2
	 * actor object 2
	 * @return int
	 * 
	 * 1 if object > object 2
	 * -1 if object 1 < object 2
	 * 0 if equal
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Actor a1 = (Actor) o1;
		Actor a2 = (Actor) o2;
		if(a1.getCount()>a2.getCount()){
			return 1;
		}
		else if (a1.getCount()==a2.getCount()){
			return 0;
		}
		else
			return -1;
	}

}

