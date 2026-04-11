package g5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.navigation.NavigationView;
import q0.b1;
import q0.u0;
import q0.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5285c;

    public /* synthetic */ k(Object obj, View view, int i) {
        this.f5283a = i;
        this.f5284b = obj;
        this.f5285c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5283a) {
            case 2:
                ((u0) this.f5284b).b();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5283a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((s.e) this.f5284b).remove(animator);
                ((p) this.f5285c).H.remove(animator);
                break;
            case 1:
                DrawerLayout drawerLayout = (DrawerLayout) this.f5284b;
                drawerLayout.c((NavigationView) this.f5285c, false);
                drawerLayout.setScrimColor(-1728053248);
                break;
            case 2:
                ((u0) this.f5284b).a();
                break;
            default:
                b1 b1Var = (b1) this.f5284b;
                b1Var.f10421a.e(1.0f);
                x0.f((View) this.f5285c, b1Var);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5283a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f5285c).H.add(animator);
                break;
            case 1:
            default:
                super.onAnimationStart(animator);
                break;
            case 2:
                ((u0) this.f5284b).c();
                break;
        }
    }

    public k(p pVar, s.e eVar) {
        this.f5283a = 0;
        this.f5285c = pVar;
        this.f5284b = eVar;
    }
}
