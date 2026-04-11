package l5;

import androidx.media3.decoder.DecoderInputBuffer;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f7856b;

    public i(LottieAnimationView lottieAnimationView, int i) {
        this.f7855a = i;
        switch (i) {
            case 1:
                this.f7856b = new WeakReference(lottieAnimationView);
                break;
            default:
                this.f7856b = new WeakReference(lottieAnimationView);
                break;
        }
    }

    @Override // l5.y
    public final void onResult(Object obj) {
        switch (this.f7855a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Throwable th = (Throwable) obj;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f7856b.get();
                if (lottieAnimationView != null) {
                    int i = lottieAnimationView.A;
                    if (i != 0) {
                        lottieAnimationView.setImageResource(i);
                    }
                    y yVar = lottieAnimationView.f2757z;
                    if (yVar == null) {
                        yVar = LottieAnimationView.K;
                    }
                    yVar.onResult(th);
                    break;
                }
                break;
            default:
                j jVar = (j) obj;
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f7856b.get();
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setComposition(jVar);
                    break;
                }
                break;
        }
    }
}
