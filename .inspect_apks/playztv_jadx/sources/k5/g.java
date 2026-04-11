package k5;

import android.database.DataSetObserver;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;
import n.a3;
import n.f2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7029b;

    public /* synthetic */ g(int i, Object obj) {
        this.f7028a = i;
        this.f7029b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f7028a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((i) this.f7029b).e();
                break;
            case 1:
                f2 f2Var = (f2) this.f7029b;
                if (f2Var.T.isShowing()) {
                    f2Var.d();
                }
                break;
            case 2:
                ((TabLayout) this.f7029b).h();
                break;
            default:
                a3 a3Var = (a3) this.f7029b;
                a3Var.f13111u = true;
                a3Var.notifyDataSetChanged();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f7028a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((i) this.f7029b).e();
                break;
            case 1:
                ((f2) this.f7029b).dismiss();
                break;
            case 2:
                ((TabLayout) this.f7029b).h();
                break;
            default:
                a3 a3Var = (a3) this.f7029b;
                a3Var.f13111u = false;
                a3Var.notifyDataSetInvalidated();
                break;
        }
    }
}
