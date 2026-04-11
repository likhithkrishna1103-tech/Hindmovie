package h5;

import a9.l;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f5840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f5841e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5844c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f5843b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5842a = new HashMap();

    public a(Context context) {
        this.f5844c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f5840d == null) {
            synchronized (f5841e) {
                try {
                    if (f5840d == null) {
                        f5840d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f5840d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f5844c.getString(c.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f5843b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e9) {
                throw new l(e9);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = this.f5842a;
        if (com.bumptech.glide.c.y()) {
            try {
                com.bumptech.glide.c.b(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = bVar.b(this.f5844c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new l(th2);
            }
        }
        Trace.endSection();
        return objB;
    }
}
