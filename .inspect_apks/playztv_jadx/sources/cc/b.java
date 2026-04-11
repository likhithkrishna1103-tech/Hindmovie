package cc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2602b;

    public b(String str, a aVar) {
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        be.h.e(str, "appId");
        be.h.e(str2, "deviceModel");
        be.h.e(str3, "osVersion");
        this.f2601a = str;
        this.f2602b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!be.h.a(this.f2601a, bVar.f2601a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!be.h.a(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        return be.h.a(str2, str2) && this.f2602b.equals(bVar.f2602b);
    }

    public final int hashCode() {
        return this.f2602b.hashCode() + ((r.f2703v.hashCode() + e6.j.h((((Build.MODEL.hashCode() + (this.f2601a.hashCode() * 31)) * 31) + 47594043) * 31, 31, Build.VERSION.RELEASE)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f2601a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=2.0.5, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + r.f2703v + ", androidAppInfo=" + this.f2602b + ')';
    }
}
