package vc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f13577b;

    public b(String str, a aVar) {
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        ge.i.e(str, "appId");
        ge.i.e(str2, "deviceModel");
        ge.i.e(str3, "osVersion");
        this.f13576a = str;
        this.f13577b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!ge.i.a(this.f13576a, bVar.f13576a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!ge.i.a(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        return ge.i.a(str2, str2) && this.f13577b.equals(bVar.f13577b);
    }

    public final int hashCode() {
        return this.f13577b.hashCode() + ((x.f13708w.hashCode() + l0.e.e((((Build.MODEL.hashCode() + (this.f13576a.hashCode() * 31)) * 31) + 48517563) * 31, 31, Build.VERSION.RELEASE)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f13576a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=3.0.4, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + x.f13708w + ", androidAppInfo=" + this.f13577b + ')';
    }
}
