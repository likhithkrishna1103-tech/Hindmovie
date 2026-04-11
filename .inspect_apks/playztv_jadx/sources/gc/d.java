package gc;

import a2.a1;
import a2.z0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2.e f5373a = new s2.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5374b = ((long) 60000) * 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5375c = ((long) 120000) * 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5376d = 2500000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5377e = 5000000;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5378g;

    @Override // a2.a1
    public final void a(b2.o oVar) {
        this.f = 0;
        this.f5378g = false;
        s2.e eVar = this.f5373a;
        synchronized (eVar) {
            if (eVar.f11732a) {
                eVar.b(0);
            }
        }
    }

    @Override // a2.a1
    public final void b(b2.o oVar) {
        this.f = 0;
        this.f5378g = false;
        s2.e eVar = this.f5373a;
        synchronized (eVar) {
            if (eVar.f11732a) {
                eVar.b(0);
            }
        }
    }

    @Override // a2.a1
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC] */
    @Override // a2.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(a2.z0 r8, r2.r[] r9) {
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
            p1.g1 r4 = r2.k()
            int r4 = r4.f9764c
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
            p1.g1 r2 = r2.k()
            int r2 = r2.f9764c
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
            s2.e r9 = r7.f5373a
            r9.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.d.d(a2.z0, r2.r[]):void");
    }

    @Override // a2.a1
    public final boolean e() {
        return !this.f5378g;
    }

    @Override // a2.a1
    public final s2.e f() {
        return this.f5373a;
    }

    @Override // a2.a1
    public final boolean g(z0 z0Var) {
        long jB = b0.B(z0Var.f519b, z0Var.f520c);
        long j5 = z0Var.f521d ? this.f5377e : this.f5376d;
        return j5 <= 0 || jB >= j5;
    }

    @Override // a2.a1
    public final void h(b2.o oVar) {
        this.f = 0;
        this.f5378g = false;
    }

    @Override // a2.a1
    public final long i() {
        return 0L;
    }

    @Override // a2.a1
    public final boolean j(z0 z0Var) {
        long jB = b0.B(z0Var.f519b, z0Var.f520c);
        boolean z2 = false;
        char c9 = jB > this.f5375c ? (char) 0 : jB < this.f5374b ? (char) 2 : (char) 1;
        boolean z10 = this.f5373a.a() >= this.f;
        if (c9 == 2 || (c9 == 1 && !z10)) {
            z2 = true;
        }
        this.f5378g = z2;
        return z2;
    }
}
