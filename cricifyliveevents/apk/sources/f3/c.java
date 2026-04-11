package f3;

import a3.c0;
import a3.i0;
import a3.k0;
import a3.l;
import a3.p;
import a3.q;
import a3.r;
import a3.u;
import a3.v;
import androidx.fragment.app.f1;
import java.util.Arrays;
import java.util.List;
import l0.e;
import ua.g0;
import ua.z0;
import v1.l0;
import v1.m0;
import v1.n0;
import v1.o;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f3946e;
    public i0 f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f3948h;
    public v i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3950k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f3951l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3952m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3953n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3942a = new byte[42];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f3943b = new t(0, new byte[32768]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3944c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3.t f3945d = new a3.t();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3947g = 0;

    @Override // a3.p
    public final void c(r rVar) {
        this.f3946e = rVar;
        this.f = rVar.p(0, 1);
        rVar.e();
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        if (j4 == 0) {
            this.f3947g = 0;
        } else {
            b bVar = this.f3951l;
            if (bVar != null) {
                bVar.d(j7);
            }
        }
        this.f3953n = j7 != 0 ? -1L : 0L;
        this.f3952m = 0;
        this.f3943b.G(0);
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) throws Throwable {
        a3.b.s(qVar, false);
        t tVar = new t(4);
        ((l) qVar).v(tVar.f14609a, 0, 4, false);
        return tVar.z() == 1716281667;
    }

    @Override // a3.p
    public final int i(q qVar, a3.t tVar) throws Throwable {
        v vVar;
        int i;
        c0 uVar;
        long j4;
        long j7;
        boolean zB;
        int i10 = this.f3947g;
        if (i10 == 0) {
            boolean z10 = !this.f3944c;
            qVar.k();
            long jX = qVar.x();
            l0 l0VarS = a3.b.s(qVar, z10);
            qVar.n((int) (qVar.x() - jX));
            this.f3948h = l0VarS;
            this.f3947g = 1;
            return 0;
        }
        byte[] bArr = this.f3942a;
        if (i10 == 1) {
            qVar.z(bArr, 0, bArr.length);
            qVar.k();
            this.f3947g = 2;
            return 0;
        }
        int i11 = 4;
        int i12 = 3;
        if (i10 == 2) {
            t tVar2 = new t(4);
            qVar.readFully(tVar2.f14609a, 0, 4);
            if (tVar2.z() != 1716281667) {
                throw n0.a(null, "Failed to read FLAC stream marker.");
            }
            this.f3947g = 3;
            return 0;
        }
        int i13 = 6;
        if (i10 == 3) {
            int i14 = 0;
            v vVar2 = this.i;
            boolean z11 = false;
            while (!z11) {
                qVar.k();
                byte[] bArr2 = new byte[i11];
                k0 k0Var = new k0(i11, bArr2);
                int i15 = i14;
                qVar.z(bArr2, i15, i11);
                boolean zH = k0Var.h();
                int i16 = k0Var.i(i);
                int i17 = k0Var.i(24) + i11;
                if (i16 == 0) {
                    byte[] bArr3 = new byte[38];
                    qVar.readFully(bArr3, i15, 38);
                    vVar2 = new v(i11, bArr3);
                } else {
                    if (vVar2 == null) {
                        throw new IllegalArgumentException();
                    }
                    l0 l0Var = vVar2.f240l;
                    if (i16 == i12) {
                        t tVar3 = new t(i17);
                        qVar.readFully(tVar3.f14609a, i15, i17);
                        vVar2 = new v(vVar2.f231a, vVar2.f232b, vVar2.f233c, vVar2.f234d, vVar2.f235e, vVar2.f236g, vVar2.f237h, vVar2.f238j, a3.b.u(tVar3), vVar2.f240l);
                    } else {
                        if (i16 == i11) {
                            t tVar4 = new t(i17);
                            qVar.readFully(tVar4.f14609a, 0, i17);
                            tVar4.K(i11);
                            l0 l0VarR = a3.b.r(Arrays.asList((String[]) a3.b.v(tVar4, false, false).f10180v));
                            if (l0Var != null) {
                                l0VarR = l0Var.b(l0VarR);
                            }
                            vVar = new v(vVar2.f231a, vVar2.f232b, vVar2.f233c, vVar2.f234d, vVar2.f235e, vVar2.f236g, vVar2.f237h, vVar2.f238j, vVar2.f239k, l0VarR);
                        } else if (i16 == i13) {
                            t tVar5 = new t(i17);
                            qVar.readFully(tVar5.f14609a, 0, i17);
                            tVar5.K(4);
                            l0 l0Var2 = new l0(ua.i0.o(m3.a.d(tVar5)));
                            if (l0Var != null) {
                                l0Var2 = l0Var.b(l0Var2);
                            }
                            vVar = new v(vVar2.f231a, vVar2.f232b, vVar2.f233c, vVar2.f234d, vVar2.f235e, vVar2.f236g, vVar2.f237h, vVar2.f238j, vVar2.f239k, l0Var2);
                        } else {
                            qVar.n(i17);
                        }
                        vVar2 = vVar;
                    }
                }
                int i18 = a0.f14551a;
                this.i = vVar2;
                z11 = zH;
                i11 = 4;
                i12 = 3;
                i = 7;
                i13 = 6;
                i14 = 0;
            }
            this.i.getClass();
            this.f3949j = Math.max(this.i.f233c, 6);
            v1.p pVarC = this.i.c(bArr, this.f3948h);
            i0 i0Var = this.f;
            o oVarA = pVarC.a();
            oVarA.f12892l = m0.p("audio/flac");
            e.s(oVarA, i0Var);
            i0 i0Var2 = this.f;
            this.i.b();
            i0Var2.getClass();
            this.f3947g = 4;
            return 0;
        }
        long j10 = 0;
        if (i10 == 4) {
            qVar.k();
            t tVar6 = new t(2);
            qVar.z(tVar6.f14609a, 0, 2);
            int iD = tVar6.D();
            if ((iD >> 2) != 16382) {
                qVar.k();
                throw n0.a(null, "First frame does not start with sync code.");
            }
            qVar.k();
            this.f3950k = iD;
            r rVar = this.f3946e;
            int i19 = a0.f14551a;
            long position = qVar.getPosition();
            long length = qVar.getLength();
            this.i.getClass();
            v vVar3 = this.i;
            l4.c0 c0Var = vVar3.f239k;
            if (c0Var != null && ((long[]) c0Var.f7705w).length > 0) {
                uVar = new u(vVar3, position, 0);
                i = 0;
            } else if (length == -1 || vVar3.f238j <= 0) {
                i = 0;
                uVar = new u(vVar3.b());
            } else {
                int i20 = this.f3950k;
                int i21 = vVar3.f233c;
                f1 f1Var = new f1(8, vVar3);
                a aVar = new a(vVar3, i20);
                long jB = vVar3.b();
                long j11 = vVar3.f238j;
                int i22 = vVar3.f234d;
                if (i22 > 0) {
                    i = 0;
                    j4 = ((((long) i22) + ((long) i21)) / 2) + 1;
                } else {
                    i = 0;
                    int i23 = vVar3.f231a;
                    j4 = 64 + (((((i23 != vVar3.f232b || i23 <= 0) ? 4096L : i23) * ((long) vVar3.f236g)) * ((long) vVar3.f237h)) / 8);
                }
                b bVar = new b(f1Var, aVar, jB, j11, position, length, j4, Math.max(6, i21));
                this.f3951l = bVar;
                uVar = bVar.f3938a;
            }
            rVar.s(uVar);
            this.f3947g = 5;
            return i;
        }
        if (i10 != 5) {
            throw new IllegalStateException();
        }
        this.f.getClass();
        this.i.getClass();
        b bVar2 = this.f3951l;
        if (bVar2 != null && bVar2.f3940c != null) {
            return bVar2.b(qVar, tVar);
        }
        if (this.f3953n == -1) {
            v vVar4 = this.i;
            qVar.k();
            qVar.A(1);
            byte[] bArr4 = new byte[1];
            qVar.z(bArr4, 0, 1);
            boolean z12 = (bArr4[0] & 1) == 1;
            qVar.A(2);
            i = z12 ? 7 : 6;
            t tVar7 = new t(i);
            byte[] bArr5 = tVar7.f14609a;
            int i24 = 0;
            while (i24 < i) {
                int i25 = qVar.i(bArr5, i24, i - i24);
                if (i25 == -1) {
                    break;
                }
                i24 += i25;
            }
            tVar7.I(i24);
            qVar.k();
            try {
                long jE = tVar7.E();
                if (!z12) {
                    jE *= (long) vVar4.f232b;
                }
                j10 = jE;
            } catch (NumberFormatException unused) {
                z = false;
            }
            if (!z) {
                throw n0.a(null, null);
            }
            this.f3953n = j10;
        } else {
            t tVar8 = this.f3943b;
            int i26 = tVar8.f14611c;
            if (i26 < 32768) {
                int i27 = qVar.read(tVar8.f14609a, i26, 32768 - i26);
                z = i27 == -1;
                if (!z) {
                    tVar8.I(i26 + i27);
                } else if (tVar8.a() == 0) {
                    long j12 = this.f3953n * 1000000;
                    v vVar5 = this.i;
                    int i28 = a0.f14551a;
                    this.f.e(j12 / ((long) vVar5.f235e), 1, this.f3952m, 0, null);
                    return -1;
                }
            } else {
                z = false;
            }
            int i29 = tVar8.f14610b;
            int i30 = this.f3952m;
            int i31 = this.f3949j;
            if (i30 < i31) {
                tVar8.K(Math.min(i31 - i30, tVar8.a()));
            }
            this.i.getClass();
            int i32 = tVar8.f14610b;
            while (true) {
                int i33 = tVar8.f14611c - 16;
                a3.t tVar9 = this.f3945d;
                if (i32 <= i33) {
                    tVar8.J(i32);
                    if (a3.b.b(tVar8, this.i, this.f3950k, tVar9)) {
                        tVar8.J(i32);
                        j7 = tVar9.f227a;
                        break;
                    }
                    i32++;
                } else {
                    if (z) {
                        while (true) {
                            int i34 = tVar8.f14611c;
                            if (i32 > i34 - this.f3949j) {
                                tVar8.J(i34);
                                break;
                            }
                            tVar8.J(i32);
                            try {
                                zB = a3.b.b(tVar8, this.i, this.f3950k, tVar9);
                            } catch (IndexOutOfBoundsException unused2) {
                                zB = false;
                            }
                            if (tVar8.f14610b > tVar8.f14611c) {
                                zB = false;
                            }
                            if (zB) {
                                tVar8.J(i32);
                                j7 = tVar9.f227a;
                                break;
                            }
                            i32++;
                        }
                    } else {
                        tVar8.J(i32);
                    }
                    j7 = -1;
                }
            }
            int i35 = tVar8.f14610b - i29;
            tVar8.J(i29);
            this.f.a(i35, tVar8);
            int i36 = this.f3952m + i35;
            this.f3952m = i36;
            if (j7 != -1) {
                long j13 = this.f3953n * 1000000;
                v vVar6 = this.i;
                int i37 = a0.f14551a;
                this.f.e(j13 / ((long) vVar6.f235e), 1, i36, 0, null);
                this.f3952m = 0;
                this.f3953n = j7;
            }
            int length2 = tVar8.f14609a.length - tVar8.f14611c;
            if (tVar8.a() < 16 && length2 < 16) {
                int iA = tVar8.a();
                byte[] bArr6 = tVar8.f14609a;
                System.arraycopy(bArr6, tVar8.f14610b, bArr6, 0, iA);
                tVar8.J(0);
                tVar8.I(iA);
            }
        }
        return 0;
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
