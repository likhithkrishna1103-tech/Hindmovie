package o9;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f0.b f9706c;

    public /* synthetic */ a(f0.b bVar, View view, int i) {
        this.f9704a = i;
        this.f9706c = bVar;
        this.f9705b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z10) {
        int i = this.f9704a;
        View view = this.f9705b;
        f0.b bVar = this.f9706c;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) bVar;
                int i10 = HideBottomViewOnScrollBehavior.G;
                if (z10 && hideBottomViewOnScrollBehavior.E == 1) {
                    hideBottomViewOnScrollBehavior.w(view);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) bVar;
                if (z10 && hideViewOnScrollBehavior.E == 1) {
                    hideViewOnScrollBehavior.x(view);
                    break;
                }
                break;
        }
    }
}
