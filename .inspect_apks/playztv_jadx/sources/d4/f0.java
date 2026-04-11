package d4;

import aa.c1;
import aa.j0;
import aa.l0;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements w2.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1.u f3847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f3848e;
    public final f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t3.k f3849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray f3850h;
    public final SparseBooleanArray i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f3851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f3852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b3.a f3853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w2.q f3854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i0 f3859r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3860s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3861t;

    public f0(int i, int i10, t3.k kVar, s1.z zVar, f fVar) {
        this.f = fVar;
        this.f3844a = i;
        this.f3845b = i10;
        this.f3849g = kVar;
        if (i == 1 || i == 2) {
            this.f3846c = Collections.singletonList(zVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f3846c = arrayList;
            arrayList.add(zVar);
        }
        this.f3847d = new s1.u(0, new byte[9400]);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.i = sparseBooleanArray;
        this.f3851j = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f3850h = sparseArray;
        this.f3848e = new SparseIntArray();
        this.f3852k = new y(1);
        this.f3854m = w2.q.f13663t;
        this.f3861t = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i11 = 0; i11 < size; i11++) {
            sparseArray.put(sparseArray2.keyAt(i11), (i0) sparseArray2.valueAt(i11));
        }
        sparseArray.put(0, new c0(new h4.z(this)));
        this.f3859r = null;
    }

    @Override // w2.o
    public final void c(w2.q qVar) {
        if ((this.f3845b & 1) == 0) {
            qVar = new a2.c(qVar, this.f3849g);
        }
        this.f3854m = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // w2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(w2.p r7) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r6 = this;
            s1.u r0 = r6.f3847d
            byte[] r0 = r0.f11709a
            w2.l r7 = (w2.l) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.r(r0, r1, r2, r1)
            r2 = r1
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = r1
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.n(r2, r1)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.f0.e(w2.p):boolean");
    }

    @Override // w2.o
    public final void f(long j5, long j8) {
        b3.a aVar;
        s1.d.g(this.f3844a != 2);
        List list = this.f3846c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            s1.z zVar = (s1.z) list.get(i);
            boolean z2 = zVar.e() == -9223372036854775807L;
            if (!z2) {
                long jD = zVar.d();
                z2 = (jD == -9223372036854775807L || jD == 0 || jD == j8) ? false : true;
            }
            if (z2) {
                zVar.g(j8);
            }
        }
        if (j8 != 0 && (aVar = this.f3853l) != null) {
            aVar.d(j8);
        }
        this.f3847d.G(0);
        this.f3848e.clear();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f3850h;
            if (i10 >= sparseArray.size()) {
                this.f3860s = 0;
                return;
            } else {
                ((i0) sparseArray.valueAt(i10)).a();
                i10++;
            }
        }
    }

    @Override // w2.o
    public final List g() {
        aa.h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.util.SparseArray] */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.util.SparseBooleanArray] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [d4.i0] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // w2.o
    public final int l(w2.p pVar, w2.s sVar) throws n0 {
        w2.p pVar2;
        ?? r12;
        int i;
        int i10;
        int i11;
        int i12;
        boolean z2;
        long length = pVar.getLength();
        int i13 = this.f3844a;
        boolean z10 = i13 == 2;
        if (this.f3856o) {
            long j5 = -9223372036854775807L;
            y yVar = this.f3852k;
            if (length != -1 && !z10 && !yVar.f4067d) {
                int i14 = this.f3861t;
                s1.z zVar = yVar.f4065b;
                s1.u uVar = yVar.f4066c;
                if (i14 <= 0) {
                    yVar.a(pVar);
                    return 0;
                }
                if (yVar.f) {
                    if (yVar.f4070h == -9223372036854775807L) {
                        yVar.a(pVar);
                        return 0;
                    }
                    if (yVar.f4068e) {
                        long j8 = yVar.f4069g;
                        if (j8 == -9223372036854775807L) {
                            yVar.a(pVar);
                            return 0;
                        }
                        yVar.i = zVar.c(yVar.f4070h) - zVar.b(j8);
                        yVar.a(pVar);
                        return 0;
                    }
                    int iMin = (int) Math.min(112800, pVar.getLength());
                    long j10 = 0;
                    if (pVar.getPosition() != j10) {
                        sVar.f13664a = j10;
                        return 1;
                    }
                    uVar.G(iMin);
                    pVar.l();
                    pVar.w(uVar.f11709a, 0, iMin);
                    int i15 = uVar.f11710b;
                    int i16 = uVar.f11711c;
                    while (true) {
                        if (i15 >= i16) {
                            break;
                        }
                        if (uVar.f11709a[i15] == 71) {
                            long jC = ga.b.C(uVar, i15, i14);
                            if (jC != -9223372036854775807L) {
                                j5 = jC;
                                break;
                            }
                        }
                        i15++;
                    }
                    yVar.f4069g = j5;
                    yVar.f4068e = true;
                    return 0;
                }
                long length2 = pVar.getLength();
                int iMin2 = (int) Math.min(112800, length2);
                long j11 = length2 - ((long) iMin2);
                if (pVar.getPosition() != j11) {
                    sVar.f13664a = j11;
                    return 1;
                }
                uVar.G(iMin2);
                pVar.l();
                pVar.w(uVar.f11709a, 0, iMin2);
                int i17 = uVar.f11710b;
                int i18 = uVar.f11711c;
                int i19 = i18 - 188;
                while (true) {
                    if (i19 < i17) {
                        break;
                    }
                    byte[] bArr = uVar.f11709a;
                    int i20 = -4;
                    int i21 = 0;
                    while (true) {
                        if (i20 > 4) {
                            break;
                        }
                        int i22 = (i20 * 188) + i19;
                        if (i22 < i17 || i22 >= i18 || bArr[i22] != 71) {
                            i21 = 0;
                        } else {
                            i21++;
                            if (i21 == 5) {
                                long jC2 = ga.b.C(uVar, i19, i14);
                                if (jC2 != -9223372036854775807L) {
                                    j5 = jC2;
                                    break;
                                }
                            }
                        }
                        i20++;
                    }
                    i19--;
                }
                yVar.f4070h = j5;
                yVar.f = true;
                return 0;
            }
            if (this.f3857p) {
                i = 1;
                z2 = false;
                i10 = i13;
            } else {
                this.f3857p = true;
                long j12 = yVar.i;
                if (j12 != -9223372036854775807L) {
                    i = 1;
                    z2 = false;
                    i10 = i13;
                    b3.a aVar = new b3.a(new w2.f(), new l0(this.f3861t, yVar.f4065b), j12, 1 + j12, 0L, length, 188L, 940);
                    this.f3853l = aVar;
                    this.f3854m.j(aVar.f1790a);
                } else {
                    i = 1;
                    z2 = false;
                    i10 = i13;
                    this.f3854m.j(new w2.t(j12));
                }
            }
            if (this.f3858q) {
                this.f3858q = z2;
                f(0L, 0L);
                if (pVar.getPosition() != 0) {
                    sVar.f13664a = 0L;
                    return i;
                }
            }
            b3.a aVar2 = this.f3853l;
            if (aVar2 != null && aVar2.f1792c != null) {
                return aVar2.b(pVar, sVar);
            }
            pVar2 = pVar;
            r12 = z2;
        } else {
            pVar2 = pVar;
            r12 = 0;
            i = 1;
            i10 = i13;
        }
        s1.u uVar2 = this.f3847d;
        byte[] bArr2 = uVar2.f11709a;
        if (9400 - uVar2.f11710b < 188) {
            int iA = uVar2.a();
            if (iA > 0) {
                System.arraycopy(bArr2, uVar2.f11710b, bArr2, r12, iA);
            }
            uVar2.H(iA, bArr2);
        }
        while (true) {
            int iA2 = uVar2.a();
            ?? r72 = this.f3850h;
            if (iA2 >= 188) {
                int i23 = uVar2.f11710b;
                int i24 = uVar2.f11711c;
                byte[] bArr3 = uVar2.f11709a;
                int i25 = i23;
                while (i25 < i24 && bArr3[i25] != 71) {
                    i25++;
                }
                uVar2.J(i25);
                int i26 = i25 + 188;
                if (i26 > i24) {
                    int i27 = (i25 - i23) + this.f3860s;
                    this.f3860s = i27;
                    i11 = i10;
                    i12 = 2;
                    if (i11 == 2 && i27 > 376) {
                        throw n0.a(null, "Cannot find sync byte. Most likely not a Transport Stream.");
                    }
                } else {
                    i11 = i10;
                    i12 = 2;
                    this.f3860s = r12;
                }
                int i28 = uVar2.f11711c;
                if (i26 > i28) {
                    return r12;
                }
                int iJ = uVar2.j();
                if ((8388608 & iJ) != 0) {
                    uVar2.J(i26);
                    return r12;
                }
                ?? r92 = (4194304 & iJ) != 0 ? 1 : r12;
                int i29 = (2096896 & iJ) >> 8;
                ?? r11 = (iJ & 32) != 0 ? 1 : r12;
                ?? r82 = (iJ & 16) != 0 ? (i0) r72.get(i29) : 0;
                if (r82 == 0) {
                    uVar2.J(i26);
                    return r12;
                }
                if (i11 != i12) {
                    int i30 = iJ & 15;
                    SparseIntArray sparseIntArray = this.f3848e;
                    int i31 = sparseIntArray.get(i29, i30 - 1);
                    sparseIntArray.put(i29, i30);
                    if (i31 == i30) {
                        uVar2.J(i26);
                        return r12;
                    }
                    if (i30 != ((i31 + 1) & 15)) {
                        r82.a();
                    }
                }
                if (r11 != 0) {
                    int iX = uVar2.x();
                    r92 = (r92 == true ? 1 : 0) | ((uVar2.x() & 64) != 0 ? i12 : r12);
                    uVar2.K(iX - 1);
                }
                boolean z11 = this.f3856o;
                if (i11 == i12 || z11 || !this.f3851j.get(i29, r12)) {
                    uVar2.I(i26);
                    r82.b(r92, uVar2);
                    uVar2.I(i28);
                }
                if (i11 != i12 && !z11 && this.f3856o && length != -1) {
                    this.f3858q = true;
                }
                uVar2.J(i26);
                return r12;
            }
            int i32 = uVar2.f11711c;
            int i33 = pVar2.read(bArr2, i32, 9400 - i32);
            if (i33 == -1) {
                for (?? r42 = r12; r42 < r72.size(); r42++) {
                    i0 i0Var = (i0) r72.valueAt(r42);
                    if (i0Var instanceof x) {
                        x xVar = (x) i0Var;
                        ?? r32 = (!z10 || xVar.d()) ? i : r12;
                        if (xVar.f4056c == 3 && xVar.f4061j == -1 && ((!z10 || !(xVar.f4054a instanceof k)) && r32 != 0)) {
                            xVar.b(i, new s1.u());
                        }
                    }
                    i = 1;
                }
                return -1;
            }
            uVar2.I(i32 + i33);
            i = 1;
        }
    }

    @Override // w2.o
    public final w2.o a() {
        return this;
    }

    @Override // w2.o
    public final void release() {
    }
}
