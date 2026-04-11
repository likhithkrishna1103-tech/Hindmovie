package r5;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.r0;
import androidx.fragment.app.w0;
import app.cricfy.tv.activities.TvActivity;
import app.cricfy.tv.activities.WebActivity;
import com.google.android.gms.internal.measurement.j4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements w0, fa.f, t5.d, x5.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ TvActivity f10883v;

    public /* synthetic */ q(TvActivity tvActivity) {
        this.f10883v = tvActivity;
    }

    @Override // t5.d
    public void a(String str) {
        ((TextView) this.f10883v.Y.f12212a).setText(str);
    }

    @Override // x5.h
    public void b(x5.i iVar, String str) {
        TvActivity tvActivity = this.f10883v;
        tvActivity.f1554d0 = iVar;
        tvActivity.f1551a0 = iVar;
        tvActivity.f1563m0 = true;
        tvActivity.f1564n0 = true;
        tvActivity.f1561k0 = str;
        tvActivity.f1562l0 = str;
        ((TextView) tvActivity.Y.f12212a).setText(str);
        ((FragmentContainerView) tvActivity.Z.f5925a).setVisibility(8);
        ((FragmentContainerView) tvActivity.Z.f5926b).setVisibility(0);
    }

    @Override // fa.f
    public void c(MenuItem menuItem) {
        int i = TvActivity.f1550s0;
        int itemId = menuItem.getItemId();
        int i10 = q5.k.playlists_nav;
        TvActivity tvActivity = this.f10883v;
        int i11 = 1;
        if (itemId == i10) {
            if (tvActivity.f1558h0 == null) {
                tvActivity.f1558h0 = new x5.r();
                r0 r0VarO = tvActivity.o();
                androidx.fragment.app.a aVarF = l0.e.f(r0VarO, r0VarO);
                aVarF.f(q5.k.playlists_fragment_container, tvActivity.f1558h0, null, 1);
                aVarF.e(false);
                ((FragmentContainerView) tvActivity.Z.f).setVisibility(0);
                ((TextView) tvActivity.Y.f12212a).setText("Playlists/IPTV");
            }
        } else if (itemId == q5.k.floating_player) {
            l7.a aVarB = l7.a.B(tvActivity.getLayoutInflater());
            SwitchCompat switchCompat = (SwitchCompat) aVarB.f7867x;
            Spinner spinner = (Spinner) aVarB.f7868y;
            int i12 = tvActivity.getSharedPreferences("DataPreferences", 0).getInt("floatings", 0);
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
            x9.b bVar = new x9.b(tvActivity, q5.p.MyMaterialDialogTheme);
            bVar.f("Close", null);
            bVar.h((LinearLayout) aVarB.f7866w);
            bVar.f5346a.f5301n = new h(tvActivity, aVarB, i11);
            bVar.d();
        } else if (itemId == q5.k.telegram_nav) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(tvActivity.f1559i0.f14906x));
                tvActivity.startActivity(intent);
            } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException e9) {
                Toast.makeText(tvActivity, e9.getMessage(), 0).show();
            }
        } else if (itemId == q5.k.network_streem) {
            v5.m.k(tvActivity);
        } else if (itemId == q5.k.share_nav) {
            j4.C(tvActivity);
        } else if (itemId == q5.k.foot_score) {
            String str = tvActivity.f1559i0.D;
            Intent intent2 = new Intent(tvActivity, (Class<?>) WebActivity.class);
            intent2.putExtra("title", "Football Score");
            intent2.putExtra("url", str);
            tvActivity.startActivity(intent2);
        } else if (itemId == q5.k.cric_score) {
            String str2 = tvActivity.f1559i0.E;
            Intent intent3 = new Intent(tvActivity, (Class<?>) WebActivity.class);
            intent3.putExtra("title", "Cricket Score");
            intent3.putExtra("url", str2);
            tvActivity.startActivity(intent3);
        } else if (itemId == q5.k.force_low) {
            w1.d.u(tvActivity);
        } else if (itemId == q5.k.copyright) {
            StringBuilder sb = new StringBuilder();
            sb.append(tvActivity.f1560j0);
            sb.append(" Does not stream any of the channels included in this Application, all the streaming links are available on third party websites freely on internet. ");
            String strQ = q4.a.q(sb, tvActivity.f1560j0, " just gaving way to stream and all content is the copyright of their owner.");
            x9.b bVarG = new x9.b(tvActivity, 0).g("Copyright Alert");
            bVarG.f5346a.f = strQ;
            bVarG.f("OK", null);
            bVarG.d();
        } else if (itemId == q5.k.update_nav) {
            tvActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(tvActivity.f1559i0.f14908z)));
        } else if (itemId == q5.k.email_nav) {
            Intent intent4 = new Intent("android.intent.action.SENDTO");
            intent4.setData(Uri.fromParts("mailto", tvActivity.f1559i0.J, null));
            try {
                tvActivity.startActivity(Intent.createChooser(intent4, "Send email using..."));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(tvActivity, "No email clients installed.", 0).show();
            }
        } else if (itemId == q5.k.exit_nav) {
            x9.b bVarG2 = new x9.b(tvActivity, 0).g("Exit");
            bVarG2.f5346a.f = "Want to exit?";
            bVarG2.f("Exit", new a6.c(3, tvActivity));
            bVarG2.e();
            bVarG2.d();
        }
        ((DrawerLayout) tvActivity.X.f1801x).d();
    }

    @Override // androidx.fragment.app.w0
    public void e(Bundle bundle) {
        this.f10883v.f1557g0 = null;
    }
}
