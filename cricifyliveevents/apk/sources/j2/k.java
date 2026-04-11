package j2;

import com.google.android.gms.internal.measurement.o4;
import f9.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import v1.m0;
import v2.q;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f6558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nc.p f6559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f6560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b2.h f6562e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f6563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f6564h;
    public final r[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f6565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public k2.c f6566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s2.b f6568m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6569n;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j2.k, java.lang.Object] */
    public k(o4 o4Var, p pVar, k2.c cVar, nc.p pVar2, int i, int[] iArr, q qVar, int i10, b2.h hVar, long j4, int i11, boolean z10, ArrayList arrayList, n nVar) {
        k2.m mVar;
        r[] rVarArr;
        v1.p pVar3;
        a3.p jVar;
        t2.d dVar;
        ?? obj = new Object();
        obj.f6558a = pVar;
        obj.f6566k = cVar;
        obj.f6559b = pVar2;
        obj.f6560c = iArr;
        obj.f6565j = qVar;
        obj.f6561d = i10;
        obj.f6562e = hVar;
        obj.f6567l = i;
        obj.f = j4;
        obj.f6563g = i11;
        n nVar2 = nVar;
        obj.f6564h = nVar2;
        long jD = cVar.d(i);
        ArrayList arrayListA = obj.a();
        obj.i = new r[qVar.length()];
        int i12 = 0;
        int i13 = 0;
        k kVar = obj;
        while (i13 < kVar.i.length) {
            k2.m mVar2 = (k2.m) arrayListA.get(qVar.e(i13));
            k2.b bVarA = pVar2.A(mVar2.f6873w);
            r[] rVarArr2 = kVar.i;
            k2.b bVar = bVarA == null ? (k2.b) mVar2.f6873w.get(i12) : bVarA;
            v1.p pVar4 = mVar2.f6872v;
            o4Var.getClass();
            String str = pVar4.f12945m;
            if (!m0.n(str)) {
                if (str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm") || str.startsWith("video/x-matroska") || str.startsWith("audio/x-matroska") || str.startsWith("application/x-matroska"))) {
                    mVar = mVar2;
                    pVar3 = pVar4;
                    rVarArr = rVarArr2;
                    jVar = new s3.d((x3.e) o4Var.f2561w, o4Var.f2560v ? 1 : 3);
                } else if (Objects.equals(str, "image/jpeg")) {
                    jVar = new i3.a(1);
                } else if (Objects.equals(str, "image/png")) {
                    jVar = new e3.a(1);
                } else {
                    int i14 = z10 ? 4 : 0;
                    mVar = mVar2;
                    int i15 = o4Var.f2560v ? i14 : i14 | 32;
                    rVarArr = rVarArr2;
                    pVar3 = pVar4;
                    jVar = new u3.j((x3.e) o4Var.f2561w, i15, null, arrayList, nVar2);
                }
                dVar = new t2.d(jVar, i10, pVar3);
                t2.d dVar2 = dVar;
                long j7 = jD;
                int i16 = i13;
                rVarArr[i16] = new r(j7, mVar, bVar, dVar2, 0L, mVar.d());
                i13 = i16 + 1;
                kVar = this;
                nVar2 = nVar;
                jD = j7;
                i12 = 0;
            } else if (o4Var.f2560v) {
                jVar = new x3.k(((x3.e) o4Var.f2561w).c(pVar4), pVar4);
            } else {
                dVar = null;
                mVar = mVar2;
                rVarArr = rVarArr2;
                t2.d dVar22 = dVar;
                long j72 = jD;
                int i162 = i13;
                rVarArr[i162] = new r(j72, mVar, bVar, dVar22, 0L, mVar.d());
                i13 = i162 + 1;
                kVar = this;
                nVar2 = nVar;
                jD = j72;
                i12 = 0;
            }
            mVar = mVar2;
            pVar3 = pVar4;
            rVarArr = rVarArr2;
            dVar = new t2.d(jVar, i10, pVar3);
            t2.d dVar222 = dVar;
            long j722 = jD;
            int i1622 = i13;
            rVarArr[i1622] = new r(j722, mVar, bVar, dVar222, 0L, mVar.d());
            i13 = i1622 + 1;
            kVar = this;
            nVar2 = nVar;
            jD = j722;
            i12 = 0;
        }
    }

    public final ArrayList a() {
        List list = this.f6566k.b(this.f6567l).f6861c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.f6560c) {
            arrayList.addAll(((k2.a) list.get(i)).f6824c);
        }
        return arrayList;
    }

    public final r b(int i) {
        r[] rVarArr = this.i;
        r rVar = rVarArr[i];
        k2.b bVarA = this.f6559b.A(((k2.m) rVar.f4362z).f6873w);
        if (bVarA == null || bVarA.equals((k2.b) rVar.A)) {
            return rVar;
        }
        r rVar2 = new r(rVar.f4359w, (k2.m) rVar.f4362z, bVarA, (t2.d) rVar.f4361y, rVar.f4360x, (i) rVar.B);
        rVarArr[i] = rVar2;
        return rVar2;
    }
}
