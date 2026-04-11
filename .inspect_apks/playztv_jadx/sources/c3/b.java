package c3;

import aa.c1;
import aa.h0;
import aa.j0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import s1.u;
import w2.l;
import w2.n;
import w2.o;
import w2.p;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f2436a = new u(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f2437b = new u(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f2438c = new u(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f2439d = new u();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f2440e;
    public q f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2442h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f2448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f2449p;

    public b() {
        c cVar = new c(0, new n());
        cVar.f2450w = -9223372036854775807L;
        cVar.f2451x = new long[0];
        cVar.f2452y = new long[0];
        this.f2440e = cVar;
        this.f2441g = 1;
    }

    public final u b(p pVar) {
        int i = this.f2445l;
        u uVar = this.f2439d;
        byte[] bArr = uVar.f11709a;
        if (i > bArr.length) {
            uVar.H(0, new byte[Math.max(bArr.length * 2, i)]);
        } else {
            uVar.J(0);
        }
        uVar.I(this.f2445l);
        pVar.readFully(uVar.f11709a, 0, this.f2445l);
        return uVar;
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f = qVar;
    }

    @Override // w2.o
    public final boolean e(p pVar) throws EOFException, InterruptedIOException {
        u uVar = this.f2436a;
        l lVar = (l) pVar;
        lVar.r(uVar.f11709a, 0, 3, false);
        uVar.J(0);
        if (uVar.A() == 4607062) {
            lVar.r(uVar.f11709a, 0, 2, false);
            uVar.J(0);
            if ((uVar.D() & 250) == 0) {
                lVar.r(uVar.f11709a, 0, 4, false);
                uVar.J(0);
                int iJ = uVar.j();
                lVar.f13655z = 0;
                lVar.b(iJ, false);
                lVar.r(uVar.f11709a, 0, 4, false);
                uVar.J(0);
                if (uVar.j() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        if (j5 == 0) {
            this.f2441g = 1;
            this.f2442h = false;
        } else {
            this.f2441g = 3;
        }
        this.f2443j = 0;
    }

    @Override // w2.o
    public final List g() {
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017b  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r29, w2.s r30) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 1122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.b.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
