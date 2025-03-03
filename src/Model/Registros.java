
package Model;
import java.util.Calendar;

public class Registros {
    
    //metodo para generar el nombre del pdf con la hora acutal
    public String NombrePDf(){
        //variables que almacenaran los datos necesarios para la fecha
        int dia, mes, anno, hora, minuto, segundo;
        String instante;
        //variable que nos proporcionara la fecha actual
        Calendar fecha = Calendar.getInstance();
        //guardando cada dato en su respectiva variable
        dia= fecha.get(Calendar.DAY_OF_MONTH);
        mes=fecha.get(Calendar.MONTH)+1;
        anno=fecha.get(Calendar.YEAR);
        hora=fecha.get(Calendar.HOUR);
        minuto=fecha.get(Calendar.MINUTE);
        segundo=fecha.get(Calendar.SECOND);
        //concatenado todas las variables para el nombre del pdf
        instante= "_"+dia+mes+anno+hora+minuto+segundo;
    
    
        return instante;
    } 
}
