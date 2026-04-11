package d2;

import android.os.Handler;
import h4.z;
import o2.b1;
import o2.y0;
import p1.l0;
import p1.n0;
import p1.q;
import s1.b0;
import s1.u;
import w2.g0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f3756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f3757b = new z(1, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f3.a f3758c = new f3.a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3759d = -9223372036854775807L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f3760e;

    public n(o oVar, s2.e eVar) {
        this.f3760e = oVar;
        this.f3756a = new b1(eVar, null, null);
    }

    @Override // w2.h0
    public final void a(long j5, int i, int i10, int i11, g0 g0Var) {
        long jI;
        long jR;
        this.f3756a.a(j5, i, i10, i11, g0Var);
        while (this.f3756a.x(false)) {
            f3.a aVar = this.f3758c;
            aVar.clear();
            if (this.f3756a.C(this.f3757b, aVar, 0, false) == -4) {
                aVar.flip();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                long j8 = aVar.timeUs;
                l0 l0VarH = this.f3760e.f3763w.h(aVar);
                if (l0VarH != null) {
                    h3.a aVar2 = (h3.a) l0VarH.f9896a[0];
                    String str = aVar2.f5783a;
                    String str2 = aVar2.f5784b;
                    if ("urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2))) {
                        try {
                            jR = b0.R(b0.o(aVar2.f5787e));
                        } catch (n0 unused) {
                            jR = -9223372036854775807L;
                        }
                        if (jR != -9223372036854775807L) {
                            m mVar = new m(j8, jR);
                            Handler handler = this.f3760e.f3764x;
                            handler.sendMessage(handler.obtainMessage(1, mVar));
                        }
                    }
                }
            }
        }
        b1 b1Var = this.f3756a;
        y0 y0Var = b1Var.f9057a;
        synchronized (b1Var) {
            int i12 = b1Var.f9073s;
            jI = i12 == 0 ? -1L : b1Var.i(i12);
        }
        y0Var.b(jI);
    }

    @Override // w2.h0
    public final void b(u uVar, int i, int i10) {
        b1 b1Var = this.f3756a;
        b1Var.getClass();
        b1Var.b(uVar, i, 0);
    }

    @Override // w2.h0
    public final int c(p1.i iVar, int i, boolean z2) {
        return e(iVar, i, z2);
    }

    @Override // w2.h0
    public final void d(q qVar) {
        this.f3756a.d(qVar);
    }

    @Override // w2.h0
    public final int e(p1.i iVar, int i, boolean z2) {
        b1 b1Var = this.f3756a;
        b1Var.getClass();
        return b1Var.e(iVar, i, z2);
    }

    @Override // w2.h0
    public final void f(int i, u uVar) {
        b(uVar, i, 0);
    }
}
