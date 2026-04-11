package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class f2 implements m.a0 {
    public static final Method U;
    public static final Method V;
    public static final Method W;
    public int A;
    public boolean C;
    public boolean D;
    public boolean E;
    public k5.g H;
    public View I;
    public AdapterView.OnItemClickListener J;
    public AdapterView.OnItemSelectedListener K;
    public final Handler P;
    public Rect R;
    public boolean S;
    public final a0 T;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f8381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ListAdapter f8382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public t1 f8383w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8386z;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f8384x = -2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8385y = -2;
    public final int B = 1002;
    public int F = 0;
    public final int G = Integer.MAX_VALUE;
    public final c2 L = new c2(this, 1);
    public final e2 M = new e2(this);
    public final d2 N = new d2(this);
    public final c2 O = new c2(this, 0);
    public final Rect Q = new Rect();

    static {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i <= 28) {
            try {
                U = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                W = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                V = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public f2(Context context, AttributeSet attributeSet, int i, int i10) {
        int resourceId;
        this.f8381u = context;
        this.P = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.ListPopupWindow, i, 0);
        this.f8386z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.A = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.C = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        a0 a0Var = new a0(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.j.PopupWindow, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.PopupWindow_overlapAnchor)) {
            a0Var.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(g.j.PopupWindow_overlapAnchor, false));
        }
        int i11 = g.j.PopupWindow_android_popupBackground;
        a0Var.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(i11) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(i11, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(i11) : com.bumptech.glide.d.p(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.T = a0Var;
        a0Var.setInputMethodMode(1);
    }

    @Override // m.a0
    public final boolean a() {
        return this.T.isShowing();
    }

    public final int b() {
        return this.f8386z;
    }

    public final Drawable c() {
        return this.T.getBackground();
    }

    @Override // m.a0
    public final void d() {
        int i;
        int iA;
        int paddingBottom;
        t1 t1Var;
        t1 t1Var2 = this.f8383w;
        Context context = this.f8381u;
        a0 a0Var = this.T;
        if (t1Var2 == null) {
            t1 t1VarP = p(context, !this.S);
            this.f8383w = t1VarP;
            t1VarP.setAdapter(this.f8382v);
            this.f8383w.setOnItemClickListener(this.J);
            this.f8383w.setFocusable(true);
            this.f8383w.setFocusableInTouchMode(true);
            this.f8383w.setOnItemSelectedListener(new z1(i, this));
            this.f8383w.setOnScrollListener(this.N);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.K;
            if (onItemSelectedListener != null) {
                this.f8383w.setOnItemSelectedListener(onItemSelectedListener);
            }
            a0Var.setContentView(this.f8383w);
        }
        Drawable background = a0Var.getBackground();
        Rect rect = this.Q;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i = rect.bottom + i10;
            if (!this.C) {
                this.A = -i10;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        boolean z2 = a0Var.getInputMethodMode() == 2;
        View view = this.I;
        int i11 = this.A;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = V;
            if (method != null) {
                try {
                    iA = ((Integer) method.invoke(a0Var, view, Integer.valueOf(i11), Boolean.valueOf(z2))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    iA = a0Var.getMaxAvailableHeight(view, i11);
                }
            } else {
                iA = a0Var.getMaxAvailableHeight(view, i11);
            }
        } else {
            iA = a2.a(a0Var, view, i11, z2);
        }
        int i12 = this.f8384x;
        if (i12 == -1) {
            paddingBottom = iA + i;
        } else {
            int i13 = this.f8385y;
            int iA2 = this.f8383w.a(i13 != -2 ? i13 != -1 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f8383w.getPaddingBottom() + this.f8383w.getPaddingTop() + i : 0);
        }
        boolean z10 = a0Var.getInputMethodMode() == 2;
        a0Var.setWindowLayoutType(this.B);
        if (a0Var.isShowing()) {
            if (this.I.isAttachedToWindow()) {
                int width = this.f8385y;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.I.getWidth();
                }
                if (i12 == -1) {
                    i12 = z10 ? paddingBottom : -1;
                    if (z10) {
                        a0Var.setWidth(this.f8385y == -1 ? -1 : 0);
                        a0Var.setHeight(0);
                    } else {
                        a0Var.setWidth(this.f8385y == -1 ? -1 : 0);
                        a0Var.setHeight(-1);
                    }
                } else if (i12 == -2) {
                    i12 = paddingBottom;
                }
                a0Var.setOutsideTouchable(true);
                View view2 = this.I;
                int i14 = width;
                int i15 = this.f8386z;
                int i16 = this.A;
                int i17 = i14 < 0 ? -1 : i14;
                if (i12 < 0) {
                    i12 = -1;
                }
                a0Var.update(view2, i15, i16, i17, i12);
                return;
            }
            return;
        }
        int width2 = this.f8385y;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.I.getWidth();
        }
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = paddingBottom;
        }
        a0Var.setWidth(width2);
        a0Var.setHeight(i12);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = U;
            if (method2 != null) {
                try {
                    method2.invoke(a0Var, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b2.b(a0Var, true);
        }
        a0Var.setOutsideTouchable(true);
        a0Var.setTouchInterceptor(this.M);
        if (this.E) {
            a0Var.setOverlapAnchor(this.D);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = W;
            if (method3 != null) {
                try {
                    method3.invoke(a0Var, this.R);
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            b2.a(a0Var, this.R);
        }
        a0Var.showAsDropDown(this.I, this.f8386z, this.A, this.F);
        this.f8383w.setSelection(-1);
        if ((!this.S || this.f8383w.isInTouchMode()) && (t1Var = this.f8383w) != null) {
            t1Var.setListSelectionHidden(true);
            t1Var.requestLayout();
        }
        if (this.S) {
            return;
        }
        this.P.post(this.O);
    }

    @Override // m.a0
    public final void dismiss() {
        a0 a0Var = this.T;
        a0Var.dismiss();
        a0Var.setContentView(null);
        this.f8383w = null;
        this.P.removeCallbacks(this.L);
    }

    @Override // m.a0
    public final t1 e() {
        return this.f8383w;
    }

    public final void g(Drawable drawable) {
        this.T.setBackgroundDrawable(drawable);
    }

    public final void i(int i) {
        this.A = i;
        this.C = true;
    }

    public final void k(int i) {
        this.f8386z = i;
    }

    public final int m() {
        if (this.C) {
            return this.A;
        }
        return 0;
    }

    public void o(ListAdapter listAdapter) {
        k5.g gVar = this.H;
        if (gVar == null) {
            this.H = new k5.g(1, this);
        } else {
            ListAdapter listAdapter2 = this.f8382v;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(gVar);
            }
        }
        this.f8382v = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.H);
        }
        t1 t1Var = this.f8383w;
        if (t1Var != null) {
            t1Var.setAdapter(this.f8382v);
        }
    }

    public t1 p(Context context, boolean z2) {
        return new t1(context, z2);
    }

    public final void q(int i) {
        Drawable background = this.T.getBackground();
        if (background == null) {
            this.f8385y = i;
            return;
        }
        Rect rect = this.Q;
        background.getPadding(rect);
        this.f8385y = rect.left + rect.right + i;
    }
}
