package p1;

import android.net.Uri;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f9694d = new d0(new kc.b(9));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9695e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9696g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f9697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f9699c;

    static {
        int i = s1.b0.f11647a;
        f9695e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f9696g = Integer.toString(2, 36);
    }

    public d0(kc.b bVar) {
        this.f9697a = (Uri) bVar.f7620v;
        this.f9698b = (String) bVar.f7621w;
        this.f9699c = (Bundle) bVar.f7622x;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (Objects.equals(this.f9697a, d0Var.f9697a) && Objects.equals(this.f9698b, d0Var.f9698b)) {
            if ((this.f9699c == null) == (d0Var.f9699c == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Uri uri = this.f9697a;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.f9698b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f9699c != null ? 1 : 0);
    }
}
