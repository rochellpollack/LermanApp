package com.example.rachel.lermanapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.rachel.lermanapp.Database.LermanFamilyContract;
import com.example.rachel.lermanapp.Database.LermanFamilyDatabase;

/**
 * Created by Rachel on 1/28/2016.
 */
public class ContactsFragment extends android.support.v4.app.Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>{

    //locations Database
    private LermanFamilyDatabase lermanFamilyDatabase;

    private Cursor contacts;

    private ListView lvContacts;

    SimpleCursorAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);



        // To and from []s for adapter
        String[] from = {LermanFamilyContract.ContactsTable.COL_CONTACTS_FIRST_NAME,
        LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSE_NAME,LermanFamilyContract.ContactsTable.COL_CONTACTS_LAST_NAME};

        int [] to = {R.id.tvContactFirstName,R.id.tvContactSpouseName,R.id.tvContactLastName};

        //instantiating the database
        lermanFamilyDatabase = new LermanFamilyDatabase(getActivity());

        contacts = getActivity().getContentResolver().query(LermanFamilyContract.ContactsTable.CONTENT_URI,
                new String[]{"0 _id", LermanFamilyContract.ContactsTable.COL_CONTACTS_PEOPLE_ID,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_FIRST_NAME,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_LAST_NAME,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSE_NAME,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_ADDRESS,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_CITY,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_STATE,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_ZIP,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_HOME_NUMBER,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_CELL_NUMBER,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSES_CELL_NUMBER,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_EMAIL_ADDRESS,
                        LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSES_EMAIL_ADDRESS
                },
                null,
                null,
                null);

        //converting the data from the cursor object to the listview
        adapter = new SimpleCursorAdapter(getActivity(),
                R.layout.list_item_contact,
                contacts,
                from,
                to);

        //set the adapter
        lvContacts.setAdapter(adapter);


        return inflater.inflate(R.layout.fragment_contacts, container, false);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
