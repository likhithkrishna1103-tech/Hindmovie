package w4;

import be.h;
import ie.n;
import java.util.ArrayList;
import java.util.List;
import nd.k;
import od.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f13732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13733d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public f(String str, boolean z2, List list, List list2) {
        h.e(str, "name");
        h.e(list, "columns");
        h.e(list2, "orders");
        this.f13730a = str;
        this.f13731b = z2;
        this.f13732c = list;
        this.f13733d = list2;
        List arrayList = list2;
        if (arrayList.isEmpty()) {
            int size = list.size();
            arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add("ASC");
            }
        }
        this.f13733d = (List) arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            String str = fVar.f13730a;
            if (this.f13731b == fVar.f13731b && h.a(this.f13732c, fVar.f13732c) && h.a(this.f13733d, fVar.f13733d)) {
                String str2 = this.f13730a;
                return n.M(str2, "index_", false) ? n.M(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f13730a;
        return this.f13733d.hashCode() + ((this.f13732c.hashCode() + ((((n.M(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f13731b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |Index {\n            |   name = '");
        sb2.append(this.f13730a);
        sb2.append("',\n            |   unique = '");
        sb2.append(this.f13731b);
        sb2.append("',\n            |   columns = {");
        ie.g.D(i.b0(this.f13732c, ",", null, null, null, 62));
        ie.g.D("},");
        k kVar = k.f8990a;
        sb2.append(kVar);
        sb2.append("\n            |   orders = {");
        ie.g.D(i.b0(this.f13733d, ",", null, null, null, 62));
        ie.g.D(" }");
        sb2.append(kVar);
        sb2.append("\n            |}\n        ");
        return ie.g.D(ie.g.E(sb2.toString()));
    }
}
