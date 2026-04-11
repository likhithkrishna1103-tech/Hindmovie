package v3;

import a3.p;
import a3.q;
import a3.r;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import v1.n0;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f13141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f13142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13143c;

    public final boolean b(q qVar) {
        boolean zX;
        f fVar = new f();
        if (fVar.a(qVar, true) && (fVar.f13149a & 2) == 2) {
            int iMin = Math.min(fVar.f13153e, 8);
            t tVar = new t(iMin);
            qVar.z(tVar.f14609a, 0, iMin);
            tVar.J(0);
            if (tVar.a() >= 5 && tVar.x() == 127 && tVar.z() == 1179402563) {
                this.f13142b = new c();
                return true;
            }
            tVar.J(0);
            try {
                zX = a3.b.x(1, tVar, true);
            } catch (n0 unused) {
                zX = false;
            }
            if (zX) {
                this.f13142b = new j();
            } else {
                tVar.J(0);
                if (h.e(tVar, h.f13155o)) {
                    this.f13142b = new h();
                }
            }
            return true;
        }
        return false;
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f13141a = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        i iVar = this.f13142b;
        if (iVar != null) {
            e eVar = iVar.f13158a;
            f fVar = eVar.f13144a;
            fVar.f13149a = 0;
            fVar.f13150b = 0L;
            fVar.f13151c = 0;
            fVar.f13152d = 0;
            fVar.f13153e = 0;
            eVar.f13145b.G(0);
            eVar.f13146c = -1;
            eVar.f13148e = false;
            if (j4 == 0) {
                iVar.d(!iVar.f13167l);
                return;
            }
            if (iVar.f13164h != 0) {
                long j10 = (((long) iVar.i) * j7) / 1000000;
                iVar.f13162e = j10;
                g gVar = iVar.f13161d;
                int i = a0.f14551a;
                gVar.d(j10);
                iVar.f13164h = 2;
            }
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        try {
            return b(qVar);
        } catch (n0 unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0176  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r21, a3.t r22) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.d.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
