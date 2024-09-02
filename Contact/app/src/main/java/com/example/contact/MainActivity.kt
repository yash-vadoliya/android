package com.example.contact

import android.Manifest
import android.content.pm.PackageManager
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var contactsListView: ListView
    private val contactsList = mutableListOf<String>()
    private val phoneNumbers = mutableListOf<String>()

    private val requestPermissionsLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
        if (permissions[Manifest.permission.READ_CONTACTS] == true && permissions[Manifest.permission.CALL_PHONE] == true) {
            loadContacts()
        } else {
            Toast.makeText(this, "Permissions denied", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactsListView = findViewById(R.id.list)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            loadContacts()
        } else {
            requestPermissionsLauncher.launch(
                arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE)
            )
        }

        var add : Button = findViewById(R.id.Button_add)

        add.setOnClickListener {
            var intent = Intent(Intent.ACTION_INSERT)
            intent.data = ContactsContract.RawContacts.CONTENT_URI
            startActivity(intent)
            on_Restart()
        }
    }

    private fun on_Restart(){
        super.onRestart()
        loadContacts()
    }

    private fun loadContacts() {
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
        cursor?.use {
            val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
//
//            while (cursor.moveToNext()) {
                val name = cursor.getString(nameIndex)
                val number = cursor.getString(numberIndex)
                contactsList.add(name)
                phoneNumbers.add(number)
//            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
            contactsListView.adapter = adapter

            contactsListView.setOnItemClickListener { _, _, position, _ ->
                val number = phoneNumbers[position]
                makeCall(number)
            }
        }
    }

    private fun makeCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = android.net.Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Call permission not granted", Toast.LENGTH_SHORT).show()
        }
    }
}