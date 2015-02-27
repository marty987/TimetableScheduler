package application;
/**
 * This class defines a user within the scheduling system's constraints. Also defines
 * functions to register the student with the system.
 * @author Martin Bullman 112735341
 * @since Feb 7, 2015, 12:56:25 PM
 */
import java.util.Date;
import emailsender.Email;
import java.util.Calendar;
import java.util.ArrayList;
import dbpackage.DatabaseClass;
import miscellaneous.PasswordHasher;
import java.text.SimpleDateFormat;

public class User {
    private String userId;
    private String stream;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password1;
    private String password2;
    private String phoneNo;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    /**
     * constructor for the class
     */
    public User( ) {
        userId = "";
        stream = "";
        firstName = "";
        middleName = "";
        lastName = "";
        email = "";
        password1 = "";
        password2 = "";
        phoneNo = "";
        errors = new ArrayList<>( );
        
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    /**
     * Getter method for the user's user id
     * @return the variable userID (string)
     */
    public String getUserId( ) {
        return userId;
    }
    /**
     * Setter method for the user's user id
     * @param userId (string)
     */
    public void setUserId( final String userId ) {
        System.out.println("test test");
        this.userId = userId;
    }
    /**
     * Getter method for the stream which the user is enrolled in. ie. Core stream, 
     * Web stream, Year 1 Computer Science
     * @return the variable stream (string)
     */
    public String getStream( ) {
        return stream;
    }
     /**
     * Setter method for the stream which the user is enrolled in. ie. Core stream, 
     * Web stream, Year 1 Computer Science
     * @param stream (string)
     **/
    public void setStream( final String stream ) {
        this.stream = stream;
    }
    /**
     * Getter method for the user's first name
     * @return the variable firstName (string)
     */
    public String getFirstName( ) {
        return firstName;
    }
    /**
     * setter method for the user's first name
     * @param firstName (string)
     */
    public void setFirstName( final String firstName ) {
        this.firstName = firstName;
    }
    /**
     * Getter method for the user's middle name
     * @return the variable middleName (string)
     */
    public String getMiddleName( ) {
        return middleName;
    }
    /**
     * Setter method for the user's middle name
     * @param middleName (string)
     */
    public void setMiddleName( final String middleName ) {
        this.middleName = middleName;
    }
    /**
     * Getter method for the user's last name
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    /**
     * Setter method for the user's last name
     * @param lastName (string)
     **/
    public void setLastName( final String lastName ) {
        this.lastName = lastName;
    }
    /**
     * Getter method for the user's email address
     * @return the variable email (string)
     */
    public String getEmail( ) {
        return email;
    }
    /**
     * Setter method for the user's email address
     * @param email (string)
     */
    public void setEmail( final String email ) {
        this.email = email;
    }
    /**
     * Getter method for the user's password1 (the original password.)
     * @return the variable password1 (string)
     */
    public String getPassword1( ) {
        return password1;
    }
    /**
     * Setter method for the user's password1 (the original password)
     * @param password1 (string)
    */
    public void setPassword1( final String password1 ) {
        this.password1 = password1;
    }
    /**
     * Getter method for the user's password2 (the password used to confirm the 
     * user's password choice)
     * @return the variable password2 (string)
     */
    public String getPassword2( ) {
        return password2;
    }
    /**
     * Setter method for the user's password2 (the password used to confirm the 
     * user's password choice)
     * @param password2 (string)
     */
    public void setPassword2( final String password2 ) {
        this.password2 = password2;
    }
    /**
     * Getter method for the user's phone number.
     * @return the variable phoneNo (string)
     */
    public String getPhoneNo( ) {
        return phoneNo;
    }
    /**
     * Setter method for the user's phone number.
     * @param phoneNo (string)
     */
    public void setPhoneNo( final String phoneNo ) {
        this.phoneNo = phoneNo;
    }
  /**
     * Ensures the form is filled out correctly by the user.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateRegForm( ) {
        boolean isValid = true;
        
        if(doesUserExist(userId)) {
            errors.add( "User already exists" );
            isValid = false;
            userId = "";
        }
        
        if( userId.equals( "" ) || userId.length( ) != 9 || ! isInteger( userId )) {
            errors.add( "User ID required. Must be valid ID and 9 digits in length" );
            isValid = false;
            userId = "";
        }
        
        if( firstName.equals( "" )  ) {
            errors.add( "First Name required." );
            isValid = false;
            firstName = "";
        }
      
        if( lastName.equals( "" )  ) {
            errors.add( "Last Name required." );
            isValid = false;
            lastName = "";
        }
        
        if( email.equals( "" ) || ! email.contains( "@" ) || ! email.contains( "." ) ) {
            errors.add( "Email required. Must be valid email address" );
            isValid = false;
            email = "";
        }
        
        if( password1.equals( "" ) ) {
            errors.add( "Password required. Min length is 6 characters" );
            isValid = false;
        }
        
        if( password2.equals( "" ) ) {
            errors.add( "Confirm Password required." );
            isValid = false;
        }
        
        if( ! password1.equals( password2 ) ){
            errors.add( "Passwords do not match. Must be identical" );
            isValid = false;
        }
        
        if( phoneNo.equals( "" ) || phoneNo.length( ) < 6 ) {
            errors.add( "Phone Number required. Must be valid phone number" );
            isValid = false;
            phoneNo = "";
        }
        
        if( isValid ) {
            registerNewUser( );
            
            // This will not work in the labs, as UCC blocks the smpt port
            // If you are running at home uncomment the two lines below and it will 
            // send an email to new registered users.
            
            //Email email = new Email( );
            //email.sendEmailToNewRegUser( userId, firstName, getEmail( ) );
        }
        
        return isValid;
    }
    /**
     * Function to see if the user attempting to register already exists in the database.
     * @param userID
     * @return true if the user does already exist in the database and false otherwise.
     */
    public boolean doesUserExist(String userID) {
        String[] dbResult = database.SelectRow( "SELECT user_id FROM users WHERE user_id = '" + userID + "';" );
        
        if(dbResult.length != 0) {
            return true;
        }
        return false;
    }
    /**
     * Function to register the new user into the database.
     */
    public void registerNewUser(  ) {
        database.Insert( "INSERT INTO users( user_id, stream, first_name, middle_name, last_name, email, password, phone_number, is_admin, date_joined )" +
                         "VALUES( '" + userId + "', '" + stream + "', '" + firstName + "', '" + middleName + "', '" + lastName + "', '" + email +
                         "', '" + PasswordHasher.sha256Hash( password2 ) + "', '" + phoneNo + "', '" + "0" + "', '" + getCurrentDate( ) + "' );" );
        
        database.Insert( "INSERT INTO is_member_of VALUES( '" + userId + "', '" + stream + "' );" );
        
        database.Close();
    }
    /**
     * Function to print any error messages that may have been collected throughout the 
     * registration process
     * @return errorList (string)
     */
    public String printErrors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    /**
     * Function to check if a string can be parsed to an integer.
     * @param value
     * @return true if the string is a string representation of an integer and false if otherwise
     */
    public boolean isInteger( String value ) {
        try { 
            Integer.parseInt( value ); 
        } 
        catch( NumberFormatException exception ) { 
            return false; 
        }
        return true;
    }
    /**
     * Function to get today's date.
     * @return the variable folderName (string) 
     */
    public String getCurrentDate( ) {
        Date today = Calendar.getInstance( ).getTime( );
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
        String folderName = formatter.format( today );

        return folderName;
    }
    /**
     * Function that allows the user to reset their password.
     * @param password1
     * @param password2
     * @param userId
     * @return true if the passwords are the same and thus, the password is reset. False if otherwise
     */
    public boolean resetPassword( final String password1, final String password2, final String userId ) {
        String[] user = getUser( userId );
         
        if( userId.equals( "" ) || user.length == 0 || ! password1.equals( password2 ) ) {
            return false;
        }
         
        database.Insert( "UPDATE users SET password = '" + PasswordHasher.sha256Hash( password2 ) 
                       + "' Where user_id = '" + userId + "'; ");
         
        return true;
    } 
    /**
     * Get the user's information from the database using their login ID.
     * @param userId
     * @return the array dbResult which contains the user's information
     */
    public String[] getUser( String userId ) {
        String[] dbResult = database.SelectRow( "SELECT * FROM users WHERE user_id = '" + userId + "';" );
        
        database.Close();
        return dbResult;
    }
     /**
      * Form used to register the user to the scheduling system.
      * @return the variable form (string)
      */
     public String registrationForm( ) {
        String form = "<form name='registration_form' action='register.jsp' method='POST'>\n";
        form += "<label for='userId'>Id Number:</label>\n";
        form += "<input type='text' name='userId' value='" + userId + "' placeholder='123456789' /><br />\n";
        
        form += "<label for='stream'>Stream:</label>\n";
        form += "<select name=\"stream\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>Computer Sci Year 1</option>\n" +
                    "  <option value=\"2\">Core Year 2</option>\n" +
                    "  <option value=\"3\">Core Year 3</option>\n" +
                    "  <option value=\"4\">Core Year 4</option>\n" +
                    "  <option value=\"5\">Web Year 2</option>\n" +
                    "  <option value=\"6\">Web Year 3</option>\n" +
                    "  <option value=\"7\">Web Year 4</option>\n" +
                    "  <option value=\"8\">Soft Entrep Year 2</option>\n" +
                    "  <option value=\"9\">Soft Entrep Year 3</option>\n" +
                    "  <option value=\"10\">Soft Entrep Year 4</option>\n" +
                    "  <option value=\"11\">Chinese Year 2</option>\n" +
                    "  <option value=\"12\">Chinese Year 3</option>\n" +
                    "  <option value=\"13\">Chinese Year 4</option>\n" +
                "</select><br />"; 
        
        form += "<label for='firstName'>First Name:</label>\n";
        form += "<input type='text' name='firstName' value='" + firstName +  "' placeholder='John' /><br />\n";
        form += "<label for='middleName'>Middle Name:</label>\n";
        form += "<input type='text' name='middleName' value='" + middleName +  "' placeholder='Swan' /><br />\n";
        form += "<label for='lastName'>Last Name:</label>\n";
        form += "<input type='text' name='lastName' value='" + lastName +  "' placeholder='Smith' /><br />\n";
        form += "<label for='email'>Email:</label>\n";
        form += "<input type='email' id='email' name='email' value='" + email +  "' placeholder='martin@live.ie' /><br />\n";
        form += "<label for='password1'>Password:</label>\n";
        form += "<input type='password' name='password1' /><br />\n";
        form += "<label for='password2'>Confirm Password:</label>\n";
        form += "<input type='password' name='password2' /><br />\n"; 
        form += "<label for='phoneNo'>Phone Number:</label>\n";
        form += "<input type='text' name='phoneNo' value='" + phoneNo +  "' placeholder='085-1175892' /><br />\n";
        
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</form>\n";
        
        return form;
    }
     
//    private void changePassword( String userInputCurrentPassword, String newPassword ) {
//        DatabaseClass database = new DatabaseClass( );
//        database.setup( "localhost", "timetable_scheduler_db", "root", "" );
//        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
//        
//        String currentPasswordFromDB = request.getParameter( "password" );
//        
//        if( currentPasswordFromDB.equals(userInputCurrentPassword) ) {
//            database.Insert( "INSERT INTO users( password )"
//                    + "VALUES (\"" + newPassword + "\");"
//                    + "WHERE user_id = \"" + userId + "\";");
//        }
//        else
//        {
//            
//        }
//            
//    }
//    
//    private void changePhoneNo( String currentPassword ) {
//        
//    } 
}

