package n2;

import java.util.List;
import java.util.Map;
import ua.i0;
import ua.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8690e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f8692h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8693j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f8694k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8695l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f8696m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f8697n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f8698o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f8699p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v1.l f8700q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final i0 f8701r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final i0 f8702s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final k0 f8703t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f8704u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f8705v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i0 f8706w;

    public l(int i, String str, List list, long j4, boolean z10, long j7, boolean z11, int i10, long j10, int i11, long j11, long j12, boolean z12, boolean z13, boolean z14, v1.l lVar, List list2, List list3, k kVar, Map map, List list4) {
        super(str, list, z12);
        this.f8689d = i;
        this.f8692h = j7;
        this.f8691g = z10;
        this.i = z11;
        this.f8693j = i10;
        this.f8694k = j10;
        this.f8695l = i11;
        this.f8696m = j11;
        this.f8697n = j12;
        this.f8698o = z13;
        this.f8699p = z14;
        this.f8700q = lVar;
        this.f8701r = i0.k(list2);
        this.f8702s = i0.k(list3);
        this.f8703t = k0.a(map);
        this.f8706w = i0.k(list4);
        if (!list3.isEmpty()) {
            g gVar = (g) ua.q.l(list3);
            this.f8704u = gVar.f8683z + gVar.f8681x;
        } else if (list2.isEmpty()) {
            this.f8704u = 0L;
        } else {
            i iVar = (i) ua.q.l(list2);
            this.f8704u = iVar.f8683z + iVar.f8681x;
        }
        this.f8690e = j4 != -9223372036854775807L ? j4 >= 0 ? Math.min(this.f8704u, j4) : Math.max(0L, this.f8704u + j4) : -9223372036854775807L;
        this.f = j4 >= 0;
        this.f8705v = kVar;
    }

    @Override // r2.a
    public final Object a(List list) {
        return this;
    }
}
