package ejercicio1.almacen;

import ejercicio1.almacen.exceptions.*;


/**
 * <p>
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades). El menú del programa debe tener, al menos, las
 * siguientes opciones:
 * </p>
 * <ul>
 * <li>1. Listado</li>
 * <li>2. Alta</li>
 * <li>3. Baja</li>
 * <li>4. Modificación</li>
 * <li>5. Entrada de mercancía</li>
 * <li>6. Salida de mercancía</li>
 * <li>7. Salir</li>
 * </ul>
 * <p>
 * La entrada y salida de mercancía supone respectivamente el incremento y
 * decremento de stock de un determinado artículo. Hay que controlar que no se
 * pueda sacar más mercancía de la que hay en el almacén.
 * </p>
 *
 * @author Rafael Miguel Cruz Álvarez
 * @version 1.0
 */
public class Articulo {

  /**
   * Generará códigos para los artículos
   */
  private static int contador = 1;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int stock;
  private Iva iva;
  
  /**
   * Identifica al artículo. Será único
   */
  private int codigo;

  /**
   * Constructor de la clase artículo
   * @param descripcion
   * @param iva
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws StockNegativoException
   * @throws PrecioCompraNegativoException
   * @throws PrecioVentaNegativoException
   * @throws IvaInvalidoException 
   */
  Articulo(String descripcion,Iva iva, double precioCompra, double precioVenta, int stock)
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException, IvaInvalidoException {
    setDescripcion(descripcion);
    setIva(iva);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
    setCodigo();
  }

  /**
   * Constructor de la clase artículo unicamente con el código del artículo
   * 
   * @param codigoArticulo
   */
  Articulo(int codigoArticulo) {
    setCodigo(codigoArticulo);
  }

  /**
   * Setter del código que aumenta el contador en 1
   */
  private void setCodigo() {
    this.codigo = Articulo.contador++;
  }

  /**
   * Setter del código del constructor de articulo que usa unicamente el codigo.
   * 
   */
  private void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * Getter del código
   * 
   * @return codigo del artículo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * Getter de la descripción
   * 
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * Setter de la descripción
   * 
   * @param descripcion
   *          the descripcion to set
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Getter precio de compra
   * 
   * @return the precioCompra
   */
  public double getPrecioCompra() {
    return precioCompra;
  }

  /**
   * Setter de precio de compra en el que se controla que el precio de compra no
   * sea negativo
   * 
   * @param precioCompra
   *          the precioCompra to set
   * @throws PrecioCompraNegativoException
   */
  void setPrecioCompra(double precioCompra) throws PrecioCompraNegativoException {
    if (precioCompra <= 0) 
      throw new PrecioCompraNegativoException("El precio de compra no puede ser negativo.");
      
    this.precioCompra = precioCompra;
  }

  /**
   * Getter precio de venta
   * 
   * @return the precioVenta
   */
  public double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * Setter precio de venta en el que se controla que el precio de venta no sea
   * negativo
   * 
   * @param precioVenta
   *          the precioVenta to set
   * @throws PrecioVentaNegativoException
   */
  void setPrecioVenta(double precioVenta) throws PrecioVentaNegativoException {
    if (precioVenta <= 0) 
      throw new PrecioVentaNegativoException("El precio de venta no puede ser negativo.");

    this.precioVenta = precioVenta;
  }

  /**
   * Getter del stock
   * 
   * @return the stock
   */
  public int getStock() {
    return stock;
  }

  /**
   * Setter de stock en el que se controla que el stock no sea negativo
   * 
   * @param stock
   *          the stock to set
   * @throws StockNegativoException
   */
  void setStock(int stock) throws StockNegativoException {
    if (stock <= 0) 
      throw new StockNegativoException("El stock no puede ser negativo.");

    this.stock = stock;
  }
  
  /**
   * Método getter de iva.
   * @return devuelve el tipo de iva.
   */
  
  public Iva getIva() {
    return iva;
  }
  
  /**
   * Método setter donde se controlará que el Iva introducido no puede ser Null, para ello se creará una excepción.
   * @throws IvaInvalidoException 
   */
  
  void setIva(Iva iva) throws IvaInvalidoException {
    if (iva == null)
      throw new IvaInvalidoException("Iva no valido");
    this.iva = iva;
  }

  /**
   * Método para aumentar el stock
   * 
   * @param cantidad
   * @throws StockNegativoException
   * @throws CantidadNegativaException
   */
  public void incrementaStock(int cantidad) throws StockNegativoException, CantidadNegativaException {
    if (cantidad < 0)
      throw new CantidadNegativaException("No se puede añadir una cantidad de stock negativo.");

    setStock(getStock() + cantidad);
  }

  /**
   * Método para aumentar el stock
   * 
   * @param cantidad
   * @throws CantidadNegativaException
   * @throws StockNegativoException
   */
  public void decrementaStock(int cantidad) throws CantidadNegativaException, StockNegativoException {
    if (cantidad < 0)
      throw new CantidadNegativaException("No se puede añadir una cantidad de stock negativo.");

    setStock(getStock() - cantidad);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "\nCodigo: " + getCodigo() + "\nDescripcion: " + getDescripcion() + "\nTipo de Iva: "+getIva()+"\nPrecioCompra: " + getPrecioCompra()
        + "\nPrecioVenta: " + getPrecioVenta() + "\nStock: " + getStock() + "\n'''''''''''''''''''''''''''''''''''''''";
  }

  /**
   * Método set usado en Almacen para realizar la modificación, hay que añadir el tipo de iva.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param stock
   * @throws StockNegativoException
   * @throws PrecioCompraNegativoException
   * @throws PrecioVentaNegativoException
   * @throws IvaInvalidoException 
   */
  public void set(String descripcion,Iva iva, double precioCompra, double precioVenta, int stock)
      throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException, IvaInvalidoException {
    setDescripcion(descripcion);
    setIva(iva);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setStock(stock);
  }

}