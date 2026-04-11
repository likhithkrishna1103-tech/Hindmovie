package com.playz.tv.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.f0;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.d;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.datepicker.n;
import com.playz.tv.app.ProApplication;
import gc.k;
import h.j;
import h.q;
import hc.w;
import java.util.Objects;
import qc.b;
import ub.o;
import z7.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class WebActivity extends j {
    public o V;
    public ProApplication W;
    public final f0 X = new f0(this, 4);

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        q.l();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(k.activity_web, (ViewGroup) null, false);
        int i = gc.j.main_toolbar_layout;
        if (((AppBarLayout) a.k(viewInflate, i)) != null) {
            i = gc.j.refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) a.k(viewInflate, i);
            if (swipeRefreshLayout != null) {
                i = gc.j.toolbarBinding;
                Toolbar toolbar = (Toolbar) a.k(viewInflate, i);
                if (toolbar != null) {
                    i = gc.j.toolbar_title;
                    TextView textView = (TextView) a.k(viewInflate, i);
                    if (textView != null) {
                        i = gc.j.toolbar_title_layout;
                        if (((LinearLayout) a.k(viewInflate, i)) != null) {
                            i = gc.j.web_view;
                            WebView webView = (WebView) a.k(viewInflate, i);
                            if (webView != null) {
                                LinearLayout linearLayout = (LinearLayout) viewInflate;
                                this.V = new o(linearLayout, swipeRefreshLayout, toolbar, textView, webView, 20);
                                setContentView(linearLayout);
                                ((SwipeRefreshLayout) this.V.f12868v).setRefreshing(true);
                                this.W = (ProApplication) getApplication();
                                Intent intent = getIntent();
                                j().a(this.X, this);
                                v((Toolbar) this.V.f12869w);
                                d dVarN = n();
                                Objects.requireNonNull(dVarN);
                                dVarN.K();
                                n().J(true);
                                ((Toolbar) this.V.f12869w).setNavigationOnClickListener(new n(1, this));
                                ((Toolbar) this.V.f12869w).setTitleTextColor(-1);
                                ((TextView) this.V.f12870x).setText(intent.getStringExtra("title"));
                                ((WebView) this.V.f12871y).getSettings().setJavaScriptEnabled(true);
                                ((WebView) this.V.f12871y).getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                                ((WebView) this.V.f12871y).getSettings().setDomStorageEnabled(true);
                                ((WebView) this.V.f12871y).getSettings().setAllowContentAccess(true);
                                ((WebView) this.V.f12871y).getSettings().setAllowFileAccess(true);
                                ((WebView) this.V.f12871y).getSettings().setDisplayZoomControls(false);
                                ((WebView) this.V.f12871y).getSettings().setMixedContentMode(0);
                                ((WebView) this.V.f12871y).getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
                                ((WebView) this.V.f12871y).setWebChromeClient(new w(this));
                                WebView webView2 = (WebView) this.V.f12871y;
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
        this.W.F = null;
        super.onPause();
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        b.a(this);
    }
}
