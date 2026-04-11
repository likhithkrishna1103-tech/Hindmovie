package ua;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient Set f12368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient n f12369w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public transient Map f12370x;

    public abstract Map a();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return ((v0) this).a().equals(((v0) ((o) obj)).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
