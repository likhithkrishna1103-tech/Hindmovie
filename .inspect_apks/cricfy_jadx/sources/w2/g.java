package w2;

import android.content.Context;
import b2.h0;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import s2.c0;
import ua.i0;
import ua.k0;
import ua.z0;
import y1.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements d, h0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final z0 f13851p = i0.n(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final z0 f13852q = i0.n(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final z0 f13853r = i0.n(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final z0 f13854s = i0.n(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final z0 f13855t = i0.n(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final z0 f13856u = i0.n(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static g f13857v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f13859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kf.i f13860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f13861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13862e;
    public final t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13864h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f13865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f13866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f13867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f13868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13870o;

    public g(Context context, HashMap map, boolean z10) {
        boolean z11;
        v vVar = v.f14615a;
        this.f13858a = context == null ? null : context.getApplicationContext();
        this.f13859b = k0.a(map);
        this.f13860c = new kf.i(25);
        this.f = new t();
        this.f13861d = vVar;
        this.f13862e = z10;
        if (context == null) {
            this.f13869n = 0;
            this.f13867l = 1000000L;
            return;
        }
        y1.s sVarA = y1.s.a(context);
        int iB = sVarA.b();
        this.f13869n = iB;
        this.f13867l = a(iB);
        f fVar = new f(this);
        Executor executorI = y1.b.i();
        CopyOnWriteArrayList<y1.r> copyOnWriteArrayList = sVarA.f14603b;
        for (y1.r rVar : copyOnWriteArrayList) {
            if (rVar.f14599a.get() == null) {
                copyOnWriteArrayList.remove(rVar);
            }
        }
        y1.r rVar2 = new y1.r(sVarA, fVar, executorI);
        synchronized (sVarA.f14604c) {
            sVarA.f14603b.add(rVar2);
            z11 = sVarA.f14606e;
        }
        if (z11) {
            rVar2.f14600b.execute(new pa.c(13, rVar2));
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
        throw new UnsupportedOperationException("Method not decompiled: w2.g.a(int):long");
    }

    public final void b(int i, long j4, long j7) {
        final int i10;
        final long j10;
        final long j11;
        if (i == 0 && j4 == 0 && j7 == this.f13868m) {
            return;
        }
        this.f13868m = j7;
        for (final c cVar : (CopyOnWriteArrayList) this.f13860c.f7483w) {
            if (cVar.f13844c) {
                i10 = i;
                j10 = j4;
                j11 = j7;
            } else {
                i10 = i;
                j10 = j4;
                j11 = j7;
                cVar.f13842a.post(new Runnable() { // from class: w2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        h2.f fVar = cVar.f13843b;
                        c2.o oVar = fVar.f5497y;
                        h2.a aVarS = fVar.S(((i0) oVar.f2036c).isEmpty() ? null : (c0) ua.q.l((i0) oVar.f2036c));
                        fVar.W(aVarS, 1006, new h2.c(aVarS, i10, j10, j11));
                    }
                });
            }
            i = i10;
            j4 = j10;
            j7 = j11;
        }
    }
}
