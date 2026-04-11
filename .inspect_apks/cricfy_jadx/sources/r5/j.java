package r5;

import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import app.cricfy.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements MenuItem.OnActionExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10870a;

    public j(MainActivity mainActivity) {
        this.f10870a = mainActivity;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        new Handler(Looper.getMainLooper()).postDelayed(new pa.c(5, this), 100L);
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }
}
