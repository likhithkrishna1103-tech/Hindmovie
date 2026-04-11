package n8;

import java.util.Arrays;
import nb.w;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l8.d f8883b;

    public /* synthetic */ j(a aVar, l8.d dVar) {
        this.f8882a = aVar;
        this.f8883b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof j)) {
            j jVar = (j) obj;
            if (u.j(this.f8882a, jVar.f8882a) && u.j(this.f8883b, jVar.f8883b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8882a, this.f8883b});
    }

    public final String toString() {
        w wVar = new w(this);
        wVar.v(this.f8882a, "key");
        wVar.v(this.f8883b, "feature");
        return wVar.toString();
    }
}
