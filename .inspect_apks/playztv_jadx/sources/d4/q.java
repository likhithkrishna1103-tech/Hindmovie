package d4;

import a2.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f3964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3966c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3969g;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w2.h0 f3971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f3972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3973l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3975n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f3970h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0 f3967d = new u0(7);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u0 f3968e = new u0(8);
    public final u0 f = new u0(6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3974m = -9223372036854775807L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s1.u f3976o = new s1.u();

    public q(d0 d0Var, boolean z2, boolean z10) {
        this.f3964a = d0Var;
        this.f3965b = z2;
        this.f3966c = z10;
    }

    @Override // d4.i
    public final void a() {
        this.f3969g = 0L;
        this.f3975n = false;
        this.f3974m = -9223372036854775807L;
        t1.p.a(this.f3970h);
        this.f3967d.g();
        this.f3968e.g();
        this.f.g();
        this.f3964a.f3813d.i(0);
        p pVar = this.f3972k;
        if (pVar != null) {
            pVar.f3955k = false;
            pVar.f3959o = false;
            o oVar = pVar.f3958n;
            oVar.f3934b = false;
            oVar.f3933a = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(int r26, int r27, long r28, long r30) {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.q.b(int, int, long, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.q.c(byte[], int, int):void");
    }

    @Override // d4.i
    public final void d(s1.u uVar) {
        int i;
        s1.d.h(this.f3971j);
        int i10 = s1.b0.f11647a;
        int i11 = uVar.f11710b;
        int i12 = uVar.f11711c;
        byte[] bArr = uVar.f11709a;
        this.f3969g += (long) uVar.a();
        this.f3971j.f(uVar.a(), uVar);
        while (true) {
            int iB = t1.p.b(bArr, i11, i12, this.f3970h);
            if (iB == i12) {
                c(bArr, i11, i12);
                return;
            }
            int i13 = bArr[iB + 3] & 31;
            if (iB <= 0 || bArr[iB - 1] != 0) {
                i = 3;
            } else {
                iB--;
                i = 4;
            }
            int i14 = iB - i11;
            if (i14 > 0) {
                c(bArr, i11, iB);
            }
            int i15 = i12 - iB;
            long j5 = this.f3969g - ((long) i15);
            b(i15, i14 < 0 ? -i14 : 0, j5, this.f3974m);
            h(i13, j5, this.f3974m);
            i11 = iB + i;
        }
    }

    @Override // d4.i
    public final void e(boolean z2) {
        s1.d.h(this.f3971j);
        int i = s1.b0.f11647a;
        if (z2) {
            this.f3964a.f3813d.i(0);
            b(0, 0, this.f3969g, this.f3974m);
            h(9, this.f3969g, this.f3974m);
            b(0, 0, this.f3969g, this.f3974m);
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3974m = j5;
        this.f3975n = ((i & 2) != 0) | this.f3975n;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.i = h0Var.f3889e;
        h0Var.b();
        w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 2);
        this.f3971j = h0VarQ;
        this.f3972k = new p(h0VarQ, this.f3965b, this.f3966c);
        this.f3964a.b(qVar, h0Var);
    }

    public final void h(int i, long j5, long j8) {
        if (!this.f3973l || this.f3972k.f3949c) {
            this.f3967d.h(i);
            this.f3968e.h(i);
        }
        this.f.h(i);
        p pVar = this.f3972k;
        boolean z2 = this.f3975n;
        pVar.i = i;
        pVar.f3956l = j8;
        pVar.f3954j = j5;
        pVar.f3963s = z2;
        if (!pVar.f3948b || i != 1) {
            if (!pVar.f3949c) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        o oVar = pVar.f3957m;
        pVar.f3957m = pVar.f3958n;
        pVar.f3958n = oVar;
        oVar.f3934b = false;
        oVar.f3933a = false;
        pVar.f3953h = 0;
        pVar.f3955k = true;
    }
}
