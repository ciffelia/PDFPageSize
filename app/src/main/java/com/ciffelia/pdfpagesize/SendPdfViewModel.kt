package com.ciffelia.pdfpagesize

import android.app.Application
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciffelia.pdfpagesize.pdf.PdfFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SendPdfViewModel (
    application: Application,
    intent: Intent
) : ViewModel() {

    private val receivedFile: ReceivedFile

    val pdfFileName: String?
    val pdfFile: PdfFile

    init {
        if (intent.type != "application/pdf") {
            throw IllegalArgumentException("Unsupported intent type")
        }

        receivedFile = ReceivedFile(application, intent)

        pdfFileName = receivedFile.fileName
        pdfFile = PdfFile(receivedFile.fileDescriptor)

        viewModelScope.launch(context = Dispatchers.IO) {
            preloadPdfPages()
        }
    }

    override fun onCleared() {
        super.onCleared()
        pdfFile.close()
    }

    private fun preloadPdfPages () {
        for (page in pdfFile.pages) {
            page.sizeStandard
            page.orientation
        }
    }
}
