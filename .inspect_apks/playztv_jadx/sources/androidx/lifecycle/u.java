package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p.a f1503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f1504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f1505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1506e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1508h;

    public u(s sVar) {
        new AtomicReference();
        this.f1502a = true;
        this.f1503b = new p.a();
        this.f1504c = n.f1483v;
        this.f1508h = new ArrayList();
        this.f1505d = new WeakReference(sVar);
    }

    public final void a(r rVar) {
        q reflectiveGenericLifecycleObserver;
        Object obj;
        s sVar;
        c("addObserver");
        n nVar = this.f1504c;
        n nVar2 = n.f1482u;
        if (nVar != nVar2) {
            nVar2 = n.f1483v;
        }
        t tVar = new t();
        HashMap map = v.f1509a;
        boolean z2 = rVar instanceof q;
        boolean z10 = rVar instanceof e;
        if (z2 && z10) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) rVar, (q) rVar);
        } else if (z10) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) rVar, null);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = (q) rVar;
        } else {
            Class<?> cls = rVar.getClass();
            if (v.b(cls) == 2) {
                Object obj2 = v.f1510b.get(cls);
                be.h.b(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    v.a((Constructor) list.get(0), rVar);
                    throw null;
                }
                int size = list.size();
                h[] hVarArr = new h[size];
                if (size > 0) {
                    v.a((Constructor) list.get(0), rVar);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(hVarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(rVar);
            }
        }
        tVar.f1500b = reflectiveGenericLifecycleObserver;
        tVar.f1499a = nVar2;
        p.a aVar = this.f1503b;
        p.c cVarB = aVar.b(rVar);
        if (cVarB != null) {
            obj = cVarB.f9597v;
        } else {
            HashMap map2 = aVar.f9592y;
            p.c cVar = new p.c(rVar, tVar);
            aVar.f9606x++;
            p.c cVar2 = aVar.f9604v;
            if (cVar2 == null) {
                aVar.f9603u = cVar;
                aVar.f9604v = cVar;
            } else {
                cVar2.f9598w = cVar;
                cVar.f9599x = cVar2;
                aVar.f9604v = cVar;
            }
            map2.put(rVar, cVar);
            obj = null;
        }
        if (((t) obj) == null && (sVar = (s) this.f1505d.get()) != null) {
            boolean z11 = this.f1506e != 0 || this.f;
            n nVarB = b(rVar);
            this.f1506e++;
            while (tVar.f1499a.compareTo(nVarB) < 0 && this.f1503b.f9592y.containsKey(rVar)) {
                n nVar3 = tVar.f1499a;
                ArrayList arrayList = this.f1508h;
                arrayList.add(nVar3);
                k kVar = m.Companion;
                n nVar4 = tVar.f1499a;
                kVar.getClass();
                be.h.e(nVar4, "state");
                int iOrdinal = nVar4.ordinal();
                m mVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : m.ON_RESUME : m.ON_START : m.ON_CREATE;
                if (mVar == null) {
                    throw new IllegalStateException("no event up from " + tVar.f1499a);
                }
                tVar.a(sVar, mVar);
                arrayList.remove(arrayList.size() - 1);
                nVarB = b(rVar);
            }
            if (!z11) {
                h();
            }
            this.f1506e--;
        }
    }

    public final n b(r rVar) {
        t tVar;
        HashMap map = this.f1503b.f9592y;
        p.c cVar = map.containsKey(rVar) ? ((p.c) map.get(rVar)).f9599x : null;
        n nVar = (cVar == null || (tVar = (t) cVar.f9597v) == null) ? null : tVar.f1499a;
        ArrayList arrayList = this.f1508h;
        n nVar2 = arrayList.isEmpty() ? null : (n) arrayList.get(arrayList.size() - 1);
        n nVar3 = this.f1504c;
        be.h.e(nVar3, "state1");
        if (nVar == null || nVar.compareTo(nVar3) >= 0) {
            nVar = nVar3;
        }
        return (nVar2 == null || nVar2.compareTo(nVar) >= 0) ? nVar : nVar2;
    }

    public final void c(String str) {
        if (this.f1502a) {
            o.a.Y().f.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(e6.j.n("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(m mVar) {
        be.h.e(mVar, "event");
        c("handleLifecycleEvent");
        e(mVar.a());
    }

    public final void e(n nVar) {
        n nVar2 = this.f1504c;
        if (nVar2 == nVar) {
            return;
        }
        n nVar3 = n.f1483v;
        n nVar4 = n.f1482u;
        if (nVar2 == nVar3 && nVar == nVar4) {
            throw new IllegalStateException(("no event down from " + this.f1504c + " in component " + this.f1505d.get()).toString());
        }
        this.f1504c = nVar;
        if (this.f || this.f1506e != 0) {
            this.f1507g = true;
            return;
        }
        this.f = true;
        h();
        this.f = false;
        if (this.f1504c == nVar4) {
            this.f1503b = new p.a();
        }
    }

    public final void f(r rVar) {
        be.h.e(rVar, "observer");
        c("removeObserver");
        this.f1503b.d(rVar);
    }

    public final void g() {
        c("setCurrentState");
        e(n.f1484w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r12.f1507g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.u.h():void");
    }
}
