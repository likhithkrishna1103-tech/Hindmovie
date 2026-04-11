package e5;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i implements d5.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final SQLiteProgram f3806v;

    public i(SQLiteProgram sQLiteProgram) {
        ge.i.e(sQLiteProgram, "delegate");
        this.f3806v = sQLiteProgram;
    }

    @Override // d5.e
    public final void S(int i, byte[] bArr) {
        this.f3806v.bindBlob(i, bArr);
    }

    @Override // d5.e
    public final void b(int i) {
        this.f3806v.bindNull(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3806v.close();
    }

    @Override // d5.e
    public final void e(int i, long j4) {
        this.f3806v.bindLong(i, j4);
    }

    @Override // d5.e
    public final void f() {
        this.f3806v.clearBindings();
    }

    @Override // d5.e
    public final void n(int i, String str) {
        ge.i.e(str, "value");
        this.f3806v.bindString(i, str);
    }

    @Override // d5.e
    public final void t(int i, double d10) {
        this.f3806v.bindDouble(i, d10);
    }
}
