package com.example.rachel.lermanapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rachel on 3/16/2016.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    //database version
    private static final int DB_VERSION = 1;

    //table strings
    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String COMMA = ",";
    private static final String NOT_NULL = "NOT NULL";
    private static final String PRIMARY_KEY = "PRIMARY KEY";
    private static final String AUTOINCREMENT = "AUTOINCREMENT";
    private static final String UNIQUE = "UNIQUE";
    private static final String FOREIGN_KEY = "FOREIGN KEY";
    private static final String REFRENCES = "REFRENCES";



    //create table sentances
    private static final String CREATE_CONTACT_TABLE = "CREATE TABLE" +
            LermanFamilyContract.ContactsTable.TABLE_NAME + "(" +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_PEOPLE_ID + INTEGER_TYPE + NOT_NULL + PRIMARY_KEY +AUTOINCREMENT +UNIQUE + COMMA +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_PARENT_ID + INTEGER_TYPE + NOT_NULL + COMMA +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_LAST_NAME + TEXT_TYPE +NOT_NULL +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_FIRST_NAME +TEXT_TYPE +  NOT_NULL +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSE_NAME + TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_ADDRESS +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_CITY + TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_STATE +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_ZIP +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_HOME_NUMBER +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_CELL_NUMBER + TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSES_CELL_NUMBER +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_EMAIL_ADDRESS +TEXT_TYPE +
            LermanFamilyContract.ContactsTable.COL_CONTACTS_SPOUSES_EMAIL_ADDRESS + TEXT_TYPE +
            FOREIGN_KEY + "(" +LermanFamilyContract.ContactsTable.COL_CONTACTS_PARENT_ID + ")" +
            REFRENCES + "(" +LermanFamilyContract.PeopleTable.COL_PEOPLE_ID +")) ";

    private static final String CREATE_PEOPLE_TABLE = "CREATE TABLE" +
            LermanFamilyContract.PeopleTable.TABLE_NAME + "(" +
            LermanFamilyContract.PeopleTable.COL_PEOPLE_ID + INTEGER_TYPE + NOT_NULL + UNIQUE + COMMA +
            PRIMARY_KEY + "(" + LermanFamilyContract.PeopleTable.COL_PEOPLE_ID + ")" +
            FOREIGN_KEY + "(" +LermanFamilyContract.PeopleTable.COL_PEOPLE_ID + ")" +
            REFRENCES +LermanFamilyContract.ContactsTable.TABLE_NAME + "(" +LermanFamilyContract.PeopleTable.COL_PEOPLE_ID +")) ";



    //Table delete sentences
    private static final String DROP_CONTACT_TABLE = "DROP TABLE IF EXIST" +
           LermanFamilyContract.ContactsTable.TABLE_NAME;

    private static final String DROP_PEOPLE_TABLE = "DROP TABLE IF EXIST" +
            LermanFamilyContract.PeopleTable.TABLE_NAME;


    public DBOpenHelper(Context context) {
        super(context, LermanFamilyContract.DATABASE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);
        db.execSQL(CREATE_PEOPLE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_CONTACT_TABLE);
        db.execSQL(DROP_PEOPLE_TABLE);
        onCreate(db);

    }
}
