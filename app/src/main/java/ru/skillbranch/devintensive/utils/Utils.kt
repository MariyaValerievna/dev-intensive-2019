package ru.skillbranch.devintensive.utils



object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        when (fullName){
            null, "", " ", "   " -> return null to null
            else -> return firstName to lastName
        }

    }
    fun toInitials(firstName: String?, lastName: String?): String {
        if (firstName =="") return "${null}"
        else if (firstName == " ") return "${null}"
        else if (firstName == null) return "${null}"
        else if (lastName =="" ) return firstName.substring(0,1).toUpperCase()
        else if (lastName == null) return firstName.substring(0,1).toUpperCase()
        else return firstName.substring(0,1).toUpperCase() + lastName.substring(0,1).toUpperCase()
    }


    fun transliteration(payload: String, divider: String = " "): String{
        var latin = ""
        for ( char in payload){
            latin += when (char) {
                ' ' -> divider
                'А' -> "A"
                'а' -> "a"
                'Б' -> "B"
                'б' -> "b"
                'В' -> "V"
                'в' -> "v"
                'Г' -> "G"
                'г' -> "g"
                'Д' -> "D"
                'д' -> "d"
                'Е' -> "E"
                'е' -> "e"
                'Ё' -> "E"
                'ё' -> "e"
                'Ж' -> "Zh"
                'ж' -> "zh"
                'З' -> "Z"
                'з' -> "z"
                'И' -> "I"
                'и' -> "i"
                'Й' -> "I"
                'й' -> "i"
                'К' -> "K"
                'к' -> "k"
                'Л' -> "L"
                'л' -> "l"
                'М' -> "M"
                'м' -> "m"
                'Н' -> "N"
                'н' -> "n"
                'О' -> "O"
                'о' -> "o"
                'П' -> "P"
                'п' -> "p"
                'Р' -> "R"
                'р' -> "r"
                'С' -> "S"
                'с' -> "s"
                'Т' -> "T"
                'т' -> "t"
                'У' -> "U"
                'у' -> "u"
                'Ф' -> "F"
                'ф' -> "f"
                'Х' -> "H"
                'х' -> "h"
                'Ц' -> "C"
                'ц' -> "c"
                'Ч' -> "Ch"
                'ч' -> "ch"
                'Ш' -> "Sh"
                'ш' -> "sh"
                'Щ' -> "Sh"
                'щ' -> "sh'"
                'Ъ' -> ""
                'ъ' -> ""
                'Ы' -> "I"
                'ы' -> "i"
                'Ь' -> ""
                'ь' -> ""
                'Э' -> "E"
                'э' -> "e"
                'Ю' -> "Yu"
                'ю' -> "yu"
                'Я' -> "Ya"
                'я' -> "ya"
                else -> "$char"
            }}
        return latin
    }

}