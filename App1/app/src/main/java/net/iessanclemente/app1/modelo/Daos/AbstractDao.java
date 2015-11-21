package net.iessanclemente.app1.modelo.Daos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.iessanclemente.app1.modelo.entidades.Persoa;

import java.util.List;

/**
 * Created by a10jesuslb on 11/18/15.
 */
public abstract class AbstractDao<T> extends SQLiteOpenHelper {

    public AbstractDao(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    abstract T selectOne(String id);
    abstract List<T> selectAll();
    abstract boolean remove(String id);
    abstract boolean update(String id);
    abstract boolean create(T rexistro);

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    abstract public void onCreatePropio(SQLiteDatabase db, String... args);
}
