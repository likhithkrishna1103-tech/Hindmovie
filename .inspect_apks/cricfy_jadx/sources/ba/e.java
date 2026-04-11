package ba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1865c;

    public e(View view, boolean z10) {
        this.f1863a = 1;
        this.f1864b = z10;
        this.f1865c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1863a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f1864b = true;
                break;
            case 1:
            default:
                super.onAnimationCancel(animator);
                break;
            case 2:
                this.f1864b = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1863a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f1865c;
                jVar.f1891r = 0;
                jVar.f1886m = null;
                if (!this.f1864b) {
                    jVar.f1892s.a(4, false);
                }
                break;
            case 1:
                if (!this.f1864b) {
                    ((View) this.f1865c).setVisibility(4);
                }
                break;
            default:
                v4.j jVar2 = (v4.j) this.f1865c;
                if (this.f1864b) {
                    this.f1864b = false;
                } else if (((Float) jVar2.f13288z.getAnimatedValue()).floatValue() != 0.0f) {
                    jVar2.A = 2;
                    jVar2.f13281s.invalidate();
                } else {
                    jVar2.A = 0;
                    jVar2.f(0);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f1863a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f1865c;
                jVar.f1892s.a(0, false);
                jVar.f1891r = 1;
                jVar.f1886m = animator;
                this.f1864b = false;
                break;
            case 1:
                if (this.f1864b) {
                    ((View) this.f1865c).setVisibility(0);
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public e(j jVar) {
        this.f1863a = 0;
        this.f1865c = jVar;
    }

    public e(v4.j jVar) {
        this.f1863a = 2;
        this.f1865c = jVar;
        this.f1864b = false;
    }
}
