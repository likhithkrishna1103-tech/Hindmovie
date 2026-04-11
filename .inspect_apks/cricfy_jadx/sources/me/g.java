package me;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sd.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends com.bumptech.glide.d {
    public static String H(e eVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (Object obj : eVar) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) str);
            }
            u8.a.a(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static List I(e eVar) {
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return p.f11669v;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return n5.a.x(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
