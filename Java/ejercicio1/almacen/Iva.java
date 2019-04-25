
package ejercicio1.almacen;

/**
 *Clase de tipo enum donde se guardarán los 3 tipos de IVA.
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public enum Iva {
  General,
  Reducido,
  SuperReducido;
  
  public static String[] toArray() {
    String[] iva = new String[Iva.values().length];
    int i=0;
    for(Iva c:Iva.values()){
      iva[i++] = c.toString();
    }
    return iva;
  }
}
