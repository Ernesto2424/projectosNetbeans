
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class BaseDeDatos {
    public String db = "alumno";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "";
    
    public BaseDeDatos(){}
    
    public Connection Connectar(){
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
    
}




