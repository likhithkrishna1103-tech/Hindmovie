package d6;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.emoji2.text.v;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.cricfy.tv.activities.LandscapeActivity;
import app.cricfy.tv.services.FloatingPlayer;
import com.google.android.gms.internal.measurement.j4;
import g2.g0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k2.t;
import m4.f0;
import nc.p;
import org.json.JSONArray;
import org.json.JSONException;
import s5.n;
import ua.z0;
import v1.a0;
import v1.c0;
import v1.d0;
import v1.j0;
import v1.u;
import v1.x;
import v1.y;
import v1.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public q5.g A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f3423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f3424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u5.d f3425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlayerView f3426e;
    public g0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f3427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f3428h;
    public ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f3430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f3431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f3432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3437r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3438s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3442w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Handler f3443x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f3444y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f3445z;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3439t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3440u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3441v = true;
    public final p6.d B = new p6.d(7, this);

    public k(h.j jVar, p pVar, u5.d dVar, Intent intent) {
        this.f3422a = jVar;
        this.f3425d = dVar;
        PlayerView playerView = (PlayerView) pVar.f9070b;
        this.f3426e = playerView;
        this.f3424c = pVar;
        playerView.setPlayer(null);
        g(false);
        a(intent);
        if (com.bumptech.glide.d.t(this.f3422a).getBoolean("external_ad_enabled", false)) {
            int i = com.bumptech.glide.d.t(this.f3422a).getInt("external_ad_repeat_after", 3);
            int i10 = com.bumptech.glide.d.t(this.f3422a).getInt("player_called", 0);
            int i11 = i10 < i ? i10 : 0;
            if (i11 == 0) {
                String string = com.bumptech.glide.d.t(this.f3422a).getString("external_ad_url", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(string));
                            intent2.setFlags(268435456);
                            intent2.setPackage("com.android.chrome");
                            this.f3422a.startActivity(intent2);
                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(string));
                            intent3.setFlags(268435456);
                            this.f3422a.startActivity(intent3);
                        }
                    } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused2) {
                    }
                }
            }
            com.bumptech.glide.d.u(this.f3422a).putInt("player_called", i11 + 1).apply();
        }
        ProgressBar progressBar = (ProgressBar) this.f3426e.findViewById(f0.exo_buffering);
        if (progressBar != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(jVar.getColor(q5.i.gray_60), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void h(Map map, v vVar) {
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

    public final void a(Intent intent) {
        this.f3434o = true;
        if (!intent.hasExtra("links_model")) {
            this.f3438s = intent.getIntExtra("position", 0);
            i(intent.getStringExtra("links"), intent.getBooleanExtra("isEncoded", true));
            return;
        }
        y5.g gVar = Build.VERSION.SDK_INT > 33 ? (y5.g) intent.getParcelableExtra("links_model", y5.g.class) : (y5.g) intent.getParcelableExtra("links_model");
        if (gVar != null) {
            this.f3429j = gVar.f14939w;
            this.f3430k = gVar.f14940x;
            this.f3437r = gVar.A;
            this.f3432m = gVar.f14942z;
            this.f3435p = gVar.B;
        } else {
            this.f3429j = "https://pro.com";
        }
        d(this.f3429j, this.f3430k, this.f3431l, this.f3432m, null);
    }

    public final v1.g0 b(String str, String str2, String str3) {
        c0 c0Var;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            g0 g0VarA = new g2.p(this.f3422a).a();
            this.f = g0VarA;
            this.f3426e.setPlayer(g0VarA);
            ab.b.k(this.f3422a, str3, this.B);
            return null;
        }
        boolean z10 = true;
        if (!str.contains(".mpd") || str2 == null || str2.isEmpty()) {
            v1.v vVar = new v1.v();
            y yVar = new y();
            List list = Collections.EMPTY_LIST;
            z0 z0Var = z0.f12413z;
            t tVar = new t();
            d0 d0Var = d0.f12622d;
            Uri uri = Uri.parse(str);
            String strM = j4.m(str);
            if (yVar.f13038b != null && yVar.f13037a == null) {
                z10 = false;
            }
            y1.d.g(z10);
            if (uri != null) {
                c0Var = new c0(uri, strM, yVar.f13037a != null ? new z(yVar) : null, null, list, null, z0Var, -9223372036854775807L);
            } else {
                c0Var = null;
            }
            return new v1.g0("", new x(vVar), c0Var, new a0(tVar), j0.K, d0Var);
        }
        int i = this.f3437r;
        UUID uuid = i != 0 ? i != 1 ? v1.f.f12661e : v1.f.f12660d : v1.f.f12659c;
        if (!str2.contains("http")) {
            u uVar = new u();
            uVar.f12994a = Uri.parse(str);
            uVar.f12995b = "application/dash+xml";
            uVar.b(new z(new y(uuid)));
            return uVar.a();
        }
        u uVar2 = new u();
        uVar2.f12994a = Uri.parse(str);
        uVar2.f12995b = "application/dash+xml";
        y yVar2 = new y(uuid);
        yVar2.f13038b = Uri.parse(str2);
        yVar2.f13037a = uuid;
        uVar2.b(new z(yVar2));
        return uVar2.a();
    }

    public final void c() {
        g0 g0Var = this.f;
        if (g0Var != null) {
            g0Var.T();
            this.f.j(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:9:0x002c, B:11:0x003b, B:13:0x0041, B:19:0x0062, B:22:0x006b, B:26:0x007f, B:37:0x00fb, B:39:0x0109, B:41:0x011c, B:44:0x0182, B:49:0x018d, B:51:0x019a, B:53:0x01a2, B:55:0x01ab, B:58:0x01b1, B:62:0x01bb, B:64:0x01ce, B:65:0x01d4, B:60:0x01b5, B:61:0x01b8, B:54:0x01a7, B:66:0x020b, B:67:0x022a, B:40:0x0112, B:29:0x00e3, B:31:0x00eb, B:34:0x00f5, B:25:0x007b, B:16:0x0048, B:18:0x0050), top: B:79:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:9:0x002c, B:11:0x003b, B:13:0x0041, B:19:0x0062, B:22:0x006b, B:26:0x007f, B:37:0x00fb, B:39:0x0109, B:41:0x011c, B:44:0x0182, B:49:0x018d, B:51:0x019a, B:53:0x01a2, B:55:0x01ab, B:58:0x01b1, B:62:0x01bb, B:64:0x01ce, B:65:0x01d4, B:60:0x01b5, B:61:0x01b8, B:54:0x01a7, B:66:0x020b, B:67:0x022a, B:40:0x0112, B:29:0x00e3, B:31:0x00eb, B:34:0x00f5, B:25:0x007b, B:16:0x0048, B:18:0x0050), top: B:79:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018d A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:9:0x002c, B:11:0x003b, B:13:0x0041, B:19:0x0062, B:22:0x006b, B:26:0x007f, B:37:0x00fb, B:39:0x0109, B:41:0x011c, B:44:0x0182, B:49:0x018d, B:51:0x019a, B:53:0x01a2, B:55:0x01ab, B:58:0x01b1, B:62:0x01bb, B:64:0x01ce, B:65:0x01d4, B:60:0x01b5, B:61:0x01b8, B:54:0x01a7, B:66:0x020b, B:67:0x022a, B:40:0x0112, B:29:0x00e3, B:31:0x00eb, B:34:0x00f5, B:25:0x007b, B:16:0x0048, B:18:0x0050), top: B:79:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x022a A[Catch: Exception -> 0x0045, TRY_LEAVE, TryCatch #0 {Exception -> 0x0045, blocks: (B:9:0x002c, B:11:0x003b, B:13:0x0041, B:19:0x0062, B:22:0x006b, B:26:0x007f, B:37:0x00fb, B:39:0x0109, B:41:0x011c, B:44:0x0182, B:49:0x018d, B:51:0x019a, B:53:0x01a2, B:55:0x01ab, B:58:0x01b1, B:62:0x01bb, B:64:0x01ce, B:65:0x01d4, B:60:0x01b5, B:61:0x01b8, B:54:0x01a7, B:66:0x020b, B:67:0x022a, B:40:0x0112, B:29:0x00e3, B:31:0x00eb, B:34:0x00f5, B:25:0x007b, B:16:0x0048, B:18:0x0050), top: B:79:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.Map r24) {
        /*
            Method dump skipped, instruction units count: 771
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.k.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void e() {
        n nVar;
        n nVar2 = this.f3428h;
        if (nVar2 != null) {
            int i = nVar2.f11513g + 1;
            if (i == this.i.size()) {
                i = 0;
            }
            y5.g gVar = (y5.g) this.i.get(i);
            this.f3445z.b(gVar.f14939w.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), gVar.f14940x, gVar.f14941y, gVar.f14942z, gVar.A, gVar.B);
            RecyclerView recyclerView = this.f3427g;
            if (recyclerView == null || (nVar = this.f3428h) == null || nVar.f11513g == i) {
                return;
            }
            recyclerView.g0(i);
            new Handler(Looper.getMainLooper()).postDelayed(new i(i, 0, this), 100L);
        }
    }

    public final void f(h.j jVar, p pVar, u5.d dVar, boolean z10) {
        this.f3426e.setPlayer(null);
        this.f3422a = jVar;
        this.f3424c = pVar;
        this.f3425d = dVar;
        PlayerView playerView = (PlayerView) pVar.f9070b;
        this.f3426e = playerView;
        g0 g0Var = this.f;
        if (g0Var != null) {
            playerView.setPlayer(g0Var);
            if (this.f3440u || this.f3439t) {
                dVar.f12254n.setVisibility(8);
                dVar.f12255o.setVisibility(0);
            } else {
                dVar.f12254n.setVisibility(0);
                dVar.f12255o.setVisibility(8);
            }
        }
        ((ProgressBar) pVar.f9071c).setVisibility(this.f3434o ? 0 : 8);
        g(z10);
    }

    public final void g(boolean z10) {
        final int i = 0;
        this.f3425d.f12248g.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                View view3 = (View) arrayList.get(i10);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i10);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i10 = 1;
        this.f3425d.f12251k.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i11 = 2;
        this.f3425d.f12249h.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i12 = 3;
        this.f3425d.f.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i13 = 4;
        this.f3425d.f12252l.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i13) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i14 = 5;
        this.f3425d.f12244b.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i14) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i15 = 6;
        this.f3425d.f12255o.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i15) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i16 = 7;
        this.f3425d.f12254n.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i16) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        final int i17 = 8;
        this.f3425d.f12249h.setOnClickListener(new View.OnClickListener(this) { // from class: d6.e

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ k f3410w;

            {
                this.f3410w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i17) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        k kVar = this.f3410w;
                        kVar.A.K = true;
                        kVar.f3425d.f12257q.setVisibility(8);
                        kVar.f3425d.f12245c.setVisibility(8);
                        kVar.f3425d.f12256p.setVisibility(8);
                        kVar.f3425d.f12251k.setVisibility(0);
                        break;
                    case 1:
                        k kVar2 = this.f3410w;
                        kVar2.A.K = false;
                        kVar2.f3425d.f12257q.setVisibility(0);
                        kVar2.f3425d.f12245c.setVisibility(0);
                        kVar2.f3425d.f12256p.setVisibility(0);
                        kVar2.f3425d.f12251k.setVisibility(8);
                        break;
                    case 2:
                        k kVar3 = this.f3410w;
                        if (kVar3.f3433n) {
                            kVar3.f.O0(kVar3.f3436q);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar3.f3433n = false;
                        } else {
                            g0 g0Var = kVar3.f;
                            g0Var.P1();
                            kVar3.f3436q = g0Var.f4708u0;
                            kVar3.f.O0(0.0f);
                            kVar3.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar3.f3433n = true;
                        }
                        break;
                    case 3:
                        k kVar4 = this.f3410w;
                        boolean z11 = kVar4.f3442w;
                        kVar4.f3442w = !z11;
                        a aVar = kVar4.f3423b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f3394v;
                        k kVar5 = (k) aVar.f3395w;
                        View view2 = (View) aVar.f3396x;
                        p pVar = (p) aVar.f3397y;
                        u5.d dVar = (u5.d) aVar.f3398z;
                        if (z11) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f1579z.f1569w;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            dVar.f.setVisibility(8);
                            dVar.i.setVisibility(8);
                            dVar.f12250j.setVisibility(8);
                            dVar.f12243a.setVisibility(8);
                            dVar.f12252l.setVisibility(0);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f1576w;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    k kVar6 = (k) floatingPlayer.f1577x.get(i102);
                                    g0 g0Var2 = kVar6.f;
                                    if (g0Var2 != null) {
                                        g0Var2.c();
                                        kVar6.f.j(false);
                                    }
                                }
                            }
                            floatingPlayer.A = kVar5;
                            floatingPlayer.B = view2;
                            floatingPlayer.C = pVar;
                            floatingPlayer.D = dVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        this.f3410w.f3425d.f.callOnClick();
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        k kVar7 = this.f3410w;
                        g0 g0Var3 = kVar7.f;
                        if (g0Var3 != null) {
                            kVar7.f3440u = false;
                            if (kVar7.f3439t) {
                                kVar7.d(kVar7.f3429j, kVar7.f3430k, kVar7.f3431l, kVar7.f3432m, null);
                                kVar7.f3439t = false;
                            } else {
                                g0Var3.T();
                                kVar7.f3425d.f12255o.setVisibility(8);
                                kVar7.f3425d.f12254n.setVisibility(0);
                            }
                        }
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        k kVar8 = this.f3410w;
                        g0 g0Var4 = kVar8.f;
                        if (g0Var4 != null) {
                            g0Var4.c();
                            kVar8.f3425d.f12254n.setVisibility(8);
                            kVar8.f3425d.f12255o.setVisibility(0);
                            kVar8.f3440u = true;
                        }
                        break;
                    default:
                        k kVar9 = this.f3410w;
                        if (kVar9.f3433n) {
                            kVar9.f.O0(kVar9.f3436q);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_up_24px);
                            kVar9.f3433n = false;
                        } else {
                            g0 g0Var5 = kVar9.f;
                            g0Var5.P1();
                            kVar9.f3436q = g0Var5.f4708u0;
                            kVar9.f.O0(0.0f);
                            kVar9.f3425d.f12249h.setImageResource(q5.j.volume_off_24px);
                            kVar9.f3433n = true;
                        }
                        break;
                }
            }
        });
        q5.g gVar = new q5.g((h.j) this.f3422a, (l7.a) this.f3424c.f9072d, this.f3426e, this.f);
        this.A = gVar;
        if (z10) {
            this.f3426e.setOnTouchListener(gVar);
        }
    }

    public final void i(String str, boolean z10) {
        if (this.f3424c == null) {
            return;
        }
        g0 g0Var = this.f;
        if (g0Var != null) {
            g0Var.C1();
        }
        if (z10) {
            android.support.v4.media.session.b.p(this.f3422a, android.support.v4.media.session.b.n(this.f3422a, str), null, new g(this, 1), false);
            return;
        }
        if (str.contains("[*]")) {
            android.support.v4.media.session.b.v(str, new g(this, 0));
            return;
        }
        try {
            if (!str.startsWith("[")) {
                str = a6.a.b(str);
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i = this.f3438s;
            if (length <= i) {
                i = 0;
            }
            y5.g gVarB = y5.g.b(jSONArray.getJSONObject(i));
            this.f3429j = gVarB.f14939w;
            this.f3430k = gVarB.f14940x;
            this.f3431l = gVarB.f14941y;
            this.f3432m = gVarB.f14942z;
            this.f3437r = gVarB.A;
            this.f3435p = gVarB.B;
            if (jSONArray.length() > 1) {
                j(jSONArray);
            }
        } catch (JSONException e9) {
            Log.e("Pro", "JSONException", e9);
            Toast.makeText(this.f3422a, e9.toString(), 1).show();
            this.f3429j = "https://pro.com";
            this.f3430k = null;
            this.f3431l = null;
            this.f3432m = null;
            this.f3437r = 0;
        }
        d(this.f3429j, this.f3430k, this.f3431l, this.f3432m, null);
    }

    public final void j(JSONArray jSONArray) {
        this.f3445z = new g(this, 2);
        ArrayList arrayListA = y5.g.a(jSONArray);
        this.i = arrayListA;
        n nVar = new n(this.f3422a, arrayListA, this.f3445z);
        this.f3428h = nVar;
        nVar.f11513g = 0;
        RecyclerView recyclerView = new RecyclerView(this.f3422a, null);
        this.f3427g = recyclerView;
        recyclerView.setAdapter(this.f3428h);
        this.f3427g.setLayoutManager(new LinearLayoutManager(0));
        new Handler(Looper.getMainLooper()).postDelayed(new f(this, 0), 100L);
    }
}
