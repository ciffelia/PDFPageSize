package com.ciffelia.pdfpagesize.pdf

import android.graphics.pdf.PdfRenderer
import com.ciffelia.pdfpagesize.paper.Paper
import com.ciffelia.pdfpagesize.paper.PaperSizeStandard

class PdfPage(private val renderer: PdfRenderer, val index: Int) {
    private val paper: Paper by lazy {
        renderer.openPage(index).use { page ->
            return@lazy Paper(page.widthInMillimeters, page.heightInMillimeters)
        }
    }

    val width: Int
        get() = paper.width

    val height: Int
        get() = paper.height

    val sizeStandard: PaperSizeStandard?
        get() = paper.sizeStandard

    val orientation: Paper.Orientation
        get() = paper.orientation
}


// converts point (1/72 inch) to millimeters
private fun pointToMillimeter(value: Int) = (value * 0.352778).toInt()

// the page width in millimeters
private val PdfRenderer.Page.widthInMillimeters: Int
    get() = pointToMillimeter(width)

// the page height in millimeters
private val PdfRenderer.Page.heightInMillimeters: Int
    get() = pointToMillimeter(height)
