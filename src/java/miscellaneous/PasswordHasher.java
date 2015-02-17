package miscellaneous;
/**
 * @author Martin Bullman 112735341
 * @since Feb 10, 2015, 12:56:25 PM
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
    
    public static String sha256Hash(String input) { 
        String sha256Hash = ""; 
        
        try {
            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
            //Update input string in message digest
            digest.update( input.getBytes( ), 0, input.length( ) );
            //Converts message digest value in base 16 (hex) 
            sha256Hash = new BigInteger( 1, digest.digest( ) ).toString( 16 );
        } 
        catch( NoSuchAlgorithmException exception ) {
               System.out.println( "The algorithm you selected could not be found, Please select another" );
               exception.printStackTrace( );
        }
        return sha256Hash;
    }
}
