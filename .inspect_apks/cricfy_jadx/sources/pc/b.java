package pc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f10178b;

    public b(Set set, c cVar) {
        this.f10177a = b(set);
        this.f10178b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb.append(aVar.f10175a);
            sb.append('/');
            sb.append(aVar.f10176b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        String str = this.f10177a;
        c cVar = this.f10178b;
        synchronized (((HashSet) cVar.f10180v)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) cVar.f10180v);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return str;
        }
        return str + ' ' + b(cVar.H());
    }
}
