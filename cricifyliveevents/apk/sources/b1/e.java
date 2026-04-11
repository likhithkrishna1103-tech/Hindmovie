package b1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.fragment.app.m;
import java.util.Arrays;
import java.util.WeakHashMap;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f1649x = new d(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1651b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f1653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f1654e;
    public float[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f1655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f1656h;
    public int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f1657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f1659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f1660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final OverScroller f1665r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final n5.a f1666s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f1667t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1668u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f1669v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1652c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final m f1670w = new m(3, this);

    public e(Context context, ViewGroup viewGroup, n5.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1669v = viewGroup;
        this.f1666s = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1663p = i;
        this.f1662o = i;
        this.f1651b = viewConfiguration.getScaledTouchSlop();
        this.f1660m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1661n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1665r = new OverScroller(context, f1649x);
    }

    public final void a() {
        this.f1652c = -1;
        float[] fArr = this.f1653d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1654e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.f1655g, 0.0f);
            Arrays.fill(this.f1656h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.f1657j, 0);
            this.f1658k = 0;
        }
        VelocityTracker velocityTracker = this.f1659l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1659l = null;
        }
    }

    public final void b(View view, int i) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f1669v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f1667t = view;
        this.f1652c = i;
        this.f1666s.A(view, i);
        p(1);
    }

    public final boolean c(float f, float f10, int i, int i10) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f10);
        if ((this.f1656h[i] & i10) != i10 || (this.f1664q & i10) == 0 || (this.f1657j[i] & i10) == i10 || (this.i[i] & i10) == i10) {
            return false;
        }
        float f11 = this.f1651b;
        if (fAbs <= f11 && fAbs2 <= f11) {
            return false;
        }
        if (fAbs < fAbs2 * 0.5f) {
            this.f1666s.getClass();
        }
        return (this.i[i] & i10) == 0 && fAbs > ((float) this.f1651b);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            n5.a r1 = r3.f1666s
            int r4 = r1.r(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.s()
            if (r1 <= 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r0
        L19:
            if (r4 == 0) goto L29
            if (r1 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f1651b
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f1651b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f1651b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.d(android.view.View, float, float):boolean");
    }

    public final void e(int i) {
        float[] fArr = this.f1653d;
        if (fArr != null) {
            int i10 = this.f1658k;
            int i11 = 1 << i;
            if ((i10 & i11) != 0) {
                fArr[i] = 0.0f;
                this.f1654e[i] = 0.0f;
                this.f[i] = 0.0f;
                this.f1655g[i] = 0.0f;
                this.f1656h[i] = 0;
                this.i[i] = 0;
                this.f1657j[i] = 0;
                this.f1658k = (~i11) & i10;
            }
        }
    }

    public final int f(int i, int i10, int i11) {
        if (i == 0) {
            return 0;
        }
        float width = this.f1669v.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i10);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i11) + 1.0f) * 256.0f), 600);
    }

    public final boolean g() {
        if (this.f1650a == 2) {
            OverScroller overScroller = this.f1665r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f1667t.getLeft();
            int top = currY - this.f1667t.getTop();
            if (left != 0) {
                View view = this.f1667t;
                WeakHashMap weakHashMap = m0.f11777a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f1667t;
                WeakHashMap weakHashMap2 = m0.f11777a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f1666s.C(this.f1667t, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f1669v.post(this.f1670w);
            }
        }
        return this.f1650a == 2;
    }

    public final View h(int i, int i10) {
        ViewGroup viewGroup = this.f1669v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f1666s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i10 >= childAt.getTop() && i10 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean i(int i, int i10, int i11, int i12) {
        float f;
        float f10;
        float f11;
        float f12;
        int left = this.f1667t.getLeft();
        int top = this.f1667t.getTop();
        int i13 = i - left;
        int i14 = i10 - top;
        OverScroller overScroller = this.f1665r;
        if (i13 == 0 && i14 == 0) {
            overScroller.abortAnimation();
            p(0);
            return false;
        }
        View view = this.f1667t;
        int i15 = (int) this.f1661n;
        int i16 = (int) this.f1660m;
        int iAbs = Math.abs(i11);
        if (iAbs < i15) {
            i11 = 0;
        } else if (iAbs > i16) {
            i11 = i11 > 0 ? i16 : -i16;
        }
        int i17 = (int) this.f1661n;
        int iAbs2 = Math.abs(i12);
        if (iAbs2 < i17) {
            i12 = 0;
        } else if (iAbs2 > i16) {
            i12 = i12 > 0 ? i16 : -i16;
        }
        int iAbs3 = Math.abs(i13);
        int iAbs4 = Math.abs(i14);
        int iAbs5 = Math.abs(i11);
        int iAbs6 = Math.abs(i12);
        int i18 = iAbs5 + iAbs6;
        int i19 = iAbs3 + iAbs4;
        if (i11 != 0) {
            f = iAbs5;
            f10 = i18;
        } else {
            f = iAbs3;
            f10 = i19;
        }
        float f13 = f / f10;
        if (i12 != 0) {
            f11 = iAbs6;
            f12 = i18;
        } else {
            f11 = iAbs4;
            f12 = i19;
        }
        float f14 = f11 / f12;
        n5.a aVar = this.f1666s;
        overScroller.startScroll(left, top, i13, i14, (int) ((f(i14, i12, aVar.s()) * f14) + (f(i13, i11, aVar.r(view)) * f13)));
        p(2);
        return true;
    }

    public final boolean j(int i) {
        if ((this.f1658k & (1 << i)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1659l == null) {
            this.f1659l = VelocityTracker.obtain();
        }
        this.f1659l.addMovement(motionEvent);
        n5.a aVar = this.f1666s;
        int i10 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewH = h((int) x10, (int) y10);
            n(x10, y10, pointerId);
            t(viewH, pointerId);
            if ((this.f1656h[pointerId] & this.f1664q) != 0) {
                aVar.z();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1650a == 1) {
                l();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1650a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i10 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i10);
                    if (j(pointerId2)) {
                        float x11 = motionEvent.getX(i10);
                        float y11 = motionEvent.getY(i10);
                        float f = x11 - this.f1653d[pointerId2];
                        float f10 = y11 - this.f1654e[pointerId2];
                        m(f, f10, pointerId2);
                        if (this.f1650a != 1) {
                            View viewH2 = h((int) x11, (int) y11);
                            if (d(viewH2, f, f10) && t(viewH2, pointerId2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i10++;
                }
                o(motionEvent);
                return;
            }
            if (j(this.f1652c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1652c);
                float x12 = motionEvent.getX(iFindPointerIndex);
                float y12 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f;
                int i11 = this.f1652c;
                int i12 = (int) (x12 - fArr[i11]);
                int i13 = (int) (y12 - this.f1655g[i11]);
                int left = this.f1667t.getLeft() + i12;
                int top = this.f1667t.getTop() + i13;
                int left2 = this.f1667t.getLeft();
                int top2 = this.f1667t.getTop();
                if (i12 != 0) {
                    left = aVar.d(this.f1667t, left);
                    WeakHashMap weakHashMap = m0.f11777a;
                    this.f1667t.offsetLeftAndRight(left - left2);
                }
                if (i13 != 0) {
                    top = aVar.e(this.f1667t, top);
                    WeakHashMap weakHashMap2 = m0.f11777a;
                    this.f1667t.offsetTopAndBottom(top - top2);
                }
                if (i12 != 0 || i13 != 0) {
                    aVar.C(this.f1667t, left, top);
                }
                o(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f1650a == 1) {
                this.f1668u = true;
                aVar.D(this.f1667t, 0.0f, 0.0f);
                this.f1668u = false;
                if (this.f1650a == 1) {
                    p(0);
                }
            }
            a();
            return;
        }
        if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f1650a == 1 && pointerId3 == this.f1652c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i10 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i10);
                    if (pointerId4 != this.f1652c) {
                        View viewH3 = h((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                        View view = this.f1667t;
                        if (viewH3 == view && t(view, pointerId4)) {
                            i = this.f1652c;
                            break;
                        }
                    }
                    i10++;
                }
                if (i == -1) {
                    l();
                }
            }
            e(pointerId3);
            return;
        }
        int pointerId5 = motionEvent.getPointerId(actionIndex);
        float x13 = motionEvent.getX(actionIndex);
        float y13 = motionEvent.getY(actionIndex);
        n(x13, y13, pointerId5);
        if (this.f1650a == 0) {
            t(h((int) x13, (int) y13), pointerId5);
            if ((this.f1656h[pointerId5] & this.f1664q) != 0) {
                aVar.z();
                return;
            }
            return;
        }
        int i14 = (int) x13;
        int i15 = (int) y13;
        View view2 = this.f1667t;
        if (view2 != null && i14 >= view2.getLeft() && i14 < view2.getRight() && i15 >= view2.getTop() && i15 < view2.getBottom()) {
            i10 = 1;
        }
        if (i10 != 0) {
            t(this.f1667t, pointerId5);
        }
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f1659l;
        float f = this.f1660m;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.f1659l.getXVelocity(this.f1652c);
        float f10 = this.f1661n;
        float fAbs = Math.abs(xVelocity);
        if (fAbs < f10) {
            xVelocity = 0.0f;
        } else if (fAbs > f) {
            xVelocity = xVelocity > 0.0f ? f : -f;
        }
        float yVelocity = this.f1659l.getYVelocity(this.f1652c);
        float f11 = this.f1661n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f11) {
            f = 0.0f;
        } else if (fAbs2 <= f) {
            f = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f = -f;
        }
        this.f1668u = true;
        this.f1666s.D(this.f1667t, xVelocity, f);
        this.f1668u = false;
        if (this.f1650a == 1) {
            p(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [n5.a] */
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
    public final void m(float f, float f10, int i) {
        boolean zC = c(f, f10, i, 1);
        ?? r02 = zC;
        if (c(f10, f, i, 4)) {
            r02 = (zC ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (c(f, f10, i, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (c(f10, f, i, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | r04;
            this.f1666s.y(r04, i);
        }
    }

    public final void n(float f, float f10, int i) {
        float[] fArr = this.f1653d;
        if (fArr == null || fArr.length <= i) {
            int i10 = i + 1;
            float[] fArr2 = new float[i10];
            float[] fArr3 = new float[i10];
            float[] fArr4 = new float[i10];
            float[] fArr5 = new float[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1654e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1655g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1656h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1657j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1653d = fArr2;
            this.f1654e = fArr3;
            this.f = fArr4;
            this.f1655g = fArr5;
            this.f1656h = iArr;
            this.i = iArr2;
            this.f1657j = iArr3;
        }
        float[] fArr9 = this.f1653d;
        this.f[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.f1654e;
        this.f1655g[i] = f10;
        fArr10[i] = f10;
        int[] iArr7 = this.f1656h;
        int i11 = (int) f;
        int i12 = (int) f10;
        ViewGroup viewGroup = this.f1669v;
        int i13 = i11 < viewGroup.getLeft() + this.f1662o ? 1 : 0;
        if (i12 < viewGroup.getTop() + this.f1662o) {
            i13 |= 4;
        }
        if (i11 > viewGroup.getRight() - this.f1662o) {
            i13 |= 2;
        }
        if (i12 > viewGroup.getBottom() - this.f1662o) {
            i13 |= 8;
        }
        iArr7[i] = i13;
        this.f1658k |= 1 << i;
    }

    public final void o(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (j(pointerId)) {
                float x10 = motionEvent.getX(i);
                float y10 = motionEvent.getY(i);
                this.f[pointerId] = x10;
                this.f1655g[pointerId] = y10;
            }
        }
    }

    public final void p(int i) {
        this.f1669v.removeCallbacks(this.f1670w);
        if (this.f1650a != i) {
            this.f1650a = i;
            this.f1666s.B(i);
            if (this.f1650a == 0) {
                this.f1667t = null;
            }
        }
    }

    public final boolean q(int i, int i10) {
        if (this.f1668u) {
            return i(i, i10, (int) this.f1659l.getXVelocity(this.f1652c), (int) this.f1659l.getYVelocity(this.f1652c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.e.r(android.view.MotionEvent):boolean");
    }

    public final boolean s(View view, int i, int i10) {
        this.f1667t = view;
        this.f1652c = -1;
        boolean zI = i(i, i10, 0, 0);
        if (!zI && this.f1650a == 0 && this.f1667t != null) {
            this.f1667t = null;
        }
        return zI;
    }

    public final boolean t(View view, int i) {
        if (view == this.f1667t && this.f1652c == i) {
            return true;
        }
        if (view == null || !this.f1666s.N(view, i)) {
            return false;
        }
        this.f1652c = i;
        b(view, i);
        return true;
    }
}
