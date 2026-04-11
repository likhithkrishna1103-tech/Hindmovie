package pc;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f10329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f10331c;

    public g(String str, i iVar) {
        this.f10330b = str;
        this.f10331c = iVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (com.bumptech.glide.d.a(this.f10330b, str)) {
            this.f10331c.l(str, this.f10329a);
            webView.stopLoading();
            webView.destroy();
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f10331c.l("http://error", null);
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            this.f10329a = webResourceRequest.getRequestHeaders();
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string = webResourceRequest.getUrl().toString();
        if (!com.bumptech.glide.d.a(this.f10330b, string)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        this.f10331c.l(string, this.f10329a);
        webView.stopLoading();
        webView.destroy();
        return true;
    }
}
