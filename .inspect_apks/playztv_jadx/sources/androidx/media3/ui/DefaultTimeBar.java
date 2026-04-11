package androidx.media3.ui;

import a2.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import i4.h;
import i4.n0;
import i4.s;
import i4.u0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import p1.f1;
import p1.w0;
import s1.b0;
import s1.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class DefaultTimeBar extends View implements u0 {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final /* synthetic */ int f1593m0 = 0;
    public final Paint A;
    public final Paint B;
    public final Paint C;
    public final Paint D;
    public final Drawable E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final StringBuilder O;
    public final Formatter P;
    public final a Q;
    public final CopyOnWriteArraySet R;
    public final Point S;
    public final float T;
    public int U;
    public long V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Rect f1594a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final ValueAnimator f1595b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f1596c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f1597d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1598e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f1599f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f1600g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f1601h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public long f1602i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f1603j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public long[] f1604k0;
    public boolean[] l0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f1605u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f1606v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f1607w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f1608x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f1609y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f1610z;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, attributeSet, 0);
    }

    public static int a(int i, float f) {
        return (int) ((i * f) + 0.5f);
    }

    private long getPositionIncrement() {
        long j5 = this.V;
        if (j5 != -9223372036854775807L) {
            return j5;
        }
        long j8 = this.f1600g0;
        if (j8 == -9223372036854775807L) {
            return 0L;
        }
        return j8 / ((long) this.U);
    }

    private String getProgressText() {
        return b0.C(this.O, this.P, this.f1601h0);
    }

    private long getScrubberPosition() {
        Rect rect = this.f1606v;
        if (rect.width() <= 0 || this.f1600g0 == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.f1608x.width()) * this.f1600g0) / ((long) rect.width());
    }

    public final boolean b(long j5) {
        long j8 = this.f1600g0;
        if (j8 <= 0) {
            return false;
        }
        long j10 = this.f1598e0 ? this.f1599f0 : this.f1601h0;
        long j11 = b0.j(j10 + j5, 0L, j8);
        if (j11 == j10) {
            return false;
        }
        if (this.f1598e0) {
            f(j11);
        } else {
            c(j11);
        }
        e();
        return true;
    }

    public final void c(long j5) {
        this.f1599f0 = j5;
        this.f1598e0 = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.R.iterator();
        while (it.hasNext()) {
            s sVar = ((h) it.next()).f6226u;
            sVar.I0 = true;
            TextView textView = sVar.f6259a0;
            if (textView != null) {
                textView.setText(b0.C(sVar.f6261c0, sVar.f6262d0, j5));
            }
            sVar.f6278u.f();
        }
    }

    public final void d(boolean z2) {
        w0 w0Var;
        removeCallbacks(this.Q);
        this.f1598e0 = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        for (h hVar : this.R) {
            long j5 = this.f1599f0;
            s sVar = hVar.f6226u;
            sVar.I0 = false;
            if (!z2 && (w0Var = sVar.B0) != null) {
                if (sVar.H0) {
                    if (w0Var.e0(17) && w0Var.e0(10)) {
                        f1 f1VarW0 = w0Var.w0();
                        int iO = f1VarW0.o();
                        int i = 0;
                        while (true) {
                            long jB0 = b0.b0(f1VarW0.m(i, sVar.f6264f0, 0L).f9723m);
                            if (j5 < jB0) {
                                break;
                            }
                            if (i == iO - 1) {
                                j5 = jB0;
                                break;
                            } else {
                                j5 -= jB0;
                                i++;
                            }
                        }
                        w0Var.u(i, j5);
                    }
                } else if (w0Var.e0(5)) {
                    w0Var.F0(j5);
                }
                sVar.o();
            }
            sVar.f6278u.g();
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.E;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e() {
        Rect rect = this.f1607w;
        Rect rect2 = this.f1606v;
        rect.set(rect2);
        Rect rect3 = this.f1608x;
        rect3.set(rect2);
        long j5 = this.f1598e0 ? this.f1599f0 : this.f1601h0;
        if (this.f1600g0 > 0) {
            rect.right = Math.min(rect2.left + ((int) ((((long) rect2.width()) * this.f1602i0) / this.f1600g0)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((((long) rect2.width()) * j5) / this.f1600g0)), rect2.right);
        } else {
            int i = rect2.left;
            rect.right = i;
            rect3.right = i;
        }
        invalidate(this.f1605u);
    }

    public final void f(long j5) {
        if (this.f1599f0 == j5) {
            return;
        }
        this.f1599f0 = j5;
        Iterator it = this.R.iterator();
        while (it.hasNext()) {
            s sVar = ((h) it.next()).f6226u;
            TextView textView = sVar.f6259a0;
            if (textView != null) {
                textView.setText(b0.C(sVar.f6261c0, sVar.f6262d0, j5));
            }
        }
    }

    @Override // i4.u0
    public long getPreferredUpdateDelay() {
        int iWidth = (int) (this.f1606v.width() / this.T);
        if (iWidth == 0) {
            return Long.MAX_VALUE;
        }
        long j5 = this.f1600g0;
        if (j5 == 0 || j5 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j5 / ((long) iWidth);
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.E;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Rect rect = this.f1606v;
        int iHeight = rect.height();
        int iCenterY = rect.centerY() - (iHeight / 2);
        int i = iCenterY + iHeight;
        long j5 = this.f1600g0;
        Paint paint = this.A;
        Rect rect2 = this.f1608x;
        if (j5 <= 0) {
            canvas2 = canvas;
            canvas2.drawRect(rect.left, iCenterY, rect.right, i, paint);
        } else {
            Rect rect3 = this.f1607w;
            int i10 = rect3.left;
            int i11 = rect3.right;
            int iMax = Math.max(Math.max(rect.left, i11), rect2.right);
            int i12 = rect.right;
            if (iMax < i12) {
                canvas.drawRect(iMax, iCenterY, i12, i, paint);
            }
            int iMax2 = Math.max(i10, rect2.right);
            if (i11 > iMax2) {
                canvas.drawRect(iMax2, iCenterY, i11, i, this.f1610z);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, iCenterY, rect2.right, i, this.f1609y);
            }
            if (this.f1603j0 != 0) {
                long[] jArr = this.f1604k0;
                jArr.getClass();
                boolean[] zArr = this.l0;
                zArr.getClass();
                int i13 = this.I;
                int i14 = i13 / 2;
                int i15 = 0;
                int i16 = 0;
                while (i16 < this.f1603j0) {
                    int i17 = i16;
                    canvas.drawRect(Math.min(rect.width() - i13, Math.max(i15, ((int) ((((long) rect.width()) * b0.j(jArr[i16], 0L, this.f1600g0)) / this.f1600g0)) - i14)) + rect.left, iCenterY, r3 + i13, i, zArr[i16] ? this.C : this.B);
                    i16 = i17 + 1;
                    i15 = i15;
                }
            }
            canvas2 = canvas;
        }
        if (this.f1600g0 > 0) {
            int i18 = b0.i(rect2.right, rect2.left, rect.right);
            int iCenterY2 = rect2.centerY();
            Drawable drawable = this.E;
            if (drawable == null) {
                canvas2.drawCircle(i18, iCenterY2, (int) ((((this.f1598e0 || isFocused()) ? this.L : isEnabled() ? this.J : this.K) * this.f1596c0) / 2.0f), this.D);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.f1596c0)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.f1596c0)) / 2;
                drawable.setBounds(i18 - intrinsicWidth, iCenterY2 - intrinsicHeight, i18 + intrinsicWidth, iCenterY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas2.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (!this.f1598e0 || z2) {
            return;
        }
        d(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f1600g0 <= 0) {
            return;
        }
        if (b0.f11647a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.b(r0)
            if (r0 == 0) goto L2e
            a2.a r5 = r4.Q
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.f1598e0
            if (r0 == 0) goto L2e
            r5 = 0
            r4.d(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int paddingBottom;
        int paddingBottom2;
        Rect rect;
        int i13 = i11 - i;
        int i14 = i12 - i10;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i13 - getPaddingRight();
        int i15 = this.f1597d0 ? 0 : this.M;
        int i16 = this.H;
        int i17 = this.F;
        int i18 = this.G;
        if (i16 == 1) {
            paddingBottom = (i14 - getPaddingBottom()) - i18;
            paddingBottom2 = ((i14 - getPaddingBottom()) - i17) - Math.max(i15 - (i17 / 2), 0);
        } else {
            paddingBottom = (i14 - i18) / 2;
            paddingBottom2 = (i14 - i17) / 2;
        }
        Rect rect2 = this.f1605u;
        rect2.set(paddingLeft, paddingBottom, paddingRight, i18 + paddingBottom);
        this.f1606v.set(rect2.left + i15, paddingBottom2, rect2.right - i15, i17 + paddingBottom2);
        if (b0.f11647a >= 29 && ((rect = this.f1594a0) == null || rect.width() != i13 || this.f1594a0.height() != i14)) {
            Rect rect3 = new Rect(0, 0, i13, i14);
            this.f1594a0 = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        e();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int i11 = this.G;
        if (mode == 0) {
            size = i11;
        } else if (mode != 1073741824) {
            size = Math.min(i11, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        Drawable drawable = this.E;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.E;
        if (drawable == null || b0.f11647a < 23 || !drawable.setLayoutDirection(i)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto La1
            long r2 = r9.f1600g0
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto La1
        L11:
            float r0 = r10.getX()
            int r0 = (int) r0
            float r2 = r10.getY()
            int r2 = (int) r2
            android.graphics.Point r3 = r9.S
            r3.set(r0, r2)
            int r0 = r3.x
            int r2 = r3.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.f1606v
            android.graphics.Rect r5 = r9.f1608x
            r6 = 1
            if (r3 == 0) goto L7d
            r7 = 3
            if (r3 == r6) goto L6e
            r8 = 2
            if (r3 == r8) goto L38
            if (r3 == r7) goto L6e
            goto La1
        L38:
            boolean r10 = r9.f1598e0
            if (r10 == 0) goto La1
            int r10 = r9.N
            if (r2 >= r10) goto L52
            int r10 = r9.W
            int r0 = r0 - r10
            int r0 = r0 / r7
            int r0 = r0 + r10
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = s1.b0.i(r10, r0, r1)
            r5.right = r10
            goto L60
        L52:
            r9.W = r0
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = s1.b0.i(r10, r0, r1)
            r5.right = r10
        L60:
            long r0 = r9.getScrubberPosition()
            r9.f(r0)
            r9.e()
            r9.invalidate()
            return r6
        L6e:
            boolean r0 = r9.f1598e0
            if (r0 == 0) goto La1
            int r10 = r10.getAction()
            if (r10 != r7) goto L79
            r1 = r6
        L79:
            r9.d(r1)
            return r6
        L7d:
            float r10 = (float) r0
            float r0 = (float) r2
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f1605u
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto La1
            int r0 = r4.left
            int r1 = r4.right
            int r10 = s1.b0.i(r10, r0, r1)
            r5.right = r10
            long r0 = r9.getScrubberPosition()
            r9.c(r0)
            r9.e()
            r9.invalidate()
            return r6
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f1600g0 <= 0) {
            return false;
        }
        if (i == 8192) {
            if (b(-getPositionIncrement())) {
                d(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (b(getPositionIncrement())) {
                d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i) {
        this.B.setColor(i);
        invalidate(this.f1605u);
    }

    public void setBufferedColor(int i) {
        this.f1610z.setColor(i);
        invalidate(this.f1605u);
    }

    @Override // i4.u0
    public void setBufferedPosition(long j5) {
        if (this.f1602i0 == j5) {
            return;
        }
        this.f1602i0 = j5;
        e();
    }

    @Override // i4.u0
    public void setDuration(long j5) {
        if (this.f1600g0 == j5) {
            return;
        }
        this.f1600g0 = j5;
        if (this.f1598e0 && j5 == -9223372036854775807L) {
            d(true);
        }
        e();
    }

    @Override // android.view.View, i4.u0
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!this.f1598e0 || z2) {
            return;
        }
        d(true);
    }

    public void setKeyCountIncrement(int i) {
        d.b(i > 0);
        this.U = i;
        this.V = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j5) {
        d.b(j5 > 0);
        this.U = -1;
        this.V = j5;
    }

    public void setPlayedAdMarkerColor(int i) {
        this.C.setColor(i);
        invalidate(this.f1605u);
    }

    public void setPlayedColor(int i) {
        this.f1609y.setColor(i);
        invalidate(this.f1605u);
    }

    @Override // i4.u0
    public void setPosition(long j5) {
        if (this.f1601h0 == j5) {
            return;
        }
        this.f1601h0 = j5;
        setContentDescription(getProgressText());
        e();
    }

    public void setScrubberColor(int i) {
        this.D.setColor(i);
        invalidate(this.f1605u);
    }

    public void setUnplayedColor(int i) {
        this.A.setColor(i);
        invalidate(this.f1605u);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, AttributeSet attributeSet2, int i) {
        super(context, attributeSet, 0);
        this.f1605u = new Rect();
        this.f1606v = new Rect();
        this.f1607w = new Rect();
        this.f1608x = new Rect();
        Paint paint = new Paint();
        this.f1609y = paint;
        Paint paint2 = new Paint();
        this.f1610z = paint2;
        Paint paint3 = new Paint();
        this.A = paint3;
        Paint paint4 = new Paint();
        this.B = paint4;
        Paint paint5 = new Paint();
        this.C = paint5;
        Paint paint6 = new Paint();
        this.D = paint6;
        paint6.setAntiAlias(true);
        this.R = new CopyOnWriteArraySet();
        this.S = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.T = f;
        this.N = a(-50, f);
        int iA = a(4, f);
        int iA2 = a(26, f);
        int iA3 = a(4, f);
        int iA4 = a(12, f);
        int iA5 = a(0, f);
        int iA6 = a(16, f);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, n0.DefaultTimeBar, 0, i);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(n0.DefaultTimeBar_scrubber_drawable);
                this.E = drawable;
                if (drawable != null) {
                    int i10 = b0.f11647a;
                    if (i10 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i10 < 23 || drawable.setLayoutDirection(layoutDirection)) {
                        }
                    }
                    iA2 = Math.max(drawable.getMinimumHeight(), iA2);
                }
                this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_bar_height, iA);
                this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_touch_target_height, iA2);
                this.H = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_bar_gravity, 0);
                this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_ad_marker_width, iA3);
                this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_scrubber_enabled_size, iA4);
                this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_scrubber_disabled_size, iA5);
                this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(n0.DefaultTimeBar_scrubber_dragged_size, iA6);
                int i11 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_played_color, -1);
                int i12 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_scrubber_color, -1);
                int i13 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_buffered_color, -855638017);
                int i14 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_unplayed_color, 872415231);
                int i15 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_ad_marker_color, -1291845888);
                int i16 = typedArrayObtainStyledAttributes.getInt(n0.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i11);
                paint6.setColor(i12);
                paint2.setColor(i13);
                paint3.setColor(i14);
                paint4.setColor(i15);
                paint5.setColor(i16);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.F = iA;
            this.G = iA2;
            this.H = 0;
            this.I = iA3;
            this.J = iA4;
            this.K = iA5;
            this.L = iA6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.E = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.O = sb2;
        this.P = new Formatter(sb2, Locale.getDefault());
        this.Q = new a(21, this);
        Drawable drawable2 = this.E;
        if (drawable2 != null) {
            this.M = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.M = (Math.max(this.K, Math.max(this.J, this.L)) + 1) / 2;
        }
        this.f1596c0 = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f1595b0 = valueAnimator;
        valueAnimator.addUpdateListener(new i4.d(0, this));
        this.f1600g0 = -9223372036854775807L;
        this.V = -9223372036854775807L;
        this.U = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
