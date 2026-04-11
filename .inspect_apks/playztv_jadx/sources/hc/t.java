package hc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.n0;
import com.playz.tv.activities.TvActivity;
import com.playz.tv.activities.WebActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements l9.p, nc.d, nc.l, jc.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6062u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ TvActivity f6063v;

    public /* synthetic */ t(TvActivity tvActivity, int i) {
        this.f6062u = i;
        this.f6063v = tvActivity;
    }

    @Override // jc.d
    public void a(String str) {
        ((TextView) this.f6063v.X.f2551j).setText(str);
    }

    @Override // l9.p
    public void b(MenuItem menuItem) {
        int i = TvActivity.f3654x0;
        int itemId = menuItem.getItemId();
        int i10 = gc.j.playlists;
        TvActivity tvActivity = this.f6063v;
        int i11 = 1;
        if (itemId == i10) {
            if (tvActivity.f3662h0 != null) {
                tvActivity.x();
            }
            if (tvActivity.f3663i0 == null) {
                tvActivity.f3663i0 = new nc.u();
                n0 n0VarO = tvActivity.o();
                androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                aVarI.e(gc.j.playlists_fragment_container, tvActivity.f3663i0, null, 1);
                aVarI.d(false);
                ((FragmentContainerView) tvActivity.Y.f2549g).setVisibility(0);
                ((TextView) tvActivity.X.f2551j).setText("Playlists/IPTV");
            }
        } else if (itemId == gc.j.floating_player) {
            kc.b bVarY = kc.b.y(tvActivity.getLayoutInflater());
            Switch r02 = (Switch) bVarY.f7621w;
            Spinner spinner = (Spinner) bVarY.f7622x;
            int i12 = tvActivity.getSharedPreferences("DataPreferences", 0).getInt("floatings", 0);
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
            d9.b bVar = new d9.b(tvActivity, gc.p.MyMaterialDialogTheme);
            bVar.d("Close", null);
            bVar.f((LinearLayout) bVarY.f7620v);
            bVar.f5489a.f5451n = new i(tvActivity, bVarY, i11);
            bVar.b();
        } else if (itemId == gc.j.telegram) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(tvActivity.f3664j0.f9505u));
                tvActivity.startActivity(intent);
            } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException e10) {
                Toast.makeText(tvActivity, e10.getMessage(), 0).show();
            }
        } else if (itemId == gc.j.network_streem) {
            if (tvActivity.f3663i0 != null) {
                tvActivity.y();
            }
            if (tvActivity.f3662h0 == null) {
                tvActivity.f3662h0 = new nc.s();
                n0 n0VarO2 = tvActivity.o();
                androidx.fragment.app.a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                aVarI2.e(gc.j.ns_fragment_container, tvActivity.f3662h0, null, 1);
                aVarI2.d(false);
                ((FragmentContainerView) tvActivity.Y.f).setVisibility(0);
                ((TextView) tvActivity.X.f2551j).setText("Network Stream");
            }
        } else if (itemId == gc.j.share) {
            uc.b.s(tvActivity);
        } else if (itemId == gc.j.foot_score) {
            String str = tvActivity.f3664j0.A;
            Intent intent2 = new Intent(tvActivity, (Class<?>) WebActivity.class);
            intent2.putExtra("title", "Football Score");
            intent2.putExtra("url", str);
            tvActivity.startActivity(intent2);
        } else if (itemId == gc.j.cric_score) {
            String str2 = tvActivity.f3664j0.B;
            Intent intent3 = new Intent(tvActivity, (Class<?>) WebActivity.class);
            intent3.putExtra("title", "Cricket Score");
            intent3.putExtra("url", str2);
            tvActivity.startActivity(intent3);
        } else if (itemId == gc.j.copyright) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(tvActivity.f3665k0);
            sb2.append(" Does not stream any of the channels included in this Application, all the streaming links are available on third party websites freely on internet. ");
            String strO = l4.a.o(sb2, tvActivity.f3665k0, " just gaving way to stream and all content is the copyright of their owner.");
            d9.b bVarE = new d9.b(tvActivity, gc.p.MyMaterialDialogTheme).e("Copyright Alert");
            bVarE.f5489a.f = strO;
            bVarE.d("OK", null);
            bVarE.b();
        } else if (itemId == gc.j.web) {
            tvActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(tvActivity.f3664j0.f9507w)));
        } else if (itemId == gc.j.contact_us) {
            Intent intent4 = new Intent("android.intent.action.SENDTO");
            intent4.setData(Uri.fromParts("mailto", tvActivity.f3664j0.G, null));
            try {
                tvActivity.startActivity(Intent.createChooser(intent4, "Send email using..."));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(tvActivity, "No email clients installed.", 0).show();
            }
        } else if (itemId == gc.j.exit) {
            d9.b bVarE2 = new d9.b(tvActivity, gc.p.MyMaterialDialogTheme).e("Exit");
            bVarE2.f5489a.f = "Want to exit?";
            bVarE2.d("Exit", new g(1, tvActivity));
            bVarE2.c();
            bVarE2.b();
        }
        ((DrawerLayout) tvActivity.W.f12869w).d();
    }

    @Override // nc.l
    public void c(nc.m mVar, String str) {
        switch (this.f6062u) {
            case 2:
                TvActivity tvActivity = this.f6063v;
                tvActivity.f3659e0 = mVar;
                tvActivity.Z = mVar;
                tvActivity.f3670q0 = true;
                tvActivity.f3671r0 = true;
                tvActivity.f3666m0 = str;
                tvActivity.f3667n0 = str;
                ((TextView) tvActivity.X.f2551j).setText(str);
                ((FragmentContainerView) tvActivity.Y.f2551j).setVisibility(8);
                ((FragmentContainerView) tvActivity.Y.i).setVisibility(0);
                break;
            default:
                TvActivity tvActivity2 = this.f6063v;
                tvActivity2.f3658d0 = mVar;
                tvActivity2.Z = mVar;
                tvActivity2.f3668o0 = true;
                tvActivity2.f3669p0 = true;
                tvActivity2.l0 = str;
                tvActivity2.f3667n0 = str;
                ((TextView) tvActivity2.X.f2551j).setText(str);
                ((FragmentContainerView) tvActivity2.Y.f2544a).setVisibility(8);
                ((FragmentContainerView) tvActivity2.Y.f2545b).setVisibility(0);
                break;
        }
    }

    @Override // nc.d
    public void d() {
        this.f6063v.f3661g0 = null;
    }
}
