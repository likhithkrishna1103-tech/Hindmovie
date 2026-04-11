package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m3 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toolbar f8443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f8445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f8446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f8447e;
    public final Drawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f8449h;
    public final CharSequence i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f8450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f8451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f8453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f8454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Drawable f8455o;

    public m3(Toolbar toolbar, boolean z2) {
        int i;
        Drawable drawable;
        int i10 = g.h.abc_action_bar_up_description;
        this.f8454n = 0;
        this.f8443a = toolbar;
        this.f8449h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.f8448g = this.f8449h != null;
        this.f = toolbar.getNavigationIcon();
        kc.b bVarD = kc.b.D(toolbar.getContext(), null, g.j.ActionBar, g.a.actionBarStyle);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        this.f8455o = bVarD.s(g.j.ActionBar_homeAsUpIndicator);
        if (z2) {
            CharSequence text = typedArray.getText(g.j.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                this.f8448g = true;
                this.f8449h = text;
                if ((this.f8444b & 8) != 0) {
                    toolbar.setTitle(text);
                    if (this.f8448g) {
                        q0.o0.o(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(g.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.i = text2;
                if ((this.f8444b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableS = bVarD.s(g.j.ActionBar_logo);
            if (drawableS != null) {
                this.f8447e = drawableS;
                c();
            }
            Drawable drawableS2 = bVarD.s(g.j.ActionBar_icon);
            if (drawableS2 != null) {
                this.f8446d = drawableS2;
                c();
            }
            if (this.f == null && (drawable = this.f8455o) != null) {
                this.f = drawable;
                if ((this.f8444b & 4) != 0) {
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(g.j.ActionBar_displayOptions, 0));
            int resourceId = typedArray.getResourceId(g.j.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f8445c;
                if (view != null && (this.f8444b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f8445c = viewInflate;
                if (viewInflate != null && (this.f8444b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                a(this.f8444b | 16);
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
                toolbar.N.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(g.j.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.F = resourceId2;
                d1 d1Var = toolbar.f943v;
                if (d1Var != null) {
                    d1Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(g.j.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.G = resourceId3;
                d1 d1Var2 = toolbar.f944w;
                if (d1Var2 != null) {
                    d1Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(g.j.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f8455o = toolbar.getNavigationIcon();
                i = 15;
            } else {
                i = 11;
            }
            this.f8444b = i;
        }
        bVarD.E();
        if (i10 != this.f8454n) {
            this.f8454n = i10;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i11 = this.f8454n;
                this.f8450j = i11 == 0 ? null : this.f8443a.getContext().getString(i11);
                b();
            }
        }
        this.f8450j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new l3(this));
    }

    public final void a(int i) {
        View view;
        int i10 = this.f8444b ^ i;
        this.f8444b = i;
        if (i10 != 0) {
            int i11 = i10 & 4;
            Toolbar toolbar = this.f8443a;
            if (i11 != 0) {
                if ((i & 4) != 0) {
                    b();
                }
                if ((this.f8444b & 4) != 0) {
                    Drawable drawable = this.f;
                    if (drawable == null) {
                        drawable = this.f8455o;
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
                    toolbar.setTitle(this.f8449h);
                    toolbar.setSubtitle(this.i);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i10 & 16) == 0 || (view = this.f8445c) == null) {
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
        if ((this.f8444b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f8450j);
            Toolbar toolbar = this.f8443a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f8454n);
            } else {
                toolbar.setNavigationContentDescription(this.f8450j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i = this.f8444b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f8447e) == null) {
            drawable = this.f8446d;
        }
        this.f8443a.setLogo(drawable);
    }
}
