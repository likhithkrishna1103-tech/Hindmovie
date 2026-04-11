package s2;

import aa.c1;
import aa.j0;
import aa.m0;
import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import o2.d0;
import s1.s;
import s1.w;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d, e0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c1 f11738p = j0.u(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c1 f11739q = j0.u(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c1 f11740r = j0.u(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c1 f11741s = j0.u(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final c1 f11742t = j0.u(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final c1 f11743u = j0.u(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static g f11744v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f11746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o4.c f11747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f11748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11749e;
    public final r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11751h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f11752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f11755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11756n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f11757o;

    public g(Context context, HashMap map, boolean z2) {
        boolean z10;
        w wVar = w.f11715a;
        this.f11745a = context == null ? null : context.getApplicationContext();
        this.f11746b = m0.a(map);
        this.f11747c = new o4.c(10);
        this.f = new r();
        this.f11748d = wVar;
        this.f11749e = z2;
        if (context == null) {
            this.f11756n = 0;
            this.f11754l = 1000000L;
            return;
        }
        s sVarA = s.a(context);
        int iB = sVarA.b();
        this.f11756n = iB;
        this.f11754l = a(iB);
        f fVar = new f(this);
        Executor executorI = s1.b.i();
        CopyOnWriteArrayList<s1.r> copyOnWriteArrayList = sVarA.f11698b;
        for (s1.r rVar : copyOnWriteArrayList) {
            if (rVar.f11694a.get() == null) {
                copyOnWriteArrayList.remove(rVar);
            }
        }
        s1.r rVar2 = new s1.r(sVarA, fVar, executorI);
        synchronized (sVarA.f11699c) {
            sVarA.f11698b.add(rVar2);
            z10 = sVarA.f11701e;
        }
        if (z10) {
            rVar2.f11695b.execute(new nc.b(4, rVar2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1149:0x1225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(int r18) {
        /*
            Method dump skipped, instruction units count: 8770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.g.a(int):long");
    }

    public final void b(int i, long j5, long j8) {
        final int i10;
        final long j10;
        final long j11;
        if (i == 0 && j5 == 0 && j8 == this.f11755m) {
            return;
        }
        this.f11755m = j8;
        for (final c cVar : (CopyOnWriteArrayList) this.f11747c.f9349u) {
            if (cVar.f11731c) {
                i10 = i;
                j10 = j5;
                j11 = j8;
            } else {
                i10 = i;
                j10 = j5;
                j11 = j8;
                cVar.f11729a.post(new Runnable() { // from class: s2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        b2.h hVar = cVar.f11730b;
                        b2.g gVar = hVar.f1745x;
                        b2.a aVarS = hVar.S(((j0) gVar.f1738c).isEmpty() ? null : (d0) aa.q.k((j0) gVar.f1738c));
                        hVar.W(aVarS, 1006, new b2.c(aVarS, i10, j10, j11));
                    }
                });
            }
            i = i10;
            j5 = j10;
            j8 = j11;
        }
    }
}
