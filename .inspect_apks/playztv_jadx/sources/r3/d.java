package r3;

import aa.c1;
import aa.h0;
import aa.j0;
import java.util.List;
import p1.n0;
import s1.b0;
import s1.u;
import w2.o;
import w2.p;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f11371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f11372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11373c;

    public final boolean b(p pVar) {
        boolean zY;
        f fVar = new f();
        if (fVar.a(pVar, true) && (fVar.f11379a & 2) == 2) {
            int iMin = Math.min(fVar.f11383e, 8);
            u uVar = new u(iMin);
            pVar.w(uVar.f11709a, 0, iMin);
            uVar.J(0);
            if (uVar.a() >= 5 && uVar.x() == 127 && uVar.z() == 1179402563) {
                this.f11372b = new c();
                return true;
            }
            uVar.J(0);
            try {
                zY = w2.b.y(1, uVar, true);
            } catch (n0 unused) {
                zY = false;
            }
            if (zY) {
                this.f11372b = new j();
            } else {
                uVar.J(0);
                if (h.e(uVar, h.f11385o)) {
                    this.f11372b = new h();
                }
            }
            return true;
        }
        return false;
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f11371a = qVar;
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        try {
            return b(pVar);
        } catch (n0 unused) {
            return false;
        }
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        i iVar = this.f11372b;
        if (iVar != null) {
            e eVar = iVar.f11388a;
            f fVar = eVar.f11374a;
            fVar.f11379a = 0;
            fVar.f11380b = 0L;
            fVar.f11381c = 0;
            fVar.f11382d = 0;
            fVar.f11383e = 0;
            eVar.f11375b.G(0);
            eVar.f11376c = -1;
            eVar.f11378e = false;
            if (j5 == 0) {
                iVar.d(!iVar.f11397l);
                return;
            }
            if (iVar.f11394h != 0) {
                long j10 = (((long) iVar.i) * j8) / 1000000;
                iVar.f11392e = j10;
                g gVar = iVar.f11391d;
                int i = b0.f11647a;
                gVar.f(j10);
                iVar.f11394h = 2;
            }
        }
    }

    @Override // w2.o
    public final List g() {
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0176  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r21, w2.s r22) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.d.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
