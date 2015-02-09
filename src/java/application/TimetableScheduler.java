package application;
/**
 *
 * @author mjb2
 */
import dbpackage.*;

public class TimetableScheduler 
{
    public TimetableScheduler( ) 
    {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
}
