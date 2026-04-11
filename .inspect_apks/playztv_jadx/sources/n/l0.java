package n;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8432v;

    public /* synthetic */ l0(int i, Object obj) {
        this.f8431u = i;
        this.f8432v = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        switch (this.f8431u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n0 n0Var = (n0) this.f8432v;
                q0 q0Var = n0Var.f8457b0;
                q0Var.setSelection(i);
                if (q0Var.getOnItemClickListener() != null) {
                    q0Var.performItemClick(view, i, n0Var.Y.getItemId(i));
                }
                n0Var.dismiss();
                break;
            case 1:
                ((SearchView) this.f8432v).n(i);
                break;
            default:
                v9.s sVar = (v9.s) this.f8432v;
                f2 f2Var = sVar.f13413y;
                v9.s.a(sVar, i < 0 ? !f2Var.T.isShowing() ? null : f2Var.f8383w.getSelectedItem() : sVar.getAdapter().getItem(i));
                AdapterView.OnItemClickListener onItemClickListener = sVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !f2Var.T.isShowing() ? null : f2Var.f8383w.getSelectedView();
                        i = !f2Var.T.isShowing() ? -1 : f2Var.f8383w.getSelectedItemPosition();
                        j5 = !f2Var.T.isShowing() ? Long.MIN_VALUE : f2Var.f8383w.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(f2Var.f8383w, view, i, j5);
                }
                f2Var.dismiss();
                break;
        }
    }
}
