package o2;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f9192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pb.c f9193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k8.b0 f9194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9196e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f9197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f9198h;
    public boolean i;

    public q(pb.c cVar) {
        this(cVar, new w2.m());
    }

    public static c0 e(Class cls, v1.g gVar) {
        try {
            return (c0) cls.getConstructor(v1.g.class).newInstance(gVar);
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // o2.c0
    public final c0 a(boolean z2) {
        this.i = z2;
        p pVar = this.f9192a;
        pVar.f9184u = z2;
        w2.m mVar = (w2.m) pVar.f9185v;
        synchronized (mVar) {
            mVar.f13659v = z2;
        }
        Iterator it = ((HashMap) pVar.f9187x).values().iterator();
        while (it.hasNext()) {
            ((c0) it.next()).a(z2);
        }
        return this;
    }

    @Override // o2.c0
    public final c0 b() {
        p pVar = this.f9192a;
        pVar.getClass();
        synchronized (((w2.m) pVar.f9185v)) {
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
    @Override // o2.c0
    public final a c(p1.g0 g0Var) {
        boolean z2;
        boolean z10;
        p1.c0 c0Var;
        long j5;
        Uri uri;
        String str;
        p1.u uVar;
        String str2;
        p1.g0 g0Var2 = g0Var;
        g0Var2.f9757b.getClass();
        String scheme = g0Var2.f9757b.f9665a.getScheme();
        if (scheme != null && scheme.equals("ssai")) {
            throw null;
        }
        if (Objects.equals(g0Var2.f9757b.f9666b, "application/x-image-uri")) {
            long j8 = g0Var2.f9757b.f9671h;
            int i = s1.b0.f11647a;
            throw null;
        }
        p1.c0 c0Var2 = g0Var2.f9757b;
        int iG = s1.b0.G(c0Var2.f9665a, c0Var2.f9666b);
        if (g0Var2.f9757b.f9671h != -9223372036854775807L) {
            w2.m mVar = (w2.m) this.f9192a.f9185v;
            synchronized (mVar) {
                mVar.f13661x = 1;
            }
        }
        try {
            p pVar = this.f9192a;
            HashMap map = (HashMap) pVar.f9187x;
            c0 c0Var3 = (c0) map.get(Integer.valueOf(iG));
            if (c0Var3 == null) {
                c0Var3 = (c0) pVar.b(iG).get();
                c0Var3.d((k8.b0) pVar.f9189z);
                c0Var3.a(pVar.f9184u);
                c0Var3.b();
                map.put(Integer.valueOf(iG), c0Var3);
            }
            e2.t tVarA = g0Var2.f9758c.a();
            p1.b0 b0Var = g0Var2.f9758c;
            if (b0Var.f9653a == -9223372036854775807L) {
                tVarA.f4363a = this.f9195d;
            }
            if (b0Var.f9656d == -3.4028235E38f) {
                tVarA.f4366d = this.f9197g;
            }
            if (b0Var.f9657e == -3.4028235E38f) {
                tVarA.f4367e = this.f9198h;
            }
            if (b0Var.f9654b == -9223372036854775807L) {
                tVarA.f4364b = this.f9196e;
            }
            if (b0Var.f9655c == -9223372036854775807L) {
                tVarA.f4365c = this.f;
            }
            p1.b0 b0Var2 = new p1.b0(tVarA);
            if (b0Var2.equals(g0Var2.f9758c)) {
                z2 = true;
                z10 = false;
            } else {
                p1.z zVar = new p1.z();
                List list = Collections.EMPTY_LIST;
                aa.j0 j0Var = aa.c1.f650y;
                p1.d0 d0Var = p1.d0.f9694d;
                p1.y yVar = g0Var2.f9760e;
                p1.w wVar = new p1.w();
                wVar.f10087a = yVar.f10101b;
                wVar.f10088b = yVar.f10103d;
                wVar.f10089c = yVar.f10104e;
                wVar.f10090d = yVar.f;
                wVar.f10091e = yVar.f10105g;
                wVar.f = yVar.f10106h;
                String str3 = g0Var2.f9756a;
                p1.j0 j0Var2 = g0Var2.f9759d;
                g0Var2.f9758c.a();
                p1.d0 d0Var2 = g0Var2.f;
                p1.c0 c0Var4 = g0Var2.f9757b;
                if (c0Var4 != null) {
                    String str4 = c0Var4.f;
                    String str5 = c0Var4.f9666b;
                    Uri uri2 = c0Var4.f9665a;
                    list = c0Var4.f9669e;
                    j0Var = c0Var4.f9670g;
                    c0Var = null;
                    p1.a0 a0Var = c0Var4.f9667c;
                    p1.z zVarA = a0Var != null ? a0Var.a() : new p1.z();
                    z10 = false;
                    p1.u uVar2 = c0Var4.f9668d;
                    z2 = true;
                    str2 = str4;
                    zVar = zVarA;
                    j5 = c0Var4.f9671h;
                    uri = uri2;
                    uVar = uVar2;
                    str = str5;
                } else {
                    c0Var = null;
                    z2 = true;
                    z10 = false;
                    j5 = -9223372036854775807L;
                    uri = null;
                    str = null;
                    uVar = null;
                    str2 = null;
                }
                List list2 = list;
                aa.j0 j0Var3 = j0Var;
                e2.t tVarA2 = b0Var2.a();
                s1.d.g((zVar.f10114b == null || zVar.f10113a != null) ? z2 : z10 ? 1 : 0);
                p1.c0 c0Var5 = uri != null ? new p1.c0(uri, str, zVar.f10113a != null ? new p1.a0(zVar) : c0Var, uVar, list2, str2, j0Var3, j5) : c0Var;
                if (str3 == null) {
                    str3 = "";
                }
                String str6 = str3;
                p1.y yVar2 = new p1.y(wVar);
                p1.b0 b0Var3 = new p1.b0(tVarA2);
                if (j0Var2 == null) {
                    j0Var2 = p1.j0.K;
                }
                g0Var2 = new p1.g0(str6, yVar2, c0Var5, b0Var3, j0Var2, d0Var2);
            }
            a aVarC = c0Var3.c(g0Var2);
            aa.j0 j0Var4 = g0Var2.f9757b.f9670g;
            if (!j0Var4.isEmpty()) {
                a[] aVarArr = new a[j0Var4.size() + 1];
                aVarArr[z10 ? 1 : 0] = aVarC;
                for (int i10 = z10 ? 1 : 0; i10 < j0Var4.size(); i10++) {
                    if (this.i) {
                        p1.p pVar2 = new p1.p();
                        pVar2.f9967m = p1.m0.p(((p1.f0) j0Var4.get(i10)).f9736b);
                        pVar2.f9960d = ((p1.f0) j0Var4.get(i10)).f9737c;
                        pVar2.f9961e = ((p1.f0) j0Var4.get(i10)).f9738d;
                        pVar2.f = ((p1.f0) j0Var4.get(i10)).f9739e;
                        pVar2.f9958b = ((p1.f0) j0Var4.get(i10)).f;
                        pVar2.f9957a = ((p1.f0) j0Var4.get(i10)).f9740g;
                        p1.q qVar = new p1.q(pVar2);
                        b2.b bVar = new b2.b(this, 16, qVar);
                        pb.c cVar = this.f9193b;
                        nc.c cVar2 = new nc.c(2, bVar);
                        a7.b bVar2 = new a7.b(18);
                        k8.a0 a0Var2 = new k8.a0(25);
                        if (this.f9194c.d(qVar)) {
                            p1.p pVarA = qVar.a();
                            pVarA.f9967m = p1.m0.p("application/x-media3-cues");
                            pVarA.f9964j = qVar.f10023n;
                            pVarA.K = this.f9194c.e(qVar);
                            qVar = new p1.q(pVarA);
                        }
                        p1.g0 g0VarB = p1.g0.b(((p1.f0) j0Var4.get(i10)).f9735a.toString());
                        g0VarB.f9757b.getClass();
                        aVarArr[i10 + 1] = new x0(g0VarB, cVar, cVar2, bVar2.b(g0VarB), a0Var2, 1048576, qVar);
                    } else {
                        pb.c cVar3 = this.f9193b;
                        cVar3.getClass();
                        aVarArr[i10 + 1] = new k1((p1.f0) j0Var4.get(i10), cVar3, new k8.a0(25));
                    }
                }
                aVarC = new o0(aVarArr);
            }
            p1.y yVar3 = g0Var2.f9760e;
            if (yVar3.f10101b != 0 || yVar3.f10103d != Long.MIN_VALUE || yVar3.f) {
                e eVar = new e(aVarC);
                long j10 = yVar3.f10101b;
                if (j10 >= 0) {
                    z10 = z2;
                }
                s1.d.b(z10);
                s1.d.g(!eVar.f9101h);
                eVar.f9096b = j10;
                long j11 = yVar3.f10103d;
                s1.d.g(!eVar.f9101h);
                eVar.f9097c = j11;
                boolean z11 = !yVar3.f10105g;
                s1.d.g(!eVar.f9101h);
                eVar.f9098d = z11;
                boolean z12 = yVar3.f10104e;
                s1.d.g(!eVar.f9101h);
                eVar.f9099e = z12;
                boolean z13 = yVar3.f;
                s1.d.g(!eVar.f9101h);
                eVar.f = z13;
                boolean z14 = yVar3.f10106h;
                s1.d.g(!eVar.f9101h);
                eVar.f9100g = z14;
                eVar.f9101h = z2;
                aVarC = new h(eVar);
            }
            g0Var2.f9757b.getClass();
            if (g0Var2.f9757b.f9668d == null) {
                return aVarC;
            }
            s1.b.p("DMediaSourceFactory", "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return aVarC;
        } catch (ClassNotFoundException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // o2.c0
    public final c0 d(k8.b0 b0Var) {
        this.f9194c = b0Var;
        p pVar = this.f9192a;
        pVar.f9189z = b0Var;
        w2.m mVar = (w2.m) pVar.f9185v;
        synchronized (mVar) {
            mVar.f13660w = b0Var;
        }
        Iterator it = ((HashMap) pVar.f9187x).values().iterator();
        while (it.hasNext()) {
            ((c0) it.next()).d(b0Var);
        }
        return this;
    }

    public q(pb.c cVar, w2.m mVar) {
        this.f9193b = cVar;
        k8.b0 b0Var = new k8.b0(27);
        this.f9194c = b0Var;
        p pVar = new p(mVar, b0Var);
        this.f9192a = pVar;
        if (cVar != ((pb.c) pVar.f9188y)) {
            pVar.f9188y = cVar;
            ((HashMap) pVar.f9186w).clear();
            ((HashMap) pVar.f9187x).clear();
        }
        this.f9195d = -9223372036854775807L;
        this.f9196e = -9223372036854775807L;
        this.f = -9223372036854775807L;
        this.f9197g = -3.4028235E38f;
        this.f9198h = -3.4028235E38f;
        this.i = true;
    }
}
