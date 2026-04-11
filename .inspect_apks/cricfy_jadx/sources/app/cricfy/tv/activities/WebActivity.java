package app.cricfy.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.b;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.i0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.cricfy.tv.app.ProApplication;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.datepicker.n;
import h.j;
import java.util.Objects;
import nc.p;
import q5.k;
import q5.l;
import r5.s;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class WebActivity extends j {
    public p W;
    public ProApplication X;
    public final i0 Y = new i0(this, 5);

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        h.p.k();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(l.activity_web, (ViewGroup) null, false);
        int i = k.main_toolbar_layout;
        if (((AppBarLayout) b.l(viewInflate, i)) != null) {
            i = k.refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) b.l(viewInflate, i);
            if (swipeRefreshLayout != null) {
                i = k.toolbarBinding;
                Toolbar toolbar = (Toolbar) b.l(viewInflate, i);
                if (toolbar != null) {
                    i = k.toolbar_title;
                    TextView textView = (TextView) b.l(viewInflate, i);
                    if (textView != null) {
                        i = k.toolbar_title_layout;
                        if (((LinearLayout) b.l(viewInflate, i)) != null) {
                            i = k.web_view;
                            WebView webView = (WebView) b.l(viewInflate, i);
                            if (webView != null) {
                                p pVar = new p();
                                pVar.f9069a = swipeRefreshLayout;
                                pVar.f9070b = toolbar;
                                pVar.f9071c = textView;
                                pVar.f9072d = webView;
                                this.W = pVar;
                                setContentView((LinearLayout) viewInflate);
                                ((SwipeRefreshLayout) this.W.f9069a).setRefreshing(true);
                                this.X = (ProApplication) getApplication();
                                Intent intent = getIntent();
                                j().a(this.Y, this);
                                v((Toolbar) this.W.f9070b);
                                g gVarN = n();
                                Objects.requireNonNull(gVarN);
                                gVarN.U();
                                n().T(true);
                                ((Toolbar) this.W.f9070b).setNavigationOnClickListener(new n(9, this));
                                ((Toolbar) this.W.f9070b).setTitleTextColor(-1);
                                ((TextView) this.W.f9071c).setText(intent.getStringExtra("title"));
                                ((WebView) this.W.f9072d).getSettings().setJavaScriptEnabled(true);
                                ((WebView) this.W.f9072d).getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                                ((WebView) this.W.f9072d).getSettings().setDomStorageEnabled(true);
                                ((WebView) this.W.f9072d).getSettings().setAllowContentAccess(true);
                                ((WebView) this.W.f9072d).getSettings().setAllowFileAccess(true);
                                ((WebView) this.W.f9072d).getSettings().setDisplayZoomControls(false);
                                ((WebView) this.W.f9072d).getSettings().setMixedContentMode(0);
                                ((WebView) this.W.f9072d).getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                                ((WebView) this.W.f9072d).setWebChromeClient(new s(this));
                                WebView webView2 = (WebView) this.W.f9072d;
                                String stringExtra = intent.getStringExtra("url");
                                Objects.requireNonNull(stringExtra);
                                webView2.loadUrl(stringExtra);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // h.j, android.app.Activity
    public final void onPause() {
        this.X.G = null;
        super.onPause();
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        a6.b.a(this);
    }
}
