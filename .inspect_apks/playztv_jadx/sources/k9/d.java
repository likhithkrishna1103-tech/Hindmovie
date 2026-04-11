package k9;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements OnBackAnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f7585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f7586b;

    public d(e eVar, b bVar) {
        this.f7586b = eVar;
        this.f7585a = bVar;
    }

    public final void onBackCancelled() {
        if (this.f7586b.f7584a != null) {
            this.f7585a.d();
        }
    }

    public final void onBackInvoked() {
        this.f7585a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        if (this.f7586b.f7584a != null) {
            this.f7585a.b(new c.c(backEvent));
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        if (this.f7586b.f7584a != null) {
            this.f7585a.c(new c.c(backEvent));
        }
    }
}
