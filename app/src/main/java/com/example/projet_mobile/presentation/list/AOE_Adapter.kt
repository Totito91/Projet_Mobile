package com.example.projet_mobile.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_mobile.R


class AOE_Adapter(private var dataSet: List<civilizations>, var listener: ((Int) -> Unit)? = null) : RecyclerView.Adapter<AOE_Adapter.ViewHolder>() {
    val imgArray = arrayOf(R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image13
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.aoe_civ)
            imageView = view.findViewById(R.id.image_civ)

        }
    }
    fun updateList(list : List<civilizations>){
        dataSet = list
        notifyDataSetChanged()

    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.aoe_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val civilizations = dataSet[position]
        viewHolder.imageView.setImageResource(imgArray[position])



        viewHolder.textView.text = civilizations.name
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(position)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
