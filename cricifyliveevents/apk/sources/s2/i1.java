package s2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b2.o f11229h;
    public final b2.g i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v1.p f11230j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f9.a0 f11232l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e1 f11234n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v1.g0 f11235o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b2.h0 f11236p;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f11231k = -9223372036854775807L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11233m = true;

    public i1(v1.f0 f0Var, l4.c0 c0Var, f9.a0 a0Var) {
        v1.c0 c0Var2;
        this.i = c0Var;
        this.f11232l = a0Var;
        boolean z10 = true;
        v1.v vVar = new v1.v();
        v1.y yVar = new v1.y();
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        v1.d0 d0Var = v1.d0.f12622d;
        Uri uri = Uri.EMPTY;
        String string = f0Var.f12668a.toString();
        string.getClass();
        ua.i0 i0VarK = ua.i0.k(ua.i0.o(f0Var));
        if (yVar.f13038b != null && yVar.f13037a == null) {
            z10 = false;
        }
        y1.d.g(z10);
        if (uri != null) {
            c0Var2 = new v1.c0(uri, null, yVar.f13037a != null ? new v1.z(yVar) : null, null, list, null, i0VarK, -9223372036854775807L);
        } else {
            c0Var2 = null;
        }
        v1.g0 g0Var = new v1.g0(string, new v1.x(vVar), c0Var2, new v1.a0(tVar), v1.j0.K, d0Var);
        this.f11235o = g0Var;
        v1.o oVar = new v1.o();
        String str = f0Var.f12669b;
        oVar.f12893m = v1.m0.p(str == null ? "text/x-unknown" : str);
        oVar.f12886d = f0Var.f12670c;
        oVar.f12887e = f0Var.f12671d;
        oVar.f = f0Var.f12672e;
        oVar.f12884b = f0Var.f;
        String str2 = f0Var.f12673g;
        oVar.f12883a = str2 != null ? str2 : null;
        this.f11230j = new v1.p(oVar);
        Map map = Collections.EMPTY_MAP;
        Uri uri2 = f0Var.f12668a;
        y1.d.i(uri2, "The uri must be set.");
        this.f11229h = new b2.o(uri2, 0L, 1, null, map, 0L, -1L, null, 1);
        this.f11234n = new e1(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, 0L, 0L, true, false, false, null, g0Var, null);
    }

    @Override // s2.a
    public final a0 c(c0 c0Var, w2.e eVar, long j4) {
        return new h1(this.f11229h, this.i, this.f11236p, this.f11230j, this.f11231k, this.f11232l, b(c0Var), this.f11233m, null);
    }

    @Override // s2.a
    public final v1.g0 i() {
        return this.f11235o;
    }

    @Override // s2.a
    public final void m(b2.h0 h0Var) {
        this.f11236p = h0Var;
        n(this.f11234n);
    }

    @Override // s2.a
    public final void o(a0 a0Var) {
        ((h1) a0Var).D.e(null);
    }

    @Override // s2.a
    public final void k() {
    }

    @Override // s2.a
    public final void q() {
    }
}
