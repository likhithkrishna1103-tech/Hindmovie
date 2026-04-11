package a5;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import androidx.emoji2.text.r;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements z4.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f542v = new String[0];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Object f543w = ga.b.u(new c(0));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f544x = ga.b.u(new c(1));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SQLiteDatabase f545u;

    public d(SQLiteDatabase sQLiteDatabase) {
        this.f545u = sQLiteDatabase;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, nd.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, nd.c] */
    @Override // z4.a
    public final void A() throws IllegalAccessException, InvocationTargetException {
        ?? r22 = f544x;
        if (((Method) r22.getValue()) != null) {
            ?? r32 = f543w;
            if (((Method) r32.getValue()) != null) {
                Method method = (Method) r22.getValue();
                be.h.b(method);
                Method method2 = (Method) r32.getValue();
                be.h.b(method2);
                Object objInvoke = method2.invoke(this.f545u, null);
                if (objInvoke == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                method.invoke(objInvoke, 0, null, 0, null);
                return;
            }
        }
        f();
    }

    @Override // z4.a
    public final boolean D() {
        return this.f545u.inTransaction();
    }

    @Override // z4.a
    public final boolean L() {
        return this.f545u.isWriteAheadLoggingEnabled();
    }

    @Override // z4.a
    public final void P(Object[] objArr) {
        this.f545u.execSQL("UPDATE requests SET _written_bytes = ?, _total_bytes = ?, _status = ? WHERE _id = ?", objArr);
    }

    @Override // z4.a
    public final void Q() {
        this.f545u.setTransactionSuccessful();
    }

    @Override // z4.a
    public final void R() {
        this.f545u.beginTransactionNonExclusive();
    }

    @Override // z4.a
    public final Cursor a0(String str) {
        be.h.e(str, "query");
        return p(new r(str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f545u.close();
    }

    @Override // z4.a
    public final void e() {
        this.f545u.endTransaction();
    }

    @Override // z4.a
    public final void f() {
        this.f545u.beginTransaction();
    }

    @Override // z4.a
    public final boolean isOpen() {
        return this.f545u.isOpen();
    }

    @Override // z4.a
    public final void n(String str) {
        be.h.e(str, "sql");
        this.f545u.execSQL(str);
    }

    @Override // z4.a
    public final Cursor p(z4.d dVar) {
        final a aVar = new a(dVar);
        Cursor cursorRawQueryWithFactory = this.f545u.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: a5.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                z4.d dVar2 = aVar.f539u;
                be.h.b(sQLiteQuery);
                dVar2.d(new k(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, dVar.v(), f542v, null);
        be.h.d(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }

    @Override // z4.a
    public final l r(String str) {
        be.h.e(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f545u.compileStatement(str);
        be.h.d(sQLiteStatementCompileStatement, "compileStatement(...)");
        return new l(sQLiteStatementCompileStatement);
    }
}
