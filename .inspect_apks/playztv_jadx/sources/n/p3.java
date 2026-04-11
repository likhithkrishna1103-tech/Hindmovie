package n;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p3 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static p3 E;
    public static p3 F;
    public int A;
    public q3 B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f8491u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CharSequence f8492v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f8493w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o3 f8494x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o3 f8495y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8496z;

    /* JADX WARN: Type inference failed for: r0v0, types: [n.o3] */
    /* JADX WARN: Type inference failed for: r0v1, types: [n.o3] */
    public p3(View view, CharSequence charSequence) {
        final int i = 0;
        this.f8494x = new Runnable(this) { // from class: n.o3

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ p3 f8474v;

            {
                this.f8474v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f8474v.c(false);
                        break;
                    default:
                        this.f8474v.a();
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f8495y = new Runnable(this) { // from class: n.o3

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ p3 f8474v;

            {
                this.f8474v = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f8474v.c(false);
                        break;
                    default:
                        this.f8474v.a();
                        break;
                }
            }
        };
        this.f8491u = view;
        this.f8492v = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = q0.p0.f10482a;
        this.f8493w = Build.VERSION.SDK_INT >= 28 ? g0.a.i(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.D = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(p3 p3Var) {
        p3 p3Var2 = E;
        if (p3Var2 != null) {
            p3Var2.f8491u.removeCallbacks(p3Var2.f8494x);
        }
        E = p3Var;
        if (p3Var != null) {
            p3Var.f8491u.postDelayed(p3Var.f8494x, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        p3 p3Var = F;
        View view = this.f8491u;
        if (p3Var == this) {
            F = null;
            q3 q3Var = this.B;
            if (q3Var != null) {
                View view2 = (View) q3Var.f8508v;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) q3Var.f8507u).getSystemService("window")).removeView(view2);
                }
                this.B = null;
                this.D = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (E == this) {
            b(null);
        }
        view.removeCallbacks(this.f8495y);
    }

    public final void c(boolean z2) {
        int height;
        int i;
        int i10;
        boolean z10;
        int i11;
        int i12;
        long longPressTimeout;
        long j5;
        long j8;
        View view = this.f8491u;
        if (view.isAttachedToWindow()) {
            b(null);
            p3 p3Var = F;
            if (p3Var != null) {
                p3Var.a();
            }
            F = this;
            this.C = z2;
            q3 q3Var = new q3(view.getContext());
            View view2 = (View) q3Var.f8508v;
            Context context = (Context) q3Var.f8507u;
            this.B = q3Var;
            int width = this.f8496z;
            int i13 = this.A;
            boolean z11 = this.C;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) q3Var.f8510x;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) q3Var.f8509w).setText(this.f8492v);
            int[] iArr = (int[]) q3Var.A;
            int[] iArr2 = (int[]) q3Var.f8512z;
            Rect rect = (Rect) q3Var.f8511y;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(g.d.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(g.d.tooltip_precise_anchor_extra_offset);
                height = i13 + dimensionPixelOffset2;
                i = i13 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z11 ? g.d.tooltip_y_offset_touch : g.d.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            int i14 = width;
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i12 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i10 = i;
                    z10 = z11;
                    i11 = 0;
                    i12 = 1;
                } else {
                    Resources resources = context.getResources();
                    i12 = 1;
                    i10 = i;
                    z10 = z11;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i11 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i15 = iArr2[i11] - iArr[i11];
                iArr2[i11] = i15;
                iArr2[i12] = iArr2[i12] - iArr[i12];
                layoutParams.x = (i15 + i14) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, i11);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i16 = iArr2[i12];
                int i17 = ((i16 + i10) - dimensionPixelOffset3) - measuredHeight;
                int i18 = i16 + height + dimensionPixelOffset3;
                if (z10) {
                    if (i17 >= 0) {
                        layoutParams.y = i17;
                    } else {
                        layoutParams.y = i18;
                    }
                } else if (measuredHeight + i18 <= rect.height()) {
                    layoutParams.y = i18;
                } else {
                    layoutParams.y = i17;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.C) {
                j8 = 2500;
            } else {
                WeakHashMap weakHashMap = q0.o0.f10475a;
                if ((view.getWindowSystemUiVisibility() & 1) == i12) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 15000;
                }
                j8 = j5 - longPressTimeout;
            }
            o3 o3Var = this.f8495y;
            view.removeCallbacks(o3Var);
            view.postDelayed(o3Var, j8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            n.q3 r4 = r3.B
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.C
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f8491u
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.D = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            n.q3 r4 = r3.B
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.D
            if (r1 != 0) goto L66
            int r1 = r3.f8496z
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f8493w
            if (r1 > r2) goto L66
            int r1 = r3.A
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f8496z = r4
            r3.A = r5
            r3.D = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.p3.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f8496z = view.getWidth() / 2;
        this.A = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
