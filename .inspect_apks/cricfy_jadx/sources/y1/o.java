package y1;

import com.google.android.gms.internal.measurement.o4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o4 f14588b = new o4(8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14590d;

    public o(Object obj) {
        this.f14587a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.f14587a.equals(((o) obj).f14587a);
    }

    public final int hashCode() {
        return this.f14587a.hashCode();
    }
}
