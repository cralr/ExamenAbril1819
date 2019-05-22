package ejercicio2;

public class Cuadrado extends Rectangulo implements Comparable<Cuadrado>{

  Cuadrado(int lado) {
    super(lado, lado);
  }
  
  public int getLado() {
    return this.getAlto(); 
  }
  
  public void setLado(int l) {
    this.setAlto(l);
    this.setAncho(l);
  }
 
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + getLado();
    return result;
  }

  /* (non-Javadoc)
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
    Cuadrado other = (Cuadrado) obj;
    if (getLado() != other.getLado())
      return false;
    return true;
  }
  
  @Override
  public int compareTo(Cuadrado c) {
    return this.getAlto()-c.getLado();
  }
   /* int resultado = 0;

    if (this.getLado() < c.getLado()) {
      resultado = -1;
    }
    else if (this.getLado() > c.getLado()) {
      resultado = 1;
    }
    else {
      resultado = 0;
      }
    return resultado;
  }*/
}
