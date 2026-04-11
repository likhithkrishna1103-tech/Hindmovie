package q9;

import android.view.View;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends v {
    public x(NavigationView navigationView) {
        d(navigationView);
    }

    private void d(View view) {
        view.setOutlineProvider(new b9.b(3, this));
    }

    @Override // q9.v
    public final void a(NavigationView navigationView) {
        navigationView.setClipToOutline(!this.f11157a);
        if (this.f11157a) {
            navigationView.invalidate();
        } else {
            navigationView.invalidateOutline();
        }
    }

    @Override // q9.v
    public final boolean b() {
        return this.f11157a;
    }
}
