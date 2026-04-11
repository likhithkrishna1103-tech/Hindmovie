package w4;

import be.h;
import cf.l;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import od.i;
import od.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f13736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f13737d;

    public g(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        h.e(abstractSet, "foreignKeys");
        this.f13734a = str;
        this.f13735b = map;
        this.f13736c = abstractSet;
        this.f13737d = abstractSet2;
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f13734a.equals(gVar.f13734a) || !this.f13735b.equals(gVar.f13735b) || !h.a(this.f13736c, gVar.f13736c)) {
            return false;
        }
        Set set2 = this.f13737d;
        if (set2 == null || (set = gVar.f13737d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f13736c.hashCode() + ((this.f13735b.hashCode() + (this.f13734a.hashCode() * 31)) * 31);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.Map] */
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb2.append(this.f13734a);
        sb2.append("',\n            |    columns = {");
        sb2.append(l.r(i.f0(this.f13735b.values(), new c0.i(8))));
        sb2.append("\n            |    foreignKeys = {");
        sb2.append(l.r(this.f13736c));
        sb2.append("\n            |    indices = {");
        Set set = this.f13737d;
        sb2.append(l.r(set != null ? i.f0(set, new c0.i(9)) : q.f9570u));
        sb2.append("\n            |}\n        ");
        return ie.g.E(sb2.toString());
    }
}
