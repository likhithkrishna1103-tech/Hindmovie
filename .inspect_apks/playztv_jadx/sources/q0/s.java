package q0;

import android.view.ScrollFeedbackProvider;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements t {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ScrollFeedbackProvider f10493u;

    public s(NestedScrollView nestedScrollView) {
        this.f10493u = ScrollFeedbackProvider.createProvider(nestedScrollView);
    }

    @Override // q0.t
    public final void onScrollLimit(int i, int i10, int i11, boolean z2) {
        this.f10493u.onScrollLimit(i, i10, i11, z2);
    }

    @Override // q0.t
    public final void onScrollProgress(int i, int i10, int i11, int i12) {
        this.f10493u.onScrollProgress(i, i10, i11, i12);
    }
}
