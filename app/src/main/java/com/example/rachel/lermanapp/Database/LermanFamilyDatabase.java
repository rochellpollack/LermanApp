package com.example.rachel.lermanapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Rachel on 3/16/2016.
 */
public class LermanFamilyDatabase extends SQLiteAssetHelper {
    //Database name
    public static final String LERMAN_FAMILY_DB = "LFDDatabase.db";
    //Database version
    public static final int DB_VERSION = 1;

    public LermanFamilyDatabase(Context context) {
        super(context, LERMAN_FAMILY_DB, null, DB_VERSION);
    }

    public Cursor getContacts() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"0 _id", LermanFamilyContract.ContactsTable.COL_CONTACTS_PEOPLE_ID, LermanFamilyContract.ContactsTable.COL_CONTACTS_FIRST_NAME, LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSE_NAME, LermanFamilyContract.ContactsTable.COL_CONTACTS_LAST_NAME};

        String sqlTables = LermanFamilyContract.ContactsTable.TABLE_NAME;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;
    }
}