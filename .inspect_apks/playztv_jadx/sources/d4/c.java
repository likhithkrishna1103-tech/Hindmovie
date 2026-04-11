package d4;

import aa.c1;
import aa.j0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements w2.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3795a = new b(0, 1, null, "audio/ac4");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f3796b = new s1.u(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3797c;

    @Override // w2.o
    public final void c(w2.q qVar) {
        this.f3795a.g(qVar, new h0(0, 1));
        qVar.e();
        qVar.j(new w2.t(-9223372036854775807L));
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) throws EOFException, InterruptedIOException {
        w2.l lVar;
        int i;
        s1.u uVar = new s1.u(10);
        int i10 = 0;
        while (true) {
            lVar = (w2.l) pVar;
            lVar.r(uVar.f11709a, 0, 10, false);
            uVar.J(0);
            if (uVar.A() != 4801587) {
                break;
            }
            uVar.K(3);
            int iW = uVar.w();
            i10 += iW + 10;
            lVar.b(iW, false);
        }
        lVar.f13655z = 0;
        lVar.b(i10, false);
        int i11 = 0;
        int i12 = i10;
        while (true) {
            int i13 = 7;
            lVar.r(uVar.f11709a, 0, 7, false);
            uVar.J(0);
            int iD = uVar.D();
            if (iD == 44096 || iD == 44097) {
                i11++;
                if (i11 >= 4) {
                    return true;
                }
                byte[] bArr = uVar.f11709a;
                if (bArr.length < 7) {
                    i = -1;
                } else {
                    int i14 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
                    if (i14 == 65535) {
                        i14 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                    } else {
                        i13 = 4;
                    }
                    if (iD == 44097) {
                        i13 += 2;
                    }
                    i = i14 + i13;
                }
                if (i == -1) {
                    break;
                }
                lVar.b(i - 7, false);
            } else {
                lVar.f13655z = 0;
                i12++;
                if (i12 - i10 >= 8192) {
                    break;
                }
                lVar.b(i12, false);
                i11 = 0;
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f3797c = false;
        this.f3795a.a();
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) {
        s1.u uVar = this.f3796b;
        int i = pVar.read(uVar.f11709a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        uVar.J(0);
        uVar.I(i);
        boolean z2 = this.f3797c;
        b bVar = this.f3795a;
        if (!z2) {
            bVar.f3794o = 0L;
            this.f3797c = true;
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
