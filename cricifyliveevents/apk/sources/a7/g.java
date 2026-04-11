package a7;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f317a = new c0(3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f318b = new f(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f319c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f320d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f321e;
    public int f;

    public g(int i) {
        this.f321e = i;
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
            Object objV = this.f317a.V();
            s7.f.b(objV);
            c cVarE = e(objV.getClass());
            this.f -= cVarE.b() * cVarE.a(objV);
            b(cVarE.a(objV), objV.getClass());
            if (Log.isLoggable(cVarE.c(), 2)) {
                Log.v(cVarE.c(), "evicted: " + cVarE.a(objV));
            }
        }
    }

    public final synchronized Object d(int i, Class cls) {
        e eVar;
        int i10;
        try {
            Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i10 = this.f) != 0 && this.f321e / i10 < 2 && num.intValue() > i * 8)) {
                f fVar = this.f318b;
                j jVarN1 = (j) ((ArrayDeque) fVar.f307w).poll();
                if (jVarN1 == null) {
                    jVarN1 = fVar.n1();
                }
                eVar = (e) jVarN1;
                eVar.f314b = i;
                eVar.f315c = cls;
            } else {
                f fVar2 = this.f318b;
                int iIntValue = num.intValue();
                j jVarN12 = (j) ((ArrayDeque) fVar2.f307w).poll();
                if (jVarN12 == null) {
                    jVarN12 = fVar2.n1();
                }
                eVar = (e) jVarN12;
                eVar.f314b = iIntValue;
                eVar.f315c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f(eVar, cls);
    }

    public final c e(Class cls) {
        c cVar;
        HashMap map = this.f320d;
        c cVar2 = (c) map.get(cls);
        if (cVar2 != null) {
            return cVar2;
        }
        if (cls.equals(int[].class)) {
            cVar = new c(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            cVar = new c(0);
        }
        map.put(cls, cVar);
        return cVar;
    }

    public final Object f(e eVar, Class cls) {
        c cVarE = e(cls);
        Object objL = this.f317a.L(eVar);
        if (objL != null) {
            this.f -= cVarE.b() * cVarE.a(objL);
            b(cVarE.a(objL), cls);
        }
        if (objL != null) {
            return objL;
        }
        if (Log.isLoggable(cVarE.c(), 2)) {
            Log.v(cVarE.c(), "Allocated " + eVar.f314b + " bytes");
        }
        int i = eVar.f314b;
        switch (cVarE.f308a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new byte[i];
            default:
                return new int[i];
        }
    }

    public final NavigableMap g(Class cls) {
        HashMap map = this.f319c;
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
        c cVarE = e(cls);
        int iA = cVarE.a(obj);
        int iB = cVarE.b() * iA;
        if (iB <= this.f321e / 2) {
            f fVar = this.f318b;
            j jVarN1 = (j) ((ArrayDeque) fVar.f307w).poll();
            if (jVarN1 == null) {
                jVarN1 = fVar.n1();
            }
            e eVar = (e) jVarN1;
            eVar.f314b = iA;
            eVar.f315c = cls;
            this.f317a.S(eVar, obj);
            NavigableMap navigableMapG = g(cls);
            Integer num = (Integer) navigableMapG.get(Integer.valueOf(eVar.f314b));
            Integer numValueOf = Integer.valueOf(eVar.f314b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapG.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            c(this.f321e);
        }
    }

    public final synchronized void i(int i) {
        try {
            if (i >= 40) {
                a();
            } else if (i >= 20 || i == 15) {
                c(this.f321e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
