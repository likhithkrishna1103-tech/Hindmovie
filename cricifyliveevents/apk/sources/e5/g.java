package e5;

import a9.l;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends SQLiteOpenHelper {
    public static final /* synthetic */ int B = 0;
    public boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f3796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p6.d f3797w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d5.c f3798x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3799y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g5.a f3800z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String str, final p6.d dVar, final d5.c cVar) {
        String string;
        super(context, str, null, cVar.f3393b, new DatabaseErrorHandler() { // from class: e5.d
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                int i = g.B;
                ge.i.b(sQLiteDatabase);
                c cVarX = com.bumptech.glide.c.x(dVar, sQLiteDatabase);
                cVar.getClass();
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + cVarX + ".path");
                SQLiteDatabase sQLiteDatabase2 = cVarX.f3786v;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        d5.c.a(path);
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
                                ge.i.d(obj, "second");
                                d5.c.a((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                d5.c.a(path2);
                            }
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    cVarX.close();
                } catch (IOException unused2) {
                }
                if (attachedDbs != null) {
                    return;
                }
            }
        });
        ge.i.e(context, "context");
        ge.i.e(cVar, "callback");
        this.f3796v = context;
        this.f3797w = dVar;
        this.f3798x = cVar;
        if (str == null) {
            string = UUID.randomUUID().toString();
            ge.i.d(string, "toString(...)");
        } else {
            string = str;
        }
        this.f3800z = new g5.a(string, context.getCacheDir(), false);
    }

    public final d5.b a(boolean z10) {
        g5.a aVar = this.f3800z;
        try {
            aVar.a((this.A || getDatabaseName() == null) ? false : true);
            this.f3799y = false;
            SQLiteDatabase sQLiteDatabaseG = g(z10);
            if (!this.f3799y) {
                c cVarX = com.bumptech.glide.c.x(this.f3797w, sQLiteDatabaseG);
                aVar.b();
                return cVarX;
            }
            close();
            d5.b bVarA = a(z10);
            aVar.b();
            return bVarA;
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        g5.a aVar = this.f3800z;
        try {
            aVar.a(aVar.f5026a);
            super.close();
            this.f3797w.f10037w = null;
            this.A = false;
        } finally {
            aVar.b();
        }
    }

    public final SQLiteDatabase g(boolean z10) throws Throwable {
        SQLiteDatabase readableDatabase;
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z11 = this.A;
        if (databaseName != null && !z11 && (parentFile = this.f3796v.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z10) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ge.i.b(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase2 = getReadableDatabase();
            ge.i.b(readableDatabase2);
            return readableDatabase2;
        } catch (Throwable unused) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z10) {
                    readableDatabase = getWritableDatabase();
                    ge.i.b(readableDatabase);
                } else {
                    readableDatabase = getReadableDatabase();
                    ge.i.b(readableDatabase);
                }
                return readableDatabase;
            } catch (Throwable th) {
                th = th;
                if (th instanceof e) {
                    e eVar = (e) th;
                    int iOrdinal = eVar.f3789v.ordinal();
                    th = eVar.f3790w;
                    if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                        throw th;
                    }
                    if (iOrdinal != 4) {
                        throw new l();
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
        ge.i.e(sQLiteDatabase, "db");
        boolean z10 = this.f3799y;
        d5.c cVar = this.f3798x;
        if (!z10 && cVar.f3393b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            cVar.h(com.bumptech.glide.c.x(this.f3797w, sQLiteDatabase));
        } catch (Throwable th) {
            throw new e(f.f3791v, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ge.i.e(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.f3798x.i(com.bumptech.glide.c.x(this.f3797w, sQLiteDatabase));
        } catch (Throwable th) {
            throw new e(f.f3792w, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        ge.i.e(sQLiteDatabase, "db");
        this.f3799y = true;
        try {
            this.f3798x.j(com.bumptech.glide.c.x(this.f3797w, sQLiteDatabase), i, i10);
        } catch (Throwable th) {
            throw new e(f.f3794y, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        ge.i.e(sQLiteDatabase, "db");
        if (!this.f3799y) {
            try {
                this.f3798x.k(com.bumptech.glide.c.x(this.f3797w, sQLiteDatabase));
            } catch (Throwable th) {
                throw new e(f.f3795z, th);
            }
        }
        this.A = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i10) {
        ge.i.e(sQLiteDatabase, "sqLiteDatabase");
        this.f3799y = true;
        try {
            this.f3798x.l(com.bumptech.glide.c.x(this.f3797w, sQLiteDatabase), i, i10);
        } catch (Throwable th) {
            throw new e(f.f3793x, th);
        }
    }
}
