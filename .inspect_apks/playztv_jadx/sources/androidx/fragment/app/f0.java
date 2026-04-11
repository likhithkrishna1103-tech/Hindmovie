package androidx.fragment.app;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.button.MaterialButton;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.PlayerActivity;
import com.playz.tv.activities.TvActivity;
import com.playz.tv.activities.WebActivity;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f1275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1277e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(h.j jVar, int i) {
        this(true);
        this.f1276d = i;
        this.f1277e = jVar;
    }

    public final void a() {
        switch (this.f1276d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n0 n0Var = (n0) this.f1277e;
                n0Var.x(true);
                if (!n0Var.f1316h.f1274b) {
                    n0Var.f1315g.f2158c.a();
                } else {
                    n0Var.O();
                }
                break;
            case 1:
                ((MainActivity) this.f1277e).x();
                break;
            case 2:
                ((PlayerActivity) this.f1277e).w();
                break;
            case 3:
                TvActivity tvActivity = (TvActivity) this.f1277e;
                if (tvActivity.f3675v0 != -1) {
                    tvActivity.f3675v0 = 0;
                }
                View viewF = ((DrawerLayout) tvActivity.W.f12869w).f(8388611);
                if (viewF != null ? DrawerLayout.n(viewF) : false) {
                    ((DrawerLayout) tvActivity.W.f12869w).d();
                } else if (((EditText) tvActivity.X.f2550h).getVisibility() != 0) {
                    nc.e eVar = tvActivity.f3661g0;
                    if (eVar == null) {
                        if (tvActivity.f3662h0 == null) {
                            nc.u uVar = tvActivity.f3663i0;
                            if (uVar == null) {
                                if (tvActivity.f3660f0 != null) {
                                    n0 n0VarO = tvActivity.o();
                                    a aVarI = e6.j.i(n0VarO, n0VarO);
                                    aVarI.g(tvActivity.f3660f0);
                                    aVarI.d(false);
                                    tvActivity.f3660f0 = null;
                                    ((FragmentContainerView) tvActivity.Y.f2548e).setVisibility(8);
                                    ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3667n0);
                                } else if (tvActivity.f3669p0) {
                                    tvActivity.f3658d0.getClass();
                                    tvActivity.f3669p0 = false;
                                    tvActivity.f3668o0 = false;
                                    tvActivity.f3658d0 = null;
                                    tvActivity.w();
                                    ((MaterialButton) tvActivity.X.f2544a).callOnClick();
                                    ((MaterialButton) tvActivity.X.f2544a).requestFocus();
                                } else if (tvActivity.f3671r0) {
                                    tvActivity.f3659e0.getClass();
                                    tvActivity.f3671r0 = false;
                                    tvActivity.f3670q0 = false;
                                    tvActivity.f3659e0 = null;
                                    tvActivity.w();
                                    ((MaterialButton) tvActivity.X.i).callOnClick();
                                    ((MaterialButton) tvActivity.X.i).requestFocus();
                                } else if (!tvActivity.f3672s0) {
                                    if (!tvActivity.f3673t0) {
                                        tvActivity.w();
                                        ((MaterialButton) tvActivity.X.f2545b).callOnClick();
                                        ((MaterialButton) tvActivity.X.f2545b).requestFocus();
                                    } else {
                                        tvActivity.finish();
                                    }
                                } else if (!tvActivity.f3673t0) {
                                    tvActivity.w();
                                    ((MaterialButton) tvActivity.X.f2544a).callOnClick();
                                    ((MaterialButton) tvActivity.X.f2544a).requestFocus();
                                } else {
                                    tvActivity.w();
                                    ((MaterialButton) tvActivity.X.f2545b).callOnClick();
                                    ((MaterialButton) tvActivity.X.f2545b).requestFocus();
                                }
                            } else if (!uVar.P()) {
                                tvActivity.y();
                                ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3667n0);
                            }
                        } else {
                            tvActivity.x();
                            ((TextView) tvActivity.X.f2551j).setText(tvActivity.f3667n0);
                        }
                    } else if (eVar.f8928x0 <= 0) {
                        n0 n0VarO2 = tvActivity.o();
                        a aVarI2 = e6.j.i(n0VarO2, n0VarO2);
                        aVarI2.g(tvActivity.f3661g0);
                        aVarI2.d(false);
                        tvActivity.f3661g0 = null;
                    }
                } else {
                    ((EditText) tvActivity.X.f2550h).setText("");
                    ((ImageView) tvActivity.X.f2549g).setVisibility(8);
                    ((EditText) tvActivity.X.f2550h).setVisibility(8);
                    ((EditText) tvActivity.X.f2550h).clearFocus();
                    ((InputMethodManager) tvActivity.getSystemService("input_method")).hideSoftInputFromWindow(((EditText) tvActivity.X.f2550h).getWindowToken(), 0);
                }
                break;
            default:
                WebActivity webActivity = (WebActivity) this.f1277e;
                if (!((WebView) webActivity.V.f12871y).canGoBack()) {
                    webActivity.finish();
                } else {
                    ((WebView) webActivity.V.f12871y).goBack();
                }
                break;
        }
    }

    public final void b(boolean z2) {
        this.f1274b = z2;
        ArrayList arrayList = this.f1273a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            c.z zVar = (c.z) obj;
            zVar.b(zVar.f2207e && z2);
        }
    }

    public f0(boolean z2) {
        this.f1273a = new ArrayList();
        this.f1274b = z2;
        this.f1275c = new CopyOnWriteArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f0(n0 n0Var) {
        this(false);
        this.f1276d = 0;
        this.f1277e = n0Var;
    }
}
