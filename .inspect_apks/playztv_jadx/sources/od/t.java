package od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends b8.h {
    public static int H(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map I(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return r.f9571u;
        }
        if (size == 1) {
            nd.f fVar = (nd.f) arrayList.get(0);
            be.h.e(fVar, "pair");
            Map mapSingletonMap = Collections.singletonMap(fVar.f8983u, fVar.f8984v);
            be.h.d(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(H(arrayList.size()));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            nd.f fVar2 = (nd.f) obj;
            linkedHashMap.put(fVar2.f8983u, fVar2.f8984v);
        }
        return linkedHashMap;
    }

    public static Map J(Map map) {
        be.h.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return r.f9571u;
        }
        if (size != 1) {
            return K(map);
        }
        be.h.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        be.h.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static LinkedHashMap K(Map map) {
        be.h.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
