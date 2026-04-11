package androidx.navigation;

import androidx.fragment.app.t0;
import androidx.lifecycle.o0;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h extends o0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t0 f1353e = new t0(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f1354d = new HashMap();

    @Override // androidx.lifecycle.o0
    public final void b() {
        HashMap map = this.f1354d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((androidx.lifecycle.t0) it.next()).a();
        }
        map.clear();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator it = this.f1354d.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
