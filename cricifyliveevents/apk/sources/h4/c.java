package h4;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements a3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5564a = new b(0, 1, null, "audio/ac4");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.t f5565b = new y1.t(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5566c;

    @Override // a3.p
    public final void c(a3.r rVar) {
        this.f5564a.e(rVar, new g0(0, 1));
        rVar.e();
        rVar.s(new a3.u(-9223372036854775807L));
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f5566c = false;
        this.f5564a.a();
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) throws EOFException, InterruptedIOException {
        a3.l lVar;
        int i;
        y1.t tVar = new y1.t(10);
        int i10 = 0;
        while (true) {
            lVar = (a3.l) qVar;
            lVar.v(tVar.f14609a, 0, 10, false);
            tVar.J(0);
            if (tVar.A() != 4801587) {
                break;
            }
            tVar.K(3);
            int iW = tVar.w();
            i10 += iW + 10;
            lVar.b(iW, false);
        }
        lVar.A = 0;
        lVar.b(i10, false);
        int i11 = 0;
        int i12 = i10;
        while (true) {
            int i13 = 7;
            lVar.v(tVar.f14609a, 0, 7, false);
            tVar.J(0);
            int iD = tVar.D();
            if (iD == 44096 || iD == 44097) {
                i11++;
                if (i11 >= 4) {
                    return true;
                }
                byte[] bArr = tVar.f14609a;
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
                lVar.A = 0;
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

    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) {
        y1.t tVar2 = this.f5565b;
        int i = qVar.read(tVar2.f14609a, 0, 16384);
        if (i == -1) {
            return -1;
        }
        tVar2.J(0);
        tVar2.I(i);
        boolean z10 = this.f5566c;
        b bVar = this.f5564a;
        if (!z10) {
            bVar.f5563o = 0L;
            this.f5566c = true;
        }
        bVar.b(tVar2);
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
