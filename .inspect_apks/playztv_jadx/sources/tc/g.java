package tc;

import a2.o0;
import a2.u;
import aa.c1;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.services.FloatingPlayer;
import e2.t;
import gc.i;
import ic.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import ta.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public f A;
    public e B;
    public gc.g C;
    public boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f12464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b2.g f12465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kc.e f12466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlayerView f12467e;
    public o0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f12468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f12469h;
    public ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f12470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f12471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f12472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f12474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12475o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12476p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12477q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12478r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f12479s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12480t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f12481u;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12485y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Handler f12486z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12482v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12483w = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12484x = true;
    public final j D = new j(this);

    public g(h.j jVar, b2.g gVar, kc.e eVar, Intent intent) {
        this.f12463a = jVar;
        this.f12466d = eVar;
        PlayerView playerView = (PlayerView) gVar.f1739d;
        this.f12467e = playerView;
        this.f12465c = gVar;
        playerView.setPlayer(null);
        i(false);
        a(intent);
        if (uc.b.f(this.f12463a).getBoolean("external_ad_enabled", false)) {
            int i = uc.b.f(this.f12463a).getInt("external_ad_repeat_after", 3);
            int i10 = uc.b.f(this.f12463a).getInt("player_called", 0);
            int i11 = i10 < i ? i10 : 0;
            if (i11 == 0) {
                String string = uc.b.f(this.f12463a).getString("external_ad_url", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(string));
                            intent2.setFlags(268435456);
                            intent2.setPackage("com.android.chrome");
                            this.f12463a.startActivity(intent2);
                        } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused) {
                            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(string));
                            intent3.setFlags(268435456);
                            this.f12463a.startActivity(intent3);
                        }
                    } catch (ActivityNotFoundException | IllegalArgumentException | SecurityException unused2) {
                    }
                }
            }
            uc.b.g(this.f12463a).putInt("player_called", i11 + 1).apply();
        }
    }

    public static void j(Map map, kc.b bVar) {
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
                bVar.f7622x = str2;
                map.remove(str);
            }
        }
        bVar.F(map);
    }

    public final void a(Intent intent) {
        if (!intent.hasExtra("links_model")) {
            this.f12474n = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
            this.f12480t = intent.getIntExtra("position", 0);
            k(intent.getStringExtra("links"), intent.getBooleanExtra("isEncoded", true));
            return;
        }
        oc.f fVar = Build.VERSION.SDK_INT > 33 ? (oc.f) intent.getParcelableExtra("links_model", oc.f.class) : (oc.f) intent.getParcelableExtra("links_model");
        if (fVar != null) {
            this.f12470j = fVar.f9541v;
            this.f12471k = fVar.f9542w;
            this.f12479s = fVar.f9545z;
            this.f12473m = fVar.f9544y;
            this.f12477q = fVar.A;
        } else {
            this.f12470j = "https://pro.com";
        }
        this.f12474n = "";
        f(this.f12470j, this.f12471k, this.f12472l, this.f12473m, null);
    }

    public final g0 b(String str, String str2, String str3) {
        c0 c0Var;
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            o0 o0VarA = new u(this.f12463a).a();
            this.f = o0VarA;
            this.f12467e.setPlayer(o0VarA);
            com.bumptech.glide.d.m(this.f12463a, str3, this.D);
            return null;
        }
        boolean z2 = true;
        if (TextUtils.isEmpty(str2)) {
            w wVar = new w();
            z zVar = new z();
            List list = Collections.EMPTY_LIST;
            c1 c1Var = c1.f650y;
            t tVar = new t();
            d0 d0Var = d0.f9694d;
            Uri uri = str == null ? null : Uri.parse(str);
            String strE = uc.b.e(str);
            if (zVar.f10114b != null && zVar.f10113a == null) {
                z2 = false;
            }
            s1.d.g(z2);
            if (uri != null) {
                c0Var = new c0(uri, strE, zVar.f10113a != null ? new a0(zVar) : null, null, list, null, c1Var, -9223372036854775807L);
            } else {
                c0Var = null;
            }
            return new g0("", new y(wVar), c0Var, new b0(tVar), j0.K, d0Var);
        }
        int i = this.f12479s;
        UUID uuid = i != 0 ? i != 1 ? p1.g.f9749e : p1.g.f9748d : p1.g.f9747c;
        if (!str2.contains("http")) {
            v vVar = new v();
            vVar.f10066a = str != null ? Uri.parse(str) : null;
            vVar.f10067b = "application/dash+xml";
            vVar.b(new a0(new z(uuid)));
            return vVar.a();
        }
        v vVar2 = new v();
        vVar2.f10066a = str != null ? Uri.parse(str) : null;
        vVar2.f10067b = "application/dash+xml";
        z zVar2 = new z(uuid);
        zVar2.f10114b = Uri.parse(str2);
        zVar2.f10113a = uuid;
        vVar2.b(new a0(zVar2));
        return vVar2.a();
    }

    public final boolean c() {
        if (this.f12476p) {
            return true;
        }
        return (this.f12482v || this.f12483w) ? false : true;
    }

    public final void d() {
        this.f12476p = (this.f12482v || this.f12483w) ? false : true;
        o0 o0Var = this.f;
        if (o0Var != null) {
            o0Var.f();
            this.f.m(false);
        }
    }

    public final void e() {
        o0 o0Var = this.f;
        if (o0Var != null) {
            o0Var.X();
            this.f.m(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108 A[Catch: Exception -> 0x0043, TryCatch #0 {Exception -> 0x0043, blocks: (B:9:0x0029, B:11:0x0039, B:13:0x003f, B:19:0x0060, B:22:0x0069, B:26:0x007d, B:37:0x00fa, B:39:0x0108, B:41:0x011b, B:43:0x017f, B:45:0x018a, B:47:0x0192, B:49:0x019a, B:51:0x01a3, B:54:0x01a9, B:58:0x01b3, B:60:0x01c6, B:61:0x01cc, B:56:0x01ad, B:57:0x01b0, B:50:0x019f, B:62:0x0203, B:63:0x0222, B:40:0x0111, B:29:0x00e2, B:31:0x00ea, B:34:0x00f4, B:25:0x0079, B:16:0x0046, B:18:0x004e), top: B:75:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0111 A[Catch: Exception -> 0x0043, TryCatch #0 {Exception -> 0x0043, blocks: (B:9:0x0029, B:11:0x0039, B:13:0x003f, B:19:0x0060, B:22:0x0069, B:26:0x007d, B:37:0x00fa, B:39:0x0108, B:41:0x011b, B:43:0x017f, B:45:0x018a, B:47:0x0192, B:49:0x019a, B:51:0x01a3, B:54:0x01a9, B:58:0x01b3, B:60:0x01c6, B:61:0x01cc, B:56:0x01ad, B:57:0x01b0, B:50:0x019f, B:62:0x0203, B:63:0x0222, B:40:0x0111, B:29:0x00e2, B:31:0x00ea, B:34:0x00f4, B:25:0x0079, B:16:0x0046, B:18:0x004e), top: B:75:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017f A[Catch: Exception -> 0x0043, TryCatch #0 {Exception -> 0x0043, blocks: (B:9:0x0029, B:11:0x0039, B:13:0x003f, B:19:0x0060, B:22:0x0069, B:26:0x007d, B:37:0x00fa, B:39:0x0108, B:41:0x011b, B:43:0x017f, B:45:0x018a, B:47:0x0192, B:49:0x019a, B:51:0x01a3, B:54:0x01a9, B:58:0x01b3, B:60:0x01c6, B:61:0x01cc, B:56:0x01ad, B:57:0x01b0, B:50:0x019f, B:62:0x0203, B:63:0x0222, B:40:0x0111, B:29:0x00e2, B:31:0x00ea, B:34:0x00f4, B:25:0x0079, B:16:0x0046, B:18:0x004e), top: B:75:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0222 A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #0 {Exception -> 0x0043, blocks: (B:9:0x0029, B:11:0x0039, B:13:0x003f, B:19:0x0060, B:22:0x0069, B:26:0x007d, B:37:0x00fa, B:39:0x0108, B:41:0x011b, B:43:0x017f, B:45:0x018a, B:47:0x0192, B:49:0x019a, B:51:0x01a3, B:54:0x01a9, B:58:0x01b3, B:60:0x01c6, B:61:0x01cc, B:56:0x01ad, B:57:0x01b0, B:50:0x019f, B:62:0x0203, B:63:0x0222, B:40:0x0111, B:29:0x00e2, B:31:0x00ea, B:34:0x00f4, B:25:0x0079, B:16:0x0046, B:18:0x004e), top: B:75:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.Map r24) {
        /*
            Method dump skipped, instruction units count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tc.g.f(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void g() {
        p pVar = this.f12469h;
        if (pVar != null) {
            int i = pVar.f6539g + 1;
            if (i == this.i.size()) {
                i = 0;
            }
            oc.f fVar = (oc.f) this.i.get(i);
            this.B.a(fVar.f9541v.replaceAll("\\\\", "").replaceAll("]", "").replaceAll("\"", ""), fVar.f9542w, fVar.f9543x, fVar.f9544y, fVar.f9545z, fVar.A);
        }
    }

    public final void h(h.j jVar, b2.g gVar, kc.e eVar, boolean z2) {
        this.f12467e.setPlayer(null);
        this.f12463a = jVar;
        this.f12465c = gVar;
        this.f12466d = eVar;
        this.f12467e = (PlayerView) gVar.f1739d;
        eVar.f7672y.setText(this.f12474n);
        o0 o0Var = this.f;
        if (o0Var != null) {
            this.f12467e.setPlayer(o0Var);
        }
        i(z2);
    }

    public final void i(boolean z2) {
        final int i = 0;
        this.f12466d.f7661n.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                View view3 = (View) arrayList.get(i10);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i10)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i10 = 3;
        this.f12466d.f7658k.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i11 = 4;
        this.f12466d.f7663p.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i12 = 5;
        this.f12466d.f7664q.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i13 = 6;
        this.f12466d.f7657j.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i13) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i14 = 7;
        this.f12466d.f7651b.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i14) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        this.f12466d.f7654e.setVisibility(8);
        final int i15 = 8;
        this.f12466d.f7660m.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i15) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i16 = 9;
        this.f12466d.f7659l.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i16) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i17 = 10;
        this.f12466d.f7652c.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i17) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i18 = 1;
        this.f12466d.f7653d.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i18) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        final int i19 = 2;
        this.f12466d.f7666s.setOnClickListener(new View.OnClickListener(this) { // from class: tc.d

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ g f12458v;

            {
                this.f12458v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i19) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        g gVar = this.f12458v;
                        o0 o0Var = gVar.f;
                        if (o0Var != null) {
                            if (!gVar.f12483w) {
                                o0Var.f();
                                gVar.f12483w = true;
                            } else if (gVar.f12482v) {
                                gVar.f(gVar.f12470j, gVar.f12471k, gVar.f12472l, gVar.f12473m, null);
                                gVar.f12482v = false;
                            } else {
                                o0Var.X();
                                gVar.f12483w = false;
                            }
                        }
                        break;
                    case 1:
                        g gVar2 = this.f12458v;
                        if (gVar2.f12475o) {
                            gVar2.f.O0(gVar2.f12478r);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_up_24px);
                            gVar2.f12475o = false;
                        } else {
                            o0 o0Var2 = gVar2.f;
                            o0Var2.S1();
                            gVar2.f12478r = o0Var2.f360t0;
                            gVar2.f.O0(0.0f);
                            gVar2.f12466d.f7653d.setImageResource(i.volume_off_24px);
                            gVar2.f12475o = true;
                        }
                        break;
                    case 2:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 3:
                        g gVar3 = this.f12458v;
                        gVar3.C.J = true;
                        gVar3.f12466d.f7662o.setVisibility(8);
                        gVar3.f12466d.f7656h.setVisibility(8);
                        gVar3.f12466d.f7670w.setVisibility(8);
                        gVar3.f12466d.f7663p.setVisibility(0);
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        g gVar4 = this.f12458v;
                        gVar4.C.J = false;
                        gVar4.f12466d.f7662o.setVisibility(0);
                        gVar4.f12466d.f7656h.setVisibility(0);
                        gVar4.f12466d.f7670w.setVisibility(0);
                        gVar4.f12466d.f7663p.setVisibility(8);
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        g gVar5 = this.f12458v;
                        if (gVar5.f12475o) {
                            gVar5.f.O0(gVar5.f12478r);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_up_24px);
                            gVar5.f12475o = false;
                        } else {
                            o0 o0Var3 = gVar5.f;
                            o0Var3.S1();
                            gVar5.f12478r = o0Var3.f360t0;
                            gVar5.f.O0(0.0f);
                            gVar5.f12466d.f7664q.setImageResource(i.volume_off_24px);
                            gVar5.f12475o = true;
                        }
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        g gVar6 = this.f12458v;
                        boolean z10 = gVar6.f12485y;
                        gVar6.f12485y = !z10;
                        a aVar = gVar6.f12464b;
                        FloatingPlayer floatingPlayer = (FloatingPlayer) aVar.f12445u;
                        g gVar7 = (g) aVar.f12446v;
                        View view2 = (View) aVar.f12447w;
                        b2.g gVar8 = (b2.g) aVar.f12448x;
                        kc.e eVar = (kc.e) aVar.f12449y;
                        if (z10) {
                            LandscapeActivity landscapeActivity = floatingPlayer.f3689y.f3678v;
                            if (landscapeActivity != null) {
                                landscapeActivity.finish();
                            }
                            eVar.f7657j.setVisibility(0);
                            eVar.f7664q.setVisibility(0);
                            eVar.f7668u.setVisibility(0);
                            eVar.f7665r.setVisibility(8);
                            floatingPlayer.a();
                        } else {
                            ArrayList arrayList = floatingPlayer.f3686v;
                            for (int i102 = 0; i102 < arrayList.size(); i102++) {
                                View view3 = (View) arrayList.get(i102);
                                if (view3 != null) {
                                    view3.setVisibility(8);
                                    ((g) floatingPlayer.f3687w.get(i102)).d();
                                }
                            }
                            floatingPlayer.f3690z = gVar7;
                            floatingPlayer.A = view2;
                            floatingPlayer.B = gVar8;
                            floatingPlayer.C = eVar;
                            Intent intent = new Intent(floatingPlayer.getApplicationContext(), (Class<?>) LandscapeActivity.class);
                            intent.setFlags(268435456);
                            floatingPlayer.getApplicationContext().startActivity(intent);
                        }
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        this.f12458v.f12466d.f7657j.callOnClick();
                        break;
                    case 8:
                        g gVar9 = this.f12458v;
                        o0 o0Var4 = gVar9.f;
                        if (o0Var4 != null) {
                            if (gVar9.f12482v) {
                                gVar9.f(gVar9.f12470j, gVar9.f12471k, gVar9.f12472l, gVar9.f12473m, null);
                                gVar9.f12482v = false;
                            } else {
                                o0Var4.X();
                                gVar9.f12466d.f7660m.setVisibility(8);
                                gVar9.f12466d.f7659l.setVisibility(0);
                            }
                        }
                        break;
                    case 9:
                        g gVar10 = this.f12458v;
                        o0 o0Var5 = gVar10.f;
                        if (o0Var5 != null) {
                            o0Var5.f();
                            gVar10.f12466d.f7659l.setVisibility(8);
                            gVar10.f12466d.f7660m.setVisibility(0);
                        }
                        break;
                    default:
                        g gVar11 = this.f12458v;
                        if (gVar11.E) {
                            gVar11.C.J = false;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_unlock);
                            gVar11.f12466d.f7650a.setVisibility(0);
                            gVar11.f12466d.f7670w.setVisibility(0);
                            gVar11.f12466d.f7651b.setVisibility(0);
                            gVar11.f12466d.f7653d.setVisibility(0);
                            gVar11.f12466d.f7671x.setVisibility(0);
                            RecyclerView recyclerView = gVar11.f12468g;
                            if (recyclerView != null) {
                                recyclerView.setVisibility(0);
                            }
                            gVar11.E = false;
                        } else {
                            gVar11.C.J = true;
                            gVar11.f12466d.f7652c.setImageResource(i.ic_lock);
                            gVar11.f12466d.f7650a.setVisibility(8);
                            gVar11.f12466d.f7670w.setVisibility(8);
                            gVar11.f12466d.f7651b.setVisibility(8);
                            gVar11.f12466d.f7653d.setVisibility(8);
                            gVar11.f12466d.f7671x.setVisibility(8);
                            RecyclerView recyclerView2 = gVar11.f12468g;
                            if (recyclerView2 != null) {
                                recyclerView2.setVisibility(8);
                            }
                            gVar11.E = true;
                        }
                        break;
                }
            }
        });
        gc.g gVar = new gc.g((h.j) this.f12463a, (kc.b) this.f12465c.f1741g, this.f12467e, this.f);
        this.C = gVar;
        if (z2) {
            this.f12467e.setOnTouchListener(gVar);
        }
    }

    public final void k(String str, boolean z2) {
        if (this.f12465c == null) {
            return;
        }
        o0 o0Var = this.f;
        if (o0Var != null) {
            o0Var.F1();
        }
        kc.e eVar = this.f12466d;
        if (eVar != null) {
            eVar.f7672y.setText(this.f12474n);
            this.f12466d.f7671x.setText(this.f12474n);
        }
        if (z2) {
            ga.b.p(this.f12463a, ga.b.n(this.f12463a, str), new e(this, 0));
            return;
        }
        if (str.contains("[*]")) {
            ga.b.r(str, new e(this, 1));
            return;
        }
        try {
            if (!str.startsWith("[")) {
                str = qc.a.b(str);
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i = this.f12480t;
            if (length <= i) {
                i = 0;
            }
            oc.f fVarB = oc.f.b(jSONArray.getJSONObject(i));
            this.f12470j = fVarB.f9541v;
            this.f12471k = fVarB.f9542w;
            this.f12472l = fVarB.f9543x;
            this.f12473m = fVarB.f9544y;
            this.f12479s = fVarB.f9545z;
            this.f12477q = fVarB.A;
            if (jSONArray.length() > 1) {
                l(jSONArray);
            }
        } catch (JSONException e10) {
            Log.e("Pro", "JSONException", e10);
            Toast.makeText(this.f12463a, e10.toString(), 1).show();
            this.f12470j = "https://pro.com";
            this.f12471k = null;
            this.f12472l = null;
            this.f12473m = null;
            this.f12479s = 0;
        }
        f(this.f12470j, this.f12471k, this.f12472l, this.f12473m, null);
    }

    public final void l(JSONArray jSONArray) {
        this.B = new e(this, 2);
        ArrayList arrayListA = oc.f.a(jSONArray);
        this.i = arrayListA;
        p pVar = new p(this.f12463a, arrayListA, this.B);
        this.f12469h = pVar;
        pVar.f6539g = 0;
        RecyclerView recyclerView = new RecyclerView(this.f12463a, null);
        this.f12468g = recyclerView;
        recyclerView.setAdapter(this.f12469h);
        this.f12468g.setLayoutManager(new LinearLayoutManager(0));
        new Handler(Looper.getMainLooper()).postDelayed(new f(this, 0), 100L);
    }
}
