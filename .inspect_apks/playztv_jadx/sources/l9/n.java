package l9;

import android.view.View;
import com.google.android.material.navigation.NavigationView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements e1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationView f8059a;

    public n(NavigationView navigationView) {
        this.f8059a = navigationView;
    }

    @Override // e1.c
    public final void b(View view) {
        NavigationView navigationView = this.f8059a;
        if (view == navigationView) {
            a7.b bVar = navigationView.P;
            Objects.requireNonNull(bVar);
            view.post(new a2.a(28, bVar));
        }
    }

    @Override // e1.c
    public final void c(View view) {
        NavigationView navigationView = this.f8059a;
        if (view == navigationView) {
            a7.b bVar = navigationView.P;
            k9.c cVar = (k9.c) bVar.f618v;
            if (cVar != null) {
                cVar.c((NavigationView) bVar.f620x);
            }
            if (!navigationView.L || navigationView.K == 0) {
                return;
            }
            navigationView.K = 0;
            navigationView.g(navigationView.getWidth(), navigationView.getHeight());
        }
    }

    @Override // e1.c
    public final void a(float f) {
    }
}
