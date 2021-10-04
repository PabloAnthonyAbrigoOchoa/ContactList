package ec.edu.tecnologicoloja.contactlist.views;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ec.edu.tecnologicoloja.contactlist.R;
import ec.edu.tecnologicoloja.contactlist.adapter.ContactAdapter;

import ec.edu.tecnologicoloja.contactlist.manager.FirebaseContactManager;
import ec.edu.tecnologicoloja.contactlist.model.Contact;


public class ListActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView mListView;
    private Button formulario;
    private ContactAdapter contactAdapter;
    private List<Contact> mListContacts = new ArrayList<>();
    private FirebaseContactManager firebaseContactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Set Button
        formulario = (Button) findViewById(R.id.formulario);
        formulario.setOnClickListener(this);

        // Set views
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setOnItemClickListener(this);

        // Set contact list
        mListContacts = FirebaseContactManager.getInstance().getAllContacts();
        // check if list is null or empty to show the list or an informative text
        if (mListContacts != null && mListContacts.size() > 0) {
            mListView.setVisibility(View.VISIBLE);

            // Init adapter
            contactAdapter = new ContactAdapter(this, mListContacts);
            mListView.setAdapter(contactAdapter);
        } else {

            mListView.setVisibility(View.GONE);

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // start detail screen when an item list is pressed
        Intent intent = new Intent();
        intent.setClass(ListActivity.this,ContactActivity.class);
        intent.putExtra("id", mListContacts.get(position).getObjectId());
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v==formulario){
            Intent intent2 = new Intent(this, RegisterUser.class );
            startActivity(intent2);
        }
    }
}
