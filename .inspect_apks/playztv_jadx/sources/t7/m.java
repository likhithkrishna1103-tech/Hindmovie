package t7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f12321b = new m(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12322a;

    public /* synthetic */ m(String str) {
        this.f12322a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return v.k(this.f12322a, ((m) obj).f12322a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12322a});
    }
}
