package com.example.rma_homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rma_homework_2.model.Contact
import com.example.rma_homework_2.view.recycler.adapter.ContactAdapter
import com.example.rma_homework_2.viewmodel.ContactsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity(),OnClickDeleteItem {

    private val contactsViewModel:ContactsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initListeners()


    }
    fun initListeners(){
        addBtn.setOnClickListener {
            val name = newNameId.text.toString()
            if(name!=null && name !="")
                contactsViewModel.addContact(Contact("x",name,"BBBBB","CCCCCC","DDDDD"))
        }
        searchId.doAfterTextChanged {
            contactsViewModel.filter(it.toString())
        }
    }
    fun initRecycler(){
        rvId.layoutManager = GridLayoutManager(this,2)
        val contactAdapter = ContactAdapter(this)
        rvId.adapter = contactAdapter
        contactsViewModel.getContacts().observe(this, Observer {
            contactAdapter.setList(it)
        })

    }

    override fun onClik(position:  Int) {
       // println(position)
       // Toast.makeText(this,position,Toast.LENGTH_SHORT).show()
        contactsViewModel.deleteContact(position)
    }
}
