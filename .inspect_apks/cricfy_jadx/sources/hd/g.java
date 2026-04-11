package hd;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5939a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f5940b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f5941c = new Handler(Looper.getMainLooper());

    public static void a() {
        synchronized (f5939a) {
            LinkedHashMap linkedHashMap = f5940b;
            f fVar = (f) linkedHashMap.get("LibGlobalFetchLib");
            if (fVar != null) {
                fVar.f5932a.b();
                if (fVar.f5932a.e() == 0) {
                    fVar.f5932a.a();
                    fVar.f5937g.b();
                    fVar.f5935d.m();
                    fVar.f5933b.close();
                    fVar.f.s();
                    fVar.f5938h.c();
                    linkedHashMap.remove("LibGlobalFetchLib");
                }
            }
        }
    }
}
