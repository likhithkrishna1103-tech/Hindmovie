package u9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import j9.f0;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends LinearLayout {
    public static final /* synthetic */ int F = 0;
    public TextView A;
    public ImageView B;
    public Drawable C;
    public int D;
    public final /* synthetic */ TabLayout E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public g f12813u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f12814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f12815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f12816x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public s8.a f12817y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f12818z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TabLayout tabLayout, Context context) {
        super(context);
        this.E = tabLayout;
        this.D = 2;
        e(context);
        int i = tabLayout.f3498y;
        int i10 = tabLayout.f3499z;
        int i11 = tabLayout.A;
        int i12 = tabLayout.B;
        WeakHashMap weakHashMap = o0.f10475a;
        setPaddingRelative(i, i10, i11, i12);
        setGravity(17);
        setOrientation(!tabLayout.W ? 1 : 0);
        setClickable(true);
        int i13 = 26;
        o0.p(this, Build.VERSION.SDK_INT >= 24 ? new u5.d(i13, m0.d.d(getContext())) : new u5.d(i13, (Object) null));
    }

    private s8.a getBadge() {
        return this.f12817y;
    }

    private s8.a getOrCreateBadge() {
        if (this.f12817y == null) {
            this.f12817y = new s8.a(getContext(), null);
        }
        b();
        s8.a aVar = this.f12817y;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void a() {
        if (this.f12817y != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.f12816x;
            if (view != null) {
                s8.a aVar = this.f12817y;
                if (aVar != null) {
                    if (aVar.d() != null) {
                        aVar.d().setForeground(null);
                    } else {
                        view.getOverlay().remove(aVar);
                    }
                }
                this.f12816x = null;
            }
        }
    }

    public final void b() {
        if (this.f12817y != null) {
            if (this.f12818z != null) {
                a();
                return;
            }
            TextView textView = this.f12814v;
            if (textView == null || this.f12813u == null) {
                a();
                return;
            }
            if (this.f12816x == textView) {
                c(textView);
                return;
            }
            a();
            TextView textView2 = this.f12814v;
            if (this.f12817y == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            s8.a aVar = this.f12817y;
            Rect rect = new Rect();
            textView2.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.i(textView2, null);
            if (aVar.d() != null) {
                aVar.d().setForeground(aVar);
            } else {
                textView2.getOverlay().add(aVar);
            }
            this.f12816x = textView2;
        }
    }

    public final void c(View view) {
        s8.a aVar = this.f12817y;
        if (aVar == null || view != this.f12816x) {
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.i(view, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            r3.f()
            u9.g r0 = r3.f12813u
            if (r0 == 0) goto L20
            com.google.android.material.tabs.TabLayout r1 = r0.f12806d
            if (r1 == 0) goto L18
            int r1 = r1.getSelectedTabPosition()
            r2 = -1
            if (r1 == r2) goto L20
            int r0 = r0.f12804b
            if (r1 != r0) goto L20
            r0 = 1
            goto L21
        L18:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Tab not attached to a TabLayout"
            r0.<init>(r1)
            throw r0
        L20:
            r0 = 0
        L21:
            r3.setSelected(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.j.d():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C;
        if ((drawable == null || !drawable.isStateful()) ? false : this.C.setState(drawableState)) {
            invalidate();
            this.E.invalidate();
        }
    }

    public final void e(Context context) {
        TabLayout tabLayout = this.E;
        int i = tabLayout.M;
        if (i != 0) {
            Drawable drawableP = com.bumptech.glide.d.p(context, i);
            this.C = drawableP;
            if (drawableP != null && drawableP.isStateful()) {
                this.C.setState(getDrawableState());
            }
        } else {
            this.C = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        Drawable rippleDrawable = gradientDrawable;
        if (tabLayout.H != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateListA = o9.a.a(tabLayout.H);
            boolean z2 = tabLayout.f3480d0;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z2) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z2 ? null : gradientDrawable2);
        }
        WeakHashMap weakHashMap = o0.f10475a;
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void f() {
        int i;
        ViewParent parent;
        g gVar = this.f12813u;
        View view = gVar != null ? gVar.f12805c : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.f12818z;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.f12818z);
                }
                addView(view);
            }
            this.f12818z = view;
            TextView textView = this.f12814v;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.f12815w;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f12815w.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.A = textView2;
            if (textView2 != null) {
                this.D = textView2.getMaxLines();
            }
            this.B = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view3 = this.f12818z;
            if (view3 != null) {
                removeView(view3);
                this.f12818z = null;
            }
            this.A = null;
            this.B = null;
        }
        if (this.f12818z == null) {
            if (this.f12815w == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(p8.h.design_layout_tab_icon, (ViewGroup) this, false);
                this.f12815w = imageView2;
                addView(imageView2, 0);
            }
            if (this.f12814v == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(p8.h.design_layout_tab_text, (ViewGroup) this, false);
                this.f12814v = textView3;
                addView(textView3);
                this.D = this.f12814v.getMaxLines();
            }
            TextView textView4 = this.f12814v;
            TabLayout tabLayout = this.E;
            textView4.setTextAppearance(tabLayout.C);
            if (!isSelected() || (i = tabLayout.E) == -1) {
                this.f12814v.setTextAppearance(tabLayout.D);
            } else {
                this.f12814v.setTextAppearance(i);
            }
            ColorStateList colorStateList = tabLayout.F;
            if (colorStateList != null) {
                this.f12814v.setTextColor(colorStateList);
            }
            g(this.f12814v, this.f12815w, true);
            b();
            ImageView imageView3 = this.f12815w;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new i(this, imageView3));
            }
            TextView textView5 = this.f12814v;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new i(this, textView5));
            }
        } else {
            TextView textView6 = this.A;
            if (textView6 != null || this.B != null) {
                g(textView6, this.B, false);
            }
        }
        if (gVar == null || TextUtils.isEmpty(null)) {
            return;
        }
        setContentDescription(null);
    }

    public final void g(TextView textView, ImageView imageView, boolean z2) {
        boolean z10;
        g gVar = this.f12813u;
        CharSequence charSequence = gVar != null ? gVar.f12803a : null;
        if (imageView != null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                z10 = false;
            } else {
                this.f12813u.getClass();
                z10 = true;
            }
            textView.setText(!zIsEmpty ? charSequence : null);
            textView.setVisibility(z10 ? 0 : 8);
            if (!zIsEmpty) {
                setVisibility(0);
            }
        } else {
            z10 = false;
        }
        if (z2 && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iB = (z10 && imageView.getVisibility() == 0) ? (int) f0.b(getContext(), 8) : 0;
            if (this.E.W) {
                if (iB != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iB);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iB != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iB;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        if (Build.VERSION.SDK_INT > 23) {
            q1.c.N(this, zIsEmpty ? null : charSequence);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f12814v, this.f12815w, this.f12818z};
        int iMax = 0;
        int iMin = 0;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z2 ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z2 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z2 = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f12814v, this.f12815w, this.f12818z};
        int iMax = 0;
        int iMin = 0;
        boolean z2 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z2 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z2 ? Math.max(iMax, view.getRight()) : view.getRight();
                z2 = true;
            }
        }
        return iMax - iMin;
    }

    public g getTab() {
        return this.f12813u;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        s8.a aVar = this.f12817y;
        if (aVar != null && aVar.isVisible()) {
            accessibilityNodeInfo.setContentDescription(this.f12817y.c());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) e7.c.a(0, 1, this.f12813u.f12804b, 1, false, isSelected()).f4586u);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r0.d.f11212g.f11221a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(p8.j.item_view_role_description));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.E;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.N, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i10);
        if (this.f12814v != null) {
            float f = tabLayout.K;
            int i11 = this.D;
            ImageView imageView = this.f12815w;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.f12814v;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.L;
                }
            } else {
                i11 = 1;
            }
            float textSize = this.f12814v.getTextSize();
            int lineCount = this.f12814v.getLineCount();
            int maxLines = this.f12814v.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i11 != maxLines)) {
                if (tabLayout.V == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.f12814v.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.f12814v.setTextSize(0, f);
                this.f12814v.setMaxLines(i11);
                super.onMeasure(i, i10);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.f12813u == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        g gVar = this.f12813u;
        TabLayout tabLayout = gVar.f12806d;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.j(gVar, true);
        return true;
    }

    @Override // android.view.View
    public void setSelected(boolean z2) {
        isSelected();
        super.setSelected(z2);
        TextView textView = this.f12814v;
        if (textView != null) {
            textView.setSelected(z2);
        }
        ImageView imageView = this.f12815w;
        if (imageView != null) {
            imageView.setSelected(z2);
        }
        View view = this.f12818z;
        if (view != null) {
            view.setSelected(z2);
        }
    }

    public void setTab(g gVar) {
        if (gVar != this.f12813u) {
            this.f12813u = gVar;
            d();
        }
    }
}
