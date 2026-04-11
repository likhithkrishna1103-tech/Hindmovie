package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends k implements SubMenu {
    public final m A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final k f8181z;

    public c0(Context context, k kVar, m mVar) {
        super(context);
        this.f8181z = kVar;
        this.A = mVar;
    }

    @Override // m.k
    public final boolean d(m mVar) {
        return this.f8181z.d(mVar);
    }

    @Override // m.k
    public final boolean e(k kVar, MenuItem menuItem) {
        return super.e(kVar, menuItem) || this.f8181z.e(kVar, menuItem);
    }

    @Override // m.k
    public final boolean f(m mVar) {
        return this.f8181z.f(mVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // m.k
    public final String j() {
        m mVar = this.A;
        int i = mVar != null ? mVar.f8230a : 0;
        if (i == 0) {
            return null;
        }
        return e6.j.l("android:menu:actionviewstates:", i);
    }

    @Override // m.k
    public final k k() {
        return this.f8181z.k();
    }

    @Override // m.k
    public final boolean m() {
        return this.f8181z.m();
    }

    @Override // m.k
    public final boolean n() {
        return this.f8181z.n();
    }

    @Override // m.k
    public final boolean o() {
        return this.f8181z.o();
    }

    @Override // m.k, android.view.Menu
    public final void setGroupDividerEnabled(boolean z2) {
        this.f8181z.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        w(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        w(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        w(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // m.k, android.view.Menu
    public final void setQwertyMode(boolean z2) {
        this.f8181z.setQwertyMode(z2);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        w(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        w(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }
}
