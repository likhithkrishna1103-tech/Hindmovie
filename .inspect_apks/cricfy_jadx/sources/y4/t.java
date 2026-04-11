package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements c5.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.c f14887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f14888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ z f14889x;

    public t(z zVar, c5.c cVar) {
        ge.i.e(cVar, "delegate");
        this.f14889x = zVar;
        this.f14887v = cVar;
        this.f14888w = ab.b.d();
    }

    @Override // c5.c
    public final void E(int i, String str) {
        ge.i.e(str, "value");
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.E(i, str);
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // c5.c
    public final boolean L() {
        return getLong(0) != 0;
    }

    @Override // c5.c
    public final boolean V() {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.V();
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final void b(int i) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.b(i);
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.close();
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // c5.c
    public final void e(int i, long j4) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.e(i, j4);
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // c5.c
    public final void f() {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.f();
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // c5.c
    public final int getColumnCount() {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.getColumnCount();
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final String getColumnName(int i) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.getColumnName(i);
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final long getLong(int i) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.getLong(i);
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final boolean isNull(int i) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.isNull(i);
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final String j(int i) {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            return this.f14887v.j(i);
        }
        android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // c5.c
    public final void reset() {
        if (this.f14889x.f14903e) {
            android.support.v4.media.session.b.N(21, "Statement is recycled");
            throw null;
        }
        if (this.f14888w == ab.b.d()) {
            this.f14887v.reset();
        } else {
            android.support.v4.media.session.b.N(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }
}
