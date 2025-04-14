// Sem o uso do princípio Single Responsibility Principle (SRP)

// A classe UserService tem mais de uma responsabilidade: autenticar usuários e gerenciar usuários
// Isso pode levar a um código mais difícil de manter e testar, pois as mudanças em uma responsabilidade podem afetar a outra

data class User(val username: String, val password: String)

class UserService {

    private val users = mutableListOf<User>()

    fun authenticate(username: String, password: String): Boolean {
        val user = findUserByUsername(username)
        return user?.password == password
    }

    fun findUserByUsername(username: String): User? {
        return users.find {
            it.username == username
        }
    }

    fun addUser(user: User) {
        users.add(user)
    }
}

fun main1() {
    val userService = UserService()

    userService.addUser(User("joao", "1234"))
    userService.addUser(User("maria", "abcd"))

    val isJoaoAuthenticated = userService.authenticate("joao", "1234")
    println("João autenticado: $isJoaoAuthenticated")

    val isMariaAuthenticated = userService.authenticate("maria", "xyz")
    println("Maria autenticada: $isMariaAuthenticated")
}

// Com o uso do princípio Single Responsibility Principle (SRP)

// A classe UserService agora tem apenas uma responsabilidade: gerenciar usuários
// A autenticação é feita em uma classe separada, AuthenticationService

class AuthenticationService(private val userRepository: UserRepository) {
    fun authenticate(username: String, password: String): Boolean {
        val user = userRepository.findUserByUsername(username)
        return user?.password == password
    }
}

class UserRepository {
    data class User(val username: String, val password: String)

    private val users = mutableListOf<User>()

    fun findUserByUsername(username: String): User? {
        return users.find {
            it.username == username
        }
    }

    fun addUser(user: User) {
        users.add(user)
    }
}

fun main2() {
    val userRepository = UserRepository()
    val authService = AuthenticationService(userRepository)

    userRepository.addUser(UserRepository.User("joao", "1234"))
    userRepository.addUser(UserRepository.User("maria", "abcd"))

    val isJoaoAuthenticated = authService.authenticate("joao", "1234")
    println("João autenticado: $isJoaoAuthenticated")

    val isMariaAuthenticated = authService.authenticate("maria", "xyz")
    println("Maria autenticada: $isMariaAuthenticated")
}

fun main() {
    println("Sem SRP:")
    main1()
    println("\nCom SRP:")
    main2()
}
