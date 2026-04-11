package h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends z7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5559d;

    public /* synthetic */ s(int i, Object obj) {
        this.f5558c = i;
        this.f5559d = obj;
    }

    @Override // q0.u0
    public final void a() {
        int i = this.f5558c;
        Object obj = this.f5559d;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = ((r) obj).f5557v;
                b0Var.P.setAlpha(1.0f);
                b0Var.S.d(null);
                b0Var.S = null;
                break;
            case 1:
                b0 b0Var2 = (b0) obj;
                b0Var2.P.setAlpha(1.0f);
                b0Var2.S.d(null);
                b0Var2.S = null;
                break;
            default:
                b0 b0Var3 = (b0) ((h4.z) obj).f5868w;
                b0Var3.P.setVisibility(8);
                PopupWindow popupWindow = b0Var3.Q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (b0Var3.P.getParent() instanceof View) {
                    View view = (View) b0Var3.P.getParent();
                    WeakHashMap weakHashMap = o0.f10475a;
                    q0.d0.c(view);
                }
                b0Var3.P.e();
                b0Var3.S.d(null);
                b0Var3.S = null;
                ViewGroup viewGroup = b0Var3.V;
                WeakHashMap weakHashMap2 = o0.f10475a;
                q0.d0.c(viewGroup);
                break;
        }
    }

    @Override // z7.a, q0.u0
    public void c() {
        int i = this.f5558c;
        Object obj = this.f5559d;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((r) obj).f5557v.P.setVisibility(0);
                break;
            case 1:
                b0 b0Var = (b0) obj;
                b0Var.P.setVisibility(0);
                if (b0Var.P.getParent() instanceof View) {
                    View view = (View) b0Var.P.getParent();
                    WeakHashMap weakHashMap = o0.f10475a;
                    q0.d0.c(view);
                }
                break;
        }
    }
}
