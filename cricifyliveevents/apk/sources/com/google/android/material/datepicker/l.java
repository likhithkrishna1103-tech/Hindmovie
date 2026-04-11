package com.google.android.material.datepicker;

import android.os.Message;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.TrackSelectionView;
import com.google.android.material.internal.NavigationMenuItemView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m4.t0;
import o.k3;
import ua.i0;
import v1.g1;
import v1.h1;
import v1.m1;
import v5.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2864v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f2865w;

    public /* synthetic */ l(int i, Object obj) {
        this.f2864v = i;
        this.f2865w = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f2864v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = (m) this.f2865w;
                int i = mVar.f2869w0;
                if (i == 2) {
                    mVar.S(1);
                    mVar.f2872z0.announceForAccessibility(mVar.m().getString(k9.j.mtrl_picker_toggled_to_day_selection));
                } else if (i == 1) {
                    mVar.S(2);
                    mVar.f2871y0.announceForAccessibility(mVar.m().getString(k9.j.mtrl_picker_toggled_to_year_selection));
                }
                break;
            case 1:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                da.t tVar = (da.t) this.f2865w;
                da.l lVar = tVar.f3633z;
                boolean z10 = true;
                if (lVar != null) {
                    lVar.f = true;
                }
                n.m itemData = navigationMenuItemView.getItemData();
                boolean zQ = tVar.f3631x.q(itemData, tVar, 0);
                if (itemData != null && itemData.isCheckable() && zQ) {
                    tVar.f3633z.i(itemData);
                } else {
                    z10 = false;
                }
                da.l lVar2 = tVar.f3633z;
                if (lVar2 != null) {
                    lVar2.f = false;
                }
                if (z10) {
                    tVar.e();
                }
                break;
            case 2:
                DrawerLayout drawerLayout = ((h.a) this.f2865w).f5258b;
                int iH = drawerLayout.h(8388611);
                View viewF = drawerLayout.f(8388611);
                if ((viewF != null ? DrawerLayout.p(viewF) : false) && iH != 2) {
                    drawerLayout.d();
                } else if (iH != 1) {
                    drawerLayout.r();
                }
                break;
            case 3:
                h.f fVar = (h.f) this.f2865w;
                Message messageObtain = (view != fVar.i || (message3 = fVar.f5330k) == null) ? (view != fVar.f5331l || (message2 = fVar.f5333n) == null) ? (view != fVar.f5334o || (message = fVar.f5336q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                fVar.E.obtainMessage(1, fVar.f5323b).sendToTarget();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.f2865w;
                HashMap map = trackSelectionView.B;
                boolean z11 = true;
                if (view == trackSelectionView.f1317x) {
                    trackSelectionView.G = true;
                    map.clear();
                } else if (view == trackSelectionView.f1318y) {
                    trackSelectionView.G = false;
                    map.clear();
                } else {
                    trackSelectionView.G = false;
                    Object tag = view.getTag();
                    tag.getClass();
                    t0 t0Var = (t0) tag;
                    m1 m1Var = t0Var.f8264a;
                    g1 g1Var = m1Var.f12873b;
                    int i10 = t0Var.f8265b;
                    h1 h1Var = (h1) map.get(g1Var);
                    if (h1Var == null) {
                        if (!trackSelectionView.D && map.size() > 0) {
                            map.clear();
                        }
                        map.put(g1Var, new h1(g1Var, i0.o(Integer.valueOf(i10))));
                    } else {
                        ArrayList arrayList = new ArrayList(h1Var.f12712b);
                        boolean zIsChecked = ((CheckedTextView) view).isChecked();
                        boolean z12 = trackSelectionView.C && m1Var.f12874c;
                        if (!z12 && (!trackSelectionView.D || trackSelectionView.A.size() <= 1)) {
                            z11 = false;
                        }
                        if (zIsChecked && z11) {
                            arrayList.remove(Integer.valueOf(i10));
                            if (arrayList.isEmpty()) {
                                map.remove(g1Var);
                            } else {
                                map.put(g1Var, new h1(g1Var, arrayList));
                            }
                        } else if (!zIsChecked) {
                            if (z12) {
                                arrayList.add(Integer.valueOf(i10));
                                map.put(g1Var, new h1(g1Var, arrayList));
                            } else {
                                map.put(g1Var, new h1(g1Var, i0.o(Integer.valueOf(i10))));
                            }
                        }
                    }
                }
                trackSelectionView.b();
                s.a aVar = trackSelectionView.H;
                if (aVar != null) {
                    boolean isDisabled = trackSelectionView.getIsDisabled();
                    Map<g1, h1> overrides = trackSelectionView.getOverrides();
                    aVar.f13454v0 = isDisabled;
                    aVar.f13455w0 = overrides;
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ((m.a) this.f2865w).a();
                break;
            default:
                k3 k3Var = ((Toolbar) this.f2865w).f612k0;
                n.m mVar2 = k3Var == null ? null : k3Var.f9257w;
                if (mVar2 != null) {
                    mVar2.collapseActionView();
                }
                break;
        }
    }
}
