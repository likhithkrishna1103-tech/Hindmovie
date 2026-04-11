package nb;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f8939d = new g(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g4.d f8940e = new g4.d(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tb.c f8941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8942b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8943c = null;

    public h(tb.c cVar) {
        this.f8941a = cVar;
    }

    public static void a(tb.c cVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            cVar.b(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e9) {
            Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", e9);
        }
    }
}
