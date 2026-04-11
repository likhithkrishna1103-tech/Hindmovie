package c3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2077e;
    public final int f;

    public d(int i, int i10, int i11, int i12, int i13, int i14) {
        this.f2073a = i;
        this.f2074b = i10;
        this.f2075c = i11;
        this.f2076d = i12;
        this.f2077e = i13;
        this.f = i14;
    }

    @Override // c3.a
    public final int a() {
        return 1752331379;
    }

    public final int b() {
        int i = this.f2073a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        y1.b.p("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i));
        return -1;
    }
}
