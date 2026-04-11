package m7;

import android.util.SparseArray;
import e6.j;
import java.util.HashMap;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f8309a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f8310b;

    static {
        HashMap map = new HashMap();
        f8310b = map;
        map.put(d.f14891u, 0);
        map.put(d.f14892v, 1);
        map.put(d.f14893w, 2);
        for (d dVar : map.keySet()) {
            f8309a.append(((Integer) f8310b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f8310b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = (d) f8309a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(j.l("Unknown Priority for value ", i));
    }
}
