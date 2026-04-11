package hc;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.playz.tv.activities.WebActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebActivity f6067a;

    public w(WebActivity webActivity) {
        this.f6067a = webActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (i >= 50) {
            ((SwipeRefreshLayout) this.f6067a.V.f12868v).setRefreshing(false);
        }
    }
}
