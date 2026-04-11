package f6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import h4.z;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f4767a = new z(14);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4768b = new e(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f4769c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f4770d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4771e;
    public int f;

    public f(int i) {
        this.f4771e = i;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(int i, Class cls) {
        NavigableMap navigableMapG = g(cls);
        Integer num = (Integer) navigableMapG.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapG.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapG.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final void c(int i) {
        while (this.f > i) {
            Object objI0 = this.f4767a.i0();
            x6.f.b(objI0);
            b bVarE = e(objI0.getClass());
            this.f -= bVarE.b() * bVarE.a(objI0);
            b(bVarE.a(objI0), objI0.getClass());
            if (Log.isLoggable(bVarE.c(), 2)) {
                Log.v(bVarE.c(), "evicted: " + bVarE.a(objI0));
            }
        }
    }

    public final synchronized Object d(int i, Class cls) {
        d dVar;
        int i10;
        try {
            Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i10 = this.f) != 0 && this.f4771e / i10 < 2 && num.intValue() > i * 8)) {
                e eVar = this.f4768b;
                h hVarQ1 = (h) ((ArrayDeque) eVar.f2454v).poll();
                if (hVarQ1 == null) {
                    hVarQ1 = eVar.q1();
                }
                dVar = (d) hVarQ1;
                dVar.f4764b = i;
                dVar.f4765c = cls;
            } else {
                e eVar2 = this.f4768b;
                int iIntValue = num.intValue();
                h hVarQ12 = (h) ((ArrayDeque) eVar2.f2454v).poll();
                if (hVarQ12 == null) {
                    hVarQ12 = eVar2.q1();
                }
                dVar = (d) hVarQ12;
                dVar.f4764b = iIntValue;
                dVar.f4765c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f(dVar, cls);
    }

    public final b e(Class cls) {
        b bVar;
        HashMap map = this.f4770d;
        b bVar2 = (b) map.get(cls);
        if (bVar2 != null) {
            return bVar2;
        }
        if (cls.equals(int[].class)) {
            bVar = new b(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            bVar = new b(0);
        }
        map.put(cls, bVar);
        return bVar;
    }

    public final Object f(d dVar, Class cls) {
        b bVarE = e(cls);
        Object objB0 = this.f4767a.b0(dVar);
        if (objB0 != null) {
            this.f -= bVarE.b() * bVarE.a(objB0);
            b(bVarE.a(objB0), cls);
        }
        if (objB0 != null) {
            return objB0;
        }
        if (Log.isLoggable(bVarE.c(), 2)) {
            Log.v(bVarE.c(), "Allocated " + dVar.f4764b + " bytes");
        }
        int i = dVar.f4764b;
        switch (bVarE.f4758a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new byte[i];
            default:
                return new int[i];
        }
    }

    public final NavigableMap g(Class cls) {
        HashMap map = this.f4769c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void h(Object obj) {
        Class<?> cls = obj.getClass();
        b bVarE = e(cls);
        int iA = bVarE.a(obj);
        int iB = bVarE.b() * iA;
        if (iB <= this.f4771e / 2) {
            e eVar = this.f4768b;
            h hVarQ1 = (h) ((ArrayDeque) eVar.f2454v).poll();
            if (hVarQ1 == null) {
                hVarQ1 = eVar.q1();
            }
            d dVar = (d) hVarQ1;
            dVar.f4764b = iA;
            dVar.f4765c = cls;
            this.f4767a.g0(dVar, obj);
            NavigableMap navigableMapG = g(cls);
            Integer num = (Integer) navigableMapG.get(Integer.valueOf(dVar.f4764b));
            Integer numValueOf = Integer.valueOf(dVar.f4764b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapG.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            c(this.f4771e);
        }
    }

    public final synchronized void i(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.f4771e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
