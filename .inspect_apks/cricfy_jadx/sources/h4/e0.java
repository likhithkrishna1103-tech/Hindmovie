package h4;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ua.i0;
import ua.z0;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements a3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f5607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y1.t f5608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f5609e;
    public final f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x3.n f5610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray f5611h;
    public final SparseBooleanArray i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f5612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f5613k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f3.b f5614l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a3.r f5615m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5616n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5617o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5618p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5619q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h0 f5620r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5621s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5622t;

    public e0(int i, int i10, x3.n nVar, y1.y yVar, f fVar) {
        this.f = fVar;
        this.f5605a = i;
        this.f5606b = i10;
        this.f5610g = nVar;
        if (i == 1 || i == 2) {
            this.f5607c = Collections.singletonList(yVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f5607c = arrayList;
            arrayList.add(yVar);
        }
        this.f5608d = new y1.t(0, new byte[9400]);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.i = sparseBooleanArray;
        this.f5612j = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f5611h = sparseArray;
        this.f5609e = new SparseIntArray();
        this.f5613k = new y(1);
        this.f5615m = a3.r.f226a;
        this.f5622t = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i11 = 0; i11 < size; i11++) {
            sparseArray.put(sparseArray2.keyAt(i11), (h0) sparseArray2.valueAt(i11));
        }
        sparseArray.put(0, new c0(new l4.c0(this)));
        this.f5620r = null;
    }

    @Override // a3.p
    public final void c(a3.r rVar) {
        if ((this.f5606b & 1) == 0) {
            rVar = new com.bumptech.glide.l(rVar, this.f5610g);
        }
        this.f5615m = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        f3.b bVar;
        y1.d.g(this.f5605a != 2);
        List list = this.f5607c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            y1.y yVar = (y1.y) list.get(i);
            boolean z10 = yVar.e() == -9223372036854775807L;
            if (!z10) {
                long jD = yVar.d();
                z10 = (jD == -9223372036854775807L || jD == 0 || jD == j7) ? false : true;
            }
            if (z10) {
                yVar.g(j7);
            }
        }
        if (j7 != 0 && (bVar = this.f5614l) != null) {
            bVar.d(j7);
        }
        this.f5608d.G(0);
        this.f5609e.clear();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.f5611h;
            if (i10 >= sparseArray.size()) {
                this.f5621s = 0;
                return;
            } else {
                ((h0) sparseArray.valueAt(i10)).a();
                i10++;
            }
        }
    }

    @Override // a3.p
    public final List f() {
        ua.g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(a3.q r7) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r6 = this;
            y1.t r0 = r6.f5608d
            byte[] r0 = r0.f14609a
            a3.l r7 = (a3.l) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.v(r0, r1, r2, r1)
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
            r7.r(r2, r1)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.e0.h(a3.q):boolean");
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
    /* JADX WARN: Type inference failed for: r8v2, types: [h4.h0] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // a3.p
    public final int i(a3.q qVar, a3.t tVar) throws n0 {
        a3.q qVar2;
        ?? r12;
        int i;
        int i10;
        int i11;
        int i12;
        boolean z10;
        long length = qVar.getLength();
        int i13 = this.f5605a;
        boolean z11 = i13 == 2;
        if (this.f5617o) {
            long j4 = -9223372036854775807L;
            y yVar = this.f5613k;
            if (length != -1 && !z11 && !yVar.f5830d) {
                int i14 = this.f5622t;
                y1.y yVar2 = yVar.f5828b;
                y1.t tVar2 = yVar.f5829c;
                if (i14 <= 0) {
                    yVar.a(qVar);
                    return 0;
                }
                if (yVar.f) {
                    if (yVar.f5833h == -9223372036854775807L) {
                        yVar.a(qVar);
                        return 0;
                    }
                    if (yVar.f5831e) {
                        long j7 = yVar.f5832g;
                        if (j7 == -9223372036854775807L) {
                            yVar.a(qVar);
                            return 0;
                        }
                        yVar.i = yVar2.c(yVar.f5833h) - yVar2.b(j7);
                        yVar.a(qVar);
                        return 0;
                    }
                    int iMin = (int) Math.min(112800, qVar.getLength());
                    long j10 = 0;
                    if (qVar.getPosition() != j10) {
                        tVar.f227a = j10;
                        return 1;
                    }
                    tVar2.G(iMin);
                    qVar.k();
                    qVar.z(tVar2.f14609a, 0, iMin);
                    int i15 = tVar2.f14610b;
                    int i16 = tVar2.f14611c;
                    while (true) {
                        if (i15 >= i16) {
                            break;
                        }
                        if (tVar2.f14609a[i15] == 71) {
                            long jU = ab.b.u(tVar2, i15, i14);
                            if (jU != -9223372036854775807L) {
                                j4 = jU;
                                break;
                            }
                        }
                        i15++;
                    }
                    yVar.f5832g = j4;
                    yVar.f5831e = true;
                    return 0;
                }
                long length2 = qVar.getLength();
                int iMin2 = (int) Math.min(112800, length2);
                long j11 = length2 - ((long) iMin2);
                if (qVar.getPosition() != j11) {
                    tVar.f227a = j11;
                    return 1;
                }
                tVar2.G(iMin2);
                qVar.k();
                qVar.z(tVar2.f14609a, 0, iMin2);
                int i17 = tVar2.f14610b;
                int i18 = tVar2.f14611c;
                int i19 = i18 - 188;
                while (true) {
                    if (i19 < i17) {
                        break;
                    }
                    byte[] bArr = tVar2.f14609a;
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
                                long jU2 = ab.b.u(tVar2, i19, i14);
                                if (jU2 != -9223372036854775807L) {
                                    j4 = jU2;
                                    break;
                                }
                            }
                        }
                        i20++;
                    }
                    i19--;
                }
                yVar.f5833h = j4;
                yVar.f = true;
                return 0;
            }
            if (this.f5618p) {
                i = 1;
                z10 = false;
                i10 = i13;
            } else {
                this.f5618p = true;
                long j12 = yVar.i;
                if (j12 != -9223372036854775807L) {
                    i = 1;
                    z10 = false;
                    i10 = i13;
                    f3.b bVar = new f3.b(new fc.e(1), new f3.a(this.f5622t, yVar.f5828b), j12, 1 + j12, 0L, length, 188L, 940);
                    this.f5614l = bVar;
                    this.f5615m.s(bVar.f3938a);
                } else {
                    i = 1;
                    z10 = false;
                    i10 = i13;
                    this.f5615m.s(new a3.u(j12));
                }
            }
            if (this.f5619q) {
                this.f5619q = z10;
                e(0L, 0L);
                if (qVar.getPosition() != 0) {
                    tVar.f227a = 0L;
                    return i;
                }
            }
            f3.b bVar2 = this.f5614l;
            if (bVar2 != null && bVar2.f3940c != null) {
                return bVar2.b(qVar, tVar);
            }
            qVar2 = qVar;
            r12 = z10;
        } else {
            qVar2 = qVar;
            r12 = 0;
            i = 1;
            i10 = i13;
        }
        y1.t tVar3 = this.f5608d;
        byte[] bArr2 = tVar3.f14609a;
        if (9400 - tVar3.f14610b < 188) {
            int iA = tVar3.a();
            if (iA > 0) {
                System.arraycopy(bArr2, tVar3.f14610b, bArr2, r12, iA);
            }
            tVar3.H(iA, bArr2);
        }
        while (true) {
            int iA2 = tVar3.a();
            ?? r72 = this.f5611h;
            if (iA2 >= 188) {
                int i23 = tVar3.f14610b;
                int i24 = tVar3.f14611c;
                byte[] bArr3 = tVar3.f14609a;
                int i25 = i23;
                while (i25 < i24 && bArr3[i25] != 71) {
                    i25++;
                }
                tVar3.J(i25);
                int i26 = i25 + 188;
                if (i26 > i24) {
                    int i27 = (i25 - i23) + this.f5621s;
                    this.f5621s = i27;
                    i11 = i10;
                    i12 = 2;
                    if (i11 == 2 && i27 > 376) {
                        throw n0.a(null, "Cannot find sync byte. Most likely not a Transport Stream.");
                    }
                } else {
                    i11 = i10;
                    i12 = 2;
                    this.f5621s = r12;
                }
                int i28 = tVar3.f14611c;
                if (i26 > i28) {
                    return r12;
                }
                int iJ = tVar3.j();
                if ((8388608 & iJ) != 0) {
                    tVar3.J(i26);
                    return r12;
                }
                ?? r92 = (4194304 & iJ) != 0 ? 1 : r12;
                int i29 = (2096896 & iJ) >> 8;
                ?? r11 = (iJ & 32) != 0 ? 1 : r12;
                ?? r82 = (iJ & 16) != 0 ? (h0) r72.get(i29) : 0;
                if (r82 == 0) {
                    tVar3.J(i26);
                    return r12;
                }
                if (i11 != i12) {
                    int i30 = iJ & 15;
                    SparseIntArray sparseIntArray = this.f5609e;
                    int i31 = sparseIntArray.get(i29, i30 - 1);
                    sparseIntArray.put(i29, i30);
                    if (i31 == i30) {
                        tVar3.J(i26);
                        return r12;
                    }
                    if (i30 != ((i31 + 1) & 15)) {
                        r82.a();
                    }
                }
                if (r11 != 0) {
                    int iX = tVar3.x();
                    r92 = (r92 == true ? 1 : 0) | ((tVar3.x() & 64) != 0 ? i12 : r12);
                    tVar3.K(iX - 1);
                }
                boolean z12 = this.f5617o;
                if (i11 == i12 || z12 || !this.f5612j.get(i29, r12)) {
                    tVar3.I(i26);
                    r82.b(r92, tVar3);
                    tVar3.I(i28);
                }
                if (i11 != i12 && !z12 && this.f5617o && length != -1) {
                    this.f5619q = true;
                }
                tVar3.J(i26);
                return r12;
            }
            int i32 = tVar3.f14611c;
            int i33 = qVar2.read(bArr2, i32, 9400 - i32);
            if (i33 == -1) {
                for (?? r42 = r12; r42 < r72.size(); r42++) {
                    h0 h0Var = (h0) r72.valueAt(r42);
                    if (h0Var instanceof x) {
                        x xVar = (x) h0Var;
                        ?? r32 = (!z11 || xVar.e()) ? i : r12;
                        if (xVar.f5819c == 3 && xVar.f5824j == -1 && ((!z11 || !(xVar.f5817a instanceof k)) && r32 != 0)) {
                            xVar.b(i, new y1.t());
                        }
                    }
                    i = 1;
                }
                return -1;
            }
            tVar3.I(i32 + i33);
            i = 1;
        }
    }

    @Override // a3.p
    public final a3.p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
