package g2;

import aa.c1;
import aa.h0;
import aa.j0;
import android.net.Uri;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p1.g1;
import s1.b0;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.h f4865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v1.h f4866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u5.d f4867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri[] f4868e;
    public final p1.q[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h2.c f4869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f4870h;
    public final List i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b2.o f4872k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4873l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o2.b f4875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Uri f4876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Uri f4877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public r2.r f4879r;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final rc.b f4871j = new rc.b(11);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f4874m = b0.f11649c;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4880s = -9223372036854775807L;

    public i(c cVar, h2.c cVar2, Uri[] uriArr, p1.q[] qVarArr, wb.c cVar3, e0 e0Var, u5.d dVar, List list, b2.o oVar) {
        this.f4864a = cVar;
        this.f4869g = cVar2;
        this.f4868e = uriArr;
        this.f = qVarArr;
        this.f4867d = dVar;
        this.i = list;
        this.f4872k = oVar;
        v1.h hVarG = ((v1.g) cVar3.f14088v).g();
        this.f4865b = hVarG;
        if (e0Var != null) {
            hVarG.g(e0Var);
        }
        this.f4866c = ((v1.g) cVar3.f14088v).g();
        this.f4870h = new g1("", qVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((qVarArr[i].f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        g1 g1Var = this.f4870h;
        int[] iArrS = q1.c.S(arrayList);
        g gVar = new g(g1Var, iArrS);
        gVar.f4859g = gVar.g(g1Var.f9765d[iArrS[0]]);
        this.f4879r = gVar;
    }

    public static h d(h2.l lVar, long j5, int i) {
        long j8 = lVar.f5719k;
        j0 j0Var = lVar.f5727s;
        int i10 = (int) (j5 - j8);
        j0 j0Var2 = lVar.f5726r;
        if (i10 == j0Var2.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < j0Var.size()) {
                return new h((h2.j) j0Var.get(i), j5, i);
            }
            return null;
        }
        h2.i iVar = (h2.i) j0Var2.get(i10);
        if (i == -1) {
            return new h(iVar, j5, -1);
        }
        if (i < iVar.G.size()) {
            return new h((h2.j) iVar.G.get(i), j5, i);
        }
        int i11 = i10 + 1;
        if (i11 < j0Var2.size()) {
            return new h((h2.j) j0Var2.get(i11), j5 + 1, -1);
        }
        if (j0Var.isEmpty()) {
            return null;
        }
        return new h((h2.j) j0Var.get(0), j5 + 1, 0);
    }

    public final p2.n[] a(j jVar, long j5) {
        List listUnmodifiableList;
        i iVar = this;
        j jVar2 = jVar;
        int iA = jVar2 == null ? -1 : iVar.f4870h.a(jVar2.f10146x);
        int length = iVar.f4879r.length();
        p2.n[] nVarArr = new p2.n[length];
        boolean z2 = false;
        int i = 0;
        while (i < length) {
            int iE = iVar.f4879r.e(i);
            Uri uri = iVar.f4868e[iE];
            h2.c cVar = iVar.f4869g;
            if (cVar.c(uri)) {
                h2.l lVarA = cVar.a(uri, z2);
                lVarA.getClass();
                long j8 = lVarA.f5717h - cVar.H;
                Pair pairC = iVar.c(jVar2, iE != iA ? true : z2, lVarA, j8, j5);
                long jLongValue = ((Long) pairC.first).longValue();
                int iIntValue = ((Integer) pairC.second).intValue();
                long j10 = lVarA.f5719k;
                j0 j0Var = lVarA.f5727s;
                j0 j0Var2 = lVarA.f5726r;
                int i10 = (int) (jLongValue - j10);
                if (i10 < 0 || j0Var2.size() < i10) {
                    h0 h0Var = j0.f690v;
                    listUnmodifiableList = c1.f650y;
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i10 < j0Var2.size()) {
                        if (iIntValue != -1) {
                            h2.i iVar2 = (h2.i) j0Var2.get(i10);
                            if (iIntValue == 0) {
                                arrayList.add(iVar2);
                            } else if (iIntValue < iVar2.G.size()) {
                                j0 j0Var3 = iVar2.G;
                                arrayList.addAll(j0Var3.subList(iIntValue, j0Var3.size()));
                            }
                            i10++;
                        }
                        arrayList.addAll(j0Var2.subList(i10, j0Var2.size()));
                        iIntValue = 0;
                    }
                    if (lVarA.f5722n != -9223372036854775807L) {
                        if (iIntValue == -1) {
                            iIntValue = 0;
                        }
                        if (iIntValue < j0Var.size()) {
                            arrayList.addAll(j0Var.subList(iIntValue, j0Var.size()));
                        }
                    }
                    listUnmodifiableList = Collections.unmodifiableList(arrayList);
                }
                nVarArr[i] = new f(j8, listUnmodifiableList);
            } else {
                nVarArr[i] = p2.n.f10160p;
            }
            i++;
            iVar = this;
            jVar2 = jVar;
            z2 = false;
        }
        return nVarArr;
    }

    public final int b(j jVar) {
        int i = jVar.I;
        if (i == -1) {
            return 1;
        }
        h2.l lVarA = this.f4869g.a(this.f4868e[this.f4870h.a(jVar.f10146x)], false);
        lVarA.getClass();
        j0 j0Var = lVarA.f5726r;
        int i10 = (int) (jVar.D - lVarA.f5719k);
        if (i10 < 0) {
            return 1;
        }
        j0 j0Var2 = i10 < j0Var.size() ? ((h2.i) j0Var.get(i10)).G : lVarA.f5727s;
        if (i >= j0Var2.size()) {
            return 2;
        }
        h2.g gVar = (h2.g) j0Var2.get(i);
        if (gVar.G) {
            return 0;
        }
        return Objects.equals(Uri.parse(s1.b.n(lVarA.f5747a, gVar.f5703u)), jVar.f10144v.f13157a) ? 1 : 2;
    }

    public final Pair c(j jVar, boolean z2, h2.l lVar, long j5, long j8) {
        boolean z10 = true;
        if (jVar != null) {
            long jA = jVar.D;
            int i = jVar.I;
            if (!z2) {
                if (!jVar.f4883b0) {
                    return new Pair(Long.valueOf(jA), Integer.valueOf(i));
                }
                if (i == -1) {
                    jA = jVar.a();
                }
                return new Pair(Long.valueOf(jA), Integer.valueOf(i != -1 ? i + 1 : -1));
            }
        }
        long j10 = lVar.f5729u;
        j0 j0Var = lVar.f5727s;
        long j11 = lVar.f5719k;
        j0 j0Var2 = lVar.f5726r;
        long j12 = j10 + j5;
        if (jVar != null && !this.f4878q) {
            j8 = jVar.A;
        }
        if (!lVar.f5723o && j8 >= j12) {
            return new Pair(Long.valueOf(j11 + ((long) j0Var2.size())), -1);
        }
        long j13 = j8 - j5;
        Long lValueOf = Long.valueOf(j13);
        int i10 = 0;
        if (this.f4869g.G && jVar != null) {
            z10 = false;
        }
        int iC = b0.c(j0Var2, lValueOf, z10);
        long j14 = ((long) iC) + j11;
        if (iC >= 0) {
            h2.i iVar = (h2.i) j0Var2.get(iC);
            j0 j0Var3 = j13 < iVar.f5707y + iVar.f5705w ? iVar.G : j0Var;
            while (true) {
                if (i10 >= j0Var3.size()) {
                    break;
                }
                h2.g gVar = (h2.g) j0Var3.get(i10);
                if (j13 >= gVar.f5707y + gVar.f5705w) {
                    i10++;
                } else if (gVar.F) {
                    j14 += j0Var3 == j0Var ? 1L : 0L;
                    i = i10;
                }
            }
        }
        return new Pair(Long.valueOf(j14), Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e e(Uri uri, int i, boolean z2) {
        if (uri == null) {
            return null;
        }
        rc.b bVar = this.f4871j;
        byte[] bArr = (byte[]) ((d) bVar.f11562v).remove(uri);
        if (bArr != null) {
            return null;
        }
        v1.m mVar = new v1.m(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 1);
        p1.q qVar = this.f[i];
        int iM = this.f4879r.m();
        Object objQ = this.f4879r.q();
        byte[] bArr2 = this.f4874m;
        e eVar = new e(this.f4866c, mVar, 3, qVar, iM, objQ, -9223372036854775807L, -9223372036854775807L);
        if (bArr2 == null) {
            bArr2 = b0.f11649c;
        }
        eVar.D = bArr2;
        return eVar;
    }
}
