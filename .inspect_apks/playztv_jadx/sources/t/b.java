package t;

import java.util.LinkedHashMap;
import w2.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f11962a;

    public b(int i) {
        switch (i) {
            case 1:
                this.f11962a = new LinkedHashMap();
                break;
            default:
                this.f11962a = new LinkedHashMap(0, 0.75f, true);
                break;
        }
    }

    public void a(k kVar) {
        long[] jArr = kVar.f13649e;
        if (jArr.length > 0) {
            Long lValueOf = Long.valueOf(jArr[0]);
            LinkedHashMap linkedHashMap = this.f11962a;
            if (linkedHashMap.containsKey(lValueOf)) {
                return;
            }
            linkedHashMap.put(Long.valueOf(kVar.f13649e[0]), kVar);
        }
    }
}
