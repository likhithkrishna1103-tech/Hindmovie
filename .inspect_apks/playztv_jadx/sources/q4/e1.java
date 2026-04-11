package q4;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10785e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f10786g;

    public e1(int i) {
        this.f10781a = 1;
        this.f10782b = i;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f = new t.b(0);
        this.f10786g = new k8.b0(26);
    }

    public static void l(Object obj, Object obj2) {
        be.h.e(obj, "key");
        be.h.e(obj2, "value");
    }

    public void a() {
        View view = (View) ((ArrayList) this.f).get(r0.size() - 1);
        b1 b1Var = (b1) view.getLayoutParams();
        this.f10783c = ((StaggeredGridLayoutManager) this.f10786g).f1676r.d(view);
        b1Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f).clear();
        this.f10782b = Integer.MIN_VALUE;
        this.f10783c = Integer.MIN_VALUE;
        this.f10784d = 0;
    }

    public Object c(Object obj) {
        be.h.e(obj, "key");
        return null;
    }

    public int d() {
        return ((StaggeredGridLayoutManager) this.f10786g).f1681w ? f(r0.size() - 1, -1) : f(0, ((ArrayList) this.f).size());
    }

    public int e() {
        return ((StaggeredGridLayoutManager) this.f10786g).f1681w ? f(0, ((ArrayList) this.f).size()) : f(r0.size() - 1, -1);
    }

    public int f(int i, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f10786g;
        int iM = staggeredGridLayoutManager.f1676r.m();
        int i11 = staggeredGridLayoutManager.f1676r.i();
        int i12 = i10 > i ? 1 : -1;
        while (i != i10) {
            View view = (View) ((ArrayList) this.f).get(i);
            int iG = staggeredGridLayoutManager.f1676r.g(view);
            int iD = staggeredGridLayoutManager.f1676r.d(view);
            boolean z2 = iG <= i11;
            boolean z10 = iD >= iM;
            if (z2 && z10 && (iG < iM || iD > i11)) {
                return h0.G(view);
            }
            i += i12;
        }
        return -1;
    }

    public Object g(Object obj) {
        Object objPut;
        be.h.e(obj, "key");
        synchronized (((k8.b0) this.f10786g)) {
            t.b bVar = (t.b) this.f;
            bVar.getClass();
            Object obj2 = bVar.f11962a.get(obj);
            if (obj2 != null) {
                this.f10784d++;
                return obj2;
            }
            this.f10785e++;
            Object objC = c(obj);
            if (objC == null) {
                return null;
            }
            synchronized (((k8.b0) this.f10786g)) {
                t.b bVar2 = (t.b) this.f;
                bVar2.getClass();
                objPut = bVar2.f11962a.put(obj, objC);
                if (objPut != null) {
                    t.b bVar3 = (t.b) this.f;
                    bVar3.getClass();
                    bVar3.f11962a.put(obj, objPut);
                } else {
                    int i = this.f10783c;
                    l(obj, objC);
                    this.f10783c = i + 1;
                }
            }
            if (objPut != null) {
                return objPut;
            }
            m(this.f10782b);
            return objC;
        }
    }

    public int h(int i) {
        int i10 = this.f10783c;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        a();
        return this.f10783c;
    }

    public View i(int i, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f10786g;
        ArrayList arrayList = (ArrayList) this.f;
        View view = null;
        if (i10 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1681w && h0.G(view2) >= i) || ((!staggeredGridLayoutManager.f1681w && h0.G(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            View view3 = (View) arrayList.get(i11);
            if ((staggeredGridLayoutManager.f1681w && h0.G(view3) <= i) || ((!staggeredGridLayoutManager.f1681w && h0.G(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i11++;
            view = view3;
        }
        return view;
    }

    public int j(int i) {
        ArrayList arrayList = (ArrayList) this.f;
        int i10 = this.f10782b;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (arrayList.size() == 0) {
            return i;
        }
        View view = (View) arrayList.get(0);
        b1 b1Var = (b1) view.getLayoutParams();
        this.f10782b = ((StaggeredGridLayoutManager) this.f10786g).f1676r.g(view);
        b1Var.getClass();
        return this.f10782b;
    }

    public Object k(Object obj, Object obj2) {
        Object objPut;
        be.h.e(obj, "key");
        be.h.e(obj2, "value");
        synchronized (((k8.b0) this.f10786g)) {
            int i = this.f10783c;
            l(obj, obj2);
            this.f10783c = i + 1;
            t.b bVar = (t.b) this.f;
            bVar.getClass();
            objPut = bVar.f11962a.put(obj, obj2);
            if (objPut != null) {
                int i10 = this.f10783c;
                l(obj, objPut);
                this.f10783c = i10 - 1;
            }
        }
        m(this.f10782b);
        return objPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(int r6) {
        /*
            r5 = this;
        L0:
            java.lang.Object r0 = r5.f10786g
            k8.b0 r0 = (k8.b0) r0
            monitor-enter(r0)
            int r1 = r5.f10783c     // Catch: java.lang.Throwable -> L1a
            if (r1 < 0) goto L92
            java.lang.Object r1 = r5.f     // Catch: java.lang.Throwable -> L1a
            t.b r1 = (t.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f11962a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1d
            int r1 = r5.f10783c     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L92
            goto L1d
        L1a:
            r6 = move-exception
            goto L9a
        L1d:
            int r1 = r5.f10783c     // Catch: java.lang.Throwable -> L1a
            if (r1 <= r6) goto L90
            java.lang.Object r1 = r5.f     // Catch: java.lang.Throwable -> L1a
            t.b r1 = (t.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f11962a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2e
            goto L90
        L2e:
            java.lang.Object r1 = r5.f     // Catch: java.lang.Throwable -> L1a
            t.b r1 = (t.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f11962a     // Catch: java.lang.Throwable -> L1a
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "map.entries"
            be.h.d(r1, r2)     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            if (r2 == 0) goto L51
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L4b
            goto L60
        L4b:
            r2 = 0
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L1a
            goto L60
        L51:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L5c
            goto L60
        L5c:
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L1a
        L60:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto L66
            monitor-exit(r0)
            return
        L66:
            java.lang.Object r1 = r3.getKey()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = r3.getValue()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r3 = r5.f     // Catch: java.lang.Throwable -> L1a
            t.b r3 = (t.b) r3     // Catch: java.lang.Throwable -> L1a
            r3.getClass()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "key"
            be.h.e(r1, r4)     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r3 = r3.f11962a     // Catch: java.lang.Throwable -> L1a
            r3.remove(r1)     // Catch: java.lang.Throwable -> L1a
            int r3 = r5.f10783c     // Catch: java.lang.Throwable -> L1a
            l(r1, r2)     // Catch: java.lang.Throwable -> L1a
            int r3 = r3 + (-1)
            r5.f10783c = r3     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r0)
            java.lang.String r0 = "oldValue"
            be.h.e(r2, r0)
            goto L0
        L90:
            monitor-exit(r0)
            return
        L92:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L1a
            throw r1     // Catch: java.lang.Throwable -> L1a
        L9a:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.e1.m(int):void");
    }

    public String toString() {
        String str;
        switch (this.f10781a) {
            case 1:
                synchronized (((k8.b0) this.f10786g)) {
                    try {
                        int i = this.f10784d;
                        int i10 = this.f10785e + i;
                        str = "LruCache[maxSize=" + this.f10782b + ",hits=" + this.f10784d + ",misses=" + this.f10785e + ",hitRate=" + (i10 != 0 ? (i * 100) / i10 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public e1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f10781a = 0;
        this.f10786g = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.f10782b = Integer.MIN_VALUE;
        this.f10783c = Integer.MIN_VALUE;
        this.f10784d = 0;
        this.f10785e = i;
    }
}
