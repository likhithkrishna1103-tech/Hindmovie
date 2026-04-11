package d4;

import aa.c1;
import aa.j0;
import android.util.SparseArray;
import com.google.android.gms.internal.measurement.k4;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements w2.o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3777e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3779h;
    public b3.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w2.q f3780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3781k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1.z f3773a = new s1.z(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f3775c = new s1.u(4096);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f3774b = new SparseArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f3776d = new y(0);

    @Override // w2.o
    public final void c(w2.q qVar) {
        this.f3780j = qVar;
    }

    @Override // w2.o
    public final boolean e(w2.p pVar) throws EOFException, InterruptedIOException {
        byte[] bArr = new byte[14];
        w2.l lVar = (w2.l) pVar;
        lVar.r(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            lVar.b(bArr[13] & 7, false);
            lVar.r(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        s1.z zVar = this.f3773a;
        boolean z2 = zVar.e() == -9223372036854775807L;
        if (!z2) {
            long jD = zVar.d();
            z2 = (jD == -9223372036854775807L || jD == 0 || jD == j8) ? false : true;
        }
        if (z2) {
            zVar.g(j8);
        }
        b3.a aVar = this.i;
        if (aVar != null) {
            aVar.d(j8);
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f3774b;
            if (i >= sparseArray.size()) {
                return;
            }
            z zVar2 = (z) sparseArray.valueAt(i);
            zVar2.f = false;
            zVar2.f4071a.a();
            i++;
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) {
        int i;
        int i10;
        long j5;
        i kVar;
        long j8;
        s1.d.h(this.f3780j);
        long length = pVar.getLength();
        int i11 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j10 = -9223372036854775807L;
        y yVar = this.f3776d;
        if (i11 != 0 && !yVar.f4067d) {
            s1.z zVar = yVar.f4065b;
            s1.u uVar = yVar.f4066c;
            if (!yVar.f) {
                long length2 = pVar.getLength();
                int iMin = (int) Math.min(20000L, length2);
                long j11 = length2 - ((long) iMin);
                if (pVar.getPosition() != j11) {
                    sVar.f13664a = j11;
                    return 1;
                }
                uVar.G(iMin);
                pVar.l();
                pVar.w(uVar.f11709a, 0, iMin);
                int i12 = uVar.f11710b;
                int i13 = uVar.f11711c - 4;
                while (true) {
                    if (i13 < i12) {
                        break;
                    }
                    if (y.b(i13, uVar.f11709a) == 442) {
                        uVar.J(i13 + 4);
                        long jC = y.c(uVar);
                        if (jC != -9223372036854775807L) {
                            j10 = jC;
                            break;
                        }
                    }
                    i13--;
                }
                yVar.f4070h = j10;
                yVar.f = true;
                return 0;
            }
            if (yVar.f4070h == -9223372036854775807L) {
                yVar.a(pVar);
                return 0;
            }
            if (yVar.f4068e) {
                long j12 = yVar.f4069g;
                if (j12 == -9223372036854775807L) {
                    yVar.a(pVar);
                    return 0;
                }
                yVar.i = zVar.c(yVar.f4070h) - zVar.b(j12);
                yVar.a(pVar);
                return 0;
            }
            int iMin2 = (int) Math.min(20000L, pVar.getLength());
            long j13 = 0;
            if (pVar.getPosition() != j13) {
                sVar.f13664a = j13;
                return 1;
            }
            uVar.G(iMin2);
            pVar.l();
            pVar.w(uVar.f11709a, 0, iMin2);
            int i14 = uVar.f11710b;
            int i15 = uVar.f11711c;
            while (true) {
                if (i14 >= i15 - 3) {
                    j8 = -9223372036854775807L;
                    break;
                }
                if (y.b(i14, uVar.f11709a) == 442) {
                    uVar.J(i14 + 4);
                    long jC2 = y.c(uVar);
                    if (jC2 != -9223372036854775807L) {
                        j8 = jC2;
                        break;
                    }
                }
                i14++;
            }
            yVar.f4069g = j8;
            yVar.f4068e = true;
            return 0;
        }
        if (this.f3781k) {
            i = i11;
            i10 = 4;
        } else {
            this.f3781k = true;
            long j14 = yVar.i;
            if (j14 != -9223372036854775807L) {
                s1.z zVar2 = yVar.f4065b;
                w2.f fVar = new w2.f();
                k4 k4Var = new k4();
                k4Var.f3070u = zVar2;
                k4Var.f3071v = new s1.u();
                i = i11;
                i10 = 4;
                b3.a aVar = new b3.a(fVar, k4Var, j14, j14 + 1, 0L, length, 188L, 1000);
                this.i = aVar;
                this.f3780j.j(aVar.f1790a);
            } else {
                i = i11;
                i10 = 4;
                this.f3780j.j(new w2.t(j14));
            }
        }
        b3.a aVar2 = this.i;
        if (aVar2 != null && aVar2.f1792c != null) {
            return aVar2.b(pVar, sVar);
        }
        pVar.l();
        long jS = i != 0 ? length - pVar.s() : -1L;
        if (jS != -1 && jS < 4) {
            return -1;
        }
        s1.u uVar2 = this.f3775c;
        if (!pVar.r(uVar2.f11709a, 0, i10, true)) {
            return -1;
        }
        uVar2.J(0);
        int iJ = uVar2.j();
        if (iJ == 441) {
            return -1;
        }
        if (iJ == 442) {
            pVar.w(uVar2.f11709a, 0, 10);
            uVar2.J(9);
            pVar.m((uVar2.x() & 7) + 14);
            return 0;
        }
        if (iJ == 443) {
            pVar.w(uVar2.f11709a, 0, 2);
            uVar2.J(0);
            pVar.m(uVar2.D() + 6);
            return 0;
        }
        if (((iJ & (-256)) >> 8) != 1) {
            pVar.m(1);
            return 0;
        }
        int i16 = iJ & 255;
        SparseArray sparseArray = this.f3774b;
        z zVar3 = (z) sparseArray.get(i16);
        if (!this.f3777e) {
            if (zVar3 == null) {
                if (i16 == 189) {
                    kVar = new b("video/mp2p");
                    this.f = true;
                    this.f3779h = pVar.getPosition();
                } else if ((iJ & 224) == 192) {
                    kVar = new u(0, null, "video/mp2p");
                    this.f = true;
                    this.f3779h = pVar.getPosition();
                } else if ((iJ & 240) == 224) {
                    kVar = new k(null, "video/mp2p");
                    this.f3778g = true;
                    this.f3779h = pVar.getPosition();
                } else {
                    kVar = null;
                }
                if (kVar != null) {
                    kVar.g(this.f3780j, new h0(i16, 256));
                    zVar3 = new z(kVar, this.f3773a);
                    sparseArray.put(i16, zVar3);
                }
            }
            if (pVar.getPosition() > ((this.f && this.f3778g) ? this.f3779h + 8192 : 1048576L)) {
                this.f3777e = true;
                this.f3780j.e();
            }
        }
        pVar.w(uVar2.f11709a, 0, 2);
        uVar2.J(0);
        int iD = uVar2.D() + 6;
        if (zVar3 == null) {
            pVar.m(iD);
            return 0;
        }
        uVar2.G(iD);
        pVar.readFully(uVar2.f11709a, 0, iD);
        uVar2.J(6);
        i iVar = zVar3.f4071a;
        s1.t tVar = zVar3.f4073c;
        uVar2.h(tVar.f11703b, 0, 3);
        tVar.q(0);
        tVar.t(8);
        zVar3.f4074d = tVar.h();
        zVar3.f4075e = tVar.h();
        tVar.t(6);
        uVar2.h(tVar.f11703b, 0, tVar.i(8));
        tVar.q(0);
        s1.z zVar4 = zVar3.f4072b;
        zVar3.f4076g = 0L;
        if (zVar3.f4074d) {
            tVar.t(4);
            long jI = ((long) tVar.i(3)) << 30;
            tVar.t(1);
            long jI2 = jI | ((long) (tVar.i(15) << 15));
            tVar.t(1);
            long jI3 = jI2 | ((long) tVar.i(15));
            tVar.t(1);
            if (zVar3.f || !zVar3.f4075e) {
                j5 = jI3;
            } else {
                tVar.t(4);
                long jI4 = ((long) tVar.i(3)) << 30;
                tVar.t(1);
                long jI5 = ((long) (tVar.i(15) << 15)) | jI4;
                tVar.t(1);
                long jI6 = jI5 | ((long) tVar.i(15));
                tVar.t(1);
                zVar4.b(jI6);
                zVar3.f = true;
                j5 = jI3;
            }
            zVar3.f4076g = zVar4.b(j5);
        }
        iVar.f(4, zVar3.f4076g);
        iVar.d(uVar2);
        iVar.e(false);
        uVar2.I(uVar2.f11709a.length);
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
