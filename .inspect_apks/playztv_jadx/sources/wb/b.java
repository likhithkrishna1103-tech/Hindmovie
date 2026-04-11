package wb;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14085b;

    public b(Set set, c cVar) {
        this.f14084a = b(set);
        this.f14085b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb2.append(aVar.f14082a);
            sb2.append('/');
            sb2.append(aVar.f14083b);
            if (it.hasNext()) {
                sb2.append(' ');
            }
        }
        return sb2.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        String str = this.f14084a;
        c cVar = this.f14085b;
        synchronized (((HashSet) cVar.f14088v)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) cVar.f14088v);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return str;
        }
        return str + ' ' + b(cVar.f());
    }
}
