package pa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f10056b;

    public /* synthetic */ d(e eVar, int i) {
        this.f10055a = i;
        this.f10056b = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f10055a) {
            case 1:
                this.f10056b.f10095b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f10055a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f10056b.f10095b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
