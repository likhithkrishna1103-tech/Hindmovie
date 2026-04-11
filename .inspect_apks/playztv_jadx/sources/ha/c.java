package ha;

import aa.o0;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.i1;
import java.util.ArrayList;
import k8.c2;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nb.b f6025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f6026b = null;

    public c(nb.b bVar) {
        this.f6025a = bVar;
    }

    public static boolean a(ArrayList arrayList, b bVar) {
        String str = bVar.f6020a;
        String str2 = bVar.f6021b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b bVar2 = (b) obj;
            if (bVar2.f6020a.equals(str) && bVar2.f6021b.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList b() {
        ka.c cVar = (ka.c) ((ka.b) this.f6025a.get());
        cVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : ((i1) cVar.f7608a.f11562v).c("frc", "")) {
            o0 o0Var = la.a.f8063a;
            v.h(bundle);
            ka.a aVar = new ka.a();
            String str = (String) c2.a(bundle, "origin", String.class, null);
            v.h(str);
            aVar.f7594a = str;
            String str2 = (String) c2.a(bundle, "name", String.class, null);
            v.h(str2);
            aVar.f7595b = str2;
            aVar.f7596c = c2.a(bundle, "value", Object.class, null);
            aVar.f7597d = (String) c2.a(bundle, "trigger_event_name", String.class, null);
            aVar.f7598e = ((Long) c2.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            aVar.f = (String) c2.a(bundle, "timed_out_event_name", String.class, null);
            aVar.f7599g = (Bundle) c2.a(bundle, "timed_out_event_params", Bundle.class, null);
            aVar.f7600h = (String) c2.a(bundle, "triggered_event_name", String.class, null);
            aVar.i = (Bundle) c2.a(bundle, "triggered_event_params", Bundle.class, null);
            aVar.f7601j = ((Long) c2.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            aVar.f7602k = (String) c2.a(bundle, "expired_event_name", String.class, null);
            aVar.f7603l = (Bundle) c2.a(bundle, "expired_event_params", Bundle.class, null);
            aVar.f7605n = ((Boolean) c2.a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            aVar.f7604m = ((Long) c2.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            aVar.f7606o = ((Long) c2.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x028e  */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r24v1, types: [android.os.Bundle, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.ArrayList r24) throws ha.a {
        /*
            Method dump skipped, instruction units count: 907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ha.c.c(java.util.ArrayList):void");
    }
}
