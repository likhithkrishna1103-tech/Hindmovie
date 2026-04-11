package x5;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements j5.i, z5.k, h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f14338v;

    public /* synthetic */ d(e eVar) {
        this.f14338v = eVar;
    }

    @Override // x5.h
    public void b(i iVar, String str) {
        e eVar = this.f14338v;
        h hVar = eVar.f14341w0;
        if (hVar == null) {
            return;
        }
        hVar.b(iVar, str);
        m4.l lVar = eVar.f14343y0;
        ArrayList arrayList = eVar.f14342x0;
        lVar.getClass();
        lVar.f8185g = new ArrayList(arrayList);
        lVar.d();
    }

    @Override // j5.i
    public void d() {
        this.f14338v.V();
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        e eVar = this.f14338v;
        if (!z10) {
            ((SwipeRefreshLayout) eVar.f14339u0.A).setRefreshing(false);
            return;
        }
        try {
            eVar.W(new JSONArray(str));
        } catch (JSONException unused) {
            ((SwipeRefreshLayout) eVar.f14339u0.A).setRefreshing(false);
        }
    }
}
