package ic;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f6510a;

    public h(i iVar) {
        this.f6510a = iVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        i iVar = this.f6510a;
        String string = webResourceRequest.getUrl().toString();
        if ("http://localhost:9867/".equals(string)) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
                intent.setPackage("com.android.chrome");
                iVar.f6514x.f6522e.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                return true;
            }
        } catch (ActivityNotFoundException unused2) {
            iVar.f6514x.f6522e.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
            return true;
        }
    }
}
