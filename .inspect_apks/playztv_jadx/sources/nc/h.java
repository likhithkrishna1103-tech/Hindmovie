package nc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.playz.tv.CustomLayoutManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class h extends f {
    public String A0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public ub.o f8932t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Context f8933u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public l f8934v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList f8935w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ic.c f8936x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public String f8937y0 = "";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f8938z0;

    public static h U(String str) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("tag", str);
        hVar.L(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        ((SwipeRefreshLayout) this.f8932t0.f12871y).setRefreshing(true);
        this.f8933u0 = j();
        T();
        ((SwipeRefreshLayout) this.f8932t0.f12871y).setOnRefreshListener(new g(this));
    }

    @Override // nc.f
    public final void Q(int i) {
        ((RecyclerView) this.f8932t0.f12870x).setLayoutManager(new CustomLayoutManager(i));
    }

    @Override // nc.f
    public final void R() {
        ((SwipeRefreshLayout) this.f8932t0.f12871y).setRefreshing(true);
        T();
    }

    @Override // nc.f
    public final void S(String str) {
        if (this.f8935w0 == null) {
            this.f8937y0 = str;
            return;
        }
        if (str.isEmpty() && !this.f8937y0.isEmpty()) {
            this.f8937y0 = "";
            ic.c cVar = this.f8936x0;
            ArrayList arrayList = this.f8935w0;
            cVar.getClass();
            cVar.f = new ArrayList(arrayList);
            cVar.f10982a.b();
            ((RecyclerView) this.f8932t0.f12870x).setVisibility(0);
            ((LinearLayout) this.f8932t0.f12868v).setVisibility(8);
            ((TextView) this.f8932t0.f12869w).setText(this.A0);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.f8935w0;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            oc.b bVar = (oc.b) obj;
            String str2 = bVar.f9511a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(bVar);
            }
        }
        if (arrayList2.isEmpty()) {
            ((RecyclerView) this.f8932t0.f12870x).setVisibility(8);
            ((LinearLayout) this.f8932t0.f12868v).setVisibility(0);
            ((TextView) this.f8932t0.f12869w).setText("No Category Found.");
        } else {
            ((RecyclerView) this.f8932t0.f12870x).setVisibility(0);
            ((LinearLayout) this.f8932t0.f12868v).setVisibility(8);
            ic.c cVar2 = this.f8936x0;
            cVar2.getClass();
            cVar2.f = new ArrayList(arrayList2);
            cVar2.f10982a.b();
        }
        this.f8937y0 = str;
    }

    public final void T() {
        ga.b.p(j(), ga.b.n(j(), this.f8938z0 ? "sports.txt" : "categories.txt"), new g(this));
    }

    public final void V(JSONArray jSONArray) {
        ((SwipeRefreshLayout) this.f8932t0.f12871y).setRefreshing(false);
        if (jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = new JSONObject(jSONArray.getJSONObject(i).getString("cat"));
                    if (jSONObject.getBoolean("visible")) {
                        arrayList.add(oc.b.a(jSONObject));
                    }
                } catch (JSONException unused) {
                }
            }
            this.f8935w0 = arrayList;
            if (!arrayList.isEmpty()) {
                ic.c cVar = this.f8936x0;
                if (cVar == null) {
                    ic.c cVar2 = new ic.c(this.f8933u0, new g(this), this.f8935w0, this.f8938z0);
                    this.f8936x0 = cVar2;
                    ((RecyclerView) this.f8932t0.f12870x).setAdapter(cVar2);
                    ((RecyclerView) this.f8932t0.f12870x).setLayoutManager(new CustomLayoutManager(P() ? 6 : 3));
                } else {
                    cVar.f = new ArrayList(this.f8935w0);
                    cVar.f10982a.b();
                    ((RecyclerView) this.f8932t0.f12870x).j0(0);
                }
                if (!this.f8937y0.isEmpty()) {
                    S(this.f8937y0);
                }
                ((LinearLayout) this.f8932t0.f12868v).setVisibility(8);
                ((RecyclerView) this.f8932t0.f12870x).setVisibility(0);
                return;
            }
        }
        ((LinearLayout) this.f8932t0.f12868v).setVisibility(0);
    }

    @Override // androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        Bundle bundle2 = this.A;
        String string = bundle2 != null ? bundle2.getString("tag") : "";
        if (TextUtils.isEmpty(string)) {
            string = "categories";
        }
        vc.a aVar = (vc.a) new a7.b(G()).t(vc.a.class, string);
        this.f8934v0 = aVar.f13484d;
        boolean z2 = aVar.f13485e;
        this.f8938z0 = z2;
        if (z2) {
            this.A0 = "Sports Categories not Available!";
        } else {
            this.A0 = "Categories not Available!";
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_category, (ViewGroup) null, false);
        int i = gc.j.no_cat_layout;
        LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
        if (linearLayout != null) {
            i = gc.j.not_available;
            TextView textView = (TextView) z7.a.k(viewInflate, i);
            if (textView != null) {
                i = gc.j.recycler_view;
                RecyclerView recyclerView = (RecyclerView) z7.a.k(viewInflate, i);
                if (recyclerView != null) {
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate;
                    this.f8932t0 = new ub.o(swipeRefreshLayout, linearLayout, textView, recyclerView, swipeRefreshLayout, 22);
                    return swipeRefreshLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
