package v3;

import a3.i0;
import a3.r;
import nb.w;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f13159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f13160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f13161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13162e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13164h;
    public int i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13168m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13158a = new e();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w f13165j = new w(26, false);

    public void a(long j4) {
        this.f13163g = j4;
    }

    public abstract long b(t tVar);

    public abstract boolean c(t tVar, long j4, w wVar);

    public void d(boolean z10) {
        if (z10) {
            this.f13165j = new w(26, false);
            this.f = 0L;
            this.f13164h = 0;
        } else {
            this.f13164h = 1;
        }
        this.f13162e = -1L;
        this.f13163g = 0L;
    }
}
