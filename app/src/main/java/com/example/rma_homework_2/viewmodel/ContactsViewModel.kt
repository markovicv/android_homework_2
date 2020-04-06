package com.example.rma_homework_2.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rma_homework_2.model.Contact

class ContactsViewModel : ViewModel() {

    private val contacts : MutableLiveData<List<Contact>> = MutableLiveData()
    private val contactList : MutableList<Contact> = mutableListOf()


    init {
        for(i in 1..20){
            contactList.add(Contact("x","Marko$i","Peric$i","033/222/111","perica@raf.rs"))

        }
        val listToSubmit = mutableListOf<Contact>()
        listToSubmit.addAll(contactList)
        contacts.value = listToSubmit
    }

    fun getContacts(): LiveData<List<Contact>>{
        return contacts
    }

    fun deleteContact(position: Int){
        contactList.removeAt(position)
        contacts.value = contactList
    }
    fun addContact(contact: Contact){
        contactList.add(contact)
        contacts.value = contactList
    }

    fun filter(fiterName:String){
        val filteredList = contactList.filter {
            it.name.toLowerCase().startsWith(fiterName.toLowerCase())
        }
        contacts.value = filteredList
    }



}