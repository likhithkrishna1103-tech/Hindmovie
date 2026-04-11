package vc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f13665a = new m0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.c f13666b;

    static {
        cc.d dVar = new cc.d();
        dVar.a(l0.class, g.f13617a);
        dVar.a(t0.class, h.f13625a);
        dVar.a(k.class, e.f13605a);
        dVar.a(b.class, d.f13592a);
        dVar.a(a.class, c.f13581a);
        dVar.a(d0.class, f.f13611a);
        dVar.f2136d = true;
        f13666b = new p6.c(6, dVar);
    }

    public static b a(ab.g gVar) throws PackageManager.NameNotFoundException {
        gVar.a();
        Context context = gVar.f390a;
        ge.i.d(context, "getApplicationContext(...)");
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        gVar.a();
        String str = gVar.f392c.f404b;
        ge.i.d(str, "getApplicationId(...)");
        ge.i.d(Build.MODEL, "MODEL");
        ge.i.d(Build.VERSION.RELEASE, "RELEASE");
        ge.i.b(packageName);
        String str2 = packageInfo.versionName;
        String str3 = str2 == null ? strValueOf : str2;
        ge.i.d(Build.MANUFACTURER, "MANUFACTURER");
        gVar.a();
        d0 d0VarB = t.b(context);
        gVar.a();
        return new b(str, new a(packageName, str3, strValueOf, d0VarB, t.a(context)));
    }
}
