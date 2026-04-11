package l5;

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
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n implements Cloneable {
    public static final Animator[] R = new Animator[0];
    public static final int[] S = {2, 1, 3, 4};
    public static final f9.z T = new f9.z(16);
    public static final ThreadLocal U = new ThreadLocal();
    public ArrayList F;
    public ArrayList G;
    public l[] H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7814v = getClass().getName();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7815w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f7816x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TimeInterpolator f7817y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f7818z = new ArrayList();
    public final ArrayList A = new ArrayList();
    public b6.f B = new b6.f(10);
    public b6.f C = new b6.f(10);
    public a D = null;
    public final int[] E = S;
    public final ArrayList I = new ArrayList();
    public Animator[] J = R;
    public int K = 0;
    public boolean L = false;
    public boolean M = false;
    public n N = null;
    public ArrayList O = null;
    public ArrayList P = new ArrayList();
    public f9.z Q = T;

    public static void b(b6.f fVar, View view, v vVar) {
        v.e eVar = (v.e) fVar.f1800w;
        v.e eVar2 = (v.e) fVar.f1803z;
        SparseArray sparseArray = (SparseArray) fVar.f1801x;
        v.h hVar = (v.h) fVar.f1802y;
        eVar.put(view, vVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (sparseArray.indexOfKey(id2) >= 0) {
                sparseArray.put(id2, null);
            } else {
                sparseArray.put(id2, view);
            }
        }
        WeakHashMap weakHashMap = m0.f11777a;
        String strF = t0.d0.f(view);
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
                if (hVar.f(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    hVar.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) hVar.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    hVar.h(itemIdAtPosition, null);
                }
            }
        }
    }

    public static v.e p() {
        ThreadLocal threadLocal = U;
        v.e eVar = (v.e) threadLocal.get();
        if (eVar != null) {
            return eVar;
        }
        v.e eVar2 = new v.e(0);
        threadLocal.set(eVar2);
        return eVar2;
    }

    public static boolean u(v vVar, v vVar2, String str) {
        Object obj = vVar.f7829a.get(str);
        Object obj2 = vVar2.f7829a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(long j4) {
        this.f7816x = j4;
    }

    public void C(TimeInterpolator timeInterpolator) {
        this.f7817y = timeInterpolator;
    }

    public void D(f9.z zVar) {
        if (zVar == null) {
            this.Q = T;
        } else {
            this.Q = zVar;
        }
    }

    public void F(long j4) {
        this.f7815w = j4;
    }

    public final void G() {
        if (this.K == 0) {
            v(this, m.f7809l);
            this.M = false;
        }
        this.K++;
    }

    public String H(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f7816x != -1) {
            sb.append("dur(");
            sb.append(this.f7816x);
            sb.append(") ");
        }
        if (this.f7815w != -1) {
            sb.append("dly(");
            sb.append(this.f7815w);
            sb.append(") ");
        }
        if (this.f7817y != null) {
            sb.append("interp(");
            sb.append(this.f7817y);
            sb.append(") ");
        }
        ArrayList arrayList = this.f7818z;
        int size = arrayList.size();
        ArrayList arrayList2 = this.A;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i10));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(l lVar) {
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(lVar);
    }

    public void c() {
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.J);
        this.J = R;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.J = animatorArr;
        v(this, m.f7811n);
    }

    public abstract void d(v vVar);

    public final void e(View view, boolean z10) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            v vVar = new v(view);
            if (z10) {
                g(vVar);
            } else {
                d(vVar);
            }
            vVar.f7831c.add(this);
            f(vVar);
            if (z10) {
                b(this.B, view, vVar);
            } else {
                b(this.C, view, vVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i), z10);
            }
        }
    }

    public abstract void g(v vVar);

    public final void h(ViewGroup viewGroup, boolean z10) {
        i(z10);
        ArrayList arrayList = this.f7818z;
        int size = arrayList.size();
        ArrayList arrayList2 = this.A;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z10);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                v vVar = new v(viewFindViewById);
                if (z10) {
                    g(vVar);
                } else {
                    d(vVar);
                }
                vVar.f7831c.add(this);
                f(vVar);
                if (z10) {
                    b(this.B, viewFindViewById, vVar);
                } else {
                    b(this.C, viewFindViewById, vVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = (View) arrayList2.get(i10);
            v vVar2 = new v(view);
            if (z10) {
                g(vVar2);
            } else {
                d(vVar2);
            }
            vVar2.f7831c.add(this);
            f(vVar2);
            if (z10) {
                b(this.B, view, vVar2);
            } else {
                b(this.C, view, vVar2);
            }
        }
    }

    public final void i(boolean z10) {
        if (z10) {
            ((v.e) this.B.f1800w).clear();
            ((SparseArray) this.B.f1801x).clear();
            ((v.h) this.B.f1802y).b();
        } else {
            ((v.e) this.C.f1800w).clear();
            ((SparseArray) this.C.f1801x).clear();
            ((v.h) this.C.f1802y).b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public n clone() {
        try {
            n nVar = (n) super.clone();
            nVar.P = new ArrayList();
            nVar.B = new b6.f(10);
            nVar.C = new b6.f(10);
            nVar.F = null;
            nVar.G = null;
            nVar.N = this;
            nVar.O = null;
            return nVar;
        } catch (CloneNotSupportedException e9) {
            throw new RuntimeException(e9);
        }
    }

    public Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, b6.f fVar, b6.f fVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i10;
        View view;
        v vVar;
        Animator animator;
        v vVar2;
        v.e eVarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i11 = 0;
        while (i11 < size) {
            v vVar3 = (v) arrayList.get(i11);
            v vVar4 = (v) arrayList2.get(i11);
            if (vVar3 != null && !vVar3.f7831c.contains(this)) {
                vVar3 = null;
            }
            if (vVar4 != null && !vVar4.f7831c.contains(this)) {
                vVar4 = null;
            }
            if ((vVar3 != null || vVar4 != null) && (vVar3 == null || vVar4 == null || s(vVar3, vVar4))) {
                Animator animatorK = k(viewGroup, vVar3, vVar4);
                if (animatorK != null) {
                    String str = this.f7814v;
                    if (vVar4 != null) {
                        view = vVar4.f7830b;
                        String[] strArrQ = q();
                        if (strArrQ != null && strArrQ.length > 0) {
                            vVar2 = new v(view);
                            v vVar5 = (v) ((v.e) fVar2.f1800w).get(view);
                            i = size;
                            if (vVar5 != null) {
                                int i12 = 0;
                                while (i12 < strArrQ.length) {
                                    String str2 = strArrQ[i12];
                                    int i13 = i11;
                                    vVar2.f7829a.put(str2, vVar5.f7829a.get(str2));
                                    i12++;
                                    i11 = i13;
                                    vVar5 = vVar5;
                                }
                            }
                            i10 = i11;
                            int i14 = eVarP.f12542x;
                            int i15 = 0;
                            while (true) {
                                if (i15 >= i14) {
                                    animator = animatorK;
                                    break;
                                }
                                k kVar = (k) eVarP.get((Animator) eVarP.f(i15));
                                if (kVar.f7806c != null && kVar.f7804a == view && kVar.f7805b.equals(str) && kVar.f7806c.equals(vVar2)) {
                                    animator = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i = size;
                            i10 = i11;
                            animator = animatorK;
                            vVar2 = null;
                        }
                        animatorK = animator;
                        vVar = vVar2;
                    } else {
                        i = size;
                        i10 = i11;
                        view = vVar3.f7830b;
                        vVar = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        k kVar2 = new k();
                        kVar2.f7804a = view;
                        kVar2.f7805b = str;
                        kVar2.f7806c = vVar;
                        kVar2.f7807d = windowId;
                        kVar2.f7808e = this;
                        kVar2.f = animatorK;
                        eVarP.put(animatorK, kVar2);
                        this.P.add(animatorK);
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
                k kVar3 = (k) eVarP.get((Animator) this.P.get(sparseIntArray.keyAt(i16)));
                kVar3.f.setStartDelay(kVar3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i16)) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i = this.K - 1;
        this.K = i;
        if (i == 0) {
            v(this, m.f7810m);
            for (int i10 = 0; i10 < ((v.h) this.B.f1802y).i(); i10++) {
                View view = (View) ((v.h) this.B.f1802y).j(i10);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i11 = 0; i11 < ((v.h) this.C.f1802y).i(); i11++) {
                View view2 = (View) ((v.h) this.C.f1802y).j(i11);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.M = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r5 = r4.G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r5 = r4.F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (l5.v) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l5.v n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            l5.a r0 = r4.D
            if (r0 == 0) goto L9
            l5.v r5 = r0.n(r5, r6)
            return r5
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.F
            goto L10
        Le:
            java.util.ArrayList r0 = r4.G
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            l5.v r3 = (l5.v) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.f7830b
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
            java.util.ArrayList r5 = r4.G
            goto L35
        L33:
            java.util.ArrayList r5 = r4.F
        L35:
            java.lang.Object r5 = r5.get(r2)
            l5.v r5 = (l5.v) r5
            return r5
        L3c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.n.n(android.view.View, boolean):l5.v");
    }

    public final n o() {
        a aVar = this.D;
        return aVar != null ? aVar.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final v r(View view, boolean z10) {
        a aVar = this.D;
        if (aVar != null) {
            return aVar.r(view, z10);
        }
        return (v) ((v.e) (z10 ? this.B : this.C).f1800w).get(view);
    }

    public boolean s(v vVar, v vVar2) {
        if (vVar != null && vVar2 != null) {
            String[] strArrQ = q();
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    if (u(vVar, vVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = vVar.f7829a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(vVar, vVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id2 = view.getId();
        ArrayList arrayList = this.f7818z;
        int size = arrayList.size();
        ArrayList arrayList2 = this.A;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id2)) || arrayList2.contains(view);
    }

    public final String toString() {
        return H("");
    }

    public final void v(n nVar, m mVar) {
        n nVar2 = this.N;
        if (nVar2 != null) {
            nVar2.v(nVar, mVar);
        }
        ArrayList arrayList = this.O;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.O.size();
        l[] lVarArr = this.H;
        if (lVarArr == null) {
            lVarArr = new l[size];
        }
        this.H = null;
        l[] lVarArr2 = (l[]) this.O.toArray(lVarArr);
        for (int i = 0; i < size; i++) {
            mVar.a(lVarArr2[i], nVar);
            lVarArr2[i] = null;
        }
        this.H = lVarArr2;
    }

    public void w(View view) {
        if (this.M) {
            return;
        }
        ArrayList arrayList = this.I;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.J);
        this.J = R;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.J = animatorArr;
        v(this, m.f7812o);
        this.L = true;
    }

    public n x(l lVar) {
        n nVar;
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            if (!arrayList.remove(lVar) && (nVar = this.N) != null) {
                nVar.x(lVar);
            }
            if (this.O.size() == 0) {
                this.O = null;
            }
        }
        return this;
    }

    public void y(View view) {
        if (this.L) {
            if (!this.M) {
                ArrayList arrayList = this.I;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.J);
                this.J = R;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.J = animatorArr;
                v(this, m.f7813p);
            }
            this.L = false;
        }
    }

    public void z() {
        G();
        v.e eVarP = p();
        ArrayList arrayList = this.P;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (eVarP.containsKey(animator)) {
                G();
                if (animator != null) {
                    animator.addListener(new fa.b(this, eVarP));
                    long j4 = this.f7816x;
                    if (j4 >= 0) {
                        animator.setDuration(j4);
                    }
                    long j7 = this.f7815w;
                    if (j7 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j7);
                    }
                    TimeInterpolator timeInterpolator = this.f7817y;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new ba.f(2, this));
                    animator.start();
                }
            }
        }
        this.P.clear();
        m();
    }

    public void E() {
    }

    public void B(a.a aVar) {
    }

    public void f(v vVar) {
    }
}
