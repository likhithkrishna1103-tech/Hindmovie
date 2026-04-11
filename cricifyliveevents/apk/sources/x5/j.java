package x5;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements z5.k, v9.f, j5.i {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14354v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f14355w;

    public /* synthetic */ j(k kVar, int i) {
        this.f14354v = i;
        this.f14355w = kVar;
    }

    @Override // j5.i
    public void d() {
        this.f14355w.V();
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        switch (this.f14354v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = this.f14355w;
                kVar.getClass();
                if (!z10) {
                    ((SwipeRefreshLayout) kVar.f14356u0.f).setRefreshing(false);
                } else {
                    try {
                        kVar.H0.f3976d = new JSONArray(str);
                        if (kVar.D0 != null) {
                            kVar.X();
                        }
                    } catch (JSONException unused) {
                        ((SwipeRefreshLayout) kVar.f14356u0.f).setRefreshing(false);
                        return;
                    }
                }
                break;
            default:
                k kVar2 = this.f14355w;
                kVar2.getClass();
                if (!z10) {
                    ((SwipeRefreshLayout) kVar2.f14356u0.f).setRefreshing(false);
                } else {
                    try {
                        kVar2.D0 = new JSONObject(str);
                        if (kVar2.H0.f3976d != null) {
                            kVar2.X();
                        }
                    } catch (JSONException unused2) {
                        ((SwipeRefreshLayout) kVar2.f14356u0.f).setRefreshing(false);
                        return;
                    }
                }
                break;
        }
    }

    @Override // v9.f
    public void p(ArrayList arrayList) {
        k kVar = this.f14355w;
        if (!kVar.G0) {
            kVar.G0 = true;
            return;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        if (iIntValue == q5.k.chipLive) {
            ((TextView) kVar.f14356u0.f2036c).setText("No Live Event Available");
            kVar.F0 = 1;
        } else if (iIntValue == q5.k.chipUpcoming) {
            ((TextView) kVar.f14356u0.f2036c).setText("No Upcoming Event Available");
            kVar.F0 = 2;
        } else if (iIntValue == q5.k.chipRecent) {
            ((TextView) kVar.f14356u0.f2036c).setText("No Recent Available");
            kVar.F0 = 3;
        } else {
            ((TextView) kVar.f14356u0.f2036c).setText("No Events Available");
            kVar.F0 = 0;
        }
        if (kVar.f14359x0 == null) {
            kVar.Y();
            return;
        }
        List listW = kVar.W(kVar.E0);
        kVar.C0 = listW;
        if (listW.isEmpty()) {
            ((LinearLayout) kVar.f14356u0.f2035b).setVisibility(0);
        } else {
            ((LinearLayout) kVar.f14356u0.f2035b).setVisibility(8);
        }
        s5.i iVar = kVar.f14359x0;
        List list = kVar.C0;
        f6.b bVar = kVar.H0;
        iVar.j(bVar.f3978g, bVar.f3979h, list);
    }
}
