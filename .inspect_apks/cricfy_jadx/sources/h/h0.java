package h;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.internal.measurement.o4;
import java.util.ArrayList;
import java.util.WeakHashMap;
import o.k3;
import o.p3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends vf.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p3 f5349e;
    public final Window.Callback f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final pc.c f5350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5351h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f5353k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.fragment.app.m f5354l = new androidx.fragment.app.m(12, this);

    public h0(Toolbar toolbar, CharSequence charSequence, w wVar) {
        p6.c cVar = new p6.c(19, this);
        p3 p3Var = new p3(toolbar, false);
        this.f5349e = p3Var;
        wVar.getClass();
        this.f = wVar;
        p3Var.f9316k = wVar;
        toolbar.setOnMenuItemClickListener(cVar);
        if (!p3Var.f9313g) {
            p3Var.f9314h = charSequence;
            if ((p3Var.f9309b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (p3Var.f9313g) {
                    t0.m0.o(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.f5350g = new pc.c(this);
    }

    @Override // vf.g
    public final int F() {
        return this.f5349e.f9309b;
    }

    @Override // vf.g
    public final Context H() {
        return this.f5349e.f9308a.getContext();
    }

    @Override // vf.g
    public final boolean I() {
        p3 p3Var = this.f5349e;
        Toolbar toolbar = p3Var.f9308a;
        androidx.fragment.app.m mVar = this.f5354l;
        toolbar.removeCallbacks(mVar);
        Toolbar toolbar2 = p3Var.f9308a;
        WeakHashMap weakHashMap = t0.m0.f11777a;
        toolbar2.postOnAnimation(mVar);
        return true;
    }

    @Override // vf.g
    public final void K() {
        this.f5349e.f9308a.removeCallbacks(this.f5354l);
    }

    @Override // vf.g
    public final boolean L(int i, KeyEvent keyEvent) {
        Menu menuE0 = e0();
        if (menuE0 == null) {
            return false;
        }
        menuE0.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuE0.performShortcut(i, keyEvent, 0);
    }

    @Override // vf.g
    public final boolean M(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            N();
        }
        return true;
    }

    @Override // vf.g
    public final boolean N() {
        return this.f5349e.f9308a.u();
    }

    @Override // vf.g
    public final void T(boolean z10) {
        int i = z10 ? 4 : 0;
        p3 p3Var = this.f5349e;
        p3Var.a((i & 4) | (p3Var.f9309b & (-5)));
    }

    @Override // vf.g
    public final void U() {
        p3 p3Var = this.f5349e;
        p3Var.a(p3Var.f9309b & (-9));
    }

    @Override // vf.g
    public final void W(CharSequence charSequence) {
        p3 p3Var = this.f5349e;
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

    public final Menu e0() {
        boolean z10 = this.i;
        p3 p3Var = this.f5349e;
        if (!z10) {
            o4 o4Var = new o4((Object) this, false);
            p6.d dVar = new p6.d(21, this);
            Toolbar toolbar = p3Var.f9308a;
            toolbar.f613l0 = o4Var;
            toolbar.f614m0 = dVar;
            ActionMenuView actionMenuView = toolbar.f619v;
            if (actionMenuView != null) {
                actionMenuView.P = o4Var;
                actionMenuView.Q = dVar;
            }
            this.i = true;
        }
        return p3Var.f9308a.getMenu();
    }

    @Override // vf.g
    public final boolean l() {
        o.k kVar;
        ActionMenuView actionMenuView = this.f5349e.f9308a.f619v;
        return (actionMenuView == null || (kVar = actionMenuView.O) == null || !kVar.d()) ? false : true;
    }

    @Override // vf.g
    public final boolean m() {
        n.m mVar;
        k3 k3Var = this.f5349e.f9308a.f612k0;
        if (k3Var == null || (mVar = k3Var.f9257w) == null) {
            return false;
        }
        if (k3Var == null) {
            mVar = null;
        }
        if (mVar == null) {
            return true;
        }
        mVar.collapseActionView();
        return true;
    }

    @Override // vf.g
    public final void w(boolean z10) {
        if (z10 == this.f5352j) {
            return;
        }
        this.f5352j = z10;
        ArrayList arrayList = this.f5353k;
        if (arrayList.size() > 0) {
            throw q4.a.k(0, arrayList);
        }
    }

    @Override // vf.g
    public final void J() {
    }

    @Override // vf.g
    public final void S(boolean z10) {
    }

    @Override // vf.g
    public final void V(boolean z10) {
    }
}
