package yc;

import android.net.Uri;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vc.b f15031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vd.h f15032b;

    public d(vc.b bVar, vd.h hVar) {
        ge.i.e(bVar, "appInfo");
        ge.i.e(hVar, "blockingDispatcher");
        this.f15031a = bVar;
        this.f15032b = hVar;
    }

    public static final URL a(d dVar) {
        dVar.getClass();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority("firebase-settings.crashlytics.com").appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp");
        vc.b bVar = dVar.f15031a;
        Uri.Builder builderAppendPath2 = builderAppendPath.appendPath(bVar.f13576a).appendPath("settings");
        vc.a aVar = bVar.f13577b;
        return new URL(builderAppendPath2.appendQueryParameter("build_version", aVar.f13562c).appendQueryParameter("display_version", aVar.f13561b).build().toString());
    }
}
