package d6;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.LandscapeActivity;
import app.cricfy.tv.services.FloatingPlayer;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import g2.g0;
import java.util.ArrayList;
import java.util.List;
import m4.l;
import s5.o;
import s5.p;
import v5.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3399v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3400w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3401x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3402y;

    public /* synthetic */ b(Object obj, Object obj2, Object obj3, int i) {
        this.f3399v = i;
        this.f3400w = obj;
        this.f3401x = obj2;
        this.f3402y = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3399v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                FloatingPlayer floatingPlayer = (FloatingPlayer) this.f3400w;
                k kVar = (k) this.f3401x;
                View view2 = (View) this.f3402y;
                ArrayList arrayList = floatingPlayer.f1576w;
                LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                if (landscapeActivity != null) {
                    landscapeActivity.finish();
                }
                g0 g0Var = kVar.f;
                if (g0Var != null) {
                    g0Var.C1();
                    kVar.f = null;
                    kVar.f3424c = null;
                    kVar.f3425d = null;
                    kVar.f3426e = null;
                    kVar.f3427g = null;
                }
                floatingPlayer.f1575v.removeView(view2);
                arrayList.remove(view2);
                floatingPlayer.f1577x.remove(kVar);
                if (arrayList.isEmpty()) {
                    floatingPlayer.stopSelf();
                }
                break;
            case 1:
                l lVar = (l) this.f3400w;
                y5.b bVar = (y5.b) this.f3401x;
                String str = (String) this.f3402y;
                Context context = (Context) lVar.f8184e;
                String str2 = bVar.f14911c;
                String str3 = bVar.f14912d;
                if (str3.equals("custom")) {
                    str2 = com.bumptech.glide.d.s(context) + bVar.f14911c;
                }
                x5.i iVar = (x5.i) lVar.f8186h;
                if (iVar == null) {
                    lVar.f8186h = x5.i.X(str2, str3, false);
                    r0 r0VarO = ((h.j) context).o();
                    androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                    aVarF.f(q5.k.channels_fragment_container, (x5.i) lVar.f8186h, null, 1);
                    aVarF.e(false);
                } else {
                    iVar.Y(str2, str3);
                }
                ((x5.d) lVar.f).b((x5.i) lVar.f8186h, str);
                break;
            case 2:
                l lVar2 = (l) this.f3400w;
                s5.j jVar = (s5.j) this.f3401x;
                y5.d dVar = (y5.d) this.f3402y;
                s5.j jVar2 = (s5.j) lVar2.f8186h;
                if (jVar != jVar2) {
                    jVar2.f11503u.setSelected(false);
                    jVar.f11503u.setSelected(true);
                    lVar2.f8186h = jVar;
                    x5.j jVar3 = (x5.j) lVar2.f;
                    String str4 = dVar.f14918a;
                    int i = dVar.f14920c;
                    int i10 = dVar.f14921d;
                    int i11 = dVar.f;
                    int i12 = dVar.f14922e;
                    x5.k kVar2 = jVar3.f14355w;
                    if (i == kVar2.f14360y0.size()) {
                        kVar2.Z(kVar2.f14360y0.size(), kVar2.f14361z0.size(), kVar2.B0.size(), kVar2.A0.size());
                    } else {
                        kVar2.Z(i, i10, i11, i12);
                    }
                    List listW = kVar2.W(str4);
                    kVar2.C0 = listW;
                    if (listW.isEmpty()) {
                        ((LinearLayout) kVar2.f14356u0.f2035b).setVisibility(0);
                    } else {
                        ((LinearLayout) kVar2.f14356u0.f2035b).setVisibility(8);
                    }
                    s5.i iVar2 = kVar2.f14359x0;
                    if (iVar2 != null) {
                        List list = kVar2.C0;
                        f6.b bVar2 = kVar2.H0;
                        iVar2.j(bVar2.f3978g, bVar2.f3979h, list);
                    }
                }
                break;
            case 3:
                p pVar = (p) this.f3400w;
                b6.h hVar = (b6.h) this.f3401x;
                o oVar = (o) this.f3402y;
                new v5.i(pVar.f11521e, hVar.f1810b, hVar.f1811c, hVar.f1812d, hVar.f1813e).show();
                if (!hVar.f) {
                    oVar.f11519y.setVisibility(8);
                    hVar.f = true;
                    new Thread(new nc.i(6, pVar, hVar)).start();
                }
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                dd.c cVar = (dd.c) this.f3400w;
                h.h hVar2 = (h.h) this.f3401x;
                v5.b bVar3 = (v5.b) this.f3402y;
                TextInputEditText textInputEditText = (TextInputEditText) cVar.f3675z;
                TextInputEditText textInputEditText2 = (TextInputEditText) cVar.f3673x;
                TextInputEditText textInputEditText3 = (TextInputEditText) cVar.A;
                TextInputEditText textInputEditText4 = (TextInputEditText) cVar.f3674y;
                String string = textInputEditText.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    String string2 = textInputEditText4.getText().toString();
                    if (!TextUtils.isEmpty(string2)) {
                        String string3 = textInputEditText3.getText().toString();
                        String string4 = textInputEditText2.getText().toString();
                        if (((LinearLayout) cVar.f3672w).getVisibility() == 0) {
                            if (TextUtils.isEmpty(string3)) {
                                textInputEditText3.setError("Mast not be empty.");
                            } else if (TextUtils.isEmpty(string4)) {
                                textInputEditText2.setError("Mast not be empty.");
                            }
                        }
                        bVar3.a(string, string2, string3, string4);
                        hVar2.dismiss();
                    } else {
                        textInputEditText4.setError("Mast not be empty.");
                    }
                } else {
                    ((TextInputEditText) cVar.f3675z).setError("Enter playlist title.");
                }
                break;
            default:
                m mVar = (m) this.f3400w;
                TextInputLayout textInputLayout = (TextInputLayout) this.f3401x;
                TextInputEditText textInputEditText5 = (TextInputEditText) this.f3402y;
                mVar.getClass();
                if (!"Clear".contentEquals(((Object) textInputLayout.getEndIconContentDescription()) + "")) {
                    textInputEditText5.setText(j4.r(mVar.getContext()));
                } else {
                    textInputEditText5.setText("");
                }
                break;
        }
    }
}
