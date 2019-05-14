package ejercicio1;

import java.io.IOException;
import java.util.Scanner;

import ejercicio1.almacen.Almacen;
import ejercicio1.almacen.Articulo;
import ejercicio1.almacen.Iva;
import ejercicio1.almacen.exceptions.*;
import ejercicio1.utiles.*;



/**
 * Se comunica con el usuario (E/S de datos por consola) Comprueba si existe o
 * no el artículo en el almacén Comprueba que el stock no sea negativo en el
 * almacén Comprueba que el articulo exista para borrarlo del almacén.
 * 
 * Test para comprobar la clase Gestisimal.
 * 
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */

public class TestGestisimal {
  static Iva iva[] =Iva.values();
  
  static Almacen almacen = new Almacen();
  static Scanner entrada = new Scanner(System.in);
  private static Menu menu = new Menu("----MENÚ GESTISIMAL----", new String[] {"Listado", "Alta", "Baja",
      "Modificación", "Entada de mercancía","Salida de mercancía", "Salir" });
  
  //Creación del objeto menuIva, será una instacia de menu.
  private static Menu menuIva = new Menu("----MENÚ IVA----", new String[] {"General","Reducido","Super Reducido"});
  
  public static void main(String[] args) throws Exception {

    do {
      switch ((menu.gestionar())) {
        case 1:
          System.out.println(almacen);
          break;
        case 2:
          annadir();
          break;
        case 3:
          baja();
          break;
        case 4:
          modificar();
          break;
        case 5:
          entradaAlmacen();
          break;
        case 6:
          salidaAlmacen();
          break;
         default:
           System.out.println("Gracias por usar Gestisimal.");
           return;
        }
    } while (true);
  }

  /**
   * Método añadir en el que se le pedirá al usuario los datos del artículo.
   * @throws Exception
   */

  private static void annadir() throws Exception  {

    try {
      System.out.println("--AÑADIR ARTÍCULO--");
      almacen.annadir(Teclado.leerCadena("Introduzca la descripción del artículo:"),
          pedirIva(), 
          Teclado.leerDecimal("Introduzca el precio de compra del artículo:"),
          Teclado.leerDecimal("Introduzca el precio de venta del artículo:"), 
          Teclado.leerEntero("Introduzca el stock del artículo:")); 
                                                                      
      System.out.println("Artículo añadido.");
    } catch (Exception e) {
      System.err.println("No se ha podido dar de alta al artículo. " + e.getMessage());// Si hay un error salta la
      entrada.nextLine();
    }
  }

  /**
   * Método para dar de baja un artículo de la lista.
   * 
   * @throws CodigoNoValidoException
   * @throws NoEsEnteroException 
   * @throws ArticuloNoExisteException 
   */
  private static void baja() throws CodigoNoValidoException, NoEsEnteroException {
    try {
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      if (almacen.baja(codigo))
        System.out.println("Artículo eliminado.");
      else
        System.err.println("El artículo no se ha podido eliminar. No existe un artículo con ese código en el almacen.");
    }catch(NoEsEnteroException n) {
      System.err.println(n.getMessage());
    }
  }

  /**
   * Método para modificar los atributos de un artículo.
   * 
   * @throws StockNegativoException
   * @throws PrecioCompraNegativoException
   * @throws PrecioVentaNegativoException
   * @throws NoEsEnteroException 
   * @throws NoEsDecimalException 
   * @throws IvaInvalidoException 
   * @throws IOException 
   * @throws NumberFormatException 
   */
  private static void modificar()
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException,NoEsEnteroException, NoEsDecimalException, IvaInvalidoException, NumberFormatException, IOException {

    try {
      System.out.println("--MODIFICAR ARTÍCULO--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a modificar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      almacen.set(codigo, pedirIva(), Teclado.leerCadena("Introduzca la descripción del artículo:"),
          Teclado.leerDecimal("Introduzca el precio de compra del artículo:"),
          Teclado.leerDecimal("Introduzca el precio de venta del artículo:"),
          Teclado.leerEntero("Introduzca el stock del artículo:"));
    } catch (ArticuloNoExisteException  | PrecioCompraNegativoException | PrecioVentaNegativoException | StockNegativoException | NoEsDecimalException | NoEsEnteroException e  ) {
      System.err.println("No se ha podido modificar el artículo." + e.getMessage());
      entrada.nextLine();
    }

  }

  /**
   * Método para aumentar el stock de un artículo.
   * @throws NoEsEnteroException 
   * @throws StockNegativoException
   * @throws CantidadNegativaException
   */
  private static void entradaAlmacen() throws NoEsEnteroException, StockNegativoException {
    try {
      System.out.println("--INCREMENTAR STOCK--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      almacen.incrementar(codigo, Teclado.leerEntero("Introduzca el número de artículos a aumentar del stock del almacen."));
    } catch (ArticuloNoExisteException | CantidadNegativaException e) {
      System.err.println("No se ha podido incrementar el stock del artículo." + e.getMessage()+"\n");
    }
  }

  /**
   * Método para disminuir el stock de un artículo, este no puede ser negativo.
   * @throws NoEsEnteroException 
   * @throws StockNegativoException
   * @throws CantidadNegativaException
   */
  private static void salidaAlmacen() throws NoEsEnteroException, CantidadNegativaException {
    try {
      System.out.println("--DECREMENTAR STOCK--");
      int codigo= Teclado.leerEntero("Introduce el códido del artículo a eliminar.");
      Articulo articulo = almacen.get(codigo);
      System.out.println(articulo);

      almacen.decrementar(codigo, Teclado.leerEntero("Introduzca el número de artículos a eliminar del stock del almacen."));
    } catch (ArticuloNoExisteException |StockNegativoException | CantidadNegativaException e ) {
      System.err.println("No se ha podido decrementar el stock del artículo." + e.getMessage()+"\n");
    }
  }
  
  /**
   * Método para recoger la opcion del iva.
   * @return opcion elegida
   * @throws NumberFormatException
   * @throws NoEsEnteroException
   * @throws IOException
   */
  public static Iva pedirIva() throws NumberFormatException, NoEsEnteroException, IOException {
    int opcion = menuIva.gestionar();
    return iva[opcion - 1];
  }
}