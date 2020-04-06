package com.example.rma_homework_2.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rma_homework_2.OnClickDeleteItem
import com.example.rma_homework_2.R
import com.example.rma_homework_2.model.Contact
import com.example.rma_homework_2.view.recycler.viewholder.ContactViewHolder

class ContactAdapter(val onClickDeleteItem: OnClickDeleteItem) : RecyclerView.Adapter<ContactViewHolder>() {
    private var contacts:List<Contact> = ArrayList<Contact>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts.get(position),onClickDeleteItem)
    }


    fun setList(newList:List<Contact>){
        val oldList = contacts
        val diffRes:DiffUtil.DiffResult = DiffUtil.calculateDiff(ContactItemDiffCallBack(oldList,newList))
        this.contacts = newList
        diffRes.dispatchUpdatesTo(this)
        notifyDataSetChanged()

    }


    class ContactItemDiffCallBack(var oldContactList:List<Contact>,var newContactList:List<Contact>):DiffUtil.Callback(){


        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldContactList.get(oldItemPosition).name == newContactList.get(newItemPosition).name
        }

        override fun getOldListSize(): Int {
            return oldContactList.size
        }

        override fun getNewListSize(): Int {
            return newContactList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            var contact1 = oldContactList.get(oldItemPosition)
            var contact2 = newContactList.get(newItemPosition)

            return contact1.email == contact2.email && contact1.image == contact2.image &&
                    contact1.surnmae == contact2.surnmae && contact1.telephone == contact2.telephone


        }
    }
}

