package ye;

import bf.c0;
import java.io.IOException;
import k8.t0;
import n.p;
import ue.a0;
import va.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0 f14706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ue.a f14707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f14708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f14709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f14710e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14712h;
    public a0 i;

    public d(t0 t0Var, ue.a aVar, h hVar) {
        be.h.e(t0Var, "connectionPool");
        this.f14706a = t0Var;
        this.f14707b = aVar;
        this.f14708c = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ye.k a(int r12, int r13, int r14, boolean r15, boolean r16) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.d.a(int, int, int, boolean, boolean):ye.k");
    }

    public final boolean b(ue.o oVar) {
        be.h.e(oVar, "url");
        ue.o oVar2 = this.f14707b.f12929h;
        return oVar.f13012e == oVar2.f13012e && be.h.a(oVar.f13011d, oVar2.f13011d);
    }

    public final void c(IOException iOException) {
        be.h.e(iOException, "e");
        this.i = null;
        if ((iOException instanceof c0) && ((c0) iOException).f2063u == 8) {
            this.f++;
        } else if (iOException instanceof bf.a) {
            this.f14711g++;
        } else {
            this.f14712h++;
        }
    }
}
