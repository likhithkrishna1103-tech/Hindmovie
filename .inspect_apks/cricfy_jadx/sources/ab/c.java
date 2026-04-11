package ab;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f383c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f381a = i;
        this.f383c = obj;
        this.f382b = obj2;
    }

    @Override // hc.b
    public final Object get() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        switch (this.f381a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f383c;
                Context contextA = (Context) this.f382b;
                String strD = gVar.d();
                mc.a aVar = new mc.a();
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    contextA = i >= 24 ? i0.a.a(contextA) : null;
                }
                SharedPreferences sharedPreferences = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + strD, 0);
                boolean z10 = true;
                if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
                    z10 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
                } else {
                    try {
                        PackageManager packageManager = contextA.getPackageManager();
                        if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextA.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                            z10 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                        }
                        break;
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                aVar.f8418a = z10;
                return aVar;
            case 1:
                return new fc.j((Context) this.f382b, (String) this.f383c);
            default:
                hb.g gVar2 = (hb.g) this.f383c;
                hb.b bVar = (hb.b) this.f382b;
                return bVar.f.e(new dd.c(bVar, gVar2));
        }
    }

    public /* synthetic */ c(Context context, String str) {
        this.f381a = 1;
        this.f382b = context;
        this.f383c = str;
    }
}
