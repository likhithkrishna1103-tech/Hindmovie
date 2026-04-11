package o;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9247v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f9248w;

    public /* synthetic */ j0(int i, Object obj) {
        this.f9247v = i;
        this.f9248w = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        switch (this.f9247v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l0 l0Var = (l0) this.f9248w;
                o0 o0Var = l0Var.f9261c0;
                o0Var.setSelection(i);
                if (o0Var.getOnItemClickListener() != null) {
                    o0Var.performItemClick(view, i, l0Var.Z.getItemId(i));
                }
                l0Var.dismiss();
                break;
            case 1:
                ((SearchView) this.f9248w).n(i);
                break;
            case 2:
                pa.v vVar = (pa.v) this.f9248w;
                g2 g2Var = vVar.f10131z;
                vVar.setText(vVar.convertSelectionToString(i < 0 ? !g2Var.U.isShowing() ? null : g2Var.f9231x.getSelectedItem() : vVar.getAdapter().getItem(i)), false);
                AdapterView.OnItemClickListener onItemClickListener = vVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !g2Var.U.isShowing() ? null : g2Var.f9231x.getSelectedView();
                        i = !g2Var.U.isShowing() ? -1 : g2Var.f9231x.getSelectedItemPosition();
                        j4 = !g2Var.U.isShowing() ? Long.MIN_VALUE : g2Var.f9231x.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(g2Var.f9231x, view, i, j4);
                }
                g2Var.dismiss();
                break;
            default:
                v5.d dVar = (v5.d) this.f9248w;
                x5.i iVar = dVar.K0.f14347v;
                ((TabLayout) iVar.f14348u0.f).j(((TabLayout) iVar.f14348u0.f).f(i), true);
                dVar.R(false, false);
                break;
        }
    }
}
