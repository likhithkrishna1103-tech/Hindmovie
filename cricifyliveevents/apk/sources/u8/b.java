package u8;

import android.content.Context;
import b7.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12289b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f12290a;

    static {
        b bVar = new b();
        bVar.f12290a = null;
        f12289b = bVar;
    }

    public static e a(Context context) {
        e eVar;
        b bVar = f12289b;
        synchronized (bVar) {
            try {
                if (bVar.f12290a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    bVar.f12290a = new e(context);
                }
                eVar = bVar.f12290a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }
}
