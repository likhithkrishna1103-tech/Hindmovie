package lc;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8085u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.n f8086v;

    public /* synthetic */ c(androidx.fragment.app.n nVar, int i) {
        this.f8085u = i;
        this.f8086v = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        switch (this.f8085u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) this.f8086v;
                TextView textView = (TextView) view.findViewById(gc.j.choose_txt);
                nc.i iVar = eVar.J0;
                int iIndexOf = eVar.I0.indexOf(textView.getText().toString());
                nc.m mVar = iVar.f8939u;
                mVar.B0 = iIndexOf;
                ((TabLayout) mVar.f8944t0.f).j(((TabLayout) mVar.f8944t0.f).f(iIndexOf), true);
                eVar.P(false, false);
                break;
            default:
                h hVar = (h) this.f8086v;
                h.T(hVar.h(), hVar.J0, hVar.I0, i, hVar.K0, hVar.L0);
                hVar.P(false, false);
                break;
        }
    }
}
