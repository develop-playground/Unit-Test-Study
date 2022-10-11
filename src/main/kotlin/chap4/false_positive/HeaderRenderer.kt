package chap4.false_positive

class HeaderRenderer : IRenderer {
    override fun render(message: Message): String = "<h1>${message.header}</h1>"
}