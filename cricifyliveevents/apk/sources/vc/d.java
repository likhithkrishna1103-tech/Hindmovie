package vc;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ac.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13592a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.c f13593b = ac.c.a("appId");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.c f13594c = ac.c.a("deviceModel");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.c f13595d = ac.c.a("sessionSdkVersion");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.c f13596e = ac.c.a("osVersion");
    public static final ac.c f = ac.c.a("logEnvironment");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ac.c f13597g = ac.c.a("androidAppInfo");

    @Override // ac.a
    public final void a(Object obj, Object obj2) {
        b bVar = (b) obj;
        ac.e eVar = (ac.e) obj2;
        eVar.g(f13593b, bVar.f13576a);
        eVar.g(f13594c, Build.MODEL);
        eVar.g(f13595d, "3.0.4");
        eVar.g(f13596e, Build.VERSION.RELEASE);
        eVar.g(f, x.f13708w);
        eVar.g(f13597g, bVar.f13577b);
    }
}
