package r5;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.r0;
import androidx.fragment.app.w0;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.PlayerActivity;
import app.cricfy.tv.activities.WebActivity;
import app.cricfy.tv.services.FloatingPlayer;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.appbar.MaterialToolbar;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements t5.d, e.b, w0, x5.h, fa.f, hf.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10857v;

    public /* synthetic */ c(MainActivity mainActivity) {
        this.f10857v = mainActivity;
    }

    @Override // t5.d
    public void a(String str) {
        ((MaterialToolbar) this.f10857v.Y.f9017x).setTitle(str);
    }

    @Override // x5.h
    public void b(x5.i iVar, String str) {
        MainActivity mainActivity = this.f10857v;
        mainActivity.f1496f0 = iVar;
        mainActivity.f1493c0 = iVar;
        mainActivity.f1505p0 = true;
        mainActivity.f1506q0 = true;
        mainActivity.f1504n0 = str;
        mainActivity.o0 = str;
        mainActivity.f1492b0.collapseActionView();
        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle(str);
        ((FragmentContainerView) mainActivity.Z.f5925a).setVisibility(8);
        ((FragmentContainerView) mainActivity.Z.f5926b).setVisibility(0);
        mainActivity.E();
    }

    @Override // fa.f
    public void c(MenuItem menuItem) {
        int i = MainActivity.B0;
        int itemId = menuItem.getItemId();
        int i10 = q5.k.playlists_nav;
        MainActivity mainActivity = this.f10857v;
        int i11 = 0;
        if (itemId == i10) {
            if (mainActivity.f1501k0 == null) {
                mainActivity.f1501k0 = new x5.r();
                r0 r0VarO = mainActivity.o();
                androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                aVarF.f(q5.k.playlists_fragment_container, mainActivity.f1501k0, null, 1);
                aVarF.e(false);
                ((FragmentContainerView) mainActivity.Z.f).setVisibility(0);
                mainActivity.o0 = ((MaterialToolbar) mainActivity.Y.f9017x).getTitle().toString();
                ((MaterialToolbar) mainActivity.Y.f9017x).setTitle("Playlists/IPTV");
                mainActivity.E();
            }
        } else if (itemId == q5.k.floating_player) {
            l7.a aVarB = l7.a.B(mainActivity.getLayoutInflater());
            SwitchCompat switchCompat = (SwitchCompat) aVarB.f7867x;
            Spinner spinner = (Spinner) aVarB.f7868y;
            int i12 = mainActivity.getSharedPreferences("DataPreferences", 0).getInt("floatings", 0);
            if (i12 > 0) {
                switchCompat.setChecked(true);
                spinner.setAlpha(1.0f);
                spinner.setSelection(i12 - 1);
                spinner.setEnabled(true);
                spinner.setClickable(true);
            } else {
                spinner.setEnabled(false);
                spinner.setClickable(false);
            }
            switchCompat.setOnCheckedChangeListener(new g(aVarB, i11));
            x9.b bVar = new x9.b(mainActivity, q5.p.MyMaterialDialogTheme);
            bVar.f("Close", null);
            bVar.h((LinearLayout) aVarB.f7866w);
            bVar.f5346a.f5301n = new h(mainActivity, aVarB, i11);
            bVar.d();
        } else if (itemId == q5.k.telegram_nav) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(mainActivity.f1502l0.f14906x));
                mainActivity.startActivity(intent);
            } catch (ActivityNotFoundException e9) {
                Toast.makeText(mainActivity, e9.getMessage(), 0).show();
            }
        } else if (itemId == q5.k.network_streem) {
            v5.m.k(mainActivity);
        } else if (itemId == q5.k.share_nav) {
            j4.C(mainActivity);
        } else if (itemId == q5.k.foot_score) {
            String str = mainActivity.f1502l0.D;
            Intent intent2 = new Intent(mainActivity, (Class<?>) WebActivity.class);
            intent2.putExtra("title", "Football Score");
            intent2.putExtra("url", str);
            mainActivity.startActivity(intent2);
        } else if (itemId == q5.k.cric_score) {
            String str2 = mainActivity.f1502l0.E;
            Intent intent3 = new Intent(mainActivity, (Class<?>) WebActivity.class);
            intent3.putExtra("title", "Cricket Score");
            intent3.putExtra("url", str2);
            mainActivity.startActivity(intent3);
        } else if (itemId == q5.k.force_low) {
            w1.d.u(mainActivity);
        } else if (itemId == q5.k.copyright) {
            StringBuilder sb = new StringBuilder();
            sb.append(mainActivity.f1503m0);
            sb.append(" Does not stream any of the channels included in this Application, all the streaming links are available on third party websites freely on internet. ");
            String strQ = q4.a.q(sb, mainActivity.f1503m0, " just gaving way to stream and all content is the copyright of their owner.");
            x9.b bVarG = new x9.b(mainActivity, 0).g("Copyright Alert");
            bVarG.f5346a.f = strQ;
            bVarG.f("OK", null);
            bVarG.d();
        } else if (itemId == q5.k.update_nav) {
            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mainActivity.f1502l0.f14908z)));
        } else if (itemId == q5.k.email_nav) {
            Intent intent4 = new Intent("android.intent.action.SENDTO");
            intent4.setData(Uri.fromParts("mailto", mainActivity.f1502l0.J, null));
            try {
                mainActivity.startActivity(Intent.createChooser(intent4, "Send email using..."));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(mainActivity, "No email clients installed.", 0).show();
            }
        } else if (itemId == q5.k.exit_nav) {
            x9.b bVarG2 = new x9.b(mainActivity, 0).g("Exit");
            bVarG2.f5346a.f = "Want to exit?";
            bVarG2.f("Exit", new a6.c(2, mainActivity));
            bVarG2.e();
            bVarG2.d();
        }
        ((DrawerLayout) mainActivity.X.f2038e).d();
    }

    @Override // hf.d
    public void d(int i) {
        MainActivity mainActivity = this.f10857v;
        if (mainActivity.f1501k0 != null) {
            mainActivity.B();
        }
        mainActivity.A();
        mainActivity.z();
        if (i == 1) {
            mainActivity.o0 = "Sports";
            if (mainActivity.f1497g0 == null) {
                y5.a aVar = mainActivity.f1502l0;
                mainActivity.f1497g0 = x5.i.X(aVar.f14904v, aVar.f14905w, true);
                r0 r0VarO = mainActivity.o();
                androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                aVarF.f(q5.k.sports_fragment_container, mainActivity.f1497g0, null, 1);
                aVarF.e(false);
            }
            mainActivity.f1508s0 = false;
            mainActivity.f1507r0 = false;
            mainActivity.f1506q0 = false;
            ((FragmentContainerView) mainActivity.Z.f5927c).setVisibility(8);
            ((FragmentContainerView) mainActivity.Z.f5925a).setVisibility(8);
            ((FragmentContainerView) mainActivity.Z.f5926b).setVisibility(8);
            ((FragmentContainerView) mainActivity.Z.f5928d).setVisibility(8);
            mainActivity.f1493c0 = mainActivity.f1497g0;
            ((FragmentContainerView) mainActivity.Z.f5931h).setVisibility(0);
            if (mainActivity.f1512w0 == 0) {
                mainActivity.f1497g0.U("");
            }
        } else if (i == 2) {
            mainActivity.o0 = "Categories";
            mainActivity.C();
        } else {
            mainActivity.o0 = mainActivity.f1503m0;
            mainActivity.D();
        }
        ((MaterialToolbar) mainActivity.Y.f9017x).setTitle(mainActivity.o0);
    }

    @Override // androidx.fragment.app.w0
    public void e(Bundle bundle) {
        MainActivity mainActivity = this.f10857v;
        mainActivity.f1500j0 = null;
        v5.o.a(mainActivity, mainActivity.f1502l0.f14906x);
    }

    @Override // e.b
    public void i(Object obj) {
        androidx.fragment.app.e eVar = this.f10857v.f1513x0;
        if (eVar != null) {
            Context context = (MainActivity) eVar.f969w;
            Intent intent = (Intent) eVar.f970x;
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
