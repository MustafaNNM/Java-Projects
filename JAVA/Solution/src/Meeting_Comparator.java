import java.util.Comparator;

/**
 * 
 */

/**
 * @author PC
 *
 */
public class Meeting_Comparator implements Comparator<Meeting> {


	@Override
	public int compare(Meeting m1, Meeting m2) {
		// TODO Auto-generated method stub
		return m1.start_time.oncelik - m2.start_time.oncelik;
	}

}
