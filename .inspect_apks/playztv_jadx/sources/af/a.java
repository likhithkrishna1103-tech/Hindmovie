package af;

import e2.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k8.n0;
import s1.b0;
import t7.v;
import ue.m;
import w2.h0;
import w2.k;
import w2.p;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d2.h, p, q, o8.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f795u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f796v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f797w;

    public /* synthetic */ a(int i, long j5, Object obj) {
        this.f795u = i;
        this.f796v = j5;
        this.f797w = obj;
    }

    @Override // d2.h
    public long A(long j5, long j8) {
        return ((k) this.f797w).f13645a;
    }

    @Override // w2.p
    public void B(int i) {
        ((p) this.f797w).B(i);
    }

    public void C(int i) {
        if (i < 64) {
            this.f796v &= ~(1 << i);
            return;
        }
        a aVar = (a) this.f797w;
        if (aVar != null) {
            aVar.C(i - 64);
        }
    }

    public int D(int i) {
        a aVar = (a) this.f797w;
        if (aVar == null) {
            return i >= 64 ? Long.bitCount(this.f796v) : Long.bitCount(this.f796v & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.f796v & ((1 << i) - 1));
        }
        return Long.bitCount(this.f796v) + aVar.D(i - 64);
    }

    public void E() {
        if (((a) this.f797w) == null) {
            this.f797w = new a(8);
        }
    }

    public void F(ab.c cVar) {
        this.f796v++;
        Thread thread = new Thread(cVar);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f796v + ")");
        ((List) this.f797w).add(cVar);
        thread.start();
    }

    public boolean G(int i) {
        if (i < 64) {
            return (this.f796v & (1 << i)) != 0;
        }
        E();
        return ((a) this.f797w).G(i - 64);
    }

    public void H(int i, boolean z2) {
        if (i >= 64) {
            E();
            ((a) this.f797w).H(i - 64, z2);
            return;
        }
        long j5 = this.f796v;
        boolean z10 = (Long.MIN_VALUE & j5) != 0;
        long j8 = (1 << i) - 1;
        this.f796v = ((j5 & (~j8)) << 1) | (j5 & j8);
        if (z2) {
            L(i);
        } else {
            C(i);
        }
        if (z10 || ((a) this.f797w) != null) {
            E();
            ((a) this.f797w).H(0, z10);
        }
    }

    public m I() {
        q2.d dVar = new q2.d(2);
        while (true) {
            String strM = ((hf.h) this.f797w).M(this.f796v);
            this.f796v -= (long) strM.length();
            if (strM.length() == 0) {
                return dVar.g();
            }
            int iS = ie.e.S(strM, ':', 1, 4);
            if (iS != -1) {
                String strSubstring = strM.substring(0, iS);
                be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = strM.substring(iS + 1);
                be.h.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                dVar.f(strSubstring, strSubstring2);
            } else if (strM.charAt(0) == ':') {
                String strSubstring3 = strM.substring(1);
                be.h.d(strSubstring3, "this as java.lang.String).substring(startIndex)");
                dVar.f("", strSubstring3);
            } else {
                dVar.f("", strM);
            }
        }
    }

    public boolean J(int i) {
        if (i >= 64) {
            E();
            return ((a) this.f797w).J(i - 64);
        }
        long j5 = 1 << i;
        long j8 = this.f796v;
        boolean z2 = (j8 & j5) != 0;
        long j10 = j8 & (~j5);
        this.f796v = j10;
        long j11 = j5 - 1;
        this.f796v = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
        a aVar = (a) this.f797w;
        if (aVar != null) {
            if (aVar.G(0)) {
                L(63);
            }
            ((a) this.f797w).J(0);
        }
        return z2;
    }

    public void K() {
        this.f796v = 0L;
        a aVar = (a) this.f797w;
        if (aVar != null) {
            aVar.K();
        }
    }

    public void L(int i) {
        if (i < 64) {
            this.f796v |= 1 << i;
        } else {
            E();
            ((a) this.f797w).L(i - 64);
        }
    }

    @Override // w2.p
    public int a(int i) {
        return ((p) this.f797w).a(i);
    }

    @Override // d2.h
    public long b(long j5) {
        return ((k) this.f797w).f13649e[(int) j5] - this.f796v;
    }

    @Override // d2.h
    public long c(long j5, long j8) {
        k kVar = (k) this.f797w;
        return b0.e(kVar.f13649e, j5 + this.f796v, true);
    }

    @Override // d2.h
    public long d(long j5, long j8) {
        return ((k) this.f797w).f13648d[(int) j5];
    }

    @Override // w2.q
    public void e() {
        ((q) this.f797w).e();
    }

    @Override // w2.p
    public boolean f(byte[] bArr, int i, int i10, boolean z2) {
        return ((p) this.f797w).f(bArr, 0, i10, z2);
    }

    @Override // w2.p
    public long getLength() {
        return ((p) this.f797w).getLength() - this.f796v;
    }

    @Override // w2.p
    public long getPosition() {
        return ((p) this.f797w).getPosition() - this.f796v;
    }

    @Override // w2.p
    public int i(byte[] bArr, int i, int i10) {
        return ((p) this.f797w).i(bArr, i, i10);
    }

    @Override // w2.q
    public void j(w2.b0 b0Var) {
        ((q) this.f797w).j(new e3.d(this, b0Var, b0Var));
    }

    @Override // w2.p
    public void l() {
        ((p) this.f797w).l();
    }

    @Override // w2.p
    public void m(int i) {
        ((p) this.f797w).m(i);
    }

    @Override // w2.p
    public boolean n(int i, boolean z2) {
        return ((p) this.f797w).n(i, true);
    }

    @Override // d2.h
    public long p(long j5, long j8) {
        return 0L;
    }

    @Override // w2.q
    public h0 q(int i, int i10) {
        return ((q) this.f797w).q(i, i10);
    }

    @Override // w2.p
    public boolean r(byte[] bArr, int i, int i10, boolean z2) {
        return ((p) this.f797w).r(bArr, i, i10, z2);
    }

    @Override // p1.i
    public int read(byte[] bArr, int i, int i10) {
        return ((p) this.f797w).read(bArr, i, i10);
    }

    @Override // w2.p
    public void readFully(byte[] bArr, int i, int i10) {
        ((p) this.f797w).readFully(bArr, i, i10);
    }

    @Override // w2.p
    public long s() {
        return ((p) this.f797w).s() - this.f796v;
    }

    @Override // o8.d
    public void t(Exception exc) {
        n0 n0Var = (n0) this.f797w;
        n0Var.f7328c.set(this.f796v);
    }

    public String toString() {
        switch (this.f795u) {
            case 8:
                if (((a) this.f797w) == null) {
                    return Long.toBinaryString(this.f796v);
                }
                return ((a) this.f797w).toString() + "xx" + Long.toBinaryString(this.f796v);
            default:
                return super.toString();
        }
    }

    @Override // d2.h
    public long u(long j5, long j8) {
        return -9223372036854775807L;
    }

    @Override // d2.h
    public j v(long j5) {
        return new j(((k) this.f797w).f13647c[(int) j5], r1.f13646b[r7], null);
    }

    @Override // w2.p
    public void w(byte[] bArr, int i, int i10) {
        ((p) this.f797w).w(bArr, i, i10);
    }

    @Override // d2.h
    public boolean x() {
        return true;
    }

    @Override // d2.h
    public long y() {
        return 0L;
    }

    @Override // d2.h
    public long z(long j5) {
        return ((k) this.f797w).f13645a;
    }

    public a(x7.a aVar) {
        this.f795u = 6;
        v.h(aVar);
        this.f797w = aVar;
    }

    public a(hf.h hVar) {
        this.f795u = 0;
        be.h.e(hVar, "source");
        this.f797w = hVar;
        this.f796v = 262144L;
    }

    public a(p pVar, long j5) {
        this.f795u = 3;
        this.f797w = pVar;
        s1.d.b(pVar.getPosition() >= j5);
        this.f796v = j5;
    }

    public a(k kVar, long j5) {
        this.f795u = 1;
        this.f797w = kVar;
        this.f796v = j5;
    }

    public a(int i) {
        this.f795u = i;
        switch (i) {
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f797w = Collections.synchronizedList(new ArrayList());
                break;
            case 8:
                this.f796v = 0L;
                break;
        }
    }
}
