import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private int ganados;
    private int derrotas;
    private int golesMarcados;
    private int golesRecibidos;

    public Equipo (){

    }


    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getGolesMarcados() {
        return golesMarcados;
    }

    public void setGolesMarcados(int golesMarcados) {
        this.golesMarcados = golesMarcados;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public static void insertarEquipos(){
        File archivo = null;
        Connection con;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner s = null;

        try {

            archivo = new File ("equipos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            s = new Scanner(br);

            while(s.hasNextLine()){
                System.out.println(s.nextLine());

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

}
