package h9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5977c;

    public c(View view, boolean z2) {
        this.f5975a = 2;
        this.f5976b = z2;
        this.f5977c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5975a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5976b = true;
                break;
            case 1:
                this.f5976b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5975a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i iVar = (i) this.f5977c;
                iVar.f6010r = 0;
                iVar.f6004l = null;
                if (!this.f5976b) {
                    iVar.f6011s.a(4, false);
                }
                break;
            case 1:
                q4.j jVar = (q4.j) this.f5977c;
                if (this.f5976b) {
                    this.f5976b = false;
                } else if (((Float) jVar.f10858z.getAnimatedValue()).floatValue() != 0.0f) {
                    jVar.A = 2;
                    jVar.f10851s.invalidate();
                } else {
                    jVar.A = 0;
                    jVar.f(0);
                }
                break;
            default:
                if (!this.f5976b) {
                    ((View) this.f5977c).setVisibility(4);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f5975a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i iVar = (i) this.f5977c;
                iVar.f6011s.a(0, false);
                iVar.f6010r = 1;
                iVar.f6004l = animator;
                this.f5976b = false;
                break;
            case 1:
            default:
                super.onAnimationStart(animator);
                break;
            case 2:
                if (this.f5976b) {
                    ((View) this.f5977c).setVisibility(0);
                }
                break;
        }
    }

    public c(i iVar) {
        this.f5975a = 0;
        this.f5977c = iVar;
    }

    public c(q4.j jVar) {
        this.f5975a = 1;
        this.f5977c = jVar;
        this.f5976b = false;
    }
}
