package e3;

import aa.c1;
import aa.h0;
import aa.j0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import q3.n;
import s1.u;
import w2.l;
import w2.o;
import w2.p;
import w2.q;
import w2.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f4374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4377e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l3.a f4378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f4379h;
    public af.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f4380j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f4373a = new u(2);
    public long f = -1;

    public final void b() {
        q qVar = this.f4374b;
        qVar.getClass();
        qVar.e();
        this.f4374b.j(new t(-9223372036854775807L));
        this.f4375c = 6;
    }

    @Override // w2.o
    public final void c(q qVar) {
        this.f4374b = qVar;
    }

    @Override // w2.o
    public final boolean e(p pVar) throws EOFException, InterruptedIOException {
        l lVar = (l) pVar;
        u uVar = this.f4373a;
        uVar.G(2);
        lVar.r(uVar.f11709a, 0, 2, false);
        if (uVar.D() == 65496) {
            uVar.G(2);
            lVar.r(uVar.f11709a, 0, 2, false);
            int iD = uVar.D();
            this.f4376d = iD;
            if (iD == 65504) {
                uVar.G(2);
                lVar.r(uVar.f11709a, 0, 2, false);
                lVar.b(uVar.D() - 2, false);
                uVar.G(2);
                lVar.r(uVar.f11709a, 0, 2, false);
                this.f4376d = uVar.D();
            }
            if (this.f4376d == 65505) {
                return true;
            }
        }
        return false;
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        if (j5 == 0) {
            this.f4375c = 0;
            this.f4380j = null;
        } else if (this.f4375c == 5) {
            n nVar = this.f4380j;
            nVar.getClass();
            nVar.f(j5, j8);
        }
    }

    @Override // w2.o
    public final List g() {
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0179  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r26, w2.s r27) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.b.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final void release() {
        n nVar = this.f4380j;
        if (nVar != null) {
            nVar.getClass();
        }
    }

    @Override // w2.o
    public final o a() {
        return this;
    }
}
