package v5;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.PlayerActivity;
import app.cricfy.tv.services.FloatingPlayer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.fragment.app.q {
    public ArrayList I0;
    public String J0;
    public String K0;
    public boolean L0;
    public boolean M0;

    public static void V(h.j jVar, ArrayList arrayList, String str, String str2, boolean z10, boolean z11) {
        if (arrayList == null || arrayList.isEmpty()) {
            W(jVar, str, str2, 0, z10, z11);
            return;
        }
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("linkNames", arrayList);
        bundle.putString("links", str);
        bundle.putString("title", str2);
        bundle.putBoolean("isEncoded", z10);
        bundle.putBoolean("isTv", z11);
        hVar.N(bundle);
        hVar.U(jVar.o(), "LinksDialog");
    }

    public static void W(h.j jVar, String str, String str2, int i, boolean z10, boolean z11) {
        Intent intent = new Intent();
        intent.putExtra("title", str2);
        intent.putExtra("links", str);
        intent.putExtra("position", i);
        intent.putExtra("isEncoded", z10);
        if (z11) {
            intent.setClass(jVar, PlayerActivity.class);
            jVar.startActivity(intent);
            return;
        }
        if (com.bumptech.glide.d.t(jVar).getInt("floatings", 0) <= 0 || !(jVar instanceof MainActivity)) {
            intent.setClass(jVar, PlayerActivity.class);
            jVar.startActivity(intent);
            return;
        }
        MainActivity mainActivity = (MainActivity) jVar;
        if (Settings.canDrawOverlays(mainActivity)) {
            intent.setClass(mainActivity, FloatingPlayer.class);
            mainActivity.startService(intent);
            return;
        }
        mainActivity.f1513x0 = new androidx.fragment.app.e(3, mainActivity, intent);
        try {
            mainActivity.f1515z0.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + mainActivity.getPackageName())));
        } catch (Exception e9) {
            Toast.makeText(mainActivity, e9.getMessage(), 0).show();
        }
    }

    @Override // androidx.fragment.app.q
    public final Dialog S(Bundle bundle) {
        Dialog dialogS = super.S(bundle);
        Window window = dialogS.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        dialogS.setCancelable(true);
        dialogS.setCanceledOnTouchOutside(true);
        return dialogS;
    }

    @Override // androidx.fragment.app.q, androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        Bundle bundle2 = this.B;
        if (bundle2 != null) {
            this.I0 = bundle2.getStringArrayList("linkNames");
            this.K0 = bundle2.getString("links");
            this.J0 = bundle2.getString("title");
            this.L0 = bundle2.getBoolean("isEncoded");
            this.M0 = bundle2.getBoolean("isTv");
        }
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.dialog_links, (ViewGroup) null, false);
        int i = q5.k.link_listView;
        ListView listView = (ListView) android.support.v4.media.session.b.l(viewInflate, i);
        if (listView != null) {
            i = q5.k.title_textView;
            if (((TextView) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                relativeLayout.setOnClickListener(new com.google.android.material.datepicker.n(11, this));
                listView.setAdapter((ListAdapter) new ArrayAdapter(K(), q5.l.item_listview, q5.k.list_textview, this.I0));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: v5.g
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i10, long j4) {
                        h hVar = this.f13427v;
                        h.W(hVar.h(), hVar.K0, hVar.J0, i10, hVar.L0, hVar.M0);
                        hVar.R(false, false);
                    }
                });
                return relativeLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
