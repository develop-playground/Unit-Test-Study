package chap4.false_positive

class FooterRenderer : IRenderer {
    override fun render(message: Message): String = "<i>${message.footer}</i>"
}