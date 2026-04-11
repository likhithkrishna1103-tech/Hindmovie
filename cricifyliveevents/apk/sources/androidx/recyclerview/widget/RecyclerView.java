package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import b1.d;
import f9.s0;
import ff.m;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kf.i;
import l0.e;
import nb.w;
import t0.g0;
import t0.k;
import t0.l;
import t0.m0;
import u4.a;
import u4.c;
import v.g;
import v.h;
import v4.c0;
import v4.d0;
import v4.e0;
import v4.f0;
import v4.f1;
import v4.h0;
import v4.i0;
import v4.j;
import v4.j0;
import v4.k0;
import v4.l0;
import v4.n0;
import v4.o0;
import v4.p0;
import v4.q0;
import v4.s;
import v4.t0;
import v4.u0;
import v4.v0;
import v4.w0;
import v4.x;
import v4.x0;
import v4.y;
import v4.y0;
import v4.z;
import z0.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements k {
    public static boolean W0 = false;
    public static boolean X0 = false;
    public static final int[] Y0 = {R.attr.nestedScrollingEnabled};
    public static final float Z0 = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final boolean f1423a1 = true;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final boolean f1424b1 = true;
    public static final Class[] c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final d f1425d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final u0 f1426e1;
    public final m A;
    public final g A0;
    public final w B;
    public final t0 B0;
    public boolean C;
    public k0 C0;
    public final v4.w D;
    public ArrayList D0;
    public final Rect E;
    public boolean E0;
    public final Rect F;
    public boolean F0;
    public final RectF G;
    public final y G0;
    public z H;
    public boolean H0;
    public h0 I;
    public y0 I0;
    public final ArrayList J;
    public final int[] J0;
    public final ArrayList K;
    public l K0;
    public final ArrayList L;
    public final int[] L0;
    public j M;
    public final int[] M0;
    public boolean N;
    public final int[] N0;
    public boolean O;
    public final ArrayList O0;
    public boolean P;
    public final v4.w P0;
    public int Q;
    public boolean Q0;
    public boolean R;
    public int R0;
    public boolean S;
    public int S0;
    public boolean T;
    public final boolean T0;
    public int U;
    public final x U0;
    public boolean V;
    public final t0.g V0;
    public final AccessibilityManager W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1427a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1428b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1429c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1430d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public d0 f1431e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public EdgeEffect f1432f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public EdgeEffect f1433g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public EdgeEffect f1434h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public EdgeEffect f1435i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public e0 f1436j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f1437k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f1438l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public VelocityTracker f1439m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1440n0;
    public int o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1441p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f1442q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f1443r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public j0 f1444s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int f1445t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final int f1446u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f1447v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final float f1448v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p0 f1449w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final float f1450w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final n0 f1451x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f1452x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q0 f1453y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final w0 f1454y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ff.k f1455z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public v4.l f1456z0;

    static {
        Class cls = Integer.TYPE;
        c1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f1425d1 = new d(2);
        f1426e1 = new u0();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.recyclerViewStyle);
    }

    public static RecyclerView G(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewG = G(viewGroup.getChildAt(i));
            if (recyclerViewG != null) {
                return recyclerViewG;
            }
        }
        return null;
    }

    public static x0 M(View view) {
        if (view == null) {
            return null;
        }
        return ((i0) view.getLayoutParams()).f13261a;
    }

    private l getScrollingChildHelper() {
        if (this.K0 == null) {
            this.K0 = new l(this);
        }
        return this.K0;
    }

    public static void l(x0 x0Var) {
        WeakReference weakReference = x0Var.f13388b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == x0Var.f13387a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            x0Var.f13388b = null;
        }
    }

    public static int o(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i10) {
        if (i > 0 && edgeEffect != null && w1.d.h(edgeEffect) != 0.0f) {
            int iRound = Math.round(w1.d.q(edgeEffect, ((-i) * 4.0f) / i10, 0.5f) * ((-i10) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || w1.d.h(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i10;
        int iRound2 = Math.round(w1.d.q(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z10) {
        W0 = z10;
    }

    public static void setVerboseLoggingEnabled(boolean z10) {
        X0 = z10;
    }

    public final void A() {
        if (this.f1433g0 != null) {
            return;
        }
        ((u0) this.f1431e0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1433g0 = edgeEffect;
        if (this.C) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String B() {
        return " " + super.toString() + ", adapter:" + this.H + ", layout:" + this.I + ", context:" + getContext();
    }

    public final void C(t0 t0Var) {
        if (getScrollState() != 2) {
            t0Var.getClass();
            return;
        }
        OverScroller overScroller = this.f1454y0.f13382x;
        overScroller.getFinalX();
        overScroller.getCurrX();
        t0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View D(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList r1 = r11.L
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L64
            java.lang.Object r5 = r1.get(r4)
            v4.j r5 = (v4.j) r5
            int r6 = r5.f13284v
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L59
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.d(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.c(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L61
            if (r6 != 0) goto L3c
            if (r9 == 0) goto L61
        L3c:
            if (r9 == 0) goto L49
            r5.f13285w = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f13278p = r6
            goto L55
        L49:
            if (r6 == 0) goto L55
            r5.f13285w = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f13275m = r6
        L55:
            r5.f(r8)
            goto L5b
        L59:
            if (r6 != r8) goto L61
        L5b:
            r6 = 3
            if (r0 == r6) goto L61
            r11.M = r5
            return r7
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.E(android.view.MotionEvent):boolean");
    }

    public final void F(int[] iArr) {
        int iV = this.A.v();
        if (iV == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < iV; i11++) {
            x0 x0VarM = M(this.A.u(i11));
            if (!x0VarM.o()) {
                int iB = x0VarM.b();
                if (iB < i) {
                    i = iB;
                }
                if (iB > i10) {
                    i10 = iB;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i10;
    }

    public final x0 H(int i) {
        x0 x0Var = null;
        if (this.f1427a0) {
            return null;
        }
        int iY = this.A.y();
        for (int i10 = 0; i10 < iY; i10++) {
            x0 x0VarM = M(this.A.x(i10));
            if (x0VarM != null && !x0VarM.h() && J(x0VarM) == i) {
                if (!((ArrayList) this.A.f4602z).contains(x0VarM.f13387a)) {
                    return x0VarM;
                }
                x0Var = x0VarM;
            }
        }
        return x0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.I(int, int, int, int):boolean");
    }

    public final int J(x0 x0Var) {
        if ((x0Var.f13394j & 524) == 0 && x0Var.e()) {
            int i = x0Var.f13389c;
            ArrayList arrayList = (ArrayList) this.f1455z.f4588c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                v4.a aVar = (v4.a) arrayList.get(i10);
                int i11 = aVar.f13174a;
                if (i11 != 1) {
                    if (i11 == 2) {
                        int i12 = aVar.f13175b;
                        if (i12 <= i) {
                            int i13 = aVar.f13177d;
                            if (i12 + i13 <= i) {
                                i -= i13;
                            }
                        } else {
                            continue;
                        }
                    } else if (i11 == 8) {
                        int i14 = aVar.f13175b;
                        if (i14 == i) {
                            i = aVar.f13177d;
                        } else {
                            if (i14 < i) {
                                i--;
                            }
                            if (aVar.f13177d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (aVar.f13175b <= i) {
                    i += aVar.f13177d;
                }
            }
            return i;
        }
        return -1;
    }

    public final long K(x0 x0Var) {
        return this.H.f13408b ? x0Var.f13391e : x0Var.f13389c;
    }

    public final x0 L(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return M(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect N(View view) {
        i0 i0Var = (i0) view.getLayoutParams();
        boolean z10 = i0Var.f13263c;
        Rect rect = i0Var.f13262b;
        if (!z10 || (this.B0.f13366g && (i0Var.f13261a.k() || i0Var.f13261a.f()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.E;
            rect2.set(0, 0, 0, 0);
            ((f0) arrayList.get(i)).getClass();
            ((i0) view.getLayoutParams()).f13261a.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        i0Var.f13263c = false;
        return rect;
    }

    public final boolean O() {
        return !this.P || this.f1427a0 || this.f1455z.y();
    }

    public final boolean P() {
        return this.f1429c0 > 0;
    }

    public final void Q(int i) {
        if (this.I == null) {
            return;
        }
        setScrollState(2);
        this.I.r0(i);
        awakenScrollBars();
    }

    public final void R() {
        int iY = this.A.y();
        for (int i = 0; i < iY; i++) {
            ((i0) this.A.x(i).getLayoutParams()).f13263c = true;
        }
        ArrayList arrayList = this.f1451x.f13309c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            i0 i0Var = (i0) ((x0) arrayList.get(i10)).f13387a.getLayoutParams();
            if (i0Var != null) {
                i0Var.f13263c = true;
            }
        }
    }

    public final void S(int i, int i10, boolean z10) {
        int i11 = i + i10;
        int iY = this.A.y();
        for (int i12 = 0; i12 < iY; i12++) {
            x0 x0VarM = M(this.A.x(i12));
            if (x0VarM != null && !x0VarM.o()) {
                int i13 = x0VarM.f13389c;
                t0 t0Var = this.B0;
                if (i13 >= i11) {
                    if (X0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i12 + " holder " + x0VarM + " now at position " + (x0VarM.f13389c - i10));
                    }
                    x0VarM.l(-i10, z10);
                    t0Var.f = true;
                } else if (i13 >= i) {
                    if (X0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i12 + " holder " + x0VarM + " now REMOVED");
                    }
                    x0VarM.a(8);
                    x0VarM.l(-i10, z10);
                    x0VarM.f13389c = i - 1;
                    t0Var.f = true;
                }
            }
        }
        n0 n0Var = this.f1451x;
        ArrayList arrayList = n0Var.f13309c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x0 x0Var = (x0) arrayList.get(size);
            if (x0Var != null) {
                int i14 = x0Var.f13389c;
                if (i14 >= i11) {
                    if (X0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + x0Var + " now at position " + (x0Var.f13389c - i10));
                    }
                    x0Var.l(-i10, z10);
                } else if (i14 >= i) {
                    x0Var.a(8);
                    n0Var.h(size);
                }
            }
        }
        requestLayout();
    }

    public final void T() {
        this.f1429c0++;
    }

    public final void U(boolean z10) {
        int i;
        AccessibilityManager accessibilityManager;
        int i10 = this.f1429c0 - 1;
        this.f1429c0 = i10;
        if (i10 < 1) {
            if (W0 && i10 < 0) {
                throw new IllegalStateException(e.i(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.f1429c0 = 0;
            if (z10) {
                int i11 = this.U;
                this.U = 0;
                if (i11 != 0 && (accessibilityManager = this.W) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i11);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.O0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    x0 x0Var = (x0) arrayList.get(size);
                    if (x0Var.f13387a.getParent() == this && !x0Var.o() && (i = x0Var.f13401q) != -1) {
                        x0Var.f13387a.setImportantForAccessibility(i);
                        x0Var.f13401q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void V(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1438l0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1438l0 = motionEvent.getPointerId(i);
            int x10 = (int) (motionEvent.getX(i) + 0.5f);
            this.f1441p0 = x10;
            this.f1440n0 = x10;
            int y10 = (int) (motionEvent.getY(i) + 0.5f);
            this.f1442q0 = y10;
            this.o0 = y10;
        }
    }

    public final void W() {
        if (this.H0 || !this.N) {
            return;
        }
        WeakHashMap weakHashMap = m0.f11777a;
        postOnAnimation(this.P0);
        this.H0 = true;
    }

    public final void X() {
        boolean z10;
        boolean z11 = false;
        if (this.f1427a0) {
            ff.k kVar = this.f1455z;
            kVar.F((ArrayList) kVar.f4588c);
            kVar.F((ArrayList) kVar.f4589d);
            kVar.f4586a = 0;
            if (this.f1428b0) {
                this.I.a0();
            }
        }
        if (this.f1436j0 == null || !this.I.D0()) {
            this.f1455z.f();
        } else {
            this.f1455z.E();
        }
        boolean z12 = this.E0 || this.F0;
        boolean z13 = this.P && this.f1436j0 != null && ((z10 = this.f1427a0) || z12 || this.I.f) && (!z10 || this.H.f13408b);
        t0 t0Var = this.B0;
        t0Var.f13368j = z13;
        if (z13 && z12 && !this.f1427a0 && this.f1436j0 != null && this.I.D0()) {
            z11 = true;
        }
        t0Var.f13369k = z11;
    }

    public final void Y(boolean z10) {
        this.f1428b0 = z10 | this.f1428b0;
        this.f1427a0 = true;
        int iY = this.A.y();
        for (int i = 0; i < iY; i++) {
            x0 x0VarM = M(this.A.x(i));
            if (x0VarM != null && !x0VarM.o()) {
                x0VarM.a(6);
            }
        }
        R();
        n0 n0Var = this.f1451x;
        ArrayList arrayList = n0Var.f13309c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            x0 x0Var = (x0) arrayList.get(i10);
            if (x0Var != null) {
                x0Var.a(6);
                x0Var.a(1024);
            }
        }
        z zVar = n0Var.f13313h.H;
        if (zVar == null || !zVar.f13408b) {
            n0Var.g();
        }
    }

    public final void Z(x0 x0Var, d4.e eVar) {
        x0Var.f13394j &= -8193;
        boolean z10 = this.B0.f13367h;
        w wVar = this.B;
        if (z10 && x0Var.k() && !x0Var.h() && !x0Var.o()) {
            ((h) wVar.f9017x).h(K(x0Var), x0Var);
        }
        v.k kVar = (v.k) wVar.f9016w;
        f1 f1VarA = (f1) kVar.get(x0Var);
        if (f1VarA == null) {
            f1VarA = f1.a();
            kVar.put(x0Var, f1VarA);
        }
        f1VarA.f13224b = eVar;
        f1VarA.f13223a |= 4;
    }

    public final void a0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1432f0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f1432f0.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f1433g0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f1433g0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1434h0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f1434h0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1435i0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f1435i0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i10) {
        h0 h0Var = this.I;
        if (h0Var != null) {
            h0Var.getClass();
        }
        super.addFocusables(arrayList, i, i10);
    }

    public final int b0(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.f1432f0;
        float f10 = 0.0f;
        if (edgeEffect == null || w1.d.h(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1434h0;
            if (edgeEffect2 != null && w1.d.h(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.f1434h0.onRelease();
                } else {
                    float fQ = w1.d.q(this.f1434h0, width, height);
                    if (w1.d.h(this.f1434h0) == 0.0f) {
                        this.f1434h0.onRelease();
                    }
                    f10 = fQ;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f1432f0.onRelease();
            } else {
                float f11 = -w1.d.q(this.f1432f0, -width, 1.0f - height);
                if (w1.d.h(this.f1432f0) == 0.0f) {
                    this.f1432f0.onRelease();
                }
                f10 = f11;
            }
            invalidate();
        }
        return Math.round(f10 * getWidth());
    }

    public final int c0(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.f1433g0;
        float f10 = 0.0f;
        if (edgeEffect == null || w1.d.h(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1435i0;
            if (edgeEffect2 != null && w1.d.h(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.f1435i0.onRelease();
                } else {
                    float fQ = w1.d.q(this.f1435i0, height, 1.0f - width);
                    if (w1.d.h(this.f1435i0) == 0.0f) {
                        this.f1435i0.onRelease();
                    }
                    f10 = fQ;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f1433g0.onRelease();
            } else {
                float f11 = -w1.d.q(this.f1433g0, -height, width);
                if (w1.d.h(this.f1433g0) == 0.0f) {
                    this.f1433g0.onRelease();
                }
                f10 = f11;
            }
            invalidate();
        }
        return Math.round(f10 * getHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i0) && this.I.f((i0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.d()) {
            return this.I.j(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.d()) {
            return this.I.k(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.d()) {
            return this.I.l(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.e()) {
            return this.I.m(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.e()) {
            return this.I.n(this.B0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        h0 h0Var = this.I;
        if (h0Var != null && h0Var.e()) {
            return this.I.o(this.B0);
        }
        return 0;
    }

    public final void d0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.E;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof i0) {
            i0 i0Var = (i0) layoutParams;
            if (!i0Var.f13263c) {
                Rect rect2 = i0Var.f13262b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.I.o0(this, view, this.E, !this.P, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        h0 layoutManager = getLayoutManager();
        int iA = 0;
        if (layoutManager != null) {
            if (layoutManager.e()) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 92 || keyCode == 93) {
                    int measuredHeight = getMeasuredHeight();
                    if (keyCode == 93) {
                        i0(0, measuredHeight, false);
                        return true;
                    }
                    i0(0, -measuredHeight, false);
                    return true;
                }
                if (keyCode == 122 || keyCode == 123) {
                    boolean zL = layoutManager.L();
                    if (keyCode == 122) {
                        if (zL) {
                            iA = getAdapter().a();
                        }
                    } else if (!zL) {
                        iA = getAdapter().a();
                    }
                    j0(iA);
                    return true;
                }
            } else if (layoutManager.d()) {
                int keyCode2 = keyEvent.getKeyCode();
                if (keyCode2 == 92 || keyCode2 == 93) {
                    int measuredWidth = getMeasuredWidth();
                    if (keyCode2 == 93) {
                        i0(measuredWidth, 0, false);
                        return true;
                    }
                    i0(-measuredWidth, 0, false);
                    return true;
                }
                if (keyCode2 == 122 || keyCode2 == 123) {
                    boolean zL2 = layoutManager.L();
                    if (keyCode2 == 122) {
                        if (zL2) {
                            iA = getAdapter().a();
                        }
                    } else if (!zL2) {
                        iA = getAdapter().a();
                    }
                    j0(iA);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f10, boolean z10) {
        return getScrollingChildHelper().a(f, f10, z10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f10) {
        return getScrollingChildHelper().b(f, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i10, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().d(i, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i = 0; i < size; i++) {
            ((f0) arrayList.get(i)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.f1432f0;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.C ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f1432f0;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f1433g0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.C) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1433g0;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f1434h0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.C ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f1434h0;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f1435i0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.C) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1435i0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.f1436j0 == null || arrayList.size() <= 0 || !this.f1436j0.f()) ? z10 : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0(int r19, int r20, android.view.MotionEvent r21, int r22) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e0(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void f0(int i, int i10, int[] iArr) {
        x0 x0Var;
        k0();
        T();
        Trace.beginSection("RV Scroll");
        t0 t0Var = this.B0;
        C(t0Var);
        n0 n0Var = this.f1451x;
        int iQ0 = i != 0 ? this.I.q0(i, n0Var, t0Var) : 0;
        int iS0 = i10 != 0 ? this.I.s0(i10, n0Var, t0Var) : 0;
        Trace.endSection();
        int iV = this.A.v();
        for (int i11 = 0; i11 < iV; i11++) {
            View viewU = this.A.u(i11);
            x0 x0VarL = L(viewU);
            if (x0VarL != null && (x0Var = x0VarL.i) != null) {
                View view = x0Var.f13387a;
                int left = viewU.getLeft();
                int top = viewU.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        U(true);
        m0(false);
        if (iArr != null) {
            iArr[0] = iQ0;
            iArr[1] = iS0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0197 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce A[ADDED_TO_REGION] */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instruction units count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(int i) {
        if (this.S) {
            return;
        }
        o0();
        h0 h0Var = this.I;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h0Var.r0(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h0 h0Var = this.I;
        if (h0Var != null) {
            return h0Var.r();
        }
        throw new IllegalStateException(e.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        h0 h0Var = this.I;
        if (h0Var != null) {
            return h0Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(e.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public z getAdapter() {
        return this.H;
    }

    @Override // android.view.View
    public int getBaseline() {
        h0 h0Var = this.I;
        if (h0Var == null) {
            return super.getBaseline();
        }
        h0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        return super.getChildDrawingOrder(i, i10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.C;
    }

    public y0 getCompatAccessibilityDelegate() {
        return this.I0;
    }

    public d0 getEdgeEffectFactory() {
        return this.f1431e0;
    }

    public e0 getItemAnimator() {
        return this.f1436j0;
    }

    public int getItemDecorationCount() {
        return this.K.size();
    }

    public h0 getLayoutManager() {
        return this.I;
    }

    public int getMaxFlingVelocity() {
        return this.f1446u0;
    }

    public int getMinFlingVelocity() {
        return this.f1445t0;
    }

    public long getNanoTime() {
        if (f1424b1) {
            return System.nanoTime();
        }
        return 0L;
    }

    public j0 getOnFlingListener() {
        return this.f1444s0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1452x0;
    }

    public v4.m0 getRecycledViewPool() {
        return this.f1451x.c();
    }

    public int getScrollState() {
        return this.f1437k0;
    }

    public final void h(x0 x0Var) {
        View view = x0Var.f13387a;
        boolean z10 = view.getParent() == this;
        this.f1451x.m(L(view));
        if (x0Var.j()) {
            this.A.f(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z10) {
            this.A.d(view, -1, true);
            return;
        }
        m mVar = this.A;
        int iIndexOfChild = ((RecyclerView) ((i) mVar.f4600x).f7483w).indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((s0) mVar.f4601y).L(iIndexOfChild);
            mVar.z(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final boolean h0(EdgeEffect edgeEffect, int i, int i10) {
        if (i > 0) {
            return true;
        }
        float fH = w1.d.h(edgeEffect) * i10;
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.f1447v * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d10 = Z0;
        return ((float) (Math.exp((d10 / (d10 - 1.0d)) * dLog) * ((double) f))) < fH;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(f0 f0Var) {
        h0 h0Var = this.I;
        if (h0Var != null) {
            h0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.K;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(f0Var);
        R();
        requestLayout();
    }

    public final void i0(int i, int i10, boolean z10) {
        h0 h0Var = this.I;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.S) {
            return;
        }
        if (!h0Var.d()) {
            i = 0;
        }
        if (!this.I.e()) {
            i10 = 0;
        }
        if (i == 0 && i10 == 0) {
            return;
        }
        if (z10) {
            int i11 = i != 0 ? 1 : 0;
            if (i10 != 0) {
                i11 |= 2;
            }
            getScrollingChildHelper().g(i11, 1);
        }
        this.f1454y0.c(i, i10, Integer.MIN_VALUE, null);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.N;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.S;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f11770d;
    }

    public final void j(k0 k0Var) {
        if (this.D0 == null) {
            this.D0 = new ArrayList();
        }
        this.D0.add(k0Var);
    }

    public final void j0(int i) {
        if (this.S) {
            return;
        }
        h0 h0Var = this.I;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h0Var.B0(this, i);
        }
    }

    public final void k(String str) {
        if (P()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(e.i(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.f1430d0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(e.i(this, new StringBuilder(""))));
        }
    }

    public final void k0() {
        int i = this.Q + 1;
        this.Q = i;
        if (i != 1 || this.S) {
            return;
        }
        this.R = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l0(int i) {
        boolean zD = this.I.d();
        int i10 = zD;
        if (this.I.e()) {
            i10 = (zD ? 1 : 0) | 2;
        }
        getScrollingChildHelper().g(i10, i);
    }

    public final void m() {
        int iY = this.A.y();
        for (int i = 0; i < iY; i++) {
            x0 x0VarM = M(this.A.x(i));
            if (!x0VarM.o()) {
                x0VarM.f13390d = -1;
                x0VarM.f13392g = -1;
            }
        }
        n0 n0Var = this.f1451x;
        ArrayList arrayList = n0Var.f13307a;
        ArrayList arrayList2 = n0Var.f13309c;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            x0 x0Var = (x0) arrayList2.get(i10);
            x0Var.f13390d = -1;
            x0Var.f13392g = -1;
        }
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            x0 x0Var2 = (x0) arrayList.get(i11);
            x0Var2.f13390d = -1;
            x0Var2.f13392g = -1;
        }
        ArrayList arrayList3 = n0Var.f13308b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                x0 x0Var3 = (x0) n0Var.f13308b.get(i12);
                x0Var3.f13390d = -1;
                x0Var3.f13392g = -1;
            }
        }
    }

    public final void m0(boolean z10) {
        if (this.Q < 1) {
            if (W0) {
                throw new IllegalStateException(e.i(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.Q = 1;
        }
        if (!z10 && !this.S) {
            this.R = false;
        }
        if (this.Q == 1) {
            if (z10 && this.R && !this.S && this.I != null && this.H != null) {
                r();
            }
            if (!this.S) {
                this.R = false;
            }
        }
        this.Q--;
    }

    public final void n(int i, int i10) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1432f0;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.f1432f0.onRelease();
            zIsFinished = this.f1432f0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1434h0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f1434h0.onRelease();
            zIsFinished |= this.f1434h0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1433g0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.f1433g0.onRelease();
            zIsFinished |= this.f1433g0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1435i0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.f1435i0.onRelease();
            zIsFinished |= this.f1435i0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final void n0(int i) {
        getScrollingChildHelper().h(i);
    }

    public final void o0() {
        s sVar;
        setScrollState(0);
        w0 w0Var = this.f1454y0;
        w0Var.B.removeCallbacks(w0Var);
        w0Var.f13382x.abortAnimation();
        h0 h0Var = this.I;
        if (h0Var == null || (sVar = h0Var.f13251e) == null) {
            return;
        }
        sVar.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f1429c0 = r0
            r1 = 1
            r5.N = r1
            boolean r2 = r5.P
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.P = r2
            v4.n0 r2 = r5.f1451x
            r2.e()
            v4.h0 r2 = r5.I
            if (r2 == 0) goto L26
            r2.f13252g = r1
            r2.R(r5)
        L26:
            r5.H0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f1424b1
            if (r0 == 0) goto L80
            java.lang.ThreadLocal r0 = v4.l.f13294z
            java.lang.Object r1 = r0.get()
            v4.l r1 = (v4.l) r1
            r5.f1456z0 = r1
            if (r1 != 0) goto L66
            v4.l r1 = new v4.l
            r1.<init>()
            r5.f1456z0 = r1
            java.util.WeakHashMap r1 = t0.m0.f11777a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L58
            if (r1 == 0) goto L58
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L58
            goto L5a
        L58:
            r1 = 1114636288(0x42700000, float:60.0)
        L5a:
            v4.l r2 = r5.f1456z0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f13297x = r3
            r0.set(r2)
        L66:
            v4.l r0 = r5.f1456z0
            java.util.ArrayList r0 = r0.f13295v
            boolean r1 = androidx.recyclerview.widget.RecyclerView.W0
            if (r1 == 0) goto L7d
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L75
            goto L7d
        L75:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L7d:
            r0.add(r5)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        v4.l lVar;
        super.onDetachedFromWindow();
        e0 e0Var = this.f1436j0;
        if (e0Var != null) {
            e0Var.e();
        }
        o0();
        int i = 0;
        this.N = false;
        h0 h0Var = this.I;
        if (h0Var != null) {
            h0Var.f13252g = false;
            h0Var.S(this);
        }
        this.O0.clear();
        removeCallbacks(this.P0);
        this.B.getClass();
        while (f1.f13222d.i() != null) {
        }
        n0 n0Var = this.f1451x;
        ArrayList arrayList = n0Var.f13309c;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            z0.a.a(((x0) arrayList.get(i10)).f13387a);
        }
        n0Var.f(n0Var.f13313h.H, false);
        int i11 = z0.a.f15058a;
        while (i < getChildCount()) {
            int i12 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            int i13 = z0.a.f15058a;
            b bVar = (b) childAt.getTag(i13);
            if (bVar == null) {
                bVar = new b();
                childAt.setTag(i13, bVar);
            }
            ArrayList arrayList2 = bVar.f15060a;
            int iD0 = sd.k.d0(arrayList2);
            if (-1 < iD0) {
                throw q4.a.k(iD0, arrayList2);
            }
            i = i12;
        }
        if (!f1424b1 || (lVar = this.f1456z0) == null) {
            return;
        }
        boolean zRemove = lVar.f13295v.remove(this);
        if (W0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.f1456z0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((f0) arrayList.get(i)).a(this);
        }
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        boolean z10;
        if (this.I != null && !this.S && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f = this.I.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.I.d() ? motionEvent.getAxisValue(10) : 0.0f;
                i = 0;
                z10 = false;
                f = f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.I.e()) {
                    float f10 = -axisValue;
                    axisValue = 0.0f;
                    f = f10;
                } else if (!this.I.d()) {
                    axisValue = 0.0f;
                }
                i = 26;
                z10 = this.T0;
            } else {
                axisValue = 0.0f;
                i = 0;
                z10 = false;
            }
            int i10 = (int) (f * this.f1450w0);
            int i11 = (int) (axisValue * this.f1448v0);
            if (z10) {
                OverScroller overScroller = this.f1454y0.f13382x;
                i0((overScroller.getFinalX() - overScroller.getCurrX()) + i11, (overScroller.getFinalY() - overScroller.getCurrY()) + i10, true);
            } else {
                h0 h0Var = this.I;
                if (h0Var == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.S) {
                    int[] iArr = this.N0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zD = h0Var.d();
                    boolean zE = this.I.e();
                    int i12 = zE ? (zD ? 1 : 0) | 2 : zD ? 1 : 0;
                    float y10 = motionEvent.getY();
                    float x10 = motionEvent.getX();
                    int iB0 = i11 - b0(i11, y10);
                    int iC0 = i10 - c0(i10, x10);
                    getScrollingChildHelper().g(i12, 1);
                    if (u(zD ? iB0 : 0, zE ? iC0 : 0, 1, this.N0, this.L0)) {
                        iB0 -= iArr[0];
                        iC0 -= iArr[1];
                    }
                    e0(zD ? iB0 : 0, zE ? iC0 : 0, motionEvent, 1);
                    v4.l lVar = this.f1456z0;
                    if (lVar != null && (iB0 != 0 || iC0 != 0)) {
                        lVar.a(this, iB0, iC0);
                    }
                    n0(1);
                }
            }
            if (i != 0 && !z10) {
                this.V0.a(motionEvent, i);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        if (!this.S) {
            this.M = null;
            if (E(motionEvent)) {
                VelocityTracker velocityTracker = this.f1439m0;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                n0(0);
                a0();
                setScrollState(0);
                return true;
            }
            h0 h0Var = this.I;
            if (h0Var != null) {
                boolean zD = h0Var.d();
                boolean zE = this.I.e();
                if (this.f1439m0 == null) {
                    this.f1439m0 = VelocityTracker.obtain();
                }
                this.f1439m0.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.T) {
                        this.T = false;
                    }
                    this.f1438l0 = motionEvent.getPointerId(0);
                    int x10 = (int) (motionEvent.getX() + 0.5f);
                    this.f1441p0 = x10;
                    this.f1440n0 = x10;
                    int y10 = (int) (motionEvent.getY() + 0.5f);
                    this.f1442q0 = y10;
                    this.o0 = y10;
                    EdgeEffect edgeEffect = this.f1432f0;
                    if (edgeEffect == null || w1.d.h(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z10 = false;
                    } else {
                        w1.d.q(this.f1432f0, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z10 = true;
                    }
                    EdgeEffect edgeEffect2 = this.f1434h0;
                    if (edgeEffect2 != null && w1.d.h(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        w1.d.q(this.f1434h0, 0.0f, motionEvent.getY() / getHeight());
                        z10 = true;
                    }
                    EdgeEffect edgeEffect3 = this.f1433g0;
                    if (edgeEffect3 != null && w1.d.h(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        w1.d.q(this.f1433g0, 0.0f, motionEvent.getX() / getWidth());
                        z10 = true;
                    }
                    EdgeEffect edgeEffect4 = this.f1435i0;
                    if (edgeEffect4 != null && w1.d.h(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        w1.d.q(this.f1435i0, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z10 = true;
                    }
                    if (z10 || this.f1437k0 == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        n0(1);
                    }
                    int[] iArr = this.M0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    l0(0);
                } else if (actionMasked == 1) {
                    this.f1439m0.clear();
                    n0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1438l0);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1438l0 + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.f1437k0 != 1) {
                        int i = x11 - this.f1440n0;
                        int i10 = y11 - this.o0;
                        if (!zD || Math.abs(i) <= this.f1443r0) {
                            z11 = false;
                        } else {
                            this.f1441p0 = x11;
                            z11 = true;
                        }
                        if (zE && Math.abs(i10) > this.f1443r0) {
                            this.f1442q0 = y11;
                            z11 = true;
                        }
                        if (z11) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    VelocityTracker velocityTracker2 = this.f1439m0;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    n0(0);
                    a0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.f1438l0 = motionEvent.getPointerId(actionIndex);
                    int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f1441p0 = x12;
                    this.f1440n0 = x12;
                    int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f1442q0 = y12;
                    this.o0 = y12;
                } else if (actionMasked == 6) {
                    V(motionEvent);
                }
                if (this.f1437k0 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        Trace.beginSection("RV OnLayout");
        r();
        Trace.endSection();
        this.P = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        h0 h0Var = this.I;
        if (h0Var == null) {
            q(i, i10);
            return;
        }
        boolean zK = h0Var.K();
        boolean z10 = false;
        t0 t0Var = this.B0;
        if (zK) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.I.f13248b.q(i, i10);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.Q0 = z10;
            if (z10 || this.H == null) {
                return;
            }
            if (t0Var.f13364d == 1) {
                s();
            }
            this.I.u0(i, i10);
            t0Var.i = true;
            t();
            this.I.w0(i, i10);
            if (this.I.z0()) {
                this.I.u0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                t0Var.i = true;
                t();
                this.I.w0(i, i10);
            }
            this.R0 = getMeasuredWidth();
            this.S0 = getMeasuredHeight();
            return;
        }
        if (this.O) {
            this.I.f13248b.q(i, i10);
            return;
        }
        if (this.V) {
            k0();
            T();
            X();
            U(true);
            if (t0Var.f13369k) {
                t0Var.f13366g = true;
            } else {
                this.f1455z.f();
                t0Var.f13366g = false;
            }
            this.V = false;
            m0(false);
        } else if (t0Var.f13369k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        z zVar = this.H;
        if (zVar != null) {
            t0Var.f13365e = zVar.a();
        } else {
            t0Var.f13365e = 0;
        }
        k0();
        this.I.f13248b.q(i, i10);
        m0(false);
        t0Var.f13366g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (P()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof q0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q0 q0Var = (q0) parcelable;
        this.f1453y = q0Var;
        super.onRestoreInstanceState(q0Var.f112v);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        q0 q0Var = new q0(super.onSaveInstanceState());
        q0 q0Var2 = this.f1453y;
        if (q0Var2 != null) {
            q0Var.f13336x = q0Var2.f13336x;
            return q0Var;
        }
        h0 h0Var = this.I;
        if (h0Var != null) {
            q0Var.f13336x = h0Var.h0();
            return q0Var;
        }
        q0Var.f13336x = null;
        return q0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        if (i == i11 && i10 == i12) {
            return;
        }
        this.f1435i0 = null;
        this.f1433g0 = null;
        this.f1434h0 = null;
        this.f1432f0 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x020b A[PHI: r1
      0x020b: PHI (r1v50 int) = (r1v34 int), (r1v54 int) binds: [B:95:0x01f4, B:99:0x0207] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0224  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (!this.P || this.f1427a0) {
            Trace.beginSection("RV FullInvalidate");
            r();
            Trace.endSection();
            return;
        }
        if (this.f1455z.y()) {
            ff.k kVar = this.f1455z;
            int i = kVar.f4586a;
            if ((i & 4) == 0 || (i & 11) != 0) {
                if (kVar.y()) {
                    Trace.beginSection("RV FullInvalidate");
                    r();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            k0();
            T();
            this.f1455z.E();
            if (!this.R) {
                int iV = this.A.v();
                int i10 = 0;
                while (true) {
                    if (i10 < iV) {
                        x0 x0VarM = M(this.A.u(i10));
                        if (x0VarM != null && !x0VarM.o() && x0VarM.k()) {
                            r();
                            break;
                        }
                        i10++;
                    } else {
                        this.f1455z.e();
                        break;
                    }
                }
            }
            m0(true);
            U(true);
            Trace.endSection();
        }
    }

    public final void q(int i, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = m0.f11777a;
        setMeasuredDimension(h0.g(i, paddingRight, getMinimumWidth()), h0.g(i10, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03aa  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r():void");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z10) {
        x0 x0VarM = M(view);
        if (x0VarM != null) {
            if (x0VarM.j()) {
                x0VarM.f13394j &= -257;
            } else if (!x0VarM.o()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(x0VarM);
                throw new IllegalArgumentException(e.i(this, sb));
            }
        } else if (W0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(e.i(this, sb2));
        }
        view.clearAnimation();
        M(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        s sVar = this.I.f13251e;
        if ((sVar == null || !sVar.f13350e) && !P() && view2 != null) {
            d0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.I.o0(this, view, rect, z10, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        ArrayList arrayList = this.L;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((j) arrayList.get(i)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.Q != 0 || this.S) {
            this.R = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.s():void");
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i10) {
        h0 h0Var = this.I;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.S) {
            return;
        }
        boolean zD = h0Var.d();
        boolean zE = this.I.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i10 = 0;
            }
            e0(i, i10, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!P()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.U |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(y0 y0Var) {
        this.I0 = y0Var;
        m0.n(this, y0Var);
    }

    public void setAdapter(z zVar) {
        setLayoutFrozen(false);
        z zVar2 = this.H;
        p0 p0Var = this.f1449w;
        if (zVar2 != null) {
            zVar2.f13407a.unregisterObserver(p0Var);
            this.H.getClass();
        }
        e0 e0Var = this.f1436j0;
        if (e0Var != null) {
            e0Var.e();
        }
        h0 h0Var = this.I;
        n0 n0Var = this.f1451x;
        if (h0Var != null) {
            h0Var.k0(n0Var);
            this.I.l0(n0Var);
        }
        n0Var.f13307a.clear();
        n0Var.g();
        ff.k kVar = this.f1455z;
        kVar.F((ArrayList) kVar.f4588c);
        kVar.F((ArrayList) kVar.f4589d);
        kVar.f4586a = 0;
        z zVar3 = this.H;
        this.H = zVar;
        if (zVar != null) {
            zVar.f13407a.registerObserver(p0Var);
        }
        h0 h0Var2 = this.I;
        if (h0Var2 != null) {
            h0Var2.Q();
        }
        z zVar4 = this.H;
        n0Var.f13307a.clear();
        n0Var.g();
        n0Var.f(zVar3, true);
        v4.m0 m0VarC = n0Var.c();
        if (zVar3 != null) {
            m0VarC.f13304b--;
        }
        if (m0VarC.f13304b == 0) {
            SparseArray sparseArray = m0VarC.f13303a;
            for (int i = 0; i < sparseArray.size(); i++) {
                l0 l0Var = (l0) sparseArray.valueAt(i);
                ArrayList arrayList = l0Var.f13299a;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    z0.a.a(((x0) obj).f13387a);
                }
                l0Var.f13299a.clear();
            }
        }
        if (zVar4 != null) {
            m0VarC.f13304b++;
        }
        n0Var.e();
        this.B0.f = true;
        Y(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(c0 c0Var) {
        if (c0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.C) {
            this.f1435i0 = null;
            this.f1433g0 = null;
            this.f1434h0 = null;
            this.f1432f0 = null;
        }
        this.C = z10;
        super.setClipToPadding(z10);
        if (this.P) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(d0 d0Var) {
        d0Var.getClass();
        this.f1431e0 = d0Var;
        this.f1435i0 = null;
        this.f1433g0 = null;
        this.f1434h0 = null;
        this.f1432f0 = null;
    }

    public void setHasFixedSize(boolean z10) {
        this.O = z10;
    }

    public void setItemAnimator(e0 e0Var) {
        e0 e0Var2 = this.f1436j0;
        if (e0Var2 != null) {
            e0Var2.e();
            this.f1436j0.f13212a = null;
        }
        this.f1436j0 = e0Var;
        if (e0Var != null) {
            e0Var.f13212a = this.G0;
        }
    }

    public void setItemViewCacheSize(int i) {
        n0 n0Var = this.f1451x;
        n0Var.f13311e = i;
        n0Var.n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(h0 h0Var) {
        if (h0Var == this.I) {
            return;
        }
        o0();
        h0 h0Var2 = this.I;
        n0 n0Var = this.f1451x;
        if (h0Var2 != null) {
            e0 e0Var = this.f1436j0;
            if (e0Var != null) {
                e0Var.e();
            }
            this.I.k0(n0Var);
            this.I.l0(n0Var);
            n0Var.f13307a.clear();
            n0Var.g();
            if (this.N) {
                h0 h0Var3 = this.I;
                h0Var3.f13252g = false;
                h0Var3.S(this);
            }
            this.I.x0(null);
            this.I = null;
        } else {
            n0Var.f13307a.clear();
            n0Var.g();
        }
        m mVar = this.A;
        RecyclerView recyclerView = (RecyclerView) ((i) mVar.f4600x).f7483w;
        ((s0) mVar.f4601y).K();
        ArrayList arrayList = (ArrayList) mVar.f4602z;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x0 x0VarM = M((View) arrayList.get(size));
            if (x0VarM != null) {
                int i = x0VarM.f13400p;
                if (recyclerView.P()) {
                    x0VarM.f13401q = i;
                    recyclerView.O0.add(x0VarM);
                } else {
                    x0VarM.f13387a.setImportantForAccessibility(i);
                }
                x0VarM.f13400p = 0;
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            M(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.I = h0Var;
        if (h0Var != null) {
            if (h0Var.f13248b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(h0Var);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(e.i(h0Var.f13248b, sb));
            }
            h0Var.x0(this);
            if (this.N) {
                h0 h0Var4 = this.I;
                h0Var4.f13252g = true;
                h0Var4.R(this);
            }
        }
        n0Var.n();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        l scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f11770d) {
            ViewGroup viewGroup = scrollingChildHelper.f11769c;
            WeakHashMap weakHashMap = m0.f11777a;
            t0.d0.m(viewGroup);
        }
        scrollingChildHelper.f11770d = z10;
    }

    public void setOnFlingListener(j0 j0Var) {
        this.f1444s0 = j0Var;
    }

    @Deprecated
    public void setOnScrollListener(k0 k0Var) {
        this.C0 = k0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f1452x0 = z10;
    }

    public void setRecycledViewPool(v4.m0 m0Var) {
        n0 n0Var = this.f1451x;
        RecyclerView recyclerView = n0Var.f13313h;
        n0Var.f(recyclerView.H, false);
        if (n0Var.f13312g != null) {
            r2.f13304b--;
        }
        n0Var.f13312g = m0Var;
        if (m0Var != null && recyclerView.getAdapter() != null) {
            n0Var.f13312g.f13304b++;
        }
        n0Var.e();
    }

    public void setScrollState(int i) {
        s sVar;
        if (i == this.f1437k0) {
            return;
        }
        if (X0) {
            StringBuilder sbM = e.m(i, "setting scroll state to ", " from ");
            sbM.append(this.f1437k0);
            Log.d("RecyclerView", sbM.toString(), new Exception());
        }
        this.f1437k0 = i;
        if (i != 2) {
            w0 w0Var = this.f1454y0;
            w0Var.B.removeCallbacks(w0Var);
            w0Var.f13382x.abortAnimation();
            h0 h0Var = this.I;
            if (h0Var != null && (sVar = h0Var.f13251e) != null) {
                sVar.i();
            }
        }
        h0 h0Var2 = this.I;
        if (h0Var2 != null) {
            h0Var2.i0(i);
        }
        k0 k0Var = this.C0;
        if (k0Var != null) {
            k0Var.a(i);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k0) this.D0.get(size)).a(i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.f1443r0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.f1443r0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(v0 v0Var) {
        this.f1451x.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.S) {
            k("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.S = true;
                this.T = true;
                o0();
                return;
            }
            this.S = false;
            if (this.R && this.I != null && this.H != null) {
                requestLayout();
            }
            this.R = false;
        }
    }

    public final void t() {
        k0();
        T();
        t0 t0Var = this.B0;
        t0Var.a(6);
        this.f1455z.f();
        t0Var.f13365e = this.H.a();
        t0Var.f13363c = 0;
        if (this.f1453y != null) {
            z zVar = this.H;
            int iC = y.e.c(zVar.f13409c);
            if (iC == 1 ? zVar.a() > 0 : iC != 2) {
                Parcelable parcelable = this.f1453y.f13336x;
                if (parcelable != null) {
                    this.I.g0(parcelable);
                }
                this.f1453y = null;
            }
        }
        t0Var.f13366g = false;
        this.I.e0(this.f1451x, t0Var);
        t0Var.f = false;
        t0Var.f13368j = t0Var.f13368j && this.f1436j0 != null;
        t0Var.f13364d = 4;
        U(true);
        m0(false);
    }

    public final boolean u(int i, int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i10, i11, iArr, iArr2);
    }

    public final void v(int i, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().d(i, i10, i11, i12, iArr, i13, iArr2);
    }

    public final void w(int i, int i10) {
        this.f1430d0++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i10);
        k0 k0Var = this.C0;
        if (k0Var != null) {
            k0Var.b(this, i, i10);
        }
        ArrayList arrayList = this.D0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k0) this.D0.get(size)).b(this, i, i10);
            }
        }
        this.f1430d0--;
    }

    public final void x() {
        if (this.f1435i0 != null) {
            return;
        }
        ((u0) this.f1431e0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1435i0 = edgeEffect;
        if (this.C) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void y() {
        if (this.f1432f0 != null) {
            return;
        }
        ((u0) this.f1431e0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1432f0 = edgeEffect;
        if (this.C) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void z() {
        if (this.f1434h0 != null) {
            return;
        }
        ((u0) this.f1431e0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1434h0 = edgeEffect;
        if (this.C) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float fA;
        char c9;
        char c10;
        TypedArray typedArray;
        Constructor constructor;
        super(context, attributeSet, i);
        this.f1449w = new p0(this);
        this.f1451x = new n0(this);
        this.B = new w(29);
        this.D = new v4.w(this, 0);
        this.E = new Rect();
        this.F = new Rect();
        this.G = new RectF();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.Q = 0;
        this.f1427a0 = false;
        this.f1428b0 = false;
        this.f1429c0 = 0;
        this.f1430d0 = 0;
        this.f1431e0 = f1426e1;
        v4.h hVar = new v4.h();
        Object[] objArr = null;
        hVar.f13212a = null;
        hVar.f13213b = new ArrayList();
        hVar.f13214c = 120L;
        hVar.f13215d = 120L;
        hVar.f13216e = 250L;
        hVar.f = 250L;
        int i10 = 1;
        hVar.f13236g = true;
        hVar.f13237h = new ArrayList();
        hVar.i = new ArrayList();
        hVar.f13238j = new ArrayList();
        hVar.f13239k = new ArrayList();
        hVar.f13240l = new ArrayList();
        hVar.f13241m = new ArrayList();
        hVar.f13242n = new ArrayList();
        hVar.f13243o = new ArrayList();
        hVar.f13244p = new ArrayList();
        hVar.f13245q = new ArrayList();
        hVar.f13246r = new ArrayList();
        this.f1436j0 = hVar;
        this.f1437k0 = 0;
        this.f1438l0 = -1;
        this.f1448v0 = Float.MIN_VALUE;
        this.f1450w0 = Float.MIN_VALUE;
        this.f1452x0 = true;
        this.f1454y0 = new w0(this);
        this.A0 = f1424b1 ? new g() : null;
        t0 t0Var = new t0();
        t0Var.f13361a = -1;
        t0Var.f13362b = 0;
        t0Var.f13363c = 0;
        t0Var.f13364d = 1;
        t0Var.f13365e = 0;
        t0Var.f = false;
        t0Var.f13366g = false;
        t0Var.f13367h = false;
        t0Var.i = false;
        t0Var.f13368j = false;
        t0Var.f13369k = false;
        this.B0 = t0Var;
        this.E0 = false;
        this.F0 = false;
        y yVar = new y(this);
        this.G0 = yVar;
        this.H0 = false;
        this.J0 = new int[2];
        this.L0 = new int[2];
        this.M0 = new int[2];
        this.N0 = new int[2];
        this.O0 = new ArrayList();
        this.P0 = new v4.w(this, i10);
        this.R0 = 0;
        this.S0 = 0;
        this.U0 = new x(this);
        this.V0 = new t0.g(getContext(), new y(this));
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1443r0 = viewConfiguration.getScaledTouchSlop();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            Method method = t0.n0.f11784a;
            fA = d1.a.b(viewConfiguration);
        } else {
            fA = t0.n0.a(viewConfiguration, context);
        }
        this.f1448v0 = fA;
        this.f1450w0 = i11 >= 26 ? d1.a.c(viewConfiguration) : t0.n0.a(viewConfiguration, context);
        this.f1445t0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1446u0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1447v = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f1436j0.f13212a = yVar;
        this.f1455z = new ff.k(new x(this));
        this.A = new m(new i(21, this));
        WeakHashMap weakHashMap = m0.f11777a;
        if ((i11 >= 26 ? g0.a(this) : 0) == 0 && i11 >= 26) {
            g0.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.W = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new y0(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.RecyclerView, i, 0);
        m0.m(this, context, c.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i);
        String string = typedArrayObtainStyledAttributes.getString(c.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.C = typedArrayObtainStyledAttributes.getBoolean(c.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(c.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(c.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(c.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(c.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(c.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(e.i(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c10 = 2;
            c9 = 1;
            typedArray = typedArrayObtainStyledAttributes;
            new j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(u4.b.fastscroll_default_thickness), resources.getDimensionPixelSize(u4.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(u4.b.fastscroll_margin));
        } else {
            c9 = 1;
            c10 = 2;
            typedArray = typedArrayObtainStyledAttributes;
        }
        typedArray.recycle();
        this.T0 = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(h0.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(c1);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[c9] = attributeSet;
                        objArr2[c10] = Integer.valueOf(i);
                        objArr2[3] = 0;
                        objArr = objArr2;
                        constructor = constructor2;
                    } catch (NoSuchMethodException e9) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e10) {
                            e10.initCause(e9);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e10);
                        }
                    }
                    constructor.setAccessible(c9);
                    setLayoutManager((h0) constructor.newInstance(objArr));
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e12);
                } catch (IllegalAccessException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e14);
                } catch (InvocationTargetException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                }
            }
        }
        int[] iArr = Y0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        m0.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i);
        boolean z10 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z10);
        setTag(z0.a.f15059b, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        h0 h0Var = this.I;
        if (h0Var != null) {
            return h0Var.t(layoutParams);
        }
        throw new IllegalStateException(e.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Deprecated
    public void setRecyclerListener(o0 o0Var) {
    }
}
