package com.example.rachel.lermanapp;

import android.os.Bundle;
import android.view.View;
import android.content.Loader;
import android.view.ViewGroup;
import android.database.Cursor;
import android.widget.ListView;
import android.app.LoaderManager;
import android.widget.ListAdapter;
import android.view.LayoutInflater;
import android.widget.SimpleCursorAdapter;

import com.example.rachel.lermanapp.Database.LermanFamilyContract;
import com.example.rachel.lermanapp.Database.LermanFamilyDatabase;


public class ContactsFragment extends android.support.v4.app.Fragment
        implements LoaderManager.LoaderCallbacks<Cursor>{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Cursor contacts = null;
        ListView lvContacts = null;
        ListAdapter adapter = null;

        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        String[] from = {
            LermanFamilyContract.ContactsTable.COL_CONTACTS_FIRST_NAME,
            LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSE_NAME,
            LermanFamilyContract.ContactsTable.COL_CONTACTS_LAST_NAME
        };

        int [] to = {
                R.id.tvContactFirstName,
                R.id.tvContactSpouseName,
                R.id.tvContactLastName
        };

        LermanFamilyDatabase lermanFamilyDatabase = new LermanFamilyDatabase(getActivity());

        contacts = lermanFamilyDatabase.getContacts();

        adapter = new SimpleCursorAdapter(
            getActivity(),
            R.layout.list_item_contact,
            contacts,
            from,
            to,
            0
        );

        lvContacts = (ListView) rootView.findViewById(R.id.lv_contacts);
        lvContacts.setAdapter(adapter);

        return rootView;
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
