package ac;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f410b;

    public c(String str, Map map) {
        this.f409a = str;
        this.f410b = map;
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
        return this.f409a.equals(cVar.f409a) && this.f410b.equals(cVar.f410b);
    }

    public final int hashCode() {
        return this.f410b.hashCode() + (this.f409a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f409a + ", properties=" + this.f410b.values() + "}";
    }
}
