package c5;

import a2.y0;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.bumptech.glide.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f2505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2506e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2509c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f2508b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2507a = new HashMap();

    public a(Context context) {
        this.f2509c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f2505d == null) {
            synchronized (f2506e) {
                try {
                    if (f2505d == null) {
                        f2505d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f2505d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f2509c.getString(c.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f2508b;
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
            } catch (ClassNotFoundException e10) {
                throw new y0(e10);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        HashMap map = this.f2507a;
        if (d.w()) {
            try {
                d.e(cls.getSimpleName());
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
                objB = bVar.b(this.f2509c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new y0(th2);
            }
        }
        Trace.endSection();
        return objB;
    }
}
