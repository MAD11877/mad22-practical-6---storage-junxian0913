package sg.edu.np.mad.newprojectfile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBapadter extends SQLiteOpenHelper {
    public DBapadter(Context c){
        super(c, "P05.db",null,1 );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * CREATE TABLE USER (NAME TEXT, DESCRIPTION TEXT, ID INTEGER, FOLLOWED BOOLEAN)
         *
         */
        db.execSQL("CREATE TABLE USER (NAME TEXT, DESCRIPTION TEXT, ID INTEGER, FOLLOWED BOOLEAN)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER ");
        onCreate(db);
    }
    public void insertmessage(user m){
        /**
         * INSERT INTO USER VALUES( "NAME", "DESCRIPTION", "ID", "FOLLOWED "
         */
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO USER VALUES( \""+ m.name+"\", \""+m.description+"\", \""+m.id+"\", \""+m.followed+"\")");
        db.close();

    }
    public ArrayList<user> getUsers(){

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<user> list= new ArrayList<>();
        /**
         * SELECT * FROM USER;
         */
        Cursor cursor = db.rawQuery("SELECT * FROM USER",null);

        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            int id = cursor.getInt(2);

            Boolean follow = cursor.getInt(3)>0;
            user u = new user(name,description,id,follow);
            list.add(u);
        }
        cursor.close();
        db.close();

        return list;
    }

    public void updateUser(user m){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE ID = \"" + m.id + "\"", null);
        if (cursor.moveToFirst()){
            db.delete("User", "id = ?", new String[]{String.valueOf(m.id)});
            insertmessage(m);
        }

    }
}
