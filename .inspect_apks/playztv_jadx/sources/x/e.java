package x;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import y.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final d I;
    public final d J;
    public final d K;
    public final d L;
    public final d M;
    public final d N;
    public final d O;
    public final d P;
    public final d[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public e T;
    public int U;
    public int V;
    public float W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f14122a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y.c f14123b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f14124b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y.c f14125c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f14126c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f14128d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f14130e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public View f14131f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f14133g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f14135h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f14136i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14137j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f14138j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14139k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final float[] f14140k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14141l;
    public final e[] l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14142m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final e[] f14143m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14144n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f14145n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14146o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f14147o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14148p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f14149p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f14152s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f14153t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f14156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f14159z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14121a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y.k f14127d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f14129e = null;
    public final boolean[] f = {true, true};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14132g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14134h = -1;
    public int i = -1;

    public e() {
        new HashMap();
        this.f14139k = false;
        this.f14141l = false;
        this.f14142m = false;
        this.f14144n = false;
        this.f14146o = -1;
        this.f14148p = -1;
        this.f14150q = 0;
        this.f14151r = 0;
        this.f14152s = 0;
        this.f14153t = new int[2];
        this.f14154u = 0;
        this.f14155v = 0;
        this.f14156w = 1.0f;
        this.f14157x = 0;
        this.f14158y = 0;
        this.f14159z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = 0.0f;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        d dVar = new d(this, 2);
        this.I = dVar;
        d dVar2 = new d(this, 3);
        this.J = dVar2;
        d dVar3 = new d(this, 4);
        this.K = dVar3;
        d dVar4 = new d(this, 5);
        this.L = dVar4;
        d dVar5 = new d(this, 6);
        this.M = dVar5;
        d dVar6 = new d(this, 8);
        this.N = dVar6;
        d dVar7 = new d(this, 9);
        this.O = dVar7;
        d dVar8 = new d(this, 7);
        this.P = dVar8;
        this.Q = new d[]{dVar, dVar3, dVar2, dVar4, dVar5, dVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        this.f14149p0 = new int[]{1, 1};
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f14122a0 = 0;
        this.f14128d0 = 0.5f;
        this.f14130e0 = 0.5f;
        this.f14133g0 = 0;
        this.f14135h0 = null;
        this.f14136i0 = 0;
        this.f14138j0 = 0;
        this.f14140k0 = new float[]{-1.0f, -1.0f};
        this.l0 = new e[]{null, null};
        this.f14143m0 = new e[]{null, null};
        this.f14145n0 = -1;
        this.f14147o0 = -1;
        arrayList.add(dVar);
        arrayList.add(dVar2);
        arrayList.add(dVar3);
        arrayList.add(dVar4);
        arrayList.add(dVar6);
        arrayList.add(dVar7);
        arrayList.add(dVar8);
        arrayList.add(dVar5);
    }

    public static void G(int i, int i10, String str, StringBuilder sb2) {
        if (i == i10) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i);
        sb2.append(",\n");
    }

    public static void H(StringBuilder sb2, String str, float f, float f4) {
        if (f == f4) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f);
        sb2.append(",\n");
    }

    public static void o(StringBuilder sb2, String str, int i, int i10, int i11, int i12, int i13, float f) {
        sb2.append(str);
        sb2.append(" :  {\n");
        G(i, 0, "      size", sb2);
        G(i10, 0, "      min", sb2);
        G(i11, Integer.MAX_VALUE, "      max", sb2);
        G(i12, 0, "      matchMin", sb2);
        G(i13, 0, "      matchDef", sb2);
        H(sb2, "      matchPercent", f, 1.0f);
        sb2.append("    },\n");
    }

    public static void p(StringBuilder sb2, String str, d dVar) {
        if (dVar.f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(dVar.f);
        sb2.append("'");
        if (dVar.f14120h != Integer.MIN_VALUE || dVar.f14119g != 0) {
            sb2.append(",");
            sb2.append(dVar.f14119g);
            if (dVar.f14120h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(dVar.f14120h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    public boolean A() {
        if (this.f14139k) {
            return true;
        }
        return this.I.f14116c && this.K.f14116c;
    }

    public boolean B() {
        if (this.f14141l) {
            return true;
        }
        return this.J.f14116c && this.L.f14116c;
    }

    public void C() {
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.T = null;
        this.D = 0.0f;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f14122a0 = 0;
        this.f14124b0 = 0;
        this.f14126c0 = 0;
        this.f14128d0 = 0.5f;
        this.f14130e0 = 0.5f;
        int[] iArr = this.f14149p0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f14131f0 = null;
        this.f14133g0 = 0;
        this.f14136i0 = 0;
        this.f14138j0 = 0;
        float[] fArr = this.f14140k0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f14146o = -1;
        this.f14148p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f14151r = 0;
        this.f14152s = 0;
        this.f14156w = 1.0f;
        this.f14159z = 1.0f;
        this.f14155v = Integer.MAX_VALUE;
        this.f14158y = Integer.MAX_VALUE;
        this.f14154u = 0;
        this.f14157x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f14132g = true;
        int[] iArr3 = this.f14153t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f14134h = -1;
        this.i = -1;
    }

    public final void D() {
        e eVar = this.T;
        if (eVar != null && (eVar instanceof f)) {
            ((f) eVar).getClass();
        }
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((d) arrayList.get(i)).j();
        }
    }

    public final void E() {
        this.f14139k = false;
        this.f14141l = false;
        this.f14142m = false;
        this.f14144n = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d dVar = (d) arrayList.get(i);
            dVar.f14116c = false;
            dVar.f14115b = 0;
        }
    }

    public void F(kc.b bVar) {
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.P.k();
        this.N.k();
        this.O.k();
    }

    public final void I(int i) {
        this.f14122a0 = i;
        this.E = i > 0;
    }

    public final void J(int i, int i10) {
        if (this.f14139k) {
            return;
        }
        this.I.l(i);
        this.K.l(i10);
        this.Y = i;
        this.U = i10 - i;
        this.f14139k = true;
    }

    public final void K(int i, int i10) {
        if (this.f14141l) {
            return;
        }
        this.J.l(i);
        this.L.l(i10);
        this.Z = i;
        this.V = i10 - i;
        if (this.E) {
            this.M.l(i + this.f14122a0);
        }
        this.f14141l = true;
    }

    public final void L(int i) {
        this.V = i;
        int i10 = this.f14126c0;
        if (i < i10) {
            this.V = i10;
        }
    }

    public final void M(int i) {
        this.f14149p0[0] = i;
    }

    public final void N(int i) {
        this.f14149p0[1] = i;
    }

    public final void O(int i) {
        this.U = i;
        int i10 = this.f14124b0;
        if (i < i10) {
            this.U = i10;
        }
    }

    public void P(boolean z2, boolean z10) {
        int i;
        int i10;
        y.k kVar = this.f14127d;
        boolean z11 = z2 & kVar.f14417g;
        m mVar = this.f14129e;
        boolean z12 = z10 & mVar.f14417g;
        int i11 = kVar.f14418h.f14395g;
        int i12 = mVar.f14418h.f14395g;
        int i13 = kVar.i.f14395g;
        int i14 = mVar.i.f14395g;
        int i15 = i14 - i12;
        if (i13 - i11 < 0 || i15 < 0 || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE) {
            i13 = 0;
            i14 = 0;
            i11 = 0;
            i12 = 0;
        }
        int i16 = i13 - i11;
        int i17 = i14 - i12;
        if (z11) {
            this.Y = i11;
        }
        if (z12) {
            this.Z = i12;
        }
        if (this.f14133g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f14149p0;
        if (z11) {
            if (iArr[0] == 1 && i16 < (i10 = this.U)) {
                i16 = i10;
            }
            this.U = i16;
            int i18 = this.f14124b0;
            if (i16 < i18) {
                this.U = i18;
            }
        }
        if (z12) {
            if (iArr[1] == 1 && i17 < (i = this.V)) {
                i17 = i;
            }
            this.V = i17;
            int i19 = this.f14126c0;
            if (i17 < i19) {
                this.V = i19;
            }
        }
    }

    public void Q(v.c cVar, boolean z2) {
        int i;
        int i10;
        m mVar;
        y.k kVar;
        cVar.getClass();
        int iN = v.c.n(this.I);
        int iN2 = v.c.n(this.J);
        int iN3 = v.c.n(this.K);
        int iN4 = v.c.n(this.L);
        if (z2 && (kVar = this.f14127d) != null) {
            y.f fVar = kVar.f14418h;
            if (fVar.f14397j) {
                y.f fVar2 = kVar.i;
                if (fVar2.f14397j) {
                    iN = fVar.f14395g;
                    iN3 = fVar2.f14395g;
                }
            }
        }
        if (z2 && (mVar = this.f14129e) != null) {
            y.f fVar3 = mVar.f14418h;
            if (fVar3.f14397j) {
                y.f fVar4 = mVar.i;
                if (fVar4.f14397j) {
                    iN2 = fVar3.f14395g;
                    iN4 = fVar4.f14395g;
                }
            }
        }
        int i11 = iN4 - iN2;
        if (iN3 - iN < 0 || i11 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i12 = iN3 - iN;
        int i13 = iN4 - iN2;
        this.Y = iN;
        this.Z = iN2;
        if (this.f14133g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f14149p0;
        int i14 = iArr[0];
        if (i14 == 1 && i12 < (i10 = this.U)) {
            i12 = i10;
        }
        if (iArr[1] == 1 && i13 < (i = this.V)) {
            i13 = i;
        }
        this.U = i12;
        this.V = i13;
        int i15 = this.f14126c0;
        if (i13 < i15) {
            this.V = i15;
        }
        int i16 = this.f14124b0;
        if (i12 < i16) {
            this.U = i16;
        }
        int i17 = this.f14155v;
        if (i17 > 0 && i14 == 3) {
            this.U = Math.min(this.U, i17);
        }
        int i18 = this.f14158y;
        if (i18 > 0 && iArr[1] == 3) {
            this.V = Math.min(this.V, i18);
        }
        int i19 = this.U;
        if (i12 != i19) {
            this.f14134h = i19;
        }
        int i20 = this.V;
        if (i13 != i20) {
            this.i = i20;
        }
    }

    public final void a(f fVar, v.c cVar, HashSet hashSet, int i, boolean z2) {
        if (z2) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.b(fVar, cVar, this);
            hashSet.remove(this);
            b(cVar, fVar.W(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.I.f14114a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).f14117d.a(fVar, cVar, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.K.f14114a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).f14117d.a(fVar, cVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.f14114a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).f14117d.a(fVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.L.f14114a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).f14117d.a(fVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.M.f14114a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).f14117d.a(fVar, cVar, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fd  */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r4v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r58v0, types: [x.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(v.c r59, boolean r60) {
        /*
            Method dump skipped, instruction units count: 1912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.b(v.c, boolean):void");
    }

    public boolean c() {
        return this.f14133g0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0493 A[PHI: r3
      0x0493: PHI (r3v17 int) = (r3v16 int), (r3v21 int), (r3v21 int), (r3v21 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(v.c r30, boolean r31, boolean r32, boolean r33, boolean r34, v.f r35, v.f r36, int r37, boolean r38, x.d r39, x.d r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.d(v.c, boolean, boolean, boolean, boolean, v.f, v.f, int, boolean, x.d, x.d, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i, e eVar, int i10, int i11) {
        boolean z2;
        if (i == 7) {
            if (i10 != 7) {
                if (i10 == 2 || i10 == 4) {
                    e(2, eVar, i10, 0);
                    e(4, eVar, i10, 0);
                    i(7).a(eVar.i(i10), 0);
                    return;
                } else {
                    if (i10 == 3 || i10 == 5) {
                        e(3, eVar, i10, 0);
                        e(5, eVar, i10, 0);
                        i(7).a(eVar.i(i10), 0);
                        return;
                    }
                    return;
                }
            }
            d dVarI = i(2);
            d dVarI2 = i(4);
            d dVarI3 = i(3);
            d dVarI4 = i(5);
            boolean z10 = true;
            if ((dVarI == null || !dVarI.h()) && (dVarI2 == null || !dVarI2.h())) {
                e(2, eVar, 2, 0);
                e(4, eVar, 4, 0);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((dVarI3 == null || !dVarI3.h()) && (dVarI4 == null || !dVarI4.h())) {
                e(3, eVar, 3, 0);
                e(5, eVar, 5, 0);
            } else {
                z10 = false;
            }
            if (z2 && z10) {
                i(7).a(eVar.i(7), 0);
                return;
            } else if (z2) {
                i(8).a(eVar.i(8), 0);
                return;
            } else {
                if (z10) {
                    i(9).a(eVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i10 == 2 || i10 == 4)) {
            d dVarI5 = i(2);
            d dVarI6 = eVar.i(i10);
            d dVarI7 = i(4);
            dVarI5.a(dVarI6, 0);
            dVarI7.a(dVarI6, 0);
            i(8).a(dVarI6, 0);
            return;
        }
        if (i == 9 && (i10 == 3 || i10 == 5)) {
            d dVarI8 = eVar.i(i10);
            i(3).a(dVarI8, 0);
            i(5).a(dVarI8, 0);
            i(9).a(dVarI8, 0);
            return;
        }
        if (i == 8 && i10 == 8) {
            i(2).a(eVar.i(2), 0);
            i(4).a(eVar.i(4), 0);
            i(8).a(eVar.i(i10), 0);
            return;
        }
        if (i == 9 && i10 == 9) {
            i(3).a(eVar.i(3), 0);
            i(5).a(eVar.i(5), 0);
            i(9).a(eVar.i(i10), 0);
            return;
        }
        d dVarI9 = i(i);
        d dVarI10 = eVar.i(i10);
        if (dVarI9.i(dVarI10)) {
            if (i == 6) {
                d dVarI11 = i(3);
                d dVarI12 = i(5);
                if (dVarI11 != null) {
                    dVarI11.j();
                }
                if (dVarI12 != null) {
                    dVarI12.j();
                }
            } else if (i == 3 || i == 5) {
                d dVarI13 = i(6);
                if (dVarI13 != null) {
                    dVarI13.j();
                }
                d dVarI14 = i(7);
                if (dVarI14.f != dVarI10) {
                    dVarI14.j();
                }
                d dVarF = i(i).f();
                d dVarI15 = i(9);
                if (dVarI15.h()) {
                    dVarF.j();
                    dVarI15.j();
                }
            } else if (i == 2 || i == 4) {
                d dVarI16 = i(7);
                if (dVarI16.f != dVarI10) {
                    dVarI16.j();
                }
                d dVarF2 = i(i).f();
                d dVarI17 = i(8);
                if (dVarI17.h()) {
                    dVarF2.j();
                    dVarI17.j();
                }
            }
            dVarI9.a(dVarI10, i11);
        }
    }

    public final void f(d dVar, d dVar2, int i) {
        if (dVar.f14117d == this) {
            e(dVar.f14118e, dVar2.f14117d, dVar2.f14118e, i);
        }
    }

    public final void g(v.c cVar) {
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        cVar.k(this.L);
        if (this.f14122a0 > 0) {
            cVar.k(this.M);
        }
    }

    public final void h() {
        if (this.f14127d == null) {
            y.k kVar = new y.k(this);
            kVar.f14418h.f14394e = 4;
            kVar.i.f14394e = 5;
            kVar.f = 0;
            this.f14127d = kVar;
        }
        if (this.f14129e == null) {
            m mVar = new m(this);
            y.f fVar = new y.f(mVar);
            mVar.f14405k = fVar;
            mVar.f14406l = null;
            mVar.f14418h.f14394e = 6;
            mVar.i.f14394e = 7;
            fVar.f14394e = 8;
            mVar.f = 1;
            this.f14129e = mVar;
        }
    }

    public d i(int i) {
        switch (v.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return this.L;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return this.M;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return this.P;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return this.N;
            case 8:
                return this.O;
            default:
                throw new AssertionError(c.c(i));
        }
    }

    public final int j(int i) {
        int[] iArr = this.f14149p0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.f14133g0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final e l(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.L).f) != null && dVar2.f == dVar) {
                return dVar2.f14117d;
            }
            return null;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f;
        if (dVar4 == null || dVar4.f != dVar3) {
            return null;
        }
        return dVar4.f14117d;
    }

    public final e m(int i) {
        d dVar;
        d dVar2;
        if (i != 0) {
            if (i == 1 && (dVar2 = (dVar = this.J).f) != null && dVar2.f == dVar) {
                return dVar2.f14117d;
            }
            return null;
        }
        d dVar3 = this.I;
        d dVar4 = dVar3.f;
        if (dVar4 == null || dVar4.f != dVar3) {
            return null;
        }
        return dVar4.f14117d;
    }

    public void n(StringBuilder sb2) {
        sb2.append("  " + this.f14137j + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.U);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.V);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.Y);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.Z);
        sb2.append("\n");
        p(sb2, "left", this.I);
        p(sb2, "top", this.J);
        p(sb2, "right", this.K);
        p(sb2, "bottom", this.L);
        p(sb2, "baseline", this.M);
        p(sb2, "centerX", this.N);
        p(sb2, "centerY", this.O);
        int i = this.U;
        int i10 = this.f14124b0;
        int[] iArr = this.C;
        int i11 = iArr[0];
        int i12 = this.f14154u;
        int i13 = this.f14151r;
        float f = this.f14156w;
        float[] fArr = this.f14140k0;
        float f4 = fArr[0];
        o(sb2, "    width", i, i10, i11, i12, i13, f);
        int i14 = this.V;
        int i15 = this.f14126c0;
        int i16 = iArr[1];
        int i17 = this.f14157x;
        int i18 = this.f14152s;
        float f10 = this.f14159z;
        float f11 = fArr[1];
        o(sb2, "    height", i14, i15, i16, i17, i18, f10);
        float f12 = this.W;
        int i19 = this.X;
        if (f12 != 0.0f) {
            sb2.append("    dimensionRatio");
            sb2.append(" :  [");
            sb2.append(f12);
            sb2.append(",");
            sb2.append(i19);
            sb2.append("");
            sb2.append("],\n");
        }
        H(sb2, "    horizontalBias", this.f14128d0, 0.5f);
        H(sb2, "    verticalBias", this.f14130e0, 0.5f);
        G(this.f14136i0, 0, "    horizontalChainStyle", sb2);
        G(this.f14138j0, 0, "    verticalChainStyle", sb2);
        sb2.append("  }");
    }

    public final int q() {
        if (this.f14133g0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final int r() {
        e eVar = this.T;
        return (eVar == null || !(eVar instanceof f)) ? this.Y : ((f) eVar).f14167x0 + this.Y;
    }

    public final int s() {
        e eVar = this.T;
        return (eVar == null || !(eVar instanceof f)) ? this.Z : ((f) eVar).f14168y0 + this.Z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            x.d r5 = r4.I
            x.d r5 = r5.f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            x.d r3 = r4.K
            x.d r3 = r3.f
            if (r3 == 0) goto L16
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            x.d r5 = r4.J
            x.d r5 = r5.f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            x.d r3 = r4.L
            x.d r3 = r3.f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            x.d r3 = r4.M
            x.d r3 = r3.f
            if (r3 == 0) goto L36
            r3 = r2
            goto L37
        L36:
            r3 = r1
        L37:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x.e.t(int):boolean");
    }

    public String toString() {
        StringBuilder sbB = v.e.b("");
        sbB.append(this.f14135h0 != null ? l4.a.o(new StringBuilder("id: "), this.f14135h0, " ") : "");
        sbB.append("(");
        sbB.append(this.Y);
        sbB.append(", ");
        sbB.append(this.Z);
        sbB.append(") - (");
        sbB.append(this.U);
        sbB.append(" x ");
        return c.a(sbB, this.V, ")");
    }

    public final boolean u(int i, int i10) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        if (i == 0) {
            d dVar5 = this.I;
            d dVar6 = dVar5.f;
            if (dVar6 == null || !dVar6.f14116c || (dVar4 = (dVar3 = this.K).f) == null || !dVar4.f14116c) {
                return false;
            }
            return (dVar4.d() - dVar3.e()) - (dVar5.e() + dVar5.f.d()) >= i10;
        }
        d dVar7 = this.J;
        d dVar8 = dVar7.f;
        if (dVar8 == null || !dVar8.f14116c || (dVar2 = (dVar = this.L).f) == null || !dVar2.f14116c) {
            return false;
        }
        return (dVar2.d() - dVar.e()) - (dVar7.e() + dVar7.f.d()) >= i10;
    }

    public final void v(int i, int i10, int i11, int i12, e eVar) {
        i(i).b(eVar.i(i10), i11, i12, true);
    }

    public final boolean w(int i) {
        d dVar;
        d dVar2;
        int i10 = i * 2;
        d[] dVarArr = this.Q;
        d dVar3 = dVarArr[i10];
        d dVar4 = dVar3.f;
        return (dVar4 == null || dVar4.f == dVar3 || (dVar2 = (dVar = dVarArr[i10 + 1]).f) == null || dVar2.f != dVar) ? false : true;
    }

    public final boolean x() {
        d dVar = this.I;
        d dVar2 = dVar.f;
        if (dVar2 != null && dVar2.f == dVar) {
            return true;
        }
        d dVar3 = this.K;
        d dVar4 = dVar3.f;
        return dVar4 != null && dVar4.f == dVar3;
    }

    public final boolean y() {
        d dVar = this.J;
        d dVar2 = dVar.f;
        if (dVar2 != null && dVar2.f == dVar) {
            return true;
        }
        d dVar3 = this.L;
        d dVar4 = dVar3.f;
        return dVar4 != null && dVar4.f == dVar3;
    }

    public final boolean z() {
        return this.f14132g && this.f14133g0 != 8;
    }
}
