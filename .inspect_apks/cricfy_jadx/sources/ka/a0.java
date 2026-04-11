package ka;

import android.view.View;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends x {
    public a0(NavigationView navigationView) {
        d(navigationView);
    }

    private void d(View view) {
        view.setOutlineProvider(new y(1, this));
    }

    @Override // ka.x
    public final void a(NavigationView navigationView) {
        navigationView.setClipToOutline(!this.f7384a);
        if (this.f7384a) {
            navigationView.invalidate();
        } else {
            navigationView.invalidateOutline();
        }
    }

    @Override // ka.x
    public final boolean b() {
        return this.f7384a;
    }
}
