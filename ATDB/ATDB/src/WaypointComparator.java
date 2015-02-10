/**
 * WaypointComparator.java compares Waypoint objects by its parameters to be sorted
 * @author Nick Colvin
 * @version 02/05/2015
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
	private String field;
	private boolean isAsc;
	private ArrayList<String> searchTerms = new ArrayList<String>(Arrays.asList("TY","NA","ST","LA","LO","DS","DK","EL"));
	
	/**
	 * initializes WaypointComparator object
	 * @param f = sort field
	 * @param ia = ascending or not ascending
	 */
	public WaypointComparator(String f, boolean ia) {
		field = f;
		isAsc = ia;
	}
	
	/**
	 * compares two Waypoint objects based on sorting field
	 * @param w1 = first Waypoint object
	 * @param w2 = second Waypoint object
	 */
	public int compare(Waypoint w1, Waypoint w2) {
		if(field.equals(searchTerms.get(0))) {
			String l1 = w1.getType();
			String l2 = w2.getType();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(1))) {
			String l1 = w1.getName();
			String l2 = w2.getName();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(2))) {
			String l1 = w1.getState();
			String l2 = w2.getState();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(3))) {
			Double l1 = w1.getLatitude();
			Double l2 = w2.getLatitude();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(4))) {
			Double l1 = w1.getLongitude();
			Double l2 = w2.getLongitude();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(5))) {
			Double l1 = w1.milesToSpringer();
			Double l2 = w2.milesToSpringer();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(6))) {
			Double l1 = w1.milesToKatahdin();
			Double l2 = w2.milesToKatahdin();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else if(field.equals(searchTerms.get(7))) {
			Integer l1 = w1.getElevation();
			Integer l2 = w2.getElevation();
			return ! isAsc ? l1.compareTo(l2) : l1.compareTo(l2) * -1;
		}
		else
			return 0;
	}
}