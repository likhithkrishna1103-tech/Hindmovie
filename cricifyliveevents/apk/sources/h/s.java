package h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends w4.v {
    public final /* synthetic */ int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5402j;

    public /* synthetic */ s(int i, Object obj) {
        this.i = i;
        this.f5402j = obj;
    }

    @Override // t0.r0
    public final void a() {
        int i = this.i;
        Object obj = this.f5402j;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a0 a0Var = ((q) obj).f5400w;
                a0Var.Q.setAlpha(1.0f);
                a0Var.T.d(null);
                a0Var.T = null;
                break;
            case 1:
                a0 a0Var2 = (a0) obj;
                a0Var2.Q.setAlpha(1.0f);
                a0Var2.T.d(null);
                a0Var2.T = null;
                break;
            default:
                a0 a0Var3 = (a0) ((l4.c0) obj).f7706x;
                a0Var3.Q.setVisibility(8);
                PopupWindow popupWindow = a0Var3.R;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (a0Var3.Q.getParent() instanceof View) {
                    View view = (View) a0Var3.Q.getParent();
                    WeakHashMap weakHashMap = t0.m0.f11777a;
                    t0.b0.c(view);
                }
                a0Var3.Q.e();
                a0Var3.T.d(null);
                a0Var3.T = null;
                ViewGroup viewGroup = a0Var3.V;
                WeakHashMap weakHashMap2 = t0.m0.f11777a;
                t0.b0.c(viewGroup);
                break;
        }
    }

    @Override // w4.v, t0.r0
    public void c() {
        int i = this.i;
        Object obj = this.f5402j;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((q) obj).f5400w.Q.setVisibility(0);
                break;
            case 1:
                a0 a0Var = (a0) obj;
                a0Var.Q.setVisibility(0);
                if (a0Var.Q.getParent() instanceof View) {
                    View view = (View) a0Var.Q.getParent();
                    WeakHashMap weakHashMap = t0.m0.f11777a;
                    t0.b0.c(view);
                }
                break;
        }
    }
}
