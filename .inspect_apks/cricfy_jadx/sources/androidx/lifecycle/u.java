package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q.a f1199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f1200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f1201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1202e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f1204h;

    public u(s sVar) {
        new AtomicReference();
        this.f1198a = true;
        this.f1199b = new q.a();
        this.f1200c = n.f1180w;
        this.f1204h = new ArrayList();
        this.f1201d = new WeakReference(sVar);
    }

    public final void a(r rVar) {
        q reflectiveGenericLifecycleObserver;
        Object obj;
        s sVar;
        ge.i.e(rVar, "observer");
        c("addObserver");
        n nVar = this.f1200c;
        n nVar2 = n.f1179v;
        if (nVar != nVar2) {
            nVar2 = n.f1180w;
        }
        t tVar = new t();
        HashMap map = v.f1205a;
        boolean z10 = rVar instanceof q;
        boolean z11 = rVar instanceof e;
        if (z10 && z11) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) rVar, (q) rVar);
        } else if (z11) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((e) rVar, null);
        } else if (z10) {
            reflectiveGenericLifecycleObserver = (q) rVar;
        } else {
            Class<?> cls = rVar.getClass();
            if (v.b(cls) == 2) {
                Object obj2 = v.f1206b.get(cls);
                ge.i.b(obj2);
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
        tVar.f1196b = reflectiveGenericLifecycleObserver;
        tVar.f1195a = nVar2;
        q.a aVar = this.f1199b;
        q.c cVarA = aVar.a(rVar);
        if (cVarA != null) {
            obj = cVarA.f10311w;
        } else {
            HashMap map2 = aVar.f10306z;
            q.c cVar = new q.c(rVar, tVar);
            aVar.f10320y++;
            q.c cVar2 = aVar.f10318w;
            if (cVar2 == null) {
                aVar.f10317v = cVar;
                aVar.f10318w = cVar;
            } else {
                cVar2.f10312x = cVar;
                cVar.f10313y = cVar2;
                aVar.f10318w = cVar;
            }
            map2.put(rVar, cVar);
            obj = null;
        }
        if (((t) obj) == null && (sVar = (s) this.f1201d.get()) != null) {
            boolean z12 = this.f1202e != 0 || this.f;
            n nVarB = b(rVar);
            this.f1202e++;
            while (tVar.f1195a.compareTo(nVarB) < 0 && this.f1199b.f10306z.containsKey(rVar)) {
                n nVar3 = tVar.f1195a;
                ArrayList arrayList = this.f1204h;
                arrayList.add(nVar3);
                k kVar = m.Companion;
                n nVar4 = tVar.f1195a;
                kVar.getClass();
                ge.i.e(nVar4, "state");
                int iOrdinal = nVar4.ordinal();
                m mVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : m.ON_RESUME : m.ON_START : m.ON_CREATE;
                if (mVar == null) {
                    throw new IllegalStateException("no event up from " + tVar.f1195a);
                }
                tVar.a(sVar, mVar);
                arrayList.remove(arrayList.size() - 1);
                nVarB = b(rVar);
            }
            if (!z12) {
                h();
            }
            this.f1202e--;
        }
    }

    public final n b(r rVar) {
        t tVar;
        HashMap map = this.f1199b.f10306z;
        q.c cVar = map.containsKey(rVar) ? ((q.c) map.get(rVar)).f10313y : null;
        n nVar = (cVar == null || (tVar = (t) cVar.f10311w) == null) ? null : tVar.f1195a;
        ArrayList arrayList = this.f1204h;
        n nVar2 = arrayList.isEmpty() ? null : (n) arrayList.get(arrayList.size() - 1);
        n nVar3 = this.f1200c;
        ge.i.e(nVar3, "state1");
        if (nVar == null || nVar.compareTo(nVar3) >= 0) {
            nVar = nVar3;
        }
        return (nVar2 == null || nVar2.compareTo(nVar) >= 0) ? nVar : nVar2;
    }

    public final void c(String str) {
        if (this.f1198a) {
            p.b.M().f9865a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(l0.e.k("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(m mVar) {
        ge.i.e(mVar, "event");
        c("handleLifecycleEvent");
        e(mVar.a());
    }

    public final void e(n nVar) {
        n nVar2 = this.f1200c;
        if (nVar2 == nVar) {
            return;
        }
        n nVar3 = n.f1180w;
        n nVar4 = n.f1179v;
        if (nVar2 == nVar3 && nVar == nVar4) {
            throw new IllegalStateException(("no event down from " + this.f1200c + " in component " + this.f1201d.get()).toString());
        }
        this.f1200c = nVar;
        if (this.f || this.f1202e != 0) {
            this.f1203g = true;
            return;
        }
        this.f = true;
        h();
        this.f = false;
        if (this.f1200c == nVar4) {
            this.f1199b = new q.a();
        }
    }

    public final void f(r rVar) {
        ge.i.e(rVar, "observer");
        c("removeObserver");
        this.f1199b.b(rVar);
    }

    public final void g(n nVar) {
        ge.i.e(nVar, "state");
        c("setCurrentState");
        e(nVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r12.f1203g = false;
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
