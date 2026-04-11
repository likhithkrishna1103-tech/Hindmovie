package h4;

import a3.k0;
import android.util.SparseArray;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements a3.p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5546e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5548h;
    public f3.b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a3.r f5549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5550k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1.y f5542a = new y1.y(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5544c = new y1.t(4096);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f5543b = new SparseArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f5545d = new y(0);

    @Override // a3.p
    public final void c(a3.r rVar) {
        this.f5549j = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        y1.y yVar = this.f5542a;
        boolean z10 = yVar.e() == -9223372036854775807L;
        if (!z10) {
            long jD = yVar.d();
            z10 = (jD == -9223372036854775807L || jD == 0 || jD == j7) ? false : true;
        }
        if (z10) {
            yVar.g(j7);
        }
        f3.b bVar = this.i;
        if (bVar != null) {
            bVar.d(j7);
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f5543b;
            if (i >= sparseArray.size()) {
                return;
            }
            z zVar = (z) sparseArray.valueAt(i);
            zVar.f = false;
            zVar.f5834a.a();
            i++;
        }
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(a3.q qVar) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        a3.l lVar = (a3.l) qVar;
        lVar.v(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            lVar.b(bArr[13] & 7, false);
            lVar.v(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) {
        int i;
        int i10;
        long j4;
        i kVar;
        long j7;
        y1.d.h(this.f5549j);
        long length = qVar.getLength();
        int i11 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j10 = -9223372036854775807L;
        y yVar = this.f5545d;
        if (i11 != 0 && !yVar.f5830d) {
            y1.y yVar2 = yVar.f5828b;
            y1.t tVar2 = yVar.f5829c;
            if (!yVar.f) {
                long length2 = qVar.getLength();
                int iMin = (int) Math.min(20000L, length2);
                long j11 = length2 - ((long) iMin);
                if (qVar.getPosition() != j11) {
                    tVar.f227a = j11;
                    return 1;
                }
                tVar2.G(iMin);
                qVar.k();
                qVar.z(tVar2.f14609a, 0, iMin);
                int i12 = tVar2.f14610b;
                int i13 = tVar2.f14611c - 4;
                while (true) {
                    if (i13 < i12) {
                        break;
                    }
                    if (y.b(i13, tVar2.f14609a) == 442) {
                        tVar2.J(i13 + 4);
                        long jC = y.c(tVar2);
                        if (jC != -9223372036854775807L) {
                            j10 = jC;
                            break;
                        }
                    }
                    i13--;
                }
                yVar.f5833h = j10;
                yVar.f = true;
                return 0;
            }
            if (yVar.f5833h == -9223372036854775807L) {
                yVar.a(qVar);
                return 0;
            }
            if (yVar.f5831e) {
                long j12 = yVar.f5832g;
                if (j12 == -9223372036854775807L) {
                    yVar.a(qVar);
                    return 0;
                }
                yVar.i = yVar2.c(yVar.f5833h) - yVar2.b(j12);
                yVar.a(qVar);
                return 0;
            }
            int iMin2 = (int) Math.min(20000L, qVar.getLength());
            long j13 = 0;
            if (qVar.getPosition() != j13) {
                tVar.f227a = j13;
                return 1;
            }
            tVar2.G(iMin2);
            qVar.k();
            qVar.z(tVar2.f14609a, 0, iMin2);
            int i14 = tVar2.f14610b;
            int i15 = tVar2.f14611c;
            while (true) {
                if (i14 >= i15 - 3) {
                    j7 = -9223372036854775807L;
                    break;
                }
                if (y.b(i14, tVar2.f14609a) == 442) {
                    tVar2.J(i14 + 4);
                    long jC2 = y.c(tVar2);
                    if (jC2 != -9223372036854775807L) {
                        j7 = jC2;
                        break;
                    }
                }
                i14++;
            }
            yVar.f5832g = j7;
            yVar.f5831e = true;
            return 0;
        }
        if (this.f5550k) {
            i = i11;
            i10 = 4;
        } else {
            this.f5550k = true;
            long j14 = yVar.i;
            if (j14 != -9223372036854775807L) {
                i = i11;
                i10 = 4;
                f3.b bVar = new f3.b(new fc.e(1), new l4.c0(yVar.f5828b), j14, j14 + 1, 0L, length, 188L, 1000);
                this.i = bVar;
                this.f5549j.s(bVar.f3938a);
            } else {
                i = i11;
                i10 = 4;
                this.f5549j.s(new a3.u(j14));
            }
        }
        f3.b bVar2 = this.i;
        if (bVar2 != null && bVar2.f3940c != null) {
            return bVar2.b(qVar, tVar);
        }
        qVar.k();
        long jX = i != 0 ? length - qVar.x() : -1L;
        if (jX != -1 && jX < 4) {
            return -1;
        }
        y1.t tVar3 = this.f5544c;
        if (!qVar.v(tVar3.f14609a, 0, i10, true)) {
            return -1;
        }
        tVar3.J(0);
        int iJ = tVar3.j();
        if (iJ == 441) {
            return -1;
        }
        if (iJ == 442) {
            qVar.z(tVar3.f14609a, 0, 10);
            tVar3.J(9);
            qVar.n((tVar3.x() & 7) + 14);
            return 0;
        }
        if (iJ == 443) {
            qVar.z(tVar3.f14609a, 0, 2);
            tVar3.J(0);
            qVar.n(tVar3.D() + 6);
            return 0;
        }
        if (((iJ & (-256)) >> 8) != 1) {
            qVar.n(1);
            return 0;
        }
        int i16 = iJ & 255;
        SparseArray sparseArray = this.f5543b;
        z zVar = (z) sparseArray.get(i16);
        if (!this.f5546e) {
            if (zVar == null) {
                if (i16 == 189) {
                    kVar = new b("video/mp2p");
                    this.f = true;
                    this.f5548h = qVar.getPosition();
                } else if ((iJ & 224) == 192) {
                    kVar = new u(0, null, "video/mp2p");
                    this.f = true;
                    this.f5548h = qVar.getPosition();
                } else if ((iJ & 240) == 224) {
                    kVar = new k(null, "video/mp2p");
                    this.f5547g = true;
                    this.f5548h = qVar.getPosition();
                } else {
                    kVar = null;
                }
                if (kVar != null) {
                    kVar.e(this.f5549j, new g0(i16, 256));
                    zVar = new z(kVar, this.f5542a);
                    sparseArray.put(i16, zVar);
                }
            }
            if (qVar.getPosition() > ((this.f && this.f5547g) ? this.f5548h + 8192 : 1048576L)) {
                this.f5546e = true;
                this.f5549j.e();
            }
        }
        qVar.z(tVar3.f14609a, 0, 2);
        tVar3.J(0);
        int iD = tVar3.D() + 6;
        if (zVar == null) {
            qVar.n(iD);
            return 0;
        }
        tVar3.G(iD);
        qVar.readFully(tVar3.f14609a, 0, iD);
        tVar3.J(6);
        i iVar = zVar.f5834a;
        k0 k0Var = zVar.f5836c;
        tVar3.h(k0Var.f208b, 0, 3);
        k0Var.q(0);
        k0Var.t(8);
        zVar.f5837d = k0Var.h();
        zVar.f5838e = k0Var.h();
        k0Var.t(6);
        tVar3.h(k0Var.f208b, 0, k0Var.i(8));
        k0Var.q(0);
        y1.y yVar3 = zVar.f5835b;
        zVar.f5839g = 0L;
        if (zVar.f5837d) {
            k0Var.t(4);
            long jI = ((long) k0Var.i(3)) << 30;
            k0Var.t(1);
            long jI2 = jI | ((long) (k0Var.i(15) << 15));
            k0Var.t(1);
            long jI3 = jI2 | ((long) k0Var.i(15));
            k0Var.t(1);
            if (zVar.f || !zVar.f5838e) {
                j4 = jI3;
            } else {
                k0Var.t(4);
                long jI4 = ((long) k0Var.i(3)) << 30;
                k0Var.t(1);
                long jI5 = ((long) (k0Var.i(15) << 15)) | jI4;
                k0Var.t(1);
                long jI6 = jI5 | ((long) k0Var.i(15));
                k0Var.t(1);
                yVar3.b(jI6);
                zVar.f = true;
                j4 = jI3;
            }
            zVar.f5839g = yVar3.b(j4);
        }
        iVar.d(4, zVar.f5839g);
        iVar.b(tVar3);
        iVar.c(false);
        tVar3.I(tVar3.f14609a.length);
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
