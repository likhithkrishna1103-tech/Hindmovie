package hc;

import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import com.playz.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f6046a;

    public k(MainActivity mainActivity) {
        this.f6046a = mainActivity;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        new Handler(Looper.getMainLooper()).postDelayed(new a2.a(19, this), 100L);
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }
}
