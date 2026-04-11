package hc;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.n0;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.PlayerActivity;
import com.playz.tv.activities.WebActivity;
import com.playz.tv.services.FloatingPlayer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements e.b, nc.d, nc.l, l9.p, l9.k, jc.d, pc.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ MainActivity f6033v;

    public /* synthetic */ d(MainActivity mainActivity, int i) {
        this.f6032u = i;
        this.f6033v = mainActivity;
    }

    @Override // jc.d
    public void a(String str) {
        ((Toolbar) this.f6033v.X.f5868w).setTitle(str);
    }

    @Override // l9.p
    public void b(MenuItem menuItem) {
        int i = MainActivity.F0;
        int itemId = menuItem.getItemId();
        int i10 = gc.j.playlists;
        MainActivity mainActivity = this.f6033v;
        int i11 = 0;
        if (itemId == i10) {
            if (mainActivity.f3606j0 != null) {
                mainActivity.A();
            }
            if (mainActivity.f3607k0 == null) {
                mainActivity.f3607k0 = new nc.u();
                n0 n0VarO = mainActivity.o();
                androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                aVarI.e(gc.j.playlists_fragment_container, mainActivity.f3607k0, null, 1);
                aVarI.d(false);
                ((FragmentContainerView) mainActivity.Y.f2549g).setVisibility(0);
                mainActivity.f3611p0 = ((Toolbar) mainActivity.X.f5868w).getTitle().toString();
                ((Toolbar) mainActivity.X.f5868w).setTitle("Playlists/IPTV");
                mainActivity.D();
            }
        } else if (itemId == gc.j.floating_player) {
            kc.b bVarY = kc.b.y(mainActivity.getLayoutInflater());
            Switch r02 = (Switch) bVarY.f7621w;
            Spinner spinner = (Spinner) bVarY.f7622x;
            int i12 = mainActivity.getSharedPreferences("DataPreferences", 0).getInt("floatings", 0);
            if (i12 > 0) {
                r02.setChecked(true);
                spinner.setAlpha(1.0f);
                spinner.setSelection(i12 - 1);
                spinner.setEnabled(true);
                spinner.setClickable(true);
            } else {
                spinner.setEnabled(false);
                spinner.setClickable(false);
            }
            r02.setOnCheckedChangeListener(new h(i11, bVarY));
            d9.b bVar = new d9.b(mainActivity, gc.p.MyMaterialDialogTheme);
            bVar.d("Close", null);
            bVar.f((LinearLayout) bVarY.f7620v);
            bVar.f5489a.f5451n = new i(mainActivity, bVarY, i11);
            bVar.b();
        } else if (itemId == gc.j.telegram) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(mainActivity.l0.f9505u));
                mainActivity.startActivity(intent);
            } catch (ActivityNotFoundException e10) {
                Toast.makeText(mainActivity, e10.getMessage(), 0).show();
            }
        } else if (itemId == gc.j.network_streem) {
            if (mainActivity.f3607k0 != null) {
                mainActivity.B();
            }
            if (mainActivity.f3606j0 == null) {
                mainActivity.f3606j0 = new nc.s();
                n0 n0VarO2 = mainActivity.o();
                androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                aVarI2.e(gc.j.ns_fragment_container, mainActivity.f3606j0, null, 1);
                aVarI2.d(false);
                ((FragmentContainerView) mainActivity.Y.f).setVisibility(0);
                mainActivity.f3611p0 = ((Toolbar) mainActivity.X.f5868w).getTitle().toString();
                ((Toolbar) mainActivity.X.f5868w).setTitle("Network Stream");
                mainActivity.D();
            }
        } else if (itemId == gc.j.share) {
            uc.b.s(mainActivity);
        } else if (itemId == gc.j.foot_score) {
            String str = mainActivity.l0.A;
            Intent intent2 = new Intent(mainActivity, (Class<?>) WebActivity.class);
            intent2.putExtra("title", "Football Score");
            intent2.putExtra("url", str);
            mainActivity.startActivity(intent2);
        } else if (itemId == gc.j.cric_score) {
            String str2 = mainActivity.l0.B;
            Intent intent3 = new Intent(mainActivity, (Class<?>) WebActivity.class);
            intent3.putExtra("title", "Cricket Score");
            intent3.putExtra("url", str2);
            mainActivity.startActivity(intent3);
        } else if (itemId == gc.j.copyright) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mainActivity.f3608m0);
            sb2.append(" Does not stream any of the channels included in this Application, all the streaming links are available on third party websites freely on internet. ");
            String strO = l4.a.o(sb2, mainActivity.f3608m0, " just gaving way to stream and all content is the copyright of their owner.");
            d9.b bVarE = new d9.b(mainActivity, gc.p.MyMaterialDialogTheme).e("Copyright Alert");
            bVarE.f5489a.f = strO;
            bVarE.d("OK", null);
            bVarE.b();
        } else if (itemId == gc.j.web) {
            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mainActivity.l0.f9507w)));
        } else if (itemId == gc.j.contact_us) {
            Intent intent4 = new Intent("android.intent.action.SENDTO");
            intent4.setData(Uri.fromParts("mailto", mainActivity.l0.G, null));
            try {
                mainActivity.startActivity(Intent.createChooser(intent4, "Send email using..."));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(mainActivity, "No email clients installed.", 0).show();
            }
        } else if (itemId == gc.j.exit) {
            d9.b bVarE2 = new d9.b(mainActivity, gc.p.MyMaterialDialogTheme).e("Exit");
            bVarE2.f5489a.f = "Want to exit?";
            bVarE2.d("Exit", new g(0, mainActivity));
            bVarE2.c();
            bVarE2.b();
        }
        ((DrawerLayout) mainActivity.W.f1739d).d();
    }

    @Override // nc.l
    public void c(nc.m mVar, String str) {
        switch (this.f6032u) {
            case 2:
                MainActivity mainActivity = this.f6033v;
                mainActivity.f3602f0 = mVar;
                mainActivity.f3598b0 = mVar;
                mainActivity.f3612q0 = true;
                mainActivity.f3613r0 = true;
                mainActivity.f3609n0 = str;
                mainActivity.f3611p0 = str;
                mainActivity.f3597a0.collapseActionView();
                ((Toolbar) mainActivity.X.f5868w).setTitle(str);
                ((FragmentContainerView) mainActivity.Y.f2544a).setVisibility(8);
                ((FragmentContainerView) mainActivity.Y.f2545b).setVisibility(0);
                mainActivity.D();
                break;
            default:
                MainActivity mainActivity2 = this.f6033v;
                mainActivity2.f3603g0 = mVar;
                mainActivity2.f3598b0 = mVar;
                mainActivity2.f3614s0 = true;
                mainActivity2.f3615t0 = true;
                mainActivity2.f3610o0 = str;
                mainActivity2.f3611p0 = str;
                mainActivity2.f3597a0.collapseActionView();
                ((Toolbar) mainActivity2.X.f5868w).setTitle(str);
                ((FragmentContainerView) mainActivity2.Y.f2551j).setVisibility(8);
                ((FragmentContainerView) mainActivity2.Y.i).setVisibility(0);
                mainActivity2.D();
                break;
        }
    }

    @Override // nc.d
    public void d() {
        MainActivity mainActivity = this.f6033v;
        mainActivity.f3605i0 = null;
        lc.j.a(mainActivity, mainActivity.l0.f9505u);
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        c7.h hVar = this.f6033v.Y;
        if (hVar == null) {
            return;
        }
        ((LinearLayout) hVar.f2546c).setVisibility(z2 ? 8 : 0);
    }

    @Override // e.b
    public void j(Object obj) {
        b2.b bVar = this.f6033v.B0;
        if (bVar != null) {
            Context context = (MainActivity) bVar.f1728v;
            Intent intent = (Intent) bVar.f1729w;
            if (Settings.canDrawOverlays(context)) {
                intent.setClass(context, FloatingPlayer.class);
                context.startService(intent);
            } else {
                intent.setClass(context, PlayerActivity.class);
                context.startActivity(intent);
            }
        }
    }
}
