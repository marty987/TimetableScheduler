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
        database.setup( "localhost", "timetable_scheduler_db", "root", "" );
    }
    
}
