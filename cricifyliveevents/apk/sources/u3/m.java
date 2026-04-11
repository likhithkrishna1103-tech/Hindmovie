package u3;

import a3.c0;
import a3.j0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements a3.p, c0 {
    public l[] A;
    public long[][] B;
    public int C;
    public long D;
    public int E;
    public p3.a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3.n f12143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f12145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y1.t f12146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y1.t f12147e;
    public final y1.t f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f12148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f12149h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z0 f12150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f12152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public y1.t f12155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f12163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f12165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a3.r f12166z;

    public m(x3.n nVar, int i) {
        this.f12143a = nVar;
        this.f12144b = i;
        g0 g0Var = i0.f12341w;
        this.f12150j = z0.f12413z;
        this.f12151k = (i & 4) != 0 ? 3 : 0;
        this.f12149h = new o();
        this.i = new ArrayList();
        this.f = new y1.t(16);
        this.f12148g = new ArrayDeque();
        this.f12145c = new y1.t(z1.o.f15122a);
        this.f12146d = new y1.t(6);
        this.f12147e = new y1.t();
        this.f12156p = -1;
        this.f12166z = a3.r.f226a;
        this.A = new l[0];
    }

    @Override // a3.p
    public final void c(a3.r rVar) {
        if ((this.f12144b & 16) == 0) {
            rVar = new com.bumptech.glide.l(rVar, this.f12143a);
        }
        this.f12166z = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f12148g.clear();
        this.f12154n = 0;
        this.f12156p = -1;
        this.f12157q = 0;
        this.f12158r = 0;
        this.f12159s = 0;
        this.f12160t = false;
        if (j4 == 0) {
            if (this.f12151k != 3) {
                this.f12151k = 0;
                this.f12154n = 0;
                return;
            } else {
                o oVar = this.f12149h;
                oVar.f12171a.clear();
                oVar.f12172b = 0;
                this.i.clear();
                return;
            }
        }
        for (l lVar : this.A) {
            t tVar = lVar.f12139b;
            int iE = a0.e(tVar.f, j7, false);
            while (true) {
                if (iE < 0) {
                    iE = -1;
                    break;
                } else if ((tVar.f12210g[iE] & 1) != 0) {
                    break;
                } else {
                    iE--;
                }
            }
            if (iE == -1) {
                iE = tVar.a(j7);
            }
            lVar.f12142e = iE;
            j0 j0Var = lVar.f12141d;
            if (j0Var != null) {
                j0Var.f197b = false;
                j0Var.f198c = 0;
            }
        }
    }

    @Override // a3.p
    public final List f() {
        return this.f12150j;
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) {
        z0 z0VarO;
        a3.g0 g0VarN = p.n(qVar, false, (this.f12144b & 2) != 0);
        if (g0VarN != null) {
            z0VarO = i0.o(g0VarN);
        } else {
            g0 g0Var = i0.f12341w;
            z0VarO = z0.f12413z;
        }
        this.f12150j = z0VarO;
        return g0VarN == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:263:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0518 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x06fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x06fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r44, a3.t r45) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 1832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.m.i(a3.q, a3.t):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e4 A[EDGE_INSN: B:73:0x00e4->B:65:0x00e4 BREAK  A[LOOP:1: B:32:0x006b->B:64:0x00e0], SYNTHETIC] */
    @Override // a3.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a3.b0 j(long r21) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.m.j(long):a3.b0");
    }

    @Override // a3.c0
    public final long l() {
        return this.D;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0002 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(long r34) {
        /*
            Method dump skipped, instruction units count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.m.m(long):void");
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
