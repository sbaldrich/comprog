fun main() {
    println(readLine()!!.toLowerCase().replace("[aeiouy]+".toRegex(), "").replace("(.)".toRegex(), ".$1"))
}