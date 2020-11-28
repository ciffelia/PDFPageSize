package com.ciffelia.pdfpagesize

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ciffelia.pdfpagesize.pdf.PdfPage


class PageRecyclerViewAdapter(
    private val context: Context,
    private val pageList: List<PdfPage>
) : RecyclerView.Adapter<PageRecyclerViewAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pageNumberTextView: TextView = itemView.findViewById(R.id.pageNumberTextView)
        val pageSizeValueTextView: TextView = itemView.findViewById(R.id.pageSizeValueTextView)
        val pageSizeDescriptionTextView: TextView = itemView.findViewById(R.id.pageSizeDescriptionTextView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.page_list_item, parent, false)

        return ViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val page = pageList[position]

        val sizeDescription = if (page.sizeStandard != null) {
            context.getString(R.string.page_size_standard_and_orientation, page.sizeStandard, page.orientation)
        } else {
            context.getString(R.string.page_orientation, page.orientation)
        }

        holder.pageNumberTextView.text = context.getString(R.string.page_number, position + 1)
        holder.pageSizeValueTextView.text = context.getString(R.string.page_size_value, page.width, page.height)
        holder.pageSizeDescriptionTextView.text = sizeDescription
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = pageList.size
}
