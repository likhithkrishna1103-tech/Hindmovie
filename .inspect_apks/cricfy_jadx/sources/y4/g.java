package y4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c5.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.c f14852v;

    public g(c5.c cVar) {
        this.f14852v = cVar;
    }

    @Override // c5.c
    public final void E(int i, String str) {
        ge.i.e(str, "value");
        this.f14852v.E(i, str);
    }

    @Override // c5.c
    public final boolean L() {
        return this.f14852v.L();
    }

    @Override // c5.c
    public final boolean V() {
        return this.f14852v.V();
    }

    @Override // c5.c
    public final void b(int i) {
        this.f14852v.b(i);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        c5.c cVar = this.f14852v;
        cVar.reset();
        cVar.f();
    }

    @Override // c5.c
    public final void e(int i, long j4) {
        this.f14852v.e(i, j4);
    }

    @Override // c5.c
    public final void f() {
        this.f14852v.f();
    }

    @Override // c5.c
    public final int getColumnCount() {
        return this.f14852v.getColumnCount();
    }

    @Override // c5.c
    public final String getColumnName(int i) {
        return this.f14852v.getColumnName(i);
    }

    @Override // c5.c
    public final long getLong(int i) {
        return this.f14852v.getLong(i);
    }

    @Override // c5.c
    public final boolean isNull(int i) {
        return this.f14852v.isNull(i);
    }

    @Override // c5.c
    public final String j(int i) {
        return this.f14852v.j(i);
    }

    @Override // c5.c
    public final void reset() {
        this.f14852v.reset();
    }
}
