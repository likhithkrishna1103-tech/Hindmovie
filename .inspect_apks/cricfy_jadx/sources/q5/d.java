package q5;

import g2.p0;
import g2.q0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.e f10368a = new w2.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10369b = ((long) 60000) * 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10370c = ((long) 120000) * 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10371d = 2500000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10372e = 5000000;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10373g;

    @Override // g2.q0
    public final void a(h2.l lVar) {
        this.f = 0;
        this.f10373g = false;
        w2.e eVar = this.f10368a;
        synchronized (eVar) {
            if (eVar.f13845a) {
                eVar.b(0);
            }
        }
    }

    @Override // g2.q0
    public final boolean b() {
        return false;
    }

    @Override // g2.q0
    public final boolean c(p0 p0Var) {
        long jB = a0.B(p0Var.f4876b, p0Var.f4877c);
        boolean z10 = false;
        char c9 = jB > this.f10370c ? (char) 0 : jB < this.f10369b ? (char) 2 : (char) 1;
        boolean z11 = this.f10368a.a() >= this.f;
        if (c9 == 2 || (c9 == 1 && !z11)) {
            z10 = true;
        }
        this.f10373g = z10;
        return z10;
    }

    @Override // g2.q0
    public final boolean d() {
        return !this.f10373g;
    }

    @Override // g2.q0
    public final boolean e(p0 p0Var) {
        long jB = a0.B(p0Var.f4876b, p0Var.f4877c);
        long j4 = p0Var.f4878d ? this.f10372e : this.f10371d;
        return j4 <= 0 || jB >= j4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC] */
    @Override // g2.q0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(g2.p0 r8, v2.q[] r9) {
        /*
            r7 = this;
            r8 = 0
            r7.f = r8
            int r0 = r9.length
            r1 = r8
        L5:
            if (r1 >= r0) goto L3e
            r2 = r9[r1]
            if (r2 == 0) goto L3b
            int r3 = r7.f
            v1.g1 r4 = r2.i()
            int r4 = r4.f12704c
            r5 = 13107200(0xc80000, float:1.8367099E-38)
            r6 = 131072(0x20000, float:1.83671E-40)
            switch(r4) {
                case -2: goto L28;
                case -1: goto L29;
                case 0: goto L25;
                case 1: goto L29;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L20;
                case 5: goto L20;
                case 6: goto L20;
                default: goto L1a;
            }
        L1a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>()
            throw r8
        L20:
            r5 = r6
            goto L29
        L22:
            r5 = 131072000(0x7d00000, float:3.1296362E-34)
            goto L29
        L25:
            r5 = 144310272(0x89a0000, float:9.268538E-34)
            goto L29
        L28:
            r5 = r8
        L29:
            int r3 = r3 + r5
            r7.f = r3
            v1.g1 r2 = r2.i()
            int r2 = r2.f12704c
            r3 = 2
            if (r2 != r3) goto L3b
            int r2 = r7.f
            int r2 = r2 * 4
            r7.f = r2
        L3b:
            int r1 = r1 + 1
            goto L5
        L3e:
            int r8 = r7.f
            w2.e r9 = r7.f10368a
            r9.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.d.f(g2.p0, v2.q[]):void");
    }

    @Override // g2.q0
    public final w2.e g() {
        return this.f10368a;
    }

    @Override // g2.q0
    public final void h(h2.l lVar) {
        this.f = 0;
        this.f10373g = false;
    }

    @Override // g2.q0
    public final long i() {
        return 0L;
    }

    @Override // g2.q0
    public final void j(h2.l lVar) {
        this.f = 0;
        this.f10373g = false;
        w2.e eVar = this.f10368a;
        synchronized (eVar) {
            if (eVar.f13845a) {
                eVar.b(0);
            }
        }
    }
}
