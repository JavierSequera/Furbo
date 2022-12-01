import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MétodosDB {

    public static Connection conexion() {
        Connection con = null;
        String url = "jdbc:mysql://dns11036.phdns11.es:3306/ad2223_fjsequera?user=ad2223_fjsequera&password=1234";
        try {
            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }

    public static void CrearTabla(String nombre, String[] campos) {
        Statement statement;
        Connection con = null;

        String sql = "CREATE TABLE " + nombre + " (";
        for (int i = 0; i < campos.length; i++) {
            sql += campos[i];
            if (i < campos.length - 1) {
                sql += ", ";
            }
        }
        sql = sql + ");";
        try {
            con = conexion();
            statement = con.createStatement();
            statement.execute("USE ad2223_fjsequera");
            statement.execute(sql);
            con.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static List<String> mostrarDatos(String consulta, String[] datos, String[]tipoDatos) {
        Statement statement;
        Connection con = null;
        List<String> ListaCosas = new ArrayList<>();
        try {

            con = conexion();
            statement = con.createStatement();

            statement.execute("USE ad2223_fjsequera");
            ResultSet rs = statement.executeQuery(consulta);

            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    if (nombraColumna(rs, datos[i])) {
                        switch (tipoDatos[i]) {
                            case "int":
                                ListaCosas.add(String.valueOf(rs.getInt(datos[i])));
                                break;
                            case "string":
                                ListaCosas.add(rs.getString(datos[i]));
                                break;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ListaCosas;
    }

    //Método que comprueba si existe la columna
    public static boolean nombraColumna(ResultSet rs, String columnName) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            for (int x = 1; x <= columns; x++) {
                if (columnName.equals(rsmd.getColumnName(x))) {
                    return true;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

}
