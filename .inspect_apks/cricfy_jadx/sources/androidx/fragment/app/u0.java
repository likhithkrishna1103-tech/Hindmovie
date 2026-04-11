package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 extends androidx.lifecycle.o0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final t0 f1077j = new t0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1080g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f1078d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f1079e = new HashMap();
    public final HashMap f = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1081h = false;
    public boolean i = false;

    public u0(boolean z10) {
        this.f1080g = z10;
    }

    @Override // androidx.lifecycle.o0
    public final void b() {
        if (r0.J(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f1081h = true;
    }

    public final void c(y yVar) {
        if (this.i) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = yVar.A;
        HashMap map = this.f1078d;
        if (map.containsKey(str)) {
            return;
        }
        map.put(yVar.A, yVar);
        if (r0.J(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + yVar);
        }
    }

    public final void d(y yVar) {
        if (r0.J(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + yVar);
        }
        e(yVar.A);
    }

    public final void e(String str) {
        HashMap map = this.f1079e;
        u0 u0Var = (u0) map.get(str);
        if (u0Var != null) {
            u0Var.b();
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
        if (obj != null && u0.class == obj.getClass()) {
            u0 u0Var = (u0) obj;
            if (this.f1078d.equals(u0Var.f1078d) && this.f1079e.equals(u0Var.f1079e) && this.f.equals(u0Var.f)) {
                return true;
            }
        }
        return false;
    }

    public final void f(y yVar) {
        if (this.i) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f1078d.remove(yVar.A) == null || !r0.J(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + yVar);
        }
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.f1079e.hashCode() + (this.f1078d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f1078d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f1079e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
