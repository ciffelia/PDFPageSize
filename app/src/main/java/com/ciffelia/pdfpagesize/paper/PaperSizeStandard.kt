package com.ciffelia.pdfpagesize.paper

data class PaperSizeStandard(val name: String, val width: Int, val height: Int) {
    override fun toString() = name

    companion object {
        val A0 = PaperSizeStandard("A0", 841, 1189)
        val A1 = PaperSizeStandard("A1", 594, 841)
        val A2 = PaperSizeStandard("A2", 420, 594)
        val A3 = PaperSizeStandard("A3", 297, 420)
        val A4 = PaperSizeStandard("A4", 210, 297)
        val A5 = PaperSizeStandard("A5", 148, 210)
        val A6 = PaperSizeStandard("A6", 105, 148)
        val A7 = PaperSizeStandard("A7", 74, 105)
        val A8 = PaperSizeStandard("A8", 52, 74)
        val A9 = PaperSizeStandard("A9", 37, 52)
        val A10 = PaperSizeStandard("A10", 26, 37)

        val JisB0 = PaperSizeStandard("JIS B0", 1030, 1456)
        val JisB1 = PaperSizeStandard("JIS B1", 728, 1030)
        val JisB2 = PaperSizeStandard("JIS B2", 515, 728)
        val JisB3 = PaperSizeStandard("JIS B3", 364, 515)
        val JisB4 = PaperSizeStandard("JIS B4", 257, 364)
        val JisB5 = PaperSizeStandard("JIS B5", 182, 257)
        val JisB6 = PaperSizeStandard("JIS B6", 128, 182)
        val JisB7 = PaperSizeStandard("JIS B7", 91, 128)
        val JisB8 = PaperSizeStandard("JIS B8", 64, 91)
        val JisB9 = PaperSizeStandard("JIS B9", 45, 64)
        val JisB10 = PaperSizeStandard("JIS B10", 32, 45)

        val AvailableStandards = listOf(
            A0,
            A1,
            A2,
            A3,
            A4,
            A5,
            A6,
            A7,
            A8,
            A9,
            A10,
            JisB0,
            JisB1,
            JisB2,
            JisB3,
            JisB4,
            JisB5,
            JisB6,
            JisB7,
            JisB8,
            JisB9,
            JisB10
        )
    }
}
