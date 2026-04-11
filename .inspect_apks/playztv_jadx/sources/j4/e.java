package j4;

import c.a0;
import c.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import ne.l;
import ne.n;
import od.q;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f6779a = new n(f.f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f6780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f6781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final od.g f6782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final od.g f6783e;
    public z f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f6785h;
    public final LinkedHashSet i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f6786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f6787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6790n;

    public e() {
        n nVar = new n(new c());
        this.f6780b = nVar;
        this.f6781c = new l(nVar);
        this.f6782d = new od.g();
        this.f6783e = new od.g();
        this.i = new LinkedHashSet();
        this.f6786j = new LinkedHashSet();
        this.f6787k = new LinkedHashSet();
    }

    public final void a(o oVar, d dVar, int i) {
        be.h.e(oVar, "dispatcher");
        if (dVar.f6777a == null) {
            (i != 0 ? i != 1 ? this.i : this.f6786j : this.f6787k).add(dVar);
            dVar.f6777a = oVar;
            be.h.e((c) this.f6781c.f9016u.d(), "history");
            dVar.b(i != 0 ? i != 1 ? this.f6790n : this.f6788l : this.f6789m);
            return;
        }
        throw new IllegalArgumentException(("Input '" + dVar + "' is already added to dispatcher " + dVar.f6777a + '.').toString());
    }

    public final void b() {
        boolean z2;
        boolean z10;
        c cVar;
        od.g gVar = this.f6782d;
        if (gVar == null || !gVar.isEmpty()) {
            Iterator it = gVar.iterator();
            while (it.hasNext()) {
                if (((z) it.next()).f2204b) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        od.g gVar2 = this.f6783e;
        if (gVar2 == null || !gVar2.isEmpty()) {
            Iterator it2 = gVar2.iterator();
            while (it2.hasNext()) {
                if (((z) it2.next()).f2204b) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        boolean z11 = z2 || z10;
        boolean z12 = this.f6789m != z2;
        boolean z13 = this.f6788l != z10;
        boolean z14 = this.f6790n != z11;
        LinkedHashSet linkedHashSet = this.f6787k;
        if (z12) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).b(z2);
            }
        }
        LinkedHashSet linkedHashSet2 = this.f6786j;
        if (z13) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).b(z10);
            }
        }
        LinkedHashSet linkedHashSet3 = this.i;
        if (z14) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).b(z11);
            }
        }
        this.f6789m = z2;
        this.f6788l = z10;
        this.f6790n = z11;
        z zVarC = this.f;
        if (zVarC == null) {
            zVarC = c(0);
        }
        z zVarC2 = this.f;
        if (zVarC2 == null) {
            zVarC2 = c(0);
        }
        if (be.h.a(zVarC2, zVarC)) {
            if (zVarC2 == null) {
                cVar = new c();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = gVar.iterator();
                while (it6.hasNext()) {
                    ((z) it6.next()).getClass();
                }
                Iterator<E> it7 = gVar2.iterator();
                while (it7.hasNext()) {
                    ((z) it7.next()).getClass();
                }
                a0 a0Var = zVarC2.f2203a;
                pd.c cVarN = android.support.v4.media.session.b.n();
                od.o.V(cVarN, arrayList);
                cVarN.add(a0Var);
                od.o.V(cVarN, q.f9570u);
                cVar = new c(arrayList.size(), android.support.v4.media.session.b.c(cVarN));
            }
            n nVar = this.f6780b;
            if (be.h.a((c) nVar.d(), cVar)) {
                return;
            }
            nVar.f(null, cVar);
            Iterator it8 = linkedHashSet.iterator();
            while (it8.hasNext()) {
                ((d) it8.next()).getClass();
            }
            Iterator it9 = linkedHashSet2.iterator();
            while (it9.hasNext()) {
                ((d) it9.next()).getClass();
            }
            Iterator it10 = linkedHashSet3.iterator();
            while (it10.hasNext()) {
                ((d) it10.next()).getClass();
            }
        }
    }

    public final z c(int i) {
        Object next;
        Object next2;
        od.g gVar = this.f6783e;
        od.g gVar2 = this.f6782d;
        Object obj = null;
        if (i == -1) {
            Iterator it = gVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((z) next).f2204b) {
                    break;
                }
            }
            z zVar = (z) next;
            if (zVar != null) {
                return zVar;
            }
            Iterator it2 = gVar.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((z) next3).f2204b) {
                    obj = next3;
                    break;
                }
            }
            return (z) obj;
        }
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
            }
            Iterator it3 = gVar2.iterator();
            while (it3.hasNext()) {
                ((z) it3.next()).getClass();
            }
            Iterator it4 = gVar.iterator();
            while (it4.hasNext()) {
                ((z) it4.next()).getClass();
            }
            return null;
        }
        Iterator it5 = gVar2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it5.next();
            if (((z) next2).f2204b) {
                break;
            }
        }
        z zVar2 = (z) next2;
        if (zVar2 != null) {
            return zVar2;
        }
        Iterator it6 = gVar.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next4 = it6.next();
            if (((z) next4).f2204b) {
                obj = next4;
                break;
            }
        }
        return (z) obj;
    }
}
