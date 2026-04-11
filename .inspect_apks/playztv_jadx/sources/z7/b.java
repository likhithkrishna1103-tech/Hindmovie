package z7;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f14897b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wc.b f14898a;

    static {
        b bVar = new b();
        bVar.f14898a = null;
        f14897b = bVar;
    }

    public static wc.b a(Context context) {
        wc.b bVar;
        b bVar2 = f14897b;
        synchronized (bVar2) {
            try {
                if (bVar2.f14898a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    bVar2.f14898a = new wc.b(context);
                }
                bVar = bVar2.f14898a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
