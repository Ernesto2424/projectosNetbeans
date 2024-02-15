
package ventanas;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
    import javax.swing.JOptionPane;  

public class clase {
    public String db = "sips";
    public String user = "root";
    public String pass = "";
    public String url = "jdbc:mysql://localhost/" + db;
    
    public Connection Connetar (){
        Connection link = null;
        try {
             Class.forName("org.gjt.mm.mysql.Driver");
              link = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tipo de Error: " + e);
        }
        return link;
    }
    
}
