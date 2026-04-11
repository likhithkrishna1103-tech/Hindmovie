package fa;

import android.view.View;
import androidx.emoji2.text.v;
import androidx.emoji2.text.w;
import com.google.android.material.navigation.NavigationView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements j1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationView f4524a;

    public d(NavigationView navigationView) {
        this.f4524a = navigationView;
    }

    @Override // j1.c
    public final void b(View view) {
        NavigationView navigationView = this.f4524a;
        if (view == navigationView) {
            v vVar = navigationView.S;
            Objects.requireNonNull(vVar);
            view.post(new w(6, vVar));
        }
    }

    @Override // j1.c
    public final void c(View view) {
        NavigationView navigationView = this.f4524a;
        if (view == navigationView) {
            v vVar = navigationView.S;
            ea.d dVar = (ea.d) vVar.f888w;
            if (dVar != null) {
                dVar.c((NavigationView) vVar.f890y);
            }
            if (!navigationView.O || navigationView.N == 0) {
                return;
            }
            navigationView.N = 0;
            navigationView.g(navigationView.getWidth(), navigationView.getHeight());
        }
    }

    @Override // j1.c
    public final void a(float f) {
    }
}
