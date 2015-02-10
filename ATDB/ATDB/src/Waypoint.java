/**
 * A Waypoint object is an object of note along or on the Appalachian Trail
 * in the Eastern United States, running from Mt. Katahdin in Maine to 
 * Springer Mountain in Georgia. Trail distance is 2189.2 miles in 2014.
 * 
 * This class offers an implementation of the Comparable interface, a first
 * for the APCS 2014-15 class.
 * 
 * @author Nick Colvin
 * @version 02/05/2015
 */

public class Waypoint {
	private String type, name, state;
	private double latitude, longitude;
	private double distanceToSpringer, distanceToKatahdin;
	private int elevation;
	
	/**
	 * Parameterized constructor for class Waypoint. Used for importing and parsing data in the text file.
	 * @param t
	 * @param n
	 * @param st
	 * @param lat
	 * @param lon
	 * @param dts
	 * @param dtk
	 * @param el
	 */
	public Waypoint(String t, String n, String st, double lat, double lon, double dts, double dtk, int el)	{
		type = t;
		name = n;
		state = st;
		latitude = lat;
		longitude = lon;
		distanceToSpringer = dts;
		distanceToKatahdin = dtk;
		elevation = el;
	}
	
	/**
	 * The type of the Waypoint
	 * @return
	 */
	public String getType()		{	return type;	}
	
	/**
	 * The name of the Waypoint
	 * @return
	 */
	public String getName()		{	return name;	}
	
	/**
	 * The state in which the Waypoint is located
	 * @return
	 */
	public String getState()		{	return state;	}
	
	/**
	 * The latitude of the Waypoint
	 * @return
	 */
	public double getLatitude()		{	return latitude;	}
	
	/**
	 * The longitude of the Waypoint
	 * @return
	 */
	public double getLongitude()		{	return longitude;	}
	
	/**
	 * The miles to Springer Mountain, GA from this Waypoint
	 * @return
	 */
	public double milesToSpringer()	{	return distanceToSpringer;	}
	
	/**
	 * The miles to Mt. Katahdin, ME from this Waypoint
	 * @return
	 */
	public double milesToKatahdin()	{	return distanceToKatahdin;	}
	
	/**
	 * The elevation (in feet) of this Waypoint
	 * @return
	 */
	public int getElevation()	{	return elevation;	}
	
	/**
	 * Convert this Waypoint data to a single String
	 * @return
	 */
	public String toString()	{
		return type + "\t" + name + "\t" + state + "\t" + latitude + "\t" + longitude + 
				 "\t" + distanceToSpringer + "\t" + distanceToKatahdin + "\t" + elevation;
	}
	
	/**
	 * This parameter MUST be of type Object
	 * Overriding Object.equals method
	 */
	public boolean equals(Object other)	{
		Waypoint temp = (Waypoint)other;
		return this.type.equals(temp.type) &&
				this.name.equals(temp.name) &&
				this.state.equals(temp.state) &&
				this.elevation == temp.elevation;
	}
	
	/**
	 * Method not being used; can be uncommented if the programmer wants to have Waypoint implement Comparable<Waypoint>
	 * @param other Another Waypoint object
	 * @return -int if the elevation of this object is less than other, 0 if equal, +int if greater
	 */
	public int compareTo(Waypoint other)	{
		return this.elevation - other.elevation;
	}
}