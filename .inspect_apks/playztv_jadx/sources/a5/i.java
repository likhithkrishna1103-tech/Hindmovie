package a5;

import a2.y0;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends SQLiteOpenHelper {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f558u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u5.d f559v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t1.e f560w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f561x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b5.a f562y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f563z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, String str, final u5.d dVar, final t1.e eVar) {
        String string;
        super(context, str, null, eVar.f12004b, new DatabaseErrorHandler() { // from class: a5.f
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                int i = i.A;
                be.h.b(sQLiteDatabase);
                d dVarV = a.a.v(dVar, sQLiteDatabase);
                eVar.getClass();
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + dVarV + ".path");
                SQLiteDatabase sQLiteDatabase2 = dVarV.f545u;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        t1.e.a(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } finally {
                        if (attachedDbs != null) {
                            Iterator<T> it = attachedDbs.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                be.h.d(obj, "second");
                                t1.e.a((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                t1.e.a(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    dVarV.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            }
        });
        be.h.e(context, "context");
        be.h.e(eVar, "callback");
        this.f558u = context;
        this.f559v = dVar;
        this.f560w = eVar;
        if (str == null) {
            string = UUID.randomUUID().toString();
            be.h.d(string, "toString(...)");
        } else {
            string = str;
        }
        this.f562y = new b5.a(string, context.getCacheDir(), false);
    }

    public final z4.a a(boolean z2) {
        b5.a aVar = this.f562y;
        try {
            aVar.a((this.f563z || getDatabaseName() == null) ? false : true);
            this.f561x = false;
            SQLiteDatabase sQLiteDatabaseD = d(z2);
            if (!this.f561x) {
                d dVarV = a.a.v(this.f559v, sQLiteDatabaseD);
                aVar.b();
                return dVarV;
            }
            close();
            z4.a aVarA = a(z2);
            aVar.b();
            return aVarA;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        b5.a aVar = this.f562y;
        try {
            aVar.a(aVar.f1814a);
            super.close();
            this.f559v.f12784v = null;
            this.f563z = false;
        } finally {
            aVar.b();
        }
    }

    public final SQLiteDatabase d(boolean z2) throws Throwable {
        SQLiteDatabase readableDatabase;
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z10 = this.f563z;
        if (databaseName != null && !z10 && (parentFile = this.f558u.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z2) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                be.h.b(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase2 = getReadableDatabase();
            be.h.b(readableDatabase2);
            return readableDatabase2;
        } catch (Throwable unused) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z2) {
                    readableDatabase = getWritableDatabase();
                    be.h.b(readableDatabase);
                } else {
                    readableDatabase = getReadableDatabase();
                    be.h.b(readableDatabase);
                }
                return readableDatabase;
            } catch (Throwable th) {
                th = th;
                if (th instanceof g) {
                    g gVar = (g) th;
                    int iOrdinal = gVar.f550u.ordinal();
                    th = gVar.f551v;
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                        throw th;
                    }
                    if (iOrdinal != 4) {
                        throw new y0();
                    }
                    if (!(th instanceof SQLiteException)) {
                        throw th;
                    }
                }
                throw th;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        be.h.e(sQLiteDatabase, "db");
        boolean z2 = this.f561x;
        t1.e eVar = this.f560w;
        if (!z2 && eVar.f12004b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            eVar.h(a.a.v(this.f559v, sQLiteDatabase));
        } catch (Throwable th) {
            throw new g(h.f552u, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        be.h.e(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.f560w.i(a.a.v(this.f559v, sQLiteDatabase));
        } catch (Throwable th) {
            throw new g(h.f553v, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        be.h.e(sQLiteDatabase, "db");
        this.f561x = true;
        try {
            this.f560w.j(a.a.v(this.f559v, sQLiteDatabase), i, i10);
        } catch (Throwable th) {
            throw new g(h.f555x, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        be.h.e(sQLiteDatabase, "db");
        if (!this.f561x) {
            try {
                this.f560w.k(a.a.v(this.f559v, sQLiteDatabase));
            } catch (Throwable th) {
                throw new g(h.f556y, th);
            }
        }
        this.f563z = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        be.h.e(sQLiteDatabase, "sqLiteDatabase");
        this.f561x = true;
        try {
            this.f560w.l(a.a.v(this.f559v, sQLiteDatabase), i, i10);
        } catch (Throwable th) {
            throw new g(h.f554w, th);
        }
    }
}
