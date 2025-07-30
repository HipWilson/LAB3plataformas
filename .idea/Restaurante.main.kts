// Definición abstracta Food
abstract class Food(val name: String, val price: Double) {
    abstract fun cook(): String
}

// Subclase Burger
class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Haciendo el $name en la plancha"
    }
}

// Subclase Pizza
class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook(): String {
        return "Horneando la pizza $name en el horno de leña"
    }
}
//Subclase Ensalada
class Salad(name: String, price: Double, val dressing: String) : Food(name, price) {
    override fun cook(): String {
        return "Preparando la ensalada $name con aderezo $dressing"
    }

    fun toss(): String {
        return "Mezclando la ensalada $name para regar el aderezo"
    }
}

// Interfaz Dessert
interface Dessert {
    fun eat(): String
}

//IceCream que implementa Dessert
class IceCream(name: String, price: Double) : Food(name, price), Dessert {
    override fun cook(): String {
        return "Enfriando el helado $name a -18°C"
    }

    override fun eat(): String {
        return "Comiendome el $name, ¡que rico esta!"
    }
}

// Clase abstracta Drink
abstract class Drink(name: String, price: Double) : Food(name, price) {
    abstract fun pour(): String
}

// Subclase Juice
class Juice(name: String, price: Double) : Drink(name, price) {
    override fun cook(): String {
        return "Exprimiendo las naranjas para obtener el $name"
    }

    override fun pour(): String {
        return "Poniendo $name en un vaso"
    }
}
class Coffee(name: String, price: Double, val strength: String) : Drink(name, price) {
    override fun cook(): String {
        return "Preparando café $name ($strength) en la máquina Expreso"
    }

    override fun pour(): String {
        return "Sirviendo el café $name en la taza"
    }

    fun addMilk(): String {
        return "Añadiendo leche al café $name"
    }
}
// Descuento
fun Food.discountedPrice(percentage: Double): Double {
    return price * (1 - percentage / 100)
}

fun main() {
    // Creación de instancias de alimentos
    val BigMc = Burger("Big mac triple", 45.0)
    val PizzaPeperoni = Pizza("Pizza Pepperoni", 85.0)
    val caesarSalad = Salad("Ensalada Santa Fe", 30.0, "Ranch")
    val vanillaIceCream = IceCream("Helado de Vainilla", 25.0)
    val orangeJuice = Juice("Jugo de Naranja", 15.0)
    val Espresso = Coffee("Espresso", 18.0, "fuerte")

    // Llamada a la función cook() para cada alimento
    println("--- En la cocina ---")
    println(BigMc.cook())
    println(PizzaPeperoni.cook())
    println(caesarSalad.cook())
    println(vanillaIceCream.cook())
    println(orangeJuice.cook())
    println(Espresso.cook())

    println("\n--- Preparación adicional ---")
    println(caesarSalad.toss())
    println(Espresso.addMilk())

    // Llamada a la función para el helado
    println("\n--- Comiendo el postre ---")
    println(vanillaIceCream.eat())

    // Uso de la función de extensión discountedPrice()
    println("\n--- Descuentos ---")
    val discountPercentage = 20.0
    val discountedPrice = BigMc.discountedPrice(discountPercentage)
    println("Precio base del ${BigMc.name}: Q${BigMc.price}")
    println("Precio con $discountPercentage% de descuento: Q${"%.2f".format(discountedPrice)}")
}

