package vc;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f13563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f13564e;

    public a(String str, String str2, String str3, d0 d0Var, ArrayList arrayList) {
        String str4 = Build.MANUFACTURER;
        ge.i.e(str2, "versionName");
        ge.i.e(str3, "appBuildVersion");
        ge.i.e(str4, "deviceManufacturer");
        this.f13560a = str;
        this.f13561b = str2;
        this.f13562c = str3;
        this.f13563d = d0Var;
        this.f13564e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f13560a.equals(aVar.f13560a) || !ge.i.a(this.f13561b, aVar.f13561b) || !ge.i.a(this.f13562c, aVar.f13562c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return ge.i.a(str, str) && this.f13563d.equals(aVar.f13563d) && this.f13564e.equals(aVar.f13564e);
    }

    public final int hashCode() {
        return this.f13564e.hashCode() + ((this.f13563d.hashCode() + l0.e.e(l0.e.e(l0.e.e(this.f13560a.hashCode() * 31, 31, this.f13561b), 31, this.f13562c), 31, Build.MANUFACTURER)) * 31);
    }

    public final String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f13560a + ", versionName=" + this.f13561b + ", appBuildVersion=" + this.f13562c + ", deviceManufacturer=" + Build.MANUFACTURER + ", currentProcessDetails=" + this.f13563d + ", appProcessDetails=" + this.f13564e + ')';
    }
}
