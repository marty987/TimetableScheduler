package notifications;
/**
 * @author Martin Bullman 112735341
 * @since Feb 24, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersNotifications {
    private DatabaseClass database;
    private Statement statementObject;
    private Connection connectionObject;
    
    public void getUsersNotifications( String userId ) throws SQLException {
        String notifications;
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        try{
            statementObject = connectionObject.createStatement( );
            ResultSet statementResult = statementObject.executeQuery( "SELECT * FROM events JOIN has_events JOIN " ); //Should connection be left open?
    
            notifications = "<table>";
            notifications = "<th>Event Name</th><th></th>";
            
            while( statementResult.next( ) ){
                notifications += "<tr>" ;
            }
        }
        catch( SQLException exceptionObject ){
           
        }
    }
}
