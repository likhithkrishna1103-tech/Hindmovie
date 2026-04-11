package nc;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements b9.h, e5.j, pc.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8951u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ o f8952v;

    public /* synthetic */ n(o oVar, int i) {
        this.f8951u = i;
        this.f8952v = oVar;
    }

    @Override // e5.j
    public void a() {
        this.f8952v.T();
    }

    @Override // b9.h
    public void d(ArrayList arrayList) {
        o oVar = this.f8952v;
        if (!oVar.F0) {
            oVar.F0 = true;
            return;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int iIntValue = ((Integer) arrayList.get(0)).intValue();
        if (iIntValue == gc.j.chipLive) {
            ((TextView) oVar.f8953t0.f14946v).setText("No Live Event Available");
            oVar.E0 = 1;
        } else if (iIntValue == gc.j.chipUpcoming) {
            ((TextView) oVar.f8953t0.f14946v).setText("No Upcoming Event Available");
            oVar.E0 = 2;
        } else if (iIntValue == gc.j.chipFinished) {
            ((TextView) oVar.f8953t0.f14946v).setText("No Event Finished");
            oVar.E0 = 3;
        } else {
            ((TextView) oVar.f8953t0.f14946v).setText("No Events Available");
            oVar.E0 = 0;
        }
        if (oVar.f8956w0 == null) {
            oVar.W();
            return;
        }
        List listU = oVar.U(oVar.D0);
        oVar.B0 = listU;
        if (listU.isEmpty()) {
            ((LinearLayout) oVar.f8953t0.f14945u).setVisibility(0);
        } else {
            ((LinearLayout) oVar.f8953t0.f14945u).setVisibility(8);
        }
        ic.k kVar = oVar.f8956w0;
        List list = oVar.B0;
        vc.b bVar = oVar.G0;
        kVar.i(bVar.f13488g, bVar.f13489h, list);
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        switch (this.f8951u) {
            case 2:
                o oVar = this.f8952v;
                oVar.getClass();
                if (!z2) {
                    ((SwipeRefreshLayout) oVar.f8953t0.f14948x).setRefreshing(false);
                } else {
                    try {
                        oVar.G0.f13486d = new JSONArray(str);
                        if (oVar.C0 != null) {
                            oVar.V();
                        }
                    } catch (JSONException unused) {
                        ((SwipeRefreshLayout) oVar.f8953t0.f14948x).setRefreshing(false);
                        return;
                    }
                }
                break;
            default:
                o oVar2 = this.f8952v;
                oVar2.getClass();
                if (!z2) {
                    ((SwipeRefreshLayout) oVar2.f8953t0.f14948x).setRefreshing(false);
                } else {
                    try {
                        oVar2.C0 = new JSONObject(str);
                        if (oVar2.G0.f13486d != null) {
                            oVar2.V();
                        }
                    } catch (JSONException unused2) {
                        ((SwipeRefreshLayout) oVar2.f8953t0.f14948x).setRefreshing(false);
                        return;
                    }
                }
                break;
        }
    }
}
