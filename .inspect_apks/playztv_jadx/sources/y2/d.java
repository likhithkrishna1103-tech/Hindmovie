package y2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14499e;
    public final int f;

    public d(int i, int i10, int i11, int i12, int i13, int i14) {
        this.f14495a = i;
        this.f14496b = i10;
        this.f14497c = i11;
        this.f14498d = i12;
        this.f14499e = i13;
        this.f = i14;
    }

    @Override // y2.a
    public final int a() {
        return 1752331379;
    }

    public final int b() {
        int i = this.f14495a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        s1.b.p("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i));
        return -1;
    }
}
