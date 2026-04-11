package cf;

import aa.c0;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import cc.p;
import g5.a0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import na.r;
import o8.o;
import od.t;
import q4.h0;
import q4.t0;
import r4.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2735a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f2736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2737c;

    public static final Object a(o oVar, p pVar) throws Exception {
        if (!oVar.i()) {
            ke.g gVar = new ke.g(1, a.a.w(pVar));
            gVar.v();
            oVar.b(te.a.f12494u, new o4.c(gVar));
            return gVar.u();
        }
        Exception excG = oVar.g();
        if (excG != null) {
            throw excG;
        }
        if (!oVar.f9442d) {
            return oVar.h();
        }
        throw new CancellationException("Task " + oVar + " was cancelled normally.");
    }

    public static hf.d b() throws InterruptedException {
        hf.d dVar = hf.d.f6107l;
        be.h.b(dVar);
        hf.d dVar2 = dVar.f;
        if (dVar2 == null) {
            long jNanoTime = System.nanoTime();
            hf.d.i.await(hf.d.f6105j, TimeUnit.MILLISECONDS);
            hf.d dVar3 = hf.d.f6107l;
            be.h.b(dVar3);
            if (dVar3.f != null || System.nanoTime() - jNanoTime < hf.d.f6106k) {
                return null;
            }
            return hf.d.f6107l;
        }
        long jNanoTime2 = dVar2.f6109g - System.nanoTime();
        if (jNanoTime2 > 0) {
            hf.d.i.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        hf.d dVar4 = hf.d.f6107l;
        be.h.b(dVar4);
        dVar4.f = dVar2.f;
        dVar2.f = null;
        return dVar2;
    }

    public static pd.i c(pd.i iVar) {
        pd.f fVar = iVar.f10364u;
        fVar.b();
        fVar.G = true;
        if (fVar.C <= 0) {
            be.h.c(pd.f.H, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        return fVar.C > 0 ? iVar : pd.i.f10363v;
    }

    public static void d(String str, long j5) {
        if (j5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " (" + j5 + ") must be >= 0");
    }

    public static void e(int i) {
        if (2 > i || i >= 37) {
            throw new IllegalArgumentException("radix " + i + " was not in valid range " + new fe.c(2, 36, 1));
        }
    }

    public static int f(int i, int i10, int i11) {
        return i < i10 ? i10 : i > i11 ? i11 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(y4.c cVar, Throwable th) throws Exception {
        if (cVar != 0) {
            if (th != null) {
                try {
                    x.c.b(cVar);
                    return;
                } catch (Throwable th2) {
                    com.bumptech.glide.d.d(th, th2);
                    return;
                }
            }
            if (cVar instanceof AutoCloseable) {
                cVar.close();
                return;
            }
            if (cVar instanceof ExecutorService) {
                c0.x((ExecutorService) cVar);
                return;
            }
            if (cVar instanceof TypedArray) {
                ((TypedArray) cVar).recycle();
                return;
            }
            if (cVar instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) cVar).release();
                return;
            }
            if (cVar instanceof MediaDrm) {
                ((MediaDrm) cVar).release();
            } else if (cVar instanceof DrmManagerClient) {
                ((DrmManagerClient) cVar).release();
            } else {
                if (!(cVar instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) cVar).release();
            }
        }
    }

    public static int h(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z2) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(h0.G(view) - h0.G(view2)) + 1;
        }
        return Math.min(hVar.n(), hVar.d(view2) - hVar.g(view));
    }

    public static int i(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z2, boolean z10) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z10 ? Math.max(0, (t0Var.b() - Math.max(h0.G(view), h0.G(view2))) - 1) : Math.max(0, Math.min(h0.G(view), h0.G(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(hVar.d(view2) - hVar.g(view)) / (Math.abs(h0.G(view) - h0.G(view2)) + 1))) + (hVar.m() - hVar.g(view)));
        }
        return iMax;
    }

    public static int j(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z2) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return t0Var.b();
        }
        return (int) (((hVar.d(view2) - hVar.g(view)) / (Math.abs(h0.G(view) - h0.G(view2)) + 1)) * t0Var.b());
    }

    public static final q l(Context context, Class cls, String str) {
        be.h.e(context, "context");
        if (str == null || ie.e.U(str)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        if (be.h.a(str, ":memory:")) {
            throw new IllegalArgumentException("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new q(context, cls, str);
    }

    public static void m(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            na.b bVar = (na.b) obj;
            na.h hVar = new na.h(bVar);
            for (r rVar : bVar.f8880b) {
                boolean z2 = bVar.f8883e == 0;
                na.i iVar = new na.i(rVar, !z2);
                if (!map.containsKey(iVar)) {
                    map.put(iVar, new HashSet());
                }
                Set set = (Set) map.get(iVar);
                if (!set.isEmpty() && z2) {
                    throw new IllegalArgumentException("Multiple components provide " + rVar + ".");
                }
                set.add(hVar);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (na.h hVar2 : (Set) it.next()) {
                for (na.j jVar : hVar2.f8894a.f8881c) {
                    if (jVar.f8901c == 0) {
                        Set<na.h> set2 = (Set) map.get(new na.i(jVar.f8899a, jVar.f8900b == 2));
                        if (set2 != null) {
                            for (na.h hVar3 : set2) {
                                hVar2.f8895b.add(hVar3);
                                hVar3.f8896c.add(hVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<na.h> hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        for (na.h hVar4 : hashSet) {
            if (hVar4.f8896c.isEmpty()) {
                hashSet2.add(hVar4);
            }
        }
        while (!hashSet2.isEmpty()) {
            na.h hVar5 = (na.h) hashSet2.iterator().next();
            hashSet2.remove(hVar5);
            i++;
            for (na.h hVar6 : hVar5.f8895b) {
                hVar6.f8896c.remove(hVar5);
                if (hVar6.f8896c.isEmpty()) {
                    hashSet2.add(hVar6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (na.h hVar7 : hashSet) {
            if (!hVar7.f8896c.isEmpty() && !hVar7.f8895b.isEmpty()) {
                arrayList2.add(hVar7.f8894a);
            }
        }
        throw new na.k("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
    }

    public static final boolean n(char c9, char c10, boolean z2) {
        if (c9 == c10) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c9);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static final int o(int i, int i10, int i11) {
        if (i11 > 0) {
            if (i < i10) {
                int i12 = i10 % i11;
                if (i12 < 0) {
                    i12 += i11;
                }
                int i13 = i % i11;
                if (i13 < 0) {
                    i13 += i11;
                }
                int i14 = (i12 - i13) % i11;
                if (i14 < 0) {
                    i14 += i11;
                }
                return i10 - i14;
            }
        } else {
            if (i11 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i10) {
                int i15 = -i11;
                int i16 = i % i15;
                if (i16 < 0) {
                    i16 += i15;
                }
                int i17 = i10 % i15;
                if (i17 < 0) {
                    i17 += i15;
                }
                int i18 = (i16 - i17) % i15;
                if (i18 < 0) {
                    i18 += i15;
                }
                return i18 + i10;
            }
        }
        return i10;
    }

    public static final boolean r(char c9) {
        return Character.isWhitespace(c9) || Character.isSpaceChar(c9);
    }

    public static Set s(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(t.H(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f6, code lost:
    
        r0 = c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01fa, code lost:
    
        g(r2, null);
        r10 = r0;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w4.g w(y4.a r31, java.lang.String r32) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.d.w(y4.a, java.lang.String):w4.g");
    }

    public abstract Intent k(h.j jVar, Object obj);

    public u5.c p(h.j jVar, Object obj) {
        return null;
    }

    public float q(View view) {
        if (f2735a) {
            try {
                return a0.a(view);
            } catch (NoSuchMethodError unused) {
                f2735a = false;
            }
        }
        return view.getAlpha();
    }

    public abstract void t(Throwable th);

    public abstract void u(ub.o oVar);

    public abstract Object v(Intent intent, int i);

    public void x(View view, float f) {
        if (f2735a) {
            try {
                a0.b(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                f2735a = false;
            }
        }
        view.setAlpha(f);
    }

    public void y(View view, int i) {
        if (!f2737c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2736b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f2737c = true;
        }
        Field field = f2736b;
        if (field != null) {
            try {
                f2736b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
