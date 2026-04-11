package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f13619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13623e;
    public final long f;

    public e(h hVar, long j5, long j8, long j10, long j11, long j12) {
        this.f13619a = hVar;
        this.f13620b = j5;
        this.f13621c = j8;
        this.f13622d = j10;
        this.f13623e = j11;
        this.f = j12;
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        c0 c0Var = new c0(j5, g.a(this.f13619a.e(j5), 0L, this.f13621c, this.f13622d, this.f13623e, this.f));
        return new a0(c0Var, c0Var);
    }

    @Override // w2.b0
    public final long k() {
        return this.f13620b;
    }
}
