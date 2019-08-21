package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"): String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return  dateFormat.format(this)
}
fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date{
    var time= this.time
    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
fun Date.humanizeDiff(date: Date = Date() ): String {
    val lastVisit = this.time
    var st = ""
    if (date.time>lastVisit)
        st +=when ((date.time-lastVisit)/1000) {
            in 0..1 -> return "только что"
            in 1..45 -> return "${TimeUnits.SECOND.plural(((date.time - lastVisit)/1000).toInt())} назад"
            in 45..75 -> return "минуту назад"
            in (75)..(45 * 60) -> return "${TimeUnits.MINUTE.plural(((date.time - lastVisit)/(1000 * 60)).toInt())} назад"
            in (45 * 60)..(75 * 60) -> return "час назад"
            in (75 * 60)..(22 * 60 * 60) -> return "${TimeUnits.HOUR.plural(((date.time - lastVisit)/(1000*60*60)).toInt())} назад"
            in (22 * 60 * 60)..(26 * 60 * 60) -> return "день назад"
            in (26 * 60 * 60)..(360 * 24 * 60 * 60) -> return "${TimeUnits.DAY.plural(((date.time - lastVisit)/(1000*60*60*24)).toInt())} назад"
            else -> " более года назад"
        }
    else
        st += when((lastVisit-date.time)/1000) {
            in 0..1 -> " только что"
            in 1..45 -> " через ${TimeUnits.SECOND.plural(((lastVisit-date.time)/1000).toInt())}"
            in 45..75 -> " через одну минуту"
            in 75..45 * 60 -> " через ${TimeUnits.MINUTE.plural(((lastVisit-date.time)/(1000*60)).toInt())}"
            in 45 * 60..75 * 60 -> " через час"
            in 75 * 60..22 * 60 * 60 -> " через ${TimeUnits.HOUR.plural(((lastVisit-date.time)/(1000*60*60)).toInt())}"
            in 22 * 60 * 60..26 * 60 * 60 -> " через день"
            in 26 * 60 * 60..360 * 24 * 60 * 60 -> " через ${TimeUnits.DAY.plural(((lastVisit-date.time)/(1000*60*60*24)).toInt())}"
            else -> " более чем через год"
        }
    return st
}
fun TimeUnits.plural(value: Int): String {
    val units : TimeUnits = this
    val znach: Int = value
    var numeral =""
    if (units == TimeUnits.SECOND)
        numeral = when (znach){
            1, 21, 31, 41, 51  -> "$znach секунду"
            in 2..4 -> "$znach секунды"
            in 5..20 -> "$znach секунд"
            in 22..24 -> "$znach секунды"
            in 25..30 -> "$znach секунд"
            in 32..34 -> "$znach секунды"
            in 35..40 -> "$znach секунд"
            in 42..44 -> "$znach секунды"
            in 45..50 -> "$znach секунд"
            in 52..54 -> "$znach секунды"
            in 55..60 -> "$znach секунд"
            else -> "$znach ERROR" }
    else if (units == TimeUnits.MINUTE)
        numeral = when (znach){
            1, 21, 31, 41, 51  -> "$znach минуту"
            in 2..4 -> "$znach минуты"
            in 5..20 -> "$znach минут"
            in 22..24 -> "$znach минуты"
            in 25..30 -> "$znach минут"
            in 32..34 -> "$znach минуты"
            in 35..40 -> "$znach минут"
            in 42..44 -> "$znach минуты"
            in 45..50 -> "$znach минут"
            in 52..54 -> "$znach минуты"
            in 55..60 -> "$znach минут"
            else -> "$znach ERROR"}
    else if (units == TimeUnits.HOUR)
        numeral = when (znach){
            1, 21  -> "$znach час"
            in 2..4 -> "$znach часа"
            in 5..20 -> "$znach часов"
            in 22..24 -> "$znach часа"
            else -> "$znach ERROR"}
    else if (units == TimeUnits.DAY)
        numeral = when (znach){
            1, 21, 31, 41, 51, 61,71,81,91,101,121,131,141, 151,161,171,181,191,
            201, 221, 231, 241, 251, 261,271,281,291,301, 321, 331, 341, 351, 361  -> "$znach день"
            in 2..4 -> "$znach дня"
            in 5..20 -> "$znach дней"
            in 22..24 -> "$znach дня"
            in 25..30 -> "$znach дней"
            in 32..34 -> "$znach дня"
            in 35..40 -> "$znach дней"
            in 42..44 -> "$znach дня"
            in 45..50 -> "$znach дней"
            in 52..54 -> "$znach дня"
            in 55..60 -> "$znach дней"
            in 62..64 -> "$znach дня"
            in 65..70 -> "$znach дней"
            in 72..74 -> "$znach дня"
            in 75..80 -> "$znach дней"
            in 82..84 -> "$znach дня"
            in 85..90 -> "$znach дней"
            in 92..94 -> "$znach дня"
            in 95..100 -> "$znach дней"
            in 102..104 -> "$znach дня"
            in 105..120 -> "$znach дней"
            in 122..124 -> "$znach дня"
            in 125..130 -> "$znach дней"
            in 132..134 -> "$znach дня"
            in 135..140 -> "$znach дней"
            in 142..144 -> "$znach дня"
            in 145..150 -> "$znach дней"
            in 152..154 -> "$znach дня"
            in 155..160 -> "$znach дней"
            in 162..164 -> "$znach дня"
            in 165..170 -> "$znach дней"
            in 172..174 -> "$znach дня"
            in 175..180 -> "$znach дней"
            in 182..184 -> "$znach дня"
            in 185..190 -> "$znach дней"
            in 192..194 -> "$znach дня"
            in 195..200 -> "$znach дней"
            in 202..204 -> "$znach дня"
            in 205..220 -> "$znach дней"
            in 222..224 -> "$znach дня"
            in 225..230 -> "$znach дней"
            in 232..234 -> "$znach дня"
            in 235..240 -> "$znach дней"
            in 242..244 -> "$znach дня"
            in 245..250 -> "$znach дней"
            in 252..254 -> "$znach дня"
            in 255..260 -> "$znach дней"
            in 262..264 -> "$znach дня"
            in 265..270 -> "$znach дней"
            in 272..274 -> "$znach дня"
            in 275..280 -> "$znach дней"
            in 282..284 -> "$znach дня"
            in 285..290 -> "$znach дней"
            in 292..294 -> "$znach дня"
            in 295..300 -> "$znach дней"
            in 302..304 -> "$znach дня"
            in 305..320 -> "$znach дней"
            in 322..324 -> "$znach дня"
            in 325..330 -> "$znach дней"
            in 332..334 -> "$znach дня"
            in 335..340 -> "$znach дней"
            in 342..344 -> "$znach дня"
            in 345..350 -> "$znach дней"
            in 352..354 -> "$znach дня"
            in 355..360 -> "$znach дней"
            else -> "$znach ERROR"}
    return numeral
}

