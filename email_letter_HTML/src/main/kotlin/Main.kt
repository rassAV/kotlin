import java.io.PrintWriter

fun main() {
    data class Message(val from_addr: String?, val to_addr: String?,
                       val topic: String? = null, val content: String? = null) {
        fun toHTML(): String {
            var template = "<table> "
            from_addr?.let { template += "<tr><td>from address</td><td>$it</td></tr> \n" }
            to_addr?.let { template += "<tr><td>to address</td><td>$it</td></tr> \n" }
            topic?.let { template += "<tr><td>topic</td><td>$it</td></tr> \n" }
            content?.let { template += "<tr><td>content</td><td>$it</td></tr> \n" }
            template +=  "</table>"
            return template
        }
    }

    val m = Message("fromname@microsoft.com", "toname@microsoft.com", null, "fdgdf")
    val writer = PrintWriter("index.html")
    writer.append(m.toHTML())
    writer.close()
}