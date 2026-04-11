package ua;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends x0 implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g4.d f12400v;

    public v(g4.d dVar) {
        this.f12400v = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f12400v.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return this.f12400v.equals(((v) obj).f12400v);
        }
        return false;
    }

    public final int hashCode() {
        return this.f12400v.hashCode();
    }

    public final String toString() {
        return this.f12400v.toString();
    }
}
