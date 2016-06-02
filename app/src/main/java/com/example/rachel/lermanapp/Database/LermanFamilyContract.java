package com.example.rachel.lermanapp.Database;

import android.content.ContentResolver;
import android.net.Uri;

/**
 * Created by Rachel on 3/16/2016.
 */
public class LermanFamilyContract {

    //Content Authority
    public static final String CONTENT_AUTHORITY = "com.example.rachel.lermanapp";

    //base for all uris
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    public static final String PATH_CONTACTS = "contacts";
    public static final String PATH_PEOPLE = "people";

    //Database Name
    public static final String DATABASE_NAME = "databases/LFDDatabase.db";

    //contacts table
    public static final class ContactsTable {

        //table name
        public static final String TABLE_NAME = "contacts";

        //table fields
        public static final String COL_CONTACTS_PEOPLE_ID ="people_id";
        public static final String COL_CONTACTS_PARENT_ID = "parent_id";
        public static final String COL_CONTACTS_LAST_NAME ="last_name";
        public static final String COL_CONTACTS_FIRST_NAME = "first_name";
        public static final String COL_CONTACTS_SPOUSE_NAME ="spouse_name";
        public static final String COL_CONTACTS_ADDRESS= "address";
        public static final String COL_CONTACTS_CITY = "city";
        public static final String COL_CONTACTS_STATE = "state";
        public static final String COL_CONTACTS_ZIP = "zip";
        public static final String COL_CONTACTS_HOME_NUMBER = "home_number";
        public static final String COL_CONTACTS_CELL_NUMBER = "cell_number";
        public static final String COL_CONTACTS_SPOUSES_CELL_NUMBER = "spouses_cell_number";
        public static final String COL_CONTACTS_EMAIL_ADDRESS ="email_address";
        public static final String COL_CONTACTS_SPOUSES_EMAIL_ADDRESS ="spouses_email_address";


        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;


    }

    //peoples table
    public static final class PeopleTable {

        //table name
        public static final String TABLE_NAME = "people";

        //table fields
        public static final String COL_PEOPLE_ID = "id";

        // create content uri
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TABLE_NAME).build();
        // create cursor of base type directory for multiple entries
        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        // create cursor of base type item for single entry
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +"/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;



    }


}

