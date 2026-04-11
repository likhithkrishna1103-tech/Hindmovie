package c2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2008c = {"name", "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f2010b;

    public g() {
        this.f2009a = new HashMap();
        this.f2010b = new ArrayList();
    }

    public void a(Object obj, String str) {
        HashMap map = (HashMap) this.f2009a;
        obj.getClass();
        map.put(str, obj);
        ((ArrayList) this.f2010b).remove(str);
    }

    public HashMap b() throws a2.a {
        try {
            ((String) this.f2010b).getClass();
            Cursor cursorQuery = ((a2.b) this.f2009a).getReadableDatabase().query((String) this.f2010b, f2008c, null, null, null, null, null);
            try {
                HashMap map = new HashMap(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    string.getClass();
                    map.put(string, new f(cursorQuery.getLong(1), cursorQuery.getLong(2)));
                }
                cursorQuery.close();
                return map;
            } finally {
            }
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    public void c(long j4) throws a2.a {
        a2.b bVar = (a2.b) this.f2009a;
        try {
            String hexString = Long.toHexString(j4);
            this.f2010b = "ExoPlayerCacheFileMetadata" + hexString;
            if (a2.c.a(bVar.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    a2.c.b(writableDatabase, 2, hexString);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) this.f2010b));
                    writableDatabase.execSQL("CREATE TABLE " + ((String) this.f2010b) + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    public void d(Set set) throws a2.a {
        ((String) this.f2010b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((a2.b) this.f2009a).getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete((String) this.f2010b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    public void e(long j4, long j7, String str) throws a2.a {
        ((String) this.f2010b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((a2.b) this.f2009a).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j4));
            contentValues.put("last_touch_timestamp", Long.valueOf(j7));
            writableDatabase.replaceOrThrow((String) this.f2010b, null, contentValues);
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    public g(a2.b bVar) {
        this.f2009a = bVar;
    }
}
