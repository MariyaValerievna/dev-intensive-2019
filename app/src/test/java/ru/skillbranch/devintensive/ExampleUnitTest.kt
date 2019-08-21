package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_factory() {
        val user = User.makeUser("John")
        val user2 = User.makeUser( " ")
        val user3 = User.makeUser("John Silverhand")

        println("""
            $user
            $user2
            $user3
        """.trimIndent())
    }
    @Test
    fun test_date_maping() {
        val user = User.makeUser("Мария Валериевна")
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }
    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("John Wick")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")
        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    @Test
    fun test_parse() {
        val user = Utils.parseFullName(null)
        val user2 = Utils.parseFullName( " ")
        val user3 = Utils.parseFullName("John")
        val user4 = Utils.parseFullName("John Silverhand")

        println("""
            $user
            $user2
            $user3
            $user4
        """.trimIndent())
    }
    @Test
    fun test_date_format() {
        val d1 = Date().format() //14:00:00 27.06.19
        val d2 = Date().format("HH:mm") //14:00

        println("""
            $d1
            $d2
        """.trimIndent())
    }
    @Test
    fun test_date_add() {
        val d1 = Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
        val d2 = Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019
        println("""
            $d1
            $d2
        """.trimIndent())
    }
    @Test
    fun test_initials() {
        val user  = Utils.toInitials("john", "doe") //JD
        val user2 = Utils.toInitials("John", null) //J
        val user3 = Utils.toInitials(null, null) //null
        val user4 = Utils.toInitials(" ", "") //null

        println("""
        $user
        $user2
        $user3
        $user4
    """.trimIndent())
    }
    @Test
    fun test_transliteration(){
        val us1 = Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
        val us2 = Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        println("""
            $us1
            $us2
        """.trimIndent())
    }
    @Test
    fun test_humanizeDiff(){
        val t1 = Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
        val t2 = Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
        val t3 = Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
        val t4 = Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
        val t5 = Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
        val t6 = Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
        println("""
          $t1
          $t2
          $t3
          $t4
          $t5
          $t6
     """.trimIndent())
    }
    @Test
    fun test_builder(){
        val user = User.Builder()
            .id("0")
            .firstName("Mariya")
            .lastName("Valerievna")
            .avatar(null)
            .rating(0)
            .respect(0)
            .lastVisit(null)
            .isOnline(false)
            .build()
        println("""
            $user
        """.trimIndent())
    }
    @Test
    fun test_plural() {
        val us1 : String = TimeUnits.SECOND.plural(1) //1 секунду
        val us2 : String = TimeUnits.MINUTE.plural(4) //4 минуты
        val us3 : String = TimeUnits.HOUR.plural(19) //19 часов
        val us4 : String = TimeUnits.DAY.plural(222) //222 дня

        println("""
            $us1
            $us2
            $us3
            $us4
        """.trimIndent())
    }
    @Test
    fun test_truncate() {
        val us1 = "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»"
        val us2 = "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»"
        val us3 = "A     "

        println("""
            ${us1.truncate()}
            ${us2.truncate(15)}
            ${us3.truncate(3)}
        """.trimIndent())
    }
    @Test
    fun test_stripHtml() {
        val us1 = "<p class=title>Образовательное IT-сообщество Skill Branch</p>"
        val us2 = "<p>Образовательное       IT-сообщество Skill Branch</p>"

        println("""
            ${us1.stripHtml()}
            ${us2.stripHtml()}
        """.trimIndent())
    }


}
