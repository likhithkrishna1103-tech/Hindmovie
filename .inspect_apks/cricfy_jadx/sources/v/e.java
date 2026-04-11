package v;

import androidx.datastore.preferences.protobuf.z0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e extends k implements Map {
    public d A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public z0 f12519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f12520z;

    public e() {
        super(0);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        z0 z0Var = this.f12519y;
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this, 2);
        this.f12519y = z0Var2;
        return z0Var2;
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
        b bVar = this.f12520z;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f12520z = bVar2;
        return bVar2;
    }

    public final boolean l(Collection collection) {
        int i = this.f12542x;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.f12542x;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f12542x);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.A;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.A = dVar2;
        return dVar2;
    }

    public e(e eVar) {
        super(0);
        g(eVar);
    }
}
