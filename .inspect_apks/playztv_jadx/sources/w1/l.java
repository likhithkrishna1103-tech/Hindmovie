package w1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f13540e = {"id", "key", "metadata"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1.a f13541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f13542b = new SparseArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13544d;

    public l(u1.a aVar) {
        this.f13541a = aVar;
    }

    @Override // w1.n
    public final void a(k kVar) {
        this.f13542b.put(kVar.f13535a, kVar);
    }

    @Override // w1.n
    public final void b(k kVar, boolean z2) {
        int i = kVar.f13535a;
        SparseArray sparseArray = this.f13542b;
        if (z2) {
            sparseArray.delete(i);
        } else {
            sparseArray.put(i, null);
        }
    }

    @Override // w1.n
    public final boolean c() throws c6.c {
        try {
            SQLiteDatabase readableDatabase = this.f13541a.getReadableDatabase();
            String str = this.f13543c;
            str.getClass();
            return u1.b.a(readableDatabase, 1, str) != -1;
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    @Override // w1.n
    public final void d(HashMap map) throws c6.c {
        SparseArray sparseArray = this.f13542b;
        if (sparseArray.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f13541a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i = 0; i < sparseArray.size(); i++) {
                try {
                    k kVar = (k) sparseArray.valueAt(i);
                    if (kVar == null) {
                        int iKeyAt = sparseArray.keyAt(i);
                        String str = this.f13544d;
                        str.getClass();
                        writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                    } else {
                        i(writableDatabase, kVar);
                    }
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            writableDatabase.setTransactionSuccessful();
            sparseArray.clear();
            writableDatabase.endTransaction();
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    @Override // w1.n
    public final void e(HashMap map) throws c6.c {
        try {
            SQLiteDatabase writableDatabase = this.f13541a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                j(writableDatabase);
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    i(writableDatabase, (k) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.f13542b.clear();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e10) {
            throw new c6.c(e10);
        }
    }

    @Override // w1.n
    public final void f(long j5) {
        String hexString = Long.toHexString(j5);
        this.f13543c = hexString;
        this.f13544d = l4.a.m("ExoPlayerCacheIndex", hexString);
    }

    @Override // w1.n
    public final void g(HashMap map, SparseArray sparseArray) throws c6.c {
        u1.a aVar = this.f13541a;
        s1.d.g(this.f13542b.size() == 0);
        try {
            SQLiteDatabase readableDatabase = aVar.getReadableDatabase();
            String str = this.f13543c;
            str.getClass();
            if (u1.b.a(readableDatabase, 1, str) != 1) {
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    j(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            SQLiteDatabase readableDatabase2 = aVar.getReadableDatabase();
            String str2 = this.f13544d;
            str2.getClass();
            Cursor cursorQuery = readableDatabase2.query(str2, f13540e, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    int i = cursorQuery.getInt(0);
                    String string = cursorQuery.getString(1);
                    string.getClass();
                    map.put(string, new k(i, string, b2.g.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                    sparseArray.put(i, string);
                } finally {
                }
            }
            cursorQuery.close();
        } catch (SQLiteException e10) {
            map.clear();
            sparseArray.clear();
            throw new c6.c(e10);
        }
    }

    @Override // w1.n
    public final void h() throws c6.c {
        u1.a aVar = this.f13541a;
        String str = this.f13543c;
        str.getClass();
        try {
            String strConcat = "ExoPlayerCacheIndex".concat(str);
            SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int i = u1.b.f12543a;
                try {
                    int i10 = b0.f11647a;
                    if (DatabaseUtils.queryNumEntries(writableDatabase, "sqlite_master", "tbl_name = ?", new String[]{"ExoPlayerVersions"}) > 0) {
                        writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                    }
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + strConcat);
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e10) {
                    throw new c6.c(e10);
                }
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e11) {
            throw new c6.c(e11);
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase, k kVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b2.g.b(kVar.f13539e, new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(kVar.f13535a));
        contentValues.put("key", kVar.f13536b);
        contentValues.put("metadata", byteArray);
        String str = this.f13544d;
        str.getClass();
        sQLiteDatabase.replaceOrThrow(str, null, contentValues);
    }

    public final void j(SQLiteDatabase sQLiteDatabase) throws c6.c {
        String str = this.f13543c;
        str.getClass();
        u1.b.b(sQLiteDatabase, 1, str);
        String str2 = this.f13544d;
        str2.getClass();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
        sQLiteDatabase.execSQL("CREATE TABLE " + this.f13544d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
    }
}
