/**
 * TrailDatabase.java builds a database of Appalachian Mountain trails, and allows users to sort and view them by their
 * category.
 * @author Nick Colvin
 * @version 02/05/2015
 */

import java.io.*;
import java.util.*;

public class TrailDatabase {
	ArrayList<Waypoint> myPoints;
	ArrayList<Waypoint> helperArray;
	
	/**
	 * creates instance of TrailDatabase object
	 */
	public TrailDatabase() {
		myPoints = new ArrayList<Waypoint>();
		helperArray = new ArrayList<Waypoint>();
		populateDatabase();
	}
	
	/**
	 * adds waypoints to an array in order to be sorted
	 */
	private void populateDatabase()	{
		Scanner in = null;
		try	{
			in = new Scanner(new File("apptrailDB.txt"));
			while(in.hasNext()) {
				String[] temp = in.nextLine().split("\t");
				String t = temp[0];
				String n = temp[1];
				String s = temp[2];
				double lat = Double.parseDouble(temp[3]);
				double lon = Double.parseDouble(temp[4]);
				double dfs = Double.parseDouble(temp[5]);
				double dfk = Double.parseDouble(temp[6]);
				int el = Integer.parseInt(temp[7]);
				myPoints.add(new Waypoint(t,n,s,lat,lon,dfs,dfk,el));
				helperArray.add(new Waypoint(t,n,s,lat,lon,dfs,dfk,el));
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	/**
	 * gets user's sort field and whether or not it is ascending
	 * @return field user wants to sort by, ascending or not ascending
	 */
	public String[] getSearchTerms() {
		Scanner input = new Scanner(System.in);
		System.out.println("*** Welcome to the Appalachian Trail Database ***\n" + "+ Menu of search terms to use for sorting waypoints +");
		System.out.print("\tTY: by type\n\tNA: by name\n\tST: by state\n\tLA: by latitude\n\tLO: by longitude\n\tDS: by distance to Springer\n\tDK: by distance to Katahdin\n\tEL: by elevation\n");
		System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
		String param = input.nextLine().toUpperCase();
		if(!param.equals("Q")) {
			System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
			return new String[] {param, input.nextLine().toUpperCase()};
		}
		input.close();
		return null;
	}
	
	/**
	 * prints out each waypoint of waypoint database
	 */
	public void printDatabase() {
		for(Waypoint point : myPoints) {
			System.out.println(point);
		}
	}
	
	/**
	 * calls mergesort
	 * @param wc = user's sorting field choice
	 */
	public void sortDB(WaypointComparator wc) {
		doMergeSort(0,myPoints.size()-1,wc);
	}
	
	/**
	 * 
	 * @param low = index of merge array
	 * @param high = index of merge array
	 * @param wc = user's sorting field choice
	 */
	private void doMergeSort(int low, int high, WaypointComparator wc) {
		if (low < high) {
	    	int middle = low + (high - low) / 2;
	    	doMergeSort(low, middle, wc);
	    	doMergeSort(middle + 1, high, wc);
	    	merge(low, middle, high, wc);
		}
	}

	/**
	 * merges together two smaller arrays in ascending or descending order
	 * @param low = low index of array
	 * @param middle = middle of array
	 * @param high = high index of array
	 * @param wc = user's sorting field choice
	 */
	public void merge(int low, int middle, int high, WaypointComparator wc) {
		for (int i = low; i <= high; i++)
			helperArray.set(i, myPoints.get(i));
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (wc.compare(helperArray.get(i), helperArray.get(j)) > 0) {
				myPoints.set(k, helperArray.get(i));
				i++;
			} else {
				myPoints.set(k, helperArray.get(j));
				j++;
			}
			k++;
		}
		while (i <= middle) {
			myPoints.set(k, helperArray.get(i));
	    	k++;
	    	i++;
	    }
	} 

	/**
	 * main method to create and populate waypoint database, allows users to sort and view database
	 * @param command line args, if needed
	 */
	public static void main(String[] args) {
		List<String> searchTerms = Arrays.asList("TY","NA","ST","LA","LO","DS","DK","EL");
		TrailDatabase run = new TrailDatabase();
		while(true) {
			String[] userTerms = run.getSearchTerms();
			if(userTerms == null)
				break;
			if(searchTerms.contains(userTerms[0]) && userTerms[1].equals("A") || userTerms[1].equals("D")) {
				run.sortDB(new WaypointComparator(userTerms[0], userTerms[1].equals("A")));
				run.printDatabase();
			}
			else
				System.err.println("Error: bad input");
		}
	}
}
