package x5;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.emoji2.text.v;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.CustomLayoutManager;
import app.cricfy.tv.app.ProApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class e extends c {
    public String A0;
    public ProApplication B0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public dd.c f14339u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Context f14340v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public h f14341w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public ArrayList f14342x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public m4.l f14343y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public String f14344z0 = "";

    @Override // x5.c, androidx.fragment.app.y
    public final void G(View view) {
        ((SwipeRefreshLayout) this.f14339u0.A).setRefreshing(true);
        this.B0 = ProApplication.K;
        this.f14340v0 = j();
        V();
        ((SwipeRefreshLayout) this.f14339u0.A).setOnRefreshListener(new d(this));
        TextView textView = (TextView) this.f14339u0.f3674y;
        String str = ProApplication.K.I;
        textView.setVisibility(8);
    }

    @Override // x5.c
    public final void S(int i) {
        ((RecyclerView) this.f14339u0.f3675z).setLayoutManager(new CustomLayoutManager(i));
        this.B0.a((RecyclerView) this.f14339u0.f3675z);
    }

    @Override // x5.c
    public final void T() {
        ((SwipeRefreshLayout) this.f14339u0.A).setRefreshing(true);
        V();
    }

    @Override // x5.c
    public final void U(String str) {
        if (this.f14342x0 == null) {
            this.f14344z0 = str;
            return;
        }
        if (str.isEmpty() && !this.f14344z0.isEmpty()) {
            this.f14344z0 = "";
            m4.l lVar = this.f14343y0;
            ArrayList arrayList = this.f14342x0;
            lVar.getClass();
            lVar.f8185g = new ArrayList(arrayList);
            lVar.d();
            ((RecyclerView) this.f14339u0.f3675z).setVisibility(0);
            ((LinearLayout) this.f14339u0.f3672w).setVisibility(8);
            ((TextView) this.f14339u0.f3673x).setText(this.A0);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.f14342x0;
        int size = arrayList3.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            y5.b bVar = (y5.b) obj;
            String str2 = bVar.f14909a;
            if (str2 != null && str2.toLowerCase().contains(str.toLowerCase())) {
                arrayList2.add(bVar);
            }
        }
        if (arrayList2.isEmpty()) {
            ((RecyclerView) this.f14339u0.f3675z).setVisibility(8);
            ((LinearLayout) this.f14339u0.f3672w).setVisibility(0);
            ((TextView) this.f14339u0.f3673x).setText("No Category Found.");
        } else {
            ((RecyclerView) this.f14339u0.f3675z).setVisibility(0);
            ((LinearLayout) this.f14339u0.f3672w).setVisibility(8);
            m4.l lVar2 = this.f14343y0;
            lVar2.getClass();
            lVar2.f8185g = new ArrayList(arrayList2);
            lVar2.d();
        }
        this.f14344z0 = str;
    }

    public final void V() {
        android.support.v4.media.session.b.p(j(), android.support.v4.media.session.b.n(j(), "categories.txt"), null, new d(this), false);
    }

    public final void W(JSONArray jSONArray) {
        ((SwipeRefreshLayout) this.f14339u0.A).setRefreshing(false);
        if (jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = new JSONObject(jSONArray.getJSONObject(i).getString("cat"));
                    if (jSONObject.getBoolean("visible")) {
                        arrayList.add(y5.b.a(jSONObject));
                    }
                } catch (JSONException unused) {
                }
            }
            this.f14342x0 = arrayList;
            if (!arrayList.isEmpty()) {
                m4.l lVar = this.f14343y0;
                if (lVar == null) {
                    m4.l lVar2 = new m4.l(this.f14340v0, new d(this), this.f14342x0);
                    this.f14343y0 = lVar2;
                    ((RecyclerView) this.f14339u0.f3675z).setAdapter(lVar2);
                    ((RecyclerView) this.f14339u0.f3675z).setLayoutManager(new CustomLayoutManager(R() ? 4 : 2));
                    this.B0.a((RecyclerView) this.f14339u0.f3675z);
                } else {
                    lVar.f8185g = new ArrayList(this.f14342x0);
                    lVar.d();
                    ((RecyclerView) this.f14339u0.f3675z).j0(0);
                }
                if (!this.f14344z0.isEmpty()) {
                    U(this.f14344z0);
                }
                ((LinearLayout) this.f14339u0.f3672w).setVisibility(8);
                ((RecyclerView) this.f14339u0.f3675z).setVisibility(0);
                return;
            }
        }
        ((LinearLayout) this.f14339u0.f3672w).setVisibility(0);
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        Bundle bundle2 = this.B;
        String string = bundle2 != null ? bundle2.getString("tag") : "";
        if (TextUtils.isEmpty(string)) {
            string = "categories";
        }
        this.f14341w0 = ((f6.a) new v(J()).s(f6.a.class, string)).f3975d;
        this.A0 = "Categories not Available!";
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_category, (ViewGroup) null, false);
        int i = q5.k.no_cat_layout;
        LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
        if (linearLayout != null) {
            i = q5.k.not_available;
            TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
            if (textView != null) {
                i = q5.k.pTxt;
                TextView textView2 = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                if (textView2 != null) {
                    i = q5.k.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) android.support.v4.media.session.b.l(viewInflate, i);
                    if (recyclerView != null) {
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate;
                        this.f14339u0 = new dd.c(swipeRefreshLayout, linearLayout, textView, textView2, recyclerView, swipeRefreshLayout);
                        return swipeRefreshLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
