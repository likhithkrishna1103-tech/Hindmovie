package lc;

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
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.PlayerActivity;
import com.playz.tv.services.FloatingPlayer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class h extends androidx.fragment.app.n {
    public ArrayList H0;
    public String I0;
    public String J0;
    public boolean K0;
    public boolean L0;

    public static void S(h.j jVar, ArrayList arrayList, String str, String str2, boolean z2, boolean z10) {
        if (arrayList == null || arrayList.isEmpty()) {
            T(jVar, str, str2, 0, z2, z10);
            return;
        }
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("linkNames", arrayList);
        bundle.putString("links", str);
        bundle.putString("title", str2);
        bundle.putBoolean("isEncoded", z2);
        bundle.putBoolean("isTv", z10);
        hVar.L(bundle);
        hVar.R(jVar.o(), "LinksDialog");
    }

    public static void T(h.j jVar, String str, String str2, int i, boolean z2, boolean z10) {
        Intent intent = new Intent();
        intent.putExtra("title", str2);
        intent.putExtra("links", str);
        intent.putExtra("position", i);
        intent.putExtra("isEncoded", z2);
        if (z10) {
            intent.setClass(jVar, PlayerActivity.class);
            jVar.startActivity(intent);
            return;
        }
        if (uc.b.f(jVar).getInt("floatings", 0) <= 0 || !(jVar instanceof MainActivity)) {
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
        mainActivity.B0 = new b2.b(mainActivity, 22, intent);
        try {
            mainActivity.D0.a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + mainActivity.getPackageName())));
        } catch (Exception e10) {
            Toast.makeText(mainActivity, e10.getMessage(), 0).show();
        }
    }

    @Override // androidx.fragment.app.n
    public final Dialog Q(Bundle bundle) {
        Dialog dialogQ = super.Q(bundle);
        Window window = dialogQ.getWindow();
        Objects.requireNonNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        dialogQ.setCancelable(true);
        dialogQ.setCanceledOnTouchOutside(true);
        return dialogQ;
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        Bundle bundle2 = this.A;
        if (bundle2 != null) {
            this.H0 = bundle2.getStringArrayList("linkNames");
            this.J0 = bundle2.getString("links");
            this.I0 = bundle2.getString("title");
            this.K0 = bundle2.getBoolean("isEncoded");
            this.L0 = bundle2.getBoolean("isTv");
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.dialog_links, (ViewGroup) null, false);
        int i = gc.j.link_listView;
        ListView listView = (ListView) z7.a.k(viewInflate, i);
        if (listView != null) {
            i = gc.j.title_textView;
            if (((TextView) z7.a.k(viewInflate, i)) != null) {
                RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                relativeLayout.setOnClickListener(new com.google.android.material.datepicker.n(8, this));
                listView.setAdapter((ListAdapter) new ArrayAdapter(H(), gc.k.item_listview, gc.j.list_textview, this.H0));
                listView.setOnItemClickListener(new c(this, 1));
                return relativeLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
