package ea;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements OnBackAnimationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f3861b;

    public e(f fVar, b bVar) {
        this.f3861b = fVar;
        this.f3860a = bVar;
    }

    public final void onBackCancelled() {
        if (this.f3861b.f3859a != null) {
            this.f3860a.d();
        }
    }

    public final void onBackInvoked() {
        this.f3860a.a();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        if (this.f3861b.f3859a != null) {
            this.f3860a.b(new c.c(backEvent));
        }
    }

    public final void onBackStarted(BackEvent backEvent) {
        if (this.f3861b.f3859a != null) {
            this.f3860a.c(new c.c(backEvent));
        }
    }
}
