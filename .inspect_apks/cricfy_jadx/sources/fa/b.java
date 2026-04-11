package fa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.navigation.NavigationView;
import l5.n;
import t0.r0;
import t0.u0;
import t0.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4522c;

    public /* synthetic */ b(Object obj, View view, int i) {
        this.f4520a = i;
        this.f4521b = obj;
        this.f4522c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f4520a) {
            case 2:
                ((r0) this.f4521b).b();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4520a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                DrawerLayout drawerLayout = (DrawerLayout) this.f4521b;
                drawerLayout.c((NavigationView) this.f4522c, false);
                drawerLayout.setScrimColor(-1728053248);
                break;
            case 1:
                ((v.e) this.f4521b).remove(animator);
                ((n) this.f4522c).I.remove(animator);
                break;
            case 2:
                ((r0) this.f4521b).a();
                break;
            default:
                z0 z0Var = (z0) this.f4521b;
                z0Var.f11831a.e(1.0f);
                u0.f((View) this.f4522c, z0Var);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f4520a) {
            case 1:
                ((n) this.f4522c).I.add(animator);
                break;
            case 2:
                ((r0) this.f4521b).c();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public b(n nVar, v.e eVar) {
        this.f4520a = 1;
        this.f4522c = nVar;
        this.f4521b = eVar;
    }
}
