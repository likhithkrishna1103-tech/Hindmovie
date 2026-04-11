package p1;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10064b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f10065a;

    static {
        int i = s1.b0.f11647a;
        f10064b = Integer.toString(0, 36);
    }

    public u(r0 r0Var) {
        this.f10065a = (Uri) r0Var.f10045a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && this.f10065a.equals(((u) obj).f10065a);
    }

    public final int hashCode() {
        return this.f10065a.hashCode() * 31;
    }
}
