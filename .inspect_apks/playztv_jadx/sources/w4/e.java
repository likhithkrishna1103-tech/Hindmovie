package w4;

import be.h;
import e6.j;
import java.util.ArrayList;
import nd.k;
import od.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f13728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f13729e;

    public e(String str, String str2, String str3, ArrayList arrayList, ArrayList arrayList2) {
        h.e(str, "referenceTable");
        h.e(str2, "onDelete");
        h.e(str3, "onUpdate");
        this.f13725a = str;
        this.f13726b = str2;
        this.f13727c = str3;
        this.f13728d = arrayList;
        this.f13729e = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (h.a(this.f13725a, eVar.f13725a) && h.a(this.f13726b, eVar.f13726b) && h.a(this.f13727c, eVar.f13727c) && this.f13728d.equals(eVar.f13728d)) {
            return this.f13729e.equals(eVar.f13729e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13729e.hashCode() + ((this.f13728d.hashCode() + j.h(j.h(this.f13725a.hashCode() * 31, 31, this.f13726b), 31, this.f13727c)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb2.append(this.f13725a);
        sb2.append("',\n            |   onDelete = '");
        sb2.append(this.f13726b);
        sb2.append("',\n            |   onUpdate = '");
        sb2.append(this.f13727c);
        sb2.append("',\n            |   columnNames = {");
        ie.g.D(i.b0(i.e0(this.f13728d), ",", null, null, null, 62));
        ie.g.D("},");
        k kVar = k.f8990a;
        sb2.append(kVar);
        sb2.append("\n            |   referenceColumnNames = {");
        ie.g.D(i.b0(i.e0(this.f13729e), ",", null, null, null, 62));
        ie.g.D(" }");
        sb2.append(kVar);
        sb2.append("\n            |}\n        ");
        return ie.g.D(ie.g.E(sb2.toString()));
    }
}
