package com.ciffelia.pdfpagesize

import android.app.Application
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SendPdfViewModelFactory(
    private val application: Application,
    private val intent: Intent
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(SendPdfViewModel::class.java)) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }

        @Suppress("UNCHECKED_CAST")
        return SendPdfViewModel(application, intent) as T
    }
}
