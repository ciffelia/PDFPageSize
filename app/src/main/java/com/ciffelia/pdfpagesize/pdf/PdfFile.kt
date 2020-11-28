package com.ciffelia.pdfpagesize.pdf

import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor

class PdfFile(fileDescriptor: ParcelFileDescriptor): AutoCloseable {
    private val renderer = PdfRenderer(fileDescriptor)

    val pages: List<PdfPage>

    init {
        val pageList = mutableListOf<PdfPage>()

        val pageCount = renderer.pageCount
        for (i in 0 until pageCount) {
            pageList.add(
                PdfPage(renderer, i)
            )
        }

        pages = pageList
    }

    override fun close() {
        renderer.close()
    }
}
