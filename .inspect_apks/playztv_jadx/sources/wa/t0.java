package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1 f14035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14036e;

    public t0(String str, String str2, List list, x1 x1Var, int i) {
        this.f14032a = str;
        this.f14033b = str2;
        this.f14034c = list;
        this.f14035d = x1Var;
        this.f14036e = i;
    }

    public final boolean equals(Object obj) {
        String str;
        x1 x1Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x1) {
            t0 t0Var = (t0) ((x1) obj);
            x1 x1Var2 = t0Var.f14035d;
            String str2 = t0Var.f14033b;
            if (this.f14032a.equals(t0Var.f14032a) && ((str = this.f14033b) != null ? str.equals(str2) : str2 == null) && this.f14034c.equals(t0Var.f14034c) && ((x1Var = this.f14035d) != null ? x1Var.equals(x1Var2) : x1Var2 == null) && this.f14036e == t0Var.f14036e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f14032a.hashCode() ^ 1000003) * 1000003;
        String str = this.f14033b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f14034c.hashCode()) * 1000003;
        x1 x1Var = this.f14035d;
        return ((iHashCode2 ^ (x1Var != null ? x1Var.hashCode() : 0)) * 1000003) ^ this.f14036e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Exception{type=");
        sb2.append(this.f14032a);
        sb2.append(", reason=");
        sb2.append(this.f14033b);
        sb2.append(", frames=");
        sb2.append(this.f14034c);
        sb2.append(", causedBy=");
        sb2.append(this.f14035d);
        sb2.append(", overflowCount=");
        return x.c.a(sb2, this.f14036e, "}");
    }
}
