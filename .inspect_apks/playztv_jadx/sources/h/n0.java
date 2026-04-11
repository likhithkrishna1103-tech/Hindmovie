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
import n.h3;
import n.m1;
import n.m3;
import q0.o0;
import q0.s0;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends com.bumptech.glide.d implements n.c {
    public static final AccelerateInterpolator A = new AccelerateInterpolator();
    public static final DecelerateInterpolator B = new DecelerateInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f5522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f5523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionBarOverlayLayout f5524e;
    public ActionBarContainer f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m1 f5525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActionBarContextView f5526h;
    public final View i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m0 f5528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m0 f5529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h4.z f5530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f5532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f5536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5537t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public l.j f5538u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5539v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5540w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l0 f5541x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l0 f5542y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final rc.b f5543z;

    public n0(Activity activity, boolean z2) {
        new ArrayList();
        this.f5532o = new ArrayList();
        this.f5533p = 0;
        this.f5534q = true;
        this.f5537t = true;
        this.f5541x = new l0(this, 0);
        this.f5542y = new l0(this, 1);
        this.f5543z = new rc.b(13, this);
        View decorView = activity.getWindow().getDecorView();
        c0(decorView);
        if (z2) {
            return;
        }
        this.i = decorView.findViewById(R.id.content);
    }

    @Override // com.bumptech.glide.d
    public final void I(boolean z2) {
        if (this.f5527j) {
            return;
        }
        J(z2);
    }

    @Override // com.bumptech.glide.d
    public final void J(boolean z2) {
        int i = z2 ? 4 : 0;
        m3 m3Var = (m3) this.f5525g;
        int i10 = m3Var.f8444b;
        this.f5527j = true;
        m3Var.a((i & 4) | (i10 & (-5)));
    }

    @Override // com.bumptech.glide.d
    public final void K() {
        m3 m3Var = (m3) this.f5525g;
        m3Var.a(m3Var.f8444b & (-9));
    }

    @Override // com.bumptech.glide.d
    public final void O(boolean z2) {
        l.j jVar;
        this.f5539v = z2;
        if (z2 || (jVar = this.f5538u) == null) {
            return;
        }
        jVar.a();
    }

    @Override // com.bumptech.glide.d
    public final void Q(CharSequence charSequence) {
        m3 m3Var = (m3) this.f5525g;
        if (m3Var.f8448g) {
            return;
        }
        Toolbar toolbar = m3Var.f8443a;
        m3Var.f8449h = charSequence;
        if ((m3Var.f8444b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (m3Var.f8448g) {
                o0.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // com.bumptech.glide.d
    public final l.a U(h4.z zVar) {
        m0 m0Var = this.f5528k;
        if (m0Var != null) {
            m0Var.a();
        }
        this.f5524e.setHideOnContentScrollEnabled(false);
        this.f5526h.e();
        m0 m0Var2 = new m0(this, this.f5526h.getContext(), zVar);
        m.k kVar = m0Var2.f5519x;
        kVar.y();
        try {
            if (!((ub.o) m0Var2.f5520y.f5867v).M(m0Var2, kVar)) {
                return null;
            }
            this.f5528k = m0Var2;
            m0Var2.h();
            this.f5526h.c(m0Var2);
            b0(true);
            return m0Var2;
        } finally {
            kVar.x();
        }
    }

    public final void b0(boolean z2) {
        t0 t0VarI;
        t0 t0VarI2;
        if (z2) {
            if (!this.f5536s) {
                this.f5536s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f5524e;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                e0(false);
            }
        } else if (this.f5536s) {
            this.f5536s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5524e;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            e0(false);
        }
        if (!this.f.isLaidOut()) {
            if (z2) {
                ((m3) this.f5525g).f8443a.setVisibility(4);
                this.f5526h.setVisibility(0);
                return;
            } else {
                ((m3) this.f5525g).f8443a.setVisibility(0);
                this.f5526h.setVisibility(8);
                return;
            }
        }
        if (z2) {
            m3 m3Var = (m3) this.f5525g;
            t0VarI = o0.a(m3Var.f8443a);
            t0VarI.a(0.0f);
            t0VarI.c(100L);
            t0VarI.d(new l.i(m3Var, 4));
            t0VarI2 = this.f5526h.i(0, 200L);
        } else {
            m3 m3Var2 = (m3) this.f5525g;
            t0 t0VarA = o0.a(m3Var2.f8443a);
            t0VarA.a(1.0f);
            t0VarA.c(200L);
            t0VarA.d(new l.i(m3Var2, 0));
            t0VarI = this.f5526h.i(8, 100L);
            t0VarI2 = t0VarA;
        }
        l.j jVar = new l.j();
        ArrayList arrayList = jVar.f7799a;
        arrayList.add(t0VarI);
        View view = (View) t0VarI.f10499a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) t0VarI2.f10499a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(t0VarI2);
        jVar.b();
    }

    public final void c0(View view) {
        m1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(g.f.decor_content_parent);
        this.f5524e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(g.f.action_bar);
        if (callbackFindViewById instanceof m1) {
            wrapper = (m1) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f5525g = wrapper;
        this.f5526h = (ActionBarContextView) view.findViewById(g.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(g.f.action_bar_container);
        this.f = actionBarContainer;
        m1 m1Var = this.f5525g;
        if (m1Var == null || this.f5526h == null || actionBarContainer == null) {
            throw new IllegalStateException(n0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((m3) m1Var).f8443a.getContext();
        this.f5522c = context;
        if ((((m3) this.f5525g).f8444b & 4) != 0) {
            this.f5527j = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.f5525g.getClass();
        d0(context.getResources().getBoolean(g.b.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f5522c.obtainStyledAttributes(null, g.j.ActionBar, g.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(g.j.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f5524e;
            if (!actionBarOverlayLayout2.A) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f5540w = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f;
            WeakHashMap weakHashMap = o0.f10475a;
            q0.f0.k(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void d0(boolean z2) {
        if (z2) {
            this.f.setTabContainer(null);
            ((m3) this.f5525g).getClass();
        } else {
            ((m3) this.f5525g).getClass();
            this.f.setTabContainer(null);
        }
        m3 m3Var = (m3) this.f5525g;
        m3Var.getClass();
        m3Var.f8443a.setCollapsible(false);
        this.f5524e.setHasNonEmbeddedTabs(false);
    }

    public final void e0(boolean z2) {
        boolean z10 = this.f5535r;
        boolean z11 = this.f5536s;
        rc.b bVar = this.f5543z;
        View view = this.i;
        int i = 0;
        if (!z11 && z10) {
            if (this.f5537t) {
                this.f5537t = false;
                l.j jVar = this.f5538u;
                if (jVar != null) {
                    jVar.a();
                }
                int i10 = this.f5533p;
                l0 l0Var = this.f5541x;
                if (i10 != 0 || (!this.f5539v && !z2)) {
                    l0Var.a();
                    return;
                }
                this.f.setAlpha(1.0f);
                this.f.setTransitioning(true);
                l.j jVar2 = new l.j();
                float f = -this.f.getHeight();
                if (z2) {
                    this.f.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                t0 t0VarA = o0.a(this.f);
                t0VarA.e(f);
                View view2 = (View) t0VarA.f10499a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(bVar != null ? new s0(bVar, i, view2) : null);
                }
                boolean z12 = jVar2.f7803e;
                ArrayList arrayList = jVar2.f7799a;
                if (!z12) {
                    arrayList.add(t0VarA);
                }
                if (this.f5534q && view != null) {
                    t0 t0VarA2 = o0.a(view);
                    t0VarA2.e(f);
                    if (!jVar2.f7803e) {
                        arrayList.add(t0VarA2);
                    }
                }
                boolean z13 = jVar2.f7803e;
                if (!z13) {
                    jVar2.f7801c = A;
                }
                if (!z13) {
                    jVar2.f7800b = 250L;
                }
                if (!z13) {
                    jVar2.f7802d = l0Var;
                }
                this.f5538u = jVar2;
                jVar2.b();
                return;
            }
            return;
        }
        if (this.f5537t) {
            return;
        }
        this.f5537t = true;
        l.j jVar3 = this.f5538u;
        if (jVar3 != null) {
            jVar3.a();
        }
        this.f.setVisibility(0);
        int i11 = this.f5533p;
        l0 l0Var2 = this.f5542y;
        if (i11 == 0 && (this.f5539v || z2)) {
            this.f.setTranslationY(0.0f);
            float f4 = -this.f.getHeight();
            if (z2) {
                this.f.getLocationInWindow(new int[]{0, 0});
                f4 -= r12[1];
            }
            this.f.setTranslationY(f4);
            l.j jVar4 = new l.j();
            t0 t0VarA3 = o0.a(this.f);
            t0VarA3.e(0.0f);
            View view3 = (View) t0VarA3.f10499a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(bVar != null ? new s0(bVar, i, view3) : null);
            }
            boolean z14 = jVar4.f7803e;
            ArrayList arrayList2 = jVar4.f7799a;
            if (!z14) {
                arrayList2.add(t0VarA3);
            }
            if (this.f5534q && view != null) {
                view.setTranslationY(f4);
                t0 t0VarA4 = o0.a(view);
                t0VarA4.e(0.0f);
                if (!jVar4.f7803e) {
                    arrayList2.add(t0VarA4);
                }
            }
            boolean z15 = jVar4.f7803e;
            if (!z15) {
                jVar4.f7801c = B;
            }
            if (!z15) {
                jVar4.f7800b = 250L;
            }
            if (!z15) {
                jVar4.f7802d = l0Var2;
            }
            this.f5538u = jVar4;
            jVar4.b();
        } else {
            this.f.setAlpha(1.0f);
            this.f.setTranslationY(0.0f);
            if (this.f5534q && view != null) {
                view.setTranslationY(0.0f);
            }
            l0Var2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f5524e;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            q0.d0.c(actionBarOverlayLayout);
        }
    }

    @Override // com.bumptech.glide.d
    public final boolean g() {
        h3 h3Var;
        m1 m1Var = this.f5525g;
        if (m1Var == null || (h3Var = ((m3) m1Var).f8443a.f935j0) == null || h3Var.f8397v == null) {
            return false;
        }
        h3 h3Var2 = ((m3) m1Var).f8443a.f935j0;
        m.m mVar = h3Var2 == null ? null : h3Var2.f8397v;
        if (mVar == null) {
            return true;
        }
        mVar.collapseActionView();
        return true;
    }

    @Override // com.bumptech.glide.d
    public final void i(boolean z2) {
        if (z2 == this.f5531n) {
            return;
        }
        this.f5531n = z2;
        ArrayList arrayList = this.f5532o;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // com.bumptech.glide.d
    public final int o() {
        return ((m3) this.f5525g).f8444b;
    }

    @Override // com.bumptech.glide.d
    public final Context u() {
        if (this.f5523d == null) {
            TypedValue typedValue = new TypedValue();
            this.f5522c.getTheme().resolveAttribute(g.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f5523d = new ContextThemeWrapper(this.f5522c, i);
            } else {
                this.f5523d = this.f5522c;
            }
        }
        return this.f5523d;
    }

    @Override // com.bumptech.glide.d
    public final void x() {
        d0(this.f5522c.getResources().getBoolean(g.b.abc_action_bar_embed_tabs));
    }

    @Override // com.bumptech.glide.d
    public final boolean z(int i, KeyEvent keyEvent) {
        m.k kVar;
        m0 m0Var = this.f5528k;
        if (m0Var == null || (kVar = m0Var.f5519x) == null) {
            return false;
        }
        kVar.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return kVar.performShortcut(i, keyEvent, 0);
    }

    public n0(Dialog dialog) {
        new ArrayList();
        this.f5532o = new ArrayList();
        this.f5533p = 0;
        this.f5534q = true;
        this.f5537t = true;
        this.f5541x = new l0(this, 0);
        this.f5542y = new l0(this, 1);
        this.f5543z = new rc.b(13, this);
        c0(dialog.getWindow().getDecorView());
    }
}
