package k8;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends q4.e1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d1 f7148h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(d1 d1Var) {
        super(20);
        this.f7148h = d1Var;
    }

    @Override // q4.e1
    public final Object c(Object obj) {
        com.google.android.gms.internal.measurement.n2 n2Var;
        String str = (String) obj;
        t7.v.d(str);
        d1 d1Var = this.f7148h;
        d1Var.t1();
        t7.v.d(str);
        if (TextUtils.isEmpty(str) || (n2Var = (com.google.android.gms.internal.measurement.n2) d1Var.C.get(str)) == null || n2Var.n() == 0) {
            return null;
        }
        if (!d1Var.C.containsKey(str) || d1Var.C.get(str) == null) {
            d1Var.N1(str);
        } else {
            d1Var.C1(str, (com.google.android.gms.internal.measurement.n2) d1Var.C.get(str));
        }
        e1 e1Var = d1Var.E;
        e1Var.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (((b0) e1Var.f10786g)) {
            Set<Map.Entry> setEntrySet = ((t.b) e1Var.f).f11962a.entrySet();
            be.h.d(setEntrySet, "map.entries");
            for (Map.Entry entry : setEntrySet) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (com.google.android.gms.internal.measurement.v) linkedHashMap.get(str);
    }
}
