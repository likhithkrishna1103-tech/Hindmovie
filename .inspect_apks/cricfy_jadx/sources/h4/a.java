package h4;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements a3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5539a = new b("audio/ac3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.t f5540b = new y1.t(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5541c;

    @Override // a3.p
    public final void c(a3.r rVar) {
        this.f5539a.e(rVar, new g0(0, 1));
        rVar.e();
        rVar.s(new a3.u(-9223372036854775807L));
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f5541c = false;
        this.f5539a.a();
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) throws EOFException, InterruptedIOException {
        a3.l lVar;
        int iF;
        y1.t tVar = new y1.t(10);
        int i = 0;
        while (true) {
            lVar = (a3.l) qVar;
            lVar.v(tVar.f14609a, 0, 10, false);
            tVar.J(0);
            if (tVar.A() != 4801587) {
                break;
            }
            tVar.K(3);
            int iW = tVar.w();
            i += iW + 10;
            lVar.b(iW, false);
        }
        lVar.A = 0;
        lVar.b(i, false);
        int i10 = 0;
        int i11 = i;
        while (true) {
            lVar.v(tVar.f14609a, 0, 6, false);
            tVar.J(0);
            if (tVar.D() != 2935) {
                lVar.A = 0;
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
                byte[] bArr = tVar.f14609a;
                if (bArr.length < 6) {
                    iF = -1;
                } else if (((bArr[5] & 248) >> 3) > 10) {
                    iF = ((((bArr[2] & 7) << 8) | (bArr[3] & 255)) + 1) * 2;
                } else {
                    byte b8 = bArr[4];
                    iF = a3.b.f((b8 & 192) >> 6, b8 & 63);
                }
                if (iF == -1) {
                    break;
                }
                lVar.b(iF - 6, false);
            }
        }
        return false;
    }

    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) {
        y1.t tVar2 = this.f5540b;
        int i = qVar.read(tVar2.f14609a, 0, 2786);
        if (i == -1) {
            return -1;
        }
        tVar2.J(0);
        tVar2.I(i);
        boolean z10 = this.f5541c;
        b bVar = this.f5539a;
        if (!z10) {
            bVar.f5563o = 0L;
            this.f5541c = true;
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
