package p3;

import aa.c1;
import aa.j0;
import java.io.EOFException;
import java.util.List;
import p1.l0;
import s1.u;
import w2.h0;
import w2.n;
import w2.o;
import w2.p;
import w2.q;
import w2.w;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f10175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f10176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f10177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0.e f10178e;
    public final n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f10179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h0 f10180h;
    public h0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l0 f10182k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10183l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10184m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10185n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f10186o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10187p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f10188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10189r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10190s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10191t;

    public d(int i) {
        this(-9223372036854775807L);
    }

    public final void b() {
        f fVar = this.f10188q;
        if ((fVar instanceof a) && ((a) fVar).h()) {
            long j5 = this.f10186o;
            if (j5 == -1 || j5 == this.f10188q.d()) {
                return;
            }
            a aVar = (a) this.f10188q;
            this.f10188q = new a(this.f10186o, aVar.f10167h, aVar.i, aVar.f10168j, aVar.f10169k);
            q qVar = this.f10179g;
            qVar.getClass();
            qVar.j(this.f10188q);
            this.f10180h.getClass();
            this.f10188q.k();
        }
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f10179g = qVar;
        h0 h0VarQ = qVar.q(0, 1);
        this.f10180h = h0VarQ;
        this.i = h0VarQ;
        this.f10179g.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(w2.p r9) {
        /*
            r8 = this;
            p3.f r0 = r8.f10188q
            r1 = 1
            if (r0 == 0) goto L1b
            long r2 = r0.d()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L1b
            long r4 = r9.s()
            r6 = 4
            long r2 = r2 - r6
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L1b
            goto L27
        L1b:
            s1.u r0 = r8.f10175b     // Catch: java.io.EOFException -> L27
            byte[] r0 = r0.f11709a     // Catch: java.io.EOFException -> L27
            r2 = 0
            r3 = 4
            boolean r9 = r9.r(r0, r2, r3, r1)     // Catch: java.io.EOFException -> L27
            r9 = r9 ^ r1
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.d.d(w2.p):boolean");
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        return h(pVar, true);
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f10181j = 0;
        this.f10183l = -9223372036854775807L;
        this.f10184m = 0L;
        this.f10187p = 0;
        this.f10191t = j8;
        if (this.f10188q instanceof b) {
            throw null;
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    public final boolean h(p pVar, boolean z2) throws Throwable {
        int iS;
        int i;
        int i10;
        int i11 = z2 ? 32768 : 131072;
        pVar.l();
        if (pVar.getPosition() == 0) {
            u uVar = (u) this.f10178e.f10436v;
            int i12 = 0;
            l0 l0VarY = null;
            while (true) {
                try {
                    pVar.w(uVar.f11709a, 0, 10);
                    uVar.J(0);
                    if (uVar.A() != 4801587) {
                        break;
                    }
                    uVar.K(3);
                    int iW = uVar.w();
                    int i13 = iW + 10;
                    if (l0VarY == null) {
                        byte[] bArr = new byte[i13];
                        System.arraycopy(uVar.f11709a, 0, bArr, 0, 10);
                        pVar.w(bArr, 10, iW);
                        l0VarY = new k3.h(null).y(i13, bArr);
                    } else {
                        pVar.B(iW);
                    }
                    i12 += i13;
                } catch (EOFException unused) {
                }
            }
            pVar.l();
            pVar.B(i12);
            this.f10182k = l0VarY;
            if (l0VarY != null) {
                this.f10177d.b(l0VarY);
            }
            iS = (int) pVar.s();
            if (!z2) {
                pVar.m(iS);
            }
            i = 0;
        } else {
            iS = 0;
            i = 0;
        }
        int i14 = i;
        int i15 = i14;
        while (true) {
            if (!d(pVar)) {
                u uVar2 = this.f10175b;
                uVar2.J(0);
                int iJ = uVar2.j();
                if ((i == 0 || ((-128000) & iJ) == (((long) i) & (-128000))) && (i10 = w2.b.i(iJ)) != -1) {
                    i14++;
                    if (i14 != 1) {
                        if (i14 == 4) {
                            break;
                        }
                    } else {
                        this.f10176c.a(iJ);
                        i = iJ;
                    }
                    pVar.B(i10 - 4);
                } else {
                    int i16 = i15 + 1;
                    if (i15 == i11) {
                        if (z2) {
                            return false;
                        }
                        b();
                        throw new EOFException();
                    }
                    if (z2) {
                        pVar.l();
                        pVar.B(iS + i16);
                    } else {
                        pVar.m(1);
                    }
                    i14 = 0;
                    i15 = i16;
                    i = 0;
                }
            } else if (i14 <= 0) {
                b();
                throw new EOFException();
            }
        }
        if (z2) {
            pVar.m(iS + i15);
        } else {
            pVar.l();
        }
        this.f10181j = i;
        return true;
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
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r54, w2.s r55) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.d.l(w2.p, w2.s):int");
    }

    public d(long j5) {
        this.f10174a = j5;
        this.f10175b = new u(10);
        this.f10176c = new z();
        this.f10177d = new w();
        this.f10183l = -9223372036854775807L;
        this.f10178e = new q0.e(14);
        n nVar = new n();
        this.f = nVar;
        this.i = nVar;
        this.f10186o = -1L;
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
