
import java.util.Comparator;
/**
 * 
 * @author Varun
 *110256128
 */
public class TitleComparator implements Comparator{
/**
 * return 1 if m1 >m2
 * -1 if m1<m2
 * 0 if m1=m2
 */
	@Override
	public int compare(Object o1, Object o2) {
		Movie m1 = (Movie)o1;
		Movie m2 = (Movie)o2;
		return m1.getTitle().compareTo(m2.getTitle());
	}

}