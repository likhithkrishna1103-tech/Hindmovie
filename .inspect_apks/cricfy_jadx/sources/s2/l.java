package s2;

import android.os.Handler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f11256h = new HashMap();
    public Handler i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b2.h0 f11257j;

    @Override // s2.a
    public final void e() {
        for (k kVar : this.f11256h.values()) {
            kVar.f11245a.d(kVar.f11246b);
        }
    }

    @Override // s2.a
    public final void g() {
        for (k kVar : this.f11256h.values()) {
            kVar.f11245a.f(kVar.f11246b);
        }
    }

    @Override // s2.a
    public void k() {
        Iterator it = this.f11256h.values().iterator();
        while (it.hasNext()) {
            ((k) it.next()).f11245a.k();
        }
    }

    @Override // s2.a
    public void q() {
        HashMap map = this.f11256h;
        for (k kVar : map.values()) {
            a aVar = kVar.f11245a;
            j jVar = kVar.f11247c;
            aVar.p(kVar.f11246b);
            aVar.s(jVar);
            aVar.r(jVar);
        }
        map.clear();
    }

    public abstract c0 u(Object obj, c0 c0Var);

    public abstract void x(Object obj, a aVar, v1.f1 f1Var);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [s2.d0, s2.i] */
    public final void y(final Object obj, a aVar) {
        HashMap map = this.f11256h;
        y1.d.b(!map.containsKey(obj));
        ?? r12 = new d0() { // from class: s2.i
            @Override // s2.d0
            public final void a(a aVar2, v1.f1 f1Var) {
                this.f11227a.x(obj, aVar2, f1Var);
            }
        };
        j jVar = new j(this, obj);
        map.put(obj, new k(aVar, r12, jVar));
        Handler handler = this.i;
        handler.getClass();
        aVar.getClass();
        f3.a aVar2 = aVar.f11149c;
        aVar2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) aVar2.f3937y;
        h0 h0Var = new h0();
        h0Var.f11220a = handler;
        h0Var.f11221b = jVar;
        copyOnWriteArrayList.add(h0Var);
        Handler handler2 = this.i;
        handler2.getClass();
        l2.k kVar = aVar.f11150d;
        kVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = kVar.f7673c;
        l2.j jVar2 = new l2.j();
        jVar2.f7669a = handler2;
        jVar2.f7670b = jVar;
        copyOnWriteArrayList2.add(jVar2);
        b2.h0 h0Var2 = this.f11257j;
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        aVar.l(r12, h0Var2, lVar);
        if (this.f11148b.isEmpty()) {
            aVar.d(r12);
        }
    }

    public long v(long j4, Object obj) {
        return j4;
    }

    public int w(int i, Object obj) {
        return i;
    }
}
