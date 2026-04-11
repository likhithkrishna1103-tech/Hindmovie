package oa;

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
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.tabs.TabLayout;
import da.e0;
import i2.a0;
import java.util.WeakHashMap;
import t0.f0;
import t0.m0;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends LinearLayout {
    public static final /* synthetic */ int G = 0;
    public View A;
    public TextView B;
    public ImageView C;
    public Drawable D;
    public int E;
    public final /* synthetic */ TabLayout F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f9731v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f9732w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f9733x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f9734y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n9.a f9735z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TabLayout tabLayout, Context context) {
        super(context);
        this.F = tabLayout;
        this.E = 2;
        e(context);
        setPaddingRelative(tabLayout.f2963z, tabLayout.A, tabLayout.B, tabLayout.C);
        setGravity(17);
        setOrientation(!tabLayout.f2941b0 ? 1 : 0);
        setClickable(true);
        Context context2 = getContext();
        int i = Build.VERSION.SDK_INT;
        m2.e eVar = i >= 24 ? new m2.e(p0.d.e(context2)) : new m2.e((Object) null);
        WeakHashMap weakHashMap = m0.f11777a;
        if (i >= 24) {
            f0.a(this, a0.i((PointerIcon) eVar.f8050v));
        }
    }

    private n9.a getBadge() {
        return this.f9735z;
    }

    private n9.a getOrCreateBadge() {
        if (this.f9735z == null) {
            this.f9735z = new n9.a(getContext());
        }
        b();
        n9.a aVar = this.f9735z;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("Unable to create badge");
    }

    public final void a() {
        if (this.f9735z != null) {
            setClipChildren(true);
            setClipToPadding(true);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(true);
                viewGroup.setClipToPadding(true);
            }
            View view = this.f9734y;
            if (view != null) {
                n9.a aVar = this.f9735z;
                if (aVar != null) {
                    if (aVar.d() != null) {
                        aVar.d().setForeground(null);
                    } else {
                        view.getOverlay().remove(aVar);
                    }
                }
                this.f9734y = null;
            }
        }
    }

    public final void b() {
        if (this.f9735z != null) {
            if (this.A != null) {
                a();
                return;
            }
            TextView textView = this.f9732w;
            if (textView == null || this.f9731v == null) {
                a();
                return;
            }
            if (this.f9734y == textView) {
                c(textView);
                return;
            }
            a();
            TextView textView2 = this.f9732w;
            if (this.f9735z == null || textView2 == null) {
                return;
            }
            setClipChildren(false);
            setClipToPadding(false);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
            }
            n9.a aVar = this.f9735z;
            Rect rect = new Rect();
            textView2.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.i(textView2, null);
            if (aVar.d() != null) {
                aVar.d().setForeground(aVar);
            } else {
                textView2.getOverlay().add(aVar);
            }
            this.f9734y = textView2;
        }
    }

    public final void c(View view) {
        n9.a aVar = this.f9735z;
        if (aVar == null || view != this.f9734y) {
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
            oa.h r0 = r3.f9731v
            if (r0 == 0) goto L20
            com.google.android.material.tabs.TabLayout r1 = r0.f9724d
            if (r1 == 0) goto L18
            int r1 = r1.getSelectedTabPosition()
            r2 = -1
            if (r1 == r2) goto L20
            int r0 = r0.f9722b
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
        throw new UnsupportedOperationException("Method not decompiled: oa.k.d():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.D;
        if ((drawable == null || !drawable.isStateful()) ? false : this.D.setState(drawableState)) {
            invalidate();
            this.F.invalidate();
        }
    }

    public final void e(Context context) {
        TabLayout tabLayout = this.F;
        int i = tabLayout.O;
        if (i != 0) {
            Drawable drawableI = j4.i(context, i);
            this.D = drawableI;
            if (drawableI != null && drawableI.isStateful()) {
                this.D.setState(getDrawableState());
            }
        } else {
            this.D = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        Drawable rippleDrawable = gradientDrawable;
        if (tabLayout.I != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(1.0E-5f);
            gradientDrawable2.setColor(-1);
            ColorStateList colorStateList = tabLayout.I;
            int iA = ia.a.a(colorStateList, ia.a.f6380c);
            int[] iArr = ia.a.f6379b;
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{ia.a.f6381d, iArr, StateSet.NOTHING}, new int[]{iA, ia.a.a(colorStateList, iArr), ia.a.a(colorStateList, ia.a.f6378a)});
            boolean z10 = tabLayout.f2945f0;
            GradientDrawable gradientDrawable3 = gradientDrawable;
            if (z10) {
                gradientDrawable3 = null;
            }
            rippleDrawable = new RippleDrawable(colorStateList2, gradientDrawable3, z10 ? null : gradientDrawable2);
        }
        setBackground(rippleDrawable);
        tabLayout.invalidate();
    }

    public final void f() {
        int i;
        ViewParent parent;
        h hVar = this.f9731v;
        View view = hVar != null ? hVar.f9723c : null;
        if (view != null) {
            ViewParent parent2 = view.getParent();
            if (parent2 != this) {
                if (parent2 != null) {
                    ((ViewGroup) parent2).removeView(view);
                }
                View view2 = this.A;
                if (view2 != null && (parent = view2.getParent()) != null) {
                    ((ViewGroup) parent).removeView(this.A);
                }
                addView(view);
            }
            this.A = view;
            TextView textView = this.f9732w;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.f9733x;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f9733x.setImageDrawable(null);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.text1);
            this.B = textView2;
            if (textView2 != null) {
                this.E = textView2.getMaxLines();
            }
            this.C = (ImageView) view.findViewById(R.id.icon);
        } else {
            View view3 = this.A;
            if (view3 != null) {
                removeView(view3);
                this.A = null;
            }
            this.B = null;
            this.C = null;
        }
        if (this.A == null) {
            if (this.f9733x == null) {
                ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(k9.h.design_layout_tab_icon, (ViewGroup) this, false);
                this.f9733x = imageView2;
                addView(imageView2, 0);
            }
            if (this.f9732w == null) {
                TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(k9.h.design_layout_tab_text, (ViewGroup) this, false);
                this.f9732w = textView3;
                addView(textView3);
                this.E = this.f9732w.getMaxLines();
            }
            TextView textView4 = this.f9732w;
            TabLayout tabLayout = this.F;
            textView4.setTextAppearance(tabLayout.D);
            if (!isSelected() || (i = tabLayout.F) == -1) {
                this.f9732w.setTextAppearance(tabLayout.E);
            } else {
                this.f9732w.setTextAppearance(i);
            }
            ColorStateList colorStateList = tabLayout.G;
            if (colorStateList != null) {
                this.f9732w.setTextColor(colorStateList);
            }
            g(this.f9732w, this.f9733x, true);
            b();
            ImageView imageView3 = this.f9733x;
            if (imageView3 != null) {
                imageView3.addOnLayoutChangeListener(new j(this, imageView3));
            }
            TextView textView5 = this.f9732w;
            if (textView5 != null) {
                textView5.addOnLayoutChangeListener(new j(this, textView5));
            }
        } else {
            TextView textView6 = this.B;
            if (textView6 != null || this.C != null) {
                g(textView6, this.C, false);
            }
        }
        if (hVar == null || TextUtils.isEmpty(null)) {
            return;
        }
        setContentDescription(null);
    }

    public final void g(TextView textView, ImageView imageView, boolean z10) {
        boolean z11;
        h hVar = this.f9731v;
        CharSequence charSequence = hVar != null ? hVar.f9721a : null;
        if (imageView != null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        if (textView != null) {
            if (zIsEmpty) {
                z11 = false;
            } else {
                this.f9731v.getClass();
                z11 = true;
            }
            textView.setText(!zIsEmpty ? charSequence : null);
            textView.setVisibility(z11 ? 0 : 8);
            if (!zIsEmpty) {
                setVisibility(0);
            }
        } else {
            z11 = false;
        }
        if (z10 && imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            int iA = (z11 && imageView.getVisibility() == 0) ? (int) e0.a(getContext(), 8) : 0;
            if (this.F.f2941b0) {
                if (iA != marginLayoutParams.getMarginEnd()) {
                    marginLayoutParams.setMarginEnd(iA);
                    marginLayoutParams.bottomMargin = 0;
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            } else if (iA != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = iA;
                marginLayoutParams.setMarginEnd(0);
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
        }
        if (Build.VERSION.SDK_INT > 23) {
            v.t(this, zIsEmpty ? null : charSequence);
        }
    }

    public int getContentHeight() {
        View[] viewArr = {this.f9732w, this.f9733x, this.A};
        int iMax = 0;
        int iMin = 0;
        boolean z10 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z10 ? Math.min(iMin, view.getTop()) : view.getTop();
                iMax = z10 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                z10 = true;
            }
        }
        return iMax - iMin;
    }

    public int getContentWidth() {
        View[] viewArr = {this.f9732w, this.f9733x, this.A};
        int iMax = 0;
        int iMin = 0;
        boolean z10 = false;
        for (int i = 0; i < 3; i++) {
            View view = viewArr[i];
            if (view != null && view.getVisibility() == 0) {
                iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                z10 = true;
            }
        }
        return iMax - iMin;
    }

    public h getTab() {
        return this.f9731v;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r9) {
        /*
            r8 = this;
            super.onInitializeAccessibilityNodeInfo(r9)
            n9.a r0 = r8.f9735z
            r1 = 0
            if (r0 == 0) goto L85
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L85
            n9.a r0 = r8.f9735z
            n9.c r2 = r0.f8905z
            boolean r3 = r0.isVisible()
            r4 = 0
            if (r3 != 0) goto L1b
            goto L82
        L1b:
            n9.b r2 = r2.f8912b
            java.lang.String r3 = r2.E
            r5 = 1
            if (r3 == 0) goto L24
            r3 = r5
            goto L25
        L24:
            r3 = r1
        L25:
            if (r3 == 0) goto L33
            java.lang.CharSequence r4 = r2.J
            if (r4 == 0) goto L2c
            goto L82
        L2c:
            n9.c r0 = r0.f8905z
            n9.b r0 = r0.f8912b
            java.lang.String r4 = r0.E
            goto L82
        L33:
            boolean r3 = r0.g()
            if (r3 == 0) goto L80
            int r3 = r2.L
            if (r3 == 0) goto L82
            java.lang.ref.WeakReference r3 = r0.f8901v
            java.lang.Object r3 = r3.get()
            android.content.Context r3 = (android.content.Context) r3
            if (r3 != 0) goto L48
            goto L82
        L48:
            int r4 = r0.C
            r6 = -2
            if (r4 == r6) goto L65
            int r4 = r0.e()
            int r6 = r0.C
            if (r4 > r6) goto L56
            goto L65
        L56:
            int r0 = r2.M
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r4[r1] = r2
            java.lang.String r4 = r3.getString(r0, r4)
            goto L82
        L65:
            android.content.res.Resources r3 = r3.getResources()
            int r2 = r2.L
            int r4 = r0.e()
            int r0 = r0.e()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r0
            java.lang.String r4 = r3.getQuantityString(r2, r4, r5)
            goto L82
        L80:
            java.lang.CharSequence r4 = r2.K
        L82:
            r9.setContentDescription(r4)
        L85:
            oa.h r0 = r8.f9731v
            int r4 = r0.f9722b
            r6 = 0
            boolean r7 = r8.isSelected()
            r2 = 0
            r3 = 1
            r5 = 1
            u0.d r0 = u0.d.a(r2, r3, r4, r5, r6, r7)
            java.lang.Object r0 = r0.f12060v
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            r9.setCollectionItemInfo(r0)
            boolean r0 = r8.isSelected()
            if (r0 == 0) goto Lae
            r9.setClickable(r1)
            u0.c r0 = u0.c.f12047g
            java.lang.Object r0 = r0.f12056a
            android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r0 = (android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) r0
            r9.removeAction(r0)
        Lae:
            android.content.res.Resources r0 = r8.getResources()
            int r1 = k9.j.item_view_role_description
            java.lang.String r0 = r0.getString(r1)
            android.os.Bundle r9 = r9.getExtras()
            java.lang.String r1 = "AccessibilityNodeInfo.roleDescription"
            r9.putCharSequence(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: oa.k.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        TabLayout tabLayout = this.F;
        int tabMaxWidth = tabLayout.getTabMaxWidth();
        if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
            i = View.MeasureSpec.makeMeasureSpec(tabLayout.P, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i10);
        if (this.f9732w != null) {
            float f = tabLayout.L;
            if (isSelected() && tabLayout.F != -1) {
                f = tabLayout.M;
            }
            int i11 = this.E;
            ImageView imageView = this.f9733x;
            if (imageView == null || imageView.getVisibility() != 0) {
                TextView textView = this.f9732w;
                if (textView != null && textView.getLineCount() > 1) {
                    f = tabLayout.N;
                }
            } else {
                i11 = 1;
            }
            float textSize = this.f9732w.getTextSize();
            int lineCount = this.f9732w.getLineCount();
            int maxLines = this.f9732w.getMaxLines();
            if (f != textSize || (maxLines >= 0 && i11 != maxLines)) {
                if (tabLayout.f2940a0 == 1 && f > textSize && lineCount == 1) {
                    Layout layout = this.f9732w.getLayout();
                    if (layout == null) {
                        return;
                    }
                    if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                        return;
                    }
                }
                this.f9732w.setTextSize(0, f);
                this.f9732w.setMaxLines(i11);
                super.onMeasure(i, i10);
            }
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (this.f9731v == null) {
            return zPerformClick;
        }
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        h hVar = this.f9731v;
        TabLayout tabLayout = hVar.f9724d;
        if (tabLayout == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        tabLayout.j(hVar, true);
        return true;
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        isSelected();
        super.setSelected(z10);
        TextView textView = this.f9732w;
        if (textView != null) {
            textView.setSelected(z10);
        }
        ImageView imageView = this.f9733x;
        if (imageView != null) {
            imageView.setSelected(z10);
        }
        View view = this.A;
        if (view != null) {
            view.setSelected(z10);
        }
    }

    public void setTab(h hVar) {
        if (hVar != this.f9731v) {
            this.f9731v = hVar;
            d();
        }
    }
}
