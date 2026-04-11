package v;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import f9.z;
import java.util.ArrayList;
import v4.b1;
import v4.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12538e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f12539g;

    public j(int i) {
        this.f12534a = 0;
        this.f12535b = i;
        if (i <= 0) {
            w.a.c("maxSize <= 0");
            throw null;
        }
        this.f = new w.b(0);
        this.f12539g = new z(28);
    }

    public static void m(Object obj, Object obj2) {
        ge.i.e(obj, "key");
        ge.i.e(obj2, "value");
    }

    public void a() {
        View view = (View) ((ArrayList) this.f).get(r0.size() - 1);
        b1 b1Var = (b1) view.getLayoutParams();
        this.f12536c = ((StaggeredGridLayoutManager) this.f12539g).f1459r.d(view);
        b1Var.getClass();
    }

    public void b() {
        ((ArrayList) this.f).clear();
        this.f12535b = Integer.MIN_VALUE;
        this.f12536c = Integer.MIN_VALUE;
        this.f12537d = 0;
    }

    public Object c(Object obj) {
        ge.i.e(obj, "key");
        return null;
    }

    public void d(boolean z10, Object obj, Object obj2, Object obj3) {
        ge.i.e(obj, "key");
        ge.i.e(obj2, "oldValue");
    }

    public int e() {
        return ((StaggeredGridLayoutManager) this.f12539g).f1464w ? g(r0.size() - 1, -1) : g(0, ((ArrayList) this.f).size());
    }

    public int f() {
        return ((StaggeredGridLayoutManager) this.f12539g).f1464w ? g(0, ((ArrayList) this.f).size()) : g(r0.size() - 1, -1);
    }

    public int g(int i, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f12539g;
        int iM = staggeredGridLayoutManager.f1459r.m();
        int i11 = staggeredGridLayoutManager.f1459r.i();
        int i12 = i10 > i ? 1 : -1;
        while (i != i10) {
            View view = (View) ((ArrayList) this.f).get(i);
            int iG = staggeredGridLayoutManager.f1459r.g(view);
            int iD = staggeredGridLayoutManager.f1459r.d(view);
            boolean z10 = iG <= i11;
            boolean z11 = iD >= iM;
            if (z10 && z11 && (iG < iM || iD > i11)) {
                return h0.G(view);
            }
            i += i12;
        }
        return -1;
    }

    public Object h(Object obj) {
        Object objPut;
        ge.i.e(obj, "key");
        synchronized (((z) this.f12539g)) {
            w.b bVar = (w.b) this.f;
            bVar.getClass();
            Object obj2 = bVar.f13746a.get(obj);
            if (obj2 != null) {
                this.f12537d++;
                return obj2;
            }
            this.f12538e++;
            Object objC = c(obj);
            if (objC == null) {
                return null;
            }
            synchronized (((z) this.f12539g)) {
                w.b bVar2 = (w.b) this.f;
                bVar2.getClass();
                objPut = bVar2.f13746a.put(obj, objC);
                if (objPut != null) {
                    w.b bVar3 = (w.b) this.f;
                    bVar3.getClass();
                    bVar3.f13746a.put(obj, objPut);
                } else {
                    int i = this.f12536c;
                    m(obj, objC);
                    this.f12536c = i + 1;
                }
            }
            if (objPut != null) {
                d(false, obj, objC, objPut);
                return objPut;
            }
            n(this.f12535b);
            return objC;
        }
    }

    public int i(int i) {
        int i10 = this.f12536c;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (((ArrayList) this.f).size() == 0) {
            return i;
        }
        a();
        return this.f12536c;
    }

    public View j(int i, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f12539g;
        ArrayList arrayList = (ArrayList) this.f;
        View view = null;
        if (i10 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1464w && h0.G(view2) >= i) || ((!staggeredGridLayoutManager.f1464w && h0.G(view2) <= i) || !view2.hasFocusable())) {
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
            if ((staggeredGridLayoutManager.f1464w && h0.G(view3) <= i) || ((!staggeredGridLayoutManager.f1464w && h0.G(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i11++;
            view = view3;
        }
        return view;
    }

    public int k(int i) {
        ArrayList arrayList = (ArrayList) this.f;
        int i10 = this.f12535b;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (arrayList.size() == 0) {
            return i;
        }
        View view = (View) arrayList.get(0);
        b1 b1Var = (b1) view.getLayoutParams();
        this.f12535b = ((StaggeredGridLayoutManager) this.f12539g).f1459r.g(view);
        b1Var.getClass();
        return this.f12535b;
    }

    public Object l(Object obj, Object obj2) {
        Object objPut;
        ge.i.e(obj, "key");
        ge.i.e(obj2, "value");
        synchronized (((z) this.f12539g)) {
            int i = this.f12536c;
            m(obj, obj2);
            this.f12536c = i + 1;
            w.b bVar = (w.b) this.f;
            bVar.getClass();
            objPut = bVar.f13746a.put(obj, obj2);
            if (objPut != null) {
                int i10 = this.f12536c;
                m(obj, objPut);
                this.f12536c = i10 - 1;
            }
        }
        if (objPut != null) {
            d(false, obj, objPut, obj2);
        }
        n(this.f12535b);
        return objPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(int r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6.f12539g
            f9.z r0 = (f9.z) r0
            monitor-enter(r0)
            int r1 = r6.f12536c     // Catch: java.lang.Throwable -> L1a
            if (r1 < 0) goto L91
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            w.b r1 = (w.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f13746a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1d
            int r1 = r6.f12536c     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L91
            goto L1d
        L1a:
            r7 = move-exception
            goto L99
        L1d:
            int r1 = r6.f12536c     // Catch: java.lang.Throwable -> L1a
            if (r1 <= r7) goto L8f
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            w.b r1 = (w.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f13746a     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2e
            goto L8f
        L2e:
            java.lang.Object r1 = r6.f     // Catch: java.lang.Throwable -> L1a
            w.b r1 = (w.b) r1     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r1 = r1.f13746a     // Catch: java.lang.Throwable -> L1a
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "<get-entries>(...)"
            ge.i.d(r1, r2)     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L1a
            r3 = 0
            if (r2 == 0) goto L52
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L4c
        L4a:
            r1 = r3
            goto L61
        L4c:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L1a
            goto L61
        L52:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1a
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L5d
            goto L4a
        L5d:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L1a
        L61:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L67
            monitor-exit(r0)
            return
        L67:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r4 = r6.f     // Catch: java.lang.Throwable -> L1a
            w.b r4 = (w.b) r4     // Catch: java.lang.Throwable -> L1a
            r4.getClass()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "key"
            ge.i.e(r2, r5)     // Catch: java.lang.Throwable -> L1a
            java.util.LinkedHashMap r4 = r4.f13746a     // Catch: java.lang.Throwable -> L1a
            r4.remove(r2)     // Catch: java.lang.Throwable -> L1a
            int r4 = r6.f12536c     // Catch: java.lang.Throwable -> L1a
            m(r2, r1)     // Catch: java.lang.Throwable -> L1a
            r5 = 1
            int r4 = r4 - r5
            r6.f12536c = r4     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r0)
            r6.d(r5, r2, r1, r3)
            goto L0
        L8f:
            monitor-exit(r0)
            return
        L91:
            java.lang.String r7 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L1a
            throw r1     // Catch: java.lang.Throwable -> L1a
        L99:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v.j.n(int):void");
    }

    public String toString() {
        String str;
        switch (this.f12534a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                synchronized (((z) this.f12539g)) {
                    try {
                        int i = this.f12537d;
                        int i10 = this.f12538e + i;
                        str = "LruCache[maxSize=" + this.f12535b + ",hits=" + this.f12537d + ",misses=" + this.f12538e + ",hitRate=" + (i10 != 0 ? (i * 100) / i10 : 0) + "%]";
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public j(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f12534a = 1;
        this.f12539g = staggeredGridLayoutManager;
        this.f = new ArrayList();
        this.f12535b = Integer.MIN_VALUE;
        this.f12536c = Integer.MIN_VALUE;
        this.f12537d = 0;
        this.f12538e = i;
    }
}
