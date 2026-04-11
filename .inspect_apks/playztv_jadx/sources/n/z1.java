package n;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z1 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f8600v;

    public /* synthetic */ z1(int i, Object obj) {
        this.f8599u = i;
        this.f8600v = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j5) {
        t1 t1Var;
        switch (this.f8599u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (i != -1 && (t1Var = ((f2) this.f8600v).f8383w) != null) {
                    t1Var.setListSelectionHidden(false);
                    break;
                }
                break;
            case 1:
                ((SearchView) this.f8600v).o(i);
                break;
            default:
                nc.s sVar = (nc.s) this.f8600v;
                sVar.f8969t0 = i;
                sVar.f8967r0.f7635o.setVisibility(i == sVar.f8968s0 ? 0 : 8);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.f8599u;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    private final void c(AdapterView adapterView) {
    }
}
