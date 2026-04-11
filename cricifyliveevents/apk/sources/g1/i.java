package g1;

import fe.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import rd.l;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends xd.h implements q {
    public /* synthetic */ h1.b A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public /* synthetic */ f1.f f4614z;

    @Override // fe.q
    public final Object g(Object obj, Object obj2, Object obj3) {
        i iVar = new i(3, (vd.c) obj3);
        iVar.f4614z = (f1.f) obj;
        iVar.A = (h1.b) obj2;
        return iVar.o(l.f11003a);
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        com.bumptech.glide.c.C(obj);
        f1.f fVar = this.f4614z;
        h1.b bVar = this.A;
        Set setKeySet = bVar.a().keySet();
        ArrayList arrayList = new ArrayList(sd.l.f0(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((h1.e) it.next()).f5477a);
        }
        Map<String, ?> all = fVar.f3927a.getAll();
        ge.i.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it2.next();
            String key = next.getKey();
            Set set = fVar.f3928b;
            if (set != null ? set.contains(key) : true) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(s.A(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key2 = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = sd.j.u0((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!arrayList.contains((String) entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        h1.b bVar2 = new h1.b(s.D(bVar.a()), false);
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str = (String) entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Boolean) {
                ge.i.e(str, "name");
                bVar2.e(new h1.e(str), value2);
            } else if (value2 instanceof Float) {
                ge.i.e(str, "name");
                bVar2.e(new h1.e(str), value2);
            } else if (value2 instanceof Integer) {
                ge.i.e(str, "name");
                bVar2.e(new h1.e(str), value2);
            } else if (value2 instanceof Long) {
                ge.i.e(str, "name");
                bVar2.e(new h1.e(str), value2);
            } else if (value2 instanceof String) {
                ge.i.e(str, "name");
                bVar2.e(new h1.e(str), value2);
            } else if (value2 instanceof Set) {
                bVar2.e(w8.e.m(str), (Set) value2);
            }
        }
        return new h1.b(s.D(bVar2.a()), true);
    }
}
