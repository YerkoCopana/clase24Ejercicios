class Ejercicios {

  class Caja[A](val contenido: A) {

    def obtener: A = contenido

    def combinar[B](otro: B): (A, B) = {
      (contenido, otro)
    }
  }

  val cajaInt = new Caja[Int](10)
  val cajaString = new Caja[String]("Hola")
  val cajaBoolean = new Caja[Boolean](true)


  def seleccionarPrimero[A](
    primero: A,
    segundo: A
  ): A = {
    primero
  }


  def transformar[A, B](
    valor: A,
    funcion: A => B
  ): B = {
    funcion(valor)
  }


  abstract class Vehiculo(val marca: String)

  class Automovil(marca: String) extends Vehiculo(marca)

  class Motocicleta(marca: String) extends Vehiculo(marca)

  class RegistroVehiculo[A <: Vehiculo](val vehiculo: A)

  val auto = new Automovil("Toyota")
  val moto = new Motocicleta("Honda")

  val registroAuto = new RegistroVehiculo[Automovil](auto)
  val registroMoto = new RegistroVehiculo[Motocicleta](moto)


  class Animal(val nombre: String)

  class Perro(nombre: String) extends Animal(nombre)

  class Contenedor[+A](val valor: A)

  val contenedorPerro: Contenedor[Perro] =
    new Contenedor[Perro](new Perro("Toby"))

  val contenedorAnimal: Contenedor[Animal] =
    contenedorPerro


  trait Procesador[-A] {
    def procesar(valor: A): String
  }

  class ProcesadorAnimal extends Procesador[Animal] {

    def procesar(valor: Animal): String = {
      "Procesando: " + valor.nombre
    }
  }

  val procesador: Procesador[Perro] = new ProcesadorAnimal


  class Gato(nombre: String) extends Animal(nombre)

  trait Productor[+A] {
    def producir: A
  }

  trait Consumidor[-A] {
    def consumir(valor: A): String
  }

  class ProductorPerro extends Productor[Perro] {
    def producir: Perro = new Perro("Toby")
  }

  class ProductorGato extends Productor[Gato] {
    def producir: Gato = new Gato("Michi")
  }

  class ConsumidorAnimal extends Consumidor[Animal] {
    def consumir(valor: Animal): String = {
      "Animal recibido: " + valor.nombre
    }
  }

  val productorPerro: Productor[Perro] = new ProductorPerro
  val productorAnimal: Productor[Animal] = productorPerro

  val consumidorAnimal: Consumidor[Animal] = new ConsumidorAnimal
  val consumidorPerro: Consumidor[Perro] = consumidorAnimal


  class Resultado[A](
    val valor: A,
    val exitoso: Boolean,
    val mensaje: String
  )

  class Persona(val nombre: String)

  val resultadoInt =
    new Resultado[Int](100, true, "Número procesado")

  val resultadoString =
    new Resultado[String]("Hola", true, "Texto procesado")

  val resultadoPersona =
    new Resultado[Persona](
      new Persona("Carlos"),
      true,
      "Persona registrada"
    )
}