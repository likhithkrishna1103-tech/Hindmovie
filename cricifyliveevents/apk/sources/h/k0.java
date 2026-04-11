package h;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends w4.v {
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m0 f5363j;

    public /* synthetic */ k0(m0 m0Var, int i) {
        this.i = i;
        this.f5363j = m0Var;
    }

    @Override // t0.r0
    public final void a() {
        View view;
        int i = this.i;
        m0 m0Var = this.f5363j;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (m0Var.f5381s && (view = m0Var.f5373k) != null) {
                    view.setTranslationY(0.0f);
                    m0Var.f5371h.setTranslationY(0.0f);
                }
                m0Var.f5371h.setVisibility(8);
                m0Var.f5371h.setTransitioning(false);
                m0Var.f5385w = null;
                l4.c0 c0Var = m0Var.f5377o;
                if (c0Var != null) {
                    c0Var.P(m0Var.f5376n);
                    m0Var.f5376n = null;
                    m0Var.f5377o = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = m0Var.f5370g;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = t0.m0.f11777a;
                    t0.b0.c(actionBarOverlayLayout);
                }
                break;
            default:
                m0Var.f5385w = null;
                m0Var.f5371h.requestLayout();
                break;
        }
    }
}
