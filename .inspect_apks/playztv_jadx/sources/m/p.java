package m;

import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f8257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f8258b;

    public p(r rVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f8258b = rVar;
        this.f8257a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f8257a.onMenuItemActionCollapse(this.f8258b.g(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f8257a.onMenuItemActionExpand(this.f8258b.g(menuItem));
    }
}
