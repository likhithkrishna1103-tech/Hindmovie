package hb;

import android.util.Log;
import com.google.android.gms.internal.measurement.z3;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c {
    public static final f C = new f(0);
    public final AtomicReference A;
    public final x3.b B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f5885v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f5886w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f5887x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashSet f5888y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l f5889z;

    public g(ArrayList arrayList, ArrayList arrayList2, x3.b bVar) {
        ib.k kVar = ib.k.f6411v;
        this.f5885v = new HashMap();
        this.f5886w = new HashMap();
        this.f5887x = new HashMap();
        this.f5888y = new HashSet();
        this.A = new AtomicReference();
        l lVar = new l();
        this.f5889z = lVar;
        this.B = bVar;
        ArrayList arrayList3 = new ArrayList();
        int i = 2;
        int i10 = 0;
        arrayList3.add(b.c(lVar, l.class, ec.c.class, ec.b.class));
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
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((hc.b) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.B.c(componentRegistrar));
                        it.remove();
                    }
                } catch (m e9) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e9);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                Object[] array = ((b) it2.next()).f5877b.toArray();
                int length = array.length;
                int i13 = 0;
                while (true) {
                    if (i13 < length) {
                        Object obj3 = array[i13];
                        if (obj3.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f5888y.contains(obj3.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f5888y.add(obj3.toString());
                        }
                        i13++;
                    }
                }
            }
            if (this.f5885v.isEmpty()) {
                com.bumptech.glide.f.k(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f5885v.keySet());
                arrayList6.addAll(arrayList3);
                com.bumptech.glide.f.k(arrayList6);
            }
            int size3 = arrayList3.size();
            int i14 = 0;
            while (i14 < size3) {
                Object obj4 = arrayList3.get(i14);
                i14++;
                b bVar3 = (b) obj4;
                this.f5885v.put(bVar3, new n(new ab.c(i, this, bVar3)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            e();
        }
        int size4 = arrayList5.size();
        while (i10 < size4) {
            Object obj5 = arrayList5.get(i10);
            i10++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.A.get();
        if (bool != null) {
            a(this.f5885v, bool.booleanValue());
        }
    }

    public final void a(HashMap map, boolean z10) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            b bVar = (b) entry.getKey();
            hc.b bVar2 = (hc.b) entry.getValue();
            int i = bVar.f5879d;
            if (i == 1 || (i == 2 && z10)) {
                bVar2.get();
            }
        }
        l lVar = this.f5889z;
        synchronized (lVar) {
            try {
                arrayDeque = lVar.f5899b;
                if (arrayDeque != null) {
                    lVar.f5899b = null;
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
                throw q4.a.l(it);
            }
        }
    }

    @Override // hb.c
    public final Object b(Class cls) {
        return f(r.a(cls));
    }

    @Override // hb.c
    public final p c(r rVar) {
        hc.b bVarD = d(rVar);
        return bVarD == null ? new p(p.f5906c, p.f5907d) : bVarD instanceof p ? (p) bVarD : new p(null, bVarD);
    }

    @Override // hb.c
    public final synchronized hc.b d(r rVar) {
        z3.h(rVar, "Null interface requested.");
        return (hc.b) this.f5886w.get(rVar);
    }

    public final void e() {
        HashMap map = this.f5886w;
        HashMap map2 = this.f5887x;
        for (b bVar : this.f5885v.keySet()) {
            for (j jVar : bVar.f5878c) {
                boolean z10 = jVar.f5896b == 2;
                r rVar = jVar.f5895a;
                if (z10 && !map2.containsKey(rVar)) {
                    Set set = Collections.EMPTY_SET;
                    o oVar = new o();
                    oVar.f5905b = null;
                    oVar.f5904a = Collections.newSetFromMap(new ConcurrentHashMap());
                    oVar.f5904a.addAll(set);
                    map2.put(rVar, oVar);
                } else if (map.containsKey(rVar)) {
                    continue;
                } else {
                    int i = jVar.f5896b;
                    if (i == 1) {
                        throw new k("Unsatisfied dependency for component " + bVar + ": " + rVar);
                    }
                    if (i != 2) {
                        map.put(rVar, new p(p.f5906c, p.f5907d));
                    }
                }
            }
        }
    }

    @Override // hb.c
    public final Object f(r rVar) {
        hc.b bVarD = d(rVar);
        if (bVarD == null) {
            return null;
        }
        return bVarD.get();
    }

    @Override // hb.c
    public final hc.b g(Class cls) {
        return d(r.a(cls));
    }

    @Override // hb.c
    public final Set h(r rVar) {
        hc.b bVar;
        synchronized (this) {
            bVar = (o) this.f5887x.get(rVar);
            if (bVar == null) {
                bVar = C;
            }
        }
        return (Set) bVar.get();
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b bVar = (b) obj;
            if (bVar.f5880e == 0) {
                hc.b bVar2 = (hc.b) this.f5885v.get(bVar);
                for (r rVar : bVar.f5877b) {
                    HashMap map = this.f5886w;
                    if (map.containsKey(rVar)) {
                        arrayList2.add(new androidx.fragment.app.d(12, (p) ((hc.b) map.get(rVar)), bVar2));
                    } else {
                        map.put(rVar, bVar2);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList j() {
        HashMap map = this.f5887x;
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : this.f5885v.entrySet()) {
            b bVar = (b) entry.getKey();
            if (bVar.f5880e != 0) {
                hc.b bVar2 = (hc.b) entry.getValue();
                for (r rVar : bVar.f5877b) {
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
                    arrayList.add(new androidx.fragment.app.d(13, oVar, (hc.b) it.next()));
                }
            } else {
                r rVar2 = (r) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                o oVar2 = new o();
                oVar2.f5905b = null;
                oVar2.f5904a = Collections.newSetFromMap(new ConcurrentHashMap());
                oVar2.f5904a.addAll(set);
                map.put(rVar2, oVar2);
            }
        }
        return arrayList;
    }
}
