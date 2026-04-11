package v1;

import android.net.Uri;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12662h;
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12665l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12666m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12667n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12672e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12673g;

    static {
        int i10 = y1.a0.f14551a;
        f12662h = Integer.toString(0, 36);
        i = Integer.toString(1, 36);
        f12663j = Integer.toString(2, 36);
        f12664k = Integer.toString(3, 36);
        f12665l = Integer.toString(4, 36);
        f12666m = Integer.toString(5, 36);
        f12667n = Integer.toString(6, 36);
    }

    public f0(hb.a aVar) {
        this.f12668a = (Uri) aVar.f5873d;
        this.f12669b = aVar.f5870a;
        this.f12670c = (String) aVar.f5874e;
        this.f12671d = aVar.f5871b;
        this.f12672e = aVar.f5872c;
        this.f = (String) aVar.f;
        this.f12673g = (String) aVar.f5875g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f12668a.equals(f0Var.f12668a) && Objects.equals(this.f12669b, f0Var.f12669b) && Objects.equals(this.f12670c, f0Var.f12670c) && this.f12671d == f0Var.f12671d && this.f12672e == f0Var.f12672e && Objects.equals(this.f, f0Var.f) && Objects.equals(this.f12673g, f0Var.f12673g);
    }

    public final int hashCode() {
        int iHashCode = this.f12668a.hashCode() * 31;
        String str = this.f12669b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f12670c;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f12671d) * 31) + this.f12672e) * 31;
        String str3 = this.f;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f12673g;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }
}
