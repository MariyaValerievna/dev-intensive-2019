package ru.skillbranch.devintensive.extensions

fun String.truncate(i: Int = 16): String {
    val text: String = this
    val tran: String = text.substring(0,i)
    val plus = "..."
    val tranplus : String = if (text.substring((i-1),i) == " ") text.substring(0,(i-1))+plus else tran+plus
    return tranplus
}

fun String.stripHtml(): String {
    val image: String = this
    val stripHt: String = image.substringBeforeLast('.')
    val stripH: String = stripHt.replace("  ","")
    val strip: String = stripH.trimIndent()
    val stri: String = strip.substringBefore('<')+strip.substringAfter('>')
    val str: String = stri.substringBeforeLast('<')+stri.substringAfterLast('>')
    var st = ""
    for (char in str)
        st +=when (char){
            '<' -> str.substringBefore('<')+str.substringAfter('>')
            '"' -> ""
            '&' -> ""
            '(' -> ""
            ')' -> ""
            '/' -> ""
            else -> "$char"
        }
    return st
}


