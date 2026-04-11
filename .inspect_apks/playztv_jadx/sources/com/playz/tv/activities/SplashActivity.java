package com.playz.tv.activities;

import a2.f0;
import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import b2.g;
import com.playz.tv.activities.SplashActivity;
import com.playz.tv.app.ProApplication;
import g4.s0;
import gc.k;
import gc.n;
import h.j;
import h.q;
import nc.x;
import oc.a;
import uc.b;
import vc.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CustomSplashScreen"})
public class SplashActivity extends j {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f3647g0 = 0;
    public ProApplication V;
    public g W;
    public int X;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3648a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public x f3649b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public a f3650c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a f3651d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f3652e0;
    public int Y = 0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final e.g f3653f0 = l(new j0(2), new s0(29));

    public final void A(String str) {
        b.f(this).edit().putString("api_host", "https://error_pro.com").apply();
        int i = this.Y;
        if (i == 0) {
            this.Z = true;
            x();
        } else if (i < 2) {
            w(str);
        } else {
            ((LinearLayout) this.W.f).setVisibility(0);
        }
        this.Y++;
    }

    public final void B() {
        a aVar = this.f3651d0;
        if (aVar == null) {
            return;
        }
        if (aVar.I == this.X) {
            y();
            return;
        }
        c cVar = (c) new a7.b(this).s(c.class);
        cVar.i = this.X;
        cVar.f13492g = this.f3652e0;
        a aVar2 = this.f3651d0;
        cVar.f = aVar2.f9507w;
        cVar.f13491e = aVar2.f9508x;
        cVar.f13493h = aVar2.H;
        cVar.f13490d = new f0(21, this);
        this.f3649b0 = new x();
        if (isFinishing() || o().L()) {
            return;
        }
        this.f3649b0.R(o(), this.f3649b0.S);
        this.f3649b0 = null;
    }

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) throws Throwable {
        q.l();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(k.activity_splash, (ViewGroup) null, false);
        int i = gc.j.btn_mobile_data_settings;
        Button button = (Button) z7.a.k(viewInflate, i);
        if (button != null) {
            i = gc.j.btn_retry;
            Button button2 = (Button) z7.a.k(viewInflate, i);
            if (button2 != null) {
                i = gc.j.btn_wifi_settings;
                Button button3 = (Button) z7.a.k(viewInflate, i);
                if (button3 != null) {
                    i = gc.j.image_card;
                    if (((CardView) z7.a.k(viewInflate, i)) != null) {
                        i = gc.j.imageView;
                        if (((ImageView) z7.a.k(viewInflate, i)) != null) {
                            i = gc.j.imgLoad;
                            ImageView imageView = (ImageView) z7.a.k(viewInflate, i);
                            if (imageView != null) {
                                i = gc.j.network_settings_buttons;
                                LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
                                if (linearLayout != null) {
                                    i = gc.j.txtName;
                                    if (((TextView) z7.a.k(viewInflate, i)) != null) {
                                        i = gc.j.versionTXT;
                                        TextView textView = (TextView) z7.a.k(viewInflate, i);
                                        if (textView != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                            this.W = new g(constraintLayout, button, button2, button3, imageView, linearLayout, textView);
                                            setContentView(constraintLayout);
                                            this.V = ProApplication.I;
                                            com.bumptech.glide.b.a(this).f2764y.c(this).o().H(Integer.valueOf(n.loading)).D((ImageView) this.W.f1740e);
                                            boolean z2 = getPackageManager().hasSystemFeature("android.software.leanback") || getPackageManager().hasSystemFeature("com.google.android.tv") || ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4;
                                            this.f3648a0 = z2;
                                            b.f(this).edit().putBoolean("is_tv", z2).apply();
                                            try {
                                                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    this.X = (int) packageInfo.getLongVersionCode();
                                                } else {
                                                    this.X = packageInfo.versionCode;
                                                }
                                                ((TextView) this.W.f1741g).setText("Version: " + packageInfo.versionName);
                                            } catch (PackageManager.NameNotFoundException e10) {
                                                e10.printStackTrace();
                                            }
                                            b.f(this).edit().putInt("non_touchscreen_ac", 1).apply();
                                            b.g(this).putInt("player_called", 0).apply();
                                            if (Build.VERSION.SDK_INT >= 33 && f0.c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                                                this.f3653f0.a("android.permission.POST_NOTIFICATIONS");
                                            }
                                            final int i10 = 0;
                                            ((Button) this.W.f1738c).setOnClickListener(new View.OnClickListener(this) { // from class: hc.r

                                                /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f6059v;

                                                {
                                                    this.f6059v = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i11 = i10;
                                                    SplashActivity splashActivity = this.f6059v;
                                                    switch (i11) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.W.f).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i12 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i11 = 1;
                                            ((Button) this.W.f1739d).setOnClickListener(new View.OnClickListener(this) { // from class: hc.r

                                                /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f6059v;

                                                {
                                                    this.f6059v = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i112 = i11;
                                                    SplashActivity splashActivity = this.f6059v;
                                                    switch (i112) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.W.f).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i12 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i12 = 2;
                                            ((Button) this.W.f1737b).setOnClickListener(new View.OnClickListener(this) { // from class: hc.r

                                                /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f6059v;

                                                {
                                                    this.f6059v = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i112 = i12;
                                                    SplashActivity splashActivity = this.f6059v;
                                                    switch (i112) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.W.f).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i122 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f3647g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            this.f3650c0 = new a();
                                            qc.b.a(this);
                                            x();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        qc.b.a(this);
        x xVar = this.f3649b0;
        if (xVar != null) {
            try {
                xVar.R(o(), this.f3649b0.S);
                this.f3649b0 = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void w(String str) {
        if (z()) {
            ga.b.q(this, str.concat("app.txt"), null, new b2.b(this, 11, str), !this.f3648a0);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new a2.a(20, this), 500L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea A[Catch: IOException -> 0x0081, XmlPullParserException -> 0x0084, TryCatch #3 {IOException -> 0x0081, XmlPullParserException -> 0x0084, blocks: (B:14:0x0074, B:16:0x007a, B:21:0x0087, B:26:0x0098, B:51:0x00ef, B:29:0x00a0, B:33:0x00b0, B:34:0x00b4, B:39:0x00c1, B:50:0x00ea, B:44:0x00d0, B:46:0x00d8, B:47:0x00dd, B:49:0x00e5), top: B:62:0x0074 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playz.tv.activities.SplashActivity.x():void");
    }

    public final void y() {
        Intent intent = new Intent(this, (Class<?>) (this.f3648a0 ? TvActivity.class : MainActivity.class));
        intent.putExtra("appDetail", this.f3651d0);
        startActivity(intent);
        finish();
    }

    public final boolean z() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (Build.VERSION.SDK_INT > 28) {
            return connectivityManager.getActiveNetwork() != null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
