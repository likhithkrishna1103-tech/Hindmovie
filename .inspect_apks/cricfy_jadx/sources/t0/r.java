package t0;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ScrollFeedbackProvider f11798v;

    public r(NestedScrollView nestedScrollView) {
        this.f11798v = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // t0.s
    public final void onScrollLimit(int i, int i10, int i11, boolean z10) {
        this.f11798v.onScrollLimit(i, i10, i11, z10);
    }

    @Override // t0.s
    public final void onScrollProgress(int i, int i10, int i11, int i12) {
        this.f11798v.onScrollProgress(i, i10, i11, i12);
    }
}
