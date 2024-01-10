package com.example.myapplication.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.data.UserBean;

public class Accountable extends SQLiteOpenHelper {

    // Le nom de la base de données.
    private static final String DB_NAME = "account_db";

    // La version de la base de données.
    private static final int DB_VERSION = 1;

    // Le nom de la table utilisateur.
    private static final String USER_TABLE_NAME = "user";

    // Les noms des colonnes de la table utilisateur.
    private static final String USER_ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM ="confirm";

    // Constructeur pour la classe Accountable.
    public Accountable(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Crée la table utilisateur lors de la création de la base de données.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableUser = "CREATE TABLE " + USER_TABLE_NAME + "(" +
                USER_ID + " INTEGER PRIMARY KEY," +
                NAME + " VARCHAR(50) NOT NULL," +
                EMAIL + " VARCHAR(100) NOT NULL," +
                PASSWORD + " VARCHAR(20) NOT NULL," +
                CONFIRM + " VARCHAR(20) NOT NULL" +
                ")";
        db.execSQL(createTableUser);
    }

    // Met à jour la table utilisateur lors de la mise à jour de la base de données.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(db);
    }

    // Ajoute un utilisateur à la table utilisateur.
    public boolean addUser(UserBean user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());
        values.put(CONFIRM, user.getConfirmPassword());

        long result = db.insert(USER_TABLE_NAME, null, values);

        db.close();

        return result != -1;
    }

    // Récupère un utilisateur par son email.
    public UserBean getUserByEmail(String email) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {USER_ID, NAME, EMAIL, PASSWORD};
        String selection = EMAIL + " = ?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(USER_TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        UserBean user = null;

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(USER_ID);
            int nameIndex = cursor.getColumnIndex(NAME);
            int passwordIndex = cursor.getColumnIndex(PASSWORD);

            if (idIndex >= 0 && nameIndex >= 0 && passwordIndex >= 0) {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                String password = cursor.getString(passwordIndex);
                user = new UserBean(id, name, email, password);
            }
        }

        cursor.close();
        db.close();

        return user;
    }

    // Met à jour un utilisateur.
    public boolean updateUser(UserBean user) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(PASSWORD, user.getPassword());

        String selection = EMAIL + " = ?";
        String[] selectionArgs = {user.getEmail()};

        int rowsAffected = db.update(USER_TABLE_NAME, values, selection, selectionArgs);

        db.close();

        return rowsAffected > 0;
    }

    // Supprime un utilisateur.
    public boolean deleteUser(UserBean user) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = EMAIL + " = ?";
        String[] selectionArgs = {user.getEmail()};

        int rowsAffected = db.delete(USER_TABLE_NAME, selection, selectionArgs);

        db.close();

        return rowsAffected > 0;
    }
}
