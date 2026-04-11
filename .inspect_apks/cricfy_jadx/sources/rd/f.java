package rd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f10993v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f10994w;

    public f(Object obj, Object obj2) {
        this.f10993v = obj;
        this.f10994w = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return ge.i.a(this.f10993v, fVar.f10993v) && ge.i.a(this.f10994w, fVar.f10994w);
    }

    public final int hashCode() {
        Object obj = this.f10993v;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f10994w;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f10993v + ", " + this.f10994w + ')';
    }
}
