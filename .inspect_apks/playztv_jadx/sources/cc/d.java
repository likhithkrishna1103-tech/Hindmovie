package cc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements gb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2614a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gb.c f2615b = gb.c.a("appId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gb.c f2616c = gb.c.a("deviceModel");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gb.c f2617d = gb.c.a("sessionSdkVersion");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gb.c f2618e = gb.c.a("osVersion");
    public static final gb.c f = gb.c.a("logEnvironment");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gb.c f2619g = gb.c.a("androidAppInfo");

    @Override // gb.a
    public final void a(Object obj, Object obj2) {
        b bVar = (b) obj;
        gb.e eVar = (gb.e) obj2;
        eVar.g(f2615b, bVar.f2601a);
        eVar.g(f2616c, Build.MODEL);
        eVar.g(f2617d, "2.0.5");
        eVar.g(f2618e, Build.VERSION.RELEASE);
        eVar.g(f, r.f2703v);
        eVar.g(f2619g, bVar.f2602b);
    }
}
