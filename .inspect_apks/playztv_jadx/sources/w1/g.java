package w1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f13523c = {"name", "length", "last_touch_timestamp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f13525b;

    public g() {
        this.f13524a = new HashMap();
        this.f13525b = new ArrayList();
    }

    public void a(Object obj, String str) {
        HashMap map = (HashMap) this.f13524a;
        obj.getClass();
        map.put(str, obj);
        ((ArrayList) this.f13525b).remove(str);
    }

    public HashMap b() throws c6.c {
        try {
            ((String) this.f13525b).getClass();
            Cursor cursorQuery = ((u1.a) this.f13524a).getReadableDatabase().query((String) this.f13525b, f13523c, null, null, null, null, null);
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
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    public void c(long j5) throws c6.c {
        u1.a aVar = (u1.a) this.f13524a;
        try {
            String hexString = Long.toHexString(j5);
            this.f13525b = "ExoPlayerCacheFileMetadata" + hexString;
            if (u1.b.a(aVar.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    u1.b.b(writableDatabase, 2, hexString);
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + ((String) this.f13525b));
                    writableDatabase.execSQL("CREATE TABLE " + ((String) this.f13525b) + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    public void d(Set set) throws c6.c {
        ((String) this.f13525b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((u1.a) this.f13524a).getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete((String) this.f13525b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    public void e(long j5, long j8, String str) throws c6.c {
        ((String) this.f13525b).getClass();
        try {
            SQLiteDatabase writableDatabase = ((u1.a) this.f13524a).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j5));
            contentValues.put("last_touch_timestamp", Long.valueOf(j8));
            writableDatabase.replaceOrThrow((String) this.f13525b, null, contentValues);
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    public g(u1.a aVar) {
        this.f13524a = aVar;
    }
}
