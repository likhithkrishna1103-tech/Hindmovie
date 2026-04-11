package p3;

import java.util.ArrayList;
import v1.i0;
import v1.k0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9985a;

    public c(ArrayList arrayList) {
        this.f9985a = arrayList;
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            long j4 = ((b) arrayList.get(0)).f9983b;
            int i = 1;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                if (((b) arrayList.get(i)).f9982a < j4) {
                    z10 = true;
                    break;
                } else {
                    j4 = ((b) arrayList.get(i)).f9983b;
                    i++;
                }
            }
        }
        y1.d.b(!z10);
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f9985a.equals(((c) obj).f9985a);
    }

    public final int hashCode() {
        return this.f9985a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f9985a;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
