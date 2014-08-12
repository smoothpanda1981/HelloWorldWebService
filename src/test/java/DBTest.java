import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class DBTest {

	@Test
	public void test() throws Exception {
		Connection connection;
        
//        Properties prop = new Properties();
//        System.out.println("test");
//        prop.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));
//        String host = prop.getProperty("host").toString();
//        String username = prop.getProperty("username").toString();
//        String password = prop.getProperty("password").toString();
//        String driver = prop.getProperty("driver").toString();
        String host = "jdbc:mysql://mysql-ywang.appengine.flow.ch/Recette";
        String username = "root";
        String password = "OrlD5yJBpi";
        String driver = "com.mysql.jdbc.Driver";
 
        
        Class.forName(driver);
        System.out.println("--------------------------");
        System.out.println("DRIVER: " + driver);
        connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);
	}

}
