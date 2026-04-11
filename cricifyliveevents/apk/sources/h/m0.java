package h;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o.j1;
import o.k3;
import o.p3;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends vf.g implements o.c {
    public static final AccelerateInterpolator C = new AccelerateInterpolator();
    public static final DecelerateInterpolator D = new DecelerateInterpolator();
    public final k0 A;
    public final p6.c B;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f5369e;
    public Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionBarOverlayLayout f5370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActionBarContainer f5371h;
    public j1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ActionBarContextView f5372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f5373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5374l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l0 f5375m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l0 f5376n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l4.c0 f5377o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5378p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f5379q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5380r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5381s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5382t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f5383u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5384v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public m.j f5385w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f5386x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5387y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k0 f5388z;

    public m0(Activity activity, boolean z10) {
        new ArrayList();
        this.f5379q = new ArrayList();
        this.f5380r = 0;
        this.f5381s = true;
        this.f5384v = true;
        this.f5388z = new k0(this, 0);
        this.A = new k0(this, 1);
        this.B = new p6.c(20, this);
        View decorView = activity.getWindow().getDecorView();
        f0(decorView);
        if (z10) {
            return;
        }
        this.f5373k = decorView.findViewById(R.id.content);
    }

    @Override // vf.g
    public final int F() {
        return ((p3) this.i).f9309b;
    }

    @Override // vf.g
    public final Context H() {
        if (this.f == null) {
            TypedValue typedValue = new TypedValue();
            this.f5369e.getTheme().resolveAttribute(g.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f = new ContextThemeWrapper(this.f5369e, i);
            } else {
                this.f = this.f5369e;
            }
        }
        return this.f;
    }

    @Override // vf.g
    public final void J() {
        g0(this.f5369e.getResources().getBoolean(g.b.abc_action_bar_embed_tabs));
    }

    @Override // vf.g
    public final boolean L(int i, KeyEvent keyEvent) {
        n.k kVar;
        l0 l0Var = this.f5375m;
        if (l0Var == null || (kVar = l0Var.f5367y) == null) {
            return false;
        }
        kVar.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return kVar.performShortcut(i, keyEvent, 0);
    }

    @Override // vf.g
    public final void S(boolean z10) {
        if (this.f5374l) {
            return;
        }
        T(z10);
    }

    @Override // vf.g
    public final void T(boolean z10) {
        int i = z10 ? 4 : 0;
        p3 p3Var = (p3) this.i;
        int i10 = p3Var.f9309b;
        this.f5374l = true;
        p3Var.a((i & 4) | (i10 & (-5)));
    }

    @Override // vf.g
    public final void U() {
        p3 p3Var = (p3) this.i;
        p3Var.a(p3Var.f9309b & (-9));
    }

    @Override // vf.g
    public final void V(boolean z10) {
        m.j jVar;
        this.f5386x = z10;
        if (z10 || (jVar = this.f5385w) == null) {
            return;
        }
        jVar.a();
    }

    @Override // vf.g
    public final void W(CharSequence charSequence) {
        p3 p3Var = (p3) this.i;
        if (p3Var.f9313g) {
            return;
        }
        Toolbar toolbar = p3Var.f9308a;
        p3Var.f9314h = charSequence;
        if ((p3Var.f9309b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (p3Var.f9313g) {
                t0.m0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // vf.g
    public final m.a Z(l4.c0 c0Var) {
        l0 l0Var = this.f5375m;
        if (l0Var != null) {
            l0Var.a();
        }
        this.f5370g.setHideOnContentScrollEnabled(false);
        this.f5372j.e();
        l0 l0Var2 = new l0(this, this.f5372j.getContext(), c0Var);
        n.k kVar = l0Var2.f5367y;
        kVar.w();
        try {
            if (!((nc.p) l0Var2.f5368z.f7705w).w(l0Var2, kVar)) {
                return null;
            }
            this.f5375m = l0Var2;
            l0Var2.g();
            this.f5372j.c(l0Var2);
            e0(true);
            return l0Var2;
        } finally {
            kVar.v();
        }
    }

    public final void e0(boolean z10) {
        q0 q0VarI;
        q0 q0VarI2;
        if (z10) {
            if (!this.f5383u) {
                this.f5383u = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f5370g;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                h0(false);
            }
        } else if (this.f5383u) {
            this.f5383u = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5370g;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            h0(false);
        }
        if (!this.f5371h.isLaidOut()) {
            if (z10) {
                ((p3) this.i).f9308a.setVisibility(4);
                this.f5372j.setVisibility(0);
                return;
            } else {
                ((p3) this.i).f9308a.setVisibility(0);
                this.f5372j.setVisibility(8);
                return;
            }
        }
        if (z10) {
            p3 p3Var = (p3) this.i;
            q0VarI = t0.m0.a(p3Var.f9308a);
            q0VarI.a(0.0f);
            q0VarI.c(100L);
            q0VarI.d(new m.i(p3Var, 4));
            q0VarI2 = this.f5372j.i(0, 200L);
        } else {
            p3 p3Var2 = (p3) this.i;
            q0 q0VarA = t0.m0.a(p3Var2.f9308a);
            q0VarA.a(1.0f);
            q0VarA.c(200L);
            q0VarA.d(new m.i(p3Var2, 0));
            q0VarI = this.f5372j.i(8, 100L);
            q0VarI2 = q0VarA;
        }
        m.j jVar = new m.j();
        ArrayList arrayList = jVar.f8013a;
        arrayList.add(q0VarI);
        View view = (View) q0VarI.f11795a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) q0VarI2.f11795a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(q0VarI2);
        jVar.b();
    }

    public final void f0(View view) {
        j1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(g.f.decor_content_parent);
        this.f5370g = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(g.f.action_bar);
        if (callbackFindViewById instanceof j1) {
            wrapper = (j1) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.i = wrapper;
        this.f5372j = (ActionBarContextView) view.findViewById(g.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(g.f.action_bar_container);
        this.f5371h = actionBarContainer;
        j1 j1Var = this.i;
        if (j1Var == null || this.f5372j == null || actionBarContainer == null) {
            throw new IllegalStateException(m0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((p3) j1Var).f9308a.getContext();
        this.f5369e = context;
        if ((((p3) this.i).f9309b & 4) != 0) {
            this.f5374l = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.i.getClass();
        g0(context.getResources().getBoolean(g.b.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f5369e.obtainStyledAttributes(null, g.j.ActionBar, g.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5370g;
            if (!actionBarOverlayLayout2.B) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f5387y = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f5371h;
            WeakHashMap weakHashMap = t0.m0.f11777a;
            t0.d0.k(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g0(boolean z10) {
        if (z10) {
            this.f5371h.setTabContainer(null);
            ((p3) this.i).getClass();
        } else {
            ((p3) this.i).getClass();
            this.f5371h.setTabContainer(null);
        }
        this.i.getClass();
        ((p3) this.i).f9308a.setCollapsible(false);
        this.f5370g.setHasNonEmbeddedTabs(false);
    }

    public final void h0(boolean z10) {
        boolean z11 = this.f5382t;
        boolean z12 = this.f5383u;
        p6.c cVar = this.B;
        View view = this.f5373k;
        int i = 1;
        if (!z12 && z11) {
            if (this.f5384v) {
                this.f5384v = false;
                m.j jVar = this.f5385w;
                if (jVar != null) {
                    jVar.a();
                }
                int i10 = this.f5380r;
                k0 k0Var = this.f5388z;
                if (i10 != 0 || (!this.f5386x && !z10)) {
                    k0Var.a();
                    return;
                }
                this.f5371h.setAlpha(1.0f);
                this.f5371h.setTransitioning(true);
                m.j jVar2 = new m.j();
                float f = -this.f5371h.getHeight();
                if (z10) {
                    this.f5371h.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                q0 q0VarA = t0.m0.a(this.f5371h);
                q0VarA.e(f);
                View view2 = (View) q0VarA.f11795a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(cVar != null ? new m9.c(i, cVar, view2) : null);
                }
                boolean z13 = jVar2.f8017e;
                ArrayList arrayList = jVar2.f8013a;
                if (!z13) {
                    arrayList.add(q0VarA);
                }
                if (this.f5381s && view != null) {
                    q0 q0VarA2 = t0.m0.a(view);
                    q0VarA2.e(f);
                    if (!jVar2.f8017e) {
                        arrayList.add(q0VarA2);
                    }
                }
                boolean z14 = jVar2.f8017e;
                if (!z14) {
                    jVar2.f8015c = C;
                }
                if (!z14) {
                    jVar2.f8014b = 250L;
                }
                if (!z14) {
                    jVar2.f8016d = k0Var;
                }
                this.f5385w = jVar2;
                jVar2.b();
                return;
            }
            return;
        }
        if (this.f5384v) {
            return;
        }
        this.f5384v = true;
        m.j jVar3 = this.f5385w;
        if (jVar3 != null) {
            jVar3.a();
        }
        this.f5371h.setVisibility(0);
        int i11 = this.f5380r;
        k0 k0Var2 = this.A;
        if (i11 == 0 && (this.f5386x || z10)) {
            this.f5371h.setTranslationY(0.0f);
            float f10 = -this.f5371h.getHeight();
            if (z10) {
                this.f5371h.getLocationInWindow(new int[]{0, 0});
                f10 -= r12[1];
            }
            this.f5371h.setTranslationY(f10);
            m.j jVar4 = new m.j();
            q0 q0VarA3 = t0.m0.a(this.f5371h);
            q0VarA3.e(0.0f);
            View view3 = (View) q0VarA3.f11795a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(cVar != null ? new m9.c(i, cVar, view3) : null);
            }
            boolean z15 = jVar4.f8017e;
            ArrayList arrayList2 = jVar4.f8013a;
            if (!z15) {
                arrayList2.add(q0VarA3);
            }
            if (this.f5381s && view != null) {
                view.setTranslationY(f10);
                q0 q0VarA4 = t0.m0.a(view);
                q0VarA4.e(0.0f);
                if (!jVar4.f8017e) {
                    arrayList2.add(q0VarA4);
                }
            }
            boolean z16 = jVar4.f8017e;
            if (!z16) {
                jVar4.f8015c = D;
            }
            if (!z16) {
                jVar4.f8014b = 250L;
            }
            if (!z16) {
                jVar4.f8016d = k0Var2;
            }
            this.f5385w = jVar4;
            jVar4.b();
        } else {
            this.f5371h.setAlpha(1.0f);
            this.f5371h.setTranslationY(0.0f);
            if (this.f5381s && view != null) {
                view.setTranslationY(0.0f);
            }
            k0Var2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f5370g;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = t0.m0.f11777a;
            t0.b0.c(actionBarOverlayLayout);
        }
    }

    @Override // vf.g
    public final boolean m() {
        k3 k3Var;
        j1 j1Var = this.i;
        if (j1Var == null || (k3Var = ((p3) j1Var).f9308a.f612k0) == null || k3Var.f9257w == null) {
            return false;
        }
        k3 k3Var2 = ((p3) j1Var).f9308a.f612k0;
        n.m mVar = k3Var2 == null ? null : k3Var2.f9257w;
        if (mVar == null) {
            return true;
        }
        mVar.collapseActionView();
        return true;
    }

    @Override // vf.g
    public final void w(boolean z10) {
        if (z10 == this.f5378p) {
            return;
        }
        this.f5378p = z10;
        ArrayList arrayList = this.f5379q;
        if (arrayList.size() > 0) {
            throw q4.a.k(0, arrayList);
        }
    }

    public m0(Dialog dialog) {
        new ArrayList();
        this.f5379q = new ArrayList();
        this.f5380r = 0;
        this.f5381s = true;
        this.f5384v = true;
        this.f5388z = new k0(this, 0);
        this.A = new k0(this, 1);
        this.B = new p6.c(20, this);
        f0(dialog.getWindow().getDecorView());
    }
}
