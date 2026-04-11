package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p3 implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f9308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f9310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f9311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f9312e;
    public final Drawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f9314h;
    public final CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f9315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f9316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f9318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f9319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Drawable f9320o;

    public p3(Toolbar toolbar, boolean z10) {
        int i;
        Drawable drawable;
        int i10 = g.h.abc_action_bar_up_description;
        this.f9319n = 0;
        this.f9308a = toolbar;
        this.f9314h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.f9313g = this.f9314h != null;
        this.f = toolbar.getNavigationIcon();
        l7.a aVarF = l7.a.F(toolbar.getContext(), null, g.j.ActionBar, g.a.actionBarStyle);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        this.f9320o = aVarF.u(g.j.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence text = typedArray.getText(g.j.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.f9313g = true;
                this.f9314h = text;
                if ((this.f9309b & 8) != 0) {
                    toolbar.setTitle(text);
                    if (this.f9313g) {
                        t0.m0.o(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(g.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.f9309b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableU = aVarF.u(g.j.ActionBar_logo);
            if (drawableU != null) {
                this.f9312e = drawableU;
                c();
            }
            Drawable drawableU2 = aVarF.u(g.j.ActionBar_icon);
            if (drawableU2 != null) {
                this.f9311d = drawableU2;
                c();
            }
            if (this.f == null && (drawable = this.f9320o) != null) {
                this.f = drawable;
                if ((this.f9309b & 4) != 0) {
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(g.j.ActionBar_displayOptions, 0));
            int resourceId = typedArray.getResourceId(g.j.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f9310c;
                if (view != null && (this.f9309b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f9310c = viewInflate;
                if (viewInflate != null && (this.f9309b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                a(this.f9309b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(g.j.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(g.j.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(g.j.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.d();
                toolbar.O.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(g.j.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.G = resourceId2;
                a1 a1Var = toolbar.f620w;
                if (a1Var != null) {
                    a1Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(g.j.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.H = resourceId3;
                a1 a1Var2 = toolbar.f621x;
                if (a1Var2 != null) {
                    a1Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(g.j.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f9320o = toolbar.getNavigationIcon();
                i = 15;
            } else {
                i = 11;
            }
            this.f9309b = i;
        }
        aVarF.G();
        if (i10 != this.f9319n) {
            this.f9319n = i10;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i11 = this.f9319n;
                this.f9315j = i11 == 0 ? null : this.f9308a.getContext().getString(i11);
                b();
            }
        }
        this.f9315j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new o3(this));
    }

    public final void a(int i) {
        View view;
        int i10 = this.f9309b ^ i;
        this.f9309b = i;
        if (i10 != 0) {
            int i11 = i10 & 4;
            Toolbar toolbar = this.f9308a;
            if (i11 != 0) {
                if ((i & 4) != 0) {
                    b();
                }
                if ((this.f9309b & 4) != 0) {
                    Drawable drawable = this.f;
                    if (drawable == null) {
                        drawable = this.f9320o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i10 & 3) != 0) {
                c();
            }
            if ((i10 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.f9314h);
                    toolbar.setSubtitle(this.i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i10 & 16) == 0 || (view = this.f9310c) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f9309b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f9315j);
            Toolbar toolbar = this.f9308a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f9319n);
            } else {
                toolbar.setNavigationContentDescription(this.f9315j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i = this.f9309b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f9312e) == null) {
            drawable = this.f9311d;
        }
        this.f9308a.setLogo(drawable);
    }
}
