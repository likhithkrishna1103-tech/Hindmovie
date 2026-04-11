package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e6.i f13695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e6.i f13696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13697c;

    public y(long j5, long[] jArr, long[] jArr2) {
        s1.d.b(jArr.length == jArr2.length);
        int length = jArr2.length;
        if (length <= 0 || jArr2[0] <= 0) {
            this.f13695a = new e6.i(length);
            this.f13696b = new e6.i(length);
        } else {
            int i = length + 1;
            e6.i iVar = new e6.i(i);
            this.f13695a = iVar;
            e6.i iVar2 = new e6.i(i);
            this.f13696b = iVar2;
            iVar.a(0L);
            iVar2.a(0L);
        }
        this.f13695a.b(jArr);
        this.f13696b.b(jArr2);
        this.f13697c = j5;
    }

    @Override // w2.b0
    public final boolean h() {
        return this.f13696b.f4522u > 0;
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        e6.i iVar = this.f13696b;
        if (iVar.f4522u == 0) {
            c0 c0Var = c0.f13600c;
            return new a0(c0Var, c0Var);
        }
        int iB = s1.b0.b(iVar, j5);
        long jD = iVar.d(iB);
        e6.i iVar2 = this.f13695a;
        c0 c0Var2 = new c0(jD, iVar2.d(iB));
        if (jD == j5 || iB == iVar.f4522u - 1) {
            return new a0(c0Var2, c0Var2);
        }
        int i = iB + 1;
        return new a0(c0Var2, new c0(iVar.d(i), iVar2.d(i)));
    }

    @Override // w2.b0
    public final long k() {
        return this.f13697c;
    }
}
