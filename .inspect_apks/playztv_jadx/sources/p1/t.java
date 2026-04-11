package p1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10060d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10062b;

    static {
        int i = s1.b0.f11647a;
        f10059c = Integer.toString(0, 36);
        f10060d = Integer.toString(1, 36);
    }

    public t(String str, String str2) {
        this.f10061a = s1.b0.P(str);
        this.f10062b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t.class == obj.getClass()) {
            t tVar = (t) obj;
            if (Objects.equals(this.f10061a, tVar.f10061a) && Objects.equals(this.f10062b, tVar.f10062b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f10062b.hashCode() * 31;
        String str = this.f10061a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
