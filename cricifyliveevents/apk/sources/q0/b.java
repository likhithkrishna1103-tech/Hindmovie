package q0;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f10323c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f10321a, bVar.f10321a) && Objects.equals(this.f10322b, bVar.f10322b) && Objects.equals(this.f10323c, bVar.f10323c);
    }

    public final int hashCode() {
        return Objects.hash(this.f10321a, this.f10322b, this.f10323c);
    }
}
