package h;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends z7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f5517d;

    public /* synthetic */ l0(n0 n0Var, int i) {
        this.f5516c = i;
        this.f5517d = n0Var;
    }

    @Override // q0.u0
    public final void a() {
        View view;
        int i = this.f5516c;
        n0 n0Var = this.f5517d;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (n0Var.f5534q && (view = n0Var.i) != null) {
                    view.setTranslationY(0.0f);
                    n0Var.f.setTranslationY(0.0f);
                }
                n0Var.f.setVisibility(8);
                n0Var.f.setTransitioning(false);
                n0Var.f5538u = null;
                h4.z zVar = n0Var.f5530m;
                if (zVar != null) {
                    zVar.d0(n0Var.f5529l);
                    n0Var.f5529l = null;
                    n0Var.f5530m = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = n0Var.f5524e;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = o0.f10475a;
                    q0.d0.c(actionBarOverlayLayout);
                }
                break;
            default:
                n0Var.f5538u = null;
                n0Var.f.requestLayout();
                break;
        }
    }
}
