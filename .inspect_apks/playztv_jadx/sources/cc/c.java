package cc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2606a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2607b = gb.c.a("packageName");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2608c = gb.c.a("versionName");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2609d = gb.c.a("appBuildVersion");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f2610e = gb.c.a("deviceManufacturer");
    public static final gb.c f = gb.c.a("currentProcessDetails");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f2611g = gb.c.a("appProcessDetails");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        a aVar = (a) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.g(f2607b, aVar.f2594a);
        eVar.g(f2608c, aVar.f2595b);
        eVar.g(f2609d, aVar.f2596c);
        eVar.g(f2610e, Build.MANUFACTURER);
        eVar.g(f, aVar.f2597d);
        eVar.g(f2611g, aVar.f2598e);
    }
}
