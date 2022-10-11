package chap4.false_positive

class MessageRenderer : IRenderer {
    val subRenderers: List<IRenderer> = listOf(
        HeaderRenderer(),
        BodyRenderer(),
        FooterRenderer()
    )

    override fun render(message: Message): String {
        return subRenderers
            .map { x ->
                x.render(message)
            }.fold("") { str1, str2 ->
                str1 + str2
            }
    }
}