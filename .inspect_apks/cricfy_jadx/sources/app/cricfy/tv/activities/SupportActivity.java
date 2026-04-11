package app.cricfy.tv.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.b;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import app.cricfy.tv.activities.SupportActivity;
import com.bumptech.glide.d;
import h.j;
import o.t3;
import pa.c;
import q5.h;
import q5.k;
import q5.l;
import q5.o;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SupportActivity extends j {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f1548b0 = 0;
    public t3 W;
    public a X;
    public boolean Y = false;
    public final Handler Z = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public c f1549a0;

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(l.activity_support, (ViewGroup) null, false);
        int i = k.btnClickHere;
        LinearLayout linearLayout = (LinearLayout) b.l(viewInflate, i);
        if (linearLayout != null) {
            i = k.btnGetApp;
            TextView textView = (TextView) b.l(viewInflate, i);
            if (textView != null) {
                i = k.btnHowToOpenAds;
                LinearLayout linearLayout2 = (LinearLayout) b.l(viewInflate, i);
                if (linearLayout2 != null) {
                    i = k.btnJoinTelegram;
                    LinearLayout linearLayout3 = (LinearLayout) b.l(viewInflate, i);
                    if (linearLayout3 != null) {
                        i = k.inst_time_txt;
                        TextView textView2 = (TextView) b.l(viewInflate, i);
                        if (textView2 != null) {
                            i = k.inst_wait_seconds_txt;
                            TextView textView3 = (TextView) b.l(viewInflate, i);
                            if (textView3 != null) {
                                i = k.tvAdFrequency;
                                if (((TextView) b.l(viewInflate, i)) != null) {
                                    i = k.tvSupportMeta;
                                    TextView textView4 = (TextView) b.l(viewInflate, i);
                                    if (textView4 != null) {
                                        ScrollView scrollView = (ScrollView) viewInflate;
                                        this.W = new t3(scrollView, linearLayout, textView, linearLayout2, linearLayout3, textView2, textView3, textView4);
                                        setContentView(scrollView);
                                        Intent intent = getIntent();
                                        if (Build.VERSION.SDK_INT >= 33) {
                                            this.X = (a) intent.getParcelableExtra("appDetail", a.class);
                                        } else {
                                            this.X = (a) intent.getParcelableExtra("appDetail");
                                        }
                                        if (this.X == null) {
                                            Toast.makeText(this, "App details not found", 0).show();
                                            finish();
                                            return;
                                        }
                                        ((TextView) this.W.B).setText("Wait time: " + this.X.O + "s • Trigger: every " + this.X.P + "h • Auto close: ON");
                                        TextView textView5 = (TextView) this.W.A;
                                        StringBuilder sb = new StringBuilder("Stay on the page for ");
                                        sb.append(this.X.O);
                                        sb.append(" seconds ♥️");
                                        textView5.setText(sb.toString());
                                        ((TextView) this.W.f9371z).setText("Enjoy ad-free streaming for next " + this.X.P + " " + getString(o.hours));
                                        ((LinearLayout) this.W.f9367v).startAnimation(AnimationUtils.loadAnimation(this, h.zoom_anim_loop));
                                        final int i10 = 0;
                                        ((TextView) this.W.f9369x).setOnClickListener(new View.OnClickListener(this) { // from class: r5.o

                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                            public final /* synthetic */ SupportActivity f10880w;

                                            {
                                                this.f10880w = this;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r12v5, types: [android.content.Context, app.cricfy.tv.activities.SupportActivity, java.lang.Object] */
                                            /* JADX WARN: Type inference failed for: r12v8, types: [android.widget.Toast] */
                                            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                                                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:40:0x00f6
                                                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
                                                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
                                                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
                                                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
                                                */
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(android.view.View r12) {
                                                /*
                                                    Method dump skipped, instruction units count: 300
                                                    To view this dump add '--comments-level debug' option
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: r5.o.onClick(android.view.View):void");
                                            }
                                        });
                                        final int i11 = 1;
                                        ((LinearLayout) this.W.f9370y).setOnClickListener(new View.OnClickListener(this) { // from class: r5.o

                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                            public final /* synthetic */ SupportActivity f10880w;

                                            {
                                                this.f10880w = this;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r12v5, types: [android.content.Context, app.cricfy.tv.activities.SupportActivity, java.lang.Object] */
                                            /* JADX WARN: Type inference failed for: r12v8, types: [android.widget.Toast] */
                                            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                                                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:40:0x00f6
                                                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
                                                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
                                                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
                                                */
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(android.view.View r12) {
                                                /*
                                                    Method dump skipped, instruction units count: 300
                                                    To view this dump add '--comments-level debug' option
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: r5.o.onClick(android.view.View):void");
                                            }
                                        });
                                        final int i12 = 2;
                                        ((LinearLayout) this.W.f9368w).setOnClickListener(new View.OnClickListener(this) { // from class: r5.o

                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                            public final /* synthetic */ SupportActivity f10880w;

                                            {
                                                this.f10880w = this;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r12v5, types: [android.content.Context, app.cricfy.tv.activities.SupportActivity, java.lang.Object] */
                                            /* JADX WARN: Type inference failed for: r12v8, types: [android.widget.Toast] */
                                            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                                                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:40:0x00f6
                                                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
                                                	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
                                                */
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(android.view.View r12) {
                                                /*
                                                    Method dump skipped, instruction units count: 300
                                                    To view this dump add '--comments-level debug' option
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: r5.o.onClick(android.view.View):void");
                                            }
                                        });
                                        final int i13 = 3;
                                        ((LinearLayout) this.W.f9367v).setOnClickListener(new View.OnClickListener(this) { // from class: r5.o

                                            /* JADX INFO: renamed from: w, reason: collision with root package name */
                                            public final /* synthetic */ SupportActivity f10880w;

                                            {
                                                this.f10880w = this;
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r12v5, types: [android.content.Context, app.cricfy.tv.activities.SupportActivity, java.lang.Object] */
                                            /* JADX WARN: Type inference failed for: r12v8, types: [android.widget.Toast] */
                                            /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
                                                jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:40:0x00f6
                                                	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
                                                */
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(android.view.View r12) {
                                                /*
                                                    Method dump skipped, instruction units count: 300
                                                    To view this dump add '--comments-level debug' option
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: r5.o.onClick(android.view.View):void");
                                            }
                                        });
                                        return;
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
    public final void onDestroy() {
        super.onDestroy();
        c cVar = this.f1549a0;
        if (cVar != null) {
            this.Z.removeCallbacks(cVar);
        }
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.Y) {
            this.Y = false;
            c cVar = this.f1549a0;
            if (cVar != null) {
                this.Z.removeCallbacks(cVar);
                Toast.makeText(this, "Please stay on page for " + this.X.O + " seconds...", 0).show();
            }
            ((LinearLayout) this.W.f9367v).setEnabled(true);
        }
    }

    public final boolean w() {
        return getPackageManager().resolveService(new Intent("android.support.customtabs.action.CustomTabsService"), 0) != null;
    }

    public final void x() {
        Toast.makeText(this, "Thank you for support.", 0).show();
        d.u(this).putLong("support_time_ms", System.currentTimeMillis()).apply();
        Intent intent = new Intent(this, (Class<?>) (d.t(this).getBoolean("is_tv", false) ? TvActivity.class : MainActivity.class));
        intent.putExtra("appDetail", this.X);
        startActivity(intent);
        finish();
    }

    public final void y(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
        }
    }
}
