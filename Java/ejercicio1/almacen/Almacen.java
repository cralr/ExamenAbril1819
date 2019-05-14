package ejercicio1.almacen;

import java.util.ArrayList;

import ejercicio1.almacen.exceptions.*;

/**
 * Gestiona el conjunto de artículos del almacén.
 *
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class Almacen {
  private ArrayList<Articulo> arraylist = new ArrayList<Articulo>();

  /**
   * Añadir un articulo
   * 
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws Exception
   */
  public void annadir(String descripcion,Iva iva, double precioCompra, double precioVenta, int stock) throws Exception {
    arraylist.add(new Articulo(descripcion,iva, precioCompra, precioVenta, stock));
  }

  /**
   * Elimina el artículo del almacén
   * 
   * @param codigo
   *          Código del artículo a eliminar
   * @return true si se ha eliminado. false en otro caso.
   */
  public boolean baja(int codigo) throws CodigoNoValidoException {
    return arraylist.remove(new Articulo(codigo)); // Si el código que introducimos en el test es igual al código del
                                                 // artículo que hay en la lista se realiza el borrado.
  }

  /**
   * Modificar articulo
   * 
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws StockNegativoException
   * @throws PrecioVentaNegativoException
   * @throws PrecioCompraNegativoException
   * @throws IvaInvalidoException 
   * @throws ArticuloNoExisteException 
   */

  public void set(int codigo,Iva iva, String descripcion, double precioCompra, double precioVenta, int stock)
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException, IvaInvalidoException, ArticuloNoExisteException {
    get(codigo).set(descripcion, iva, precioCompra, precioVenta, stock);
  }

  /**
   * Método toString
   */
  @Override
  public String toString() {
    return "Artículo " + arraylist + "";
  }

  /**
   * Obteniene el Artículo según su código.
   * 
   * @param codigo
   * @return Artículo del almacén según su código
   * @throws ArticuloNoExisteException
   */
  public Articulo get(int codigo) throws ArticuloNoExisteException {
    try {
      return arraylist.get(arraylist.indexOf(new Articulo(codigo))); // Con get lo que se hace es extraer el código del
                                                                 // artículo.
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El código del artículo no existe en el almacén.");// Si el código no lo
                                                                                             // devuelve el indexOf es
                                                                                             // que no existe y salta la
                                                                                             // excepción.
    }
  }

  /**
   * Método incrementar, que aumenta las unidades de stock de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws CantidadNegativaException
   * @throws StockNegativoException
   * @throws ArticuloNoExisteException 
   */
  public void incrementar(int codigo, int cantidad) throws StockNegativoException, CantidadNegativaException, ArticuloNoExisteException {
    get(codigo).incrementaStock(cantidad);
  }

  /**
   * Método decrementar, que disminuye las unidades de stock de un artículo.
   * 
   * @param codigo
   * @param cantidad
   * @throws CantidadNegativaException
   * @throws StockNegativoException
   * @throws ArticuloNoExisteException 
   */
  public void decrementar(int codigo, int cantidad) throws StockNegativoException, CantidadNegativaException, ArticuloNoExisteException {
   get(codigo).decrementaStock(cantidad);
    
  }
}
