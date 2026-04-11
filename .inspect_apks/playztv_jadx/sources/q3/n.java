package q3;

import aa.c1;
import aa.h0;
import aa.j0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import w2.b0;
import w2.f0;
import w2.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements w2.o, b0 {
    public m[] A;
    public long[][] B;
    public int C;
    public long D;
    public int E;
    public l3.a F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t3.k f10668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f10670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.u f10671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s1.u f10672e;
    public final s1.u f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f10673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f10674h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c1 f10675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public s1.u f10680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10683r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10684s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10685t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10686u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10687v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f10688w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10689x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f10690y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public w2.q f10691z;

    public n(t3.k kVar, int i) {
        this.f10668a = kVar;
        this.f10669b = i;
        h0 h0Var = j0.f690v;
        this.f10675j = c1.f650y;
        this.f10676k = (i & 4) != 0 ? 3 : 0;
        this.f10674h = new p();
        this.i = new ArrayList();
        this.f = new s1.u(16);
        this.f10673g = new ArrayDeque();
        this.f10670c = new s1.u(t1.p.f12057a);
        this.f10671d = new s1.u(6);
        this.f10672e = new s1.u();
        this.f10681p = -1;
        this.f10691z = w2.q.f13663t;
        this.A = new m[0];
    }

    @Override // w2.o
    public final void c(w2.q qVar) {
        if ((this.f10669b & 16) == 0) {
            qVar = new a2.c(qVar, this.f10668a);
        }
        this.f10691z = qVar;
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) {
        c1 c1VarV;
        f0 f0VarN = q.n(pVar, false, (this.f10669b & 2) != 0);
        if (f0VarN != null) {
            c1VarV = j0.v(f0VarN);
        } else {
            h0 h0Var = j0.f690v;
            c1VarV = c1.f650y;
        }
        this.f10675j = c1VarV;
        return f0VarN == null;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f10673g.clear();
        this.f10679n = 0;
        this.f10681p = -1;
        this.f10682q = 0;
        this.f10683r = 0;
        this.f10684s = 0;
        this.f10685t = false;
        if (j5 == 0) {
            if (this.f10676k != 3) {
                this.f10676k = 0;
                this.f10679n = 0;
                return;
            } else {
                p pVar = this.f10674h;
                pVar.f10696a.clear();
                pVar.f10697b = 0;
                this.i.clear();
                return;
            }
        }
        for (m mVar : this.A) {
            u uVar = mVar.f10664b;
            int iE = s1.b0.e(uVar.f, j8, false);
            while (true) {
                if (iE < 0) {
                    iE = -1;
                    break;
                } else if ((uVar.f10735g[iE] & 1) != 0) {
                    break;
                } else {
                    iE--;
                }
            }
            if (iE == -1) {
                iE = uVar.a(j8);
            }
            mVar.f10667e = iE;
            i0 i0Var = mVar.f10666d;
            if (i0Var != null) {
                i0Var.f13640b = false;
                i0Var.f13641c = 0;
            }
        }
    }

    @Override // w2.o
    public final List g() {
        return this.f10675j;
    }

    @Override // w2.b0
    public final boolean h() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e4 A[EDGE_INSN: B:73:0x00e4->B:65:0x00e4 BREAK  A[LOOP:1: B:32:0x006b->B:64:0x00e0], SYNTHETIC] */
    @Override // w2.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w2.a0 i(long r21) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.n.i(long):w2.a0");
    }

    @Override // w2.b0
    public final long k() {
        return this.D;
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
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r44, w2.s r45) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 1832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.n.l(w2.p, w2.s):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0002 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(long r34) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 797
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.n.m(long):void");
    }

    @Override // w2.o
    public final w2.o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
