package vc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13581a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f13582b = ac.c.a("packageName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f13583c = ac.c.a("versionName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f13584d = ac.c.a("appBuildVersion");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f13585e = ac.c.a("deviceManufacturer");
    public static final ac.c f = ac.c.a("currentProcessDetails");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f13586g = ac.c.a("appProcessDetails");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        a aVar = (a) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.g(f13582b, aVar.f13560a);
        eVar.g(f13583c, aVar.f13561b);
        eVar.g(f13584d, aVar.f13562c);
        eVar.g(f13585e, Build.MANUFACTURER);
        eVar.g(f, aVar.f13563d);
        eVar.g(f13586g, aVar.f13564e);
    }
}
