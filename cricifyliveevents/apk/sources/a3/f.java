package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f180e;
    public final long f;

    public f(h hVar, long j4, long j7, long j10, long j11, long j12) {
        this.f176a = hVar;
        this.f177b = j4;
        this.f178c = j7;
        this.f179d = j10;
        this.f180e = j11;
        this.f = j12;
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        d0 d0Var = new d0(j4, g.a(this.f176a.d(j4), 0L, this.f178c, this.f179d, this.f180e, this.f));
        return new b0(d0Var, d0Var);
    }

    @Override // a3.c0
    public final long l() {
        return this.f177b;
    }
}
