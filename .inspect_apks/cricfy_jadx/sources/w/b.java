package w;

import android.util.Log;
import ge.i;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f13746a;

    public b(int i) {
        switch (i) {
            case 1:
                this.f13746a = new LinkedHashMap();
                break;
            default:
                this.f13746a = new LinkedHashMap(0, 0.75f, true);
                break;
        }
    }

    public void a(ed.a aVar) {
        i.e(aVar, "migration");
        int i = aVar.f3887a;
        int i10 = aVar.f3888b;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.f13746a;
        Object treeMap = linkedHashMap.get(numValueOf);
        if (treeMap == null) {
            treeMap = new TreeMap();
            linkedHashMap.put(numValueOf, treeMap);
        }
        TreeMap treeMap2 = (TreeMap) treeMap;
        if (treeMap2.containsKey(Integer.valueOf(i10))) {
            Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i10)) + " with " + aVar);
        }
        treeMap2.put(Integer.valueOf(i10), aVar);
    }
}
