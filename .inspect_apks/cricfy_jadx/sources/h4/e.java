package h4;

import a3.i0;
import a3.k0;
import java.util.Arrays;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f5583x = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5584a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5588e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i0 f5590h;
    public i0 i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5594m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5595n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5598q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5599r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5601t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i0 f5603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f5604w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f5585b = new k0(7, new byte[7]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f5586c = new y1.t(Arrays.copyOf(f5583x, 10));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5596o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5597p = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f5600s = -9223372036854775807L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f5602u = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5591j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5592k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5593l = 256;

    public e(int i, String str, String str2, boolean z10) {
        this.f5584a = z10;
        this.f5587d = str;
        this.f5588e = i;
        this.f = str2;
    }

    @Override // h4.i
    public final void a() {
        this.f5602u = -9223372036854775807L;
        this.f5595n = false;
        this.f5591j = 0;
        this.f5592k = 0;
        this.f5593l = 256;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0207  */
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
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r24) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.e.b(y1.t):void");
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5602u = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5589g = g0Var.f5646e;
        g0Var.b();
        i0 i0VarP = rVar.p(g0Var.f5645d, 1);
        this.f5590h = i0VarP;
        this.f5603v = i0VarP;
        if (!this.f5584a) {
            this.i = new a3.o();
            return;
        }
        g0Var.a();
        g0Var.b();
        i0 i0VarP2 = rVar.p(g0Var.f5645d, 5);
        this.i = i0VarP2;
        v1.o oVar = new v1.o();
        g0Var.b();
        oVar.f12883a = g0Var.f5646e;
        oVar.f12892l = m0.p(this.f);
        oVar.f12893m = m0.p("application/id3");
        l0.e.s(oVar, i0VarP2);
    }

    @Override // h4.i
    public final void c(boolean z10) {
    }
}
