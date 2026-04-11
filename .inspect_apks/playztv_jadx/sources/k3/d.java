package k3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f6988e;
    public final i[] f;

    public d(String str, boolean z2, boolean z10, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f6985b = str;
        this.f6986c = z2;
        this.f6987d = z10;
        this.f6988e = strArr;
        this.f = iVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f6986c == dVar.f6986c && this.f6987d == dVar.f6987d && Objects.equals(this.f6985b, dVar.f6985b) && Arrays.equals(this.f6988e, dVar.f6988e) && Arrays.equals(this.f, dVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((527 + (this.f6986c ? 1 : 0)) * 31) + (this.f6987d ? 1 : 0)) * 31;
        String str = this.f6985b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
