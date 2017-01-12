package jdbcdemo;
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		
		
		
		// Denne databasen er borte nå, må legge inn ny.
		
		
		String url = "jdbc:mysql://localhost:8889/dat310_booking";
		String user ="root";
		String password ="root";
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try{
			// Get connection to database
			conn = DriverManager.getConnection(url, user, password);

			// Create a statement
			stmt = conn.createStatement();
			
			// Insert into database
			String sql = "insert into properties (name, location)"
					+ "values('Regimentet', 'Regimentveien, Hafrsfjord')";
			stmt.executeUpdate(sql);
			
			// Update database row
			String updatesql = "update properties set name = 'Rolf'"
					+ "where property_id = 1";
			stmt.executeUpdate(updatesql);
			
			// Delete database row
			String deletesql = "delete from properties where property_id = 3";
			int row_deleted = stmt.executeUpdate(deletesql);
			System.out.println("Rows affected: " + row_deleted);
			System.out.println("Delete complete");
			
			// Execute a SQL query
			res = stmt.executeQuery("select *from properties");
			System.out.println("Insert complete.");
			
			// Process the result set
			while(res.next()){
				System.out.println(res.getString("name") + ", " + res.getString("location"));
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		finally
	    {
	        // Her er det god praksis og terminere connection.
	    }

	}

}
