package ld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashMap f8123u = new HashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f8124v = new ArrayList();

    public b(HashMap map) {
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.trim().split("=");
                if (strArrSplit.length == 2) {
                    this.f8123u.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    public final void b() {
        Iterator it = this.f8124v.iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f8123u.keySet().iterator();
    }
}
