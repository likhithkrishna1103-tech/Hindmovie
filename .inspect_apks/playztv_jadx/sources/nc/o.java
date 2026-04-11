package nc;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.playz.tv.CustomLayoutManager;
import com.playz.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class o extends f {
    public List A0;
    public List B0;
    public JSONObject C0;
    public String D0 = "all";
    public int E0 = 0;
    public boolean F0 = true;
    public vc.b G0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public zc.c f8953t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public dd.h f8954u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ProApplication f8955v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ic.k f8956w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public List f8957x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public List f8958y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public List f8959z0;

    @Override // androidx.fragment.app.v
    public final void D() {
        ((SwipeRefreshLayout) this.f8953t0.f14948x).setRefreshing(true);
        this.f8930s0 = true;
        this.f8955v0 = (ProApplication) G().getApplication();
        dd.h hVar = (dd.h) this.f8953t0.f14949y;
        this.f8954u0 = hVar;
        ((ChipGroup) hVar.f4153c).setOnCheckedStateChangeListener(new n(this, 0));
        T();
        ((SwipeRefreshLayout) this.f8953t0.f14948x).setOnRefreshListener(new n(this, 1));
        ((TextView) this.f8954u0.f4157h).setText(this.G0.f13487e);
        ((TextView) this.f8954u0.f4157h).setSelected(true);
        ((MaterialCardView) this.f8954u0.f4156g).setOnClickListener(new com.google.android.material.datepicker.n(10, this));
    }

    @Override // nc.f
    public final void Q(int i) {
        if (i == 3) {
            ((RecyclerView) this.f8953t0.f14947w).setLayoutManager(new CustomLayoutManager(this.f8956w0));
        } else {
            ((RecyclerView) this.f8953t0.f14947w).setLayoutManager(new LinearLayoutManager(1));
        }
    }

    @Override // nc.f
    public final void R() {
        ((SwipeRefreshLayout) this.f8953t0.f14948x).setRefreshing(true);
        T();
    }

    @Override // nc.f
    public final void S(String str) {
        if (this.B0 == null || this.f8956w0 == null) {
            return;
        }
        if (str.isEmpty()) {
            ic.k kVar = this.f8956w0;
            List list = this.B0;
            vc.b bVar = this.G0;
            kVar.i(bVar.f13488g, bVar.f13489h, list);
            ((RecyclerView) this.f8953t0.f14947w).setVisibility(0);
            ((LinearLayout) this.f8953t0.f14945u).setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String lowerCase = str.toLowerCase();
        for (oc.e eVar : this.B0) {
            String lowerCase2 = eVar.f9529d.toLowerCase();
            String lowerCase3 = eVar.f9530e.toLowerCase();
            if (lowerCase2.contains(lowerCase) || lowerCase3.contains(lowerCase) || eVar.f9526a.toLowerCase().contains(lowerCase) || eVar.f9527b.toLowerCase().contains(lowerCase)) {
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f8953t0.f14947w).setVisibility(8);
            ((LinearLayout) this.f8953t0.f14945u).setVisibility(0);
            return;
        }
        ((RecyclerView) this.f8953t0.f14947w).setVisibility(0);
        ((LinearLayout) this.f8953t0.f14945u).setVisibility(8);
        ic.k kVar2 = this.f8956w0;
        vc.b bVar2 = this.G0;
        kVar2.i(bVar2.f13488g, bVar2.f13489h, arrayList);
    }

    public final void T() {
        ga.b.p(j(), ga.b.n(j(), "event_cats.txt"), new n(this, 3));
        ga.b.p(j(), ga.b.n(j(), "events.txt"), new n(this, 2));
    }

    public final List U(String str) {
        this.D0 = str;
        int i = this.E0;
        List<oc.e> list = i != 1 ? i != 2 ? i != 3 ? this.f8957x0 : this.f8959z0 : this.A0 : this.f8958y0;
        if (str.equalsIgnoreCase("all")) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (oc.e eVar : list) {
            if (eVar.f9526a.trim().equals(str.trim())) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public final void V() {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2 = this.G0.f13486d;
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
                    oc.e eVar = new oc.e();
                    jSONArray = jSONArray2;
                    try {
                        eVar.f9538o = jSONObject.optInt("priority", -1);
                        eVar.f9526a = jSONObject.getString("category");
                        jSONObject.optString("categoryLogo", "");
                        eVar.f9527b = jSONObject.getString("eventName").trim();
                        eVar.f9529d = string;
                        eVar.f9530e = string2;
                        eVar.f = jSONObject.getString("teamAFlag");
                        eVar.f9531g = jSONObject.getString("teamBFlag");
                        eVar.f9528c = jSONObject.optString("eventLogo");
                        eVar.f9532h = jSONObject.getString("links");
                        eVar.f9533j = jSONObject.getString("date");
                        eVar.i = jSONObject.getString("time");
                        eVar.f9535l = jSONObject.optString("end_date", null);
                        eVar.f9534k = jSONObject.optString("end_time", null);
                        eVar.f9537n = uc.b.w(jSONObject.optJSONArray("link_names"));
                        arrayList.add(eVar);
                        if (uc.b.m(eVar.f9535l, eVar.f9534k)) {
                            eVar.f9536m = "ended";
                            eVar.f9539p = true;
                            arrayList3.add(eVar);
                        } else if (uc.b.l(eVar.f9533j, eVar.i)) {
                            eVar.f9536m = "live";
                            arrayList2.add(eVar);
                        } else {
                            eVar.f9536m = "upcoming";
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
        arrayList5.add(oc.e.b(arrayList));
        arrayList5.add(oc.e.b(arrayList2));
        arrayList5.add(arrayList3);
        arrayList5.add(oc.e.b(arrayList4));
        this.f8957x0 = (List) arrayList5.get(0);
        this.f8958y0 = (List) arrayList5.get(1);
        this.f8959z0 = (List) arrayList5.get(2);
        this.A0 = (List) arrayList5.get(3);
        ProApplication proApplication = ProApplication.I;
        List list = this.f8957x0;
        proApplication.f3682z = list;
        X(list.size(), this.f8958y0.size(), this.A0.size(), this.f8959z0.size());
        W();
        this.D0 = "all";
        Context contextJ = j();
        List<oc.e> list2 = this.f8957x0;
        JSONObject jSONObject2 = this.C0;
        ArrayList arrayList6 = new ArrayList();
        oc.d dVar = new oc.d();
        dVar.f9521a = "All";
        dVar.f9523c = list2.size();
        arrayList6.add(dVar);
        HashMap map = new HashMap();
        for (oc.e eVar2 : list2) {
            String strTrim = eVar2.f9526a.trim();
            oc.d dVar2 = (oc.d) map.get(strTrim);
            if (dVar2 == null) {
                dVar2 = new oc.d();
                dVar2.f9521a = strTrim;
                dVar2.f9522b = jSONObject2.optString(strTrim, "");
                dVar2.f9523c = 0;
                map.put(strTrim, dVar2);
            }
            dVar2.f9523c++;
            String str = eVar2.f9536m;
            if (str != null) {
                if ("ended".equals(str)) {
                    dVar2.f9525e++;
                } else if ("live".equals(eVar2.f9536m)) {
                    dVar2.f9524d++;
                } else if ("upcoming".equals(eVar2.f9536m)) {
                    dVar2.f++;
                }
            }
        }
        arrayList6.addAll(map.values());
        Collections.sort(arrayList6, new j2.t(1, Arrays.asList("All", "Football", "Cricket", "Boxing", "Motorsport", "Motorsports", "Basketball", "Baseball", "WWE", "Wwe")));
        ((RecyclerView) this.f8954u0.f).setAdapter(new i4.n(contextJ, arrayList6, new n(this, 4)));
        ((RecyclerView) this.f8954u0.f).setLayoutManager(new LinearLayoutManager(0));
    }

    public final void W() {
        if (h() == null) {
            return;
        }
        ((SwipeRefreshLayout) this.f8953t0.f14948x).setRefreshing(false);
        int i = this.E0;
        List list = i != 1 ? i != 2 ? i != 3 ? this.f8957x0 : this.f8959z0 : this.A0 : this.f8958y0;
        this.B0 = list;
        if (list == null || list.isEmpty()) {
            ((LinearLayout) this.f8953t0.f14945u).setVisibility(0);
            return;
        }
        ((LinearLayout) this.f8953t0.f14945u).setVisibility(8);
        ProApplication proApplication = this.f8955v0;
        String str = this.G0.f13488g;
        proApplication.getClass();
        ProApplication proApplication2 = this.f8955v0;
        String str2 = this.G0.f13489h;
        proApplication2.getClass();
        ic.k kVar = this.f8956w0;
        if (kVar != null) {
            List list2 = this.B0;
            vc.b bVar = this.G0;
            kVar.i(bVar.f13488g, bVar.f13489h, list2);
            ((RecyclerView) this.f8953t0.f14947w).j0(0);
            return;
        }
        h.j jVarG = G();
        List list3 = this.B0;
        vc.b bVar2 = this.G0;
        ic.k kVar2 = new ic.k(jVarG, list3, bVar2.f13488g, bVar2.f13489h);
        this.f8956w0 = kVar2;
        ((RecyclerView) this.f8953t0.f14947w).setAdapter(kVar2);
        if (P()) {
            ((RecyclerView) this.f8953t0.f14947w).setLayoutManager(new CustomLayoutManager(this.f8956w0));
        } else {
            ((RecyclerView) this.f8953t0.f14947w).setLayoutManager(new LinearLayoutManager(1));
        }
    }

    public final void X(int i, int i10, int i11, int i12) {
        ((Chip) this.f8954u0.f4151a).setText("All (" + i + ")");
        ((Chip) this.f8954u0.f4154d).setText("Live (" + i10 + ")");
        ((Chip) this.f8954u0.f4155e).setText("Upcoming (" + i11 + ")");
        ((Chip) this.f8954u0.f4152b).setText("Finished (" + i12 + ")");
    }

    @Override // androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        this.G0 = (vc.b) new a7.b(G()).s(vc.b.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d5 A[PHI: r1
      0x00d5: PHI (r1v2 int) = (r1v1 int), (r1v5 int), (r1v6 int), (r1v7 int) binds: [B:3:0x0014, B:5:0x001e, B:7:0x0028, B:9:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.fragment.app.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View w(android.view.LayoutInflater r18, android.view.ViewGroup r19) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.o.w(android.view.LayoutInflater, android.view.ViewGroup):android.view.View");
    }
}
