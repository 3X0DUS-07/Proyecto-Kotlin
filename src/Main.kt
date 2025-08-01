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

fun solicitarUsuarioManual(scanner: Scanner): User {
    println("=== Registro de Usuario ===")

    print("Nombre completo: ")
    val nombre = scanner.nextLine()

    print("Edad: ")
    val edad = scanner.nextLine().toIntOrNull() ?: 0

    print("Altura (m): ")
    val altura = scanner.nextLine().toDoubleOrNull() ?: 0.0

    print("Peso (kg): ")
    val peso = scanner.nextLine().toDoubleOrNull() ?: 0.0

    print("Email: ")
    val email = scanner.nextLine()

    print("Ciudad de residencia: ")
    val ciudad = scanner.nextLine()

    return User(nombre, edad, altura, peso, email, ciudad)
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Bienvenido al Gestor de Información Personal\n")

    println("Registro del usuario 1:")
    val user1 = solicitarUsuarioManual(scanner)

    println("\nRegistro del usuario 2:")
    val user2 = solicitarUsuarioManual(scanner)

    println("\nRegistro del usuario 3:")
    val user3 = solicitarUsuarioManual(scanner)

    println("\n=== Información de Usuarios ===\n")

    println("Usuario 1")
    println(crearResumen(user1))

    println("\nUsuario 2")
    println(crearResumen(user2))

    println("\nUsuario 3")
    println(crearResumen(user3))

    println("\nGracias por usar el programa.")
}
