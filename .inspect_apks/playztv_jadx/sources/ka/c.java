package ka;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.m1;
import h4.z;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import k8.b0;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f7607c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rc.b f7608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7609b;

    public c(rc.b bVar) {
        v.h(bVar);
        this.f7608a = bVar;
        this.f7609b = new ConcurrentHashMap();
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (la.a.d(str) && la.a.a(str2, bundle) && la.a.c(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            i1 i1Var = (i1) this.f7608a.f11562v;
            i1Var.e(new m1(i1Var, str, str2, bundle, 1));
        }
    }

    public final b0 b(String str, p2.c cVar) {
        Object obj;
        if (la.a.d(str)) {
            boolean zIsEmpty = str.isEmpty();
            ConcurrentHashMap concurrentHashMap = this.f7609b;
            if (zIsEmpty || !concurrentHashMap.containsKey(str) || concurrentHashMap.get(str) == null) {
                boolean zEquals = "fiam".equals(str);
                rc.b bVar = this.f7608a;
                if (zEquals) {
                    z zVar = new z(27, false);
                    zVar.f5868w = cVar;
                    bVar.J(new la.b(0, zVar));
                    zVar.f5867v = new HashSet();
                    obj = zVar;
                } else if ("clx".equals(str)) {
                    u5.c cVar2 = new u5.c(28, false);
                    cVar2.f12782v = cVar;
                    bVar.J(new la.b(1, cVar2));
                    obj = cVar2;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    concurrentHashMap.put(str, obj);
                    return new b0(15);
                }
            }
        }
        return null;
    }
}
