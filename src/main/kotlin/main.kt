const val minute = 60
const val hour = minute * 60
const val day = hour * 24


fun main() {


    val countSeconds = readLine()?.toInt()
    val countMinutes = countSeconds!! / 60
    val countHours = countMinutes / 60


    val syntaxMinute = syntaxMinutes(countMinutes)
    val syntaxHour = syntaxHours(countHours)

    val agoToText = syntaxAgoToText(countSeconds, countMinutes, syntaxMinute, countHours, syntaxHour)
    print("был(а) $agoToText")

}

private fun syntaxAgoToText(
    countSeconds: Int,
    countMinutes: Int,
    syntMinute: String,
    countHours: Int,
    syntHour: String,
) = when (countSeconds) {
    in 0..60 -> "только что"
    in minute + 1..hour -> "$countMinutes $syntMinute назад"
    in hour + 1..day -> "$countHours $syntHour назад"
    in day + 1..day * 2 -> "сегодня"
    in (day * 2) + 1 downTo day * 3 -> "вчера"
    else -> "давно"
}

private fun syntaxHours(countHours: Int) = when {
    countHours == 1 -> "час"
    countHours != 11 && countHours % 10 == 1 -> "час"
    countHours == 2 || countHours == 3 || countHours == 4 -> "часа"
    countHours % 10 == 2 || countHours % 10 == 3 || countHours % 10 == 4 -> "часа"
    else -> "часов"
}

private fun syntaxMinutes(countMinutes: Int) = when {
    countMinutes == 1 -> "минуту"
    countMinutes != 11 && countMinutes % 10 == 1 -> "минуту"
    countMinutes == 2 || countMinutes == 3 || countMinutes == 4 ||
            countMinutes % 10 == 2 || countMinutes % 10 == 3 || countMinutes % 10 == 4 -> "минуты"
    else -> "минут"
}