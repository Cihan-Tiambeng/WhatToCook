import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Admin {
	// PROPERTIES
	private int ID;
	private String name;
	private String MD5;
	
	// 0 if deleted; 1 if existing
	private int valid; 
	
	private DBConnection databaseConnection;
	private DBAdminTable adminTable;

	// CONSTRUCTORS
	public Admin (String ID, DBConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
		// Return Admin?
	}

	public Admin (String name, String password, DBConnection databaseConnection) throws Exception {
		this.name = name;
		this.MD5 = md5(password);
		this.databaseConnection = databaseConnection;
		adminTable = new DBAdminTable(databaseConnection, "AdminTable");
		adminTable.insertRow( name + "," + MD5  + "," + valid , "AdminTable");
	}

	// METHODS 
	public boolean check (String name, String password) throws Exception{
		String checkMD5 = md5(password);

		return adminTable.check(name, checkMD5);
	}

	public void changePassword (String newPassword) {
		String newMD5 = md5(newPassword);
		// Change in database
		// Edit Row lazim!
	}

	public boolean delete (String password) {
		if( MD5.equals(md5(password))) {
			valid = 0;
			return true;
		} else {
			return false;
		}
		// Change in database
		// Edit Row!
	}

	public int getID () {
		return ID;
	}
	
	public String getName () {
		return name;
	}
	
	public String getMD5 () {
		return MD5;
	}
	
	public int getValid () {
		return valid;
	}

	public String toString () {
		return name + "," + MD5 + "," + valid;
	}

	public String logName () {
		return name + " (ID:" + ID + ")";
	}

	// Taken from http://www.asjava.com/core-java/java-md5-example/
	public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}