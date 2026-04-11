package p1;

import android.net.Uri;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9729h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9734n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f9735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9739e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9740g;

    static {
        int i10 = s1.b0.f11647a;
        f9729h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f9730j = Integer.toString(2, 36);
        f9731k = Integer.toString(3, 36);
        f9732l = Integer.toString(4, 36);
        f9733m = Integer.toString(5, 36);
        f9734n = Integer.toString(6, 36);
    }

    public f0(na.a aVar) {
        this.f9735a = (Uri) aVar.f8876d;
        this.f9736b = aVar.f8873a;
        this.f9737c = (String) aVar.f8877e;
        this.f9738d = aVar.f8874b;
        this.f9739e = aVar.f8875c;
        this.f = (String) aVar.f;
        this.f9740g = (String) aVar.f8878g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f9735a.equals(f0Var.f9735a) && Objects.equals(this.f9736b, f0Var.f9736b) && Objects.equals(this.f9737c, f0Var.f9737c) && this.f9738d == f0Var.f9738d && this.f9739e == f0Var.f9739e && Objects.equals(this.f, f0Var.f) && Objects.equals(this.f9740g, f0Var.f9740g);
    }

    public final int hashCode() {
        int iHashCode = this.f9735a.hashCode() * 31;
        String str = this.f9736b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9737c;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f9738d) * 31) + this.f9739e) * 31;
        String str3 = this.f;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f9740g;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }
}
