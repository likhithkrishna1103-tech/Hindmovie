package dd;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4165a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f4166b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f4167c = new Handler(Looper.getMainLooper());

    public static void a() {
        synchronized (f4165a) {
            LinkedHashMap linkedHashMap = f4166b;
            i iVar = (i) linkedHashMap.get("LibGlobalFetchLib");
            if (iVar != null) {
                iVar.f4158a.b();
                if (iVar.f4158a.e() == 0) {
                    iVar.f4158a.a();
                    iVar.f4163g.b();
                    iVar.f4161d.o();
                    iVar.f4159b.close();
                    iVar.f.G();
                    iVar.f4164h.c();
                    linkedHashMap.remove("LibGlobalFetchLib");
                }
            }
        }
    }
}
