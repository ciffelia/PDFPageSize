package com.ciffelia.pdfpagesize.paper

import kotlin.math.abs

fun findClosestStandard(width: Int, height: Int): PaperSizeStandard? {
    if (width == height) return null
    if (width > height) return findClosestStandard(height, width)

    var closest: PaperSizeStandard? = null
    var closestError = Double.MAX_VALUE

    for (standard in PaperSizeStandard.AvailableStandards) {
        val widthError = abs((width - standard.width).toDouble() / width)
        val heightError = abs((height - standard.height).toDouble() / height)
        val error = widthError + heightError

        if (widthError < 0.1 && heightError < 0.1 && error < closestError) {
            closest = standard
            closestError = error
        }
    }

    return closest
}
