package p;

import com.bumptech.glide.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f9863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9864c = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9865a = new c();

    public static b M() {
        if (f9863b != null) {
            return f9863b;
        }
        synchronized (b.class) {
            try {
                if (f9863b == null) {
                    f9863b = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9863b;
    }
}
