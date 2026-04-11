package gb;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5366b;

    public c(String str, Map map) {
        this.f5365a = str;
        this.f5366b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5365a.equals(cVar.f5365a) && this.f5366b.equals(cVar.f5366b);
    }

    public final int hashCode() {
        return this.f5366b.hashCode() + (this.f5365a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f5365a + ", properties=" + this.f5366b.values() + "}";
    }
}
