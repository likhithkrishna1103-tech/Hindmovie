package d4;

import aa.c1;
import aa.j0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements w2.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f3805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.t f3806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w2.q f3807e;
    public long f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3809h;
    public boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3803a = new e(0, null, "audio/mp4a-latm", true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f3804b = new s1.u(2048);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3808g = -1;

    public d(int i) {
        s1.u uVar = new s1.u(10);
        this.f3805c = uVar;
        byte[] bArr = uVar.f11709a;
        this.f3806d = new s1.t(bArr.length, bArr);
    }

    @Override // w2.o
    public final void c(w2.q qVar) {
        this.f3807e = qVar;
        this.f3803a.g(qVar, new h0(0, 1));
        qVar.e();
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) throws EOFException, InterruptedIOException {
        int i = 0;
        while (true) {
            s1.u uVar = this.f3805c;
            pVar.w(uVar.f11709a, 0, 10);
            uVar.J(0);
            if (uVar.A() != 4801587) {
                break;
            }
            uVar.K(3);
            int iW = uVar.w();
            i += iW + 10;
            pVar.B(iW);
        }
        pVar.l();
        pVar.B(i);
        if (this.f3808g == -1) {
            this.f3808g = i;
        }
        int i10 = i;
        int i11 = 0;
        int i12 = 0;
        do {
            s1.u uVar2 = this.f3805c;
            w2.l lVar = (w2.l) pVar;
            lVar.r(uVar2.f11709a, 0, 2, false);
            uVar2.J(0);
            if ((uVar2.D() & 65526) == 65520) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                lVar.r(uVar2.f11709a, 0, 4, false);
                s1.t tVar = this.f3806d;
                tVar.q(14);
                int i13 = tVar.i(13);
                if (i13 <= 6) {
                    i10++;
                    lVar.f13655z = 0;
                    lVar.b(i10, false);
                } else {
                    lVar.b(i13 - 6, false);
                    i12 += i13;
                }
            } else {
                i10++;
                lVar.f13655z = 0;
                lVar.b(i10, false);
            }
            i11 = 0;
            i12 = 0;
        } while (i10 - i < 8192);
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f3809h = false;
        this.f3803a.a();
        this.f = j8;
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) throws n0 {
        s1.d.h(this.f3807e);
        pVar.getLength();
        s1.u uVar = this.f3804b;
        int i = pVar.read(uVar.f11709a, 0, 2048);
        boolean z2 = i == -1;
        if (!this.i) {
            this.f3807e.j(new w2.t(-9223372036854775807L));
            this.i = true;
        }
        if (z2) {
            return -1;
        }
        uVar.J(0);
        uVar.I(i);
        boolean z10 = this.f3809h;
        e eVar = this.f3803a;
        if (!z10) {
            eVar.f3833u = this.f;
            this.f3809h = true;
        }
        eVar.d(uVar);
        return 0;
    }

    @Override // w2.o
    public final w2.o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
