package m2;

import android.net.Uri;
import android.util.Pair;
import b2.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ua.g0;
import ua.i0;
import ua.z0;
import v1.g1;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b2.h f8059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.h f8060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l4.a f8061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri[] f8062e;
    public final v1.p[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n2.c f8063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f8064h;
    public final List i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h2.l f8066k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8067l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s2.b f8069n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Uri f8070o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Uri f8071p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8072q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public v2.q f8073r;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f8065j = new e(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f8068m = a0.f14553c;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f8074s = -9223372036854775807L;

    public j(c cVar, n2.c cVar2, Uri[] uriArr, v1.p[] pVarArr, l4.a aVar, h0 h0Var, l4.a aVar2, List list, h2.l lVar) {
        this.f8058a = cVar;
        this.f8063g = cVar2;
        this.f8062e = uriArr;
        this.f = pVarArr;
        this.f8061d = aVar2;
        this.i = list;
        this.f8066k = lVar;
        b2.h hVarH = ((b2.g) aVar.f7697v).h();
        this.f8059b = hVarH;
        if (h0Var != null) {
            hVarH.d(h0Var);
        }
        this.f8060c = ((b2.g) aVar.f7697v).h();
        this.f8064h = new g1("", pVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((pVarArr[i].f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        g1 g1Var = this.f8064h;
        int[] iArrC = com.bumptech.glide.d.C(arrayList);
        h hVar = new h(g1Var, iArrC);
        hVar.f8053g = hVar.n(g1Var.f12705d[iArrC[0]]);
        this.f8073r = hVar;
    }

    public static i d(n2.l lVar, long j4, int i) {
        long j7 = lVar.f8694k;
        i0 i0Var = lVar.f8702s;
        int i10 = (int) (j4 - j7);
        i0 i0Var2 = lVar.f8701r;
        if (i10 == i0Var2.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < i0Var.size()) {
                return new i((n2.j) i0Var.get(i), j4, i);
            }
            return null;
        }
        n2.i iVar = (n2.i) i0Var2.get(i10);
        if (i == -1) {
            return new i(iVar, j4, -1);
        }
        if (i < iVar.H.size()) {
            return new i((n2.j) iVar.H.get(i), j4, i);
        }
        int i11 = i10 + 1;
        if (i11 < i0Var2.size()) {
            return new i((n2.j) i0Var2.get(i11), j4 + 1, -1);
        }
        if (i0Var.isEmpty()) {
            return null;
        }
        return new i((n2.j) i0Var.get(0), j4 + 1, 0);
    }

    public final t2.l[] a(k kVar, long j4) {
        List listUnmodifiableList;
        j jVar = this;
        k kVar2 = kVar;
        int iA = kVar2 == null ? -1 : jVar.f8064h.a(kVar2.f11851y);
        int length = jVar.f8073r.length();
        t2.l[] lVarArr = new t2.l[length];
        boolean z10 = false;
        int i = 0;
        while (i < length) {
            int iE = jVar.f8073r.e(i);
            Uri uri = jVar.f8062e[iE];
            n2.c cVar = jVar.f8063g;
            if (cVar.c(uri)) {
                n2.l lVarA = cVar.a(uri, z10);
                lVarA.getClass();
                long j7 = lVarA.f8692h - cVar.I;
                Pair pairC = jVar.c(kVar2, iE != iA ? true : z10, lVarA, j7, j4);
                long jLongValue = ((Long) pairC.first).longValue();
                int iIntValue = ((Integer) pairC.second).intValue();
                long j10 = lVarA.f8694k;
                i0 i0Var = lVarA.f8702s;
                i0 i0Var2 = lVarA.f8701r;
                int i10 = (int) (jLongValue - j10);
                if (i10 < 0 || i0Var2.size() < i10) {
                    g0 g0Var = i0.f12341w;
                    listUnmodifiableList = z0.f12413z;
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i10 < i0Var2.size()) {
                        if (iIntValue != -1) {
                            n2.i iVar = (n2.i) i0Var2.get(i10);
                            if (iIntValue == 0) {
                                arrayList.add(iVar);
                            } else if (iIntValue < iVar.H.size()) {
                                i0 i0Var3 = iVar.H;
                                arrayList.addAll(i0Var3.subList(iIntValue, i0Var3.size()));
                            }
                            i10++;
                        }
                        arrayList.addAll(i0Var2.subList(i10, i0Var2.size()));
                        iIntValue = 0;
                    }
                    if (lVarA.f8697n != -9223372036854775807L) {
                        if (iIntValue == -1) {
                            iIntValue = 0;
                        }
                        if (iIntValue < i0Var.size()) {
                            arrayList.addAll(i0Var.subList(iIntValue, i0Var.size()));
                        }
                    }
                    listUnmodifiableList = Collections.unmodifiableList(arrayList);
                }
                lVarArr[i] = new g(j7, listUnmodifiableList);
            } else {
                lVarArr[i] = t2.l.f11863r;
            }
            i++;
            jVar = this;
            kVar2 = kVar;
            z10 = false;
        }
        return lVarArr;
    }

    public final int b(k kVar) {
        int i = kVar.J;
        if (i == -1) {
            return 1;
        }
        n2.l lVarA = this.f8063g.a(this.f8062e[this.f8064h.a(kVar.f11851y)], false);
        lVarA.getClass();
        i0 i0Var = lVarA.f8701r;
        int i10 = (int) (kVar.E - lVarA.f8694k);
        if (i10 < 0) {
            return 1;
        }
        i0 i0Var2 = i10 < i0Var.size() ? ((n2.i) i0Var.get(i10)).H : lVarA.f8702s;
        if (i >= i0Var2.size()) {
            return 2;
        }
        n2.g gVar = (n2.g) i0Var2.get(i);
        if (gVar.H) {
            return 0;
        }
        return Objects.equals(Uri.parse(y1.b.n(lVarA.f8722a, gVar.f8679v)), kVar.f11849w.f1714a) ? 1 : 2;
    }

    public final Pair c(k kVar, boolean z10, n2.l lVar, long j4, long j7) {
        boolean z11 = true;
        if (kVar != null) {
            long jB = kVar.E;
            int i = kVar.J;
            if (!z10) {
                if (!kVar.f8078c0) {
                    return new Pair(Long.valueOf(jB), Integer.valueOf(i));
                }
                if (i == -1) {
                    jB = kVar.b();
                }
                return new Pair(Long.valueOf(jB), Integer.valueOf(i != -1 ? i + 1 : -1));
            }
        }
        long j10 = lVar.f8704u;
        i0 i0Var = lVar.f8702s;
        long j11 = lVar.f8694k;
        i0 i0Var2 = lVar.f8701r;
        long j12 = j10 + j4;
        if (kVar != null && !this.f8072q) {
            j7 = kVar.B;
        }
        if (!lVar.f8698o && j7 >= j12) {
            return new Pair(Long.valueOf(j11 + ((long) i0Var2.size())), -1);
        }
        long j13 = j7 - j4;
        Long lValueOf = Long.valueOf(j13);
        int i10 = 0;
        if (this.f8063g.H && kVar != null) {
            z11 = false;
        }
        int iC = a0.c(i0Var2, lValueOf, z11);
        long j14 = ((long) iC) + j11;
        if (iC >= 0) {
            n2.i iVar = (n2.i) i0Var2.get(iC);
            i0 i0Var3 = j13 < iVar.f8683z + iVar.f8681x ? iVar.H : i0Var;
            while (true) {
                if (i10 >= i0Var3.size()) {
                    break;
                }
                n2.g gVar = (n2.g) i0Var3.get(i10);
                if (j13 >= gVar.f8683z + gVar.f8681x) {
                    i10++;
                } else if (gVar.G) {
                    j14 += i0Var3 == i0Var ? 1L : 0L;
                    i = i10;
                }
            }
        }
        return new Pair(Long.valueOf(j14), Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f e(Uri uri, int i, boolean z10) {
        if (uri == null) {
            return null;
        }
        e eVar = this.f8065j;
        byte[] bArr = (byte[]) ((d) eVar.f8050v).remove(uri);
        if (bArr != null) {
            return null;
        }
        b2.o oVar = new b2.o(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 1);
        v1.p pVar = this.f[i];
        int iK = this.f8073r.k();
        Object objP = this.f8073r.p();
        byte[] bArr2 = this.f8068m;
        f fVar = new f(this.f8060c, oVar, 3, pVar, iK, objP, -9223372036854775807L, -9223372036854775807L);
        if (bArr2 == null) {
            bArr2 = a0.f14553c;
        }
        fVar.E = bArr2;
        return fVar;
    }
}
