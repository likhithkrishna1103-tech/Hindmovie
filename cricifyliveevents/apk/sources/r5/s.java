package r5;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.activities.WebActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebActivity f10885a;

    public s(WebActivity webActivity) {
        this.f10885a = webActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        if (i >= 50) {
            ((SwipeRefreshLayout) this.f10885a.W.f9069a).setRefreshing(false);
        }
    }
}
