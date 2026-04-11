package a5;

import java.util.ArrayList;
import java.util.List;
import ne.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f292d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    public i(String str, boolean z10, List list, List list2) {
        ge.i.e(str, "name");
        ge.i.e(list, "columns");
        ge.i.e(list2, "orders");
        this.f289a = str;
        this.f290b = z10;
        this.f291c = list;
        this.f292d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                list2.add("ASC");
            }
        }
        this.f292d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String str = iVar.f289a;
            if (this.f290b == iVar.f290b && ge.i.a(this.f291c, iVar.f291c) && ge.i.a(this.f292d, iVar.f292d)) {
                String str2 = this.f289a;
                return o.Z(str2, "index_", false) ? o.Z(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f289a;
        return this.f292d.hashCode() + ((this.f291c.hashCode() + ((((o.Z(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f290b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return ne.i.T(ne.i.U("\n            |Index {\n            |   name = '" + this.f289a + "',\n            |   unique = '" + this.f290b + "',\n            |   columns = {" + com.bumptech.glide.f.C(this.f291c) + "\n            |   orders = {" + com.bumptech.glide.f.B(this.f292d) + "\n            |}\n        "));
    }
}
