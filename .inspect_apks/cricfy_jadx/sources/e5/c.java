package e5;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import c.x;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d5.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String[] f3783w = new String[0];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f3784x = android.support.v4.media.session.b.F(new x(3));

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Object f3785y = android.support.v4.media.session.b.F(new x(4));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SQLiteDatabase f3786v;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.f3786v = sQLiteDatabase;
    }

    @Override // d5.b
    public final boolean G() {
        return this.f3786v.isWriteAheadLoggingEnabled();
    }

    @Override // d5.b
    public final boolean K() {
        return this.f3786v.enableWriteAheadLogging();
    }

    @Override // d5.b
    public final void M(Object[] objArr) {
        this.f3786v.execSQL("UPDATE requests SET _written_bytes = ?, _total_bytes = ?, _status = ? WHERE _id = ?", objArr);
    }

    @Override // d5.b
    public final void N() {
        this.f3786v.setTransactionSuccessful();
    }

    @Override // d5.b
    public final void P() {
        this.f3786v.beginTransactionNonExclusive();
    }

    @Override // d5.b
    public final Cursor Z(String str) {
        ge.i.e(str, "query");
        return f0(new d5.a(0, str));
    }

    @Override // d5.b
    public final boolean c() {
        return this.f3786v.inTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3786v.close();
    }

    @Override // d5.b
    public final Cursor f0(d5.f fVar) {
        final a aVar = new a(fVar);
        Cursor cursorRawQueryWithFactory = this.f3786v.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: e5.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                d5.f fVar2 = aVar.f3781v;
                ge.i.b(sQLiteQuery);
                fVar2.a(new i(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, fVar.s(), f3783w, null);
        ge.i.d(cursorRawQueryWithFactory, "rawQueryWithFactory(...)");
        return cursorRawQueryWithFactory;
    }

    @Override // d5.b
    public final void h() {
        this.f3786v.endTransaction();
    }

    @Override // d5.b
    public final void i() {
        this.f3786v.beginTransaction();
    }

    @Override // d5.b
    public final boolean isOpen() {
        return this.f3786v.isOpen();
    }

    @Override // d5.b
    public final void l() {
        this.f3786v.disableWriteAheadLogging();
    }

    @Override // d5.b
    public final void m(String str) {
        ge.i.e(str, "sql");
        this.f3786v.execSQL(str);
    }

    @Override // d5.b
    public final j p(String str) {
        ge.i.e(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f3786v.compileStatement(str);
        ge.i.d(sQLiteStatementCompileStatement, "compileStatement(...)");
        return new j(sQLiteStatementCompileStatement);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, rd.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, rd.c] */
    @Override // d5.b
    public final void v() throws IllegalAccessException, InvocationTargetException {
        ?? r22 = f3785y;
        if (((Method) r22.getValue()) != null) {
            ?? r32 = f3784x;
            if (((Method) r32.getValue()) != null) {
                Method method = (Method) r22.getValue();
                ge.i.b(method);
                Method method2 = (Method) r32.getValue();
                ge.i.b(method2);
                Object objInvoke = method2.invoke(this.f3786v, null);
                if (objInvoke == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                method.invoke(objInvoke, 0, null, 0, null);
                return;
            }
        }
        i();
    }
}
