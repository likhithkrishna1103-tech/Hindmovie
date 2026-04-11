package sd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s extends t1 {
    public static int A(int i) {
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

    public static Map B(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return q.f11670v;
        }
        if (size == 1) {
            rd.f fVar = (rd.f) arrayList.get(0);
            ge.i.e(fVar, "pair");
            Map mapSingletonMap = Collections.singletonMap(fVar.f10993v, fVar.f10994w);
            ge.i.d(mapSingletonMap, "singletonMap(...)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(A(arrayList.size()));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            rd.f fVar2 = (rd.f) obj;
            linkedHashMap.put(fVar2.f10993v, fVar2.f10994w);
        }
        return linkedHashMap;
    }

    public static Map C(Map map) {
        ge.i.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return q.f11670v;
        }
        if (size != 1) {
            return D(map);
        }
        ge.i.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        ge.i.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static LinkedHashMap D(Map map) {
        ge.i.e(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static Object z(Map map, Object obj) {
        ge.i.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
