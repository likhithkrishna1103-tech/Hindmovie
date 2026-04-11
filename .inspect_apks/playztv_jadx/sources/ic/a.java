package ic;

import a2.o0;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.n0;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.textfield.TextInputEditText;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.services.FloatingPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6487u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6488v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f6489w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f6490x;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, int i) {
        this.f6487u = i;
        this.f6488v = obj;
        this.f6489w = obj2;
        this.f6490x = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6487u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar = (c) this.f6488v;
                oc.b bVar = (oc.b) this.f6489w;
                String str = (String) this.f6490x;
                Context context = cVar.f6494d;
                String str2 = bVar.f9513c;
                String str3 = bVar.f9514d;
                if (str3.equals("custom")) {
                    str2 = uc.b.f(context).getString("api_host", "https://error_pro.com") + bVar.f9513c;
                }
                nc.m mVar = cVar.f6496g;
                if (mVar == null) {
                    nc.m mVar2 = new nc.m();
                    Bundle bundle = new Bundle();
                    bundle.putString("api", str2);
                    bundle.putString("type", str3);
                    mVar2.L(bundle);
                    cVar.f6496g = mVar2;
                    n0 n0VarO = ((h.j) context).o();
                    androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                    aVarI.e(cVar.f6497h ? gc.j.sp_channels_fragment_container : gc.j.channels_fragment_container, cVar.f6496g, null, 1);
                    aVarI.d(false);
                } else {
                    mVar.V(str2, str3);
                }
                cVar.f6495e.c(cVar.f6496g, str);
                break;
            case 1:
                i4.n nVar = (i4.n) this.f6488v;
                l lVar = (l) this.f6489w;
                oc.d dVar = (oc.d) this.f6490x;
                l lVar2 = (l) nVar.f6239h;
                if (lVar != lVar2) {
                    lVar2.f6528u.setStrokeColor(0);
                    lVar.f6528u.setStrokeColor(((Context) nVar.f6237e).getColor(gc.h.app_color));
                    nVar.f6239h = lVar;
                    nc.n nVar2 = (nc.n) nVar.f;
                    String str4 = dVar.f9521a;
                    int i = dVar.f9523c;
                    int i10 = dVar.f9524d;
                    int i11 = dVar.f;
                    int i12 = dVar.f9525e;
                    nc.o oVar = nVar2.f8952v;
                    if (i == oVar.f8957x0.size()) {
                        oVar.X(oVar.f8957x0.size(), oVar.f8958y0.size(), oVar.A0.size(), oVar.f8959z0.size());
                    } else {
                        oVar.X(i, i10, i11, i12);
                    }
                    List listU = oVar.U(str4);
                    oVar.B0 = listU;
                    if (listU.isEmpty()) {
                        ((LinearLayout) oVar.f8953t0.f14945u).setVisibility(0);
                    } else {
                        ((LinearLayout) oVar.f8953t0.f14945u).setVisibility(8);
                    }
                    k kVar = oVar.f8956w0;
                    if (kVar != null) {
                        List list = oVar.B0;
                        vc.b bVar2 = oVar.G0;
                        kVar.i(bVar2.f13488g, bVar2.f13489h, list);
                    }
                }
                break;
            case 2:
                zc.c cVar2 = (zc.c) this.f6488v;
                h.g gVar = (h.g) this.f6489w;
                lc.b bVar3 = (lc.b) this.f6490x;
                TextInputEditText textInputEditText = (TextInputEditText) cVar2.f14948x;
                TextInputEditText textInputEditText2 = (TextInputEditText) cVar2.f14946v;
                TextInputEditText textInputEditText3 = (TextInputEditText) cVar2.f14949y;
                TextInputEditText textInputEditText4 = (TextInputEditText) cVar2.f14947w;
                String string = textInputEditText.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    String string2 = textInputEditText4.getText().toString();
                    if (!TextUtils.isEmpty(string2)) {
                        String string3 = textInputEditText3.getText().toString();
                        String string4 = textInputEditText2.getText().toString();
                        if (((LinearLayout) cVar2.f14945u).getVisibility() == 0) {
                            if (TextUtils.isEmpty(string3)) {
                                textInputEditText3.setError("Mast not be empty.");
                            } else if (TextUtils.isEmpty(string4)) {
                                textInputEditText2.setError("Mast not be empty.");
                            }
                        }
                        bVar3.l(string, string2, string3, string4);
                        gVar.dismiss();
                    } else {
                        textInputEditText4.setError("Mast not be empty.");
                    }
                } else {
                    ((TextInputEditText) cVar2.f14948x).setError("Enter playlist title.");
                }
                break;
            default:
                FloatingPlayer floatingPlayer = (FloatingPlayer) this.f6488v;
                tc.g gVar2 = (tc.g) this.f6489w;
                View view2 = (View) this.f6490x;
                ArrayList arrayList = floatingPlayer.f3686v;
                LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                if (landscapeActivity != null) {
                    landscapeActivity.finish();
                }
                o0 o0Var = gVar2.f;
                if (o0Var != null) {
                    o0Var.F1();
                    gVar2.f = null;
                    gVar2.f12465c = null;
                    gVar2.f12466d = null;
                    gVar2.f12467e = null;
                    gVar2.f12468g = null;
                }
                floatingPlayer.f3685u.removeView(view2);
                arrayList.remove(view2);
                floatingPlayer.f3687w.remove(gVar2);
                if (arrayList.isEmpty()) {
                    floatingPlayer.stopSelf();
                }
                break;
        }
    }
}
