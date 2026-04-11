package h4;

import a3.k0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.i0;
import ua.z0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a3.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k0 f5575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a3.r f5576e;
    public long f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5578h;
    public boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5572a = new e(0, null, "audio/mp4a-latm", true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.t f5573b = new y1.t(2048);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5577g = -1;

    public d(int i) {
        y1.t tVar = new y1.t(10);
        this.f5574c = tVar;
        byte[] bArr = tVar.f14609a;
        this.f5575d = new k0(bArr.length, bArr);
    }

    @Override // a3.p
    public final void c(a3.r rVar) {
        this.f5576e = rVar;
        this.f5572a.e(rVar, new g0(0, 1));
        rVar.e();
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f5578h = false;
        this.f5572a.a();
        this.f = j7;
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) throws EOFException, InterruptedIOException {
        int i = 0;
        while (true) {
            y1.t tVar = this.f5574c;
            qVar.z(tVar.f14609a, 0, 10);
            tVar.J(0);
            if (tVar.A() != 4801587) {
                break;
            }
            tVar.K(3);
            int iW = tVar.w();
            i += iW + 10;
            qVar.A(iW);
        }
        qVar.k();
        qVar.A(i);
        if (this.f5577g == -1) {
            this.f5577g = i;
        }
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        do {
            y1.t tVar2 = this.f5574c;
            a3.l lVar = (a3.l) qVar;
            lVar.v(tVar2.f14609a, 0, 2, false);
            tVar2.J(0);
            if ((tVar2.D() & 65526) == 65520) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                lVar.v(tVar2.f14609a, 0, 4, false);
                k0 k0Var = this.f5575d;
                k0Var.q(14);
                int i13 = k0Var.i(13);
                if (i13 <= 6) {
                    i10++;
                    lVar.A = 0;
                    lVar.b(i10, false);
                } else {
                    lVar.b(i13 - 6, false);
                    i12 += i13;
                }
            } else {
                i10++;
                lVar.A = 0;
                lVar.b(i10, false);
            }
            i11 = 0;
            i12 = 0;
        } while (i10 - i < 8192);
        return false;
    }

    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) throws n0 {
        y1.d.h(this.f5576e);
        qVar.getLength();
        y1.t tVar2 = this.f5573b;
        int i = qVar.read(tVar2.f14609a, 0, 2048);
        boolean z10 = i == -1;
        if (!this.i) {
            this.f5576e.s(new a3.u(-9223372036854775807L));
            this.i = true;
        }
        if (z10) {
            return -1;
        }
        tVar2.J(0);
        tVar2.I(i);
        boolean z11 = this.f5578h;
        e eVar = this.f5572a;
        if (!z11) {
            eVar.f5602u = this.f;
            this.f5578h = true;
        }
        eVar.b(tVar2);
        return 0;
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
