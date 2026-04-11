package b3;

import a2.f0;
import aa.c1;
import aa.j0;
import e6.j;
import java.util.Arrays;
import java.util.List;
import p1.l0;
import p1.m0;
import p1.n0;
import p2.c;
import s1.t;
import w2.b0;
import w2.h0;
import w2.l;
import w2.o;
import w2.p;
import w2.q;
import w2.s;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f1798e;
    public h0 f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f1800h;
    public u i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f1803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1804m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1805n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1794a = new byte[42];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.u f1795b = new s1.u(0, new byte[32768]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1796c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f1797d = new s();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1799g = 0;

    @Override // w2.o
    public final void c(q qVar) {
        this.f1798e = qVar;
        this.f = qVar.q(0, 1);
        qVar.e();
    }

    @Override // w2.o
    public final boolean e(p pVar) throws Throwable {
        w2.b.t(pVar, false);
        s1.u uVar = new s1.u(4);
        ((l) pVar).r(uVar.f11709a, 0, 4, false);
        return uVar.z() == 1716281667;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        if (j5 == 0) {
            this.f1799g = 0;
        } else {
            a aVar = this.f1803l;
            if (aVar != null) {
                aVar.d(j8);
            }
        }
        this.f1805n = j8 != 0 ? -1L : 0L;
        this.f1804m = 0;
        this.f1795b.G(0);
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // w2.o
    public final int l(p pVar, s sVar) throws Throwable {
        u uVar;
        int i;
        b0 tVar;
        long j5;
        long j8;
        boolean zC;
        int i10 = this.f1799g;
        if (i10 == 0) {
            boolean z2 = !this.f1796c;
            pVar.l();
            long jS = pVar.s();
            l0 l0VarT = w2.b.t(pVar, z2);
            pVar.m((int) (pVar.s() - jS));
            this.f1800h = l0VarT;
            this.f1799g = 1;
            return 0;
        }
        byte[] bArr = this.f1794a;
        if (i10 == 1) {
            pVar.w(bArr, 0, bArr.length);
            pVar.l();
            this.f1799g = 2;
            return 0;
        }
        int i11 = 4;
        int i12 = 3;
        if (i10 == 2) {
            s1.u uVar2 = new s1.u(4);
            pVar.readFully(uVar2.f11709a, 0, 4);
            if (uVar2.z() != 1716281667) {
                throw n0.a(null, "Failed to read FLAC stream marker.");
            }
            this.f1799g = 3;
            return 0;
        }
        int i13 = 6;
        if (i10 == 3) {
            int i14 = 0;
            u uVar3 = this.i;
            boolean z10 = false;
            while (!z10) {
                pVar.l();
                byte[] bArr2 = new byte[i11];
                t tVar2 = new t(i11, bArr2);
                int i15 = i14;
                pVar.w(bArr2, i15, i11);
                boolean zH = tVar2.h();
                int i16 = tVar2.i(i);
                int i17 = tVar2.i(24) + i11;
                if (i16 == 0) {
                    byte[] bArr3 = new byte[38];
                    pVar.readFully(bArr3, i15, 38);
                    uVar3 = new u(i11, bArr3);
                } else {
                    if (uVar3 == null) {
                        throw new IllegalArgumentException();
                    }
                    l0 l0Var = uVar3.f13677l;
                    if (i16 == i12) {
                        s1.u uVar4 = new s1.u(i17);
                        pVar.readFully(uVar4.f11709a, i15, i17);
                        uVar3 = new u(uVar3.f13668a, uVar3.f13669b, uVar3.f13670c, uVar3.f13671d, uVar3.f13672e, uVar3.f13673g, uVar3.f13674h, uVar3.f13675j, w2.b.v(uVar4), uVar3.f13677l);
                    } else {
                        if (i16 == i11) {
                            s1.u uVar5 = new s1.u(i17);
                            pVar.readFully(uVar5.f11709a, 0, i17);
                            uVar5.K(i11);
                            l0 l0VarS = w2.b.s(Arrays.asList((String[]) w2.b.w(uVar5, false, false).f8343u));
                            if (l0Var != null) {
                                l0VarS = l0Var.b(l0VarS);
                            }
                            uVar = new u(uVar3.f13668a, uVar3.f13669b, uVar3.f13670c, uVar3.f13671d, uVar3.f13672e, uVar3.f13673g, uVar3.f13674h, uVar3.f13675j, uVar3.f13676k, l0VarS);
                        } else if (i16 == i13) {
                            s1.u uVar6 = new s1.u(i17);
                            pVar.readFully(uVar6.f11709a, 0, i17);
                            uVar6.K(4);
                            l0 l0Var2 = new l0(j0.v(i3.a.d(uVar6)));
                            if (l0Var != null) {
                                l0Var2 = l0Var.b(l0Var2);
                            }
                            uVar = new u(uVar3.f13668a, uVar3.f13669b, uVar3.f13670c, uVar3.f13671d, uVar3.f13672e, uVar3.f13673g, uVar3.f13674h, uVar3.f13675j, uVar3.f13676k, l0Var2);
                        } else {
                            pVar.m(i17);
                        }
                        uVar3 = uVar;
                    }
                }
                int i18 = s1.b0.f11647a;
                this.i = uVar3;
                z10 = zH;
                i11 = 4;
                i12 = 3;
                i = 7;
                i13 = 6;
                i14 = 0;
            }
            this.i.getClass();
            this.f1801j = Math.max(this.i.f13670c, 6);
            p1.q qVarC = this.i.c(bArr, this.f1800h);
            h0 h0Var = this.f;
            p1.p pVarA = qVarC.a();
            pVarA.f9966l = m0.p("audio/flac");
            j.s(pVarA, h0Var);
            h0 h0Var2 = this.f;
            this.i.b();
            h0Var2.getClass();
            this.f1799g = 4;
            return 0;
        }
        long j10 = 0;
        if (i10 == 4) {
            pVar.l();
            s1.u uVar7 = new s1.u(2);
            pVar.w(uVar7.f11709a, 0, 2);
            int iD = uVar7.D();
            if ((iD >> 2) != 16382) {
                pVar.l();
                throw n0.a(null, "First frame does not start with sync code.");
            }
            pVar.l();
            this.f1802k = iD;
            q qVar = this.f1798e;
            int i19 = s1.b0.f11647a;
            long position = pVar.getPosition();
            long length = pVar.getLength();
            this.i.getClass();
            u uVar8 = this.i;
            c cVar = uVar8.f13676k;
            if (cVar != null && ((long[]) cVar.f10130v).length > 0) {
                tVar = new w2.t(0, position, uVar8);
                i = 0;
            } else if (length == -1 || uVar8.f13675j <= 0) {
                i = 0;
                tVar = new w2.t(uVar8.b());
            } else {
                int i20 = this.f1802k;
                int i21 = uVar8.f13670c;
                f0 f0Var = new f0(10, uVar8);
                aa.l0 l0Var3 = new aa.l0(uVar8, i20);
                long jB = uVar8.b();
                long j11 = uVar8.f13675j;
                int i22 = uVar8.f13671d;
                if (i22 > 0) {
                    i = 0;
                    j5 = ((((long) i22) + ((long) i21)) / 2) + 1;
                } else {
                    i = 0;
                    int i23 = uVar8.f13668a;
                    j5 = 64 + (((((i23 != uVar8.f13669b || i23 <= 0) ? 4096L : i23) * ((long) uVar8.f13673g)) * ((long) uVar8.f13674h)) / 8);
                }
                a aVar = new a(f0Var, l0Var3, jB, j11, position, length, j5, Math.max(6, i21));
                this.f1803l = aVar;
                tVar = aVar.f1790a;
            }
            qVar.j(tVar);
            this.f1799g = 5;
            return i;
        }
        if (i10 != 5) {
            throw new IllegalStateException();
        }
        this.f.getClass();
        this.i.getClass();
        a aVar2 = this.f1803l;
        if (aVar2 != null && aVar2.f1792c != null) {
            return aVar2.b(pVar, sVar);
        }
        if (this.f1805n == -1) {
            u uVar9 = this.i;
            pVar.l();
            pVar.B(1);
            byte[] bArr4 = new byte[1];
            pVar.w(bArr4, 0, 1);
            boolean z11 = (bArr4[0] & 1) == 1;
            pVar.B(2);
            i = z11 ? 7 : 6;
            s1.u uVar10 = new s1.u(i);
            byte[] bArr5 = uVar10.f11709a;
            int i24 = 0;
            while (i24 < i) {
                int i25 = pVar.i(bArr5, i24, i - i24);
                if (i25 == -1) {
                    break;
                }
                i24 += i25;
            }
            uVar10.I(i24);
            pVar.l();
            try {
                long jE = uVar10.E();
                if (!z11) {
                    jE *= (long) uVar9.f13669b;
                }
                j10 = jE;
            } catch (NumberFormatException unused) {
                z = false;
            }
            if (!z) {
                throw n0.a(null, null);
            }
            this.f1805n = j10;
        } else {
            s1.u uVar11 = this.f1795b;
            int i26 = uVar11.f11711c;
            if (i26 < 32768) {
                int i27 = pVar.read(uVar11.f11709a, i26, 32768 - i26);
                z = i27 == -1;
                if (!z) {
                    uVar11.I(i26 + i27);
                } else if (uVar11.a() == 0) {
                    long j12 = this.f1805n * 1000000;
                    u uVar12 = this.i;
                    int i28 = s1.b0.f11647a;
                    this.f.a(j12 / ((long) uVar12.f13672e), 1, this.f1804m, 0, null);
                    return -1;
                }
            } else {
                z = false;
            }
            int i29 = uVar11.f11710b;
            int i30 = this.f1804m;
            int i31 = this.f1801j;
            if (i30 < i31) {
                uVar11.K(Math.min(i31 - i30, uVar11.a()));
            }
            this.i.getClass();
            int i32 = uVar11.f11710b;
            while (true) {
                int i33 = uVar11.f11711c - 16;
                s sVar2 = this.f1797d;
                if (i32 <= i33) {
                    uVar11.J(i32);
                    if (w2.b.c(uVar11, this.i, this.f1802k, sVar2)) {
                        uVar11.J(i32);
                        j8 = sVar2.f13664a;
                        break;
                    }
                    i32++;
                } else {
                    if (z) {
                        while (true) {
                            int i34 = uVar11.f11711c;
                            if (i32 > i34 - this.f1801j) {
                                uVar11.J(i34);
                                break;
                            }
                            uVar11.J(i32);
                            try {
                                zC = w2.b.c(uVar11, this.i, this.f1802k, sVar2);
                            } catch (IndexOutOfBoundsException unused2) {
                                zC = false;
                            }
                            if (uVar11.f11710b > uVar11.f11711c) {
                                zC = false;
                            }
                            if (zC) {
                                uVar11.J(i32);
                                j8 = sVar2.f13664a;
                                break;
                            }
                            i32++;
                        }
                    } else {
                        uVar11.J(i32);
                    }
                    j8 = -1;
                }
            }
            int i35 = uVar11.f11710b - i29;
            uVar11.J(i29);
            this.f.f(i35, uVar11);
            int i36 = this.f1804m + i35;
            this.f1804m = i36;
            if (j8 != -1) {
                long j13 = this.f1805n * 1000000;
                u uVar13 = this.i;
                int i37 = s1.b0.f11647a;
                this.f.a(j13 / ((long) uVar13.f13672e), 1, i36, 0, null);
                this.f1804m = 0;
                this.f1805n = j8;
            }
            int length2 = uVar11.f11709a.length - uVar11.f11711c;
            if (uVar11.a() < 16 && length2 < 16) {
                int iA = uVar11.a();
                byte[] bArr6 = uVar11.f11709a;
                System.arraycopy(bArr6, uVar11.f11710b, bArr6, 0, iA);
                uVar11.J(0);
                uVar11.I(iA);
            }
        }
        return 0;
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
