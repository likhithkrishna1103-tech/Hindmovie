package o4;

import c.b0;
import c.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import nc.p;
import se.v;
import se.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f9490a = new x(f.f9502a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f9491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f9492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sd.h f9493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sd.h f9494e;
    public b0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f9496h;
    public final LinkedHashSet i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f9497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f9498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9499l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9500m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9501n;

    public e() {
        x xVar = new x(new c());
        this.f9491b = xVar;
        this.f9492c = new v(xVar);
        this.f9493d = new sd.h();
        this.f9494e = new sd.h();
        this.i = new LinkedHashSet();
        this.f9497j = new LinkedHashSet();
        this.f9498k = new LinkedHashSet();
    }

    public final void a(p pVar, d dVar, int i) {
        ge.i.e(pVar, "dispatcher");
        if (dVar.f9488a == null) {
            (i != 0 ? i != 1 ? this.i : this.f9497j : this.f9498k).add(dVar);
            dVar.f9488a = pVar;
            ge.i.e((c) this.f9492c.f11715v.d(), "history");
            dVar.b(i != 0 ? i != 1 ? this.f9501n : this.f9499l : this.f9500m);
            return;
        }
        throw new IllegalArgumentException(("Input '" + dVar + "' is already added to dispatcher " + dVar.f9488a + '.').toString());
    }

    public final void b() {
        boolean z10;
        boolean z11;
        c cVar;
        sd.h hVar = this.f9493d;
        if (hVar == null || !hVar.isEmpty()) {
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                if (((b0) it.next()).f1932b) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        sd.h hVar2 = this.f9494e;
        if (hVar2 == null || !hVar2.isEmpty()) {
            Iterator it2 = hVar2.iterator();
            while (it2.hasNext()) {
                if (((b0) it2.next()).f1932b) {
                    z11 = true;
                    break;
                }
            }
            z11 = false;
        } else {
            z11 = false;
        }
        boolean z12 = z10 || z11;
        boolean z13 = this.f9500m != z10;
        boolean z14 = this.f9499l != z11;
        boolean z15 = this.f9501n != z12;
        LinkedHashSet linkedHashSet = this.f9498k;
        if (z13) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((d) it3.next()).b(z10);
            }
        }
        LinkedHashSet linkedHashSet2 = this.f9497j;
        if (z14) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((d) it4.next()).b(z11);
            }
        }
        LinkedHashSet linkedHashSet3 = this.i;
        if (z15) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((d) it5.next()).b(z12);
            }
        }
        this.f9500m = z10;
        this.f9499l = z11;
        this.f9501n = z12;
        b0 b0VarC = this.f;
        if (b0VarC == null) {
            b0VarC = c(0);
        }
        b0 b0VarC2 = this.f;
        if (b0VarC2 == null) {
            b0VarC2 = c(0);
        }
        if (ge.i.a(b0VarC2, b0VarC)) {
            if (b0VarC2 == null) {
                cVar = new c();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = hVar.iterator();
                while (it6.hasNext()) {
                    ((b0) it6.next()).getClass();
                }
                Iterator<E> it7 = hVar2.iterator();
                while (it7.hasNext()) {
                    ((b0) it7.next()).getClass();
                }
                c0 c0Var = b0VarC2.f1931a;
                td.c cVarH = n5.a.h();
                sd.j.g0(arrayList, cVarH);
                cVarH.add(c0Var);
                sd.j.g0(sd.p.f11669v, cVarH);
                cVar = new c(arrayList.size(), n5.a.a(cVarH));
            }
            x xVar = this.f9491b;
            if (ge.i.a((c) xVar.d(), cVar)) {
                return;
            }
            xVar.e(null, cVar);
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

    public final b0 c(int i) {
        Object next;
        Object next2;
        sd.h hVar = this.f9494e;
        sd.h hVar2 = this.f9493d;
        Object obj = null;
        if (i == -1) {
            Iterator it = hVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((b0) next).f1932b) {
                    break;
                }
            }
            b0 b0Var = (b0) next;
            if (b0Var != null) {
                return b0Var;
            }
            Iterator it2 = hVar.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((b0) next3).f1932b) {
                    obj = next3;
                    break;
                }
            }
            return (b0) obj;
        }
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
            }
            Iterator it3 = hVar2.iterator();
            while (it3.hasNext()) {
                ((b0) it3.next()).getClass();
            }
            Iterator it4 = hVar.iterator();
            while (it4.hasNext()) {
                ((b0) it4.next()).getClass();
            }
            return null;
        }
        Iterator it5 = hVar2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it5.next();
            if (((b0) next2).f1932b) {
                break;
            }
        }
        b0 b0Var2 = (b0) next2;
        if (b0Var2 != null) {
            return b0Var2;
        }
        Iterator it6 = hVar.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next4 = it6.next();
            if (((b0) next4).f1932b) {
                obj = next4;
                break;
            }
        }
        return (b0) obj;
    }
}
