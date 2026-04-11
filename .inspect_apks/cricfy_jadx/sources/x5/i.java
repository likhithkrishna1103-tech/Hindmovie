package x5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.CustomLayoutManager;
import app.cricfy.tv.app.ProApplication;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.z3;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i extends c {
    public String A0;
    public String B0 = "";
    public boolean C0;
    public ProApplication D0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public c2.o f14348u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public s5.e f14349v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList f14350w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ArrayList f14351x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f14352y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f14353z0;

    public static void V(i iVar, JSONArray jSONArray) {
        ((SwipeRefreshLayout) iVar.f14348u0.f2038e).setRefreshing(false);
        String str = iVar.A0;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(jSONArray.getJSONObject(i).getString("channel"));
                if (jSONObject.optBoolean("visible", true)) {
                    y5.c cVar = new y5.c();
                    cVar.f14913a = jSONObject.getString("name");
                    cVar.f14914b = jSONObject.getString("logo");
                    cVar.f14915c = jSONObject.getString("links");
                    jSONObject.optBoolean("is_playlist", false);
                    cVar.f = j4.H(jSONObject.optJSONArray("link_names"));
                    cVar.f14916d = str;
                    arrayList.add(cVar);
                }
            } catch (JSONException e9) {
                Log.e(l0.e.g(i, "JSONException "), e9.getMessage());
            }
        }
        if (!arrayList.isEmpty()) {
            iVar.Z(arrayList);
        } else {
            ((RecyclerView) iVar.f14348u0.f2037d).setVisibility(8);
            ((TextView) iVar.f14348u0.f2036c).setVisibility(0);
        }
    }

    public static i X(String str, String str2, boolean z10) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("api", str);
        bundle.putString("type", str2);
        bundle.putBoolean("isSports", z10);
        iVar.N(bundle);
        return iVar;
    }

    @Override // x5.c, androidx.fragment.app.y
    public final void G(View view) {
        this.f14336s0 = true;
        ((SwipeRefreshLayout) this.f14348u0.f2038e).setRefreshing(true);
        this.D0 = ProApplication.K;
        W();
        ((SwipeRefreshLayout) this.f14348u0.f2038e).setOnRefreshListener(new g(this));
        ((ImageView) this.f14348u0.f2035b).setOnClickListener(new com.google.android.material.datepicker.n(14, this));
    }

    @Override // x5.c
    public final void S(int i) {
        ((RecyclerView) this.f14348u0.f2037d).setLayoutManager(new CustomLayoutManager(i));
        this.D0.a((RecyclerView) this.f14348u0.f2037d);
    }

    @Override // x5.c
    public final void T() {
        ((SwipeRefreshLayout) this.f14348u0.f2038e).setRefreshing(true);
        W();
    }

    @Override // x5.c
    public final void U(String str) {
        if (this.f14350w0 == null) {
            this.B0 = str;
            return;
        }
        if (str.isEmpty() && !this.B0.isEmpty()) {
            this.B0 = "";
            this.f14349v0.h(this.f14350w0);
            ((RecyclerView) this.f14348u0.f2037d).setVisibility(0);
            ((TextView) this.f14348u0.f2036c).setVisibility(8);
            ((TextView) this.f14348u0.f2036c).setText("Channels not available!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f14350w0;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            y5.c cVar = (y5.c) obj;
            String str2 = cVar.f14913a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            ((RecyclerView) this.f14348u0.f2037d).setVisibility(8);
            ((TextView) this.f14348u0.f2036c).setVisibility(0);
            ((TextView) this.f14348u0.f2036c).setText("No Channel Found.");
        } else {
            ((RecyclerView) this.f14348u0.f2037d).setVisibility(0);
            ((TextView) this.f14348u0.f2036c).setVisibility(8);
            this.f14349v0.h(arrayList);
        }
        this.B0 = str;
    }

    public final void W() {
        kf.p pVar;
        int i = 0;
        if (this.f14353z0.startsWith("/storage")) {
            new Thread(new f(this, i)).start();
            return;
        }
        String str = this.f14353z0;
        if (str.contains("|")) {
            String[] strArrSplit = str.split("\\|");
            String str2 = strArrSplit[0];
            HashMap mapK = j4.k(strArrSplit[1]);
            kf.p pVar2 = kf.p.f7513w;
            String[] strArr = new String[mapK.size() * 2];
            int i10 = 0;
            for (Map.Entry entry : mapK.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                String string = ne.h.t0(str3).toString();
                String string2 = ne.h.t0(str4).toString();
                n5.a.t(string);
                n5.a.u(string2, string);
                strArr[i10] = string;
                strArr[i10 + 1] = string2;
                i10 += 2;
            }
            pVar = new kf.p(strArr);
            str = str2;
        } else {
            pVar = null;
        }
        this.f14352y0 = UUID.randomUUID().toString();
        android.support.v4.media.session.b.p(j(), str, pVar, new vb.b(this), false);
    }

    public final void Y(String str, String str2) {
        this.f14353z0 = str;
        this.A0 = str2;
        W();
        this.f14350w0 = null;
        this.B0 = "";
        ((SwipeRefreshLayout) this.f14348u0.f2038e).setRefreshing(true);
        ((TextView) this.f14348u0.f2036c).setVisibility(8);
        ((RecyclerView) this.f14348u0.f2037d).g0(0);
        ((RecyclerView) this.f14348u0.f2037d).setVisibility(8);
        ((LinearLayout) this.f14348u0.f2039g).setVisibility(8);
    }

    public final void Z(ArrayList arrayList) {
        if (h() == null) {
            return;
        }
        this.f14350w0 = arrayList;
        ProApplication.K.C = arrayList;
        s5.e eVar = this.f14349v0;
        if (eVar == null) {
            this.f14349v0 = new s5.e(J(), arrayList);
            ((RecyclerView) this.f14348u0.f2037d).setHasFixedSize(true);
            ((RecyclerView) this.f14348u0.f2037d).setAdapter(this.f14349v0);
            ((RecyclerView) this.f14348u0.f2037d).setLayoutManager(new CustomLayoutManager(R() ? 8 : 4));
            this.D0.a((RecyclerView) this.f14348u0.f2037d);
        } else {
            eVar.h(arrayList);
            ((RecyclerView) this.f14348u0.f2037d).j0(0);
        }
        this.f14349v0.i = this.A0.equals("m3u") ? this.f14353z0 : "";
        if (!this.B0.isEmpty()) {
            U(this.B0);
        }
        ((RecyclerView) this.f14348u0.f2037d).setVisibility(0);
    }

    public final void a0(String str) {
        e6.b bVarR = z3.r(str);
        ArrayList arrayList = bVarR.f3813b;
        ArrayList arrayList2 = bVarR.f3812a;
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            y5.h hVar = (y5.h) obj;
            String strZ = j4.z(hVar.f14946d, hVar.f14947e, hVar.f, hVar.f14948g, hVar.f14949h);
            if (strZ != null) {
                y5.c cVar = new y5.c();
                cVar.f14913a = hVar.f14944b;
                cVar.f14914b = hVar.f14945c;
                cVar.f14917e = hVar.f14943a;
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", "Link 1");
                    jSONObject.put("channel", hVar.f14944b);
                    jSONObject.put("link", strZ);
                    jSONObject.put("scheme", hVar.f14950j);
                    String str2 = hVar.i;
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("api", str2);
                    jSONArray.put(jSONObject);
                    cVar.f14915c = jSONArray.toString();
                } catch (JSONException unused) {
                }
                cVar.f14916d = this.A0;
                arrayList3.add(cVar);
            }
        }
        ((SwipeRefreshLayout) this.f14348u0.f2038e).setRefreshing(false);
        if (arrayList3.isEmpty()) {
            ((RecyclerView) this.f14348u0.f2037d).setVisibility(8);
            ((TextView) this.f14348u0.f2036c).setVisibility(0);
            return;
        }
        Z(arrayList3);
        if (arrayList.isEmpty() || arrayList.size() <= 1) {
            ((LinearLayout) this.f14348u0.f2039g).setVisibility(8);
            return;
        }
        if (this.C0) {
            ((LinearLayout) this.f14348u0.f2039g).setVisibility(8);
            return;
        }
        this.f14351x0 = arrayList;
        ((TabLayout) this.f14348u0.f).i();
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            String str3 = (String) obj2;
            TabLayout tabLayout = (TabLayout) this.f14348u0.f;
            oa.h hVarG = tabLayout.g();
            if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(str3)) {
                hVarG.f9725e.setContentDescription(str3);
            }
            hVarG.f9721a = str3;
            oa.k kVar = hVarG.f9725e;
            if (kVar != null) {
                kVar.d();
            }
            tabLayout.a(hVarG, tabLayout.f2960w.isEmpty());
        }
        ((LinearLayout) this.f14348u0.f2039g).setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new f(this, 2), 50L);
        TabLayout tabLayout2 = (TabLayout) this.f14348u0.f;
        oa.l lVar = new oa.l(1, this);
        ArrayList arrayList4 = tabLayout2.f2949j0;
        if (arrayList4.contains(lVar)) {
            return;
        }
        arrayList4.add(lVar);
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        Bundle bundle2 = this.B;
        if (bundle2 != null) {
            this.f14353z0 = bundle2.getString("api");
            this.A0 = this.B.getString("type");
            this.C0 = this.B.getBoolean("isSports");
        }
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_channel, (ViewGroup) null, false);
        int i = q5.k.choose_btn;
        ImageView imageView = (ImageView) android.support.v4.media.session.b.l(viewInflate, i);
        if (imageView != null) {
            i = q5.k.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) android.support.v4.media.session.b.l(viewInflate, i);
            if (fragmentContainerView != null) {
                i = q5.k.not_available;
                TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                if (textView != null) {
                    i = q5.k.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                    if (recyclerView != null) {
                        i = q5.k.refresh_layout;
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) android.support.v4.media.session.b.l(viewInflate, i);
                        if (swipeRefreshLayout != null) {
                            i = q5.k.tab_layout;
                            TabLayout tabLayout = (TabLayout) android.support.v4.media.session.b.l(viewInflate, i);
                            if (tabLayout != null) {
                                i = q5.k.tab_layout_container;
                                LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                                    this.f14348u0 = new c2.o(linearLayout2, imageView, fragmentContainerView, textView, recyclerView, swipeRefreshLayout, tabLayout, linearLayout);
                                    return linearLayout2;
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
