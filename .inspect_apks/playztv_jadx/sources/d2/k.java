package d2;

import a2.c1;
import aa.j0;
import android.os.SystemClock;
import e6.f0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k8.a0;
import k8.b0;
import p1.m0;
import p1.q;
import r2.r;
import v1.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements p2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2.n f3736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ub.o f3737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f3738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v1.h f3740e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f3742h;
    public final i[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f3743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e2.c f3744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o2.b f3746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3747n;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [d2.k, java.lang.Object] */
    public k(f0 f0Var, s2.n nVar, e2.c cVar, ub.o oVar, int i, int[] iArr, r rVar, int i10, v1.h hVar, long j5, int i11, boolean z2, ArrayList arrayList, n nVar2) {
        i[] iVarArr;
        int i12;
        q qVar;
        e2.m mVar;
        w2.o kVar;
        p2.e eVar;
        ?? obj = new Object();
        obj.f3736a = nVar;
        obj.f3744k = cVar;
        obj.f3737b = oVar;
        obj.f3738c = iArr;
        obj.f3743j = rVar;
        obj.f3739d = i10;
        obj.f3740e = hVar;
        obj.f3745l = i;
        obj.f = j5;
        obj.f3741g = i11;
        n nVar3 = nVar2;
        obj.f3742h = nVar3;
        long jD = cVar.d(i);
        ArrayList arrayListH = obj.h();
        obj.i = new i[rVar.length()];
        int i13 = 0;
        int i14 = 0;
        k kVar2 = obj;
        while (i14 < kVar2.i.length) {
            e2.m mVar2 = (e2.m) arrayListH.get(rVar.e(i14));
            e2.b bVarU = oVar.U(mVar2.f4344v);
            i[] iVarArr2 = kVar2.i;
            e2.b bVar = bVarU == null ? (e2.b) mVar2.f4344v.get(i13) : bVarU;
            q qVar2 = mVar2.f4343u;
            f0Var.getClass();
            String str = qVar2.f10022m;
            if (!m0.n(str)) {
                if (str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska"))) {
                    i12 = i14;
                    mVar = mVar2;
                    qVar = qVar2;
                    iVarArr = iVarArr2;
                    kVar = new o3.d((b0) f0Var.f4499v, f0Var.f4498u ? 1 : 3);
                } else if (Objects.equals(str, "image/jpeg")) {
                    kVar = new e3.a(1);
                } else if (Objects.equals(str, "image/png")) {
                    kVar = new a3.a(1);
                } else {
                    int i15 = z2 ? 4 : 0;
                    iVarArr = iVarArr2;
                    i12 = i14;
                    qVar = qVar2;
                    int i16 = f0Var.f4498u ? i15 : i15 | 32;
                    mVar = mVar2;
                    kVar = new q3.k((b0) f0Var.f4499v, i16, null, null, arrayList, nVar3);
                }
                eVar = new p2.e(kVar, i10, qVar);
                long j8 = jD;
                iVarArr[i12] = new i(j8, mVar, bVar, eVar, 0L, mVar.e());
                i14 = i12 + 1;
                kVar2 = this;
                nVar3 = nVar2;
                jD = j8;
                i13 = 0;
            } else if (f0Var.f4498u) {
                kVar = new t3.h(((b0) f0Var.f4499v).f(qVar2), qVar2);
            } else {
                eVar = null;
                i12 = i14;
                mVar = mVar2;
                iVarArr = iVarArr2;
                long j82 = jD;
                iVarArr[i12] = new i(j82, mVar, bVar, eVar, 0L, mVar.e());
                i14 = i12 + 1;
                kVar2 = this;
                nVar3 = nVar2;
                jD = j82;
                i13 = 0;
            }
            i12 = i14;
            mVar = mVar2;
            qVar = qVar2;
            iVarArr = iVarArr2;
            eVar = new p2.e(kVar, i10, qVar);
            long j822 = jD;
            iVarArr[i12] = new i(j822, mVar, bVar, eVar, 0L, mVar.e());
            i14 = i12 + 1;
            kVar2 = this;
            nVar3 = nVar2;
            jD = j822;
            i13 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    @Override // p2.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(long r20, a2.d2 r22) {
        /*
            r19 = this;
            r1 = r20
            r7 = r19
            d2.i[] r0 = r7.i
            int r3 = r0.length
            r4 = 0
        L8:
            if (r4 >= r3) goto L64
            r5 = r0[r4]
            java.lang.Object r6 = r5.f3733g
            d2.h r6 = (d2.h) r6
            long r8 = r5.f3730c
            java.lang.Object r10 = r5.f3733g
            d2.h r10 = (d2.h) r10
            if (r6 == 0) goto L5f
            long r11 = r5.d()
            r13 = 0
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 != 0) goto L23
            goto L5f
        L23:
            s1.d.h(r10)
            long r3 = r5.f3729b
            long r3 = r10.c(r1, r3)
            long r3 = r3 + r8
            r13 = r3
            long r3 = r5.f(r13)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L58
            r15 = -1
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            r15 = 1
            if (r0 == 0) goto L4f
            s1.d.h(r10)
            long r17 = r10.y()
            long r17 = r17 + r8
            long r17 = r17 + r11
            long r17 = r17 - r15
            int r0 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r0 >= 0) goto L58
        L4f:
            long r8 = r13 + r15
            long r5 = r5.f(r8)
        L55:
            r0 = r22
            goto L5a
        L58:
            r5 = r3
            goto L55
        L5a:
            long r0 = r0.a(r1, r3, r5)
            return r0
        L5f:
            int r4 = r4 + 1
            r1 = r20
            goto L8
        L64:
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.k.a(long, a2.d2):long");
    }

    @Override // p2.j
    public final void b() throws o2.b {
        o2.b bVar = this.f3746m;
        if (bVar != null) {
            throw bVar;
        }
        this.f3736a.b();
    }

    @Override // p2.j
    public final boolean c(p2.f fVar, boolean z2, e6.i iVar, a0 a0Var) {
        long jMax;
        if (z2) {
            n nVar = this.f3742h;
            if (nVar != null) {
                long j5 = nVar.f3759d;
                boolean z10 = j5 != -9223372036854775807L && j5 < fVar.A;
                o oVar = nVar.f3760e;
                if (oVar.f3766z.f4302d) {
                    if (!oVar.B) {
                        if (z10) {
                            if (oVar.A) {
                                oVar.B = true;
                                oVar.A = false;
                                g gVar = (g) oVar.f3762v.f14088v;
                                gVar.X.removeCallbacks(gVar.Q);
                                gVar.E();
                                return true;
                            }
                        }
                    }
                    return true;
                }
            }
            boolean z11 = this.f3744k.f4302d;
            i[] iVarArr = this.i;
            if (!z11 && (fVar instanceof p2.m)) {
                IOException iOException = (IOException) iVar.f4523v;
                if ((iOException instanceof x) && ((x) iOException).f13177x == 404) {
                    i iVar2 = iVarArr[this.f3743j.g(fVar.f10146x)];
                    long jD = iVar2.d();
                    if (jD != -1 && jD != 0) {
                        h hVar = (h) iVar2.f3733g;
                        s1.d.h(hVar);
                        if (((p2.m) fVar).a() > ((hVar.y() + iVar2.f3730c) + jD) - 1) {
                            this.f3747n = true;
                            return true;
                        }
                    }
                }
            }
            i iVar3 = iVarArr[this.f3743j.g(fVar.f10146x)];
            e2.m mVar = (e2.m) iVar3.f3732e;
            e2.b bVar = (e2.b) iVar3.f;
            j0 j0Var = mVar.f4344v;
            ub.o oVar2 = this.f3737b;
            e2.b bVarU = oVar2.U(j0Var);
            if (bVarU == null || bVar.equals(bVarU)) {
                r rVar = this.f3743j;
                j0 j0Var2 = ((e2.m) iVar3.f3732e).f4344v;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int length = rVar.length();
                int i = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    if (rVar.b(i10, jElapsedRealtime)) {
                        i++;
                    }
                }
                HashSet hashSet = new HashSet();
                for (int i11 = 0; i11 < j0Var2.size(); i11++) {
                    hashSet.add(Integer.valueOf(((e2.b) j0Var2.get(i11)).f4297c));
                }
                int size = hashSet.size();
                HashSet hashSet2 = new HashSet();
                ArrayList arrayListG = oVar2.g(j0Var2);
                for (int i12 = 0; i12 < arrayListG.size(); i12++) {
                    hashSet2.add(Integer.valueOf(((e2.b) arrayListG.get(i12)).f4297c));
                }
                j9.j0 j0Var3 = new j9.j0(size, size - hashSet2.size(), length, i);
                if (j0Var3.a(2) || j0Var3.a(1)) {
                    a0Var.getClass();
                    e4.f fVarJ = a0.j(j0Var3, iVar);
                    if (fVarJ != null) {
                        long j8 = fVarJ.f4420b;
                        int i13 = fVarJ.f4419a;
                        if (j0Var3.a(i13)) {
                            if (i13 == 2) {
                                r rVar2 = this.f3743j;
                                return rVar2.o(rVar2.g(fVar.f10146x), j8);
                            }
                            if (i13 == 1) {
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime() + j8;
                                String str = bVar.f4296b;
                                HashMap map = (HashMap) oVar2.f12868v;
                                if (map.containsKey(str)) {
                                    Long l10 = (Long) map.get(str);
                                    int i14 = s1.b0.f11647a;
                                    jMax = Math.max(jElapsedRealtime2, l10.longValue());
                                } else {
                                    jMax = jElapsedRealtime2;
                                }
                                map.put(str, Long.valueOf(jMax));
                                int i15 = bVar.f4297c;
                                if (i15 != Integer.MIN_VALUE) {
                                    Integer numValueOf = Integer.valueOf(i15);
                                    HashMap map2 = (HashMap) oVar2.f12869w;
                                    if (map2.containsKey(numValueOf)) {
                                        Long l11 = (Long) map2.get(numValueOf);
                                        int i16 = s1.b0.f11647a;
                                        jElapsedRealtime2 = Math.max(jElapsedRealtime2, l11.longValue());
                                    }
                                    map2.put(numValueOf, Long.valueOf(jElapsedRealtime2));
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p2.j
    public final int d(long j5, List list) {
        return (this.f3746m != null || this.f3743j.length() < 2) ? list.size() : this.f3743j.f(j5, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p2.j
    public final void e(c1 c1Var, long j5, List list, f0 f0Var) {
        long j8;
        long j10;
        List list2;
        p2.m mVar;
        i[] iVarArr;
        long j11;
        long j12;
        long jMax;
        long j13;
        int i;
        long j14;
        long j15;
        Object kVar;
        long jO;
        long j16;
        long j17;
        boolean z2;
        if (this.f3746m != null) {
            return;
        }
        long j18 = c1Var.f178a;
        long j19 = j5 - j18;
        long jO2 = s1.b0.O(this.f3744k.b(this.f3745l).f4329b) + s1.b0.O(this.f3744k.f4299a) + j5;
        int i10 = 0;
        n nVar = this.f3742h;
        if (nVar != null) {
            o oVar = nVar.f3760e;
            e2.c cVar = oVar.f3766z;
            j10 = -9223372036854775807L;
            wb.c cVar2 = oVar.f3762v;
            if (!cVar.f4302d) {
                j8 = j18;
                z2 = false;
            } else if (oVar.B) {
                j8 = j18;
                z2 = true;
            } else {
                j8 = j18;
                Map.Entry entryCeilingEntry = oVar.f3765y.ceilingEntry(Long.valueOf(cVar.f4305h));
                if (entryCeilingEntry == null || ((Long) entryCeilingEntry.getValue()).longValue() >= jO2) {
                    z2 = false;
                } else {
                    long jLongValue = ((Long) entryCeilingEntry.getKey()).longValue();
                    g gVar = (g) cVar2.f14088v;
                    long j20 = gVar.f3725h0;
                    if (j20 == -9223372036854775807L || j20 < jLongValue) {
                        gVar.f3725h0 = jLongValue;
                    }
                    z2 = true;
                }
                if (z2 && oVar.A) {
                    oVar.B = true;
                    oVar.A = false;
                    g gVar2 = (g) cVar2.f14088v;
                    gVar2.X.removeCallbacks(gVar2.Q);
                    gVar2.E();
                }
            }
            if (z2) {
                return;
            }
        } else {
            j8 = j18;
            j10 = -9223372036854775807L;
        }
        long jO3 = s1.b0.O(s1.b0.y(this.f));
        e2.c cVar3 = this.f3744k;
        long j21 = cVar3.f4299a;
        long jO4 = j21 == j10 ? j10 : jO3 - s1.b0.O(j21 + cVar3.b(this.f3745l).f4329b);
        if (list.isEmpty()) {
            list2 = list;
            mVar = null;
        } else {
            list2 = list;
            mVar = (p2.m) list2.get(list.size() - 1);
        }
        int length = this.f3743j.length();
        p2.n[] nVarArr = new p2.n[length];
        int i11 = 0;
        while (true) {
            iVarArr = this.i;
            if (i11 >= length) {
                break;
            }
            i iVar = iVarArr[i11];
            int i12 = i10;
            h hVar = (h) iVar.f3733g;
            a0 a0Var = p2.n.f10160p;
            if (hVar == null) {
                nVarArr[i11] = a0Var;
                j16 = jO4;
            } else {
                long jB = iVar.b(jO3);
                long jC = iVar.c(jO3);
                if (mVar != null) {
                    j17 = mVar.a();
                    j16 = jO4;
                } else {
                    h hVar2 = (h) iVar.f3733g;
                    s1.d.h(hVar2);
                    j16 = jO4;
                    j17 = s1.b0.j(hVar2.c(j5, iVar.f3729b) + iVar.f3730c, jB, jC);
                }
                long j22 = j17;
                if (j22 < jB) {
                    nVarArr[i11] = a0Var;
                } else {
                    nVarArr[i11] = new j(i(i11), j22, jC);
                }
            }
            i11++;
            i10 = i12;
            jO4 = j16;
        }
        long j23 = jO4;
        int i13 = i10;
        if (!this.f3744k.f4302d || iVarArr[i13].d() == 0) {
            j11 = j19;
            j12 = 0;
            jMax = j10;
        } else {
            long jE = iVarArr[i13].e(iVarArr[i13].c(jO3));
            e2.c cVar4 = this.f3744k;
            long j24 = cVar4.f4299a;
            if (j24 == j10) {
                j11 = j19;
                jO = j10;
            } else {
                j11 = j19;
                jO = jO3 - s1.b0.O(j24 + cVar4.b(this.f3745l).f4329b);
            }
            long jMin = Math.min(jO, jE) - j8;
            j12 = 0;
            jMax = Math.max(0L, jMin);
        }
        long j25 = j12;
        this.f3743j.s(j8, j11, jMax, list2, nVarArr);
        int iN = this.f3743j.n();
        SystemClock.elapsedRealtime();
        i iVarI = i(iN);
        long j26 = iVarI.f3729b;
        long j27 = iVarI.f3730c;
        h hVar3 = (h) iVarI.f3733g;
        e2.b bVar = (e2.b) iVarI.f;
        p2.e eVar = (p2.e) iVarI.f3731d;
        e2.m mVar2 = (e2.m) iVarI.f3732e;
        if (eVar != null) {
            i = 1;
            e2.j jVar = eVar.C == null ? mVar2.f4347y : null;
            j13 = j27;
            e2.j jVarF = hVar3 == null ? mVar2.f() : null;
            if (jVar != null || jVarF != null) {
                q qVarL = this.f3743j.l();
                int iM = this.f3743j.m();
                Object objQ = this.f3743j.q();
                if (jVar != null) {
                    e2.j jVarA = jVar.a(jVarF, bVar.f4295a);
                    if (jVarA != null) {
                        jVar = jVarA;
                    }
                } else {
                    jVarF.getClass();
                    jVar = jVarF;
                }
                f0Var.f4499v = new p2.l(this.f3740e, com.bumptech.glide.c.b(mVar2, bVar.f4295a, jVar, i13), qVarL, iM, objQ, (p2.e) iVarI.f3731d);
                return;
            }
        } else {
            j13 = j27;
            i = 1;
        }
        e2.c cVar5 = this.f3744k;
        int i14 = (cVar5.f4302d && this.f3745l == cVar5.f4309m.size() + (-1)) ? i : i13;
        boolean z10 = (i14 == 0 || j26 != j10) ? i : i13;
        if (iVarI.d() == j25) {
            f0Var.f4498u = z10;
            return;
        }
        long jB2 = iVarI.b(jO3);
        long jC2 = iVarI.c(jO3);
        boolean z11 = z10;
        if (i14 != 0) {
            long jE2 = iVarI.e(jC2);
            z11 = (z10 ? 1 : 0) & ((jE2 - iVarI.f(jC2)) + jE2 >= j26 ? i : i13);
        }
        if (mVar != null) {
            j15 = mVar.a();
            j14 = jC2;
        } else {
            s1.d.h(hVar3);
            j14 = jC2;
            j15 = s1.b0.j(hVar3.c(j5, j26) + j13, jB2, j14);
        }
        long j28 = j15;
        if (j28 < jB2) {
            this.f3746m = new o2.b();
            return;
        }
        if (j28 > j14 || (this.f3747n && j28 >= j14)) {
            f0Var.f4498u = z11;
            return;
        }
        if (z11 != 0 && iVarI.f(j28) >= j26) {
            f0Var.f4498u = i;
            return;
        }
        int iMin = (int) Math.min(this.f3741g, (j14 - j28) + 1);
        int i15 = 1;
        if (j26 != j10) {
            while (iMin > 1 && iVarI.f((((long) iMin) + j28) - 1) >= j26) {
                iMin--;
            }
        }
        long j29 = list.isEmpty() ? j5 : j10;
        q qVarL2 = this.f3743j.l();
        int iM2 = this.f3743j.m();
        Object objQ2 = this.f3743j.q();
        long jF = iVarI.f(j28);
        s1.d.h(hVar3);
        e2.j jVarV = hVar3.v(j28 - j13);
        v1.h hVar4 = this.f3740e;
        if (eVar == null) {
            kVar = new p2.o(hVar4, com.bumptech.glide.c.b(mVar2, bVar.f4295a, jVarV, iVarI.g(j28, j23) ? 0 : 8), qVarL2, iM2, objQ2, jF, iVarI.e(j28), j28, this.f3739d, qVarL2);
        } else {
            e2.j jVar2 = jVarV;
            int i16 = 1;
            while (i15 < iMin) {
                int i17 = iMin;
                s1.d.h(hVar3);
                e2.j jVarA2 = jVar2.a(hVar3.v((j28 + ((long) i15)) - j13), bVar.f4295a);
                if (jVarA2 == null) {
                    break;
                }
                i16++;
                i15++;
                jVar2 = jVarA2;
                iMin = i17;
            }
            long j30 = (j28 + ((long) i16)) - 1;
            long jE3 = iVarI.e(j30);
            long j31 = (j26 == j10 || j26 > jE3) ? j10 : j26;
            v1.m mVarB = com.bumptech.glide.c.b(mVar2, bVar.f4295a, jVar2, iVarI.g(j30, j23) ? 0 : 8);
            long j32 = -mVar2.f4345w;
            if (m0.m(qVarL2.f10023n)) {
                j32 += jF;
            }
            kVar = new p2.k(hVar4, mVarB, qVarL2, iM2, objQ2, jF, jE3, j29, j31, j28, i16, j32, (p2.e) iVarI.f3731d);
        }
        f0Var.f4499v = kVar;
    }

    @Override // p2.j
    public final void f(p2.f fVar) {
        if (fVar instanceof p2.l) {
            int iG = this.f3743j.g(((p2.l) fVar).f10146x);
            i[] iVarArr = this.i;
            i iVar = iVarArr[iG];
            if (((h) iVar.f3733g) == null) {
                p2.e eVar = (p2.e) iVar.f3731d;
                s1.d.h(eVar);
                w2.b0 b0Var = eVar.B;
                w2.k kVar = b0Var instanceof w2.k ? (w2.k) b0Var : null;
                if (kVar != null) {
                    e2.m mVar = (e2.m) iVar.f3732e;
                    iVarArr[iG] = new i(iVar.f3729b, mVar, (e2.b) iVar.f, (p2.e) iVar.f3731d, iVar.f3730c, new af.a(kVar, mVar.f4345w));
                }
            }
        }
        n nVar = this.f3742h;
        if (nVar != null) {
            long j5 = nVar.f3759d;
            if (j5 == -9223372036854775807L || fVar.B > j5) {
                nVar.f3759d = fVar.B;
            }
            nVar.f3760e.A = true;
        }
    }

    @Override // p2.j
    public final boolean g(long j5, p2.f fVar, List list) {
        if (this.f3746m != null) {
            return false;
        }
        return this.f3743j.i(j5, fVar, list);
    }

    public final ArrayList h() {
        List list = this.f3744k.b(this.f3745l).f4330c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.f3738c) {
            arrayList.addAll(((e2.a) list.get(i)).f4292c);
        }
        return arrayList;
    }

    public final i i(int i) {
        i[] iVarArr = this.i;
        i iVar = iVarArr[i];
        e2.b bVarU = this.f3737b.U(((e2.m) iVar.f3732e).f4344v);
        if (bVarU == null || bVarU.equals((e2.b) iVar.f)) {
            return iVar;
        }
        i iVar2 = new i(iVar.f3729b, (e2.m) iVar.f3732e, bVarU, (p2.e) iVar.f3731d, iVar.f3730c, (h) iVar.f3733g);
        iVarArr[i] = iVar2;
        return iVar2;
    }

    @Override // p2.j
    public final void release() {
        for (i iVar : this.i) {
            p2.e eVar = (p2.e) iVar.f3731d;
            if (eVar != null) {
                eVar.f10137u.release();
            }
        }
    }
}
