package l9;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.WeakHashMap;
import k8.c0;
import m.x;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends FrameLayout implements x {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[] f8025d0 = {R.attr.state_checked};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final c0 f8026e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final d f8027f0;
    public float A;
    public float B;
    public float C;
    public int D;
    public boolean E;
    public final FrameLayout F;
    public final View G;
    public final ImageView H;
    public final ViewGroup I;
    public final TextView J;
    public final TextView K;
    public int L;
    public int M;
    public m.m N;
    public ColorStateList O;
    public Drawable P;
    public Drawable Q;
    public ValueAnimator R;
    public c0 S;
    public float T;
    public boolean U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f8028a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f8029b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public s8.a f8030c0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ColorStateList f8032v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f8033w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8034x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8035y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8036z;

    static {
        int i = 17;
        f8026e0 = new c0(i);
        f8027f0 = new d(i);
    }

    public e(Context context) {
        super(context);
        int i = 0;
        this.f8031u = false;
        this.L = -1;
        this.M = 0;
        this.S = f8026e0;
        this.T = 0.0f;
        this.U = false;
        this.V = 0;
        this.W = 0;
        this.f8028a0 = false;
        this.f8029b0 = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.F = (FrameLayout) findViewById(p8.f.navigation_bar_item_icon_container);
        this.G = findViewById(p8.f.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(p8.f.navigation_bar_item_icon_view);
        this.H = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(p8.f.navigation_bar_item_labels_group);
        this.I = viewGroup;
        TextView textView = (TextView) findViewById(p8.f.navigation_bar_item_small_label_view);
        this.J = textView;
        TextView textView2 = (TextView) findViewById(p8.f.navigation_bar_item_large_label_view);
        this.K = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f8034x = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f8035y = viewGroup.getPaddingBottom();
        this.f8036z = getResources().getDimensionPixelSize(p8.d.m3_navigation_item_active_indicator_label_padding);
        WeakHashMap weakHashMap = o0.f10475a;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        setFocusable(true);
        b(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new b(i, (v8.a) this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.widget.TextView r4, int r5) {
        /*
            r4.setTextAppearance(r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto Lb
            goto L21
        Lb:
            int[] r2 = p8.l.TextAppearance
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            int r3 = p8.l.TextAppearance_android_textSize
            boolean r3 = r5.getValue(r3, r2)
            r5.recycle()
            if (r3 != 0) goto L23
        L21:
            r5 = r1
            goto L4e
        L23:
            int r5 = r2.getComplexUnit()
            r3 = 2
            if (r5 != r3) goto L40
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L4e
        L40:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L4e:
            if (r5 == 0) goto L54
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.e.f(android.widget.TextView, int):void");
    }

    public static void g(View view, float f, float f4, int i) {
        view.setScaleX(f);
        view.setScaleY(f4);
        view.setVisibility(i);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.F;
        return frameLayout != null ? frameLayout : this.H;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i10 = 0; i10 < iIndexOfChild; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof e) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        s8.a aVar = this.f8030c0;
        int minimumWidth = aVar == null ? 0 : aVar.getMinimumWidth() - this.f8030c0.f11916y.f11925b.Q.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.H.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void h(View view, int i, int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i10;
        view.setLayoutParams(layoutParams);
    }

    public static void j(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    @Override // m.x
    public final void a(m.m mVar) {
        this.N = mVar;
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setIcon(mVar.getIcon());
        setTitle(mVar.f8234e);
        setId(mVar.f8230a);
        if (!TextUtils.isEmpty(mVar.f8244q)) {
            setContentDescription(mVar.f8244q);
        }
        CharSequence charSequence = !TextUtils.isEmpty(mVar.f8245r) ? mVar.f8245r : mVar.f8234e;
        if (Build.VERSION.SDK_INT > 23) {
            q1.c.N(this, charSequence);
        }
        setVisibility(mVar.isVisible() ? 0 : 8);
        this.f8031u = true;
    }

    public final void b(float f, float f4) {
        this.A = f - f4;
        this.B = (f4 * 1.0f) / f;
        this.C = (f * 1.0f) / f4;
    }

    public final void c() {
        m.m mVar = this.N;
        if (mVar != null) {
            setChecked(mVar.isChecked());
        }
    }

    public final void d() {
        Drawable rippleDrawable = this.f8033w;
        ColorStateList colorStateList = this.f8032v;
        FrameLayout frameLayout = this.F;
        RippleDrawable rippleDrawable2 = null;
        boolean z2 = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.U && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(o9.a.c(this.f8032v), null, activeIndicatorDrawable);
                z2 = false;
            } else if (rippleDrawable == null) {
                rippleDrawable = new RippleDrawable(o9.a.a(this.f8032v), null, null);
            }
        }
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            frameLayout.setForeground(rippleDrawable2);
        }
        WeakHashMap weakHashMap = o0.f10475a;
        setBackground(rippleDrawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.F;
        if (frameLayout != null && this.U) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f, float f4) {
        View view = this.G;
        if (view != null) {
            c0 c0Var = this.S;
            c0Var.getClass();
            view.setScaleX(q8.a.a(0.4f, 1.0f, f));
            view.setScaleY(c0Var.h(f, f4));
            view.setAlpha(q8.a.b(0.0f, 1.0f, f4 == 0.0f ? 0.8f : 0.0f, f4 == 0.0f ? 1.0f : 0.2f, f));
        }
        this.T = f;
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.G;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public s8.a getBadge() {
        return this.f8030c0;
    }

    public int getItemBackgroundResId() {
        return p8.e.mtrl_navigation_bar_item_background;
    }

    @Override // m.x
    public m.m getItemData() {
        return this.N;
    }

    public int getItemDefaultMarginResId() {
        return p8.d.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.L;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.I;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + (viewGroup.getVisibility() == 0 ? this.f8036z : 0) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.I;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void i(int i) {
        View view = this.G;
        if (view == null || i <= 0) {
            return;
        }
        int iMin = Math.min(this.V, i - (this.f8029b0 * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.f8028a0 && this.D == 2) ? iMin : this.W;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        m.m mVar = this.N;
        if (mVar != null && mVar.isCheckable() && this.N.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8025d0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        s8.a aVar = this.f8030c0;
        if (aVar != null && aVar.isVisible()) {
            m.m mVar = this.N;
            CharSequence charSequence = mVar.f8234e;
            if (!TextUtils.isEmpty(mVar.f8244q)) {
                charSequence = this.N.f8244q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.f8030c0.c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) e7.c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()).f4586u);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r0.d.f11212g.f11221a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(p8.j.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        post(new androidx.emoji2.text.k(i, 2, this));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.G;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        d();
    }

    public void setActiveIndicatorEnabled(boolean z2) {
        this.U = z2;
        d();
        View view = this.G;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i) {
        this.W = i;
        i(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i) {
        if (this.f8036z != i) {
            this.f8036z = i;
            c();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.f8029b0 = i;
        i(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z2) {
        this.f8028a0 = z2;
    }

    public void setActiveIndicatorWidth(int i) {
        this.V = i;
        i(getWidth());
    }

    public void setBadge(s8.a aVar) {
        s8.a aVar2 = this.f8030c0;
        if (aVar2 == aVar) {
            return;
        }
        ImageView imageView = this.H;
        if (aVar2 != null && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.f8030c0 != null) {
                setClipChildren(true);
                setClipToPadding(true);
                s8.a aVar3 = this.f8030c0;
                if (aVar3 != null) {
                    if (aVar3.d() != null) {
                        aVar3.d().setForeground(null);
                    } else {
                        imageView.getOverlay().remove(aVar3);
                    }
                }
                this.f8030c0 = null;
            }
        }
        this.f8030c0 = aVar;
        if (imageView == null || aVar == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        s8.a aVar4 = this.f8030c0;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        aVar4.setBounds(rect);
        aVar4.i(imageView, null);
        if (aVar4.d() != null) {
            aVar4.d().setForeground(aVar4);
        } else {
            imageView.getOverlay().add(aVar4);
        }
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setChecked(boolean r13) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.e.setChecked(boolean):void");
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        u5.d dVar;
        super.setEnabled(z2);
        this.J.setEnabled(z2);
        this.K.setEnabled(z2);
        this.H.setEnabled(z2);
        Object obj = null;
        if (!z2) {
            o0.p(this, null);
            return;
        }
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            dVar = new u5.d(26, m0.d.d(context));
        } else {
            dVar = new u5.d(26, obj);
        }
        o0.p(this, dVar);
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.P) {
            return;
        }
        this.P = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.Q = drawable;
            ColorStateList colorStateList = this.O;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.H.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        ImageView imageView = this.H;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.O = colorStateList;
        if (this.N == null || (drawable = this.Q) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.Q.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }

    public void setItemPaddingBottom(int i) {
        if (this.f8035y != i) {
            this.f8035y = i;
            c();
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.f8034x != i) {
            this.f8034x = i;
            c();
        }
    }

    public void setItemPosition(int i) {
        this.L = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f8032v = colorStateList;
        d();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.D != i) {
            this.D = i;
            if (this.f8028a0 && i == 2) {
                this.S = f8027f0;
            } else {
                this.S = f8026e0;
            }
            i(getWidth());
            c();
        }
    }

    public void setShifting(boolean z2) {
        if (this.E != z2) {
            this.E = z2;
            c();
        }
    }

    public void setTextAppearanceActive(int i) {
        this.M = i;
        TextView textView = this.K;
        f(textView, i);
        b(this.J.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z2) {
        setTextAppearanceActive(this.M);
        TextView textView = this.K;
        textView.setTypeface(textView.getTypeface(), z2 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i) {
        TextView textView = this.J;
        f(textView, i);
        b(textView.getTextSize(), this.K.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.J.setTextColor(colorStateList);
            this.K.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.J.setText(charSequence);
        this.K.setText(charSequence);
        m.m mVar = this.N;
        if (mVar == null || TextUtils.isEmpty(mVar.f8244q)) {
            setContentDescription(charSequence);
        }
        m.m mVar2 = this.N;
        if (mVar2 != null && !TextUtils.isEmpty(mVar2.f8245r)) {
            charSequence = this.N.f8245r;
        }
        if (Build.VERSION.SDK_INT > 23) {
            q1.c.N(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f8033w = drawable;
        d();
    }
}
