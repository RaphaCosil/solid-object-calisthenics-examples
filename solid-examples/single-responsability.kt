// Sem o uso do princípio

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

// Com o uso do princípio

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


