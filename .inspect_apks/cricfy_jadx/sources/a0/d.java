package a0;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import b0.k;
import b0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final c I;
    public final c J;
    public final c K;
    public final c L;
    public final c M;
    public final c N;
    public final c O;
    public final c P;
    public final c[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public d T;
    public int U;
    public int V;
    public float W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f27a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0.c f28b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f29b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0.c f30c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f31c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f33d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f35e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public View f36f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f38g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f40h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f41i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f42j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f43j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f44k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final float[] f45k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f46l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final d[] f47l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f48m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final d[] f49m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f50n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f51n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f52o;
    public int o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f53p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final int[] f54p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f55q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f56r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f57s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f58t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f59u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f60v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f61w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f62x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f63y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f64z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f32d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f34e = null;
    public final boolean[] f = {true, true};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f37g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39h = -1;
    public int i = -1;

    public d() {
        new HashMap();
        this.f44k = false;
        this.f46l = false;
        this.f48m = false;
        this.f50n = false;
        this.f52o = -1;
        this.f53p = -1;
        this.f55q = 0;
        this.f56r = 0;
        this.f57s = 0;
        this.f58t = new int[2];
        this.f59u = 0;
        this.f60v = 0;
        this.f61w = 1.0f;
        this.f62x = 0;
        this.f63y = 0;
        this.f64z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.D = Float.NaN;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        c cVar = new c(this, 2);
        this.I = cVar;
        c cVar2 = new c(this, 3);
        this.J = cVar2;
        c cVar3 = new c(this, 4);
        this.K = cVar3;
        c cVar4 = new c(this, 5);
        this.L = cVar4;
        c cVar5 = new c(this, 6);
        this.M = cVar5;
        c cVar6 = new c(this, 8);
        this.N = cVar6;
        c cVar7 = new c(this, 9);
        this.O = cVar7;
        c cVar8 = new c(this, 7);
        this.P = cVar8;
        this.Q = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        this.f54p0 = new int[]{1, 1};
        this.T = null;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f27a0 = 0;
        this.f33d0 = 0.5f;
        this.f35e0 = 0.5f;
        this.f38g0 = 0;
        this.f40h0 = null;
        this.f41i0 = 0;
        this.f43j0 = 0;
        this.f45k0 = new float[]{-1.0f, -1.0f};
        this.f47l0 = new d[]{null, null};
        this.f49m0 = new d[]{null, null};
        this.f51n0 = -1;
        this.o0 = -1;
        arrayList.add(cVar);
        arrayList.add(cVar2);
        arrayList.add(cVar3);
        arrayList.add(cVar4);
        arrayList.add(cVar6);
        arrayList.add(cVar7);
        arrayList.add(cVar8);
        arrayList.add(cVar5);
    }

    public static void G(int i, int i10, String str, StringBuilder sb) {
        if (i == i10) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void H(StringBuilder sb, String str, float f, float f10) {
        if (f == f10) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void o(StringBuilder sb, String str, int i, int i10, int i11, int i12, int i13, float f, int i14) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i14 == 1) {
            str2 = "FIXED";
        } else if (i14 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i14 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else {
            if (i14 != 4) {
                throw null;
            }
            str2 = "MATCH_PARENT";
        }
        if (!"FIXED".equals(str2)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(str2);
            sb.append(",\n");
        }
        G(i, 0, "      size", sb);
        G(i10, 0, "      min", sb);
        G(i11, Integer.MAX_VALUE, "      max", sb);
        G(i12, 0, "      matchMin", sb);
        G(i13, 0, "      matchDef", sb);
        H(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void p(StringBuilder sb, String str, c cVar) {
        if (cVar.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(cVar.f);
        sb.append("'");
        if (cVar.f25h != Integer.MIN_VALUE || cVar.f24g != 0) {
            sb.append(",");
            sb.append(cVar.f24g);
            if (cVar.f25h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(cVar.f25h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public boolean A() {
        if (this.f44k) {
            return true;
        }
        return this.I.f21c && this.K.f21c;
    }

    public boolean B() {
        if (this.f46l) {
            return true;
        }
        return this.J.f21c && this.L.f21c;
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
        this.D = Float.NaN;
        this.U = 0;
        this.V = 0;
        this.W = 0.0f;
        this.X = -1;
        this.Y = 0;
        this.Z = 0;
        this.f27a0 = 0;
        this.f29b0 = 0;
        this.f31c0 = 0;
        this.f33d0 = 0.5f;
        this.f35e0 = 0.5f;
        int[] iArr = this.f54p0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f36f0 = null;
        this.f38g0 = 0;
        this.f41i0 = 0;
        this.f43j0 = 0;
        float[] fArr = this.f45k0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f52o = -1;
        this.f53p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f56r = 0;
        this.f57s = 0;
        this.f61w = 1.0f;
        this.f64z = 1.0f;
        this.f60v = Integer.MAX_VALUE;
        this.f63y = Integer.MAX_VALUE;
        this.f59u = 0;
        this.f62x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f37g = true;
        int[] iArr3 = this.f58t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f39h = -1;
        this.i = -1;
    }

    public final void D() {
        d dVar = this.T;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((c) arrayList.get(i)).j();
        }
    }

    public final void E() {
        this.f44k = false;
        this.f46l = false;
        this.f48m = false;
        this.f50n = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) arrayList.get(i);
            cVar.f21c = false;
            cVar.f20b = 0;
        }
    }

    public void F(l7.a aVar) {
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
        this.f27a0 = i;
        this.E = i > 0;
    }

    public final void J(int i, int i10) {
        if (this.f44k) {
            return;
        }
        this.I.l(i);
        this.K.l(i10);
        this.Y = i;
        this.U = i10 - i;
        this.f44k = true;
    }

    public final void K(int i, int i10) {
        if (this.f46l) {
            return;
        }
        this.J.l(i);
        this.L.l(i10);
        this.Z = i;
        this.V = i10 - i;
        if (this.E) {
            this.M.l(i + this.f27a0);
        }
        this.f46l = true;
    }

    public final void L(int i) {
        this.V = i;
        int i10 = this.f31c0;
        if (i < i10) {
            this.V = i10;
        }
    }

    public final void M(int i) {
        this.f54p0[0] = i;
    }

    public final void N(int i) {
        this.f54p0[1] = i;
    }

    public final void O(int i) {
        this.U = i;
        int i10 = this.f29b0;
        if (i < i10) {
            this.U = i10;
        }
    }

    public void P(boolean z10, boolean z11) {
        int i;
        int i10;
        k kVar = this.f32d;
        boolean z12 = z10 & kVar.f1629g;
        m mVar = this.f34e;
        boolean z13 = z11 & mVar.f1629g;
        int i11 = kVar.f1630h.f1607g;
        int i12 = mVar.f1630h.f1607g;
        int i13 = kVar.i.f1607g;
        int i14 = mVar.i.f1607g;
        int i15 = i14 - i12;
        if (i13 - i11 < 0 || i15 < 0 || i11 == Integer.MIN_VALUE || i11 == Integer.MAX_VALUE || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE) {
            i13 = 0;
            i14 = 0;
            i11 = 0;
            i12 = 0;
        }
        int i16 = i13 - i11;
        int i17 = i14 - i12;
        if (z12) {
            this.Y = i11;
        }
        if (z13) {
            this.Z = i12;
        }
        if (this.f38g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f54p0;
        if (z12) {
            if (iArr[0] == 1 && i16 < (i10 = this.U)) {
                i16 = i10;
            }
            this.U = i16;
            int i18 = this.f29b0;
            if (i16 < i18) {
                this.U = i18;
            }
        }
        if (z13) {
            if (iArr[1] == 1 && i17 < (i = this.V)) {
                i17 = i;
            }
            this.V = i17;
            int i19 = this.f31c0;
            if (i17 < i19) {
                this.V = i19;
            }
        }
    }

    public void Q(y.c cVar, boolean z10) {
        int i;
        int i10;
        m mVar;
        k kVar;
        cVar.getClass();
        int iN = y.c.n(this.I);
        int iN2 = y.c.n(this.J);
        int iN3 = y.c.n(this.K);
        int iN4 = y.c.n(this.L);
        if (z10 && (kVar = this.f32d) != null) {
            b0.f fVar = kVar.f1630h;
            if (fVar.f1609j) {
                b0.f fVar2 = kVar.i;
                if (fVar2.f1609j) {
                    iN = fVar.f1607g;
                    iN3 = fVar2.f1607g;
                }
            }
        }
        if (z10 && (mVar = this.f34e) != null) {
            b0.f fVar3 = mVar.f1630h;
            if (fVar3.f1609j) {
                b0.f fVar4 = mVar.i;
                if (fVar4.f1609j) {
                    iN2 = fVar3.f1607g;
                    iN4 = fVar4.f1607g;
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
        if (this.f38g0 == 8) {
            this.U = 0;
            this.V = 0;
            return;
        }
        int[] iArr = this.f54p0;
        int i14 = iArr[0];
        if (i14 == 1 && i12 < (i10 = this.U)) {
            i12 = i10;
        }
        if (iArr[1] == 1 && i13 < (i = this.V)) {
            i13 = i;
        }
        this.U = i12;
        this.V = i13;
        int i15 = this.f31c0;
        if (i13 < i15) {
            this.V = i15;
        }
        int i16 = this.f29b0;
        if (i12 < i16) {
            this.U = i16;
        }
        int i17 = this.f60v;
        if (i17 > 0 && i14 == 3) {
            this.U = Math.min(this.U, i17);
        }
        int i18 = this.f63y;
        if (i18 > 0 && iArr[1] == 3) {
            this.V = Math.min(this.V, i18);
        }
        int i19 = this.U;
        if (i12 != i19) {
            this.f39h = i19;
        }
        int i20 = this.V;
        if (i13 != i20) {
            this.i = i20;
        }
    }

    public final void a(e eVar, y.c cVar, HashSet hashSet, int i, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.b(eVar, cVar, this);
            hashSet.remove(this);
            b(cVar, eVar.W(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.I.f19a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).f22d.a(eVar, cVar, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.K.f19a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).f22d.a(eVar, cVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.f19a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((c) it3.next()).f22d.a(eVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.L.f19a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((c) it4.next()).f22d.a(eVar, cVar, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.M.f19a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((c) it5.next()).f22d.a(eVar, cVar, hashSet, i, true);
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
    /* JADX WARN: Type inference failed for: r58v0, types: [a0.d] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(y.c r59, boolean r60) {
        /*
            Method dump skipped, instruction units count: 1912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.d.b(y.c, boolean):void");
    }

    public boolean c() {
        return this.f38g0 != 8;
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
    public final void d(y.c r30, boolean r31, boolean r32, boolean r33, boolean r34, y.f r35, y.f r36, int r37, boolean r38, a0.c r39, a0.c r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.d.d(y.c, boolean, boolean, boolean, boolean, y.f, y.f, int, boolean, a0.c, a0.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i, d dVar, int i10, int i11) {
        boolean z10;
        if (i == 7) {
            if (i10 != 7) {
                if (i10 == 2 || i10 == 4) {
                    e(2, dVar, i10, 0);
                    e(4, dVar, i10, 0);
                    i(7).a(dVar.i(i10), 0);
                    return;
                } else {
                    if (i10 == 3 || i10 == 5) {
                        e(3, dVar, i10, 0);
                        e(5, dVar, i10, 0);
                        i(7).a(dVar.i(i10), 0);
                        return;
                    }
                    return;
                }
            }
            c cVarI = i(2);
            c cVarI2 = i(4);
            c cVarI3 = i(3);
            c cVarI4 = i(5);
            boolean z11 = true;
            if ((cVarI == null || !cVarI.h()) && (cVarI2 == null || !cVarI2.h())) {
                e(2, dVar, 2, 0);
                e(4, dVar, 4, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((cVarI3 == null || !cVarI3.h()) && (cVarI4 == null || !cVarI4.h())) {
                e(3, dVar, 3, 0);
                e(5, dVar, 5, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                i(7).a(dVar.i(7), 0);
                return;
            } else if (z10) {
                i(8).a(dVar.i(8), 0);
                return;
            } else {
                if (z11) {
                    i(9).a(dVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i10 == 2 || i10 == 4)) {
            c cVarI5 = i(2);
            c cVarI6 = dVar.i(i10);
            c cVarI7 = i(4);
            cVarI5.a(cVarI6, 0);
            cVarI7.a(cVarI6, 0);
            i(8).a(cVarI6, 0);
            return;
        }
        if (i == 9 && (i10 == 3 || i10 == 5)) {
            c cVarI8 = dVar.i(i10);
            i(3).a(cVarI8, 0);
            i(5).a(cVarI8, 0);
            i(9).a(cVarI8, 0);
            return;
        }
        if (i == 8 && i10 == 8) {
            i(2).a(dVar.i(2), 0);
            i(4).a(dVar.i(4), 0);
            i(8).a(dVar.i(i10), 0);
            return;
        }
        if (i == 9 && i10 == 9) {
            i(3).a(dVar.i(3), 0);
            i(5).a(dVar.i(5), 0);
            i(9).a(dVar.i(i10), 0);
            return;
        }
        c cVarI9 = i(i);
        c cVarI10 = dVar.i(i10);
        if (cVarI9.i(cVarI10)) {
            if (i == 6) {
                c cVarI11 = i(3);
                c cVarI12 = i(5);
                if (cVarI11 != null) {
                    cVarI11.j();
                }
                if (cVarI12 != null) {
                    cVarI12.j();
                }
            } else if (i == 3 || i == 5) {
                c cVarI13 = i(6);
                if (cVarI13 != null) {
                    cVarI13.j();
                }
                c cVarI14 = i(7);
                if (cVarI14.f != cVarI10) {
                    cVarI14.j();
                }
                c cVarF = i(i).f();
                c cVarI15 = i(9);
                if (cVarI15.h()) {
                    cVarF.j();
                    cVarI15.j();
                }
            } else if (i == 2 || i == 4) {
                c cVarI16 = i(7);
                if (cVarI16.f != cVarI10) {
                    cVarI16.j();
                }
                c cVarF2 = i(i).f();
                c cVarI17 = i(8);
                if (cVarI17.h()) {
                    cVarF2.j();
                    cVarI17.j();
                }
            }
            cVarI9.a(cVarI10, i11);
        }
    }

    public final void f(c cVar, c cVar2, int i) {
        if (cVar.f22d == this) {
            e(cVar.f23e, cVar2.f22d, cVar2.f23e, i);
        }
    }

    public final void g(y.c cVar) {
        cVar.k(this.I);
        cVar.k(this.J);
        cVar.k(this.K);
        cVar.k(this.L);
        if (this.f27a0 > 0) {
            cVar.k(this.M);
        }
    }

    public final void h() {
        if (this.f32d == null) {
            k kVar = new k(this);
            kVar.f1630h.f1606e = 4;
            kVar.i.f1606e = 5;
            kVar.f = 0;
            this.f32d = kVar;
        }
        if (this.f34e == null) {
            m mVar = new m(this);
            b0.f fVar = new b0.f(mVar);
            mVar.f1617k = fVar;
            mVar.f1618l = null;
            mVar.f1630h.f1606e = 6;
            mVar.i.f1606e = 7;
            fVar.f1606e = 8;
            mVar.f = 1;
            this.f34e = mVar;
        }
    }

    public c i(int i) {
        switch (y.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return this.L;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return this.M;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return this.P;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return this.N;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return this.O;
            default:
                throw new AssertionError(q4.a.w(i));
        }
    }

    public final int j(int i) {
        int[] iArr = this.f54p0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.f38g0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final d l(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i == 1 && (cVar2 = (cVar = this.L).f) != null && cVar2.f == cVar) {
                return cVar2.f22d;
            }
            return null;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f;
        if (cVar4 == null || cVar4.f != cVar3) {
            return null;
        }
        return cVar4.f22d;
    }

    public final d m(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i == 1 && (cVar2 = (cVar = this.J).f) != null && cVar2.f == cVar) {
                return cVar2.f22d;
            }
            return null;
        }
        c cVar3 = this.I;
        c cVar4 = cVar3.f;
        if (cVar4 == null || cVar4.f != cVar3) {
            return null;
        }
        return cVar4.f22d;
    }

    public void n(StringBuilder sb) {
        sb.append("  " + this.f42j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.V);
        sb.append("\n");
        sb.append("    actualLeft:" + this.Y);
        sb.append("\n");
        sb.append("    actualTop:" + this.Z);
        sb.append("\n");
        p(sb, "left", this.I);
        p(sb, "top", this.J);
        p(sb, "right", this.K);
        p(sb, "bottom", this.L);
        p(sb, "baseline", this.M);
        p(sb, "centerX", this.N);
        p(sb, "centerY", this.O);
        int i = this.U;
        int i10 = this.f29b0;
        int[] iArr = this.C;
        int i11 = iArr[0];
        int i12 = this.f59u;
        int i13 = this.f56r;
        float f = this.f61w;
        int[] iArr2 = this.f54p0;
        int i14 = iArr2[0];
        float[] fArr = this.f45k0;
        float f10 = fArr[0];
        o(sb, "    width", i, i10, i11, i12, i13, f, i14);
        int i15 = this.V;
        int i16 = this.f31c0;
        int i17 = iArr[1];
        int i18 = this.f62x;
        int i19 = this.f57s;
        float f11 = this.f64z;
        int i20 = iArr2[1];
        float f12 = fArr[1];
        o(sb, "    height", i15, i16, i17, i18, i19, f11, i20);
        float f13 = this.W;
        int i21 = this.X;
        if (f13 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f13);
            sb.append(",");
            sb.append(i21);
            sb.append("");
            sb.append("],\n");
        }
        H(sb, "    horizontalBias", this.f33d0, 0.5f);
        H(sb, "    verticalBias", this.f35e0, 0.5f);
        G(this.f41i0, 0, "    horizontalChainStyle", sb);
        G(this.f43j0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int q() {
        if (this.f38g0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final int r() {
        d dVar = this.T;
        return (dVar == null || !(dVar instanceof e)) ? this.Y : ((e) dVar).f72x0 + this.Y;
    }

    public final int s() {
        d dVar = this.T;
        return (dVar == null || !(dVar instanceof e)) ? this.Z : ((e) dVar).f73y0 + this.Z;
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
            a0.c r5 = r4.I
            a0.c r5 = r5.f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            a0.c r3 = r4.K
            a0.c r3 = r3.f
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
            a0.c r5 = r4.J
            a0.c r5 = r5.f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            a0.c r3 = r4.L
            a0.c r3 = r3.f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            a0.c r3 = r4.M
            a0.c r3 = r3.f
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
        throw new UnsupportedOperationException("Method not decompiled: a0.d.t(int):boolean");
    }

    public String toString() {
        StringBuilder sbB = y.e.b("");
        sbB.append(this.f40h0 != null ? q4.a.q(new StringBuilder("id: "), this.f40h0, " ") : "");
        sbB.append("(");
        sbB.append(this.Y);
        sbB.append(", ");
        sbB.append(this.Z);
        sbB.append(") - (");
        sbB.append(this.U);
        sbB.append(" x ");
        return q4.a.o(sbB, this.V, ")");
    }

    public final boolean u(int i, int i10) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if (i == 0) {
            c cVar5 = this.I;
            c cVar6 = cVar5.f;
            if (cVar6 == null || !cVar6.f21c || (cVar4 = (cVar3 = this.K).f) == null || !cVar4.f21c) {
                return false;
            }
            return (cVar4.d() - cVar3.e()) - (cVar5.e() + cVar5.f.d()) >= i10;
        }
        c cVar7 = this.J;
        c cVar8 = cVar7.f;
        if (cVar8 == null || !cVar8.f21c || (cVar2 = (cVar = this.L).f) == null || !cVar2.f21c) {
            return false;
        }
        return (cVar2.d() - cVar.e()) - (cVar7.e() + cVar7.f.d()) >= i10;
    }

    public final void v(int i, int i10, int i11, int i12, d dVar) {
        i(i).b(dVar.i(i10), i11, i12, true);
    }

    public final boolean w(int i) {
        c cVar;
        c cVar2;
        int i10 = i * 2;
        c[] cVarArr = this.Q;
        c cVar3 = cVarArr[i10];
        c cVar4 = cVar3.f;
        return (cVar4 == null || cVar4.f == cVar3 || (cVar2 = (cVar = cVarArr[i10 + 1]).f) == null || cVar2.f != cVar) ? false : true;
    }

    public final boolean x() {
        c cVar = this.I;
        c cVar2 = cVar.f;
        if (cVar2 != null && cVar2.f == cVar) {
            return true;
        }
        c cVar3 = this.K;
        c cVar4 = cVar3.f;
        return cVar4 != null && cVar4.f == cVar3;
    }

    public final boolean y() {
        c cVar = this.J;
        c cVar2 = cVar.f;
        if (cVar2 != null && cVar2.f == cVar) {
            return true;
        }
        c cVar3 = this.L;
        c cVar4 = cVar3.f;
        return cVar4 != null && cVar4.f == cVar3;
    }

    public final boolean z() {
        return this.f37g && this.f38g0 != 8;
    }
}
