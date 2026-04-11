package k3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6983e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i[] f6984g;

    public c(String str, int i, int i10, long j5, long j8, i[] iVarArr) {
        super("CHAP");
        this.f6980b = str;
        this.f6981c = i;
        this.f6982d = i10;
        this.f6983e = j5;
        this.f = j8;
        this.f6984g = iVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f6981c == cVar.f6981c && this.f6982d == cVar.f6982d && this.f6983e == cVar.f6983e && this.f == cVar.f && Objects.equals(this.f6980b, cVar.f6980b) && Arrays.equals(this.f6984g, cVar.f6984g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (((((((527 + this.f6981c) * 31) + this.f6982d) * 31) + ((int) this.f6983e)) * 31) + ((int) this.f)) * 31;
        String str = this.f6980b;
        return i + (str != null ? str.hashCode() : 0);
    }
}
