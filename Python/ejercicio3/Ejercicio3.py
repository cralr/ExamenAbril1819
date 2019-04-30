'''
<p>
Ejercicio 3 del examen.
</p>
<ul>
 <li>1.Un objeto de esta clase se construye pasándole el ancho y el alto.
    Ninguno de los dos atributos puede ser menor o igual a cero ni mayor que
    diez, en esos casos se debe lanzar la excepción ArithmeticException.</li>
 <li>2.Mediante getters y setters permite que se acceda y se modifique el
    ancho y el alto del rectángulo teniendo en cuenta las restricciones en cuanto
    a las dimensiones del apartado anterior.</li>
 <li>3.Al imprimir en pantalla un objeto de la clase usando System.out.print
    se debe dibujar el rectángulo por la pantalla (de manera similar a como se
    imprime un cuadrado en la página 130 del libro Aprende Java con Ejercicios).</li>
__author__:Rafael Miguel Cruz Álvarez
'''
from builtins import isinstance

class Rectangulo:
    
    def __init__(self,ancho,alto):
        self.ancho=ancho
        self.alto=alto
        
    @property
    def ancho(self):
        return self.__ancho
    
    @ancho.setter
    def ancho(self,ancho):
        Rectangulo.__verifica_ancho(ancho)
        self.__ancho=ancho
        
    @property
    def alto(self):
        return self.__alto
    
    @alto.setter
    def alto(self,alto):
        Rectangulo.__verifica_alto(alto)
        self.__alto=alto
        
        
    def __str__(self):
        resultado =""
        
        for i in range (0,self.__ancho,+1):
            resultado +="[]"
        resultado+="\n"
        
        for i in range (1,(self.__alto-1),+1):
            resultado += "[]"
            for espacios in range (1,(self.__ancho-1),+1):
                resultado +="  "
            resultado +="[]\n"
        
        for i in range (0,self.__ancho,+1):
            resultado +="[]"
        resultado +="\n"
        return resultado
        
    #Comprobación de errores.
    @staticmethod
    def __verifica_ancho(num):
        if not isinstance(num, int):
            raise TypeError("Lado no entero", num)  # Lanzo esta excepcion si el parametro introducido no es un entero.
        if (num <= 0 or num > 10):
            raise ArithmeticError()
    
    @staticmethod
    def __verifica_alto(num):
        if not isinstance(num, int):
            raise TypeError("Lado no entero", num)  # Lanzo esta excepcion si el parametro introducido no es un entero.
        if (num <= 0 or num > 10):
            raise ArithmeticError()
        
#Clase Cuadrado que hereda de Rectangulo
class Cuadrado(Rectangulo):
    def __init__(self,lado,):
        super().__init__(lado,lado)
        
    @property
    def lado(self):
        return self.ancho

    @lado.setter
    def lado(self, lado):
        self.alto = lado
        self.ancho = lado  

    #Sobrecarga operador
    
    def __gt__(self, other):
        return self.lado > other.lado
    
    #def __lt__(self,other):
    #    return self.lado < other.lado
    
    def __ge__(self, other):
        return self.lado >= other.lado
    
    def __eq__(self,other):
        return self.lado == other.lado
 
if __name__=="__main__":
    ancho=int(input("Introduce el ancho del rectángulo."))
    alto=int(input("Introduce el alto del rectángulo."))
    rectangulo1 = Rectangulo(ancho,alto)
    print("El rectángulo generado es: ")
    print(rectangulo1)
    
    print("Cuadrados generados: ")
    cuadrado1 = Cuadrado(4)
    cuadrado2 = Cuadrado(5)
    print(cuadrado1)
    print(cuadrado2)
    print("Cuadrado2 es mayor que cuadrado1: "+str(cuadrado2>cuadrado1))
    print("Cuadrado1 es mayor que cuadrado2: "+str(cuadrado1>cuadrado2))
    
    print("Cuadrado1 es mayor o igual que cuadrado2: "+str(cuadrado2<=cuadrado1))
    print("Cuadrado2 es mayor o igual que cuadrado1: "+str(cuadrado1<=cuadrado2))
    
    print("Cuadrado2 es igual que cuadrado1: "+str(cuadrado2==cuadrado1))
    print("Cuadrado1 es igual que cuadrado2: "+str(cuadrado1==cuadrado2))
        
        