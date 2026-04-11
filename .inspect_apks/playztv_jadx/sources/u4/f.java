package u4;

import a5.l;
import be.h;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l f12771x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(z4.a aVar, String str) {
        super(aVar, str);
        h.e(aVar, "db");
        h.e(str, "sql");
        this.f12771x = aVar.r(str);
    }

    @Override // y4.c
    public final boolean W() {
        a();
        this.f12771x.f570v.execute();
        return false;
    }

    @Override // y4.c
    public final void b(int i) {
        a();
        this.f12771x.b(i);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12771x.close();
        this.f12774w = true;
    }

    @Override // y4.c
    public final int getColumnCount() {
        a();
        return 0;
    }

    @Override // y4.c
    public final String getColumnName(int i) {
        a();
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final long getLong(int i) {
        a();
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final void i(String str, int i) {
        h.e(str, "value");
        a();
        this.f12771x.V(str, i);
    }

    @Override // y4.c
    public final boolean isNull(int i) {
        a();
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final String j(int i) {
        a();
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final void k(long j5) {
        a();
        this.f12771x.N(1, j5);
    }

    @Override // y4.c
    public final void reset() {
    }
}
