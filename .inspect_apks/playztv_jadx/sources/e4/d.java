package e4;

import aa.c1;
import aa.j0;
import java.util.List;
import w2.h0;
import w2.o;
import w2.p;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f4408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f4409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f4412e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4413g;

    @Override // w2.o
    public final void c(q qVar) {
        this.f4408a = qVar;
        this.f4409b = qVar.q(0, 1);
        qVar.e();
    }

    @Override // w2.o
    public final boolean e(p pVar) {
        return g.a(pVar);
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        this.f4410c = j5 == 0 ? 0 : 4;
        b bVar = this.f4412e;
        if (bVar != null) {
            bVar.b(j8);
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0213, code lost:
    
        if (r9 != 65534) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023a  */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(w2.p r21, w2.s r22) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.d.l(w2.p, w2.s):int");
    }

    @Override // w2.o
    public final o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
