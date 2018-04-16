
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
public class SQL {
 
    private static Connection Conexion;
 
    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void createDB(String name) {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            MySQLConnection("root", "", name);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void createTable(String name) {
        try {
            String Query = "CREATE TABLE " + name + ""
                    + "(ID VARCHAR(25),Nombre VARCHAR(50), Apellido VARCHAR(50),"
                    + " Edad VARCHAR(3), Sexo VARCHAR(1))";
            JOptionPane.showMessageDialog(null, "Se ha creado la base de tabla " + name + " de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void insertData(String table_name, String ID, String name, String lastname, String age, String gender) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + ID + "\", "
                    + "\"" + name + "\", "
                    + "\"" + lastname + "\", "
                    + "\"" + age + "\", "
                    + "\"" + gender + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    public String getUsuario(String table_name, String nombre_usuario, String contraseña) {
    	boolean sw=true;
        try {
        	
            String Query = "SELECT * FROM " + table_name;
            String contraseñaa = null;
            int n=0;
            Statement st = Conexion.createStatement();
            
            st.executeQuery("use proyecto");
            java.sql.ResultSet resultSet;
         
            resultSet = st.executeQuery(Query);
            while ((resultSet.next())&&sw) {
                if(nombre_usuario.equals(resultSet.getString("nombre"))) {
                	sw=false;
                }
                contraseñaa=resultSet.getString("contrasena");
                n=resultSet.getInt("UsuarioID");
            }
            if (sw) {
				return "u";
			}else {
            if ((contraseña.equals(contraseñaa))) {
            	return "i"+n;
			}else {
				return Integer.toString(n);
			}
			}
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            return "e";
        }
    }
    public int longitud(String table_name,int AdminID) {
    	try {
       	 String Query = "SELECT DISTINCT * FROM "+table_name+" WHERE AdminID="+AdminID;
            int n=0;
            Statement st = Conexion.createStatement();
            
            st.executeQuery("use proyecto");
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
           
       	while (resultSet.next()){
       		n++;
       	}
       	return n;

       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
           return 0;
       }
    	
    }
    public String getValues(String table_name, int AdminID, int i) {
        try {
        	 String Query = "SELECT DISTINCT * FROM "+table_name+" WHERE AdminID="+AdminID;
             int n=0;
             String H = null;
             Statement st = Conexion.createStatement();
             
             st.executeQuery("use proyecto");
             java.sql.ResultSet resultSet;
             resultSet = st.executeQuery(Query);
            
        	while ((resultSet.next())&&(n<=i)){
        		n++;
        		H="Tema: " + resultSet.getString("Tema");
        	}
        	return H;
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            return null;
        }
    }
 
    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
 
}
