package com.playz.tv.activities;

import a2.o0;
import a2.p0;
import aa.c1;
import android.app.PictureInPictureParams;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.f0;
import androidx.fragment.app.n0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.o;
import com.google.android.material.card.MaterialCardView;
import com.playz.tv.activities.PlayerActivity;
import com.playz.tv.app.ProApplication;
import e2.t;
import g4.u;
import gc.g;
import gc.k;
import h.j;
import hc.l;
import hc.n;
import i4.h0;
import ic.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kc.b;
import kc.d;
import nc.q;
import nc.x;
import oc.a;
import oc.f;
import org.json.JSONArray;
import org.json.JSONException;
import p1.a0;
import p1.b0;
import p1.c0;
import p1.d0;
import p1.g0;
import p1.j0;
import p1.v;
import p1.w;
import p1.y;
import p1.z;
import vc.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class PlayerActivity extends j {
    public static final /* synthetic */ int M0 = 0;
    public boolean A0;
    public boolean B0;
    public g D0;
    public Handler E0;
    public n F0;
    public a G0;
    public String H0;
    public q I0;
    public ArrayList J0;
    public View K0;
    public ProApplication V;
    public kc.a W;
    public d X;
    public RecyclerView Y;
    public p Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ArrayList f3622a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public l f3623b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public o0 f3624c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public u f3625d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public PlayerView f3626e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public lc.n f3627f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f3628g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f3629h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public String f3630i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f3631j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f3632k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f3633m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f3634n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f3635o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f3636p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f3637q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f3638r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public float f3639s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3640t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f3641u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f3642v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f3643w0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f3645y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f3646z0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final u5.d f3644x0 = new u5.d(16, this);
    public boolean C0 = true;
    public final f0 L0 = new f0(this, 2);

    public static void C(Map map, b bVar) {
        if (map.isEmpty()) {
            return;
        }
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if ("user-agent".equals(str.toLowerCase())) {
                String strTrim = ((String) entry.getValue()).replaceAll("[\\r\\n]", "").trim();
                bVar.f7622x = "null".equals(strTrim) ? "" : strTrim;
                map.remove(str);
            }
        }
        bVar.F(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:14:0x0038, B:16:0x0048, B:18:0x004e, B:24:0x006e, B:27:0x0078, B:39:0x0102, B:41:0x0110, B:43:0x0123, B:46:0x018a, B:48:0x0195, B:50:0x019d, B:52:0x01a5, B:54:0x01ae, B:57:0x01b4, B:60:0x01bc, B:62:0x01cf, B:63:0x01d5, B:58:0x01b7, B:59:0x01ba, B:53:0x01aa, B:64:0x0214, B:66:0x021a, B:67:0x023d, B:68:0x0242, B:69:0x0243, B:71:0x0264, B:72:0x0272, B:73:0x0277, B:42:0x0119, B:30:0x00e9, B:32:0x00f1, B:35:0x00fb, B:21:0x0055, B:23:0x005d), top: B:90:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:14:0x0038, B:16:0x0048, B:18:0x004e, B:24:0x006e, B:27:0x0078, B:39:0x0102, B:41:0x0110, B:43:0x0123, B:46:0x018a, B:48:0x0195, B:50:0x019d, B:52:0x01a5, B:54:0x01ae, B:57:0x01b4, B:60:0x01bc, B:62:0x01cf, B:63:0x01d5, B:58:0x01b7, B:59:0x01ba, B:53:0x01aa, B:64:0x0214, B:66:0x021a, B:67:0x023d, B:68:0x0242, B:69:0x0243, B:71:0x0264, B:72:0x0272, B:73:0x0277, B:42:0x0119, B:30:0x00e9, B:32:0x00f1, B:35:0x00fb, B:21:0x0055, B:23:0x005d), top: B:90:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018a A[Catch: Exception -> 0x0052, TRY_ENTER, TryCatch #1 {Exception -> 0x0052, blocks: (B:14:0x0038, B:16:0x0048, B:18:0x004e, B:24:0x006e, B:27:0x0078, B:39:0x0102, B:41:0x0110, B:43:0x0123, B:46:0x018a, B:48:0x0195, B:50:0x019d, B:52:0x01a5, B:54:0x01ae, B:57:0x01b4, B:60:0x01bc, B:62:0x01cf, B:63:0x01d5, B:58:0x01b7, B:59:0x01ba, B:53:0x01aa, B:64:0x0214, B:66:0x021a, B:67:0x023d, B:68:0x0242, B:69:0x0243, B:71:0x0264, B:72:0x0272, B:73:0x0277, B:42:0x0119, B:30:0x00e9, B:32:0x00f1, B:35:0x00fb, B:21:0x0055, B:23:0x005d), top: B:90:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0243 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:14:0x0038, B:16:0x0048, B:18:0x004e, B:24:0x006e, B:27:0x0078, B:39:0x0102, B:41:0x0110, B:43:0x0123, B:46:0x018a, B:48:0x0195, B:50:0x019d, B:52:0x01a5, B:54:0x01ae, B:57:0x01b4, B:60:0x01bc, B:62:0x01cf, B:63:0x01d5, B:58:0x01b7, B:59:0x01ba, B:53:0x01aa, B:64:0x0214, B:66:0x021a, B:67:0x023d, B:68:0x0242, B:69:0x0243, B:71:0x0264, B:72:0x0272, B:73:0x0277, B:42:0x0119, B:30:0x00e9, B:32:0x00f1, B:35:0x00fb, B:21:0x0055, B:23:0x005d), top: B:90:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.util.Map r32) {
        /*
            Method dump skipped, instruction units count: 869
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playz.tv.activities.PlayerActivity.A(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void B() {
        p pVar = this.Z;
        if (pVar != null) {
            int i = pVar.f6539g + 1;
            if (i == this.f3622a0.size()) {
                i = 0;
            }
            f fVar = (f) this.f3622a0.get(i);
            this.f3623b0.a(fVar.f9541v.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), fVar.f9542w, fVar.f9543x, fVar.f9544y, fVar.f9545z, fVar.A);
            if (this.Z.f6539g != i) {
                this.Y.g0(i);
                new Handler(Looper.getMainLooper()).postDelayed(new p0(i, 3, this), 100L);
            }
        }
    }

    public final void D() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.W.f.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.W.f.setLayoutParams(layoutParams);
    }

    public final void E(String str, boolean z2) {
        if (this.W == null) {
            return;
        }
        o0 o0Var = this.f3624c0;
        if (o0Var != null) {
            o0Var.F1();
        }
        u uVar = this.f3625d0;
        if (uVar != null) {
            uVar.a();
        }
        if (z2) {
            ga.b.p(this, ga.b.n(this, str), new l(this, 4));
            return;
        }
        if (str.contains("[*]")) {
            ga.b.r(str, new l(this, 0));
            return;
        }
        try {
            if (!str.startsWith("[")) {
                str = qc.a.b(str);
            }
            JSONArray jSONArray = new JSONArray(str);
            f fVarB = f.b(jSONArray.getJSONObject(this.f3640t0));
            this.f3628g0 = fVarB.f9541v;
            this.f3629h0 = fVarB.f9542w;
            this.f3630i0 = fVarB.f9543x;
            this.f3631j0 = fVarB.f9544y;
            this.f3641u0 = fVarB.f9545z;
            this.l0 = fVarB.A;
            if (jSONArray.length() > 1) {
                F(jSONArray);
            } else {
                this.Z = null;
            }
        } catch (ArrayIndexOutOfBoundsException e10) {
            e = e10;
            Throwable th = e;
            Log.e("Pro", "JSONException", th);
            Toast.makeText(this, th.toString(), 1).show();
            this.f3628g0 = "https://pro.com";
            this.f3629h0 = null;
            this.f3630i0 = null;
            this.f3631j0 = null;
            this.f3641u0 = 0;
        } catch (JSONException e11) {
            e = e11;
            Throwable th2 = e;
            Log.e("Pro", "JSONException", th2);
            Toast.makeText(this, th2.toString(), 1).show();
            this.f3628g0 = "https://pro.com";
            this.f3629h0 = null;
            this.f3630i0 = null;
            this.f3631j0 = null;
            this.f3641u0 = 0;
        }
        A(this.f3628g0, this.f3629h0, this.f3630i0, this.f3631j0, null);
    }

    public final void F(JSONArray jSONArray) {
        this.f3623b0 = new l(this, 2);
        ArrayList arrayListA = f.a(jSONArray);
        this.f3622a0 = arrayListA;
        p pVar = new p(this, arrayListA, this.f3623b0);
        this.Z = pVar;
        pVar.f6539g = this.f3640t0;
        this.Y.setAdapter(pVar);
        this.Y.setLayoutManager(new LinearLayoutManager(0));
        this.Y.setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new n(this, 1), 100L);
    }

    public final void G() {
        if (!this.f3637q0) {
            setRequestedOrientation(6);
            uc.b.k(this);
            this.f3626e0.setResizeMode(3);
            this.X.f7646l.setImageResource(i4.f0.exo_ic_fullscreen_exit);
            if (this.f3645y0) {
                this.W.f7617j.setVisibility(8);
                this.W.f7611b.setVisibility(8);
            }
            D();
            H(this.X.i);
            this.f3637q0 = true;
            return;
        }
        setRequestedOrientation(1);
        uc.b.t(this);
        this.f3626e0.setResizeMode(0);
        this.X.f7646l.setImageResource(i4.f0.exo_ic_fullscreen_enter);
        if (this.f3645y0) {
            this.W.f7617j.setVisibility(0);
            this.W.f7611b.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.W.f.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f3642v0;
        this.W.f.setLayoutParams(layoutParams);
        H(this.W.f7612c);
        this.f3637q0 = false;
    }

    public final void H(FrameLayout frameLayout) {
        ViewGroup viewGroup = (ViewGroup) this.Y.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.Y);
        }
        frameLayout.addView(this.Y);
        if (this.Z != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new n(this, 2), 100L);
        }
    }

    @Override // h.j, e0.e, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        PlayerView playerView;
        if (this.K0 != null && (playerView = this.f3626e0) != null && !playerView.c()) {
            this.K0.post(new n(this, 5));
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // h.j, c.l, e0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewK;
        o.a(this);
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(k.activity_player, (ViewGroup) null, false);
        int i = gc.j.bottom_space;
        View viewK2 = z7.a.k(viewInflate, i);
        if (viewK2 != null) {
            i = gc.j.fragment_container;
            if (((FragmentContainerView) z7.a.k(viewInflate, i)) != null) {
                i = gc.j.links_lay;
                FrameLayout frameLayout = (FrameLayout) z7.a.k(viewInflate, i);
                if (frameLayout != null) {
                    i = gc.j.message_card;
                    MaterialCardView materialCardView = (MaterialCardView) z7.a.k(viewInflate, i);
                    if (materialCardView != null) {
                        i = gc.j.message_txt;
                        TextView textView = (TextView) z7.a.k(viewInflate, i);
                        if (textView != null) {
                            i = gc.j.playerLayout;
                            RelativeLayout relativeLayout = (RelativeLayout) z7.a.k(viewInflate, i);
                            if (relativeLayout != null) {
                                i = gc.j.player_view;
                                PlayerView playerView = (PlayerView) z7.a.k(viewInflate, i);
                                if (playerView != null) {
                                    i = gc.j.progress;
                                    ProgressBar progressBar = (ProgressBar) z7.a.k(viewInflate, i);
                                    if (progressBar != null && (viewK = z7.a.k(viewInflate, (i = gc.j.swipe_binding))) != null) {
                                        b bVarJ = b.j(viewK);
                                        i = gc.j.top_space;
                                        View viewK3 = z7.a.k(viewInflate, i);
                                        if (viewK3 != null) {
                                            i = gc.j.update_fragment_container;
                                            FragmentContainerView fragmentContainerView = (FragmentContainerView) z7.a.k(viewInflate, i);
                                            if (fragmentContainerView != null) {
                                                this.W = new kc.a((LinearLayout) viewInflate, viewK2, frameLayout, materialCardView, textView, relativeLayout, playerView, progressBar, bVarJ, viewK3, fragmentContainerView);
                                                int i10 = Build.VERSION.SDK_INT;
                                                if (i10 >= 35) {
                                                    this.f3645y0 = true;
                                                    viewK3.setVisibility(0);
                                                    this.W.f7617j.setOnApplyWindowInsetsListener(new hc.f(2));
                                                    this.W.f7611b.setVisibility(0);
                                                    this.W.f7611b.setOnApplyWindowInsetsListener(new hc.f(3));
                                                }
                                                setContentView(this.W.f7610a);
                                                PlayerView playerView2 = this.W.f7615g;
                                                this.f3626e0 = playerView2;
                                                View viewFindViewById = playerView2.findViewById(gc.j.player_controls);
                                                int i11 = gc.j.bottom_controller;
                                                LinearLayout linearLayout = (LinearLayout) z7.a.k(viewFindViewById, i11);
                                                if (linearLayout != null) {
                                                    i11 = gc.j.btn_back;
                                                    ImageButton imageButton = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                    if (imageButton != null) {
                                                        i11 = gc.j.btn_lock_unlock;
                                                        ImageButton imageButton2 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                        if (imageButton2 != null) {
                                                            i11 = gc.j.btn_mute;
                                                            ImageButton imageButton3 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                            if (imageButton3 != null) {
                                                                i11 = gc.j.btn_next;
                                                                ImageButton imageButton4 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                if (imageButton4 != null) {
                                                                    i11 = gc.j.btn_pip;
                                                                    ImageButton imageButton5 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                    if (imageButton5 != null) {
                                                                        i11 = gc.j.btn_prev;
                                                                        ImageButton imageButton6 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                        if (imageButton6 != null) {
                                                                            i11 = gc.j.btn_settings;
                                                                            ImageButton imageButton7 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                            if (imageButton7 != null) {
                                                                                i11 = gc.j.controller_links_lay;
                                                                                FrameLayout frameLayout2 = (FrameLayout) z7.a.k(viewFindViewById, i11);
                                                                                if (frameLayout2 != null) {
                                                                                    i11 = h0.exo_duration;
                                                                                    if (((TextView) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                        i11 = h0.exo_ffwd;
                                                                                        if (((ImageButton) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                            i11 = gc.j.exo_pause;
                                                                                            ImageButton imageButton8 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                                            if (imageButton8 != null) {
                                                                                                i11 = gc.j.exo_play;
                                                                                                ImageButton imageButton9 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                                                if (imageButton9 != null) {
                                                                                                    i11 = h0.exo_position;
                                                                                                    if (((TextView) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                                        i11 = h0.exo_progress;
                                                                                                        if (((DefaultTimeBar) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                                            i11 = h0.exo_rew;
                                                                                                            if (((ImageButton) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                                                i11 = gc.j.fullscreen;
                                                                                                                ImageButton imageButton10 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                                                                if (imageButton10 != null) {
                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
                                                                                                                    i11 = gc.j.resize_mode;
                                                                                                                    ImageButton imageButton11 = (ImageButton) z7.a.k(viewFindViewById, i11);
                                                                                                                    if (imageButton11 != null) {
                                                                                                                        i11 = gc.j.timer_bar_ly;
                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) z7.a.k(viewFindViewById, i11);
                                                                                                                        if (linearLayout2 != null) {
                                                                                                                            i11 = gc.j.title;
                                                                                                                            TextView textView2 = (TextView) z7.a.k(viewFindViewById, i11);
                                                                                                                            if (textView2 != null) {
                                                                                                                                i11 = gc.j.top_btns_lay;
                                                                                                                                if (((LinearLayout) z7.a.k(viewFindViewById, i11)) != null) {
                                                                                                                                    this.X = new d(constraintLayout, linearLayout, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, frameLayout2, imageButton8, imageButton9, imageButton10, imageButton11, linearLayout2, textView2);
                                                                                                                                    constraintLayout.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: hc.o
                                                                                                                                        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
                                                                                                                                        public final void onGlobalFocusChanged(View view, View view2) {
                                                                                                                                            PlayerActivity playerActivity = this.f6053u;
                                                                                                                                            if (playerActivity.W.f7615g.c()) {
                                                                                                                                                playerActivity.K0 = view2;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i12 = 2;
                                                                                                                                    this.X.f7638b.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i13 = i12;
                                                                                                                                            int i14 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i13) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i15 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i16 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i17 = playerActivity.V.H;
                                                                                                                                                        int size = i17 <= 0 ? playerActivity.J0.size() - 1 : i17 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i18 = playerActivity.V.H;
                                                                                                                                                        int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i14));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i13 = 3;
                                                                                                                                    this.X.f7642g.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i13;
                                                                                                                                            int i14 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i15 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i16 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i17 = playerActivity.V.H;
                                                                                                                                                        int size = i17 <= 0 ? playerActivity.J0.size() - 1 : i17 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i18 = playerActivity.V.H;
                                                                                                                                                        int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i14));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i14 = 4;
                                                                                                                                    this.X.f7641e.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i14;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i15 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i16 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i17 = playerActivity.V.H;
                                                                                                                                                        int size = i17 <= 0 ? playerActivity.J0.size() - 1 : i17 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i18 = playerActivity.V.H;
                                                                                                                                                        int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    if (i10 < 26 || !getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                                                                                                                                        this.X.f.setVisibility(8);
                                                                                                                                    } else {
                                                                                                                                        final int i15 = 5;
                                                                                                                                        this.X.f.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                            public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                            {
                                                                                                                                                this.f6055v = this;
                                                                                                                                            }

                                                                                                                                            @Override // android.view.View.OnClickListener
                                                                                                                                            public final void onClick(View view) {
                                                                                                                                                int i132 = i15;
                                                                                                                                                int i142 = 1;
                                                                                                                                                PlayerActivity playerActivity = this.f6055v;
                                                                                                                                                switch (i132) {
                                                                                                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                        if (!playerActivity.f3634n0) {
                                                                                                                                                            o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                            o0Var.S1();
                                                                                                                                                            playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                            playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                            playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                            playerActivity.f3634n0 = true;
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                            playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                            playerActivity.f3634n0 = false;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 1:
                                                                                                                                                        int i152 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.G();
                                                                                                                                                        break;
                                                                                                                                                    case 2:
                                                                                                                                                        int i16 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.w();
                                                                                                                                                        break;
                                                                                                                                                    case 3:
                                                                                                                                                        ArrayList arrayList = playerActivity.J0;
                                                                                                                                                        if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                            int i17 = playerActivity.V.H;
                                                                                                                                                            int size = i17 <= 0 ? playerActivity.J0.size() - 1 : i17 - 1;
                                                                                                                                                            playerActivity.V.H = size;
                                                                                                                                                            oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                            playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                            playerActivity.f3640t0 = 0;
                                                                                                                                                            boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                            String str = cVar.f9517c;
                                                                                                                                                            playerActivity.V.C = str;
                                                                                                                                                            playerActivity.E(str, zEquals);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                        ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                            int i18 = playerActivity.V.H;
                                                                                                                                                            int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                            playerActivity.V.H = i19;
                                                                                                                                                            oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                            playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                            playerActivity.f3640t0 = 0;
                                                                                                                                                            boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                            String str2 = cVar2.f9517c;
                                                                                                                                                            playerActivity.V.C = str2;
                                                                                                                                                            playerActivity.E(str2, zEquals2);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                        int i20 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.x();
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                        PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                        o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                        if (o0Var2 != null) {
                                                                                                                                                            playerActivity2.f3635o0 = false;
                                                                                                                                                            if (!playerActivity2.f3633m0) {
                                                                                                                                                                o0Var2.X();
                                                                                                                                                                playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                                playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                                playerActivity2.f3633m0 = false;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                        if (playerActivity.f3624c0 != null) {
                                                                                                                                                            Log.e("Pro Pro", "pause button");
                                                                                                                                                            playerActivity.f3624c0.f();
                                                                                                                                                            playerActivity.f3635o0 = true;
                                                                                                                                                            playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 8:
                                                                                                                                                        if (!playerActivity.f3636p0) {
                                                                                                                                                            playerActivity.D0.J = true;
                                                                                                                                                            playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                            playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            playerActivity.f3636p0 = true;
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity.D0.J = false;
                                                                                                                                                            playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                            playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            playerActivity.f3636p0 = false;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 9:
                                                                                                                                                        int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                        if (resizeMode == 0) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                            break;
                                                                                                                                                        } else if (resizeMode == 3) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                            break;
                                                                                                                                                        } else if (resizeMode == 4) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 10:
                                                                                                                                                        o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                        if (o0Var3 != null) {
                                                                                                                                                            lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                            playerActivity.f3627f0 = nVarT;
                                                                                                                                                            nVarT.R(playerActivity.o(), null);
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    default:
                                                                                                                                                        int i21 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.getClass();
                                                                                                                                                        try {
                                                                                                                                                            Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                            intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                            playerActivity.startActivity(intent);
                                                                                                                                                        } catch (ActivityNotFoundException e10) {
                                                                                                                                                            Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                    final int i16 = 6;
                                                                                                                                    this.X.f7645k.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i16;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i17 = playerActivity.V.H;
                                                                                                                                                        int size = i17 <= 0 ? playerActivity.J0.size() - 1 : i17 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i18 = playerActivity.V.H;
                                                                                                                                                        int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i17 = 7;
                                                                                                                                    this.X.f7644j.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i17;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i18 = playerActivity.V.H;
                                                                                                                                                        int i19 = i18 >= playerActivity.J0.size() - 1 ? 0 : i18 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i18 = 8;
                                                                                                                                    this.X.f7639c.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i18;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i182 = playerActivity.V.H;
                                                                                                                                                        int i19 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                        playerActivity.V.H = i19;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i19);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i19 = 9;
                                                                                                                                    this.X.f7647m.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i19;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i182 = playerActivity.V.H;
                                                                                                                                                        int i192 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                        playerActivity.V.H = i192;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i192);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i20 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i20 = 10;
                                                                                                                                    this.X.f7643h.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i20;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i182 = playerActivity.V.H;
                                                                                                                                                        int i192 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                        playerActivity.V.H = i192;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i192);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i202 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i21 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i21 = 0;
                                                                                                                                    this.X.f7640d.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i21;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i182 = playerActivity.V.H;
                                                                                                                                                        int i192 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                        playerActivity.V.H = i192;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i192);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i202 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i212 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    final int i22 = 1;
                                                                                                                                    this.X.f7646l.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                        public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                        {
                                                                                                                                            this.f6055v = this;
                                                                                                                                        }

                                                                                                                                        @Override // android.view.View.OnClickListener
                                                                                                                                        public final void onClick(View view) {
                                                                                                                                            int i132 = i22;
                                                                                                                                            int i142 = 1;
                                                                                                                                            PlayerActivity playerActivity = this.f6055v;
                                                                                                                                            switch (i132) {
                                                                                                                                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                    if (!playerActivity.f3634n0) {
                                                                                                                                                        o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                        o0Var.S1();
                                                                                                                                                        playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                        playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                        playerActivity.f3634n0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                        playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                        playerActivity.f3634n0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 1:
                                                                                                                                                    int i152 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.G();
                                                                                                                                                    break;
                                                                                                                                                case 2:
                                                                                                                                                    int i162 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.w();
                                                                                                                                                    break;
                                                                                                                                                case 3:
                                                                                                                                                    ArrayList arrayList = playerActivity.J0;
                                                                                                                                                    if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                        int i172 = playerActivity.V.H;
                                                                                                                                                        int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                        playerActivity.V.H = size;
                                                                                                                                                        oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                        playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                        String str = cVar.f9517c;
                                                                                                                                                        playerActivity.V.C = str;
                                                                                                                                                        playerActivity.E(str, zEquals);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                    ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                        int i182 = playerActivity.V.H;
                                                                                                                                                        int i192 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                        playerActivity.V.H = i192;
                                                                                                                                                        oc.c cVar2 = (oc.c) playerActivity.J0.get(i192);
                                                                                                                                                        playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                        playerActivity.f3640t0 = 0;
                                                                                                                                                        boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                        String str2 = cVar2.f9517c;
                                                                                                                                                        playerActivity.V.C = str2;
                                                                                                                                                        playerActivity.E(str2, zEquals2);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                    int i202 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.x();
                                                                                                                                                    break;
                                                                                                                                                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                    PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                    o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                    if (o0Var2 != null) {
                                                                                                                                                        playerActivity2.f3635o0 = false;
                                                                                                                                                        if (!playerActivity2.f3633m0) {
                                                                                                                                                            o0Var2.X();
                                                                                                                                                            playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                            playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                            playerActivity2.f3633m0 = false;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                    if (playerActivity.f3624c0 != null) {
                                                                                                                                                        Log.e("Pro Pro", "pause button");
                                                                                                                                                        playerActivity.f3624c0.f();
                                                                                                                                                        playerActivity.f3635o0 = true;
                                                                                                                                                        playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 8:
                                                                                                                                                    if (!playerActivity.f3636p0) {
                                                                                                                                                        playerActivity.D0.J = true;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                        RecyclerView recyclerView = playerActivity.Y;
                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                            recyclerView.setVisibility(8);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = true;
                                                                                                                                                    } else {
                                                                                                                                                        playerActivity.D0.J = false;
                                                                                                                                                        playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                        playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                        playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                        RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                                            recyclerView2.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        playerActivity.f3636p0 = false;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 9:
                                                                                                                                                    int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                    if (resizeMode == 0) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 3) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                        break;
                                                                                                                                                    } else if (resizeMode == 4) {
                                                                                                                                                        playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                        playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                        break;
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 10:
                                                                                                                                                    o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                    if (o0Var3 != null) {
                                                                                                                                                        lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                        playerActivity.f3627f0 = nVarT;
                                                                                                                                                        nVarT.R(playerActivity.o(), null);
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                default:
                                                                                                                                                    int i212 = PlayerActivity.M0;
                                                                                                                                                    playerActivity.getClass();
                                                                                                                                                    try {
                                                                                                                                                        Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                        intent.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                        playerActivity.startActivity(intent);
                                                                                                                                                    } catch (ActivityNotFoundException e10) {
                                                                                                                                                        Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    });
                                                                                                                                    this.D0 = new g(this, this.W.i, this.f3626e0, this.f3624c0);
                                                                                                                                    j().a(this.L0, this);
                                                                                                                                    this.V = ProApplication.I;
                                                                                                                                    RecyclerView recyclerView = new RecyclerView(this, null);
                                                                                                                                    this.Y = recyclerView;
                                                                                                                                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                                                                                                                                    this.W.f7612c.addView(this.Y);
                                                                                                                                    Intent intent = getIntent();
                                                                                                                                    this.B0 = intent.getBooleanExtra("fromSplash", true);
                                                                                                                                    y(intent);
                                                                                                                                    String str = this.V.D;
                                                                                                                                    if (str != null) {
                                                                                                                                        this.W.f7614e.setText(str);
                                                                                                                                        this.W.f7614e.setSelected(true);
                                                                                                                                        final int i23 = 11;
                                                                                                                                        this.W.f7613d.setOnClickListener(new View.OnClickListener(this) { // from class: hc.p

                                                                                                                                            /* JADX INFO: renamed from: v, reason: collision with root package name */
                                                                                                                                            public final /* synthetic */ PlayerActivity f6055v;

                                                                                                                                            {
                                                                                                                                                this.f6055v = this;
                                                                                                                                            }

                                                                                                                                            @Override // android.view.View.OnClickListener
                                                                                                                                            public final void onClick(View view) {
                                                                                                                                                int i132 = i23;
                                                                                                                                                int i142 = 1;
                                                                                                                                                PlayerActivity playerActivity = this.f6055v;
                                                                                                                                                switch (i132) {
                                                                                                                                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                        if (!playerActivity.f3634n0) {
                                                                                                                                                            o0 o0Var = playerActivity.f3624c0;
                                                                                                                                                            o0Var.S1();
                                                                                                                                                            playerActivity.f3639s0 = o0Var.f360t0;
                                                                                                                                                            playerActivity.f3624c0.O0(0.0f);
                                                                                                                                                            playerActivity.X.f7640d.setImageResource(gc.i.volume_off_24px);
                                                                                                                                                            playerActivity.f3634n0 = true;
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity.f3624c0.O0(playerActivity.f3639s0);
                                                                                                                                                            playerActivity.X.f7640d.setImageResource(gc.i.volume_up_24px);
                                                                                                                                                            playerActivity.f3634n0 = false;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 1:
                                                                                                                                                        int i152 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.G();
                                                                                                                                                        break;
                                                                                                                                                    case 2:
                                                                                                                                                        int i162 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.w();
                                                                                                                                                        break;
                                                                                                                                                    case 3:
                                                                                                                                                        ArrayList arrayList = playerActivity.J0;
                                                                                                                                                        if (arrayList != null && !arrayList.isEmpty()) {
                                                                                                                                                            int i172 = playerActivity.V.H;
                                                                                                                                                            int size = i172 <= 0 ? playerActivity.J0.size() - 1 : i172 - 1;
                                                                                                                                                            playerActivity.V.H = size;
                                                                                                                                                            oc.c cVar = (oc.c) playerActivity.J0.get(size);
                                                                                                                                                            playerActivity.f3632k0 = cVar.f9515a;
                                                                                                                                                            playerActivity.f3640t0 = 0;
                                                                                                                                                            boolean zEquals = cVar.f9518d.equals("custom");
                                                                                                                                                            String str2 = cVar.f9517c;
                                                                                                                                                            playerActivity.V.C = str2;
                                                                                                                                                            playerActivity.E(str2, zEquals);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                        ArrayList arrayList2 = playerActivity.J0;
                                                                                                                                                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                                                                                                                            int i182 = playerActivity.V.H;
                                                                                                                                                            int i192 = i182 >= playerActivity.J0.size() - 1 ? 0 : i182 + 1;
                                                                                                                                                            playerActivity.V.H = i192;
                                                                                                                                                            oc.c cVar2 = (oc.c) playerActivity.J0.get(i192);
                                                                                                                                                            playerActivity.f3632k0 = cVar2.f9515a;
                                                                                                                                                            playerActivity.f3640t0 = 0;
                                                                                                                                                            boolean zEquals2 = cVar2.f9518d.equals("custom");
                                                                                                                                                            String str22 = cVar2.f9517c;
                                                                                                                                                            playerActivity.V.C = str22;
                                                                                                                                                            playerActivity.E(str22, zEquals2);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                        int i202 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.x();
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                        PlayerActivity playerActivity2 = this.f6055v;
                                                                                                                                                        o0 o0Var2 = playerActivity2.f3624c0;
                                                                                                                                                        if (o0Var2 != null) {
                                                                                                                                                            playerActivity2.f3635o0 = false;
                                                                                                                                                            if (!playerActivity2.f3633m0) {
                                                                                                                                                                o0Var2.X();
                                                                                                                                                                playerActivity2.X.f7645k.setVisibility(8);
                                                                                                                                                                playerActivity2.X.f7644j.setVisibility(0);
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity2.A(playerActivity2.f3628g0, playerActivity2.f3629h0, playerActivity2.f3630i0, playerActivity2.f3631j0, null);
                                                                                                                                                                playerActivity2.f3633m0 = false;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                        if (playerActivity.f3624c0 != null) {
                                                                                                                                                            Log.e("Pro Pro", "pause button");
                                                                                                                                                            playerActivity.f3624c0.f();
                                                                                                                                                            playerActivity.f3635o0 = true;
                                                                                                                                                            playerActivity.X.f7644j.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7645k.setVisibility(0);
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 8:
                                                                                                                                                        if (!playerActivity.f3636p0) {
                                                                                                                                                            playerActivity.D0.J = true;
                                                                                                                                                            playerActivity.X.f7639c.setImageResource(gc.i.ic_lock);
                                                                                                                                                            playerActivity.X.f7637a.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7648n.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7638b.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7640d.setVisibility(8);
                                                                                                                                                            playerActivity.X.f7649o.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Y;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            playerActivity.f3636p0 = true;
                                                                                                                                                        } else {
                                                                                                                                                            playerActivity.D0.J = false;
                                                                                                                                                            playerActivity.X.f7639c.setImageResource(gc.i.ic_unlock);
                                                                                                                                                            playerActivity.X.f7637a.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7648n.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7638b.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7640d.setVisibility(0);
                                                                                                                                                            playerActivity.X.f7649o.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView22 = playerActivity.Y;
                                                                                                                                                            if (recyclerView22 != null) {
                                                                                                                                                                recyclerView22.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            playerActivity.f3636p0 = false;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 9:
                                                                                                                                                        int resizeMode = playerActivity.f3626e0.getResizeMode();
                                                                                                                                                        if (resizeMode == 0) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(3);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_crop);
                                                                                                                                                            break;
                                                                                                                                                        } else if (resizeMode == 3) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(4);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_fit);
                                                                                                                                                            break;
                                                                                                                                                        } else if (resizeMode == 4) {
                                                                                                                                                            playerActivity.f3626e0.setResizeMode(0);
                                                                                                                                                            playerActivity.X.f7647m.setImageResource(gc.i.mode_fill);
                                                                                                                                                            break;
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    case 10:
                                                                                                                                                        o0 o0Var3 = playerActivity.f3624c0;
                                                                                                                                                        if (o0Var3 != null) {
                                                                                                                                                            lc.n nVarT = lc.n.T(o0Var3, new c(playerActivity, i142));
                                                                                                                                                            playerActivity.f3627f0 = nVarT;
                                                                                                                                                            nVarT.R(playerActivity.o(), null);
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                    default:
                                                                                                                                                        int i212 = PlayerActivity.M0;
                                                                                                                                                        playerActivity.getClass();
                                                                                                                                                        try {
                                                                                                                                                            Intent intent2 = new Intent("android.intent.action.VIEW");
                                                                                                                                                            intent2.setData(Uri.parse(playerActivity.V.E));
                                                                                                                                                            playerActivity.startActivity(intent2);
                                                                                                                                                        } catch (ActivityNotFoundException e10) {
                                                                                                                                                            Toast.makeText(playerActivity, e10.getMessage(), 0).show();
                                                                                                                                                        }
                                                                                                                                                        break;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                    this.f3642v0 = this.W.f.getLayoutParams().height;
                                                                                                                                    if (getResources().getConfiguration().orientation != 2) {
                                                                                                                                        uc.b.t(this);
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                    G();
                                                                                                                                    this.f3638r0 = true;
                                                                                                                                    this.X.f7646l.setClickable(false);
                                                                                                                                    this.X.f7646l.setFocusable(false);
                                                                                                                                    this.X.f7646l.setEnabled(false);
                                                                                                                                    this.X.f7646l.setAlpha(0.5f);
                                                                                                                                    H(this.X.i);
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
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i11)));
                                            }
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
    public final void onDestroy() {
        o0 o0Var = this.f3624c0;
        if (o0Var != null) {
            o0Var.F1();
        }
        u uVar = this.f3625d0;
        if (uVar != null) {
            uVar.a();
        }
        this.W = null;
        super.onDestroy();
    }

    @Override // c.l, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        y(intent);
    }

    @Override // h.j, android.app.Activity
    public final void onPause() {
        o0 o0Var;
        if (!(Build.VERSION.SDK_INT >= 24 ? isInPictureInPictureMode() : false) && (o0Var = this.f3624c0) != null && !this.f3635o0) {
            o0Var.f();
        }
        this.V.F = null;
        super.onPause();
    }

    @Override // c.l, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        super.onPictureInPictureModeChanged(z2, configuration);
        if (z2) {
            lc.n nVar = this.f3627f0;
            if (nVar != null) {
                nVar.P(false, false);
            }
            this.f3626e0.b();
            this.f3626e0.setControllerAutoShow(false);
            if (this.f3637q0) {
                return;
            }
            D();
            return;
        }
        if (!this.f3637q0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.W.f.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.f3642v0;
            this.W.f.setLayoutParams(layoutParams);
        }
        o0 o0Var = this.f3624c0;
        if (o0Var != null) {
            o0Var.f();
        }
        this.f3626e0.setControllerAutoShow(true);
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        this.A0 = false;
        o0 o0Var = this.f3624c0;
        if (o0Var != null && !this.f3633m0 && !this.f3635o0) {
            o0Var.X();
        }
        qc.b.a(this);
        super.onResume();
    }

    @Override // c.l, android.app.Activity
    public final void onUserLeaveHint() {
        if (this.f3646z0 && !this.A0) {
            x();
        }
        super.onUserLeaveHint();
    }

    public final void w() {
        if (this.X.f7646l.getVisibility() == 0 && this.f3637q0 && !this.f3638r0) {
            G();
            return;
        }
        o0 o0Var = this.f3624c0;
        if (o0Var != null) {
            o0Var.F1();
        }
        if (this.B0) {
            finish();
            return;
        }
        uc.b.f(this).edit().putBoolean("is_tv", false).apply();
        if (this.G0 == null) {
            startActivity(new Intent(this, (Class<?>) SplashActivity.class));
            finish();
            return;
        }
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            int longVersionCode = Build.VERSION.SDK_INT >= 29 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
            if (this.G0.I != longVersionCode) {
                this.W.f.setVisibility(8);
                this.W.f7618k.setVisibility(0);
                c cVar = (c) new a7.b(this).s(c.class);
                cVar.i = longVersionCode;
                cVar.f13492g = this.H0;
                cVar.f13491e = this.G0.f9508x;
                cVar.f13490d = new l(this, 1);
                x xVar = new x();
                xVar.R(o(), xVar.S);
                return;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("appDetail", this.G0);
        startActivity(intent);
        finish();
    }

    public final void x() {
        if (this.f3624c0 == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            if (getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                d8.d.q();
                PictureInPictureParams.Builder builderD = d8.d.d();
                builderD.setAspectRatio(new Rational(16, 9));
                Rect rect = new Rect();
                this.W.f.getGlobalVisibleRect(rect);
                builderD.setSourceRectHint(rect);
                enterPictureInPictureMode(builderD.build());
            }
        } catch (Exception unused) {
        }
    }

    public final void y(Intent intent) {
        int i = 3;
        int i10 = 0;
        if (intent.hasExtra("links_model")) {
            f fVar = Build.VERSION.SDK_INT > 33 ? (f) intent.getParcelableExtra("links_model", f.class) : (f) intent.getParcelableExtra("links_model");
            D();
            this.f3642v0 = this.W.f.getLayoutParams().height;
            this.W.f7615g.setResizeMode(0);
            if (fVar != null) {
                this.f3628g0 = fVar.f9541v;
                this.f3629h0 = fVar.f9542w;
                this.f3641u0 = fVar.f9545z;
                this.f3631j0 = fVar.f9544y;
                this.l0 = fVar.A;
            } else {
                this.f3628g0 = "https://pro.com";
            }
            this.f3632k0 = "";
            A(this.f3628g0, this.f3629h0, this.f3630i0, this.f3631j0, null);
        } else if (intent.getData() != null) {
            uc.b.t(this);
            this.X.f7646l.setVisibility(0);
            G();
            String string = intent.getData().toString();
            ga.b.q(this, uc.b.f(this).getString("api_host", "https://error_pro.com") + "app.txt", null, new l(this, i), false);
            String lowerCase = string.toLowerCase();
            StringBuilder sb2 = new StringBuilder(string);
            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                String[] strArrSplit = string.split("\\|");
                ArrayList arrayListH = uc.b.h(strArrSplit[1], "drmlicense");
                StringBuilder sb3 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListH.get(0)));
                if (!TextUtils.isEmpty((CharSequence) arrayListH.get(1))) {
                    this.f3629h0 = (String) arrayListH.get(1);
                }
                sb2 = sb3;
            }
            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                String[] strArrSplit2 = sb2.toString().split("\\|");
                ArrayList arrayListH2 = uc.b.h(strArrSplit2[1], "drmscheme");
                sb2 = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListH2.get(0)));
                if (!TextUtils.isEmpty((CharSequence) arrayListH2.get(1))) {
                    String lowerCase2 = ((String) arrayListH2.get(1)).toLowerCase();
                    lowerCase2.getClass();
                    this.f3641u0 = !lowerCase2.equals("widevine") ? !lowerCase2.equals("clearkey") ? 2 : 0 : 1;
                }
            }
            String string2 = sb2.toString();
            if (string2.indexOf("|") + 1 >= string2.length()) {
                sb2 = new StringBuilder(string2.split("\\|")[0]);
            }
            this.B0 = false;
            String string3 = sb2.toString();
            this.f3628g0 = string3;
            this.f3630i0 = null;
            this.f3631j0 = null;
            this.l0 = true;
            A(string3, this.f3629h0, null, null, null);
        } else {
            this.f3632k0 = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
            boolean booleanExtra = intent.getBooleanExtra("isEncoded", true);
            String stringExtra = intent.getStringExtra("links");
            this.f3640t0 = intent.getIntExtra("position", 0);
            if (!this.B0) {
                uc.b.g(this).putInt("player_called", -1).apply();
            }
            this.V.C = stringExtra;
            E(stringExtra, booleanExtra);
        }
        this.Y.setVisibility(8);
        this.X.f7641e.setVisibility(8);
        this.X.f7642g.setVisibility(8);
        List list = this.V.A;
        if (list != null) {
            this.J0 = new ArrayList(list);
            if (getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false)) {
                this.X.f7641e.setVisibility(0);
                this.X.f7642g.setVisibility(0);
            }
        }
        if (!this.f3638r0) {
            q qVar = this.I0;
            if (qVar == null) {
                this.I0 = new q();
                n0 n0VarO = o();
                androidx.fragment.app.a aVarI = e6.j.i(n0VarO, n0VarO);
                aVarI.e(gc.j.fragment_container, this.I0, null, 1);
                aVarI.d(false);
            } else {
                qVar.Q();
            }
        }
        if (getSharedPreferences("DataPreferences", 0).getBoolean("is_tv", false) ? getSharedPreferences("DataPreferences", 0).getBoolean("tv_external_ad_enabled", false) : getSharedPreferences("DataPreferences", 0).getBoolean("external_ad_enabled", false)) {
            int i11 = getSharedPreferences("DataPreferences", 0).getInt("external_ad_repeat_after", 3);
            int i12 = getSharedPreferences("DataPreferences", 0).getInt("player_called", 0);
            if (i12 >= i11) {
                i12 = 0;
            }
            if (i12 == 0) {
                String string4 = uc.b.f(this).getString("external_ad_url", "");
                if (!TextUtils.isEmpty(string4)) {
                    try {
                        try {
                            this.A0 = true;
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(string4));
                            intent2.setPackage("com.android.chrome");
                            startActivity(intent2);
                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                            this.A0 = false;
                        }
                    } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused2) {
                        this.A0 = true;
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string4)));
                    }
                }
            }
            uc.b.g(this).putInt("player_called", i12 + 1).apply();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new n(this, i10), 500L);
    }

    public final g0 z(String str, String str2, String str3) {
        c0 c0Var;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            o0 o0VarA = new a2.u(this).a();
            this.f3624c0 = o0VarA;
            this.f3626e0.setPlayer(o0VarA);
            com.bumptech.glide.d.m(this, str3, this.f3644x0);
            return null;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(str2)) {
            int i = this.f3641u0;
            UUID uuid = i != 0 ? i != 1 ? p1.g.f9749e : p1.g.f9748d : p1.g.f9747c;
            if (!str2.contains("http")) {
                v vVar = new v();
                vVar.f10066a = str != null ? Uri.parse(str) : null;
                vVar.b(new a0(new z(uuid)));
                return vVar.a();
            }
            v vVar2 = new v();
            vVar2.f10066a = str != null ? Uri.parse(str) : null;
            z zVar = new z(uuid);
            zVar.f10114b = Uri.parse(str2);
            zVar.f10113a = uuid;
            vVar2.b(new a0(zVar));
            return vVar2.a();
        }
        w wVar = new w();
        z zVar2 = new z();
        List list = Collections.EMPTY_LIST;
        c1 c1Var = c1.f650y;
        t tVar = new t();
        d0 d0Var = d0.f9694d;
        Uri uri = str == null ? null : Uri.parse(str);
        String strE = uc.b.e(str);
        if (zVar2.f10114b != null && zVar2.f10113a == null) {
            z2 = false;
        }
        s1.d.g(z2);
        if (uri != null) {
            c0Var = new c0(uri, strE, zVar2.f10113a != null ? new a0(zVar2) : null, null, list, null, c1Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        return new g0("", new y(wVar), c0Var, new b0(tVar), j0.K, d0Var);
    }
}
