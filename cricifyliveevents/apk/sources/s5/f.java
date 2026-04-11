package s5;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f11485a;

    public f(g gVar) {
        this.f11485a = gVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        g gVar = this.f11485a;
        String string = webResourceRequest.getUrl().toString();
        if ("http://localhost:9867/".equals(string)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                intent.setPackage("com.android.chrome");
                gVar.f11489x.f11497e.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                return true;
            }
        } catch (ActivityNotFoundException unused2) {
            gVar.f11489x.f11497e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
            return true;
        }
    }
}
