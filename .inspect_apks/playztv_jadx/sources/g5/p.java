package g5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements Cloneable {
    public static final Animator[] Q = new Animator[0];
    public static final int[] R = {2, 1, 3, 4};
    public static final t7.j S = new t7.j(12);
    public static final ThreadLocal T = new ThreadLocal();
    public ArrayList E;
    public ArrayList F;
    public n[] G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f5298u = getClass().getName();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f5299v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f5300w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TimeInterpolator f5301x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f5302y = new ArrayList();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f5303z = new ArrayList();
    public ub.o A = new ub.o(14);
    public ub.o B = new ub.o(14);
    public a C = null;
    public final int[] D = R;
    public final ArrayList H = new ArrayList();
    public Animator[] I = Q;
    public int J = 0;
    public boolean K = false;
    public boolean L = false;
    public p M = null;
    public ArrayList N = null;
    public ArrayList O = new ArrayList();
    public t7.j P = S;

    public static void b(ub.o oVar, View view, x xVar) {
        s.e eVar = (s.e) oVar.f12868v;
        s.e eVar2 = (s.e) oVar.f12871y;
        SparseArray sparseArray = (SparseArray) oVar.f12869w;
        s.g gVar = (s.g) oVar.f12870x;
        eVar.put(view, xVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (sparseArray.indexOfKey(id2) >= 0) {
                sparseArray.put(id2, null);
            } else {
                sparseArray.put(id2, view);
            }
        }
        WeakHashMap weakHashMap = o0.f10475a;
        String strF = q0.f0.f(view);
        if (strF != null) {
            if (eVar2.containsKey(strF)) {
                eVar2.put(strF, null);
            } else {
                eVar2.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (gVar.f(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    gVar.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) gVar.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    gVar.h(itemIdAtPosition, null);
                }
            }
        }
    }

    public static s.e p() {
        ThreadLocal threadLocal = T;
        s.e eVar = (s.e) threadLocal.get();
        if (eVar != null) {
            return eVar;
        }
        s.e eVar2 = new s.e(0);
        threadLocal.set(eVar2);
        return eVar2;
    }

    public static boolean u(x xVar, x xVar2, String str) {
        Object obj = xVar.f5314a.get(str);
        Object obj2 = xVar2.f5314a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(long j5) {
        this.f5300w = j5;
    }

    public void C(TimeInterpolator timeInterpolator) {
        this.f5301x = timeInterpolator;
    }

    public void D(t7.j jVar) {
        if (jVar == null) {
            this.P = S;
        } else {
            this.P = jVar;
        }
    }

    public void F(long j5) {
        this.f5299v = j5;
    }

    public final void G() {
        if (this.J == 0) {
            v(this, o.f5293k);
            this.L = false;
        }
        this.J++;
    }

    public String H(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(getClass().getSimpleName());
        sb2.append("@");
        sb2.append(Integer.toHexString(hashCode()));
        sb2.append(": ");
        if (this.f5300w != -1) {
            sb2.append("dur(");
            sb2.append(this.f5300w);
            sb2.append(") ");
        }
        if (this.f5299v != -1) {
            sb2.append("dly(");
            sb2.append(this.f5299v);
            sb2.append(") ");
        }
        if (this.f5301x != null) {
            sb2.append("interp(");
            sb2.append(this.f5301x);
            sb2.append(") ");
        }
        ArrayList arrayList = this.f5302y;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f5303z;
        if (size > 0 || arrayList2.size() > 0) {
            sb2.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    if (i10 > 0) {
                        sb2.append(", ");
                    }
                    sb2.append(arrayList2.get(i10));
                }
            }
            sb2.append(")");
        }
        return sb2.toString();
    }

    public void a(n nVar) {
        if (this.N == null) {
            this.N = new ArrayList();
        }
        this.N.add(nVar);
    }

    public void c() {
        ArrayList arrayList = this.H;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.I);
        this.I = Q;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.I = animatorArr;
        v(this, o.f5295m);
    }

    public abstract void d(x xVar);

    public final void e(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            x xVar = new x(view);
            if (z2) {
                g(xVar);
            } else {
                d(xVar);
            }
            xVar.f5316c.add(this);
            f(xVar);
            if (z2) {
                b(this.A, view, xVar);
            } else {
                b(this.B, view, xVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i), z2);
            }
        }
    }

    public abstract void g(x xVar);

    public final void h(ViewGroup viewGroup, boolean z2) {
        i(z2);
        ArrayList arrayList = this.f5302y;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f5303z;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z2);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                x xVar = new x(viewFindViewById);
                if (z2) {
                    g(xVar);
                } else {
                    d(xVar);
                }
                xVar.f5316c.add(this);
                f(xVar);
                if (z2) {
                    b(this.A, viewFindViewById, xVar);
                } else {
                    b(this.B, viewFindViewById, xVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = (View) arrayList2.get(i10);
            x xVar2 = new x(view);
            if (z2) {
                g(xVar2);
            } else {
                d(xVar2);
            }
            xVar2.f5316c.add(this);
            f(xVar2);
            if (z2) {
                b(this.A, view, xVar2);
            } else {
                b(this.B, view, xVar2);
            }
        }
    }

    public final void i(boolean z2) {
        if (z2) {
            ((s.e) this.A.f12868v).clear();
            ((SparseArray) this.A.f12869w).clear();
            ((s.g) this.A.f12870x).b();
        } else {
            ((s.e) this.B.f12868v).clear();
            ((SparseArray) this.B.f12869w).clear();
            ((s.g) this.B.f12870x).b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public p clone() {
        try {
            p pVar = (p) super.clone();
            pVar.O = new ArrayList();
            pVar.A = new ub.o(14);
            pVar.B = new ub.o(14);
            pVar.E = null;
            pVar.F = null;
            pVar.M = this;
            pVar.N = null;
            return pVar;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Animator k(ViewGroup viewGroup, x xVar, x xVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, ub.o oVar, ub.o oVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i10;
        View view;
        x xVar;
        Animator animator;
        x xVar2;
        s.e eVarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i11 = 0;
        while (i11 < size) {
            x xVar3 = (x) arrayList.get(i11);
            x xVar4 = (x) arrayList2.get(i11);
            if (xVar3 != null && !xVar3.f5316c.contains(this)) {
                xVar3 = null;
            }
            if (xVar4 != null && !xVar4.f5316c.contains(this)) {
                xVar4 = null;
            }
            if ((xVar3 != null || xVar4 != null) && (xVar3 == null || xVar4 == null || s(xVar3, xVar4))) {
                Animator animatorK = k(viewGroup, xVar3, xVar4);
                if (animatorK != null) {
                    String str = this.f5298u;
                    if (xVar4 != null) {
                        view = xVar4.f5315b;
                        String[] strArrQ = q();
                        if (strArrQ != null && strArrQ.length > 0) {
                            xVar2 = new x(view);
                            x xVar5 = (x) ((s.e) oVar2.f12868v).get(view);
                            i = size;
                            if (xVar5 != null) {
                                int i12 = 0;
                                while (i12 < strArrQ.length) {
                                    String str2 = strArrQ[i12];
                                    int i13 = i11;
                                    xVar2.f5314a.put(str2, xVar5.f5314a.get(str2));
                                    i12++;
                                    i11 = i13;
                                    xVar5 = xVar5;
                                }
                            }
                            i10 = i11;
                            int i14 = eVarP.f11635w;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    animator = animatorK;
                                    break;
                                }
                                m mVar = (m) eVarP.get((Animator) eVarP.f(i15));
                                if (mVar.f5290c != null && mVar.f5288a == view && mVar.f5289b.equals(str) && mVar.f5290c.equals(xVar2)) {
                                    animator = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i = size;
                            i10 = i11;
                            animator = animatorK;
                            xVar2 = null;
                        }
                        animatorK = animator;
                        xVar = xVar2;
                    } else {
                        i = size;
                        i10 = i11;
                        view = xVar3.f5315b;
                        xVar = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        m mVar2 = new m();
                        mVar2.f5288a = view;
                        mVar2.f5289b = str;
                        mVar2.f5290c = xVar;
                        mVar2.f5291d = windowId;
                        mVar2.f5292e = this;
                        mVar2.f = animatorK;
                        eVarP.put(animatorK, mVar2);
                        this.O.add(animatorK);
                    }
                }
                i11 = i10 + 1;
                size = i;
            }
            i = size;
            i10 = i11;
            i11 = i10 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                m mVar3 = (m) eVarP.get((Animator) this.O.get(sparseIntArray.keyAt(i16)));
                mVar3.f.setStartDelay(mVar3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i16)) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i = this.J - 1;
        this.J = i;
        if (i == 0) {
            v(this, o.f5294l);
            for (int i10 = 0; i10 < ((s.g) this.A.f12870x).i(); i10++) {
                View view = (View) ((s.g) this.A.f12870x).j(i10);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i11 = 0; i11 < ((s.g) this.B.f12870x).i(); i11++) {
                View view2 = (View) ((s.g) this.B.f12870x).j(i11);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.L = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r5 = r4.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r5 = r4.E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (g5.x) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g5.x n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            g5.a r0 = r4.C
            if (r0 == 0) goto L9
            g5.x r5 = r0.n(r5, r6)
            return r5
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.E
            goto L10
        Le:
            java.util.ArrayList r0 = r4.F
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            g5.x r3 = (g5.x) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.f5315b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r5 = r4.F
            goto L35
        L33:
            java.util.ArrayList r5 = r4.E
        L35:
            java.lang.Object r5 = r5.get(r2)
            g5.x r5 = (g5.x) r5
            return r5
        L3c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.p.n(android.view.View, boolean):g5.x");
    }

    public final p o() {
        a aVar = this.C;
        return aVar != null ? aVar.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final x r(View view, boolean z2) {
        a aVar = this.C;
        if (aVar != null) {
            return aVar.r(view, z2);
        }
        return (x) ((s.e) (z2 ? this.A : this.B).f12868v).get(view);
    }

    public boolean s(x xVar, x xVar2) {
        if (xVar != null && xVar2 != null) {
            String[] strArrQ = q();
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    if (u(xVar, xVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = xVar.f5314a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(xVar, xVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id2 = view.getId();
        ArrayList arrayList = this.f5302y;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f5303z;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id2)) || arrayList2.contains(view);
    }

    public final String toString() {
        return H("");
    }

    public final void v(p pVar, o oVar) {
        p pVar2 = this.M;
        if (pVar2 != null) {
            pVar2.v(pVar, oVar);
        }
        ArrayList arrayList = this.N;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.N.size();
        n[] nVarArr = this.G;
        if (nVarArr == null) {
            nVarArr = new n[size];
        }
        this.G = null;
        n[] nVarArr2 = (n[]) this.N.toArray(nVarArr);
        for (int i = 0; i < size; i++) {
            oVar.a(nVarArr2[i], pVar);
            nVarArr2[i] = null;
        }
        this.G = nVarArr2;
    }

    public void w(View view) {
        if (this.L) {
            return;
        }
        ArrayList arrayList = this.H;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.I);
        this.I = Q;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.I = animatorArr;
        v(this, o.f5296n);
        this.K = true;
    }

    public p x(n nVar) {
        p pVar;
        ArrayList arrayList = this.N;
        if (arrayList != null) {
            if (!arrayList.remove(nVar) && (pVar = this.M) != null) {
                pVar.x(nVar);
            }
            if (this.N.size() == 0) {
                this.N = null;
            }
        }
        return this;
    }

    public void y(View view) {
        if (this.K) {
            if (!this.L) {
                ArrayList arrayList = this.H;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.I);
                this.I = Q;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.I = animatorArr;
                v(this, o.f5297o);
            }
            this.K = false;
        }
    }

    public void z() {
        G();
        s.e eVarP = p();
        ArrayList arrayList = this.O;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (eVarP.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new k(this, eVarP));
                    long j5 = this.f5300w;
                    if (j5 >= 0) {
                        animator.setDuration(j5);
                    }
                    long j8 = this.f5299v;
                    if (j8 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j8);
                    }
                    TimeInterpolator timeInterpolator = this.f5301x;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new l(0, this));
                    animator.start();
                }
            }
        }
        this.O.clear();
        m();
    }

    public void E() {
    }

    public void B(android.support.v4.media.session.b bVar) {
    }

    public void f(x xVar) {
    }
}
