package l3;

import java.util.ArrayList;
import p1.i0;
import p1.k0;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7814a;

    public c(ArrayList arrayList) {
        this.f7814a = arrayList;
        boolean z2 = false;
        if (!arrayList.isEmpty()) {
            long j5 = ((b) arrayList.get(0)).f7812b;
            int i = 1;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                if (((b) arrayList.get(i)).f7811a < j5) {
                    z2 = true;
                    break;
                } else {
                    j5 = ((b) arrayList.get(i)).f7812b;
                    i++;
                }
            }
        }
        s1.d.b(!z2);
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f7814a.equals(((c) obj).f7814a);
    }

    public final int hashCode() {
        return this.f7814a.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=" + this.f7814a;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
