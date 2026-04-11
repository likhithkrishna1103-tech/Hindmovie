package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1143a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1144b;

    public b(HashMap map) {
        this.f1144b = map;
        for (Map.Entry entry : map.entrySet()) {
            m mVar = (m) entry.getValue();
            List arrayList = (List) this.f1143a.get(mVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f1143a.put(mVar, arrayList);
            }
            arrayList.add((c) entry.getKey());
        }
    }

    public static void a(List list, s sVar, m mVar, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                Method method = cVar.f1146b;
                try {
                    int i = cVar.f1145a;
                    if (i == 0) {
                        method.invoke(obj, null);
                    } else if (i == 1) {
                        method.invoke(obj, sVar);
                    } else if (i == 2) {
                        method.invoke(obj, sVar, mVar);
                    }
                } catch (IllegalAccessException e9) {
                    throw new RuntimeException(e9);
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException("Failed to call observer method", e10.getCause());
                }
            }
        }
    }
}
