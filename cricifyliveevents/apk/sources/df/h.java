package df;

import java.util.LinkedHashMap;
import java.util.Map;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.a f3706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3707b;

    public h(ze.a aVar) {
        q qVar = q.f3731a;
        this.f3706a = aVar;
        this.f3707b = new g(q.f3732b, aVar.d());
    }

    @Override // ze.a
    public Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        ge.i.e(kVar, "decoder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ge.i.e(linkedHashMap, "<this>");
        int size = linkedHashMap.size() * 2;
        ff.k kVarC = kVar.c(d());
        while (true) {
            int iG = kVarC.g(d());
            if (iG == -1) {
                kVarC.t(d());
                ge.i.e(linkedHashMap, "<this>");
                return linkedHashMap;
            }
            int i = iG + size;
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            ge.i.e(linkedHashMap2, "builder");
            q qVar = q.f3731a;
            g gVar = this.f3707b;
            Object objN = kVarC.n(gVar, i, qVar, null);
            int iG2 = kVarC.g(gVar);
            if (iG2 != i + 1) {
                throw new IllegalArgumentException(q4.a.m(i, iG2, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
            }
            boolean zContainsKey = linkedHashMap2.containsKey(objN);
            ze.a aVar = this.f3706a;
            linkedHashMap2.put(objN, (!zContainsKey || (aVar.d().c() instanceof bf.c)) ? kVarC.n(gVar, iG2, aVar, null) : kVarC.n(gVar, iG2, aVar, s.z(linkedHashMap2, objN)));
        }
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        Map map = (Map) obj;
        ge.i.e(map, "<this>");
        map.size();
        g gVar = this.f3707b;
        ge.i.e(gVar, "descriptor");
        ff.l lVarA = lVar.a(gVar);
        Map map2 = (Map) obj;
        ge.i.e(map2, "<this>");
        int i = 0;
        for (Map.Entry entry : map2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i10 = i + 1;
            lVarA.h(gVar, i, q.f3731a, key);
            i += 2;
            lVarA.h(gVar, i10, this.f3706a, value);
        }
        lVarA.l(gVar);
    }

    @Override // ze.a
    public final bf.d d() {
        return this.f3707b;
    }
}
