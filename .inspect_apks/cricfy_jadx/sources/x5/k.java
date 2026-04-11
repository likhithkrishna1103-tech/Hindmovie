package x5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.emoji2.text.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.CustomLayoutManager;
import app.cricfy.tv.app.ProApplication;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k extends c {
    public List A0;
    public List B0;
    public List C0;
    public JSONObject D0;
    public String E0 = "all";
    public int F0 = 0;
    public boolean G0 = true;
    public f6.b H0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public c2.o f14356u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public tb.c f14357v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ProApplication f14358w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public s5.i f14359x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public List f14360y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public List f14361z0;

    @Override // x5.c, androidx.fragment.app.y
    public final void G(View view) {
        ((SwipeRefreshLayout) this.f14356u0.f).setRefreshing(true);
        this.f14337t0 = true;
        ProApplication proApplication = ProApplication.K;
        this.f14358w0 = proApplication;
        TextView textView = (TextView) this.f14356u0.f2037d;
        String str = proApplication.I;
        textView.setVisibility(8);
        tb.c cVar = (tb.c) this.f14356u0.f2039g;
        this.f14357v0 = cVar;
        ((ChipGroup) cVar.f11984w).setOnCheckedStateChangeListener(new j(this, 1));
        V();
        ((SwipeRefreshLayout) this.f14356u0.f).setOnRefreshListener(new j(this, 2));
        ((TextView) this.f14357v0.B).setText(this.H0.f3977e);
        ((TextView) this.f14357v0.B).setSelected(true);
        ((TextView) this.f14357v0.B).setOnClickListener(new com.google.android.material.datepicker.n(15, this));
    }

    @Override // x5.c
    public final void S(int i) {
        if (i == 3) {
            ((RecyclerView) this.f14356u0.f2038e).setLayoutManager(new CustomLayoutManager(this.f14359x0));
        } else {
            ((RecyclerView) this.f14356u0.f2038e).setLayoutManager(new LinearLayoutManager(1));
        }
        this.f14358w0.a((RecyclerView) this.f14356u0.f2038e);
    }

    @Override // x5.c
    public final void T() {
        ((SwipeRefreshLayout) this.f14356u0.f).setRefreshing(true);
        V();
    }

    @Override // x5.c
    public final void U(String str) {
        if (this.C0 == null || this.f14359x0 == null) {
            return;
        }
        if (str.isEmpty()) {
            s5.i iVar = this.f14359x0;
            List list = this.C0;
            f6.b bVar = this.H0;
            iVar.j(bVar.f3978g, bVar.f3979h, list);
            ((RecyclerView) this.f14356u0.f2038e).setVisibility(0);
            ((LinearLayout) this.f14356u0.f2035b).setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String lowerCase = str.toLowerCase();
        for (y5.e eVar : this.C0) {
            String lowerCase2 = eVar.f14926d.toLowerCase();
            String lowerCase3 = eVar.f14927e.toLowerCase();
            if (lowerCase2.contains(lowerCase) || lowerCase3.contains(lowerCase) || eVar.f14923a.toLowerCase().contains(lowerCase) || eVar.f14924b.toLowerCase().contains(lowerCase)) {
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f14356u0.f2038e).setVisibility(8);
            ((LinearLayout) this.f14356u0.f2035b).setVisibility(0);
            return;
        }
        ((RecyclerView) this.f14356u0.f2038e).setVisibility(0);
        ((LinearLayout) this.f14356u0.f2035b).setVisibility(8);
        s5.i iVar2 = this.f14359x0;
        f6.b bVar2 = this.H0;
        iVar2.j(bVar2.f3978g, bVar2.f3979h, arrayList);
    }

    public final void V() {
        android.support.v4.media.session.b.p(j(), android.support.v4.media.session.b.n(j(), "event_cats.txt"), null, new j(this, 3), false);
        android.support.v4.media.session.b.p(j(), android.support.v4.media.session.b.n(j(), "events.txt"), null, new j(this, 0), false);
    }

    public final List W(String str) {
        this.E0 = str;
        int i = this.F0;
        List<y5.e> list = i != 1 ? i != 2 ? i != 3 ? this.f14360y0 : this.A0 : this.B0 : this.f14361z0;
        if (str.equalsIgnoreCase("all")) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (y5.e eVar : list) {
            if (eVar.f14923a.trim().equals(str.trim())) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public final void X() {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2 = this.H0.f3976d;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (jSONArray2 != null) {
            int i = 0;
            while (i < jSONArray2.length()) {
                try {
                    jSONObject = new JSONObject(jSONArray2.getJSONObject(i).getString("event"));
                } catch (JSONException unused) {
                }
                if (jSONObject.getBoolean("visible")) {
                    String string = jSONObject.getString("teamAName");
                    String string2 = jSONObject.getString("teamBName");
                    y5.e eVar = new y5.e();
                    jSONArray = jSONArray2;
                    try {
                        eVar.f14935o = jSONObject.optInt("priority", -1);
                        eVar.f14923a = jSONObject.getString("category");
                        jSONObject.optString("categoryLogo", "");
                        eVar.f14924b = jSONObject.getString("eventName").trim();
                        eVar.f14926d = string;
                        eVar.f14927e = string2;
                        eVar.f = jSONObject.getString("teamAFlag");
                        eVar.f14928g = jSONObject.getString("teamBFlag");
                        eVar.f14925c = jSONObject.optString("eventLogo");
                        eVar.f14929h = jSONObject.getString("links");
                        eVar.f14930j = jSONObject.getString("date");
                        eVar.i = jSONObject.getString("time");
                        eVar.f14932l = jSONObject.optString("end_date", null);
                        eVar.f14931k = jSONObject.optString("end_time", null);
                        eVar.f14934n = j4.H(jSONObject.optJSONArray("link_names"));
                        arrayList.add(eVar);
                        if (j4.v(eVar.f14932l, eVar.f14931k)) {
                            eVar.f14933m = "ended";
                            eVar.f14936p = true;
                            arrayList3.add(eVar);
                        } else if (j4.u(eVar.f14930j, eVar.i)) {
                            eVar.f14933m = "live";
                            arrayList2.add(eVar);
                        } else {
                            eVar.f14933m = "upcoming";
                            arrayList4.add(eVar);
                        }
                    } catch (JSONException unused2) {
                    }
                } else {
                    jSONArray = jSONArray2;
                }
                i++;
                jSONArray2 = jSONArray;
            }
        }
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(y5.e.b(arrayList));
        arrayList5.add(y5.e.b(arrayList2));
        arrayList5.add(arrayList3);
        arrayList5.add(y5.e.b(arrayList4));
        this.f14360y0 = (List) arrayList5.get(0);
        this.f14361z0 = (List) arrayList5.get(1);
        this.A0 = (List) arrayList5.get(2);
        this.B0 = (List) arrayList5.get(3);
        ProApplication proApplication = ProApplication.K;
        List list = this.f14360y0;
        proApplication.A = list;
        Z(list.size(), this.f14361z0.size(), this.B0.size(), this.A0.size());
        Y();
        this.E0 = "all";
        Context contextJ = j();
        List<y5.e> list2 = this.f14360y0;
        JSONObject jSONObject2 = this.D0;
        ArrayList arrayList6 = new ArrayList();
        y5.d dVar = new y5.d();
        dVar.f14918a = "All";
        dVar.f14920c = list2.size();
        arrayList6.add(dVar);
        HashMap map = new HashMap();
        for (y5.e eVar2 : list2) {
            String strTrim = eVar2.f14923a.trim();
            y5.d dVar2 = (y5.d) map.get(strTrim);
            if (dVar2 == null) {
                dVar2 = new y5.d();
                dVar2.f14918a = strTrim;
                dVar2.f14919b = jSONObject2.optString(strTrim, "");
                dVar2.f14920c = 0;
                map.put(strTrim, dVar2);
            }
            dVar2.f14920c++;
            String str = eVar2.f14933m;
            if (str != null) {
                if ("ended".equals(str)) {
                    dVar2.f14922e++;
                } else if ("live".equals(eVar2.f14933m)) {
                    dVar2.f14921d++;
                } else if ("upcoming".equals(eVar2.f14933m)) {
                    dVar2.f++;
                }
            }
        }
        arrayList6.addAll(map.values());
        Collections.sort(arrayList6, new p2.s(2, Arrays.asList("All", "Football", "Cricket", "Boxing", "Motorsport", "Motorsports", "Basketball", "Baseball", "WWE", "Wwe")));
        ((RecyclerView) this.f14357v0.A).setAdapter(new m4.l(contextJ, arrayList6, new j(this, 4)));
        ((RecyclerView) this.f14357v0.A).setLayoutManager(new LinearLayoutManager(0));
    }

    public final void Y() {
        if (h() == null) {
            return;
        }
        ((SwipeRefreshLayout) this.f14356u0.f).setRefreshing(false);
        int i = this.F0;
        List list = i != 1 ? i != 2 ? i != 3 ? this.f14360y0 : this.A0 : this.B0 : this.f14361z0;
        this.C0 = list;
        if (list == null || list.isEmpty()) {
            ((LinearLayout) this.f14356u0.f2035b).setVisibility(0);
            return;
        }
        ((LinearLayout) this.f14356u0.f2035b).setVisibility(8);
        ProApplication proApplication = this.f14358w0;
        String str = this.H0.f3978g;
        proApplication.getClass();
        ProApplication proApplication2 = this.f14358w0;
        String str2 = this.H0.f3979h;
        proApplication2.getClass();
        s5.i iVar = this.f14359x0;
        if (iVar != null) {
            List list2 = this.C0;
            f6.b bVar = this.H0;
            iVar.j(bVar.f3978g, bVar.f3979h, list2);
            ((RecyclerView) this.f14356u0.f2038e).j0(0);
            return;
        }
        h.j jVarJ = J();
        List list3 = this.C0;
        f6.b bVar2 = this.H0;
        s5.i iVar2 = new s5.i(jVarJ, list3, bVar2.f3978g, bVar2.f3979h);
        this.f14359x0 = iVar2;
        ((RecyclerView) this.f14356u0.f2038e).setAdapter(iVar2);
        if (R()) {
            ((RecyclerView) this.f14356u0.f2038e).setLayoutManager(new CustomLayoutManager(this.f14359x0));
        } else {
            ((RecyclerView) this.f14356u0.f2038e).setLayoutManager(new LinearLayoutManager(1));
        }
        this.f14358w0.a((RecyclerView) this.f14356u0.f2038e);
    }

    public final void Z(int i, int i10, int i11, int i12) {
        ((Chip) this.f14357v0.f11983v).setText("All (" + i + ")");
        ((Chip) this.f14357v0.f11985x).setText("Live (" + i10 + ")");
        ((Chip) this.f14357v0.f11987z).setText("Upcoming (" + i11 + ")");
        ((Chip) this.f14357v0.f11986y).setText("Recent (" + i12 + ")");
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        this.H0 = (f6.b) new v(J()).r(f6.b.class);
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewL;
        View viewInflate = layoutInflater.inflate(q5.l.fragment_event, (ViewGroup) null, false);
        int i = q5.k.no_event_layout;
        LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
        if (linearLayout != null) {
            i = q5.k.not_available;
            TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
            if (textView != null) {
                i = q5.k.not_img;
                if (((ImageView) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
                    i = q5.k.pTxt;
                    TextView textView2 = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                    if (textView2 != null) {
                        i = q5.k.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                        if (recyclerView != null) {
                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate;
                            i = q5.k.top;
                            if (((LinearLayout) android.support.v4.media.session.b.l(viewInflate, i)) != null && (viewL = android.support.v4.media.session.b.l(viewInflate, (i = q5.k.top_container))) != null) {
                                int i10 = q5.k.chipAll;
                                Chip chip = (Chip) android.support.v4.media.session.b.l(viewL, i10);
                                if (chip != null) {
                                    i10 = q5.k.chipGroupFilter;
                                    ChipGroup chipGroup = (ChipGroup) android.support.v4.media.session.b.l(viewL, i10);
                                    if (chipGroup != null) {
                                        i10 = q5.k.chipLive;
                                        Chip chip2 = (Chip) android.support.v4.media.session.b.l(viewL, i10);
                                        if (chip2 != null) {
                                            i10 = q5.k.chipRecent;
                                            Chip chip3 = (Chip) android.support.v4.media.session.b.l(viewL, i10);
                                            if (chip3 != null) {
                                                i10 = q5.k.chipUpcoming;
                                                Chip chip4 = (Chip) android.support.v4.media.session.b.l(viewL, i10);
                                                if (chip4 != null) {
                                                    i10 = q5.k.event_type_rv;
                                                    RecyclerView recyclerView2 = (RecyclerView) android.support.v4.media.session.b.l(viewL, i10);
                                                    if (recyclerView2 != null) {
                                                        i10 = q5.k.message_txt;
                                                        TextView textView3 = (TextView) android.support.v4.media.session.b.l(viewL, i10);
                                                        if (textView3 != null) {
                                                            this.f14356u0 = new c2.o(swipeRefreshLayout, linearLayout, textView, textView2, recyclerView, swipeRefreshLayout, new tb.c(chip, chipGroup, chip2, chip3, chip4, recyclerView2, textView3), 10);
                                                            return swipeRefreshLayout;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                throw new NullPointerException("Missing required view with ID: ".concat(viewL.getResources().getResourceName(i10)));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
