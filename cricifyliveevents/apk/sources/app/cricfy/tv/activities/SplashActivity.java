package app.cricfy.tv.activities;

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
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.emoji2.text.v;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.m0;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.SplashActivity;
import app.cricfy.tv.app.ProApplication;
import c2.o;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.d;
import com.google.android.material.button.MaterialButton;
import e.g;
import f6.c;
import h.j;
import h.p;
import l0.e;
import nc.l;
import q5.k;
import x5.u;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CustomSplashScreen"})
public class SplashActivity extends j {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f1541g0 = 0;
    public ProApplication W;
    public o X;
    public int Y;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1542a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1543b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public u f1544c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a f1545d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f1546e0;
    public int Z = 0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final g f1547f0 = l(new l(11), new m0(2));

    public final void A(String str) {
        d.t(this).edit().putString("api_host", "https://error_pro.com").apply();
        int i = this.Z;
        if (i == 0) {
            this.f1542a0 = true;
            x();
        } else if (i < 2) {
            w(str);
        } else {
            ((LinearLayout) this.X.f2035b).setVisibility(0);
        }
        this.Z++;
    }

    public final void B() {
        a aVar = this.f1545d0;
        if (aVar == null) {
            return;
        }
        if (aVar.Q == this.Y) {
            y();
            return;
        }
        c cVar = (c) new v(this).r(c.class);
        cVar.f3983h = this.Y;
        cVar.f3982g = this.f1546e0;
        a aVar2 = this.f1545d0;
        cVar.f = aVar2.f14908z;
        cVar.f3981e = aVar2.A;
        cVar.f3980d = new kb.d(9, this);
        this.f1544c0 = new u();
        if (isFinishing() || o().O()) {
            return;
        }
        r0 r0VarO = o();
        androidx.fragment.app.a aVarF = e.f(r0VarO, r0VarO);
        aVarF.f(k.update_container, this.f1544c0, null, 1);
        aVarF.e(false);
        ((FragmentContainerView) this.X.f2038e).setVisibility(0);
        this.f1544c0 = null;
    }

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) throws Throwable {
        p.k();
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(q5.l.activity_splash, (ViewGroup) null, false);
        int i = k.anim_splash;
        if (((LottieAnimationView) b.l(viewInflate, i)) != null) {
            i = k.ly_offline;
            LinearLayout linearLayout = (LinearLayout) b.l(viewInflate, i);
            if (linearLayout != null) {
                i = k.ly_splash;
                if (((LinearLayout) b.l(viewInflate, i)) != null) {
                    i = k.mobile_data_btn;
                    MaterialButton materialButton = (MaterialButton) b.l(viewInflate, i);
                    if (materialButton != null) {
                        i = k.refresh_btn;
                        MaterialButton materialButton2 = (MaterialButton) b.l(viewInflate, i);
                        if (materialButton2 != null) {
                            i = k.splash_img;
                            if (((ImageView) b.l(viewInflate, i)) != null) {
                                i = k.update_container;
                                FragmentContainerView fragmentContainerView = (FragmentContainerView) b.l(viewInflate, i);
                                if (fragmentContainerView != null) {
                                    i = k.version_txt;
                                    TextView textView = (TextView) b.l(viewInflate, i);
                                    if (textView != null) {
                                        i = k.wifi_setting_btn;
                                        MaterialButton materialButton3 = (MaterialButton) b.l(viewInflate, i);
                                        if (materialButton3 != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                                            this.X = new o(relativeLayout, linearLayout, materialButton, materialButton2, fragmentContainerView, textView, materialButton3, 8);
                                            setContentView(relativeLayout);
                                            this.W = ProApplication.K;
                                            boolean z10 = getPackageManager().hasSystemFeature("android.software.leanback") || getPackageManager().hasSystemFeature("com.google.android.tv") || ((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4;
                                            this.f1543b0 = z10;
                                            d.t(this).edit().putBoolean("is_tv", z10).apply();
                                            try {
                                                PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    this.Y = (int) packageInfo.getLongVersionCode();
                                                } else {
                                                    this.Y = packageInfo.versionCode;
                                                }
                                                ((TextView) this.X.f).setText("Version: " + packageInfo.versionName);
                                            } catch (PackageManager.NameNotFoundException e9) {
                                                e9.printStackTrace();
                                            }
                                            d.t(this).edit().putInt("non_touchscreen_ac", 1).apply();
                                            d.u(this).putInt("player_called", 0).apply();
                                            if (Build.VERSION.SDK_INT >= 33 && i0.c.a(this, "android.permission.POST_NOTIFICATIONS") != 0 && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                                                this.f1547f0.a("android.permission.POST_NOTIFICATIONS");
                                            }
                                            final int i10 = 0;
                                            ((MaterialButton) this.X.f2037d).setOnClickListener(new View.OnClickListener(this) { // from class: r5.n

                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f10878w;

                                                {
                                                    this.f10878w = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i11 = i10;
                                                    SplashActivity splashActivity = this.f10878w;
                                                    switch (i11) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.X.f2035b).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i12 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i11 = 1;
                                            ((MaterialButton) this.X.f2039g).setOnClickListener(new View.OnClickListener(this) { // from class: r5.n

                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f10878w;

                                                {
                                                    this.f10878w = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i112 = i11;
                                                    SplashActivity splashActivity = this.f10878w;
                                                    switch (i112) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.X.f2035b).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i12 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i12 = 2;
                                            ((MaterialButton) this.X.f2036c).setOnClickListener(new View.OnClickListener(this) { // from class: r5.n

                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                public final /* synthetic */ SplashActivity f10878w;

                                                {
                                                    this.f10878w = this;
                                                }

                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) throws Throwable {
                                                    int i112 = i12;
                                                    SplashActivity splashActivity = this.f10878w;
                                                    switch (i112) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((LinearLayout) splashActivity.X.f2035b).setVisibility(8);
                                                            splashActivity.x();
                                                            break;
                                                        case 1:
                                                            int i122 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                                            break;
                                                        default:
                                                            int i13 = SplashActivity.f1541g0;
                                                            splashActivity.getClass();
                                                            splashActivity.startActivity(new Intent("android.settings.NETWORK_OPERATOR_SETTINGS"));
                                                            break;
                                                    }
                                                }
                                            });
                                            a6.b.a(this);
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
        a6.b.a(this);
        if (this.f1544c0 != null) {
            try {
                r0 r0VarO = o();
                r0VarO.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0VarO);
                aVar.f(k.update_container, this.f1544c0, null, 1);
                aVar.e(false);
                ((FragmentContainerView) this.X.f2038e).setVisibility(0);
                this.f1544c0 = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void w(String str) {
        if (z()) {
            b.p(this, str.concat("app.txt"), null, new androidx.fragment.app.e(18, this, str), !this.f1543b0);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new pa.c(6, this), 500L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3 A[Catch: IOException -> 0x007a, XmlPullParserException -> 0x007d, TryCatch #3 {IOException -> 0x007a, XmlPullParserException -> 0x007d, blocks: (B:14:0x006d, B:16:0x0073, B:21:0x0080, B:26:0x0091, B:51:0x00e8, B:29:0x0099, B:33:0x00a9, B:34:0x00ad, B:39:0x00ba, B:50:0x00e3, B:44:0x00c9, B:46:0x00d1, B:47:0x00d6, B:49:0x00de), top: B:62:0x006d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cricfy.tv.activities.SplashActivity.x():void");
    }

    public final void y() {
        Intent intent;
        if (TextUtils.isEmpty(this.f1545d0.L) || !this.f1545d0.L.startsWith("http")) {
            intent = new Intent(this, this.f1543b0 ? TvActivity.class : MainActivity.class);
        } else {
            if (System.currentTimeMillis() - d.t(this).getLong("support_time_ms", 0L) > ((long) this.f1545d0.P) * 3600000) {
                intent = new Intent(this, (Class<?>) SupportActivity.class);
            } else {
                intent = new Intent(this, this.f1543b0 ? TvActivity.class : MainActivity.class);
            }
        }
        intent.putExtra("appDetail", this.f1545d0);
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
