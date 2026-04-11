package n;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends k implements SubMenu {
    public final m A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k f8498z;

    public c0(Context context, k kVar, m mVar) {
        super(context);
        this.f8498z = kVar;
        this.A = mVar;
    }

    @Override // n.k
    public final boolean d(m mVar) {
        return this.f8498z.d(mVar);
    }

    @Override // n.k
    public final boolean e(k kVar, MenuItem menuItem) {
        return super.e(kVar, menuItem) || this.f8498z.e(kVar, menuItem);
    }

    @Override // n.k
    public final boolean f(m mVar) {
        return this.f8498z.f(mVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // n.k
    public final String j() {
        m mVar = this.A;
        int i = mVar != null ? mVar.f8544a : 0;
        if (i == 0) {
            return null;
        }
        return l0.e.g(i, "android:menu:actionviewstates:");
    }

    @Override // n.k
    public final k k() {
        return this.f8498z.k();
    }

    @Override // n.k
    public final boolean m() {
        return this.f8498z.m();
    }

    @Override // n.k
    public final boolean n() {
        return this.f8498z.n();
    }

    @Override // n.k
    public final boolean o() {
        return this.f8498z.o();
    }

    @Override // n.k, android.view.Menu
    public final void setGroupDividerEnabled(boolean z10) {
        this.f8498z.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // n.k, android.view.Menu
    public final void setQwertyMode(boolean z10) {
        this.f8498z.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }
}
