package nc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.tabs.TabLayout;
import com.playz.tv.CustomLayoutManager;
import com.playz.tv.app.ProApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class m extends f {
    public String A0 = "";
    public int B0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public b2.g f8944t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ic.g f8945u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ArrayList f8946v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList f8947w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f8948x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f8949y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f8950z0;

    public static void T(m mVar, JSONArray jSONArray) {
        int i;
        JSONException e10;
        JSONObject jSONObject;
        ((SwipeRefreshLayout) mVar.f8944t0.f1740e).setRefreshing(false);
        String str = mVar.f8950z0;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                jSONObject = new JSONObject(jSONArray.getJSONObject(i11).getString("channel"));
            } catch (JSONException e11) {
                i = i10;
                e10 = e11;
            }
            if (jSONObject.optBoolean("visible", true)) {
                oc.c cVar = new oc.c();
                cVar.f9515a = jSONObject.getString("name");
                cVar.f9516b = jSONObject.getString("logo");
                cVar.f9517c = jSONObject.getString("links");
                jSONObject.optBoolean("is_playlist", false);
                cVar.f = uc.b.w(jSONObject.optJSONArray("link_names"));
                cVar.f9518d = str;
                i = i10 + 1;
                try {
                    cVar.f9520g = i10;
                    arrayList.add(cVar);
                } catch (JSONException e12) {
                    e10 = e12;
                    Log.e(e6.j.l("JSONException ", i11), e10.getMessage());
                }
                i10 = i;
            }
        }
        if (!arrayList.isEmpty()) {
            mVar.W(arrayList);
        } else {
            ((RecyclerView) mVar.f8944t0.f1739d).setVisibility(8);
            ((TextView) mVar.f8944t0.f1738c).setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        this.f8929r0 = true;
        ((SwipeRefreshLayout) this.f8944t0.f1740e).setRefreshing(true);
        U();
        ((SwipeRefreshLayout) this.f8944t0.f1740e).setOnRefreshListener(new i(this));
        ((LinearLayout) this.f8944t0.f1737b).setOnClickListener(new com.google.android.material.datepicker.n(9, this));
    }

    @Override // nc.f
    public final void Q(int i) {
        ((RecyclerView) this.f8944t0.f1739d).setLayoutManager(new CustomLayoutManager(i));
    }

    @Override // nc.f
    public final void R() {
        ((SwipeRefreshLayout) this.f8944t0.f1740e).setRefreshing(true);
        U();
    }

    @Override // nc.f
    public final void S(String str) {
        if (this.f8946v0 == null) {
            this.A0 = str;
            return;
        }
        if (str.isEmpty() && !this.A0.isEmpty()) {
            this.A0 = "";
            this.f8945u0.g(this.f8946v0);
            ((RecyclerView) this.f8944t0.f1739d).setVisibility(0);
            ((TextView) this.f8944t0.f1738c).setVisibility(8);
            ((TextView) this.f8944t0.f1738c).setText("Channels not available!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f8946v0;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            oc.c cVar = (oc.c) obj;
            String str2 = cVar.f9515a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f8944t0.f1739d).setVisibility(8);
            ((TextView) this.f8944t0.f1738c).setVisibility(0);
            ((TextView) this.f8944t0.f1738c).setText("No Channel Found.");
        } else {
            ((RecyclerView) this.f8944t0.f1739d).setVisibility(0);
            ((TextView) this.f8944t0.f1738c).setVisibility(8);
            this.f8945u0.g(arrayList);
        }
        this.A0 = str;
    }

    public final void U() {
        ue.m mVar;
        if (this.f8949y0.startsWith("/storage")) {
            new Thread(new j(this, 0)).start();
            return;
        }
        String str = this.f8949y0;
        if (str.contains("|")) {
            String[] strArrSplit = str.split("\\|");
            String str2 = strArrSplit[0];
            HashMap mapD = uc.b.d(strArrSplit[1]);
            String[] strArr = new String[mapD.size() * 2];
            int i = 0;
            for (Map.Entry entry : mapD.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                String string = ie.e.b0(str3).toString();
                String string2 = ie.e.b0(str4).toString();
                ue.v.a(string);
                ue.v.b(string2, string);
                strArr[i] = string;
                strArr[i + 1] = string2;
                i += 2;
            }
            mVar = new ue.m(strArr);
            str = str2;
        } else {
            mVar = null;
        }
        this.f8948x0 = UUID.randomUUID().toString();
        Context contextJ = j();
        k4 k4Var = new k4();
        k4Var.f3071v = this;
        k4Var.f3070u = this.f8948x0;
        ga.b.q(contextJ, str, mVar, k4Var, false);
    }

    public final void V(String str, String str2) {
        this.f8949y0 = str;
        this.f8950z0 = str2;
        U();
        this.f8946v0 = null;
        this.A0 = "";
        ((SwipeRefreshLayout) this.f8944t0.f1740e).setRefreshing(true);
        ((TextView) this.f8944t0.f1738c).setVisibility(8);
        ((RecyclerView) this.f8944t0.f1739d).g0(0);
        ((RecyclerView) this.f8944t0.f1739d).setVisibility(8);
        ((LinearLayout) this.f8944t0.f1741g).setVisibility(8);
    }

    public final void W(ArrayList arrayList) {
        this.f8946v0 = arrayList;
        ProApplication.I.B = arrayList;
        ic.g gVar = this.f8945u0;
        if (gVar == null) {
            this.f8945u0 = new ic.g(G(), arrayList);
            ((RecyclerView) this.f8944t0.f1739d).setHasFixedSize(true);
            ((RecyclerView) this.f8944t0.f1739d).setAdapter(this.f8945u0);
            ((RecyclerView) this.f8944t0.f1739d).setLayoutManager(new CustomLayoutManager(P() ? 5 : 3));
        } else {
            gVar.g(arrayList);
            ((RecyclerView) this.f8944t0.f1739d).j0(0);
        }
        this.f8945u0.i = this.f8950z0.equals("m3u") ? this.f8949y0 : "";
        if (!this.A0.isEmpty()) {
            S(this.A0);
        }
        ((RecyclerView) this.f8944t0.f1739d).setVisibility(0);
    }

    public final void X(String str) {
        p2.c cVarQ = uc.b.q(str);
        ArrayList arrayList = (ArrayList) cVarQ.f10131w;
        ArrayList arrayList2 = (ArrayList) cVarQ.f10130v;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            oc.g gVar = (oc.g) obj;
            String strO = uc.b.o(gVar.f9549d, gVar.f9550e, gVar.f, gVar.f9551g, gVar.f9552h);
            if (strO != null) {
                oc.c cVar = new oc.c();
                cVar.f9515a = gVar.f9547b;
                cVar.f9516b = gVar.f9548c;
                cVar.f9519e = gVar.f9546a;
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", "Link 1");
                    jSONObject.put("channel", gVar.f9547b);
                    jSONObject.put("link", strO);
                    jSONObject.put("scheme", gVar.f9553j);
                    String str2 = gVar.i;
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("api", str2);
                    jSONArray.put(jSONObject);
                    cVar.f9517c = jSONArray.toString();
                } catch (JSONException unused) {
                }
                cVar.f9518d = this.f8950z0;
                cVar.f9520g = i;
                arrayList3.add(cVar);
                i++;
            }
        }
        ((SwipeRefreshLayout) this.f8944t0.f1740e).setRefreshing(false);
        if (arrayList3.isEmpty()) {
            ((RecyclerView) this.f8944t0.f1739d).setVisibility(8);
            ((TextView) this.f8944t0.f1738c).setVisibility(0);
            return;
        }
        W(arrayList3);
        if (arrayList.isEmpty() || arrayList.size() <= 1) {
            ((LinearLayout) this.f8944t0.f1741g).setVisibility(8);
            return;
        }
        this.f8947w0 = arrayList;
        ((TabLayout) this.f8944t0.f).i();
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            String str3 = (String) obj2;
            TabLayout tabLayout = (TabLayout) this.f8944t0.f;
            u9.g gVarG = tabLayout.g();
            if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(str3)) {
                gVarG.f12807e.setContentDescription(str3);
            }
            gVarG.f12803a = str3;
            u9.j jVar = gVarG.f12807e;
            if (jVar != null) {
                jVar.d();
            }
            tabLayout.a(gVarG, tabLayout.f3495v.isEmpty());
        }
        ((LinearLayout) this.f8944t0.f1741g).setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new j(this, 2), 50L);
        TabLayout tabLayout2 = (TabLayout) this.f8944t0.f;
        k kVar = new k(0, this);
        ArrayList arrayList4 = tabLayout2.f3484h0;
        if (arrayList4.contains(kVar)) {
            return;
        }
        arrayList4.add(kVar);
    }

    @Override // androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        Bundle bundle2 = this.A;
        if (bundle2 != null) {
            this.f8949y0 = bundle2.getString("api");
            this.f8950z0 = this.A.getString("type");
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_channel, (ViewGroup) null, false);
        int i = gc.j.choose_btn;
        LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
        if (linearLayout != null) {
            i = gc.j.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) z7.a.k(viewInflate, i);
            if (fragmentContainerView != null) {
                i = gc.j.not_available;
                TextView textView = (TextView) z7.a.k(viewInflate, i);
                if (textView != null) {
                    i = gc.j.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) z7.a.k(viewInflate, i);
                    if (recyclerView != null) {
                        i = gc.j.refresh_layout;
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) z7.a.k(viewInflate, i);
                        if (swipeRefreshLayout != null) {
                            i = gc.j.tab_layout;
                            TabLayout tabLayout = (TabLayout) z7.a.k(viewInflate, i);
                            if (tabLayout != null) {
                                i = gc.j.tab_layout_container;
                                LinearLayout linearLayout2 = (LinearLayout) z7.a.k(viewInflate, i);
                                if (linearLayout2 != null) {
                                    LinearLayout linearLayout3 = (LinearLayout) viewInflate;
                                    this.f8944t0 = new b2.g(linearLayout3, linearLayout, fragmentContainerView, textView, recyclerView, swipeRefreshLayout, tabLayout, linearLayout2);
                                    return linearLayout3;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
