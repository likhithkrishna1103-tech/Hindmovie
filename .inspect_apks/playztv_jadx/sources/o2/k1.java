package o2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k1 extends a {
    public final v1.m B;
    public final v1.g C;
    public final p1.q D;
    public final k8.a0 F;
    public final g1 H;
    public final p1.g0 I;
    public v1.e0 J;
    public final long E = -9223372036854775807L;
    public final boolean G = true;

    public k1(p1.f0 f0Var, pb.c cVar, k8.a0 a0Var) {
        e2.t tVar;
        p1.c0 c0Var;
        this.C = cVar;
        this.F = a0Var;
        boolean z2 = true;
        p1.w wVar = new p1.w();
        p1.z zVar = new p1.z();
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var = aa.c1.f650y;
        e2.t tVar2 = new e2.t();
        p1.d0 d0Var = p1.d0.f9694d;
        Uri uri = Uri.EMPTY;
        String string = f0Var.f9735a.toString();
        string.getClass();
        aa.j0 j0VarR = aa.j0.r(aa.j0.v(f0Var));
        if (zVar.f10114b != null && zVar.f10113a == null) {
            z2 = false;
        }
        s1.d.g(z2);
        if (uri != null) {
            p1.a0 a0Var2 = zVar.f10113a != null ? new p1.a0(zVar) : null;
            tVar = tVar2;
            c0Var = new p1.c0(uri, null, a0Var2, null, list, null, j0VarR, -9223372036854775807L);
        } else {
            tVar = tVar2;
            c0Var = null;
        }
        p1.g0 g0Var = new p1.g0(string, new p1.y(wVar), c0Var, new p1.b0(tVar), p1.j0.K, d0Var);
        this.I = g0Var;
        p1.p pVar = new p1.p();
        pVar.f9967m = p1.m0.p((String) ga.b.m(f0Var.f9736b, "text/x-unknown"));
        pVar.f9960d = f0Var.f9737c;
        pVar.f9961e = f0Var.f9738d;
        pVar.f = f0Var.f9739e;
        pVar.f9958b = f0Var.f;
        String str = f0Var.f9740g;
        pVar.f9957a = str != null ? str : null;
        this.D = new p1.q(pVar);
        Map map = Collections.EMPTY_MAP;
        Uri uri2 = f0Var.f9735a;
        s1.d.i(uri2, "The uri must be set.");
        this.B = new v1.m(uri2, 0L, 1, null, map, 0L, -1L, null, 1);
        this.H = new g1(-9223372036854775807L, true, false, g0Var);
    }

    @Override // o2.a
    public final b0 c(d0 d0Var, s2.e eVar, long j5) {
        return new j1(this.B, this.C, this.J, this.D, this.E, this.F, b(d0Var), this.G, null);
    }

    @Override // o2.a
    public final p1.g0 j() {
        return this.I;
    }

    @Override // o2.a
    public final void p(v1.e0 e0Var) {
        this.J = e0Var;
        q(this.H);
    }

    @Override // o2.a
    public final void r(b0 b0Var) {
        ((j1) b0Var).C.e(null);
    }

    @Override // o2.a
    public final void n() {
    }

    @Override // o2.a
    public final void t() {
    }
}
