package g2;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s2.a1[] f4905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4907e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v0 f4908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4909h;
    public final boolean[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e[] f4910j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v2.t f4911k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h1 f4912l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u0 f4913m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s2.l1 f4914n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public v2.u f4915o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4916p;

    public u0(e[] eVarArr, long j4, v2.t tVar, w2.e eVar, h1 h1Var, v0 v0Var, v2.u uVar) {
        this.f4910j = eVarArr;
        this.f4916p = j4;
        this.f4911k = tVar;
        this.f4912l = h1Var;
        s2.c0 c0Var = v0Var.f4919a;
        this.f4904b = c0Var.f11156a;
        this.f4908g = v0Var;
        this.f4914n = s2.l1.f11260d;
        this.f4915o = uVar;
        this.f4905c = new s2.a1[eVarArr.length];
        this.i = new boolean[eVarArr.length];
        long j7 = v0Var.f4920b;
        long j10 = v0Var.f4922d;
        boolean z10 = v0Var.f;
        h1Var.getClass();
        Object obj = c0Var.f11156a;
        int i = n1.f4811n;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        s2.c0 c0VarA = c0Var.a(pair.second);
        g1 g1Var = (g1) ((HashMap) h1Var.f4740e).get(obj2);
        g1Var.getClass();
        ((HashSet) h1Var.f4742h).add(g1Var);
        f1 f1Var = (f1) ((HashMap) h1Var.f).get(g1Var);
        if (f1Var != null) {
            f1Var.f4681a.f(f1Var.f4682b);
        }
        g1Var.f4719c.add(c0VarA);
        s2.a0 a0VarD = g1Var.f4717a.c(c0VarA, eVar, j7);
        ((IdentityHashMap) h1Var.f4739d).put(a0VarD, g1Var);
        h1Var.d();
        this.f4903a = j10 != -9223372036854775807L ? new s2.d(a0VarD, !z10, 0L, j10) : a0VarD;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, s2.a0] */
    public final long a(v2.u uVar, long j4, boolean z10, boolean[] zArr) {
        e[] eVarArr;
        s2.a1[] a1VarArr;
        int i = 0;
        while (true) {
            boolean z11 = true;
            if (i >= uVar.f13128a) {
                break;
            }
            if (z10 || !uVar.a(this.f4915o, i)) {
                z11 = false;
            }
            this.i[i] = z11;
            i++;
        }
        int i10 = 0;
        while (true) {
            eVarArr = this.f4910j;
            int length = eVarArr.length;
            a1VarArr = this.f4905c;
            if (i10 >= length) {
                break;
            }
            if (eVarArr[i10].f4658w == -2) {
                a1VarArr[i10] = null;
            }
            i10++;
        }
        b();
        this.f4915o = uVar;
        c();
        long jV = this.f4903a.v(uVar.f13130c, this.i, this.f4905c, zArr, j4);
        for (int i11 = 0; i11 < eVarArr.length; i11++) {
            if (eVarArr[i11].f4658w == -2 && this.f4915o.b(i11)) {
                a1VarArr[i11] = new s2.q();
            }
        }
        this.f = false;
        for (int i12 = 0; i12 < a1VarArr.length; i12++) {
            if (a1VarArr[i12] != null) {
                y1.d.g(uVar.b(i12));
                if (eVarArr[i12].f4658w != -2) {
                    this.f = true;
                }
            } else {
                y1.d.g(uVar.f13130c[i12] == null);
            }
        }
        return jV;
    }

    public final void b() {
        if (this.f4913m != null) {
            return;
        }
        int i = 0;
        while (true) {
            v2.u uVar = this.f4915o;
            if (i >= uVar.f13128a) {
                return;
            }
            boolean zB = uVar.b(i);
            v2.q qVar = this.f4915o.f13130c[i];
            if (zB && qVar != null) {
                qVar.g();
            }
            i++;
        }
    }

    public final void c() {
        if (this.f4913m != null) {
            return;
        }
        int i = 0;
        while (true) {
            v2.u uVar = this.f4915o;
            if (i >= uVar.f13128a) {
                return;
            }
            boolean zB = uVar.b(i);
            v2.q qVar = this.f4915o.f13130c[i];
            if (zB && qVar != null) {
                qVar.d();
            }
            i++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, s2.c1] */
    public final long d() {
        if (!this.f4907e) {
            return this.f4908g.f4920b;
        }
        long jQ = this.f ? this.f4903a.q() : Long.MIN_VALUE;
        return jQ == Long.MIN_VALUE ? this.f4908g.f4923e : jQ;
    }

    public final long e() {
        return this.f4908g.f4920b + this.f4916p;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, s2.a0] */
    public final void f(float f, v1.f1 f1Var, boolean z10) {
        this.f4907e = true;
        this.f4914n = this.f4903a.o();
        v2.u uVarJ = j(f, f1Var, z10);
        v0 v0Var = this.f4908g;
        long jMax = v0Var.f4920b;
        long j4 = v0Var.f4923e;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, j4 - 1);
        }
        long jA = a(uVarJ, jMax, false, new boolean[this.f4910j.length]);
        long j7 = this.f4916p;
        v0 v0Var2 = this.f4908g;
        this.f4916p = (v0Var2.f4920b - jA) + j7;
        this.f4908g = v0Var2.b(jA);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, s2.c1] */
    public final boolean g() {
        if (this.f4907e) {
            return !this.f || this.f4903a.q() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean h() {
        if (this.f4907e) {
            return g() || d() - this.f4908g.f4920b >= -9223372036854775807L;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s2.a0] */
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
        ?? r02 = this.f4903a;
        try {
            boolean z10 = r02 instanceof s2.d;
            h1 h1Var = this.f4912l;
            if (z10) {
                h1Var.h(((s2.d) r02).f11161v);
            } else {
                h1Var.h(r02);
            }
        } catch (RuntimeException e9) {
            y1.b.h("MediaPeriodHolder", "Period release failed.", e9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final v2.u j(float f, v1.f1 f1Var, boolean z10) {
        v2.i iVar;
        boolean z11;
        String str;
        int i;
        Pair pairJ;
        int[] iArr;
        Pair pairJ2;
        String languageTag;
        Pair pairJ3;
        CaptioningManager captioningManager;
        Locale locale;
        boolean z12;
        ua.z0 z0VarO;
        v2.q bVar;
        int i10;
        int[] iArr2;
        Object obj;
        int i11;
        v2.p pVar;
        int i12;
        int i13;
        Context context;
        int[] iArr3;
        v2.t tVar = this.f4911k;
        e[] eVarArr = this.f4910j;
        s2.l1 l1Var = this.f4914n;
        tVar.getClass();
        int i14 = 1;
        int[] iArr4 = new int[eVarArr.length + 1];
        int length = eVarArr.length + 1;
        v1.g1[][] g1VarArr = new v1.g1[length][];
        int[][][] iArr5 = new int[eVarArr.length + 1][][];
        for (int i15 = 0; i15 < length; i15++) {
            int i16 = l1Var.f11262a;
            g1VarArr[i15] = new v1.g1[i16];
            iArr5[i15] = new int[i16][];
        }
        int length2 = eVarArr.length;
        int[] iArr6 = new int[length2];
        for (int i17 = 0; i17 < length2; i17++) {
            iArr6[i17] = eVarArr[i17].B();
        }
        int i18 = 0;
        while (i18 < l1Var.f11262a) {
            v1.g1 g1VarA = l1Var.a(i18);
            int i19 = g1VarA.f12704c == 5 ? i14 : 0;
            int length3 = eVarArr.length;
            int i20 = i14;
            int i21 = 0;
            int i22 = 0;
            while (i21 < eVarArr.length) {
                e eVar = eVarArr[i21];
                v2.t tVar2 = tVar;
                s2.l1 l1Var2 = l1Var;
                int i23 = i14;
                int iMax = 0;
                for (int i24 = 0; i24 < g1VarA.f12702a; i24++) {
                    iMax = Math.max(iMax, eVar.A(g1VarA.f12705d[i24]) & 7);
                }
                int i25 = iArr4[i21] == 0 ? i23 : 0;
                if (iMax > i22 || (iMax == i22 && i19 != 0 && i20 == 0 && i25 != 0)) {
                    i22 = iMax;
                    i20 = i25;
                    length3 = i21;
                }
                i21++;
                i14 = i23;
                tVar = tVar2;
                l1Var = l1Var2;
            }
            v2.t tVar3 = tVar;
            s2.l1 l1Var3 = l1Var;
            int i26 = i14;
            if (length3 == eVarArr.length) {
                iArr3 = new int[g1VarA.f12702a];
            } else {
                e eVar2 = eVarArr[length3];
                int[] iArr7 = new int[g1VarA.f12702a];
                for (int i27 = 0; i27 < g1VarA.f12702a; i27++) {
                    iArr7[i27] = eVar2.A(g1VarA.f12705d[i27]);
                }
                iArr3 = iArr7;
            }
            int i28 = iArr4[length3];
            g1VarArr[length3][i28] = g1VarA;
            iArr5[length3][i28] = iArr3;
            iArr4[length3] = i28 + 1;
            i18++;
            i14 = i26;
            tVar = tVar3;
            l1Var = l1Var3;
        }
        v2.t tVar4 = tVar;
        int i29 = i14;
        int i30 = 0;
        s2.l1[] l1VarArr = new s2.l1[eVarArr.length];
        String[] strArr = new String[eVarArr.length];
        int[] iArr8 = new int[eVarArr.length];
        for (int i31 = 0; i31 < eVarArr.length; i31++) {
            int i32 = iArr4[i31];
            l1VarArr[i31] = new s2.l1((v1.g1[]) y1.a0.Q(i32, g1VarArr[i31]));
            iArr5[i31] = (int[][]) y1.a0.Q(i32, iArr5[i31]);
            strArr[i31] = eVarArr[i31].j();
            iArr8[i31] = eVarArr[i31].f4658w;
        }
        v2.s sVar = new v2.s(iArr8, l1VarArr, iArr6, iArr5, new s2.l1((v1.g1[]) y1.a0.Q(iArr4[eVarArr.length], g1VarArr[eVarArr.length])));
        v2.o oVar = (v2.o) tVar4;
        synchronized (oVar.f13113c) {
            oVar.f13116g = Thread.currentThread();
            iVar = oVar.f;
        }
        if (oVar.f13118j == null && (context = oVar.f13114d) != null) {
            oVar.f13118j = Boolean.valueOf(y1.a0.M(context));
        }
        if (iVar.f13100t0 && Build.VERSION.SDK_INT >= 32 && oVar.f13117h == null) {
            oVar.f13117h = new com.bumptech.glide.l(oVar.f13114d, oVar, oVar.f13118j);
        }
        int i33 = sVar.f13121a;
        Context context2 = oVar.f13114d;
        v2.p[] pVarArr = new v2.p[i33];
        int i34 = 0;
        while (true) {
            if (i34 >= sVar.f13121a) {
                z11 = 0;
                break;
            }
            if (2 == iArr8[i34] && l1VarArr[i34].f11262a > 0) {
                z11 = i29;
                break;
            }
            i34++;
        }
        Pair pairJ4 = v2.o.j(i29, sVar, iArr5, new ub.b(z11, oVar, iVar, iArr6), new g4.d(15));
        if (pairJ4 != null) {
            pVarArr[((Integer) pairJ4.second).intValue()] = (v2.p) pairJ4.first;
        }
        if (pairJ4 == null) {
            str = null;
        } else {
            v2.p pVar2 = (v2.p) pairJ4.first;
            str = pVar2.f13119a.f12705d[pVar2.f13120b[0]].f12938d;
        }
        v1.j1 j1Var = iVar.f12862u;
        Object obj2 = null;
        int i35 = 14;
        if (j1Var.f12792a == 2) {
            i = 2;
            pairJ = null;
        } else {
            i = 2;
            pairJ = v2.o.j(2, sVar, iArr5, new androidx.fragment.app.f(iVar, str, iArr6, (!iVar.f12852k || context2 == null) ? null : y1.a0.u(context2)), new g4.d(i35));
        }
        int i36 = 4;
        if ((iVar.A || pairJ == null) && j1Var.f12792a != i) {
            iArr = iArr8;
            pairJ2 = v2.o.j(4, sVar, iArr5, new kb.d(15, iVar), new g4.d(13));
        } else {
            iArr = iArr8;
            pairJ2 = null;
        }
        if (pairJ2 != null) {
            pVarArr[((Integer) pairJ2.second).intValue()] = (v2.p) pairJ2.first;
        } else if (pairJ != null) {
            pVarArr[((Integer) pairJ.second).intValue()] = (v2.p) pairJ.first;
        }
        int i37 = 16;
        int i38 = 3;
        if (j1Var.f12792a == 2) {
            pairJ3 = null;
        } else {
            if (!iVar.f12865x || context2 == null || (captioningManager = (CaptioningManager) context2.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
                languageTag = null;
            } else {
                int i39 = y1.a0.f14551a;
                languageTag = locale.toLanguageTag();
            }
            pairJ3 = v2.o.j(3, sVar, iArr5, new c8.b(iVar, str, languageTag, 14), new g4.d(i37));
        }
        if (pairJ3 != null) {
            pVarArr[((Integer) pairJ3.second).intValue()] = (v2.p) pairJ3.first;
        }
        int i40 = 0;
        while (i40 < i33) {
            int i41 = iArr[i40];
            if (i41 == 2 || i41 == 1 || i41 == i38 || i41 == i36) {
                i11 = i40;
            } else {
                s2.l1 l1Var4 = l1VarArr[i40];
                int[][] iArr9 = iArr5[i40];
                if (j1Var.f12792a == 2) {
                    i11 = i40;
                } else {
                    int i42 = i30;
                    int i43 = i42;
                    v1.g1 g1Var = null;
                    v2.g gVar = null;
                    while (i42 < l1Var4.f11262a) {
                        v1.g1 g1VarA2 = l1Var4.a(i42);
                        int[] iArr10 = iArr9[i42];
                        int i44 = i40;
                        s2.l1 l1Var5 = l1Var4;
                        v2.g gVar2 = gVar;
                        int i45 = i43;
                        v1.g1 g1Var2 = g1Var;
                        int i46 = i30;
                        while (i46 < g1VarA2.f12702a) {
                            int[][] iArr11 = iArr9;
                            if (q4.a.g(iArr10[i46], iVar.f13101u0)) {
                                i12 = i42;
                                v2.g gVar3 = new v2.g(g1VarA2.f12705d[i46], iArr10[i46]);
                                if (gVar2 != null) {
                                    i13 = i46;
                                    if (ua.y.f12407a.c(gVar3.f13093w, gVar2.f13093w).c(gVar3.f13092v, gVar2.f13092v).e() > 0) {
                                    }
                                } else {
                                    i13 = i46;
                                }
                                gVar2 = gVar3;
                                g1Var2 = g1VarA2;
                                i45 = i13;
                            } else {
                                i12 = i42;
                                i13 = i46;
                            }
                            i46 = i13 + 1;
                            iArr9 = iArr11;
                            i42 = i12;
                        }
                        i42++;
                        g1Var = g1Var2;
                        i43 = i45;
                        l1Var4 = l1Var5;
                        gVar = gVar2;
                        i40 = i44;
                    }
                    i11 = i40;
                    if (g1Var != null) {
                        pVar = new v2.p(i30, g1Var, new int[]{i43});
                    }
                    pVarArr[i11] = pVar;
                }
                pVar = null;
                pVarArr[i11] = pVar;
            }
            i40 = i11 + 1;
            i30 = 0;
            i38 = 3;
            i36 = 4;
        }
        int i47 = sVar.f13121a;
        s2.l1[] l1VarArr2 = sVar.f13123c;
        HashMap map = new HashMap();
        for (int i48 = 0; i48 < i47; i48++) {
            v2.o.c(l1VarArr2[i48], iVar, map);
        }
        v2.o.c(sVar.f, iVar, map);
        for (int i49 = 0; i49 < i47; i49++) {
            v1.h1 h1Var = (v1.h1) map.get(Integer.valueOf(sVar.f13122b[i49]));
            if (h1Var != null) {
                v1.g1 g1Var3 = h1Var.f12711a;
                ua.i0 i0Var = h1Var.f12712b;
                pVarArr[i49] = (i0Var.isEmpty() || l1VarArr2[i49].b(g1Var3) == -1) ? null : new v2.p(0, g1Var3, com.bumptech.glide.d.C(i0Var));
            }
        }
        int i50 = sVar.f13121a;
        for (int i51 = 0; i51 < i50; i51++) {
            s2.l1 l1Var6 = sVar.f13123c[i51];
            Map map2 = (Map) iVar.f13103w0.get(i51);
            if (map2 != null && map2.containsKey(l1Var6)) {
                Map map3 = (Map) iVar.f13103w0.get(i51);
                if (map3 != null && map3.get(l1Var6) != null) {
                    throw new ClassCastException();
                }
                pVarArr[i51] = null;
            }
        }
        for (int i52 = 0; i52 < i33; i52++) {
            int i53 = sVar.f13122b[i52];
            if (iVar.f13104x0.get(i52) || iVar.E.contains(Integer.valueOf(i53))) {
                pVarArr[i52] = null;
            }
        }
        f9.c0 c0Var = oVar.f13115e;
        w2.d dVar = oVar.f13127b;
        y1.d.h(dVar);
        c0Var.getClass();
        ArrayList arrayList = new ArrayList();
        int i54 = 0;
        while (i54 < pVarArr.length) {
            v2.p pVar3 = pVarArr[i54];
            if (pVar3 == null || pVar3.f13120b.length <= 1) {
                obj = obj2;
                arrayList.add(obj);
            } else {
                ua.f0 f0VarJ = ua.i0.j();
                f0VarJ.a(new v2.a(0L, 0L));
                arrayList.add(f0VarJ);
                obj = obj2;
            }
            i54++;
            obj2 = obj;
        }
        int length4 = pVarArr.length;
        long[][] jArr = new long[length4][];
        for (int i55 = 0; i55 < pVarArr.length; i55++) {
            v2.p pVar4 = pVarArr[i55];
            if (pVar4 == null) {
                jArr[i55] = new long[0];
            } else {
                int[] iArr12 = pVar4.f13120b;
                jArr[i55] = new long[iArr12.length];
                int i56 = 0;
                while (i56 < iArr12.length) {
                    int i57 = i56;
                    long j4 = pVar4.f13119a.f12705d[iArr12[i56]].f12942j;
                    long[] jArr2 = jArr[i55];
                    if (j4 == -1) {
                        j4 = 0;
                    }
                    jArr2[i57] = j4;
                    i56 = i57 + 1;
                }
                Arrays.sort(jArr[i55]);
            }
        }
        int[] iArr13 = new int[length4];
        long[] jArr3 = new long[length4];
        for (int i58 = 0; i58 < length4; i58++) {
            long[] jArr4 = jArr[i58];
            jArr3[i58] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        v2.b.v(arrayList, jArr3);
        ua.q.d(2, "expectedValuesPerKey");
        TreeMap treeMap = new TreeMap(ua.w0.f12403w);
        ua.u0 u0Var = new ua.u0();
        ua.v0 v0Var = new ua.v0(treeMap);
        v0Var.A = u0Var;
        int i59 = 0;
        while (i59 < length4) {
            long[] jArr5 = jArr[i59];
            w2.d dVar2 = dVar;
            if (jArr5.length <= 1) {
                i10 = length4;
                iArr2 = iArr13;
            } else {
                int length5 = jArr5.length;
                double[] dArr = new double[length5];
                int i60 = 0;
                while (true) {
                    long[] jArr6 = jArr[i59];
                    i10 = length4;
                    double dLog = 0.0d;
                    if (i60 >= jArr6.length) {
                        break;
                    }
                    int[] iArr14 = iArr13;
                    long j7 = jArr6[i60];
                    if (j7 != -1) {
                        dLog = Math.log(j7);
                    }
                    dArr[i60] = dLog;
                    i60++;
                    length4 = i10;
                    iArr13 = iArr14;
                }
                iArr2 = iArr13;
                int i61 = length5 - 1;
                double d10 = dArr[i61] - dArr[0];
                int i62 = 0;
                while (i62 < i61) {
                    double d11 = dArr[i62];
                    i62++;
                    int i63 = i61;
                    Double dValueOf = Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i62]) * 0.5d) - dArr[0]) / d10);
                    double d12 = d10;
                    Integer numValueOf = Integer.valueOf(i59);
                    Map map4 = v0Var.f12401y;
                    long[][] jArr7 = jArr;
                    Collection collection = (Collection) map4.get(dValueOf);
                    if (collection == null) {
                        Collection collectionC = v0Var.c();
                        if (!collectionC.add(numValueOf)) {
                            throw new AssertionError("New Collection violated the Collection spec");
                        }
                        v0Var.f12402z++;
                        map4.put(dValueOf, collectionC);
                    } else if (collection.add(numValueOf)) {
                        v0Var.f12402z++;
                    }
                    i61 = i63;
                    d10 = d12;
                    jArr = jArr7;
                }
            }
            i59++;
            length4 = i10;
            iArr13 = iArr2;
            dVar = dVar2;
            jArr = jArr;
        }
        w2.d dVar3 = dVar;
        int[] iArr15 = iArr13;
        long[][] jArr8 = jArr;
        ua.n nVar = v0Var.f12369w;
        if (nVar == null) {
            nVar = new ua.n(0, v0Var);
            v0Var.f12369w = nVar;
        }
        ua.i0 i0VarK = ua.i0.k(nVar);
        for (int i64 = 0; i64 < i0VarK.size(); i64++) {
            int iIntValue = ((Integer) i0VarK.get(i64)).intValue();
            int i65 = iArr15[iIntValue] + 1;
            iArr15[iIntValue] = i65;
            jArr3[iIntValue] = jArr8[iIntValue][i65];
            v2.b.v(arrayList, jArr3);
        }
        for (int i66 = 0; i66 < pVarArr.length; i66++) {
            if (arrayList.get(i66) != null) {
                jArr3[i66] = jArr3[i66] * 2;
            }
        }
        v2.b.v(arrayList, jArr3);
        ua.f0 f0VarJ2 = ua.i0.j();
        for (int i67 = 0; i67 < arrayList.size(); i67++) {
            ua.f0 f0Var = (ua.f0) arrayList.get(i67);
            f0VarJ2.a(f0Var == null ? ua.z0.f12413z : f0Var.g());
        }
        ua.z0 z0VarG = f0VarJ2.g();
        v2.q[] qVarArr = new v2.q[pVarArr.length];
        for (int i68 = 0; i68 < pVarArr.length; i68++) {
            v2.p pVar5 = pVarArr[i68];
            if (pVar5 != null) {
                int[] iArr16 = pVar5.f13120b;
                if (iArr16.length != 0) {
                    if (iArr16.length == 1) {
                        bVar = new v2.r(pVar5.f13119a, new int[]{iArr16[0]});
                    } else {
                        long j10 = 25000;
                        bVar = new v2.b(pVar5.f13119a, iArr16, dVar3, 10000, j10, j10, (ua.i0) z0VarG.get(i68));
                    }
                    qVarArr[i68] = bVar;
                }
            }
        }
        o1[] o1VarArr = new o1[i33];
        for (int i69 = 0; i69 < i33; i69++) {
            o1VarArr[i69] = (iVar.f13104x0.get(i69) || iVar.E.contains(Integer.valueOf(sVar.f13122b[i69])) || (sVar.f13122b[i69] != -2 && qVarArr[i69] == null)) ? null : o1.f4851c;
        }
        if (iVar.f12862u.f12792a != 0) {
            int i70 = 0;
            int i71 = -1;
            int i72 = 0;
            while (true) {
                if (i72 < sVar.f13121a) {
                    int i73 = sVar.f13122b[i72];
                    v2.q qVar = qVarArr[i72];
                    if (i73 != 1 && qVar != null) {
                        break;
                    }
                    if (i73 == 1 && qVar != null && qVar.length() == 1) {
                        if (v2.o.i(iVar, iArr5[i72][sVar.f13123c[i72].b(qVar.i())][qVar.e(0)], qVar.j())) {
                            i70++;
                            i71 = i72;
                        }
                    }
                    i72++;
                } else if (i70 == 1) {
                    int i74 = iVar.f12862u.f12793b ? 1 : 2;
                    o1 o1Var = o1VarArr[i71];
                    o1VarArr[i71] = new o1(i74, o1Var != null && o1Var.f4853b);
                }
            }
        }
        Pair pairCreate = Pair.create(o1VarArr, qVarArr);
        v2.q[] qVarArr2 = (v2.q[]) pairCreate.second;
        List[] listArr = new List[qVarArr2.length];
        for (int i75 = 0; i75 < qVarArr2.length; i75++) {
            v2.q qVar2 = qVarArr2[i75];
            if (qVar2 != null) {
                z0VarO = ua.i0.o(qVar2);
            } else {
                ua.g0 g0Var = ua.i0.f12341w;
                z0VarO = ua.z0.f12413z;
            }
            listArr[i75] = z0VarO;
        }
        ua.f0 f0Var2 = new ua.f0(4);
        int i76 = 0;
        while (true) {
            int i77 = sVar.f13121a;
            s2.l1[] l1VarArr3 = sVar.f13123c;
            if (i76 >= i77) {
                break;
            }
            s2.l1 l1Var7 = l1VarArr3[i76];
            List list = listArr[i76];
            int i78 = 0;
            while (i78 < l1Var7.f11262a) {
                v1.g1 g1VarA3 = l1Var7.a(i78);
                int i79 = l1VarArr3[i76].a(i78).f12702a;
                int[] iArr17 = new int[i79];
                int i80 = 0;
                int i81 = 0;
                while (i80 < i79) {
                    List[] listArr2 = listArr;
                    if ((sVar.f13125e[i76][i78][i80] & 7) == 4) {
                        iArr17[i81] = i80;
                        i81++;
                    }
                    i80++;
                    listArr = listArr2;
                }
                List[] listArr3 = listArr;
                int[] iArrCopyOf = Arrays.copyOf(iArr17, i81);
                s2.l1 l1Var8 = l1Var7;
                String str2 = null;
                int i82 = 0;
                boolean z13 = false;
                int i83 = 0;
                int iMin = 16;
                while (i82 < iArrCopyOf.length) {
                    String str3 = l1VarArr3[i76].a(i78).f12705d[iArrCopyOf[i82]].f12946n;
                    int i84 = i83 + 1;
                    if (i83 == 0) {
                        str2 = str3;
                    } else {
                        z13 = (!Objects.equals(str2, str3)) | z13;
                    }
                    iMin = Math.min(iMin, sVar.f13125e[i76][i78][i82] & 24);
                    i82++;
                    i83 = i84;
                }
                if (z13) {
                    iMin = Math.min(iMin, sVar.f13124d[i76]);
                }
                boolean z14 = iMin != 0;
                int i85 = g1VarA3.f12702a;
                int[] iArr18 = new int[i85];
                boolean[] zArr = new boolean[i85];
                for (int i86 = 0; i86 < g1VarA3.f12702a; i86++) {
                    iArr18[i86] = sVar.f13125e[i76][i78][i86] & 7;
                    int i87 = 0;
                    while (true) {
                        if (i87 >= list.size()) {
                            z12 = false;
                            break;
                        }
                        v2.q qVar3 = (v2.q) list.get(i87);
                        if (qVar3.i().equals(g1VarA3) && qVar3.u(i86) != -1) {
                            z12 = true;
                            break;
                        }
                        i87++;
                    }
                    zArr[i86] = z12;
                }
                f0Var2.a(new v1.m1(g1VarA3, z14, iArr18, zArr));
                i78++;
                listArr = listArr3;
                l1Var7 = l1Var8;
            }
            i76++;
        }
        s2.l1 l1Var9 = sVar.f;
        for (int i88 = 0; i88 < l1Var9.f11262a; i88++) {
            v1.g1 g1VarA4 = l1Var9.a(i88);
            int[] iArr19 = new int[g1VarA4.f12702a];
            Arrays.fill(iArr19, 0);
            f0Var2.a(new v1.m1(g1VarA4, false, iArr19, new boolean[g1VarA4.f12702a]));
        }
        v2.u uVar = new v2.u((o1[]) pairCreate.first, (v2.q[]) pairCreate.second, new v1.n1(f0Var2.g()), sVar);
        for (int i89 = 0; i89 < uVar.f13128a; i89++) {
            if (uVar.b(i89)) {
                y1.d.g(uVar.f13130c[i89] != null || this.f4910j[i89].f4658w == -2);
            } else {
                y1.d.g(uVar.f13130c[i89] == null);
            }
        }
        for (v2.q qVar4 : uVar.f13130c) {
            if (qVar4 != null) {
                qVar4.o(f);
                qVar4.a(z10);
            }
        }
        return uVar;
    }

    public final void k() {
        Object obj = this.f4903a;
        if (obj instanceof s2.d) {
            long j4 = this.f4908g.f4922d;
            if (j4 == -9223372036854775807L) {
                j4 = Long.MIN_VALUE;
            }
            s2.d dVar = (s2.d) obj;
            dVar.f11165z = 0L;
            dVar.A = j4;
        }
    }
}
