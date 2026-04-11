package o2;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends a {
    public final HashMap B = new HashMap();
    public Handler C;
    public v1.e0 D;

    public abstract void B(Object obj, a aVar, p1.f1 f1Var);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [o2.e0, o2.i] */
    public final void C(final Object obj, a aVar) {
        HashMap map = this.B;
        s1.d.b(!map.containsKey(obj));
        ?? r12 = new e0() { // from class: o2.i
            @Override // o2.e0
            public final void a(a aVar2, p1.f1 f1Var) {
                this.f9134a.B(obj, aVar2, f1Var);
            }
        };
        j jVar = new j(this, obj);
        map.put(obj, new k(aVar, r12, jVar));
        Handler handler = this.C;
        handler.getClass();
        aVar.getClass();
        aa.l0 l0Var = aVar.f9053w;
        l0Var.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) l0Var.f707x;
        j0 j0Var = new j0();
        j0Var.f9146a = handler;
        j0Var.f9147b = jVar;
        copyOnWriteArrayList.add(j0Var);
        Handler handler2 = this.C;
        handler2.getClass();
        f2.k kVar = aVar.f9054x;
        kVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = kVar.f4741c;
        f2.j jVar2 = new f2.j();
        jVar2.f4737a = handler2;
        jVar2.f4738b = jVar;
        copyOnWriteArrayList2.add(jVar2);
        v1.e0 e0Var = this.D;
        b2.o oVar = this.A;
        s1.d.h(oVar);
        aVar.o(r12, e0Var, oVar);
        if (this.f9052v.isEmpty()) {
            aVar.e(r12);
        }
    }

    @Override // o2.a
    public final void f() {
        for (k kVar : this.B.values()) {
            kVar.f9154a.e(kVar.f9155b);
        }
    }

    @Override // o2.a
    public final void h() {
        for (k kVar : this.B.values()) {
            kVar.f9154a.g(kVar.f9155b);
        }
    }

    @Override // o2.a
    public void n() {
        Iterator it = this.B.values().iterator();
        while (it.hasNext()) {
            ((k) it.next()).f9154a.n();
        }
    }

    @Override // o2.a
    public void t() {
        HashMap map = this.B;
        for (k kVar : map.values()) {
            a aVar = kVar.f9154a;
            j jVar = kVar.f9156c;
            aVar.s(kVar.f9155b);
            aVar.w(jVar);
            aVar.v(jVar);
        }
        map.clear();
    }

    public abstract d0 y(Object obj, d0 d0Var);

    public int A(int i, Object obj) {
        return i;
    }

    public long z(long j5, Object obj) {
        return j5;
    }
}
