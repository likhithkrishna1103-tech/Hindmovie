package com.google.android.material.datepicker;

import aa.j0;
import android.os.Message;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.TrackSelectionView;
import com.google.android.material.internal.NavigationMenuItemView;
import i4.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lc.n;
import n.h3;
import p1.g1;
import p1.h1;
import p1.m1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f3408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f3409v;

    public /* synthetic */ l(int i, Object obj) {
        this.f3408u = i;
        this.f3409v = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f3408u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = (m) this.f3409v;
                int i = mVar.f3413v0;
                if (i == 2) {
                    mVar.Q(1);
                } else if (i == 1) {
                    mVar.Q(2);
                }
                break;
            case 1:
                DrawerLayout drawerLayout = ((h.a) this.f3409v).f5395b;
                int iH = drawerLayout.h(8388611);
                View viewF = drawerLayout.f(8388611);
                if ((viewF != null ? DrawerLayout.p(viewF) : false) && iH != 2) {
                    drawerLayout.d();
                } else if (iH != 1) {
                    drawerLayout.r();
                }
                break;
            case 2:
                h.e eVar = (h.e) this.f3409v;
                Message messageObtain = (view != eVar.i || (message3 = eVar.f5469k) == null) ? (view != eVar.f5470l || (message2 = eVar.f5472n) == null) ? (view != eVar.f5473o || (message = eVar.f5475q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                eVar.E.obtainMessage(1, eVar.f5462b).sendToTarget();
                break;
            case 3:
                TrackSelectionView trackSelectionView = (TrackSelectionView) this.f3409v;
                HashMap map = trackSelectionView.A;
                boolean z2 = true;
                if (view == trackSelectionView.f1625w) {
                    trackSelectionView.F = true;
                    map.clear();
                } else if (view == trackSelectionView.f1626x) {
                    trackSelectionView.F = false;
                    map.clear();
                } else {
                    trackSelectionView.F = false;
                    Object tag = view.getTag();
                    tag.getClass();
                    w0 w0Var = (w0) tag;
                    m1 m1Var = w0Var.f6323a;
                    g1 g1Var = m1Var.f9944b;
                    int i10 = w0Var.f6324b;
                    h1 h1Var = (h1) map.get(g1Var);
                    if (h1Var == null) {
                        if (!trackSelectionView.C && map.size() > 0) {
                            map.clear();
                        }
                        map.put(g1Var, new h1(g1Var, j0.v(Integer.valueOf(i10))));
                    } else {
                        ArrayList arrayList = new ArrayList(h1Var.f9784b);
                        boolean zIsChecked = ((CheckedTextView) view).isChecked();
                        boolean z10 = trackSelectionView.B && m1Var.f9945c;
                        if (!z10 && (!trackSelectionView.C || trackSelectionView.f1628z.size() <= 1)) {
                            z2 = false;
                        }
                        if (zIsChecked && z2) {
                            arrayList.remove(Integer.valueOf(i10));
                            if (arrayList.isEmpty()) {
                                map.remove(g1Var);
                            } else {
                                map.put(g1Var, new h1(g1Var, arrayList));
                            }
                        } else if (!zIsChecked) {
                            if (z10) {
                                arrayList.add(Integer.valueOf(i10));
                                map.put(g1Var, new h1(g1Var, arrayList));
                            } else {
                                map.put(g1Var, new h1(g1Var, j0.v(Integer.valueOf(i10))));
                            }
                        }
                    }
                }
                trackSelectionView.b();
                n.a aVar = trackSelectionView.G;
                if (aVar != null) {
                    boolean isDisabled = trackSelectionView.getIsDisabled();
                    Map<g1, h1> overrides = trackSelectionView.getOverrides();
                    aVar.f8116u0 = isDisabled;
                    aVar.f8117v0 = overrides;
                }
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                j9.t tVar = (j9.t) this.f3409v;
                j9.l lVar = tVar.f6905y;
                boolean z11 = true;
                if (lVar != null) {
                    lVar.f = true;
                }
                m.m itemData = navigationMenuItemView.getItemData();
                boolean zQ = tVar.f6903w.q(itemData, tVar, 0);
                if (itemData != null && itemData.isCheckable() && zQ) {
                    tVar.f6905y.h(itemData);
                } else {
                    z11 = false;
                }
                j9.l lVar2 = tVar.f6905y;
                if (lVar2 != null) {
                    lVar2.f = false;
                }
                if (z11) {
                    tVar.f(false);
                }
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                m.m itemData2 = ((l9.e) view).getItemData();
                v8.b bVar = (v8.b) this.f3409v;
                if (!bVar.f8041b0.q(itemData2, bVar.f8040a0, 0)) {
                    itemData2.setChecked(true);
                }
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ((l.a) this.f3409v).a();
                break;
            default:
                h3 h3Var = ((Toolbar) this.f3409v).f935j0;
                m.m mVar2 = h3Var == null ? null : h3Var.f8397v;
                if (mVar2 != null) {
                    mVar2.collapseActionView();
                }
                break;
        }
    }
}
