package z5;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f15217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f15219c;

    public g(String str, i iVar) {
        this.f15218b = str;
        this.f15219c = iVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (ab.b.a(this.f15218b, str)) {
            this.f15219c.j(str, this.f15217a);
            webView.stopLoading();
            webView.destroy();
        }
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.f15219c.j("http://error", null);
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            this.f15217a = webResourceRequest.getRequestHeaders();
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string = webResourceRequest.getUrl().toString();
        if (!ab.b.a(this.f15218b, string)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        this.f15219c.j(string, this.f15217a);
        webView.stopLoading();
        webView.destroy();
        return true;
    }
}
