package h;

import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.h3;
import n.m3;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends com.bumptech.glide.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m3 f5502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window.Callback f5503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wb.c f5504e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5506h;
    public final ArrayList i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final androidx.fragment.app.e f5507j = new androidx.fragment.app.e(6, this);

    public i0(Toolbar toolbar, CharSequence charSequence, x xVar) {
        u5.c cVar = new u5.c(17, this);
        m3 m3Var = new m3(toolbar, false);
        this.f5502c = m3Var;
        xVar.getClass();
        this.f5503d = xVar;
        m3Var.f8451k = xVar;
        toolbar.setOnMenuItemClickListener(cVar);
        if (!m3Var.f8448g) {
            m3Var.f8449h = charSequence;
            if ((m3Var.f8444b & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (m3Var.f8448g) {
                    o0.o(toolbar.getRootView(), charSequence);
                }
            }
        }
        this.f5504e = new wb.c(16, this);
    }

    @Override // com.bumptech.glide.d
    public final boolean A(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            B();
        }
        return true;
    }

    @Override // com.bumptech.glide.d
    public final boolean B() {
        return this.f5502c.f8443a.v();
    }

    @Override // com.bumptech.glide.d
    public final void J(boolean z2) {
        int i = z2 ? 4 : 0;
        m3 m3Var = this.f5502c;
        m3Var.a((i & 4) | (m3Var.f8444b & (-5)));
    }

    @Override // com.bumptech.glide.d
    public final void K() {
        m3 m3Var = this.f5502c;
        m3Var.a(m3Var.f8444b & (-9));
    }

    @Override // com.bumptech.glide.d
    public final void Q(CharSequence charSequence) {
        m3 m3Var = this.f5502c;
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

    public final Menu b0() {
        boolean z2 = this.f5505g;
        m3 m3Var = this.f5502c;
        if (!z2) {
            e6.f0 f0Var = new e6.f0(this);
            u5.d dVar = new u5.d(14, this);
            Toolbar toolbar = m3Var.f8443a;
            toolbar.f936k0 = f0Var;
            toolbar.l0 = dVar;
            ActionMenuView actionMenuView = toolbar.f942u;
            if (actionMenuView != null) {
                actionMenuView.O = f0Var;
                actionMenuView.P = dVar;
            }
            this.f5505g = true;
        }
        return m3Var.f8443a.getMenu();
    }

    @Override // com.bumptech.glide.d
    public final boolean f() {
        n.k kVar;
        ActionMenuView actionMenuView = this.f5502c.f8443a.f942u;
        return (actionMenuView == null || (kVar = actionMenuView.N) == null || !kVar.d()) ? false : true;
    }

    @Override // com.bumptech.glide.d
    public final boolean g() {
        m.m mVar;
        h3 h3Var = this.f5502c.f8443a.f935j0;
        if (h3Var == null || (mVar = h3Var.f8397v) == null) {
            return false;
        }
        if (h3Var == null) {
            mVar = null;
        }
        if (mVar == null) {
            return true;
        }
        mVar.collapseActionView();
        return true;
    }

    @Override // com.bumptech.glide.d
    public final void i(boolean z2) {
        if (z2 == this.f5506h) {
            return;
        }
        this.f5506h = z2;
        ArrayList arrayList = this.i;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // com.bumptech.glide.d
    public final int o() {
        return this.f5502c.f8444b;
    }

    @Override // com.bumptech.glide.d
    public final Context u() {
        return this.f5502c.f8443a.getContext();
    }

    @Override // com.bumptech.glide.d
    public final boolean v() {
        m3 m3Var = this.f5502c;
        Toolbar toolbar = m3Var.f8443a;
        androidx.fragment.app.e eVar = this.f5507j;
        toolbar.removeCallbacks(eVar);
        Toolbar toolbar2 = m3Var.f8443a;
        WeakHashMap weakHashMap = o0.f10475a;
        toolbar2.postOnAnimation(eVar);
        return true;
    }

    @Override // com.bumptech.glide.d
    public final void y() {
        this.f5502c.f8443a.removeCallbacks(this.f5507j);
    }

    @Override // com.bumptech.glide.d
    public final boolean z(int i, KeyEvent keyEvent) {
        Menu menuB0 = b0();
        if (menuB0 == null) {
            return false;
        }
        menuB0.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuB0.performShortcut(i, keyEvent, 0);
    }

    @Override // com.bumptech.glide.d
    public final void x() {
    }

    @Override // com.bumptech.glide.d
    public final void I(boolean z2) {
    }

    @Override // com.bumptech.glide.d
    public final void O(boolean z2) {
    }
}
