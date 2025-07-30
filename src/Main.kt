import java.util.*

data class User(
    val nombre: String,
    val edad: Int,
    val altura: Double,
    val peso: Double,
    val email: String,
    val ciudad: String
)

fun calcularIMC(peso: Double, altura: Double): Double = peso / (altura * altura)

fun clasificarIMC(imc: Double): String = when {
    imc < 18.5 -> "Bajo peso"
    imc < 25.0 -> "Peso normal"
    imc < 30.0 -> "Sobrepeso"
    else -> "Obesidad"
}

fun esMayorDeEdad(edad: Int): Boolean = edad >= 18

fun extraerDominio(email: String): String {
    val partes = email.split("@")
    return if (partes.size == 2) partes[1] else "Dominio no válido"
}

fun crearResumen(user: User): String {
    val imc = calcularIMC(user.peso, user.altura)
    val categoriaIMC = clasificarIMC(imc)
    val dominio = extraerDominio(user.email)
    return """
        === Resumen del Usuario ===
        Nombre: ${user.nombre.uppercase()} (${user.nombre.lowercase()})
        Edad: ${user.edad} años (${if (esMayorDeEdad(user.edad)) "Mayor de edad" else "Menor de edad"})
        Altura: ${user.altura} m
        Peso: ${user.peso} kg
        IMC: ${"%.2f".format(imc)} ($categoriaIMC)
        Email: ${user.email} (Dominio: $dominio)
        Ciudad: ${user.ciudad}
    """.trimIndent()
}

fun validarEmail(email: String): Boolean = email.contains("@") && email.contains(".")

fun solicitarUsuario(scanner: Scanner): User {
    println("=== Registro de Usuario ===")

    print("Nombre completo: ")
    val nombre = scanner.nextLine()

    var edad: Int
    do {
        print("Edad: ")
        edad = scanner.nextLine().toIntOrNull() ?: -1
    } while (edad <= 0)

    var altura: Double
    do {
        print("Altura (m): ")
        altura = scanner.nextLine().toDoubleOrNull() ?: -1.0
    } while (altura <= 0)

    var peso: Double
    do {
        print("Peso (kg): ")
        peso = scanner.nextLine().toDoubleOrNull() ?: -1.0
    } while (peso <= 0)

    var email: String
    do {
        print("Email: ")
        email = scanner.nextLine()
    } while (!validarEmail(email))

    print("Ciudad de residencia: ")
    val ciudad = scanner.nextLine()

    return User(nombre, edad, altura, peso, email, ciudad)
}

fun main() {
    val scanner = Scanner(System.`in`)
    val usuarios = mutableListOf<User>()

    println("Bienvenido al Gestor de Información Personal\n")

    for (i in 1..3) {
        println("\nRegistro del usuario $i:")
        usuarios.add(solicitarUsuario(scanner))
    }

    println("\n=== Información de Usuarios ===")
    usuarios.forEachIndexed { index, user ->
        println("\nUsuario ${index + 1}")
        println(crearResumen(user))
    }

    println("\nGracias por usar el programa.")
}