package com.example.rachel.lermanapp.Database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Rachel on 3/16/2016.
 */
public class LermanFamilyProvider extends ContentProvider {

    private LermanFamilyDatabase dbHelper;

    //URI matcher
    private static final int CONTACT = 1;
    private static final int PEOPLE = 2;

    private static final UriMatcher sURIMatcher = buildUriMatcher();
    private static UriMatcher buildUriMatcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        final String authority = LermanFamilyContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, LermanFamilyContract.ContactsTable.TABLE_NAME, CONTACT);
        matcher.addURI(authority, LermanFamilyContract.PeopleTable.TABLE_NAME, PEOPLE);

        return matcher;
    }



    @Override
    public boolean onCreate() {
        // get access to the database helper
        dbHelper = new LermanFamilyDatabase(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor;
        switch(sURIMatcher.match(uri)){
            // All Locations selected
            case CONTACT:{
                retCursor = dbHelper.getWritableDatabase().query(
                        LermanFamilyContract.ContactsTable.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                return retCursor;
            }

            default:{
                // By default, we assume a bad URI
                throw new UnsupportedOperationException("Unknown uri: " + uri);
            }
        }
    }

    @Override
    public String getType(Uri uri) {
        final int match = sURIMatcher.match(uri);

        switch (match){
            case CONTACT:{
                return LermanFamilyContract.ContactsTable.CONTENT_DIR_TYPE;
            }
            case PEOPLE:{
                return LermanFamilyContract.PeopleTable.CONTENT_DIR_TYPE;
            }
            default:{
                throw new UnsupportedOperationException("Unknown uri: " + uri);
            }

        }

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
