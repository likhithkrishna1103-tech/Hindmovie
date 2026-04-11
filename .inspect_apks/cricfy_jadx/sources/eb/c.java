package eb;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.x0;
import i2.k;
import java.util.concurrent.ConcurrentHashMap;
import l4.c0;
import o8.j;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f3882c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.d f3883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3884b;

    public c(p6.d dVar) {
        u.g(dVar);
        this.f3883a = dVar;
        this.f3884b = new ConcurrentHashMap();
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (fb.a.a(str) && fb.a.b(str2, bundle) && fb.a.d(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            k1 k1Var = (k1) this.f3883a.f10037w;
            k1Var.c(new x0(k1Var, str, str2, bundle, 1));
        }
    }

    public final j b(String str, k kVar) {
        if (fb.a.a(str)) {
            boolean zIsEmpty = str.isEmpty();
            ConcurrentHashMap concurrentHashMap = this.f3884b;
            if (zIsEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) {
                boolean zEquals = "fiam".equals(str);
                p6.d dVar = this.f3883a;
                qd.a c0Var = zEquals ? new c0(dVar, kVar) : "clx".equals(str) ? new p6.c(dVar, kVar) : null;
                if (c0Var != null) {
                    concurrentHashMap.put(str, c0Var);
                    return new j(10);
                }
            }
        }
        return null;
    }
}
