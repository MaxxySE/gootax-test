package com.maxie.gootax_test.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maxie.gootax_test.R
import com.maxie.gootax_test.entities.NavItem

class MainAdapter(private val items: List<NavItem>, private val onClick: (NavItem) -> Unit) :
    RecyclerView.Adapter<MainAdapter.NavViewHolder>() {

    inner class NavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.item_title)
        val subtitle: TextView = itemView.findViewById(R.id.item_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nav_item, parent, false)
        return NavViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        if (!item.subtitle.isNullOrEmpty()) {
            holder.subtitle.text = item.subtitle
            holder.subtitle.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount(): Int = items.size
}
