package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends androidx.lifecycle.o0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final p0 f1344j = new p0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1347g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f1345d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f1346e = new HashMap();
    public final HashMap f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1348h = false;
    public boolean i = false;

    public q0(boolean z2) {
        this.f1347g = z2;
    }

    @Override // androidx.lifecycle.o0
    public final void b() {
        if (n0.G(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1348h = true;
    }

    public final void c(v vVar) {
        if (this.i) {
            if (n0.G(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = vVar.f1398z;
        HashMap map = this.f1345d;
        if (map.containsKey(str)) {
            return;
        }
        map.put(vVar.f1398z, vVar);
        if (n0.G(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + vVar);
        }
    }

    public final void d(v vVar) {
        if (n0.G(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + vVar);
        }
        e(vVar.f1398z);
    }

    public final void e(String str) {
        HashMap map = this.f1346e;
        q0 q0Var = (q0) map.get(str);
        if (q0Var != null) {
            q0Var.b();
            map.remove(str);
        }
        HashMap map2 = this.f;
        androidx.lifecycle.t0 t0Var = (androidx.lifecycle.t0) map2.get(str);
        if (t0Var != null) {
            t0Var.a();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q0.class == obj.getClass()) {
            q0 q0Var = (q0) obj;
            if (this.f1345d.equals(q0Var.f1345d) && this.f1346e.equals(q0Var.f1346e) && this.f.equals(q0Var.f)) {
                return true;
            }
        }
        return false;
    }

    public final void f(v vVar) {
        if (this.i) {
            if (n0.G(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1345d.remove(vVar.f1398z) == null || !n0.G(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + vVar);
        }
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.f1346e.hashCode() + (this.f1345d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f1345d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f1346e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
