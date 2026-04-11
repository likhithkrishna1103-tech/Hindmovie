package s2;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n8.k f11285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l4.c0 f11286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x3.e f11287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11289e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f11291h;
    public boolean i;

    public p(l4.c0 c0Var) {
        this(c0Var, new a3.n());
    }

    public static b0 e(Class cls, b2.g gVar) {
        try {
            return (b0) cls.getConstructor(b2.g.class).newInstance(gVar);
        } catch (Exception e9) {
            throw new IllegalStateException(e9);
        }
    }

    @Override // s2.b0
    public final b0 a(boolean z10) {
        this.i = z10;
        n8.k kVar = this.f11285a;
        kVar.f8884v = z10;
        a3.n nVar = (a3.n) kVar.f8885w;
        synchronized (nVar) {
            nVar.f222w = z10;
        }
        Iterator it = ((HashMap) kVar.f8887y).values().iterator();
        while (it.hasNext()) {
            ((b0) it.next()).a(z10);
        }
        return this;
    }

    @Override // s2.b0
    public final b0 b() {
        n8.k kVar = this.f11285a;
        kVar.getClass();
        synchronized (((a3.n) kVar.f8885w)) {
        }
        return this;
    }

    @Override // s2.b0
    public final b0 c(x3.e eVar) {
        this.f11287c = eVar;
        n8.k kVar = this.f11285a;
        kVar.A = eVar;
        a3.n nVar = (a3.n) kVar.f8885w;
        synchronized (nVar) {
            nVar.f223x = eVar;
        }
        Iterator it = ((HashMap) kVar.f8887y).values().iterator();
        while (it.hasNext()) {
            ((b0) it.next()).c(eVar);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // s2.b0
    public final a d(v1.g0 g0Var) {
        boolean z10;
        boolean z11;
        v1.c0 c0Var;
        long j4;
        Uri uri;
        String str;
        v1.t tVar;
        String str2;
        v1.g0 g0Var2 = g0Var;
        g0Var2.f12697b.getClass();
        String scheme = g0Var2.f12697b.f12605a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            throw null;
        }
        if (Objects.equals(g0Var2.f12697b.f12606b, "application/x-image-uri")) {
            long j7 = g0Var2.f12697b.f12611h;
            int i = y1.a0.f14551a;
            throw null;
        }
        v1.c0 c0Var2 = g0Var2.f12697b;
        int iG = y1.a0.G(c0Var2.f12605a, c0Var2.f12606b);
        if (g0Var2.f12697b.f12611h != -9223372036854775807L) {
            a3.n nVar = (a3.n) this.f11285a.f8885w;
            synchronized (nVar) {
                nVar.f224y = 1;
            }
        }
        try {
            n8.k kVar = this.f11285a;
            HashMap map = (HashMap) kVar.f8887y;
            b0 b0Var = (b0) map.get(Integer.valueOf(iG));
            if (b0Var == null) {
                b0Var = (b0) kVar.b(iG).get();
                b0Var.c((x3.e) kVar.A);
                b0Var.a(kVar.f8884v);
                b0Var.b();
                map.put(Integer.valueOf(iG), b0Var);
            }
            k2.t tVarA = g0Var2.f12698c.a();
            v1.a0 a0Var = g0Var2.f12698c;
            if (a0Var.f12571a == -9223372036854775807L) {
                tVarA.f6892a = this.f11288d;
            }
            if (a0Var.f12574d == -3.4028235E38f) {
                tVarA.f6895d = this.f11290g;
            }
            if (a0Var.f12575e == -3.4028235E38f) {
                tVarA.f6896e = this.f11291h;
            }
            if (a0Var.f12572b == -9223372036854775807L) {
                tVarA.f6893b = this.f11289e;
            }
            if (a0Var.f12573c == -9223372036854775807L) {
                tVarA.f6894c = this.f;
            }
            v1.a0 a0Var2 = new v1.a0(tVarA);
            if (a0Var2.equals(g0Var2.f12698c)) {
                z10 = true;
                z11 = false;
            } else {
                v1.y yVar = new v1.y();
                List list = Collections.EMPTY_LIST;
                ua.i0 i0Var = ua.z0.f12413z;
                v1.d0 d0Var = v1.d0.f12622d;
                v1.x xVar = g0Var2.f12700e;
                v1.v vVar = new v1.v();
                vVar.f13001a = xVar.f13029b;
                vVar.f13002b = xVar.f13031d;
                vVar.f13003c = xVar.f13032e;
                vVar.f13004d = xVar.f;
                vVar.f13005e = xVar.f13033g;
                vVar.f = xVar.f13034h;
                String str3 = g0Var2.f12696a;
                v1.j0 j0Var = g0Var2.f12699d;
                g0Var2.f12698c.a();
                v1.d0 d0Var2 = g0Var2.f;
                v1.c0 c0Var3 = g0Var2.f12697b;
                if (c0Var3 != null) {
                    String str4 = c0Var3.f;
                    String str5 = c0Var3.f12606b;
                    Uri uri2 = c0Var3.f12605a;
                    list = c0Var3.f12609e;
                    i0Var = c0Var3.f12610g;
                    c0Var = null;
                    v1.z zVar = c0Var3.f12607c;
                    v1.y yVarA = zVar != null ? zVar.a() : new v1.y();
                    z11 = false;
                    v1.t tVar2 = c0Var3.f12608d;
                    z10 = true;
                    str2 = str4;
                    yVar = yVarA;
                    j4 = c0Var3.f12611h;
                    uri = uri2;
                    tVar = tVar2;
                    str = str5;
                } else {
                    c0Var = null;
                    z10 = true;
                    z11 = false;
                    j4 = -9223372036854775807L;
                    uri = null;
                    str = null;
                    tVar = null;
                    str2 = null;
                }
                List list2 = list;
                ua.i0 i0Var2 = i0Var;
                k2.t tVarA2 = a0Var2.a();
                y1.d.g((yVar.f13038b == null || yVar.f13037a != null) ? z10 : z11 ? 1 : 0);
                v1.c0 c0Var4 = uri != null ? new v1.c0(uri, str, yVar.f13037a != null ? new v1.z(yVar) : c0Var, tVar, list2, str2, i0Var2, j4) : c0Var;
                if (str3 == null) {
                    str3 = "";
                }
                String str6 = str3;
                v1.x xVar2 = new v1.x(vVar);
                v1.a0 a0Var3 = new v1.a0(tVarA2);
                if (j0Var == null) {
                    j0Var = v1.j0.K;
                }
                g0Var2 = new v1.g0(str6, xVar2, c0Var4, a0Var3, j0Var, d0Var2);
            }
            a aVarD = b0Var.d(g0Var2);
            ua.i0 i0Var3 = g0Var2.f12697b.f12610g;
            if (!i0Var3.isEmpty()) {
                a[] aVarArr = new a[i0Var3.size() + 1];
                aVarArr[z11 ? 1 : 0] = aVarD;
                for (int i10 = z11 ? 1 : 0; i10 < i0Var3.size(); i10++) {
                    if (this.i) {
                        v1.o oVar = new v1.o();
                        oVar.f12893m = v1.m0.p(((v1.f0) i0Var3.get(i10)).f12669b);
                        oVar.f12886d = ((v1.f0) i0Var3.get(i10)).f12670c;
                        oVar.f12887e = ((v1.f0) i0Var3.get(i10)).f12671d;
                        oVar.f = ((v1.f0) i0Var3.get(i10)).f12672e;
                        oVar.f12884b = ((v1.f0) i0Var3.get(i10)).f;
                        oVar.f12883a = ((v1.f0) i0Var3.get(i10)).f12673g;
                        v1.p pVar = new v1.p(oVar);
                        androidx.fragment.app.e eVar = new androidx.fragment.app.e(23, this, pVar);
                        l4.c0 c0Var5 = this.f11286b;
                        kb.d dVar = new kb.d(12, eVar);
                        androidx.emoji2.text.v vVar2 = new androidx.emoji2.text.v(29);
                        f9.a0 a0Var4 = new f9.a0(28);
                        if (this.f11287c.e(pVar)) {
                            v1.o oVarA = pVar.a();
                            oVarA.f12893m = v1.m0.p("application/x-media3-cues");
                            oVarA.f12890j = pVar.f12946n;
                            oVarA.K = this.f11287c.b(pVar);
                            pVar = new v1.p(oVarA);
                        }
                        v1.g0 g0VarB = v1.g0.b(((v1.f0) i0Var3.get(i10)).f12668a.toString());
                        g0VarB.f12697b.getClass();
                        aVarArr[i10 + 1] = new v0(g0VarB, c0Var5, dVar, vVar2.d(g0VarB), a0Var4, 1048576, pVar);
                    } else {
                        l4.c0 c0Var6 = this.f11286b;
                        c0Var6.getClass();
                        aVarArr[i10 + 1] = new i1((v1.f0) i0Var3.get(i10), c0Var6, new f9.a0(28));
                    }
                }
                aVarD = new m0(aVarArr);
            }
            v1.x xVar3 = g0Var2.f12700e;
            if (xVar3.f13029b != 0 || xVar3.f13031d != Long.MIN_VALUE || xVar3.f) {
                e eVar2 = new e(aVarD);
                long j10 = xVar3.f13029b;
                if (j10 >= 0) {
                    z11 = z10;
                }
                y1.d.b(z11);
                y1.d.g(!eVar2.f11175h);
                eVar2.f11170b = j10;
                long j11 = xVar3.f13031d;
                y1.d.g(!eVar2.f11175h);
                eVar2.f11171c = j11;
                boolean z12 = !xVar3.f13033g;
                y1.d.g(!eVar2.f11175h);
                eVar2.f11172d = z12;
                boolean z13 = xVar3.f13032e;
                y1.d.g(!eVar2.f11175h);
                eVar2.f11173e = z13;
                boolean z14 = xVar3.f;
                y1.d.g(!eVar2.f11175h);
                eVar2.f = z14;
                boolean z15 = xVar3.f13034h;
                y1.d.g(!eVar2.f11175h);
                eVar2.f11174g = z15;
                eVar2.f11175h = z10;
                aVarD = new h(eVar2);
            }
            g0Var2.f12697b.getClass();
            if (g0Var2.f12697b.f12608d == null) {
                return aVarD;
            }
            y1.b.p("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return aVarD;
        } catch (ClassNotFoundException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public p(l4.c0 c0Var, a3.n nVar) {
        this.f11286b = c0Var;
        x3.e eVar = new x3.e();
        this.f11287c = eVar;
        n8.k kVar = new n8.k(nVar, eVar);
        this.f11285a = kVar;
        if (c0Var != ((l4.c0) kVar.f8888z)) {
            kVar.f8888z = c0Var;
            ((HashMap) kVar.f8886x).clear();
            ((HashMap) kVar.f8887y).clear();
        }
        this.f11288d = -9223372036854775807L;
        this.f11289e = -9223372036854775807L;
        this.f = -9223372036854775807L;
        this.f11290g = -3.4028235E38f;
        this.f11291h = -3.4028235E38f;
        this.i = true;
    }
}
