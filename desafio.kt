enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for (conteudo in conteudos) {
            println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
        }
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        for (usuario in inscritos) {
            println("${usuario.nome} - ${usuario.email}")
        }
    }
}

fun main() {
    // Exemplo de uso das classes e funções

    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Classes e Objetos em Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Collections em Kotlin", 150)

    // Criando uma formação
    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1, conteudo2, conteudo3))

    // Criando alguns usuários
    val usuario1 = Usuario("Alice", "alice@example.com")
    val usuario2 = Usuario("Bob", "bob@example.com")
    val usuario3 = Usuario("Carol", "carol@example.com")

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario1) // Tentando matricular novamente o mesmo usuário

    // Listando conteúdos e inscritos na formação
    formacaoKotlin.listarConteudos()
    formacaoKotlin.listarInscritos()
}
