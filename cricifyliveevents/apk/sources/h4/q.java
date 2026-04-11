package h4;

import a3.i0;
import g2.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f5727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5729c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5732g;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i0 f5734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f5735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5736l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5738n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f5733h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0 f5730d = new l0(7);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l0 f5731e = new l0(8);
    public final l0 f = new l0(6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5737m = -9223372036854775807L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final y1.t f5739o = new y1.t();

    public q(d0 d0Var, boolean z10, boolean z11) {
        this.f5727a = d0Var;
        this.f5728b = z10;
        this.f5729c = z11;
    }

    @Override // h4.i
    public final void a() {
        this.f5732g = 0L;
        this.f5738n = false;
        this.f5737m = -9223372036854775807L;
        z1.o.a(this.f5733h);
        this.f5730d.g();
        this.f5731e.g();
        this.f.g();
        this.f5727a.f5582d.v(0);
        p pVar = this.f5735k;
        if (pVar != null) {
            pVar.f5718k = false;
            pVar.f5722o = false;
            o oVar = pVar.f5721n;
            oVar.f5697b = false;
            oVar.f5696a = false;
        }
    }

    @Override // h4.i
    public final void b(y1.t tVar) {
        int i;
        y1.d.h(this.f5734j);
        int i10 = y1.a0.f14551a;
        int i11 = tVar.f14610b;
        int i12 = tVar.f14611c;
        byte[] bArr = tVar.f14609a;
        this.f5732g += (long) tVar.a();
        this.f5734j.a(tVar.a(), tVar);
        while (true) {
            int iB = z1.o.b(bArr, i11, i12, this.f5733h);
            if (iB == i12) {
                g(bArr, i11, i12);
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
                g(bArr, i11, iB);
            }
            int i15 = i12 - iB;
            long j4 = this.f5732g - ((long) i15);
            f(i15, i14 < 0 ? -i14 : 0, j4, this.f5737m);
            h(i13, j4, this.f5737m);
            i11 = iB + i;
        }
    }

    @Override // h4.i
    public final void c(boolean z10) {
        y1.d.h(this.f5734j);
        int i = y1.a0.f14551a;
        if (z10) {
            this.f5727a.f5582d.v(0);
            f(0, 0, this.f5732g, this.f5737m);
            h(9, this.f5732g, this.f5737m);
            f(0, 0, this.f5732g, this.f5737m);
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5737m = j4;
        this.f5738n = ((i & 2) != 0) | this.f5738n;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.i = g0Var.f5646e;
        g0Var.b();
        i0 i0VarP = rVar.p(g0Var.f5645d, 2);
        this.f5734j = i0VarP;
        this.f5735k = new p(i0VarP, this.f5728b, this.f5729c);
        this.f5727a.b(rVar, g0Var);
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
    public final void f(int r26, int r27, long r28, long r30) {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.q.f(int, int, long, long):void");
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
    public final void g(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.q.g(byte[], int, int):void");
    }

    public final void h(int i, long j4, long j7) {
        if (!this.f5736l || this.f5735k.f5712c) {
            this.f5730d.h(i);
            this.f5731e.h(i);
        }
        this.f.h(i);
        p pVar = this.f5735k;
        boolean z10 = this.f5738n;
        pVar.i = i;
        pVar.f5719l = j7;
        pVar.f5717j = j4;
        pVar.f5726s = z10;
        if (!pVar.f5711b || i != 1) {
            if (!pVar.f5712c) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        o oVar = pVar.f5720m;
        pVar.f5720m = pVar.f5721n;
        pVar.f5721n = oVar;
        oVar.f5697b = false;
        oVar.f5696a = false;
        pVar.f5716h = 0;
        pVar.f5718k = true;
    }
}
