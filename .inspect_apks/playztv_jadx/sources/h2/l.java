package h2;

import aa.j0;
import aa.m0;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5715e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5717h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f5719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5720l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f5721m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f5722n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f5723o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f5724p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p1.m f5725q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j0 f5726r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j0 f5727s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m0 f5728t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f5729u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f5730v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j0 f5731w;

    public l(int i, String str, List list, long j5, boolean z2, long j8, boolean z10, int i10, long j10, int i11, long j11, long j12, boolean z11, boolean z12, boolean z13, p1.m mVar, List list2, List list3, k kVar, Map map, List list4) {
        super(str, list, z11);
        this.f5714d = i;
        this.f5717h = j8;
        this.f5716g = z2;
        this.i = z10;
        this.f5718j = i10;
        this.f5719k = j10;
        this.f5720l = i11;
        this.f5721m = j11;
        this.f5722n = j12;
        this.f5723o = z12;
        this.f5724p = z13;
        this.f5725q = mVar;
        this.f5726r = j0.r(list2);
        this.f5727s = j0.r(list3);
        this.f5728t = m0.a(map);
        this.f5731w = j0.r(list4);
        if (!list3.isEmpty()) {
            g gVar = (g) aa.q.k(list3);
            this.f5729u = gVar.f5707y + gVar.f5705w;
        } else if (list2.isEmpty()) {
            this.f5729u = 0L;
        } else {
            i iVar = (i) aa.q.k(list2);
            this.f5729u = iVar.f5707y + iVar.f5705w;
        }
        this.f5715e = j5 != -9223372036854775807L ? j5 >= 0 ? Math.min(this.f5729u, j5) : Math.max(0L, this.f5729u + j5) : -9223372036854775807L;
        this.f = j5 >= 0;
        this.f5730v = kVar;
    }

    @Override // l2.a
    public final Object a(List list) {
        return this;
    }
}
