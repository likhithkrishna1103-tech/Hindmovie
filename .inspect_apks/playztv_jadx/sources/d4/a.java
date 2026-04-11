package d4;

import aa.c1;
import aa.j0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements w2.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3770a = new b("audio/ac3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f3771b = new s1.u(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3772c;

    @Override // w2.o
    public final void c(w2.q qVar) {
        this.f3770a.g(qVar, new h0(0, 1));
        qVar.e();
        qVar.j(new w2.t(-9223372036854775807L));
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) throws EOFException, InterruptedIOException {
        w2.l lVar;
        int iG;
        s1.u uVar = new s1.u(10);
        int i = 0;
        while (true) {
            lVar = (w2.l) pVar;
            lVar.r(uVar.f11709a, 0, 10, false);
            uVar.J(0);
            if (uVar.A() != 4801587) {
                break;
            }
            uVar.K(3);
            int iW = uVar.w();
            i += iW + 10;
            lVar.b(iW, false);
        }
        lVar.f13655z = 0;
        lVar.b(i, false);
        int i10 = 0;
        int i11 = i;
        while (true) {
            lVar.r(uVar.f11709a, 0, 6, false);
            uVar.J(0);
            if (uVar.D() != 2935) {
                lVar.f13655z = 0;
                i11++;
                if (i11 - i >= 8192) {
                    break;
                }
                lVar.b(i11, false);
                i10 = 0;
            } else {
                i10++;
                if (i10 >= 4) {
                    return true;
                }
                byte[] bArr = uVar.f11709a;
                if (bArr.length < 6) {
                    iG = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    iG = ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2;
                } else {
                    byte b10 = bArr[4];
                    iG = w2.b.g((b10 & 192) >> 6, b10 & 63);
                }
                if (iG == -1) {
                    break;
                }
                lVar.b(iG - 6, false);
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f3772c = false;
        this.f3770a.a();
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) {
        s1.u uVar = this.f3771b;
        int i = pVar.read(uVar.f11709a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        uVar.J(0);
        uVar.I(i);
        boolean z2 = this.f3772c;
        b bVar = this.f3770a;
        if (!z2) {
            bVar.f3794o = 0L;
            this.f3772c = true;
        }
        bVar.d(uVar);
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
