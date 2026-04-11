package j2;

import a3.h0;
import a3.i0;
import android.os.Handler;
import l4.c0;
import s2.w0;
import s2.z0;
import v1.l0;
import v1.n0;
import v1.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f6577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f6578b = new c0(22, false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j3.a f6579c = new j3.a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6580d = -9223372036854775807L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f6581e;

    public n(o oVar, w2.e eVar) {
        this.f6581e = oVar;
        this.f6577a = new z0(eVar, null, null);
    }

    @Override // a3.i0
    public final void a(int i, t tVar) {
        c(tVar, i, 0);
    }

    @Override // a3.i0
    public final int b(v1.h hVar, int i, boolean z10) {
        return d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void c(t tVar, int i, int i10) {
        z0 z0Var = this.f6577a;
        z0Var.getClass();
        z0Var.c(tVar, i, 0);
    }

    @Override // a3.i0
    public final int d(v1.h hVar, int i, boolean z10) {
        z0 z0Var = this.f6577a;
        z0Var.getClass();
        return z0Var.d(hVar, i, z10);
    }

    @Override // a3.i0
    public final void e(long j4, int i, int i10, int i11, h0 h0Var) {
        long jI;
        long jR;
        this.f6577a.e(j4, i, i10, i11, h0Var);
        while (this.f6577a.x(false)) {
            j3.a aVar = this.f6579c;
            aVar.clear();
            if (this.f6577a.C(this.f6578b, aVar, 0, false) == -4) {
                aVar.flip();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                long j7 = aVar.timeUs;
                l0 l0VarO = this.f6581e.f6584x.o(aVar);
                if (l0VarO != null) {
                    l3.a aVar2 = (l3.a) l0VarO.f12828a[0];
                    String str = aVar2.f7692a;
                    String str2 = aVar2.f7693b;
                    if ("urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2))) {
                        try {
                            jR = a0.R(a0.o(aVar2.f7696e));
                        } catch (n0 unused) {
                            jR = -9223372036854775807L;
                        }
                        if (jR != -9223372036854775807L) {
                            m mVar = new m(j7, jR);
                            Handler handler = this.f6581e.f6585y;
                            handler.sendMessage(handler.obtainMessage(1, mVar));
                        }
                    }
                }
            }
        }
        z0 z0Var = this.f6577a;
        w0 w0Var = z0Var.f11373a;
        synchronized (z0Var) {
            int i12 = z0Var.f11389s;
            jI = i12 == 0 ? -1L : z0Var.i(i12);
        }
        w0Var.b(jI);
    }

    @Override // a3.i0
    public final void f(p pVar) {
        this.f6577a.f(pVar);
    }
}
