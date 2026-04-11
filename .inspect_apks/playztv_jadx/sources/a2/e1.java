package a2;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o2.c1[] f195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f197e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f1 f198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f199h;
    public final boolean[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final g[] f200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r2.u f201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t1 f202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e1 f203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o2.n1 f204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public r2.v f205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f206p;

    public e1(g[] gVarArr, long j5, r2.u uVar, s2.e eVar, t1 t1Var, f1 f1Var, r2.v vVar) {
        this.f200j = gVarArr;
        this.f206p = j5;
        this.f201k = uVar;
        this.f202l = t1Var;
        o2.d0 d0Var = f1Var.f221a;
        this.f194b = d0Var.f9090a;
        this.f198g = f1Var;
        this.f204n = o2.n1.f9176d;
        this.f205o = vVar;
        this.f195c = new o2.c1[gVarArr.length];
        this.i = new boolean[gVarArr.length];
        long j8 = f1Var.f222b;
        long j10 = f1Var.f224d;
        boolean z2 = f1Var.f;
        t1Var.getClass();
        Object obj = d0Var.f9090a;
        int i = z1.f523n;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        o2.d0 d0VarA = d0Var.a(pair.second);
        s1 s1Var = (s1) ((HashMap) t1Var.f415e).get(obj2);
        s1Var.getClass();
        ((HashSet) t1Var.f417h).add(s1Var);
        r1 r1Var = (r1) ((HashMap) t1Var.f).get(s1Var);
        if (r1Var != null) {
            r1Var.f393a.g(r1Var.f394b);
        }
        s1Var.f403c.add(d0VarA);
        o2.b0 b0VarH = s1Var.f401a.c(d0VarA, eVar, j8);
        ((IdentityHashMap) t1Var.f414d).put(b0VarH, s1Var);
        t1Var.d();
        this.f193a = j10 != -9223372036854775807L ? new o2.d(b0VarH, !z2, 0L, j10) : b0VarH;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, o2.b0] */
    public final long a(r2.v vVar, long j5, boolean z2, boolean[] zArr) {
        g[] gVarArr;
        o2.c1[] c1VarArr;
        int i = 0;
        while (true) {
            boolean z10 = true;
            if (i >= vVar.f11357a) {
                break;
            }
            if (z2 || !vVar.a(this.f205o, i)) {
                z10 = false;
            }
            this.i[i] = z10;
            i++;
        }
        int i10 = 0;
        while (true) {
            gVarArr = this.f200j;
            int length = gVarArr.length;
            c1VarArr = this.f195c;
            if (i10 >= length) {
                break;
            }
            if (gVarArr[i10].f232v == -2) {
                c1VarArr[i10] = null;
            }
            i10++;
        }
        b();
        this.f205o = vVar;
        c();
        long jN = this.f193a.n(vVar.f11359c, this.i, this.f195c, zArr, j5);
        for (int i11 = 0; i11 < gVarArr.length; i11++) {
            if (gVarArr[i11].f232v == -2 && this.f205o.b(i11)) {
                c1VarArr[i11] = new o2.r();
            }
        }
        this.f = false;
        for (int i12 = 0; i12 < c1VarArr.length; i12++) {
            if (c1VarArr[i12] != null) {
                s1.d.g(vVar.b(i12));
                if (gVarArr[i12].f232v != -2) {
                    this.f = true;
                }
            } else {
                s1.d.g(vVar.f11359c[i12] == null);
            }
        }
        return jN;
    }

    public final void b() {
        if (this.f203m != null) {
            return;
        }
        int i = 0;
        while (true) {
            r2.v vVar = this.f205o;
            if (i >= vVar.f11357a) {
                return;
            }
            boolean zB = vVar.b(i);
            r2.r rVar = this.f205o.f11359c[i];
            if (zB && rVar != null) {
                rVar.h();
            }
            i++;
        }
    }

    public final void c() {
        if (this.f203m != null) {
            return;
        }
        int i = 0;
        while (true) {
            r2.v vVar = this.f205o;
            if (i >= vVar.f11357a) {
                return;
            }
            boolean zB = vVar.b(i);
            r2.r rVar = this.f205o.f11359c[i];
            if (zB && rVar != null) {
                rVar.d();
            }
            i++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, o2.e1] */
    public final long d() {
        if (!this.f197e) {
            return this.f198g.f222b;
        }
        long jR = this.f ? this.f193a.r() : Long.MIN_VALUE;
        return jR == Long.MIN_VALUE ? this.f198g.f225e : jR;
    }

    public final long e() {
        return this.f198g.f222b + this.f206p;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, o2.b0] */
    public final void f(float f, p1.f1 f1Var, boolean z2) {
        this.f197e = true;
        this.f204n = this.f193a.p();
        r2.v vVarJ = j(f, f1Var, z2);
        f1 f1Var2 = this.f198g;
        long jMax = f1Var2.f222b;
        long j5 = f1Var2.f225e;
        if (j5 != -9223372036854775807L && jMax >= j5) {
            jMax = Math.max(0L, j5 - 1);
        }
        long jA = a(vVarJ, jMax, false, new boolean[this.f200j.length]);
        long j8 = this.f206p;
        f1 f1Var3 = this.f198g;
        this.f206p = (f1Var3.f222b - jA) + j8;
        this.f198g = f1Var3.b(jA);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, o2.e1] */
    public final boolean g() {
        if (this.f197e) {
            return !this.f || this.f193a.r() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean h() {
        if (this.f197e) {
            return g() || d() - this.f198g.f222b >= -9223372036854775807L;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, o2.b0] */
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
    public final void i() {
        b();
        ?? r02 = this.f193a;
        try {
            boolean z2 = r02 instanceof o2.d;
            t1 t1Var = this.f202l;
            if (z2) {
                t1Var.h(((o2.d) r02).f9084u);
            } else {
                t1Var.h(r02);
            }
        } catch (RuntimeException e10) {
            s1.b.h("MediaPeriodHolder", "Period release failed.", e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [int[], java.io.Serializable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v26, types: [r2.q] */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60, types: [r2.g] */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v63 */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v72 */
    /* JADX WARN: Type inference failed for: r5v3, types: [r2.q[]] */
    /* JADX WARN: Type inference failed for: r6v101 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v43, types: [r2.q] */
    /* JADX WARN: Type inference failed for: r7v62, types: [r2.q] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r8v74 */
    /* JADX WARN: Type inference failed for: r8v84 */
    public final r2.v j(float f, p1.f1 f1Var, boolean z2) {
        r2.j jVar;
        ?? r6;
        String str;
        p1.g1 g1Var;
        Pair pairJ;
        int[] iArr;
        ?? J;
        Object languageTag;
        CaptioningManager captioningManager;
        Locale locale;
        ?? J2;
        boolean z10;
        aa.c1 c1VarV;
        r2.r bVar;
        int i;
        int[] iArr2;
        p1.g1 g1Var2;
        int i10;
        Object qVar;
        int i11;
        int i12;
        Context context;
        int[] iArr3;
        r2.u uVar = this.f201k;
        g[] gVarArr = this.f200j;
        o2.n1 n1Var = this.f204n;
        uVar.getClass();
        int i13 = 1;
        int[] iArr4 = new int[gVarArr.length + 1];
        int length = gVarArr.length + 1;
        p1.g1[][] g1VarArr = new p1.g1[length][];
        int[][][] iArr5 = new int[gVarArr.length + 1][][];
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = n1Var.f9178a;
            g1VarArr[i14] = new p1.g1[i15];
            iArr5[i14] = new int[i15][];
        }
        int length2 = gVarArr.length;
        ?? r12 = new int[length2];
        for (int i16 = 0; i16 < length2; i16++) {
            r12[i16] = gVarArr[i16].B();
        }
        int i17 = 0;
        while (i17 < n1Var.f9178a) {
            p1.g1 g1VarA = n1Var.a(i17);
            int i18 = g1VarA.f9764c == 5 ? i13 : 0;
            int length3 = gVarArr.length;
            int i19 = i13;
            int i20 = 0;
            int i21 = 0;
            while (i20 < gVarArr.length) {
                g gVar = gVarArr[i20];
                r2.u uVar2 = uVar;
                o2.n1 n1Var2 = n1Var;
                int i22 = i13;
                int iMax = 0;
                for (int i23 = 0; i23 < g1VarA.f9762a; i23++) {
                    iMax = Math.max(iMax, gVar.A(g1VarA.f9765d[i23]) & 7);
                }
                int i24 = iArr4[i20] == 0 ? i22 : 0;
                if (iMax > i21 || (iMax == i21 && i18 != 0 && i19 == 0 && i24 != 0)) {
                    i21 = iMax;
                    i19 = i24;
                    length3 = i20;
                }
                i20++;
                i13 = i22;
                uVar = uVar2;
                n1Var = n1Var2;
            }
            r2.u uVar3 = uVar;
            o2.n1 n1Var3 = n1Var;
            int i25 = i13;
            if (length3 == gVarArr.length) {
                iArr3 = new int[g1VarA.f9762a];
            } else {
                g gVar2 = gVarArr[length3];
                int[] iArr6 = new int[g1VarA.f9762a];
                for (int i26 = 0; i26 < g1VarA.f9762a; i26++) {
                    iArr6[i26] = gVar2.A(g1VarA.f9765d[i26]);
                }
                iArr3 = iArr6;
            }
            int i27 = iArr4[length3];
            g1VarArr[length3][i27] = g1VarA;
            iArr5[length3][i27] = iArr3;
            iArr4[length3] = i27 + 1;
            i17++;
            i13 = i25;
            uVar = uVar3;
            n1Var = n1Var3;
        }
        r2.u uVar4 = uVar;
        int i28 = i13;
        int i29 = 0;
        o2.n1[] n1VarArr = new o2.n1[gVarArr.length];
        String[] strArr = new String[gVarArr.length];
        int[] iArr7 = new int[gVarArr.length];
        for (int i30 = 0; i30 < gVarArr.length; i30++) {
            int i31 = iArr4[i30];
            n1VarArr[i30] = new o2.n1((p1.g1[]) s1.b0.Q(i31, g1VarArr[i30]));
            iArr5[i30] = (int[][]) s1.b0.Q(i31, iArr5[i30]);
            strArr[i30] = gVarArr[i30].g();
            iArr7[i30] = gVarArr[i30].f232v;
        }
        r2.t tVar = new r2.t(iArr7, n1VarArr, r12, iArr5, new o2.n1((p1.g1[]) s1.b0.Q(iArr4[gVarArr.length], g1VarArr[gVarArr.length])));
        r2.p pVar = (r2.p) uVar4;
        synchronized (pVar.f11342c) {
            pVar.f11345g = Thread.currentThread();
            jVar = pVar.f;
        }
        if (pVar.f11347j == null && (context = pVar.f11343d) != null) {
            pVar.f11347j = Boolean.valueOf(s1.b0.M(context));
        }
        if (jVar.f11327t0 && Build.VERSION.SDK_INT >= 32 && pVar.f11346h == null) {
            pVar.f11346h = new c(pVar.f11343d, pVar, pVar.f11347j);
        }
        int i32 = tVar.f11350a;
        Context context2 = pVar.f11343d;
        ?? r52 = new r2.q[i32];
        int i33 = 0;
        while (true) {
            if (i33 >= tVar.f11350a) {
                r6 = 0;
                break;
            }
            if (2 == iArr7[i33] && n1VarArr[i33].f9178a > 0) {
                r6 = i28;
                break;
            }
            i33++;
        }
        Pair pairJ2 = r2.p.j(i28, tVar, iArr5, new ab.b(pVar, jVar, r6, r12), new c4.d(13));
        if (pairJ2 != null) {
            r52[((Integer) pairJ2.second).intValue()] = (r2.q) pairJ2.first;
        }
        if (pairJ2 == null) {
            str = null;
        } else {
            r2.q qVar2 = (r2.q) pairJ2.first;
            str = qVar2.f11348a.f9765d[qVar2.f11349b[0]].f10015d;
        }
        p1.j1 j1Var = jVar.f9929u;
        if (j1Var.f9863a == 2) {
            pairJ = null;
            g1Var = null;
        } else {
            g1Var = null;
            pairJ = r2.p.j(2, tVar, iArr5, new pc.f(jVar, str, r12, (!jVar.f9919k || context2 == null) ? null : s1.b0.u(context2)), new c4.d(12));
        }
        int i34 = 4;
        if ((jVar.A || pairJ == null) && j1Var.f9863a != 2) {
            iArr = iArr7;
            J = r2.p.j(4, tVar, iArr5, new nc.c(6, jVar), new c4.d(11));
        } else {
            iArr = iArr7;
            J = g1Var;
        }
        if (J != 0) {
            r52[((Integer) ((Pair) J).second).intValue()] = (r2.q) ((Pair) J).first;
        } else if (pairJ != null) {
            r52[((Integer) pairJ.second).intValue()] = (r2.q) pairJ.first;
        }
        int i35 = 3;
        if (j1Var.f9863a == 2) {
            J2 = g1Var;
        } else {
            if (!jVar.f9932x || context2 == null || (captioningManager = (CaptioningManager) context2.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                languageTag = g1Var;
            } else {
                int i36 = s1.b0.f11647a;
                languageTag = locale.toLanguageTag();
            }
            J2 = r2.p.j(3, tVar, iArr5, new dd.e(jVar, str, languageTag, 9), new c4.d(14));
        }
        if (J2 != 0) {
            r52[((Integer) ((Pair) J2).second).intValue()] = (r2.q) ((Pair) J2).first;
        }
        int i37 = 0;
        while (i37 < i32) {
            int i38 = iArr[i37];
            if (i38 == 2 || i38 == 1 || i38 == i35 || i38 == i34) {
                i10 = i37;
            } else {
                o2.n1 n1Var4 = n1VarArr[i37];
                int[][] iArr8 = iArr5[i37];
                if (j1Var.f9863a == 2) {
                    i10 = i37;
                } else {
                    int i39 = i29;
                    int i40 = i39;
                    p1.g1 g1Var3 = g1Var;
                    ?? r21 = g1Var3;
                    while (i39 < n1Var4.f9178a) {
                        p1.g1 g1VarA2 = n1Var4.a(i39);
                        int[] iArr9 = iArr8[i39];
                        int i41 = i37;
                        o2.n1 n1Var5 = n1Var4;
                        ?? r42 = r21;
                        int i42 = i40;
                        p1.g1 g1Var4 = g1Var3;
                        int i43 = i29;
                        while (i43 < g1VarA2.f9762a) {
                            int[][] iArr10 = iArr8;
                            if (l4.a.h(iArr9[i43], jVar.f11328u0)) {
                                i11 = i43;
                                r2.g gVar3 = new r2.g(g1VarA2.f9765d[i43], iArr9[i11]);
                                if (r42 != 0) {
                                    i12 = i39;
                                    if (aa.y.f763a.c(gVar3.f11318v, r42.f11318v).c(gVar3.f11317u, r42.f11317u).e() > 0) {
                                    }
                                } else {
                                    i12 = i39;
                                }
                                r42 = gVar3;
                                g1Var4 = g1VarA2;
                                i42 = i11;
                            } else {
                                i11 = i43;
                                i12 = i39;
                            }
                            i43 = i11 + 1;
                            iArr8 = iArr10;
                            i39 = i12;
                            r42 = r42;
                        }
                        i39++;
                        g1Var3 = g1Var4;
                        i40 = i42;
                        n1Var4 = n1Var5;
                        r21 = r42;
                        i37 = i41;
                    }
                    i10 = i37;
                    if (g1Var3 != null) {
                        qVar = new r2.q(i29, g1Var3, new int[]{i40});
                    }
                    r52[i10] = qVar;
                }
                qVar = g1Var;
                r52[i10] = qVar;
            }
            i37 = i10 + 1;
            i29 = 0;
            i35 = 3;
            i34 = 4;
        }
        int i44 = tVar.f11350a;
        o2.n1[] n1VarArr2 = tVar.f11352c;
        HashMap map = new HashMap();
        for (int i45 = 0; i45 < i44; i45++) {
            r2.p.c(n1VarArr2[i45], jVar, map);
        }
        r2.p.c(tVar.f, jVar, map);
        for (int i46 = 0; i46 < i44; i46++) {
            p1.h1 h1Var = (p1.h1) map.get(Integer.valueOf(tVar.f11351b[i46]));
            if (h1Var != null) {
                p1.g1 g1Var5 = h1Var.f9783a;
                aa.j0 j0Var = h1Var.f9784b;
                r52[i46] = (j0Var.isEmpty() || n1VarArr2[i46].b(g1Var5) == -1) ? g1Var : new r2.q(0, g1Var5, q1.c.S(j0Var));
            }
        }
        int i47 = tVar.f11350a;
        for (int i48 = 0; i48 < i47; i48++) {
            o2.n1 n1Var6 = tVar.f11352c[i48];
            Map map2 = (Map) jVar.f11330w0.get(i48);
            if (map2 != null && map2.containsKey(n1Var6)) {
                Map map3 = (Map) jVar.f11330w0.get(i48);
                if (map3 != null && map3.get(n1Var6) != null) {
                    throw new ClassCastException();
                }
                r52[i48] = g1Var;
            }
        }
        for (int i49 = 0; i49 < i32; i49++) {
            int i50 = tVar.f11351b[i49];
            if (jVar.f11331x0.get(i49) || jVar.E.contains(Integer.valueOf(i50))) {
                r52[i49] = g1Var;
            }
        }
        k8.z zVar = pVar.f11344e;
        s2.d dVar = pVar.f11356b;
        s1.d.h(dVar);
        zVar.getClass();
        ArrayList arrayList = new ArrayList();
        int i51 = 0;
        while (i51 < r52.length) {
            ?? r72 = r52[i51];
            if (r72 == 0 || r72.f11349b.length <= 1) {
                g1Var2 = g1Var;
                arrayList.add(g1Var2);
            } else {
                aa.g0 g0VarN = aa.j0.n();
                g0VarN.a(new r2.a(0L, 0L));
                arrayList.add(g0VarN);
                g1Var2 = g1Var;
            }
            i51++;
            g1Var = g1Var2;
        }
        int length4 = r52.length;
        long[][] jArr = new long[length4][];
        for (int i52 = 0; i52 < r52.length; i52++) {
            ?? r15 = r52[i52];
            if (r15 == 0) {
                jArr[i52] = new long[0];
            } else {
                int[] iArr11 = r15.f11349b;
                jArr[i52] = new long[iArr11.length];
                int i53 = 0;
                while (i53 < iArr11.length) {
                    int i54 = i53;
                    long j5 = r15.f11348a.f9765d[iArr11[i53]].f10019j;
                    long[] jArr2 = jArr[i52];
                    if (j5 == -1) {
                        j5 = 0;
                    }
                    jArr2[i54] = j5;
                    i53 = i54 + 1;
                }
                Arrays.sort(jArr[i52]);
            }
        }
        int[] iArr12 = new int[length4];
        long[] jArr3 = new long[length4];
        for (int i55 = 0; i55 < length4; i55++) {
            long[] jArr4 = jArr[i55];
            jArr3[i55] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        r2.b.v(arrayList, jArr3);
        aa.q.c("expectedValuesPerKey", 2);
        TreeMap treeMap = new TreeMap(aa.z0.f767v);
        aa.w0 w0Var = new aa.w0();
        aa.x0 x0Var = new aa.x0(treeMap);
        x0Var.f762z = w0Var;
        int i56 = 0;
        while (i56 < length4) {
            long[] jArr5 = jArr[i56];
            s2.d dVar2 = dVar;
            if (jArr5.length <= 1) {
                i = length4;
                iArr2 = iArr12;
            } else {
                int length5 = jArr5.length;
                double[] dArr = new double[length5];
                int i57 = 0;
                while (true) {
                    long[] jArr6 = jArr[i56];
                    i = length4;
                    double dLog = 0.0d;
                    if (i57 >= jArr6.length) {
                        break;
                    }
                    int[] iArr13 = iArr12;
                    long j8 = jArr6[i57];
                    if (j8 != -1) {
                        dLog = Math.log(j8);
                    }
                    dArr[i57] = dLog;
                    i57++;
                    length4 = i;
                    iArr12 = iArr13;
                }
                iArr2 = iArr12;
                int i58 = length5 - 1;
                double d10 = dArr[i58] - dArr[0];
                int i59 = 0;
                while (i59 < i58) {
                    double d11 = dArr[i59];
                    i59++;
                    int i60 = i58;
                    Double dValueOf = Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i59]) * 0.5d) - dArr[0]) / d10);
                    double d12 = d10;
                    Integer numValueOf = Integer.valueOf(i56);
                    Map map4 = x0Var.f760x;
                    long[][] jArr7 = jArr;
                    Collection collection = (Collection) map4.get(dValueOf);
                    if (collection == null) {
                        Collection collectionC = x0Var.c();
                        if (!collectionC.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        x0Var.f761y++;
                        map4.put(dValueOf, collectionC);
                    } else if (collection.add(numValueOf)) {
                        x0Var.f761y++;
                    }
                    i58 = i60;
                    d10 = d12;
                    jArr = jArr7;
                }
            }
            i56++;
            length4 = i;
            iArr12 = iArr2;
            dVar = dVar2;
            jArr = jArr;
        }
        s2.d dVar3 = dVar;
        int[] iArr14 = iArr12;
        long[][] jArr8 = jArr;
        Collection nVar = x0Var.f716v;
        if (nVar == null) {
            nVar = new aa.n(0, x0Var);
            x0Var.f716v = nVar;
        }
        aa.j0 j0VarR = aa.j0.r(nVar);
        for (int i61 = 0; i61 < j0VarR.size(); i61++) {
            int iIntValue = ((Integer) j0VarR.get(i61)).intValue();
            int i62 = iArr14[iIntValue] + 1;
            iArr14[iIntValue] = i62;
            jArr3[iIntValue] = jArr8[iIntValue][i62];
            r2.b.v(arrayList, jArr3);
        }
        for (int i63 = 0; i63 < r52.length; i63++) {
            if (arrayList.get(i63) != null) {
                jArr3[i63] = jArr3[i63] * 2;
            }
        }
        r2.b.v(arrayList, jArr3);
        aa.g0 g0VarN2 = aa.j0.n();
        for (int i64 = 0; i64 < arrayList.size(); i64++) {
            aa.g0 g0Var = (aa.g0) arrayList.get(i64);
            g0VarN2.a(g0Var == null ? aa.c1.f650y : g0Var.g());
        }
        aa.c1 c1VarG = g0VarN2.g();
        r2.r[] rVarArr = new r2.r[r52.length];
        for (int i65 = 0; i65 < r52.length; i65++) {
            ?? r73 = r52[i65];
            if (r73 != 0) {
                int[] iArr15 = r73.f11349b;
                if (iArr15.length != 0) {
                    if (iArr15.length == 1) {
                        bVar = new r2.s(r73.f11348a, new int[]{iArr15[0]});
                    } else {
                        long j10 = 25000;
                        bVar = new r2.b(r73.f11348a, iArr15, dVar3, 10000, j10, j10, (aa.j0) c1VarG.get(i65));
                    }
                    rVarArr[i65] = bVar;
                }
            }
        }
        a2[] a2VarArr = new a2[i32];
        for (int i66 = 0; i66 < i32; i66++) {
            a2VarArr[i66] = (jVar.f11331x0.get(i66) || jVar.E.contains(Integer.valueOf(tVar.f11351b[i66])) || (tVar.f11351b[i66] != -2 && rVarArr[i66] == null)) ? null : a2.f155c;
        }
        if (jVar.f9929u.f9863a != 0) {
            int i67 = 0;
            int i68 = -1;
            int i69 = 0;
            while (true) {
                if (i69 < tVar.f11350a) {
                    int i70 = tVar.f11351b[i69];
                    r2.r rVar = rVarArr[i69];
                    if (i70 != 1 && rVar != null) {
                        break;
                    }
                    if (i70 == 1 && rVar != null && rVar.length() == 1) {
                        if (r2.p.i(jVar, iArr5[i69][tVar.f11352c[i69].b(rVar.k())][rVar.e(0)], rVar.l())) {
                            i67++;
                            i68 = i69;
                        }
                    }
                    i69++;
                } else if (i67 == 1) {
                    int i71 = jVar.f9929u.f9864b ? 1 : 2;
                    a2 a2Var = a2VarArr[i68];
                    a2VarArr[i68] = new a2(i71, a2Var != null && a2Var.f157b);
                }
            }
        }
        Pair pairCreate = Pair.create(a2VarArr, rVarArr);
        r2.r[] rVarArr2 = (r2.r[]) pairCreate.second;
        List[] listArr = new List[rVarArr2.length];
        for (int i72 = 0; i72 < rVarArr2.length; i72++) {
            r2.r rVar2 = rVarArr2[i72];
            if (rVar2 != null) {
                c1VarV = aa.j0.v(rVar2);
            } else {
                aa.h0 h0Var = aa.j0.f690v;
                c1VarV = aa.c1.f650y;
            }
            listArr[i72] = c1VarV;
        }
        aa.g0 g0Var2 = new aa.g0(4);
        int i73 = 0;
        while (true) {
            int i74 = tVar.f11350a;
            o2.n1[] n1VarArr3 = tVar.f11352c;
            if (i73 >= i74) {
                break;
            }
            o2.n1 n1Var7 = n1VarArr3[i73];
            List list = listArr[i73];
            int i75 = 0;
            while (i75 < n1Var7.f9178a) {
                p1.g1 g1VarA3 = n1Var7.a(i75);
                int i76 = n1VarArr3[i73].a(i75).f9762a;
                int[] iArr16 = new int[i76];
                int i77 = 0;
                int i78 = 0;
                while (i77 < i76) {
                    List[] listArr2 = listArr;
                    if ((tVar.f11354e[i73][i75][i77] & 7) == 4) {
                        iArr16[i78] = i77;
                        i78++;
                    }
                    i77++;
                    listArr = listArr2;
                }
                List[] listArr3 = listArr;
                int[] iArrCopyOf = Arrays.copyOf(iArr16, i78);
                o2.n1 n1Var8 = n1Var7;
                int iMin = 16;
                String str2 = null;
                int i79 = 0;
                boolean z11 = false;
                int i80 = 0;
                while (i79 < iArrCopyOf.length) {
                    String str3 = n1VarArr3[i73].a(i75).f9765d[iArrCopyOf[i79]].f10023n;
                    int i81 = i80 + 1;
                    if (i80 == 0) {
                        str2 = str3;
                    } else {
                        z11 = (!Objects.equals(str2, str3)) | z11;
                    }
                    iMin = Math.min(iMin, tVar.f11354e[i73][i75][i79] & 24);
                    i79++;
                    i80 = i81;
                }
                if (z11) {
                    iMin = Math.min(iMin, tVar.f11353d[i73]);
                }
                boolean z12 = iMin != 0;
                int i82 = g1VarA3.f9762a;
                int[] iArr17 = new int[i82];
                boolean[] zArr = new boolean[i82];
                for (int i83 = 0; i83 < g1VarA3.f9762a; i83++) {
                    iArr17[i83] = tVar.f11354e[i73][i75][i83] & 7;
                    int i84 = 0;
                    while (true) {
                        if (i84 >= list.size()) {
                            z10 = false;
                            break;
                        }
                        r2.r rVar3 = (r2.r) list.get(i84);
                        if (rVar3.k().equals(g1VarA3) && rVar3.u(i83) != -1) {
                            z10 = true;
                            break;
                        }
                        i84++;
                    }
                    zArr[i83] = z10;
                }
                g0Var2.a(new p1.m1(g1VarA3, z12, iArr17, zArr));
                i75++;
                listArr = listArr3;
                n1Var7 = n1Var8;
            }
            i73++;
        }
        o2.n1 n1Var9 = tVar.f;
        for (int i85 = 0; i85 < n1Var9.f9178a; i85++) {
            p1.g1 g1VarA4 = n1Var9.a(i85);
            int[] iArr18 = new int[g1VarA4.f9762a];
            Arrays.fill(iArr18, 0);
            g0Var2.a(new p1.m1(g1VarA4, false, iArr18, new boolean[g1VarA4.f9762a]));
        }
        r2.v vVar = new r2.v((a2[]) pairCreate.first, (r2.r[]) pairCreate.second, new p1.n1(g0Var2.g()), tVar);
        for (int i86 = 0; i86 < vVar.f11357a; i86++) {
            if (vVar.b(i86)) {
                s1.d.g(vVar.f11359c[i86] != null || this.f200j[i86].f232v == -2);
            } else {
                s1.d.g(vVar.f11359c[i86] == null);
            }
        }
        for (r2.r rVar4 : vVar.f11359c) {
            if (rVar4 != null) {
                rVar4.p(f);
                rVar4.a(z2);
            }
        }
        return vVar;
    }

    public final void k() {
        Object obj = this.f193a;
        if (obj instanceof o2.d) {
            long j5 = this.f198g.f224d;
            if (j5 == -9223372036854775807L) {
                j5 = Long.MIN_VALUE;
            }
            o2.d dVar = (o2.d) obj;
            dVar.f9088y = 0L;
            dVar.f9089z = j5;
        }
    }
}
