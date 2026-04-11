package cc;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f2597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f2598e;

    public a(String str, String str2, String str3, s sVar, ArrayList arrayList) {
        String str4 = Build.MANUFACTURER;
        be.h.e(str2, "versionName");
        be.h.e(str3, "appBuildVersion");
        be.h.e(str4, "deviceManufacturer");
        this.f2594a = str;
        this.f2595b = str2;
        this.f2596c = str3;
        this.f2597d = sVar;
        this.f2598e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f2594a.equals(aVar.f2594a) || !be.h.a(this.f2595b, aVar.f2595b) || !be.h.a(this.f2596c, aVar.f2596c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return be.h.a(str, str) && this.f2597d.equals(aVar.f2597d) && this.f2598e.equals(aVar.f2598e);
    }

    public final int hashCode() {
        return this.f2598e.hashCode() + ((this.f2597d.hashCode() + e6.j.h(e6.j.h(e6.j.h(this.f2594a.hashCode() * 31, 31, this.f2595b), 31, this.f2596c), 31, Build.MANUFACTURER)) * 31);
    }

    public final String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f2594a + ", versionName=" + this.f2595b + ", appBuildVersion=" + this.f2596c + ", deviceManufacturer=" + Build.MANUFACTURER + ", currentProcessDetails=" + this.f2597d + ", appProcessDetails=" + this.f2598e + ')';
    }
}
