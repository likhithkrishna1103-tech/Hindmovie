package app.cricfy.tv.activities;

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
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.emoji2.text.v;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.i0;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.activities.PlayerActivity;
import app.cricfy.tv.app.ProApplication;
import c.p;
import com.google.android.gms.internal.measurement.j4;
import g2.g0;
import h.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k2.t;
import k4.u;
import kf.i;
import l0.e;
import m4.d0;
import org.json.JSONArray;
import org.json.JSONException;
import q5.g;
import r5.d;
import r5.k;
import r5.l;
import s5.n;
import u5.c;
import ua.z0;
import v1.a0;
import v1.c0;
import v1.f;
import v1.j0;
import v1.x;
import v1.y;
import v1.z;
import v5.s;
import x5.m;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class PlayerActivity extends j {
    public static final /* synthetic */ int I0 = 0;
    public g B0;
    public Handler C0;
    public k D0;
    public a E0;
    public String F0;
    public m G0;
    public ProApplication W;
    public u5.a X;
    public c Y;
    public RecyclerView Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public n f1516a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public ArrayList f1517b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public l f1518c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public g0 f1519d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public u f1520e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public PlayerView f1521f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public s f1522g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public String f1523h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public String f1524i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public String f1525j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f1526k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f1527l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f1528m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f1529n0;
    public boolean o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f1530p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f1531q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f1532r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f1533s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f1534t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f1535u0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f1537w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f1538x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f1539y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f1540z0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final i f1536v0 = new i(14, this);
    public boolean A0 = true;
    public final i0 H0 = new i0(this, 3);

    public static void C(Map map, v vVar) {
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
                String str2 = (String) entry.getValue();
                if ("null".equals(str2)) {
                    str2 = "";
                }
                vVar.f890y = str2;
                map.remove(str);
            }
        }
        vVar.D(map);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:14:0x0030, B:16:0x0040, B:18:0x0046, B:24:0x0066, B:27:0x0070, B:39:0x00fb, B:41:0x0109, B:43:0x011c, B:46:0x0183, B:52:0x0190, B:54:0x019d, B:56:0x01a5, B:58:0x01ae, B:61:0x01b4, B:64:0x01bc, B:66:0x01cf, B:67:0x01d5, B:62:0x01b7, B:63:0x01ba, B:57:0x01aa, B:68:0x0214, B:70:0x021a, B:71:0x023d, B:72:0x0242, B:73:0x0243, B:75:0x0264, B:76:0x0272, B:77:0x0277, B:42:0x0112, B:30:0x00e2, B:32:0x00ea, B:35:0x00f4, B:21:0x004d, B:23:0x0055), top: B:92:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:14:0x0030, B:16:0x0040, B:18:0x0046, B:24:0x0066, B:27:0x0070, B:39:0x00fb, B:41:0x0109, B:43:0x011c, B:46:0x0183, B:52:0x0190, B:54:0x019d, B:56:0x01a5, B:58:0x01ae, B:61:0x01b4, B:64:0x01bc, B:66:0x01cf, B:67:0x01d5, B:62:0x01b7, B:63:0x01ba, B:57:0x01aa, B:68:0x0214, B:70:0x021a, B:71:0x023d, B:72:0x0242, B:73:0x0243, B:75:0x0264, B:76:0x0272, B:77:0x0277, B:42:0x0112, B:30:0x00e2, B:32:0x00ea, B:35:0x00f4, B:21:0x004d, B:23:0x0055), top: B:92:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0190 A[Catch: Exception -> 0x004a, TRY_ENTER, TryCatch #0 {Exception -> 0x004a, blocks: (B:14:0x0030, B:16:0x0040, B:18:0x0046, B:24:0x0066, B:27:0x0070, B:39:0x00fb, B:41:0x0109, B:43:0x011c, B:46:0x0183, B:52:0x0190, B:54:0x019d, B:56:0x01a5, B:58:0x01ae, B:61:0x01b4, B:64:0x01bc, B:66:0x01cf, B:67:0x01d5, B:62:0x01b7, B:63:0x01ba, B:57:0x01aa, B:68:0x0214, B:70:0x021a, B:71:0x023d, B:72:0x0242, B:73:0x0243, B:75:0x0264, B:76:0x0272, B:77:0x0277, B:42:0x0112, B:30:0x00e2, B:32:0x00ea, B:35:0x00f4, B:21:0x004d, B:23:0x0055), top: B:92:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0243 A[Catch: Exception -> 0x004a, TryCatch #0 {Exception -> 0x004a, blocks: (B:14:0x0030, B:16:0x0040, B:18:0x0046, B:24:0x0066, B:27:0x0070, B:39:0x00fb, B:41:0x0109, B:43:0x011c, B:46:0x0183, B:52:0x0190, B:54:0x019d, B:56:0x01a5, B:58:0x01ae, B:61:0x01b4, B:64:0x01bc, B:66:0x01cf, B:67:0x01d5, B:62:0x01b7, B:63:0x01ba, B:57:0x01aa, B:68:0x0214, B:70:0x021a, B:71:0x023d, B:72:0x0242, B:73:0x0243, B:75:0x0264, B:76:0x0272, B:77:0x0277, B:42:0x0112, B:30:0x00e2, B:32:0x00ea, B:35:0x00f4, B:21:0x004d, B:23:0x0055), top: B:92:0x0030 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.util.Map r32) {
        /*
            Method dump skipped, instruction units count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cricfy.tv.activities.PlayerActivity.A(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void B() {
        n nVar = this.f1516a0;
        if (nVar != null) {
            int i = nVar.f11513g + 1;
            if (i == this.f1517b0.size()) {
                i = 0;
            }
            y5.g gVar = (y5.g) this.f1517b0.get(i);
            this.f1518c0.b(gVar.f14939w.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), gVar.f14940x, gVar.f14941y, gVar.f14942z, gVar.A, gVar.B);
            if (this.f1516a0.f11513g != i) {
                this.Z.g0(i);
                new Handler(Looper.getMainLooper()).postDelayed(new d6.i(i, 5, this), 100L);
            }
        }
    }

    public final void D(String str, boolean z10) {
        if (this.X == null) {
            return;
        }
        g0 g0Var = this.f1519d0;
        if (g0Var != null) {
            g0Var.C1();
        }
        u uVar = this.f1520e0;
        if (uVar != null) {
            uVar.a();
        }
        if (z10) {
            b.p(this, b.n(this, str), null, new l(this, 0), false);
            return;
        }
        if (str.contains("[*]")) {
            b.v(str, new l(this, 4));
            return;
        }
        try {
            if (!str.startsWith("[")) {
                str = a6.a.b(str);
            }
            JSONArray jSONArray = new JSONArray(str);
            y5.g gVarB = y5.g.b(jSONArray.getJSONObject(this.f1533s0));
            this.f1523h0 = gVarB.f14939w;
            this.f1524i0 = gVarB.f14940x;
            this.f1525j0 = gVarB.f14941y;
            this.f1526k0 = gVarB.f14942z;
            this.f1534t0 = gVarB.A;
            this.f1527l0 = gVarB.B;
            if (jSONArray.length() > 1) {
                E(jSONArray);
            } else {
                this.f1516a0 = null;
            }
        } catch (ArrayIndexOutOfBoundsException e9) {
            e = e9;
            Throwable th = e;
            Log.e("Pro", "JSONException", th);
            Toast.makeText(this, th.toString(), 1).show();
            this.f1523h0 = "https://pro.com";
            this.f1524i0 = null;
            this.f1525j0 = null;
            this.f1526k0 = null;
            this.f1534t0 = 0;
        } catch (JSONException e10) {
            e = e10;
            Throwable th2 = e;
            Log.e("Pro", "JSONException", th2);
            Toast.makeText(this, th2.toString(), 1).show();
            this.f1523h0 = "https://pro.com";
            this.f1524i0 = null;
            this.f1525j0 = null;
            this.f1526k0 = null;
            this.f1534t0 = 0;
        }
        A(this.f1523h0, this.f1524i0, this.f1525j0, this.f1526k0, null);
    }

    public final void E(JSONArray jSONArray) {
        this.f1518c0 = new l(this, 3);
        ArrayList arrayListA = y5.g.a(jSONArray);
        this.f1517b0 = arrayListA;
        n nVar = new n(this, arrayListA, this.f1518c0);
        this.f1516a0 = nVar;
        nVar.f11513g = this.f1533s0;
        this.Z.setAdapter(nVar);
        this.Z.setLayoutManager(new LinearLayoutManager(0));
        this.Z.setVisibility(0);
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, 1), 100L);
    }

    public final void F() {
        if (this.f1530p0) {
            setRequestedOrientation(1);
            j4.E(this);
            this.f1521f0.setResizeMode(0);
            this.Y.f12235e.setImageResource(d0.exo_ic_fullscreen_enter);
            if (this.f1537w0) {
                ((View) this.X.f12215d).setVisibility(0);
                ((View) this.X.f12214c).setVisibility(0);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((RelativeLayout) this.X.f).getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.f1535u0;
            ((RelativeLayout) this.X.f).setLayoutParams(layoutParams);
            G((FrameLayout) this.X.f12216e);
            this.f1530p0 = false;
            return;
        }
        setRequestedOrientation(6);
        j4.t(this);
        this.f1521f0.setResizeMode(3);
        this.Y.f12235e.setImageResource(d0.exo_ic_fullscreen_exit);
        if (this.f1537w0) {
            ((View) this.X.f12215d).setVisibility(8);
            ((View) this.X.f12214c).setVisibility(8);
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ((RelativeLayout) this.X.f).getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        ((RelativeLayout) this.X.f).setLayoutParams(layoutParams2);
        G(this.Y.f12233c);
        this.f1530p0 = true;
    }

    public final void G(FrameLayout frameLayout) {
        if (this.f1516a0 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.Z.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.Z);
        }
        frameLayout.addView(this.Z);
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, 0), 100L);
    }

    @Override // h.j, c.m, h0.e, android.app.Activity
    public final void onCreate(Bundle bundle) {
        View viewL;
        View viewL2;
        p.a(this);
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(q5.l.activity_player, (ViewGroup) null, false);
        int i = q5.k.bottom_space;
        View viewL3 = b.l(viewInflate, i);
        if (viewL3 != null) {
            i = q5.k.fragment_container;
            if (((FragmentContainerView) b.l(viewInflate, i)) != null) {
                i = q5.k.links_lay;
                FrameLayout frameLayout = (FrameLayout) b.l(viewInflate, i);
                if (frameLayout != null) {
                    i = q5.k.message_txt;
                    TextView textView = (TextView) b.l(viewInflate, i);
                    if (textView != null) {
                        i = q5.k.playerLayout;
                        RelativeLayout relativeLayout = (RelativeLayout) b.l(viewInflate, i);
                        if (relativeLayout != null) {
                            i = q5.k.player_view;
                            PlayerView playerView = (PlayerView) b.l(viewInflate, i);
                            if (playerView != null) {
                                i = q5.k.progress;
                                ProgressBar progressBar = (ProgressBar) b.l(viewInflate, i);
                                if (progressBar != null && (viewL = b.l(viewInflate, (i = q5.k.swipe_binding))) != null) {
                                    l7.a aVarK = l7.a.k(viewL);
                                    int i10 = q5.k.top_space;
                                    View viewL4 = b.l(viewInflate, i10);
                                    if (viewL4 != null) {
                                        i10 = q5.k.update_fragment_container;
                                        FragmentContainerView fragmentContainerView = (FragmentContainerView) b.l(viewInflate, i10);
                                        if (fragmentContainerView != null) {
                                            u5.a aVar = new u5.a();
                                            aVar.f12213b = (LinearLayout) viewInflate;
                                            aVar.f12214c = viewL3;
                                            aVar.f12216e = frameLayout;
                                            aVar.f12212a = textView;
                                            aVar.f = relativeLayout;
                                            aVar.f12217g = playerView;
                                            aVar.f12218h = progressBar;
                                            aVar.i = aVarK;
                                            aVar.f12215d = viewL4;
                                            aVar.f12219j = fragmentContainerView;
                                            this.X = aVar;
                                            int i11 = Build.VERSION.SDK_INT;
                                            if (i11 >= 35) {
                                                this.f1537w0 = true;
                                                viewL4.setVisibility(0);
                                                ((View) this.X.f12215d).setOnApplyWindowInsetsListener(new d(1));
                                                ((View) this.X.f12214c).setVisibility(0);
                                                ((View) this.X.f12214c).setOnApplyWindowInsetsListener(new d(2));
                                            }
                                            setContentView((LinearLayout) this.X.f12213b);
                                            PlayerView playerView2 = (PlayerView) this.X.f12217g;
                                            this.f1521f0 = playerView2;
                                            View viewFindViewById = playerView2.findViewById(q5.k.player_controls);
                                            int i12 = q5.k.adjust_btn;
                                            ImageView imageView = (ImageView) b.l(viewFindViewById, i12);
                                            if (imageView != null) {
                                                i12 = q5.k.bottom_controller;
                                                LinearLayout linearLayout = (LinearLayout) b.l(viewFindViewById, i12);
                                                if (linearLayout != null) {
                                                    i12 = q5.k.controllerLinksLay;
                                                    FrameLayout frameLayout2 = (FrameLayout) b.l(viewFindViewById, i12);
                                                    if (frameLayout2 != null) {
                                                        i12 = q5.k.custom_controls;
                                                        if (((LinearLayout) b.l(viewFindViewById, i12)) != null) {
                                                            i12 = q5.k.exo_back;
                                                            ImageButton imageButton = (ImageButton) b.l(viewFindViewById, i12);
                                                            if (imageButton != null && (viewL2 = b.l(viewFindViewById, (i12 = q5.k.exo_controls_background))) != null) {
                                                                i12 = q5.k.exo_duration;
                                                                if (((TextView) b.l(viewFindViewById, i12)) != null) {
                                                                    i12 = q5.k.exo_exo_rew_container;
                                                                    if (((FrameLayout) b.l(viewFindViewById, i12)) != null) {
                                                                        i12 = q5.k.exo_ffwd;
                                                                        if (((ImageButton) b.l(viewFindViewById, i12)) != null) {
                                                                            i12 = q5.k.exo_ffwd_container;
                                                                            if (((FrameLayout) b.l(viewFindViewById, i12)) != null) {
                                                                                i12 = q5.k.exo_fullscreen_btn;
                                                                                ImageButton imageButton2 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                if (imageButton2 != null) {
                                                                                    i12 = q5.k.exo_lock;
                                                                                    ImageButton imageButton3 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                    if (imageButton3 != null) {
                                                                                        i12 = q5.k.exo_mute;
                                                                                        ImageButton imageButton4 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                        if (imageButton4 != null) {
                                                                                            i12 = q5.k.exo_pause;
                                                                                            ImageButton imageButton5 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                            if (imageButton5 != null) {
                                                                                                i12 = q5.k.exo_pip;
                                                                                                ImageButton imageButton6 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                                if (imageButton6 != null) {
                                                                                                    i12 = q5.k.exo_play;
                                                                                                    ImageButton imageButton7 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                                    if (imageButton7 != null) {
                                                                                                        i12 = q5.k.exo_position;
                                                                                                        if (((TextView) b.l(viewFindViewById, i12)) != null) {
                                                                                                            i12 = q5.k.exo_progress;
                                                                                                            if (((DefaultTimeBar) b.l(viewFindViewById, i12)) != null) {
                                                                                                                i12 = q5.k.exo_rew;
                                                                                                                if (((ImageButton) b.l(viewFindViewById, i12)) != null) {
                                                                                                                    i12 = q5.k.exo_settings;
                                                                                                                    ImageButton imageButton8 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                                                    if (imageButton8 != null) {
                                                                                                                        i12 = q5.k.exo_unlock;
                                                                                                                        ImageButton imageButton9 = (ImageButton) b.l(viewFindViewById, i12);
                                                                                                                        if (imageButton9 != null) {
                                                                                                                            i12 = q5.k.left_ly;
                                                                                                                            if (((LinearLayout) b.l(viewFindViewById, i12)) != null) {
                                                                                                                                i12 = q5.k.right_ly;
                                                                                                                                if (((LinearLayout) b.l(viewFindViewById, i12)) != null) {
                                                                                                                                    i12 = q5.k.timer_bar_ly;
                                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) b.l(viewFindViewById, i12);
                                                                                                                                    if (linearLayout2 != null) {
                                                                                                                                        i12 = q5.k.top_bar;
                                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) b.l(viewFindViewById, i12);
                                                                                                                                        if (linearLayout3 != null) {
                                                                                                                                            this.Y = new c(imageView, linearLayout, frameLayout2, imageButton, viewL2, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, linearLayout2, linearLayout3);
                                                                                                                                            final int i13 = 0;
                                                                                                                                            imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i14 = i13;
                                                                                                                                                    int i15 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i14) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i16 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i17 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i15));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i18 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i19 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            if (i11 < 26 || !getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                                                                                                                                                this.Y.i.setVisibility(8);
                                                                                                                                            } else {
                                                                                                                                                final int i14 = 1;
                                                                                                                                                this.Y.i.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                    public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                    {
                                                                                                                                                        this.f10876w = this;
                                                                                                                                                    }

                                                                                                                                                    @Override // android.view.View.OnClickListener
                                                                                                                                                    public final void onClick(View view) {
                                                                                                                                                        int i142 = i14;
                                                                                                                                                        int i15 = 1;
                                                                                                                                                        PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                        switch (i142) {
                                                                                                                                                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                                int i16 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.w();
                                                                                                                                                                break;
                                                                                                                                                            case 1:
                                                                                                                                                                int i17 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.x();
                                                                                                                                                                break;
                                                                                                                                                            case 2:
                                                                                                                                                                PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                                g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                                if (g0Var != null) {
                                                                                                                                                                    playerActivity2.o0 = false;
                                                                                                                                                                    if (!playerActivity2.f1528m0) {
                                                                                                                                                                        g0Var.T();
                                                                                                                                                                        playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                        playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                    } else {
                                                                                                                                                                        playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                        playerActivity2.f1528m0 = false;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case 3:
                                                                                                                                                                g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                                if (g0Var2 != null) {
                                                                                                                                                                    g0Var2.c();
                                                                                                                                                                    playerActivity.o0 = true;
                                                                                                                                                                    playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                    playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                                playerActivity.B0.K = false;
                                                                                                                                                                playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                                RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                                if (recyclerView != null) {
                                                                                                                                                                    recyclerView.setVisibility(0);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                                playerActivity.B0.K = true;
                                                                                                                                                                playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                                RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                    recyclerView2.setVisibility(8);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                                int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                                if (resizeMode == 0) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                    break;
                                                                                                                                                                } else if (resizeMode == 3) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                    break;
                                                                                                                                                                } else if (resizeMode == 4) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                    break;
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                                g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                                if (g0Var3 != null) {
                                                                                                                                                                    v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i15));
                                                                                                                                                                    playerActivity.f1522g0 = sVarW;
                                                                                                                                                                    sVarW.U(playerActivity.o(), null);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                                if (!playerActivity.f1529n0) {
                                                                                                                                                                    g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                    g0Var4.P1();
                                                                                                                                                                    playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                    playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                    playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                    playerActivity.f1529n0 = true;
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                    playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                    playerActivity.f1529n0 = false;
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case 9:
                                                                                                                                                                int i18 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.F();
                                                                                                                                                                break;
                                                                                                                                                            default:
                                                                                                                                                                int i19 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.getClass();
                                                                                                                                                                try {
                                                                                                                                                                    Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                    intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                    playerActivity.startActivity(intent);
                                                                                                                                                                } catch (ActivityNotFoundException e9) {
                                                                                                                                                                    Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                });
                                                                                                                                            }
                                                                                                                                            final int i15 = 2;
                                                                                                                                            this.Y.f12238j.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i15;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i16 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i17 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i18 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i19 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i16 = 3;
                                                                                                                                            this.Y.f12237h.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i16;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i17 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i18 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i19 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i17 = 4;
                                                                                                                                            this.Y.f12240l.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i17;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i18 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i19 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i18 = 5;
                                                                                                                                            this.Y.f.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i18;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i182 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i19 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i19 = 6;
                                                                                                                                            this.Y.f12231a.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i19;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i182 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i192 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i20 = 7;
                                                                                                                                            this.Y.f12239k.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i20;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i182 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i192 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i21 = 8;
                                                                                                                                            this.Y.f12236g.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i21;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i182 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i192 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            final int i22 = 9;
                                                                                                                                            this.Y.f12235e.setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                {
                                                                                                                                                    this.f10876w = this;
                                                                                                                                                }

                                                                                                                                                @Override // android.view.View.OnClickListener
                                                                                                                                                public final void onClick(View view) {
                                                                                                                                                    int i142 = i22;
                                                                                                                                                    int i152 = 1;
                                                                                                                                                    PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                    switch (i142) {
                                                                                                                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                            int i162 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.w();
                                                                                                                                                            break;
                                                                                                                                                        case 1:
                                                                                                                                                            int i172 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.x();
                                                                                                                                                            break;
                                                                                                                                                        case 2:
                                                                                                                                                            PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                            g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                            if (g0Var != null) {
                                                                                                                                                                playerActivity2.o0 = false;
                                                                                                                                                                if (!playerActivity2.f1528m0) {
                                                                                                                                                                    g0Var.T();
                                                                                                                                                                    playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                    playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                    playerActivity2.f1528m0 = false;
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 3:
                                                                                                                                                            g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var2 != null) {
                                                                                                                                                                g0Var2.c();
                                                                                                                                                                playerActivity.o0 = true;
                                                                                                                                                                playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                            playerActivity.B0.K = false;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                            RecyclerView recyclerView = playerActivity.Z;
                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                recyclerView.setVisibility(0);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                            playerActivity.B0.K = true;
                                                                                                                                                            playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                            playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                            RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                            if (recyclerView2 != null) {
                                                                                                                                                                recyclerView2.setVisibility(8);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                            int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                            if (resizeMode == 0) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 3) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                break;
                                                                                                                                                            } else if (resizeMode == 4) {
                                                                                                                                                                playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                break;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                            g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                            if (g0Var3 != null) {
                                                                                                                                                                v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                playerActivity.f1522g0 = sVarW;
                                                                                                                                                                sVarW.U(playerActivity.o(), null);
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                            if (!playerActivity.f1529n0) {
                                                                                                                                                                g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                g0Var4.P1();
                                                                                                                                                                playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                playerActivity.f1529n0 = true;
                                                                                                                                                            } else {
                                                                                                                                                                playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                playerActivity.f1529n0 = false;
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                        case 9:
                                                                                                                                                            int i182 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.F();
                                                                                                                                                            break;
                                                                                                                                                        default:
                                                                                                                                                            int i192 = PlayerActivity.I0;
                                                                                                                                                            playerActivity.getClass();
                                                                                                                                                            try {
                                                                                                                                                                Intent intent = new Intent("android.intent.action.VIEW");
                                                                                                                                                                intent.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                playerActivity.startActivity(intent);
                                                                                                                                                            } catch (ActivityNotFoundException e9) {
                                                                                                                                                                Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                            }
                                                                                                                                                            break;
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            });
                                                                                                                                            this.B0 = new g(this, (l7.a) this.X.i, this.f1521f0, this.f1519d0);
                                                                                                                                            j().a(this.H0, this);
                                                                                                                                            this.W = ProApplication.K;
                                                                                                                                            RecyclerView recyclerView = new RecyclerView(this, null);
                                                                                                                                            this.Z = recyclerView;
                                                                                                                                            recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                                                                                                                                            ((FrameLayout) this.X.f12216e).addView(this.Z);
                                                                                                                                            Intent intent = getIntent();
                                                                                                                                            this.f1540z0 = intent.getBooleanExtra("fromSplash", true);
                                                                                                                                            y(intent);
                                                                                                                                            String str = this.W.E;
                                                                                                                                            if (str != null) {
                                                                                                                                                ((TextView) this.X.f12212a).setText(str);
                                                                                                                                                ((TextView) this.X.f12212a).setSelected(true);
                                                                                                                                                final int i23 = 10;
                                                                                                                                                ((TextView) this.X.f12212a).setOnClickListener(new View.OnClickListener(this) { // from class: r5.m

                                                                                                                                                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                                                                                                                                                    public final /* synthetic */ PlayerActivity f10876w;

                                                                                                                                                    {
                                                                                                                                                        this.f10876w = this;
                                                                                                                                                    }

                                                                                                                                                    @Override // android.view.View.OnClickListener
                                                                                                                                                    public final void onClick(View view) {
                                                                                                                                                        int i142 = i23;
                                                                                                                                                        int i152 = 1;
                                                                                                                                                        PlayerActivity playerActivity = this.f10876w;
                                                                                                                                                        switch (i142) {
                                                                                                                                                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                                                                                                                                int i162 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.w();
                                                                                                                                                                break;
                                                                                                                                                            case 1:
                                                                                                                                                                int i172 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.x();
                                                                                                                                                                break;
                                                                                                                                                            case 2:
                                                                                                                                                                PlayerActivity playerActivity2 = this.f10876w;
                                                                                                                                                                g0 g0Var = playerActivity2.f1519d0;
                                                                                                                                                                if (g0Var != null) {
                                                                                                                                                                    playerActivity2.o0 = false;
                                                                                                                                                                    if (!playerActivity2.f1528m0) {
                                                                                                                                                                        g0Var.T();
                                                                                                                                                                        playerActivity2.Y.f12238j.setVisibility(8);
                                                                                                                                                                        playerActivity2.Y.f12237h.setVisibility(0);
                                                                                                                                                                    } else {
                                                                                                                                                                        playerActivity2.A(playerActivity2.f1523h0, playerActivity2.f1524i0, playerActivity2.f1525j0, playerActivity2.f1526k0, null);
                                                                                                                                                                        playerActivity2.f1528m0 = false;
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case 3:
                                                                                                                                                                g0 g0Var2 = playerActivity.f1519d0;
                                                                                                                                                                if (g0Var2 != null) {
                                                                                                                                                                    g0Var2.c();
                                                                                                                                                                    playerActivity.o0 = true;
                                                                                                                                                                    playerActivity.Y.f12237h.setVisibility(8);
                                                                                                                                                                    playerActivity.Y.f12238j.setVisibility(0);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                                                                                                                                                playerActivity.B0.K = false;
                                                                                                                                                                playerActivity.Y.f12242n.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12232b.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12241m.setVisibility(0);
                                                                                                                                                                playerActivity.Y.f12240l.setVisibility(8);
                                                                                                                                                                RecyclerView recyclerView2 = playerActivity.Z;
                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                    recyclerView2.setVisibility(0);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                                                                                                                                                playerActivity.B0.K = true;
                                                                                                                                                                playerActivity.Y.f12242n.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12232b.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12241m.setVisibility(8);
                                                                                                                                                                playerActivity.Y.f12240l.setVisibility(0);
                                                                                                                                                                RecyclerView recyclerView22 = playerActivity.Z;
                                                                                                                                                                if (recyclerView22 != null) {
                                                                                                                                                                    recyclerView22.setVisibility(8);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                                                                                                                                                int resizeMode = playerActivity.f1521f0.getResizeMode();
                                                                                                                                                                if (resizeMode == 0) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(3);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_crop);
                                                                                                                                                                    break;
                                                                                                                                                                } else if (resizeMode == 3) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(4);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_fit);
                                                                                                                                                                    break;
                                                                                                                                                                } else if (resizeMode == 4) {
                                                                                                                                                                    playerActivity.f1521f0.setResizeMode(0);
                                                                                                                                                                    playerActivity.Y.f12231a.setImageResource(q5.j.mode_fill);
                                                                                                                                                                    break;
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                                                                                                                                                g0 g0Var3 = playerActivity.f1519d0;
                                                                                                                                                                if (g0Var3 != null) {
                                                                                                                                                                    v5.s sVarW = v5.s.W(g0Var3, new b(playerActivity, i152));
                                                                                                                                                                    playerActivity.f1522g0 = sVarW;
                                                                                                                                                                    sVarW.U(playerActivity.o(), null);
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                                                                                                                                                if (!playerActivity.f1529n0) {
                                                                                                                                                                    g0 g0Var4 = playerActivity.f1519d0;
                                                                                                                                                                    g0Var4.P1();
                                                                                                                                                                    playerActivity.f1532r0 = g0Var4.f4708u0;
                                                                                                                                                                    playerActivity.f1519d0.O0(0.0f);
                                                                                                                                                                    playerActivity.Y.f12236g.setImageResource(q5.j.volume_off_24px);
                                                                                                                                                                    playerActivity.f1529n0 = true;
                                                                                                                                                                } else {
                                                                                                                                                                    playerActivity.f1519d0.O0(playerActivity.f1532r0);
                                                                                                                                                                    playerActivity.Y.f12236g.setImageResource(q5.j.volume_up_24px);
                                                                                                                                                                    playerActivity.f1529n0 = false;
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                            case 9:
                                                                                                                                                                int i182 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.F();
                                                                                                                                                                break;
                                                                                                                                                            default:
                                                                                                                                                                int i192 = PlayerActivity.I0;
                                                                                                                                                                playerActivity.getClass();
                                                                                                                                                                try {
                                                                                                                                                                    Intent intent2 = new Intent("android.intent.action.VIEW");
                                                                                                                                                                    intent2.setData(Uri.parse(playerActivity.W.F));
                                                                                                                                                                    playerActivity.startActivity(intent2);
                                                                                                                                                                } catch (ActivityNotFoundException e9) {
                                                                                                                                                                    Toast.makeText(playerActivity, e9.getMessage(), 0).show();
                                                                                                                                                                }
                                                                                                                                                                break;
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                });
                                                                                                                                            }
                                                                                                                                            this.f1535u0 = ((RelativeLayout) this.X.f).getLayoutParams().height;
                                                                                                                                            if (getResources().getConfiguration().orientation != 2) {
                                                                                                                                                j4.E(this);
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            F();
                                                                                                                                            this.f1531q0 = true;
                                                                                                                                            this.Y.f12235e.setClickable(false);
                                                                                                                                            this.Y.f12235e.setFocusable(false);
                                                                                                                                            this.Y.f12235e.setEnabled(false);
                                                                                                                                            this.Y.f12235e.setAlpha(0.5f);
                                                                                                                                            G(this.Y.f12233c);
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
                                                    }
                                                }
                                            }
                                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i12)));
                                        }
                                    }
                                    i = i10;
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
        g0 g0Var = this.f1519d0;
        if (g0Var != null) {
            g0Var.C1();
        }
        u uVar = this.f1520e0;
        if (uVar != null) {
            uVar.a();
        }
        this.X = null;
        super.onDestroy();
    }

    @Override // c.m, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        y(intent);
    }

    @Override // h.j, android.app.Activity
    public final void onPause() {
        g0 g0Var;
        if (!(Build.VERSION.SDK_INT >= 24 ? isInPictureInPictureMode() : false) && (g0Var = this.f1519d0) != null && !this.o0) {
            g0Var.c();
        }
        this.W.G = null;
        super.onPause();
    }

    @Override // c.m, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        super.onPictureInPictureModeChanged(z10, configuration);
        if (!z10) {
            if (!this.f1530p0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((RelativeLayout) this.X.f).getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = this.f1535u0;
                ((RelativeLayout) this.X.f).setLayoutParams(layoutParams);
            }
            g0 g0Var = this.f1519d0;
            if (g0Var != null) {
                g0Var.c();
            }
            this.f1521f0.setControllerAutoShow(true);
            return;
        }
        s sVar = this.f1522g0;
        if (sVar != null) {
            sVar.R(false, false);
        }
        this.f1521f0.b();
        this.f1521f0.setControllerAutoShow(false);
        if (this.f1530p0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ((RelativeLayout) this.X.f).getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        ((RelativeLayout) this.X.f).setLayoutParams(layoutParams2);
    }

    @Override // h.j, android.app.Activity
    public final void onResume() {
        this.f1539y0 = false;
        g0 g0Var = this.f1519d0;
        if (g0Var != null && !this.f1528m0 && !this.o0) {
            g0Var.T();
        }
        a6.b.a(this);
        super.onResume();
    }

    @Override // c.m, android.app.Activity
    public final void onUserLeaveHint() {
        if (this.f1538x0 && !this.f1539y0) {
            x();
        }
        super.onUserLeaveHint();
    }

    public final void w() {
        if (this.Y.f12235e.getVisibility() == 0 && this.f1530p0 && !this.f1531q0) {
            F();
            return;
        }
        g0 g0Var = this.f1519d0;
        if (g0Var != null) {
            g0Var.C1();
        }
        if (this.f1540z0) {
            finish();
            return;
        }
        com.bumptech.glide.d.t(this).edit().putBoolean("is_tv", false).apply();
        if (this.E0 == null) {
            startActivity(new Intent(this, (Class<?>) SplashActivity.class));
            finish();
            return;
        }
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            int longVersionCode = Build.VERSION.SDK_INT >= 29 ? (int) packageInfo.getLongVersionCode() : packageInfo.versionCode;
            if (this.E0.Q != longVersionCode) {
                ((RelativeLayout) this.X.f).setVisibility(8);
                ((FragmentContainerView) this.X.f12219j).setVisibility(0);
                f6.c cVar = (f6.c) new v(this).r(f6.c.class);
                cVar.f3983h = longVersionCode;
                cVar.f3982g = this.F0;
                cVar.f3981e = this.E0.A;
                cVar.f3980d = new l(this, 1);
                x5.u uVar = new x5.u();
                r0 r0VarO = o();
                r0VarO.getClass();
                androidx.fragment.app.a aVar = new androidx.fragment.app.a(r0VarO);
                aVar.f(q5.k.update_fragment_container, uVar, null, 1);
                aVar.e(false);
                ((FragmentContainerView) this.X.f12219j).setVisibility(0);
                return;
            }
        } catch (PackageManager.NameNotFoundException e9) {
            e9.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("appDetail", this.E0);
        startActivity(intent);
        finish();
    }

    public final void x() {
        if (this.f1519d0 == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        try {
            if (getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                m9.a.o();
                PictureInPictureParams.Builder builderD = m9.a.d();
                builderD.setAspectRatio(new Rational(16, 9));
                Rect rect = new Rect();
                ((RelativeLayout) this.X.f).getGlobalVisibleRect(rect);
                builderD.setSourceRectHint(rect);
                enterPictureInPictureMode(builderD.build());
            }
        } catch (Exception unused) {
        }
    }

    public final void y(Intent intent) {
        int i = 2;
        if (intent.hasExtra("links_model")) {
            y5.g gVar = Build.VERSION.SDK_INT > 33 ? (y5.g) intent.getParcelableExtra("links_model", y5.g.class) : (y5.g) intent.getParcelableExtra("links_model");
            if (gVar != null) {
                this.f1523h0 = gVar.f14939w;
                this.f1524i0 = gVar.f14940x;
                this.f1534t0 = gVar.A;
                this.f1526k0 = gVar.f14942z;
                this.f1527l0 = gVar.B;
            } else {
                this.f1523h0 = "https://pro.com";
            }
            A(this.f1523h0, this.f1524i0, this.f1525j0, this.f1526k0, null);
        } else if (intent.getData() != null) {
            j4.E(this);
            this.Y.f12235e.setVisibility(0);
            F();
            String string = intent.getData().toString();
            b.p(this, com.bumptech.glide.d.s(this) + "app.txt", null, new l(this, i), false);
            String lowerCase = string.toLowerCase();
            StringBuilder sb = new StringBuilder(string);
            if (lowerCase.contains("|") && lowerCase.contains("drmlicense=")) {
                String[] strArrSplit = string.split("\\|");
                ArrayList arrayListQ = j4.q(strArrSplit[1], "drmlicense");
                StringBuilder sb2 = new StringBuilder(strArrSplit[0] + "|" + ((String) arrayListQ.get(0)));
                if (!TextUtils.isEmpty((CharSequence) arrayListQ.get(1))) {
                    this.f1524i0 = (String) arrayListQ.get(1);
                }
                sb = sb2;
            }
            if (lowerCase.contains("|") && lowerCase.contains("drmscheme=")) {
                String[] strArrSplit2 = sb.toString().split("\\|");
                ArrayList arrayListQ2 = j4.q(strArrSplit2[1], "drmscheme");
                sb = new StringBuilder(strArrSplit2[0] + "|" + ((String) arrayListQ2.get(0)));
                if (!TextUtils.isEmpty((CharSequence) arrayListQ2.get(1))) {
                    String str = (String) arrayListQ2.get(1);
                    int i10 = v5.m.D;
                    String lowerCase2 = str.toLowerCase();
                    lowerCase2.getClass();
                    this.f1534t0 = !lowerCase2.equals("widevine") ? !lowerCase2.equals("clearkey") ? 2 : 0 : 1;
                }
            }
            String string2 = sb.toString();
            if (string2.indexOf("|") + 1 >= string2.length()) {
                sb = new StringBuilder(string2.split("\\|")[0]);
            }
            this.f1540z0 = false;
            String string3 = sb.toString();
            this.f1523h0 = string3;
            this.f1525j0 = null;
            this.f1526k0 = null;
            this.f1527l0 = true;
            A(string3, this.f1524i0, null, null, null);
        } else {
            if (intent.hasExtra("title")) {
                intent.getStringExtra("title");
            }
            boolean booleanExtra = intent.getBooleanExtra("isEncoded", true);
            String stringExtra = intent.getStringExtra("links");
            this.f1533s0 = intent.getIntExtra("position", 0);
            if (!this.f1540z0) {
                com.bumptech.glide.d.u(this).putInt("player_called", -1).apply();
            }
            this.W.D = stringExtra;
            D(stringExtra, booleanExtra);
        }
        this.Z.setVisibility(8);
        if (!this.f1531q0) {
            m mVar = this.G0;
            if (mVar == null) {
                this.G0 = new m();
                r0 r0VarO = o();
                androidx.fragment.app.a aVarF = e.f(r0VarO, r0VarO);
                aVarF.f(q5.k.fragment_container, this.G0, null, 1);
                aVarF.e(false);
            } else {
                mVar.S();
            }
        }
        if (getSharedPreferences("DataPreferences", 0).getBoolean("external_ad_enabled", false)) {
            int i11 = getSharedPreferences("DataPreferences", 0).getInt("external_ad_repeat_after", 3);
            int i12 = getSharedPreferences("DataPreferences", 0).getInt("player_called", 0);
            if (i12 >= i11) {
                i12 = 0;
            }
            if (i12 == 0) {
                String string4 = com.bumptech.glide.d.t(this).getString("external_ad_url", "");
                if (!TextUtils.isEmpty(string4)) {
                    try {
                        try {
                            this.f1539y0 = true;
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(string4));
                            intent2.setPackage("com.android.chrome");
                            startActivity(intent2);
                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                            this.f1539y0 = false;
                        }
                    } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused2) {
                        this.f1539y0 = true;
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string4)));
                    }
                }
            }
            com.bumptech.glide.d.u(this).putInt("player_called", i12 + 1).apply();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, i), 500L);
    }

    public final v1.g0 z(String str, String str2, String str3) {
        c0 c0Var;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            g0 g0VarA = new g2.p(this).a();
            this.f1519d0 = g0VarA;
            this.f1521f0.setPlayer(g0VarA);
            ab.b.k(this, str3, this.f1536v0);
            return null;
        }
        boolean z10 = true;
        if (str.contains(".mpd") && str2 != null && !str2.isEmpty()) {
            int i = this.f1534t0;
            UUID uuid = i != 0 ? i != 1 ? f.f12661e : f.f12660d : f.f12659c;
            if (!str2.contains("http")) {
                v1.u uVar = new v1.u();
                uVar.f12994a = Uri.parse(str);
                uVar.b(new z(new y(uuid)));
                return uVar.a();
            }
            v1.u uVar2 = new v1.u();
            uVar2.f12994a = Uri.parse(str);
            y yVar = new y(uuid);
            yVar.f13038b = Uri.parse(str2);
            yVar.f13037a = uuid;
            uVar2.b(new z(yVar));
            return uVar2.a();
        }
        v1.v vVar = new v1.v();
        y yVar2 = new y();
        List list = Collections.EMPTY_LIST;
        z0 z0Var = z0.f12413z;
        t tVar = new t();
        v1.d0 d0Var = v1.d0.f12622d;
        Uri uri = Uri.parse(str);
        String strM = j4.m(str);
        if (yVar2.f13038b != null && yVar2.f13037a == null) {
            z10 = false;
        }
        y1.d.g(z10);
        if (uri != null) {
            c0Var = new c0(uri, strM, yVar2.f13037a != null ? new z(yVar2) : null, null, list, null, z0Var, -9223372036854775807L);
        } else {
            c0Var = null;
        }
        return new v1.g0("", new x(vVar), c0Var, new a0(tVar), j0.K, d0Var);
    }
}
