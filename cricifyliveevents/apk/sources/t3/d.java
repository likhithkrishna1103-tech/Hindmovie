package t3;

import a3.a0;
import a3.i0;
import a3.o;
import a3.p;
import a3.q;
import a3.r;
import a3.x;
import java.io.EOFException;
import java.util.List;
import ua.g0;
import ua.z0;
import v1.l0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f11878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f11879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f11880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p6.d f11881e;
    public final o f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f11882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i0 f11883h;
    public i0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l0 f11885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f11886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f11887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f11891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f11894t;

    public d(int i) {
        this(-9223372036854775807L);
    }

    public final void b() {
        f fVar = this.f11891q;
        if ((fVar instanceof a) && ((a) fVar).g()) {
            long j4 = this.f11889o;
            if (j4 == -1 || j4 == this.f11891q.d()) {
                return;
            }
            a aVar = (a) this.f11891q;
            this.f11891q = new a(this.f11889o, aVar.f11870h, aVar.i, aVar.f11871j, aVar.f11872k);
            r rVar = this.f11882g;
            rVar.getClass();
            rVar.s(this.f11891q);
            this.f11883h.getClass();
            this.f11891q.l();
        }
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f11882g = rVar;
        i0 i0VarP = rVar.p(0, 1);
        this.f11883h = i0VarP;
        this.i = i0VarP;
        this.f11882g.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(a3.q r9) {
        /*
            r8 = this;
            t3.f r0 = r8.f11891q
            r1 = 1
            if (r0 == 0) goto L1b
            long r2 = r0.d()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L1b
            long r4 = r9.x()
            r6 = 4
            long r2 = r2 - r6
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L1b
            goto L27
        L1b:
            y1.t r0 = r8.f11878b     // Catch: java.io.EOFException -> L27
            byte[] r0 = r0.f14609a     // Catch: java.io.EOFException -> L27
            r2 = 0
            r3 = 4
            boolean r9 = r9.v(r0, r2, r3, r1)     // Catch: java.io.EOFException -> L27
            r9 = r9 ^ r1
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.d.d(a3.q):boolean");
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f11884j = 0;
        this.f11886l = -9223372036854775807L;
        this.f11887m = 0L;
        this.f11890p = 0;
        this.f11894t = j7;
        if (this.f11891q instanceof b) {
            throw null;
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    public final boolean g(q qVar, boolean z10) throws Throwable {
        int iX;
        int i;
        int iH;
        int i10 = z10 ? 32768 : 131072;
        qVar.k();
        if (qVar.getPosition() == 0) {
            t tVar = (t) this.f11881e.f10037w;
            int i11 = 0;
            l0 l0VarT = null;
            while (true) {
                try {
                    qVar.z(tVar.f14609a, 0, 10);
                    tVar.J(0);
                    if (tVar.A() != 4801587) {
                        break;
                    }
                    tVar.K(3);
                    int iW = tVar.w();
                    int i12 = iW + 10;
                    if (l0VarT == null) {
                        byte[] bArr = new byte[i12];
                        System.arraycopy(tVar.f14609a, 0, bArr, 0, 10);
                        qVar.z(bArr, 10, iW);
                        l0VarT = new o3.h(null).T(i12, bArr);
                    } else {
                        qVar.A(iW);
                    }
                    i11 += i12;
                } catch (EOFException unused) {
                }
            }
            qVar.k();
            qVar.A(i11);
            this.f11885k = l0VarT;
            if (l0VarT != null) {
                this.f11880d.b(l0VarT);
            }
            iX = (int) qVar.x();
            if (!z10) {
                qVar.n(iX);
            }
            i = 0;
        } else {
            iX = 0;
            i = 0;
        }
        int i13 = i;
        int i14 = i13;
        while (true) {
            if (!d(qVar)) {
                t tVar2 = this.f11878b;
                tVar2.J(0);
                int iJ = tVar2.j();
                if ((i == 0 || ((-128000) & iJ) == (((long) i) & (-128000))) && (iH = a3.b.h(iJ)) != -1) {
                    i13++;
                    if (i13 != 1) {
                        if (i13 == 4) {
                            break;
                        }
                    } else {
                        this.f11879c.a(iJ);
                        i = iJ;
                    }
                    qVar.A(iH - 4);
                } else {
                    int i15 = i14 + 1;
                    if (i14 == i10) {
                        if (z10) {
                            return false;
                        }
                        b();
                        throw new EOFException();
                    }
                    if (z10) {
                        qVar.k();
                        qVar.A(iX + i15);
                    } else {
                        qVar.n(1);
                    }
                    i13 = 0;
                    i14 = i15;
                    i = 0;
                }
            } else if (i13 <= 0) {
                b();
                throw new EOFException();
            }
        }
        if (z10) {
            qVar.n(iX + i14);
        } else {
            qVar.k();
        }
        this.f11884j = i;
        return true;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        return g(qVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x034b A[LOOP:2: B:158:0x0349->B:159:0x034b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r54, a3.t r55) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.d.i(a3.q, a3.t):int");
    }

    public d(long j4) {
        this.f11877a = j4;
        this.f11878b = new t(10);
        this.f11879c = new a0();
        this.f11880d = new x();
        this.f11886l = -9223372036854775807L;
        this.f11881e = new p6.d(1);
        o oVar = new o();
        this.f = oVar;
        this.i = oVar;
        this.f11889o = -1L;
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
