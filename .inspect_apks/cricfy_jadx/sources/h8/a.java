package h8;

import android.util.SparseArray;
import java.util.HashMap;
import l0.e;
import u7.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f5846a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f5847b;

    static {
        HashMap map = new HashMap();
        f5847b = map;
        map.put(d.f12281v, 0);
        map.put(d.f12282w, 1);
        map.put(d.f12283x, 2);
        for (d dVar : map.keySet()) {
            f5846a.append(((Integer) f5847b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f5847b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = (d) f5846a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(e.g(i, "Unknown Priority for value "));
    }
}
