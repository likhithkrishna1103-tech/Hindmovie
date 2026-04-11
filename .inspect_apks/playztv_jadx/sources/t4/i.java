package t4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements y4.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y4.c f12130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f12131v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ p f12132w;

    public i(p pVar, y4.c cVar) {
        be.h.e(cVar, "delegate");
        this.f12132w = pVar;
        this.f12130u = cVar;
        this.f12131v = z7.a.i();
    }

    @Override // y4.c
    public final boolean O() {
        return getLong(0) != 0;
    }

    @Override // y4.c
    public final boolean W() {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.W();
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final void b(int i) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            this.f12130u.b(i);
        } else {
            android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
            throw null;
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            this.f12130u.close();
        } else {
            android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
            throw null;
        }
    }

    @Override // y4.c
    public final int getColumnCount() {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.getColumnCount();
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final String getColumnName(int i) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.getColumnName(i);
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final long getLong(int i) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.getLong(i);
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final void i(String str, int i) {
        be.h.e(str, "value");
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            this.f12130u.i(str, i);
        } else {
            android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
            throw null;
        }
    }

    @Override // y4.c
    public final boolean isNull(int i) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.isNull(i);
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final String j(int i) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            return this.f12130u.j(i);
        }
        android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
        throw null;
    }

    @Override // y4.c
    public final void k(long j5) {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            this.f12130u.k(j5);
        } else {
            android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
            throw null;
        }
    }

    @Override // y4.c
    public final void reset() {
        if (this.f12132w.f12151d.get()) {
            android.support.v4.media.session.b.O("Statement is recycled", 21);
            throw null;
        }
        if (this.f12131v == z7.a.i()) {
            this.f12130u.reset();
        } else {
            android.support.v4.media.session.b.O("Attempted to use statement on a different thread", 21);
            throw null;
        }
    }
}
