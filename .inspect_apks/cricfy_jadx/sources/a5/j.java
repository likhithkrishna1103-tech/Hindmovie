package a5;

import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f296d;

    public j(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        ge.i.e(abstractSet, "foreignKeys");
        this.f293a = str;
        this.f294b = map;
        this.f295c = abstractSet;
        this.f296d = abstractSet2;
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f293a.equals(jVar.f293a) || !this.f294b.equals(jVar.f294b) || !ge.i.a(this.f295c, jVar.f295c)) {
            return false;
        }
        Set set2 = this.f296d;
        if (set2 == null || (set = jVar.f296d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f295c.hashCode() + ((this.f294b.hashCode() + (this.f293a.hashCode() * 31)) * 31);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.Map] */
    public final String toString() {
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(this.f293a);
        sb.append("',\n            |    columns = {");
        sb.append(com.bumptech.glide.f.l(sd.j.p0(this.f294b.values(), new f(2))));
        sb.append("\n            |    foreignKeys = {");
        sb.append(com.bumptech.glide.f.l(this.f295c));
        sb.append("\n            |    indices = {");
        Set set = this.f296d;
        sb.append(com.bumptech.glide.f.l(set != null ? sd.j.p0(set, new f(3)) : p.f11669v));
        sb.append("\n            |}\n        ");
        return ne.i.U(sb.toString());
    }
}
