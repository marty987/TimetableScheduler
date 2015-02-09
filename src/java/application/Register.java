package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 7, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Register {
    private String userId;
    private String stream;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password1;
    private String password2;
    private String phoneNo;
    private DatabaseClass database;
    private final ArrayList<String> errors;
    
    public Register( ) {
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
    }
    
    public String getUserId( ) {
        return userId;
    }
    
    public void setUserId( final String userId ) {
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
    
    public String errors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
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
            insertNewUser( );
        }
        
        return isValid;
    }
    
    public void insertNewUser(  ) {
        database = new DatabaseClass( );
        database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        
        database.Insert( "INSERT INTO users( user_id, stream, first_name, middle_name, last_name, email, password, phone_number, date_joined )" +
                         "VALUES( '" + userId + "', '" + stream + "', '" + firstName + "', '" + middleName 
                            + "', '" + lastName + "', '" + email + "', '" + PasswordHasher.sha256Hash( password2 ) + "', '" + phoneNo 
                            + "', '" + getCurrentDate( ) + "' );" );
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String folderName = formatter.format(today);

        return folderName;
    }
    
     public String registrationForm( ) {
        String form = "<form name='registration_form' action='register.jsp' method='POST'>\n";
        form += "<label for='userId'>Id Number:</label>\n";
        form += "<input type='text' name='userId' value='" + userId + "' placeholder='123456789' /><br />\n";
        
        form += "<label for='stream'>Stream:</label>\n";
        form += "<select name=\"stream\">\n" +
                    "  <option value=\"Comp Science 1\" selected>Computer Sci Year 1</option>\n" +
                    "  <option value=\"Core 2\">Core Year 2</option>\n" +
                    "  <option value=\"Core 3\">Core Year 3</option>\n" +
                    "  <option value=\"Core 4\">Core Year 4</option>\n" +
                    "  <option value=\"Web 2\">Web Year 2</option>\n" +
                    "  <option value=\"Web 3\">Web Year 3</option>\n" +
                    "  <option value=\"Web 4\">Web Year 4</option>\n" +
                    "  <option value=\"Soft Entrep 2\">Soft Entrep Year 2</option>\n" +
                    "  <option value=\"Soft Entrep 3\">Soft Entrep Year 3</option>\n" +
                    "  <option value=\"Soft Entrep 4\">Soft Entrep Year 4</option>\n" +
                    "  <option value=\"Chinese 2\">Chinese Year 2</option>\n" +
                    "  <option value=\"Chinese 3\">Chinese Year 3</option>\n" +
                    "  <option value=\"Chinese 4\">Chinese Year 4</option>\n" +
                "</select><br />"; 
        
        form += "<label for='firstName'>First Name::</label>\n";
        form += "<input type='text' name='firstName' value='" + firstName +  "' placeholder='John' /><br />\n";
        form += "<label for='middleName'>Middle Name::</label>\n";
        form += "<input type='text' name='middleName' value='" + middleName +  "' placeholder='Swan' /><br />\n";
        form += "<label for='lastName'>Last Name::</label>\n";
        form += "<input type='text' name='lastName' value='" + lastName +  "' placeholder='Smith' /><br />\n";
        form += "<label for='email'>Email:</label>\n";
        form += "<input type='text' name='email' value='" + email +  "' placeholder='martin@live.ie' /><br />\n";
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
}

