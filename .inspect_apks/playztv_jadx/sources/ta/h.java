package ta;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f12365d = new g(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c4.d f12366e = new c4.d(19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final za.c f12367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12368b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12369c = null;

    public h(za.c cVar) {
        this.f12367a = cVar;
    }

    public static void a(za.c cVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            cVar.b(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e10) {
            Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", e10);
        }
    }
}
