package ic;

import a2.h0;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.n0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import q4.x0;
import q4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f6561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.fragment.app.r f6562e;
    public ArrayList f;

    public u(Context context, ArrayList arrayList, androidx.fragment.app.r rVar) {
        this.f6561d = context;
        this.f = new ArrayList(arrayList);
        this.f6562e = rVar;
    }

    @Override // q4.z
    public final int a() {
        return this.f.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final void d(x0 x0Var, final int i) {
        t tVar = (t) x0Var;
        final oc.h hVar = (oc.h) this.f.get(i);
        final String str = hVar.f9554a;
        final String str2 = hVar.f9555b;
        final String str3 = hVar.f9556c;
        final String str4 = hVar.f9557d;
        tVar.f6559v.setText(str);
        tVar.f6558u.setOnClickListener(new View.OnClickListener() { // from class: ic.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nc.u uVar = this.f6541u.f6562e.f1349a;
                uVar.f8975v0.f3680x.a(str);
                String str5 = str3;
                boolean zIsEmpty = TextUtils.isEmpty(str5);
                String strConcat = str2;
                if (!zIsEmpty) {
                    if (!strConcat.contains("/get.php")) {
                        strConcat = strConcat.concat("/get.php");
                    }
                    strConcat = strConcat + "?username=" + str5 + "&password=" + str4 + "&type=m3u";
                }
                nc.m mVar = uVar.f8974u0;
                if (mVar != null) {
                    mVar.V(strConcat, "m3u");
                    ((FloatingActionButton) uVar.f8971r0.f14946v).setVisibility(8);
                    ((SwipeRefreshLayout) uVar.f8971r0.f14948x).setVisibility(8);
                    ((FragmentContainerView) uVar.f8971r0.f14947w).setVisibility(0);
                    return;
                }
                nc.m mVar2 = new nc.m();
                Bundle bundle = new Bundle();
                bundle.putString("api", strConcat);
                bundle.putString("type", "m3u");
                mVar2.L(bundle);
                uVar.f8974u0 = mVar2;
                n0 n0VarI = uVar.i();
                n0VarI.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(n0VarI);
                aVar.e(gc.j.fragment_container, uVar.f8974u0, null, 1);
                aVar.d(false);
                ((FloatingActionButton) uVar.f8971r0.f14946v).setVisibility(8);
                ((SwipeRefreshLayout) uVar.f8971r0.f14948x).setVisibility(8);
                ((FragmentContainerView) uVar.f8971r0.f14947w).setVisibility(0);
            }
        });
        tVar.f6560w.setOnClickListener(new View.OnClickListener() { // from class: ic.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final u uVar = this;
                Context context = uVar.f6561d;
                final oc.h hVar2 = hVar;
                boolean z2 = hVar2.f9558e;
                final int i10 = i;
                final String str5 = str;
                final String str6 = str2;
                final String str7 = str3;
                final String str8 = str4;
                com.bumptech.glide.d.R(context, "Edit Playlist Details", "Update", str5, str6, str7, str8, z2, new lc.b() { // from class: ic.s
                    @Override // lc.b
                    public final void l(String str9, String str10, String str11, String str12) {
                        u uVar2 = uVar;
                        Context context2 = uVar2.f6561d;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str5);
                        sb2.append("*");
                        sb2.append(str6);
                        sb2.append("*");
                        sb2.append(str7);
                        String strO = l4.a.o(sb2, "*", str8);
                        Set<String> stringSet = uc.b.f(context2).getStringSet("list", new HashSet());
                        HashSet hashSet = new HashSet();
                        for (String str13 : stringSet) {
                            if (str13.equals(strO)) {
                                hashSet.add(str9 + "*" + str10 + "*" + str11 + "*" + str12);
                            } else {
                                hashSet.add(str13);
                            }
                        }
                        context2.getSharedPreferences("DataPreferences", 0).edit().putStringSet("list", hashSet).apply();
                        ArrayList arrayList = uVar2.f;
                        oc.h hVar3 = new oc.h(str9, str10, str11, str12, hVar2.f9558e);
                        int i11 = i10;
                        arrayList.set(i11, hVar3);
                        uVar2.f6562e.f1349a.f8973t0 = new ArrayList(uVar2.f);
                        uVar2.f10982a.c(i11);
                    }
                }, new h0(uVar, i10, hVar2));
            }
        });
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(gc.k.item_playlist, viewGroup, false);
        t tVar = new t(viewInflate);
        tVar.f6558u = (CardView) viewInflate.findViewById(gc.j.playlist_card);
        tVar.f6559v = (TextView) viewInflate.findViewById(gc.j.playlist_name);
        tVar.f6560w = (ImageButton) viewInflate.findViewById(gc.j.edit_btn);
        return tVar;
    }

    @Override // q4.z
    public final int c(int i) {
        return i;
    }
}
