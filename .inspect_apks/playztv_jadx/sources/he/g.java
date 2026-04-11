package he;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import od.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends h {
    public static String R(e eVar, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i = 0;
        for (Object obj : eVar) {
            i++;
            if (i > 1) {
                sb2.append((CharSequence) str);
            }
            cf.l.b(sb2, obj, null);
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public static List S(e eVar) {
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return q.f9570u;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return android.support.v4.media.session.b.G(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
