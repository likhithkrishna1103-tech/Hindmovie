package n;

import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f8571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f8572b;

    public p(r rVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f8572b = rVar;
        this.f8571a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f8571a.onMenuItemActionCollapse(this.f8572b.g(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f8571a.onMenuItemActionExpand(this.f8572b.g(menuItem));
    }
}
