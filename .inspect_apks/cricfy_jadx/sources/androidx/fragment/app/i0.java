package androidx.fragment.app;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.PlayerActivity;
import app.cricfy.tv.activities.TvActivity;
import app.cricfy.tv.activities.WebActivity;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1001e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(int i, Object obj) {
        this(false);
        this.f1000d = i;
        this.f1001e = obj;
    }

    public final void a() {
        switch (this.f1000d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                r0 r0Var = (r0) this.f1001e;
                r0Var.A(true);
                if (!r0Var.f1050h.f998b) {
                    r0Var.f1049g.b().a();
                } else {
                    r0Var.R();
                }
                break;
            case 1:
                ((androidx.navigation.p) this.f1001e).e();
                break;
            case 2:
                ((MainActivity) this.f1001e).x();
                break;
            case 3:
                ((PlayerActivity) this.f1001e).w();
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                TvActivity tvActivity = (TvActivity) this.f1001e;
                if (tvActivity.f1566q0 != -1) {
                    tvActivity.f1566q0 = 0;
                }
                View viewF = ((DrawerLayout) tvActivity.X.f1801x).f(8388611);
                if (viewF != null ? DrawerLayout.n(viewF) : false) {
                    ((DrawerLayout) tvActivity.X.f1801x).d();
                } else if (((EditText) tvActivity.Y.i).getVisibility() != 0) {
                    x5.b bVar = tvActivity.f1557g0;
                    if (bVar == null) {
                        x5.r rVar = tvActivity.f1558h0;
                        if (rVar == null) {
                            if (tvActivity.f1556f0 != null) {
                                r0 r0VarO = tvActivity.o();
                                a aVarF = l0.e.f(r0VarO, r0VarO);
                                aVarF.h(tvActivity.f1556f0);
                                aVarF.e(false);
                                tvActivity.f1556f0 = null;
                                ((FragmentContainerView) tvActivity.Z.f5928d).setVisibility(8);
                                ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1562l0);
                            } else if (tvActivity.f1564n0) {
                                tvActivity.f1554d0.getClass();
                                tvActivity.f1564n0 = false;
                                tvActivity.f1563m0 = false;
                                tvActivity.f1554d0 = null;
                                View currentFocus = tvActivity.getCurrentFocus();
                                if (currentFocus != null) {
                                    currentFocus.clearFocus();
                                }
                                ((MaterialButton) tvActivity.Y.f12213b).callOnClick();
                                ((MaterialButton) tvActivity.Y.f12213b).requestFocus();
                            } else if (!tvActivity.o0) {
                                View currentFocus2 = tvActivity.getCurrentFocus();
                                if (currentFocus2 != null) {
                                    currentFocus2.clearFocus();
                                }
                                ((MaterialButton) tvActivity.Y.f12214c).callOnClick();
                                ((MaterialButton) tvActivity.Y.f12214c).requestFocus();
                            } else {
                                tvActivity.finish();
                            }
                        } else if (!rVar.R()) {
                            tvActivity.w();
                            ((TextView) tvActivity.Y.f12212a).setText(tvActivity.f1562l0);
                        }
                    } else if (bVar.f14335x0 <= 0) {
                        r0 r0VarO2 = tvActivity.o();
                        a aVarF2 = l0.e.f(r0VarO2, r0VarO2);
                        aVarF2.h(tvActivity.f1557g0);
                        aVarF2.e(false);
                        tvActivity.f1557g0 = null;
                    }
                } else {
                    ((EditText) tvActivity.Y.i).setText("");
                    ((ImageView) tvActivity.Y.f12218h).setVisibility(8);
                    ((EditText) tvActivity.Y.i).setVisibility(8);
                    ((EditText) tvActivity.Y.i).clearFocus();
                    ((InputMethodManager) tvActivity.getSystemService("input_method")).hideSoftInputFromWindow(((EditText) tvActivity.Y.i).getWindowToken(), 0);
                }
                break;
            default:
                WebActivity webActivity = (WebActivity) this.f1001e;
                if (!((WebView) webActivity.W.f9072d).canGoBack()) {
                    webActivity.finish();
                } else {
                    ((WebView) webActivity.W.f9072d).goBack();
                }
                break;
        }
    }

    public final void b() throws Exception {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f999c;
        Iterator it = copyOnWriteArrayList.iterator();
        ge.i.d(it, "iterator(...)");
        while (it.hasNext()) {
            AutoCloseable autoCloseable = (AutoCloseable) it.next();
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
            } else if (autoCloseable instanceof ExecutorService) {
                a9.b.y((ExecutorService) autoCloseable);
            } else if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
        copyOnWriteArrayList.clear();
        ArrayList arrayList = this.f997a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((c.b0) obj).a();
        }
        arrayList.clear();
    }

    public final void c(boolean z10) {
        this.f998b = z10;
        ArrayList arrayList = this.f997a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            c.b0 b0Var = (c.b0) obj;
            b0Var.b(b0Var.f1935e && z10);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(h.j jVar, int i) {
        this(true);
        this.f1000d = i;
        this.f1001e = jVar;
    }

    public i0(boolean z10) {
        this.f997a = new ArrayList();
        this.f998b = z10;
        this.f999c = new CopyOnWriteArrayList();
    }
}
