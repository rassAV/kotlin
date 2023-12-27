fun splitRoles(inputText: String): Map<String, List<String>> {
    var rolesInput = true
    var phraseIndex = 1
    val scenario = mutableMapOf<String, MutableList<String>>()
    val rolesList = mutableListOf<String>()

    for (line in inputText.lines()) {
        if (line == "textLines:") {
            rolesInput = false
        } else {
            if (rolesInput) {
                scenario[line] = mutableListOf()
                rolesList.add(line)
            } else {
                val (role, text) = line.split(":", limit = 2)
                scenario[role]?.add("$phraseIndex - $text")
                phraseIndex += 1
            }
        }
    }

    return scenario
}

fun printRoles(scenario: Map<String, List<String>>) {
    for (role in scenario.keys) {
        println("\n${role}:")
        for (text in scenario[role]!!) println(text)
    }
}

fun main() {
    val inputText = """
        roles:
        Городничий
        Аммос Федорович
        Артемий Филиппович
        Лука Лукич
        textLines:
        Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.
        Аммос Федорович: Как ревизор?
        Артемий Филиппович: Как ревизор?
        Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.
        Аммос Федорович: Вот те на!
        Артемий Филиппович: Вот не было заботы, так подай!
        Лука Лукич: Господи боже! еще и с секретным предписаньем!
    """.trimIndent()
    printRoles(splitRoles(inputText))
}
