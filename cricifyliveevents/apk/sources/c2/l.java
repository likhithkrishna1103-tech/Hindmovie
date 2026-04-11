package c2;

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
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f2024e = {"id", "key", "metadata"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2.b f2025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f2026b = new SparseArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2028d;

    public l(a2.b bVar) {
        this.f2025a = bVar;
    }

    @Override // c2.n
    public final boolean a() throws a2.a {
        try {
            SQLiteDatabase readableDatabase = this.f2025a.getReadableDatabase();
            String str = this.f2027c;
            str.getClass();
            return a2.c.a(readableDatabase, 1, str) != -1;
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    @Override // c2.n
    public final void b(HashMap map) throws a2.a {
        SparseArray sparseArray = this.f2026b;
        if (sparseArray.size() == 0) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = this.f2025a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (int i = 0; i < sparseArray.size(); i++) {
                try {
                    k kVar = (k) sparseArray.valueAt(i);
                    if (kVar == null) {
                        int iKeyAt = sparseArray.keyAt(i);
                        String str = this.f2028d;
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
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    @Override // c2.n
    public final void c(k kVar) {
        this.f2026b.put(kVar.f2019a, kVar);
    }

    @Override // c2.n
    public final void d(HashMap map) throws a2.a {
        try {
            SQLiteDatabase writableDatabase = this.f2025a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                j(writableDatabase);
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    i(writableDatabase, (k) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                this.f2026b.clear();
                writableDatabase.endTransaction();
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        } catch (SQLException e9) {
            throw new a2.a(e9);
        }
    }

    @Override // c2.n
    public final void e(long j4) {
        String hexString = Long.toHexString(j4);
        this.f2027c = hexString;
        this.f2028d = q4.a.n("ExoPlayerCacheIndex", hexString);
    }

    @Override // c2.n
    public final void f(k kVar, boolean z10) {
        int i = kVar.f2019a;
        SparseArray sparseArray = this.f2026b;
        if (z10) {
            sparseArray.delete(i);
        } else {
            sparseArray.put(i, null);
        }
    }

    @Override // c2.n
    public final void g(HashMap map, SparseArray sparseArray) throws a2.a {
        a2.b bVar = this.f2025a;
        y1.d.g(this.f2026b.size() == 0);
        try {
            SQLiteDatabase readableDatabase = bVar.getReadableDatabase();
            String str = this.f2027c;
            str.getClass();
            if (a2.c.a(readableDatabase, 1, str) != 1) {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
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
            SQLiteDatabase readableDatabase2 = bVar.getReadableDatabase();
            String str2 = this.f2028d;
            str2.getClass();
            Cursor cursorQuery = readableDatabase2.query(str2, f2024e, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    int i = cursorQuery.getInt(0);
                    String string = cursorQuery.getString(1);
                    string.getClass();
                    map.put(string, new k(i, string, o.a(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                    sparseArray.put(i, string);
                } finally {
                }
            }
            cursorQuery.close();
        } catch (SQLiteException e9) {
            map.clear();
            sparseArray.clear();
            throw new a2.a(e9);
        }
    }

    @Override // c2.n
    public final void h() throws a2.a {
        a2.b bVar = this.f2025a;
        String str = this.f2027c;
        str.getClass();
        try {
            String strConcat = "ExoPlayerCacheIndex".concat(str);
            SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int i = a2.c.f113a;
                try {
                    int i10 = a0.f14551a;
                    if (DatabaseUtils.queryNumEntries(writableDatabase, "sqlite_master", "tbl_name = ?", new String[]{"ExoPlayerVersions"}) > 0) {
                        writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                    }
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + strConcat);
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e9) {
                    throw new a2.a(e9);
                }
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e10) {
            throw new a2.a(e10);
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase, k kVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        o.b(kVar.f2023e, new DataOutputStream(byteArrayOutputStream));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(kVar.f2019a));
        contentValues.put("key", kVar.f2020b);
        contentValues.put("metadata", byteArray);
        String str = this.f2028d;
        str.getClass();
        sQLiteDatabase.replaceOrThrow(str, null, contentValues);
    }

    public final void j(SQLiteDatabase sQLiteDatabase) throws a2.a {
        String str = this.f2027c;
        str.getClass();
        a2.c.b(sQLiteDatabase, 1, str);
        String str2 = this.f2028d;
        str2.getClass();
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
        sQLiteDatabase.execSQL("CREATE TABLE " + this.f2028d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
    }
}
