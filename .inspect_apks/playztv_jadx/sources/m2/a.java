package m2;

import a2.d2;
import aa.c1;
import android.net.Uri;
import android.os.SystemClock;
import e6.f0;
import e6.i;
import j9.j0;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k8.a0;
import k8.b0;
import p1.q;
import p2.e;
import p2.f;
import p2.j;
import p2.m;
import q3.k;
import q3.s;
import r2.r;
import s1.d;
import s2.n;
import v1.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f8289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e[] f8291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f8292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f8293e;
    public n2.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o2.b f8295h;

    public a(n nVar, n2.c cVar, int i, r rVar, h hVar, b0 b0Var, boolean z2) {
        s[] sVarArr;
        this.f8289a = nVar;
        this.f = cVar;
        this.f8290b = i;
        this.f8293e = rVar;
        this.f8292d = hVar;
        n2.b bVar = cVar.f[i];
        this.f8291c = new e[rVar.length()];
        for (int i10 = 0; i10 < this.f8291c.length; i10++) {
            int iE = rVar.e(i10);
            q qVar = bVar.f8648j[iE];
            if (qVar.f10027r != null) {
                n2.a aVar = cVar.f8659e;
                aVar.getClass();
                sVarArr = aVar.f8640c;
            } else {
                sVarArr = null;
            }
            s[] sVarArr2 = sVarArr;
            int i11 = bVar.f8641a;
            int i12 = i11 == 2 ? 4 : 0;
            long j5 = bVar.f8643c;
            long j8 = cVar.f8660g;
            this.f8291c[i10] = new e(new k(b0Var, !z2 ? 35 : 3, null, new q3.r(iE, i11, j5, -9223372036854775807L, j8, j8, qVar, 0, sVarArr2, i12, null, null), c1.f650y, null), bVar.f8641a, qVar);
        }
    }

    @Override // p2.j
    public final long a(long j5, d2 d2Var) {
        n2.b bVar = this.f.f[this.f8290b];
        int iE = s1.b0.e(bVar.f8653o, j5, true);
        long[] jArr = bVar.f8653o;
        long j8 = jArr[iE];
        return d2Var.a(j5, j8, (j8 >= j5 || iE >= bVar.f8649k - 1) ? j8 : jArr[iE + 1]);
    }

    @Override // p2.j
    public final void b() throws o2.b {
        o2.b bVar = this.f8295h;
        if (bVar != null) {
            throw bVar;
        }
        this.f8289a.b();
    }

    @Override // p2.j
    public final boolean c(f fVar, boolean z2, i iVar, a0 a0Var) {
        j0 j0VarF = b8.h.f(this.f8293e);
        a0Var.getClass();
        e4.f fVarJ = a0.j(j0VarF, iVar);
        if (!z2 || fVarJ == null || fVarJ.f4419a != 2) {
            return false;
        }
        r rVar = this.f8293e;
        return rVar.o(rVar.g(fVar.f10146x), fVarJ.f4420b);
    }

    @Override // p2.j
    public final int d(long j5, List list) {
        return (this.f8295h != null || this.f8293e.length() < 2) ? list.size() : this.f8293e.f(j5, list);
    }

    @Override // p2.j
    public final void e(a2.c1 c1Var, long j5, List list, f0 f0Var) {
        List list2;
        int iA;
        long jB;
        if (this.f8295h != null) {
            return;
        }
        n2.b[] bVarArr = this.f.f;
        int i = this.f8290b;
        n2.b bVar = bVarArr[i];
        int i10 = bVar.f8649k;
        long[] jArr = bVar.f8653o;
        if (i10 == 0) {
            f0Var.f4498u = !r4.f8658d;
            return;
        }
        if (list.isEmpty()) {
            iA = s1.b0.e(jArr, j5, true);
            list2 = list;
        } else {
            list2 = list;
            iA = (int) (((m) list2.get(list.size() - 1)).a() - ((long) this.f8294g));
            if (iA < 0) {
                this.f8295h = new o2.b();
                return;
            }
        }
        if (iA >= bVar.f8649k) {
            f0Var.f4498u = !this.f.f8658d;
            return;
        }
        long j8 = c1Var.f178a;
        long j10 = j5 - j8;
        n2.c cVar = this.f;
        if (cVar.f8658d) {
            n2.b bVar2 = cVar.f[i];
            int i11 = bVar2.f8649k - 1;
            jB = (bVar2.b(i11) + bVar2.f8653o[i11]) - j8;
        } else {
            jB = -9223372036854775807L;
        }
        int length = this.f8293e.length();
        p2.n[] nVarArr = new p2.n[length];
        for (int i12 = 0; i12 < length; i12++) {
            this.f8293e.e(i12);
            nVarArr[i12] = new d2.j(bVar, iA);
        }
        this.f8293e.s(j8, j10, jB, list2, nVarArr);
        long j11 = jArr[iA];
        long jB2 = bVar.b(iA) + j11;
        long j12 = list.isEmpty() ? j5 : -9223372036854775807L;
        int i13 = this.f8294g + iA;
        int iN = this.f8293e.n();
        e eVar = this.f8291c[iN];
        int iE = this.f8293e.e(iN);
        List list3 = bVar.f8652n;
        q[] qVarArr = bVar.f8648j;
        d.g(qVarArr != null);
        d.g(list3 != null);
        d.g(iA < list3.size());
        String string = Integer.toString(qVarArr[iE].f10019j);
        String string2 = ((Long) list3.get(iA)).toString();
        Uri uriO = s1.b.o(bVar.f8650l, bVar.f8651m.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        SystemClock.elapsedRealtime();
        q qVarL = this.f8293e.l();
        int iM = this.f8293e.m();
        Object objQ = this.f8293e.q();
        Map map = Collections.EMPTY_MAP;
        d.i(uriO, "The uri must be set.");
        f0Var.f4499v = new p2.k(this.f8292d, new v1.m(uriO, 0L, 1, null, map, 0L, -1L, null, 0), qVarL, iM, objQ, j11, jB2, j12, -9223372036854775807L, i13, 1, j11, eVar);
    }

    @Override // p2.j
    public final boolean g(long j5, f fVar, List list) {
        if (this.f8295h != null) {
            return false;
        }
        return this.f8293e.i(j5, fVar, list);
    }

    @Override // p2.j
    public final void release() {
        for (e eVar : this.f8291c) {
            eVar.f10137u.release();
        }
    }

    @Override // p2.j
    public final void f(f fVar) {
    }
}
