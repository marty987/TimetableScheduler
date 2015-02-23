package application;
/**
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
    
    public String getUserId( ) {
        return userId;
    }
    
    public void setUserId( final String userId ) {
        System.out.println("test test");
        this.userId = userId;
    }
    
    public String getStream( ) {
        return stream;
    }
    
    public void setStream( final String stream ) {
        this.stream = stream;
    }
    
    public String getFirstName( ) {
        return firstName;
    }
    
    public void setFirstName( final String firstName ) {
        this.firstName = firstName;
    }
    
    public String getMiddleName( ) {
        return middleName;
    }
    
    public void setMiddleName( final String middleName ) {
        this.middleName = middleName;
    }
    
    public String getLastName( ) {
        return lastName;
    }
    
    public void setLastName( final String lastName ) {
        this.lastName = lastName;
    }
    
    public String getEmail( ) {
        return email;
    }
    
    public void setEmail( final String email ) {
        this.email = email;
    }
    
    public String getPassword1( ) {
        return password1;
    }
    
    public void setPassword1( final String password1 ) {
        this.password1 = password1;
    }
    
    public String getPassword2( ) {
        return password2;
    }
    
    public void setPassword2( final String password2 ) {
        this.password2 = password2;
    }

    public String getPhoneNo( ) {
        return phoneNo;
    }
    
    public void setPhoneNo( final String phoneNo ) {
        this.phoneNo = phoneNo;
    }
    
    public boolean validateRegForm( ) {
        boolean isValid = true;
        
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
    
    public void registerNewUser(  ) {
        database.Insert( "INSERT INTO users( user_id, stream, first_name, middle_name, last_name, email, password, phone_number, is_admin, date_joined )" +
                         "VALUES( '" + userId + "', '" + stream + "', '" + firstName + "', '" + middleName + "', '" + lastName + "', '" + email +
                         "', '" + PasswordHasher.sha256Hash( password2 ) + "', '" + phoneNo + "', '" + "0" + "', '" + getCurrentDate( ) + "' );" );
        
        database.Insert( "INSERT INTO is_member_of VALUES( '" + userId + "', '" + stream + "' );" );
        
        database.Close();
    }
    
    public String printErrors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    
    public boolean isInteger( String value ) {
        try { 
            Integer.parseInt( value ); 
        } 
        catch( NumberFormatException exception ) { 
            return false; 
        }
        return true;
    }
    
    public String getCurrentDate( ) {
        Date today = Calendar.getInstance( ).getTime( );
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
        String folderName = formatter.format( today );

        return folderName;
    }
    
     public boolean resetPassword( final String password1, final String password2, final String userId ) {
         String[] user = getUser( userId );
         
         if( userId.equals( "" ) || user.length == 0 || ! password1.equals( password2 ) ) {
             return false;
         }
         
         database.Insert( "UPDATE users SET password = '" + PasswordHasher.sha256Hash( password2 ) 
                        + "' Where user_id = '" + userId + "'; ");
         
         return true;
     }
     
    public String[] getUser( String userId ) {
        String[] dbResult = database.SelectRow( "SELECT * FROM users WHERE user_id = '" + userId + "';" );
        
        database.Close();
        return dbResult;
    }
     
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

