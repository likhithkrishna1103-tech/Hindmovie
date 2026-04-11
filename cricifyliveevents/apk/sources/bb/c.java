package bb;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.k1;
import f9.h2;
import java.util.ArrayList;
import o8.u;
import ua.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hc.b f1905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f1906b = null;

    public c(hc.b bVar) {
        this.f1905a = bVar;
    }

    public static boolean a(ArrayList arrayList, b bVar) {
        String str = bVar.f1900a;
        String str2 = bVar.f1901b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b bVar2 = (b) obj;
            if (bVar2.f1900a.equals(str) && bVar2.f1901b.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList b() {
        eb.c cVar = (eb.c) ((eb.b) this.f1905a.get());
        cVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : ((k1) cVar.f3883a.f10037w).f("frc", "")) {
            m0 m0Var = fb.a.f4528a;
            u.g(bundle);
            eb.a aVar = new eb.a();
            String str = (String) h2.e(bundle, "origin", String.class, null);
            u.g(str);
            aVar.f3869a = str;
            String str2 = (String) h2.e(bundle, "name", String.class, null);
            u.g(str2);
            aVar.f3870b = str2;
            aVar.f3871c = h2.e(bundle, "value", Object.class, null);
            aVar.f3872d = (String) h2.e(bundle, "trigger_event_name", String.class, null);
            aVar.f3873e = ((Long) h2.e(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            aVar.f = (String) h2.e(bundle, "timed_out_event_name", String.class, null);
            aVar.f3874g = (Bundle) h2.e(bundle, "timed_out_event_params", Bundle.class, null);
            aVar.f3875h = (String) h2.e(bundle, "triggered_event_name", String.class, null);
            aVar.i = (Bundle) h2.e(bundle, "triggered_event_params", Bundle.class, null);
            aVar.f3876j = ((Long) h2.e(bundle, "time_to_live", Long.class, 0L)).longValue();
            aVar.f3877k = (String) h2.e(bundle, "expired_event_name", String.class, null);
            aVar.f3878l = (Bundle) h2.e(bundle, "expired_event_params", Bundle.class, null);
            aVar.f3880n = ((Boolean) h2.e(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            aVar.f3879m = ((Long) h2.e(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            aVar.f3881o = ((Long) h2.e(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0288  */
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
    /* JADX WARN: Type inference failed for: r22v0, types: [android.os.Bundle, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.ArrayList r24) throws bb.a {
        /*
            Method dump skipped, instruction units count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.c.c(java.util.ArrayList):void");
    }
}
