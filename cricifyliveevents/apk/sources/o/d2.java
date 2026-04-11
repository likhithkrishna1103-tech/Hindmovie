package o;

import android.database.DataSetObserver;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d2 extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9194b;

    public /* synthetic */ d2(int i, Object obj) {
        this.f9193a = i;
        this.f9194b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f9193a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = (g2) this.f9194b;
                if (g2Var.U.isShowing()) {
                    g2Var.d();
                }
                break;
            case 1:
                ((TabLayout) this.f9194b).h();
                break;
            case 2:
                ((p5.g) this.f9194b).e();
                break;
            default:
                e3 e3Var = (e3) this.f9194b;
                e3Var.f14543v = true;
                e3Var.notifyDataSetChanged();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f9193a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((g2) this.f9194b).dismiss();
                break;
            case 1:
                ((TabLayout) this.f9194b).h();
                break;
            case 2:
                ((p5.g) this.f9194b).e();
                break;
            default:
                e3 e3Var = (e3) this.f9194b;
                e3Var.f14543v = false;
                e3Var.notifyDataSetInvalidated();
                break;
        }
    }
}
