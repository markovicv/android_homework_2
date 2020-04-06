package com.example.rma_homework_2.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.example.rma_homework_2.OnClickDeleteItem
import com.example.rma_homework_2.model.Contact
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {



    fun bind(contact:Contact,onClickDeleteItem: OnClickDeleteItem){
        itemView.nameId.text = contact.name
        itemView.surnameId.text = contact.surnmae
        itemView.telephoneId.text = contact.telephone
        itemView.emailId.text = contact.email
       /* Picasso
            .get()
            .load(contact.image)
            .into(itemView.contactImg)*/
        itemView.removeId.setOnClickListener {
            onClickDeleteItem.onClik(adapterPosition)
        }
    }
}