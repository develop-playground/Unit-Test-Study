package chap4.false_positive

class BodyRenderer : IRenderer {
    override fun render(message: Message): String = "<b>${message.body}</b>"
}