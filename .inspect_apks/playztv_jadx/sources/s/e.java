package s;

import androidx.datastore.preferences.protobuf.i1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e extends i implements Map {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i1 f11621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f11622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public d f11623z;

    public e(e eVar) {
        super(0);
        g(eVar);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        i1 i1Var = this.f11621x;
        if (i1Var != null) {
            return i1Var;
        }
        i1 i1Var2 = new i1(this, 1);
        this.f11621x = i1Var2;
        return i1Var2;
    }

    public final boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f11622y;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f11622y = bVar2;
        return bVar2;
    }

    public final boolean l(Collection collection) {
        int i = this.f11635w;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.f11635w;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f11635w);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f11623z;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.f11623z = dVar2;
        return dVar2;
    }
}
