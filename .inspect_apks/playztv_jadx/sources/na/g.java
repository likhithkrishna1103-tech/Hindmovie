package na;

import a2.g0;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c {
    public static final f B = new f(0);
    public final pa.b A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f8888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f8889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f8890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashSet f8891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f8892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicReference f8893z;

    public g(ArrayList arrayList, ArrayList arrayList2, pa.b bVar) {
        oa.j jVar = oa.j.f9477u;
        this.f8888u = new HashMap();
        this.f8889v = new HashMap();
        this.f8890w = new HashMap();
        this.f8891x = new HashSet();
        this.f8893z = new AtomicReference();
        l lVar = new l();
        this.f8892y = lVar;
        this.A = bVar;
        ArrayList arrayList3 = new ArrayList();
        int i = 2;
        int i10 = 0;
        arrayList3.add(b.c(lVar, l.class, kb.c.class, kb.b.class));
        arrayList3.add(b.c(this, g.class, new Class[0]));
        int size = arrayList2.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            b bVar2 = (b) obj;
            if (bVar2 != null) {
                arrayList3.add(bVar2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((nb.b) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.A.j(componentRegistrar));
                        it.remove();
                    }
                } catch (m e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                Object[] array = ((b) it2.next()).f8880b.toArray();
                int length = array.length;
                int i13 = 0;
                while (true) {
                    if (i13 < length) {
                        Object obj3 = array[i13];
                        if (obj3.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f8891x.contains(obj3.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f8891x.add(obj3.toString());
                        }
                        i13++;
                    }
                }
            }
            if (this.f8888u.isEmpty()) {
                cf.d.m(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f8888u.keySet());
                arrayList6.addAll(arrayList3);
                cf.d.m(arrayList6);
            }
            int size3 = arrayList3.size();
            int i14 = 0;
            while (i14 < size3) {
                Object obj4 = arrayList3.get(i14);
                i14++;
                b bVar3 = (b) obj4;
                this.f8888u.put(bVar3, new n(new ga.c(this, i, bVar3)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            f();
        }
        int size4 = arrayList5.size();
        while (i10 < size4) {
            Object obj5 = arrayList5.get(i10);
            i10++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.f8893z.get();
        if (bool != null) {
            a(this.f8888u, bool.booleanValue());
        }
    }

    public final void a(HashMap map, boolean z2) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            b bVar = (b) entry.getKey();
            nb.b bVar2 = (nb.b) entry.getValue();
            int i = bVar.f8882d;
            if (i == 1 || (i == 2 && z2)) {
                bVar2.get();
            }
        }
        l lVar = this.f8892y;
        synchronized (lVar) {
            try {
                arrayDeque = lVar.f8903b;
                if (arrayDeque != null) {
                    lVar.f8903b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                throw l4.a.k(it);
            }
        }
    }

    @Override // na.c
    public final Object b(Class cls) {
        return d(r.a(cls));
    }

    @Override // na.c
    public final Set c(r rVar) {
        nb.b bVar;
        synchronized (this) {
            bVar = (o) this.f8890w.get(rVar);
            if (bVar == null) {
                bVar = B;
            }
        }
        return (Set) bVar.get();
    }

    @Override // na.c
    public final Object d(r rVar) {
        nb.b bVarG = g(rVar);
        if (bVarG == null) {
            return null;
        }
        return bVarG.get();
    }

    @Override // na.c
    public final nb.b e(Class cls) {
        return g(r.a(cls));
    }

    public final void f() {
        HashMap map = this.f8889v;
        HashMap map2 = this.f8890w;
        for (b bVar : this.f8888u.keySet()) {
            for (j jVar : bVar.f8881c) {
                boolean z2 = jVar.f8900b == 2;
                r rVar = jVar.f8899a;
                if (z2 && !map2.containsKey(rVar)) {
                    Set set = Collections.EMPTY_SET;
                    o oVar = new o();
                    oVar.f8909b = null;
                    oVar.f8908a = Collections.newSetFromMap(new ConcurrentHashMap());
                    oVar.f8908a.addAll(set);
                    map2.put(rVar, oVar);
                } else if (map.containsKey(rVar)) {
                    continue;
                } else {
                    int i = jVar.f8900b;
                    if (i == 1) {
                        throw new k("Unsatisfied dependency for component " + bVar + ": " + rVar);
                    }
                    if (i != 2) {
                        map.put(rVar, new p(p.f8910c, p.f8911d));
                    }
                }
            }
        }
    }

    @Override // na.c
    public final synchronized nb.b g(r rVar) {
        cf.l.i(rVar, "Null interface requested.");
        return (nb.b) this.f8889v.get(rVar);
    }

    @Override // na.c
    public final p h(r rVar) {
        nb.b bVarG = g(rVar);
        return bVarG == null ? new p(p.f8910c, p.f8911d) : bVarG instanceof p ? (p) bVarG : new p(null, bVarG);
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b bVar = (b) obj;
            if (bVar.f8883e == 0) {
                nb.b bVar2 = (nb.b) this.f8888u.get(bVar);
                for (r rVar : bVar.f8880b) {
                    HashMap map = this.f8889v;
                    if (map.containsKey(rVar)) {
                        arrayList2.add(new g0((p) ((nb.b) map.get(rVar)), 26, bVar2));
                    } else {
                        map.put(rVar, bVar2);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList j() {
        HashMap map = this.f8890w;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.f8888u.entrySet()) {
            b bVar = (b) entry.getKey();
            if (bVar.f8883e != 0) {
                nb.b bVar2 = (nb.b) entry.getValue();
                for (r rVar : bVar.f8880b) {
                    if (!map2.containsKey(rVar)) {
                        map2.put(rVar, new HashSet());
                    }
                    ((Set) map2.get(rVar)).add(bVar2);
                }
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (map.containsKey(entry2.getKey())) {
                o oVar = (o) map.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new g0(oVar, 27, (nb.b) it.next()));
                }
            } else {
                r rVar2 = (r) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                o oVar2 = new o();
                oVar2.f8909b = null;
                oVar2.f8908a = Collections.newSetFromMap(new ConcurrentHashMap());
                oVar2.f8908a.addAll(set);
                map.put(rVar2, oVar2);
            }
        }
        return arrayList;
    }
}
