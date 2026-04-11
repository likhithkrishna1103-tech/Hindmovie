package a5;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class k implements z4.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SQLiteProgram f569u;

    public k(SQLiteProgram sQLiteProgram) {
        be.h.e(sQLiteProgram, "delegate");
        this.f569u = sQLiteProgram;
    }

    @Override // z4.c
    public final void N(int i, long j5) {
        this.f569u.bindLong(i, j5);
    }

    @Override // z4.c
    public final void U(int i, byte[] bArr) {
        this.f569u.bindBlob(i, bArr);
    }

    @Override // z4.c
    public final void V(String str, int i) {
        be.h.e(str, "value");
        this.f569u.bindString(i, str);
    }

    @Override // z4.c
    public final void b(int i) {
        this.f569u.bindNull(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f569u.close();
    }

    @Override // z4.c
    public final void z(int i, double d10) {
        this.f569u.bindDouble(i, d10);
    }
}
