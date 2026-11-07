package com.example.webview.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webview.databinding.ActivityMainLayoutBinding
import com.example.webview.databinding.AddContactLayoutBinding

class MainActivity :AppCompatActivity() {
    val contactList= mutableListOf<ContactModel>()
    private lateinit var binding:ActivityMainLayoutBinding
    lateinit var contactAdapter: ContactAdapter
    lateinit var dbManager: MyDbManager
    var changedPosition:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager= MyDbManager(this)
        dbManager.onCreate()
        contactAdapter= ContactAdapter()

        binding.contactFab.setOnClickListener { 
            showAddContactDialog()
        }
        contactAdapter.submitList(contactList)
        val myLayoutManager=LinearLayoutManager(this)
        binding.contactView.apply { 
            adapter=contactAdapter
            layoutManager=myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity,myLayoutManager.orientation))
            val iteTouchHelper=ItemTouchHelper(
                object:ItemTouchHelper.SimpleCallback(
                    0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
                    override fun onMove(
                        recyclerView: RecyclerView,
                        viewHolder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder
                    ): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        changedPosition=viewHolder.adapterPosition
                        if (direction==ItemTouchHelper.RIGHT){
                            makeCall(contactList[viewHolder.adapterPosition].phoneNumber)
                        }else{
                            makeSms(contactList[viewHolder.adapterPosition].phoneNumber)
                        }
                    }
                })
            iteTouchHelper.attachToRecyclerView(binding.contactView)
            fetchContactData()
        }
    }
    private fun makeSms(phoneNumber:String){
        Intent(Intent.ACTION_VIEW, Uri.parse("sms: $phoneNumber")).apply {
            startActivity(this)
        }
    }
    private fun makeCall(phoneNumber:String){
        Intent(Intent.ACTION_DIAL,Uri.parse("tel: $phoneNumber")).apply {
            startActivity(this)
        }
    }

    private fun showAddContactDialog() {
        val dialogBinding=AddContactLayoutBinding.inflate(layoutInflater)
        val dialog=AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setView(dialogBinding.root)
            .setPositiveButton("Add"){_,_ ->
                val name=dialogBinding.nameEt.text.toString()
                val age=dialogBinding.ageEt.text.toString().toInt()
                val phone=dialogBinding.phoneNumberEt.text.toString()
                val address=dialogBinding.addressEt.text.toString()
                dbManager.insert(ContactModel(0, name,phone,address,age))
                contactAdapter.submitList(fetchContactData())
                contactAdapter.notifyItemInserted(contactList.size)
            }
            .setNegativeButton("Cancel"){_,_ ->}
            .create()
        dialog.show()
    }


    private fun fetchContactData(): List<ContactModel>{
        val cursor =dbManager.fetch()
        contactList.clear()
        if (cursor !=null){
            val idIndex=cursor.getColumnIndex(MySQLiteHelper.id)
            val nameIndex=cursor.getColumnIndex(MySQLiteHelper.name)
            val ageIndex=cursor.getColumnIndex(MySQLiteHelper.age)
            val numberIndex=cursor.getColumnIndex(MySQLiteHelper.phone)
            val addressIndex=cursor.getColumnIndex(MySQLiteHelper.address)
            do {

                val id=cursor.getInt(idIndex)
                val name=cursor.getString(nameIndex)
                val age=cursor.getInt(ageIndex)
                val number=cursor.getString(numberIndex)
                val address=cursor.getString(addressIndex)
                val contactModel=ContactModel(id,name,number,address,age)
                contactList.add(contactModel)
            }while (cursor.moveToNext())
        }
        return contactList

    }

    override fun onResume() {
        super.onResume()
        changedPosition?.apply {
            contactAdapter.notifyItemInserted(this)
        }
    }
}