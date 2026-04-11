package f9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s0 implements j9.e, a3.q, a3.r, j2.i {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4389v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4390w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4391x;

    public /* synthetic */ s0(long j4, Object obj, int i) {
        this.f4389v = i;
        this.f4390w = j4;
        this.f4391x = obj;
    }

    @Override // a3.q
    public void A(int i) {
        ((a3.q) this.f4391x).A(i);
    }

    public void C(int i) {
        if (i < 64) {
            this.f4390w &= ~(1 << i);
            return;
        }
        s0 s0Var = (s0) this.f4391x;
        if (s0Var != null) {
            s0Var.C(i - 64);
        }
    }

    public int D(int i) {
        s0 s0Var = (s0) this.f4391x;
        if (s0Var == null) {
            return i >= 64 ? Long.bitCount(this.f4390w) : Long.bitCount(this.f4390w & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.f4390w & ((1 << i) - 1));
        }
        return Long.bitCount(this.f4390w) + s0Var.D(i - 64);
    }

    public void E() {
        if (((s0) this.f4391x) == null) {
            this.f4391x = new s0(8);
        }
    }

    public void F(v1 v1Var) {
        this.f4390w++;
        Thread thread = new Thread(v1Var);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f4390w + ")");
        ((List) this.f4391x).add(v1Var);
        thread.start();
    }

    public boolean G(int i) {
        if (i < 64) {
            return (this.f4390w & (1 << i)) != 0;
        }
        E();
        return ((s0) this.f4391x).G(i - 64);
    }

    public void H(int i, boolean z10) {
        if (i >= 64) {
            E();
            ((s0) this.f4391x).H(i - 64, z10);
            return;
        }
        long j4 = this.f4390w;
        boolean z11 = (Long.MIN_VALUE & j4) != 0;
        long j7 = (1 << i) - 1;
        this.f4390w = ((j4 & (~j7)) << 1) | (j4 & j7);
        if (z10) {
            L(i);
        } else {
            C(i);
        }
        if (z11 || ((s0) this.f4391x) != null) {
            E();
            ((s0) this.f4391x).H(0, z11);
        }
    }

    public kf.p I() {
        kf.o oVar = new kf.o(0);
        while (true) {
            String strI = ((ag.g) this.f4391x).I(this.f4390w);
            this.f4390w -= (long) strI.length();
            if (strI.length() == 0) {
                return oVar.b();
            }
            int iH0 = ne.h.h0(strI, ':', 1, 4);
            if (iH0 != -1) {
                String strSubstring = strI.substring(0, iH0);
                ge.i.d(strSubstring, "substring(...)");
                String strSubstring2 = strI.substring(iH0 + 1);
                ge.i.d(strSubstring2, "substring(...)");
                n5.a.f(oVar, strSubstring, strSubstring2);
            } else if (strI.charAt(0) == ':') {
                String strSubstring3 = strI.substring(1);
                ge.i.d(strSubstring3, "substring(...)");
                n5.a.f(oVar, "", strSubstring3);
            } else {
                n5.a.f(oVar, "", strI);
            }
        }
    }

    public boolean J(int i) {
        if (i >= 64) {
            E();
            return ((s0) this.f4391x).J(i - 64);
        }
        long j4 = 1 << i;
        long j7 = this.f4390w;
        boolean z10 = (j7 & j4) != 0;
        long j10 = j7 & (~j4);
        this.f4390w = j10;
        long j11 = j4 - 1;
        this.f4390w = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
        s0 s0Var = (s0) this.f4391x;
        if (s0Var != null) {
            if (s0Var.G(0)) {
                L(63);
            }
            ((s0) this.f4391x).J(0);
        }
        return z10;
    }

    public void K() {
        this.f4390w = 0L;
        s0 s0Var = (s0) this.f4391x;
        if (s0Var != null) {
            s0Var.K();
        }
    }

    public void L(int i) {
        if (i < 64) {
            this.f4390w |= 1 << i;
        } else {
            E();
            ((s0) this.f4391x).L(i - 64);
        }
    }

    @Override // a3.q
    public int a(int i) {
        return ((a3.q) this.f4391x).a(i);
    }

    @Override // j2.i
    public long b(long j4) {
        return ((a3.k) this.f4391x).f206e[(int) j4] - this.f4390w;
    }

    @Override // j2.i
    public long c(long j4, long j7) {
        a3.k kVar = (a3.k) this.f4391x;
        return y1.a0.e(kVar.f206e, j4 + this.f4390w, true);
    }

    @Override // a3.r
    public void e() {
        ((a3.r) this.f4391x).e();
    }

    @Override // j2.i
    public long f(long j4, long j7) {
        return ((a3.k) this.f4391x).f205d[(int) j4];
    }

    @Override // a3.q
    public boolean g(byte[] bArr, int i, int i10, boolean z10) {
        return ((a3.q) this.f4391x).g(bArr, 0, i10, z10);
    }

    @Override // a3.q
    public long getLength() {
        return ((a3.q) this.f4391x).getLength() - this.f4390w;
    }

    @Override // a3.q
    public long getPosition() {
        return ((a3.q) this.f4391x).getPosition() - this.f4390w;
    }

    @Override // j2.i
    public long h(long j4, long j7) {
        return 0L;
    }

    @Override // a3.q
    public int i(byte[] bArr, int i, int i10) {
        return ((a3.q) this.f4391x).i(bArr, i, i10);
    }

    @Override // a3.q
    public void k() {
        ((a3.q) this.f4391x).k();
    }

    @Override // j2.i
    public long l(long j4, long j7) {
        return -9223372036854775807L;
    }

    @Override // j2.i
    public k2.j m(long j4) {
        return new k2.j(((a3.k) this.f4391x).f204c[(int) j4], r1.f203b[r7], null);
    }

    @Override // a3.q
    public void n(int i) {
        ((a3.q) this.f4391x).n(i);
    }

    @Override // j2.i
    public boolean o() {
        return true;
    }

    @Override // a3.r
    public a3.i0 p(int i, int i10) {
        return ((a3.r) this.f4391x).p(i, i10);
    }

    @Override // j2.i
    public long q() {
        return 0L;
    }

    @Override // a3.q
    public boolean r(int i, boolean z10) {
        return ((a3.q) this.f4391x).r(i, true);
    }

    @Override // v1.h
    public int read(byte[] bArr, int i, int i10) {
        return ((a3.q) this.f4391x).read(bArr, i, i10);
    }

    @Override // a3.q
    public void readFully(byte[] bArr, int i, int i10) {
        ((a3.q) this.f4391x).readFully(bArr, i, i10);
    }

    @Override // a3.r
    public void s(a3.c0 c0Var) {
        ((a3.r) this.f4391x).s(new i3.d(this, c0Var, c0Var));
    }

    public String toString() {
        switch (this.f4389v) {
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                if (((s0) this.f4391x) == null) {
                    return Long.toBinaryString(this.f4390w);
                }
                return ((s0) this.f4391x).toString() + "xx" + Long.toBinaryString(this.f4390w);
            default:
                return super.toString();
        }
    }

    @Override // j2.i
    public long u(long j4) {
        return ((a3.k) this.f4391x).f202a;
    }

    @Override // a3.q
    public boolean v(byte[] bArr, int i, int i10, boolean z10) {
        return ((a3.q) this.f4391x).v(bArr, i, i10, z10);
    }

    @Override // j2.i
    public long w(long j4, long j7) {
        return ((a3.k) this.f4391x).f202a;
    }

    @Override // a3.q
    public long x() {
        return ((a3.q) this.f4391x).x() - this.f4390w;
    }

    @Override // j9.e
    public /* synthetic */ void y(Exception exc) {
        androidx.emoji2.text.v vVar = (androidx.emoji2.text.v) this.f4391x;
        ((AtomicLong) vVar.f890y).set(this.f4390w);
    }

    @Override // a3.q
    public void z(byte[] bArr, int i, int i10) {
        ((a3.q) this.f4391x).z(bArr, i, i10);
    }

    public /* synthetic */ s0(Object obj, long j4, int i) {
        this.f4389v = i;
        this.f4391x = obj;
        this.f4390w = j4;
    }

    public s0(s8.a aVar) {
        this.f4389v = 1;
        o8.u.g(aVar);
        this.f4391x = aVar;
    }

    public s0(ag.q qVar) {
        this.f4389v = 7;
        ge.i.e(qVar, "source");
        this.f4391x = qVar;
        this.f4390w = 262144L;
    }

    public s0(a3.q qVar, long j4) {
        this.f4389v = 3;
        this.f4391x = qVar;
        y1.d.b(qVar.getPosition() >= j4);
        this.f4390w = j4;
    }

    public s0(int i) {
        this.f4389v = i;
        switch (i) {
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                this.f4390w = 0L;
                break;
            default:
                this.f4391x = Collections.synchronizedList(new ArrayList());
                break;
        }
    }
}
