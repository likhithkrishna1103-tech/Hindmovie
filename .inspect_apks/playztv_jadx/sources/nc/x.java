package nc;

import a2.g0;
import a2.y0;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.decoder.DecoderInputBuffer;
import b7.s;
import h4.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import n.a1;
import n.q3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class x extends androidx.fragment.app.n {
    public c7.h H0;
    public String I0;
    public String J0;
    public String K0;
    public a1 L0;
    public w M0;
    public boolean N0;
    public int O0;
    public int P0 = 1;

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void B() {
        super.B();
        this.f1307x0 = false;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.setCancelable(false);
        }
    }

    @Override // androidx.fragment.app.v
    public final void D() {
        String str;
        ((TextView) this.H0.i).setText("Update " + m().getString(gc.o.app_name) + " App");
        if (TextUtils.isEmpty(this.K0) || "null".equals(this.K0)) {
            str = "";
        } else {
            try {
                str = new String(Base64.decode(this.K0.getBytes(), 0));
            } catch (Exception unused) {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("no")) {
            ((TextView) this.H0.f2544a).setVisibility(8);
        } else {
            ((TextView) this.H0.f2544a).setText(str);
            ((TextView) this.H0.f2544a).setVisibility(0);
        }
        if (this.P0 == 0) {
            ((Button) this.H0.f2546c).setVisibility(0);
            final int i = 0;
            ((Button) this.H0.f2546c).setOnClickListener(new View.OnClickListener(this) { // from class: nc.v

                /* JADX INFO: renamed from: v, reason: collision with root package name */
                public final /* synthetic */ x f8979v;

                {
                    this.f8979v = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q3 q3Var;
                    switch (i) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            x xVar = this.f8979v;
                            if (!xVar.N0) {
                                ((Button) xVar.H0.f2551j).setVisibility(8);
                                ((Button) xVar.H0.f2549g).setVisibility(8);
                                ((Button) xVar.H0.f2546c).setVisibility(8);
                                xVar.M0.c();
                                return;
                            }
                            a1 a1Var = xVar.L0;
                            Context contextJ = xVar.j();
                            a1 a1Var2 = xVar.L0;
                            Context contextH = xVar.H();
                            String str2 = xVar.J0;
                            a1Var2.getClass();
                            File fileT = a1.t(contextH, str2);
                            a1Var.getClass();
                            a1.v(contextJ, fileT);
                            return;
                        case 1:
                            x xVar2 = this.f8979v;
                            try {
                                xVar2.O(new Intent("android.intent.action.VIEW", Uri.parse(xVar2.I0)));
                                return;
                            } catch (ActivityNotFoundException e10) {
                                Toast.makeText(xVar2.j(), e10.getMessage(), 1).show();
                                return;
                            }
                        default:
                            x xVar3 = this.f8979v;
                            if (xVar3.L0 == null) {
                                a1 a1Var3 = new a1();
                                xVar3.L0 = a1Var3;
                                Context contextJ2 = xVar3.j();
                                be.h.e(contextJ2, "context");
                                Context applicationContext = contextJ2.getApplicationContext();
                                yc.e eVar = hd.a.f6074h;
                                yc.f fVar = hd.a.f6069b;
                                id.h hVar = hd.a.f6075j;
                                yc.d dVar = hd.a.i;
                                be.h.d(applicationContext, "appContext");
                                z zVar = new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                                yc.h hVar2 = hd.a.f;
                                if (hVar != null) {
                                    hVar.getClass();
                                    if (hVar.f6578a.equals("fetch2")) {
                                        hVar.f6578a = "LibGlobalFetchLib";
                                    }
                                } else {
                                    hVar.getClass();
                                }
                                yc.c cVar = new yc.c(applicationContext, eVar, fVar, hVar, dVar, zVar, hVar2);
                                synchronized (dd.j.f4165a) {
                                    try {
                                        LinkedHashMap linkedHashMap = dd.j.f4166b;
                                        dd.i iVar = (dd.i) linkedHashMap.get("LibGlobalFetchLib");
                                        if (iVar != null) {
                                            q3Var = new q3(cVar, iVar.f4158a, iVar.f4159b, iVar.f4160c, iVar.f4161d, iVar.f4162e, iVar.f, iVar.f4163g);
                                        } else {
                                            id.k kVar = new id.k();
                                            com.bumptech.glide.manager.e eVar2 = new com.bumptech.glide.manager.e(1);
                                            zc.g gVar = new zc.g(new zc.f(applicationContext, hVar, new ad.a[]{new ad.a(1, 2, 2), new ad.a(2, 3, 5), new ad.a(3, 4, 4), new ad.a(4, 5, 1), new ad.a(5, 6, 0), new ad.a(6, 7, 3)}, eVar2, new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                            ed.a aVar = new ed.a(gVar);
                                            z zVar2 = new z(4);
                                            a7.b bVar = new a7.b(aVar);
                                            Handler handler = dd.j.f4167c;
                                            b7.s sVar = new b7.s(bVar, aVar, handler);
                                            q3Var = new q3(cVar, kVar, gVar, aVar, bVar, handler, zVar2, sVar);
                                            linkedHashMap.put("LibGlobalFetchLib", new dd.i(kVar, gVar, aVar, bVar, handler, zVar2, sVar, (c2.x) q3Var.f8512z));
                                        }
                                        ((id.k) q3Var.f8508v).c();
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                yc.c cVar2 = (yc.c) q3Var.f8507u;
                                a1Var3.f8343u = new dd.h(cVar2, (id.k) q3Var.f8508v, (Handler) q3Var.f8510x, (dd.a) q3Var.A, cVar2.f14657d, (b7.s) q3Var.f8511y, (zc.g) q3Var.f8509w);
                                xVar3.L0.C(new wb.c(29, xVar3));
                                xVar3.S();
                            } else {
                                xVar3.S();
                            }
                            ((LinearLayout) xVar3.H0.f2548e).setVisibility(0);
                            return;
                    }
                }
            });
        } else {
            ((Button) this.H0.f2546c).setVisibility(8);
        }
        final int i10 = 1;
        ((Button) this.H0.f2551j).setOnClickListener(new View.OnClickListener(this) { // from class: nc.v

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ x f8979v;

            {
                this.f8979v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q3 q3Var;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f8979v;
                        if (!xVar.N0) {
                            ((Button) xVar.H0.f2551j).setVisibility(8);
                            ((Button) xVar.H0.f2549g).setVisibility(8);
                            ((Button) xVar.H0.f2546c).setVisibility(8);
                            xVar.M0.c();
                            return;
                        }
                        a1 a1Var = xVar.L0;
                        Context contextJ = xVar.j();
                        a1 a1Var2 = xVar.L0;
                        Context contextH = xVar.H();
                        String str2 = xVar.J0;
                        a1Var2.getClass();
                        File fileT = a1.t(contextH, str2);
                        a1Var.getClass();
                        a1.v(contextJ, fileT);
                        return;
                    case 1:
                        x xVar2 = this.f8979v;
                        try {
                            xVar2.O(new Intent("android.intent.action.VIEW", Uri.parse(xVar2.I0)));
                            return;
                        } catch (ActivityNotFoundException e10) {
                            Toast.makeText(xVar2.j(), e10.getMessage(), 1).show();
                            return;
                        }
                    default:
                        x xVar3 = this.f8979v;
                        if (xVar3.L0 == null) {
                            a1 a1Var3 = new a1();
                            xVar3.L0 = a1Var3;
                            Context contextJ2 = xVar3.j();
                            be.h.e(contextJ2, "context");
                            Context applicationContext = contextJ2.getApplicationContext();
                            yc.e eVar = hd.a.f6074h;
                            yc.f fVar = hd.a.f6069b;
                            id.h hVar = hd.a.f6075j;
                            yc.d dVar = hd.a.i;
                            be.h.d(applicationContext, "appContext");
                            z zVar = new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                            yc.h hVar2 = hd.a.f;
                            if (hVar != null) {
                                hVar.getClass();
                                if (hVar.f6578a.equals("fetch2")) {
                                    hVar.f6578a = "LibGlobalFetchLib";
                                }
                            } else {
                                hVar.getClass();
                            }
                            yc.c cVar = new yc.c(applicationContext, eVar, fVar, hVar, dVar, zVar, hVar2);
                            synchronized (dd.j.f4165a) {
                                try {
                                    LinkedHashMap linkedHashMap = dd.j.f4166b;
                                    dd.i iVar = (dd.i) linkedHashMap.get("LibGlobalFetchLib");
                                    if (iVar != null) {
                                        q3Var = new q3(cVar, iVar.f4158a, iVar.f4159b, iVar.f4160c, iVar.f4161d, iVar.f4162e, iVar.f, iVar.f4163g);
                                    } else {
                                        id.k kVar = new id.k();
                                        com.bumptech.glide.manager.e eVar2 = new com.bumptech.glide.manager.e(1);
                                        zc.g gVar = new zc.g(new zc.f(applicationContext, hVar, new ad.a[]{new ad.a(1, 2, 2), new ad.a(2, 3, 5), new ad.a(3, 4, 4), new ad.a(4, 5, 1), new ad.a(5, 6, 0), new ad.a(6, 7, 3)}, eVar2, new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                        ed.a aVar = new ed.a(gVar);
                                        z zVar2 = new z(4);
                                        a7.b bVar = new a7.b(aVar);
                                        Handler handler = dd.j.f4167c;
                                        b7.s sVar = new b7.s(bVar, aVar, handler);
                                        q3Var = new q3(cVar, kVar, gVar, aVar, bVar, handler, zVar2, sVar);
                                        linkedHashMap.put("LibGlobalFetchLib", new dd.i(kVar, gVar, aVar, bVar, handler, zVar2, sVar, (c2.x) q3Var.f8512z));
                                    }
                                    ((id.k) q3Var.f8508v).c();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            yc.c cVar2 = (yc.c) q3Var.f8507u;
                            a1Var3.f8343u = new dd.h(cVar2, (id.k) q3Var.f8508v, (Handler) q3Var.f8510x, (dd.a) q3Var.A, cVar2.f14657d, (b7.s) q3Var.f8511y, (zc.g) q3Var.f8509w);
                            xVar3.L0.C(new wb.c(29, xVar3));
                            xVar3.S();
                        } else {
                            xVar3.S();
                        }
                        ((LinearLayout) xVar3.H0.f2548e).setVisibility(0);
                        return;
                }
            }
        });
        final int i11 = 2;
        ((Button) this.H0.f2549g).setOnClickListener(new View.OnClickListener(this) { // from class: nc.v

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ x f8979v;

            {
                this.f8979v = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q3 q3Var;
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        x xVar = this.f8979v;
                        if (!xVar.N0) {
                            ((Button) xVar.H0.f2551j).setVisibility(8);
                            ((Button) xVar.H0.f2549g).setVisibility(8);
                            ((Button) xVar.H0.f2546c).setVisibility(8);
                            xVar.M0.c();
                            return;
                        }
                        a1 a1Var = xVar.L0;
                        Context contextJ = xVar.j();
                        a1 a1Var2 = xVar.L0;
                        Context contextH = xVar.H();
                        String str2 = xVar.J0;
                        a1Var2.getClass();
                        File fileT = a1.t(contextH, str2);
                        a1Var.getClass();
                        a1.v(contextJ, fileT);
                        return;
                    case 1:
                        x xVar2 = this.f8979v;
                        try {
                            xVar2.O(new Intent("android.intent.action.VIEW", Uri.parse(xVar2.I0)));
                            return;
                        } catch (ActivityNotFoundException e10) {
                            Toast.makeText(xVar2.j(), e10.getMessage(), 1).show();
                            return;
                        }
                    default:
                        x xVar3 = this.f8979v;
                        if (xVar3.L0 == null) {
                            a1 a1Var3 = new a1();
                            xVar3.L0 = a1Var3;
                            Context contextJ2 = xVar3.j();
                            be.h.e(contextJ2, "context");
                            Context applicationContext = contextJ2.getApplicationContext();
                            yc.e eVar = hd.a.f6074h;
                            yc.f fVar = hd.a.f6069b;
                            id.h hVar = hd.a.f6075j;
                            yc.d dVar = hd.a.i;
                            be.h.d(applicationContext, "appContext");
                            z zVar = new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                            yc.h hVar2 = hd.a.f;
                            if (hVar != null) {
                                hVar.getClass();
                                if (hVar.f6578a.equals("fetch2")) {
                                    hVar.f6578a = "LibGlobalFetchLib";
                                }
                            } else {
                                hVar.getClass();
                            }
                            yc.c cVar = new yc.c(applicationContext, eVar, fVar, hVar, dVar, zVar, hVar2);
                            synchronized (dd.j.f4165a) {
                                try {
                                    LinkedHashMap linkedHashMap = dd.j.f4166b;
                                    dd.i iVar = (dd.i) linkedHashMap.get("LibGlobalFetchLib");
                                    if (iVar != null) {
                                        q3Var = new q3(cVar, iVar.f4158a, iVar.f4159b, iVar.f4160c, iVar.f4161d, iVar.f4162e, iVar.f, iVar.f4163g);
                                    } else {
                                        id.k kVar = new id.k();
                                        com.bumptech.glide.manager.e eVar2 = new com.bumptech.glide.manager.e(1);
                                        zc.g gVar = new zc.g(new zc.f(applicationContext, hVar, new ad.a[]{new ad.a(1, 2, 2), new ad.a(2, 3, 5), new ad.a(3, 4, 4), new ad.a(4, 5, 1), new ad.a(5, 6, 0), new ad.a(6, 7, 3)}, eVar2, new z(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                        ed.a aVar = new ed.a(gVar);
                                        z zVar2 = new z(4);
                                        a7.b bVar = new a7.b(aVar);
                                        Handler handler = dd.j.f4167c;
                                        b7.s sVar = new b7.s(bVar, aVar, handler);
                                        q3Var = new q3(cVar, kVar, gVar, aVar, bVar, handler, zVar2, sVar);
                                        linkedHashMap.put("LibGlobalFetchLib", new dd.i(kVar, gVar, aVar, bVar, handler, zVar2, sVar, (c2.x) q3Var.f8512z));
                                    }
                                    ((id.k) q3Var.f8508v).c();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            yc.c cVar2 = (yc.c) q3Var.f8507u;
                            a1Var3.f8343u = new dd.h(cVar2, (id.k) q3Var.f8508v, (Handler) q3Var.f8510x, (dd.a) q3Var.A, cVar2.f14657d, (b7.s) q3Var.f8511y, (zc.g) q3Var.f8509w);
                            xVar3.L0.C(new wb.c(29, xVar3));
                            xVar3.S();
                        } else {
                            xVar3.S();
                        }
                        ((LinearLayout) xVar3.H0.f2548e).setVisibility(0);
                        return;
                }
            }
        });
        ((LinearLayout) this.H0.f2548e).setVisibility(8);
    }

    public final void S() {
        a1 a1Var = this.L0;
        Context contextJ = j();
        String str = this.J0;
        a1Var.getClass();
        yc.j jVar = new yc.j(str, a1.t(contextJ, str).getAbsolutePath());
        jVar.f14684x = yc.g.f14673w;
        jVar.f14685y = yc.f.f14668x;
        final dd.h hVar = (dd.h) a1Var.f8343u;
        ia.b bVar = new ia.b(23);
        final ia.b bVar2 = new ia.b(23);
        hVar.getClass();
        final List listG = android.support.v4.media.session.b.G(jVar);
        final dd.e eVar = new dd.e(hVar, bVar2, bVar, 0);
        synchronized (hVar.f) {
            ((id.k) hVar.f4151a).d(new ae.a() { // from class: dd.f
                @Override // ae.a
                public final Object b() {
                    ArrayList arrayList;
                    List list = listG;
                    h hVar2 = hVar;
                    e eVar2 = eVar;
                    try {
                        HashSet hashSet = new HashSet();
                        arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (hashSet.add(((yc.j) obj).F)) {
                                arrayList.add(obj);
                            }
                        }
                    } catch (Exception e10) {
                        ((id.h) hVar2.f4154d).getClass();
                        be.h.e("Failed to enqueue list " + list, "message");
                        ((Handler) hVar2.f4152b).post(new c(bVar2, b8.h.k(e10.getMessage())));
                    }
                    if (arrayList.size() != list.size()) {
                        throw new y0("request_list_not_distinct");
                    }
                    a aVar = (a) hVar2.f4153c;
                    id.h hVar3 = (id.h) hVar2.f4154d;
                    p pVar = (p) ((s) hVar2.f4155e).i;
                    ArrayList arrayListV = aVar.v(list);
                    int size = arrayListV.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayListV.get(i);
                        i++;
                        zc.e eVar3 = (zc.e) ((nd.f) obj2).f8983u;
                        int iOrdinal = eVar3.D.ordinal();
                        if (iOrdinal == 1) {
                            zc.e eVar4 = new zc.e();
                            z7.a.F(eVar3, eVar4);
                            eVar4.D = yc.k.F;
                            pVar.a(eVar4);
                            hVar3.b("Added " + eVar3);
                            pVar.h(eVar3, false);
                            hVar3.b("Queued " + eVar3 + " for download");
                        } else if (iOrdinal == 4) {
                            pVar.c(eVar3);
                            hVar3.b("Completed download " + eVar3);
                        } else if (iOrdinal == 9) {
                            pVar.a(eVar3);
                            hVar3.b("Added " + eVar3);
                        }
                    }
                    ((Handler) hVar2.f4152b).post(new g0(eVar2, 12, arrayListV));
                    return nd.k.f8990a;
                }
            });
        }
    }

    @Override // androidx.fragment.app.n, androidx.fragment.app.v
    public final void v(Bundle bundle) {
        super.v(bundle);
        vc.c cVar = (vc.c) new a7.b(G()).s(vc.c.class);
        this.I0 = cVar.f;
        this.J0 = cVar.f13491e;
        this.K0 = cVar.f13493h;
        this.O0 = cVar.i;
        this.M0 = cVar.f13490d;
        String str = cVar.f13492g;
        if (str == null) {
            return;
        }
        try {
            for (String str2 : str.split(",")) {
                if (Integer.parseInt(str2.trim()) == this.O0) {
                    this.P0 = 0;
                    return;
                }
            }
        } catch (IllegalArgumentException unused) {
            this.P0 = 1;
        }
    }

    @Override // androidx.fragment.app.v
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(gc.k.fragment_update, (ViewGroup) null, false);
        int i = gc.j.changelog_txt;
        TextView textView = (TextView) z7.a.k(viewInflate, i);
        if (textView != null) {
            i = gc.j.close_btn;
            if (((ImageButton) z7.a.k(viewInflate, i)) != null) {
                i = gc.j.download_progress;
                ProgressBar progressBar = (ProgressBar) z7.a.k(viewInflate, i);
                if (progressBar != null) {
                    i = gc.j.later_btn;
                    Button button = (Button) z7.a.k(viewInflate, i);
                    if (button != null) {
                        i = gc.j.message_txt_update;
                        if (((TextView) z7.a.k(viewInflate, i)) != null) {
                            i = gc.j.percent_txt;
                            TextView textView2 = (TextView) z7.a.k(viewInflate, i);
                            if (textView2 != null) {
                                i = gc.j.progress_container;
                                LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
                                if (linearLayout != null) {
                                    i = gc.j.size_txt;
                                    TextView textView3 = (TextView) z7.a.k(viewInflate, i);
                                    if (textView3 != null) {
                                        i = gc.j.update_btn;
                                        Button button2 = (Button) z7.a.k(viewInflate, i);
                                        if (button2 != null) {
                                            i = gc.j.update_container;
                                            LinearLayout linearLayout2 = (LinearLayout) z7.a.k(viewInflate, i);
                                            if (linearLayout2 != null) {
                                                i = gc.j.update_ly;
                                                if (((LinearLayout) z7.a.k(viewInflate, i)) != null) {
                                                    i = gc.j.update_txt;
                                                    TextView textView4 = (TextView) z7.a.k(viewInflate, i);
                                                    if (textView4 != null) {
                                                        i = gc.j.web_btn;
                                                        Button button3 = (Button) z7.a.k(viewInflate, i);
                                                        if (button3 != null) {
                                                            FrameLayout frameLayout = (FrameLayout) viewInflate;
                                                            c7.h hVar = new c7.h();
                                                            hVar.f2544a = textView;
                                                            hVar.f2545b = progressBar;
                                                            hVar.f2546c = button;
                                                            hVar.f2547d = textView2;
                                                            hVar.f2548e = linearLayout;
                                                            hVar.f = textView3;
                                                            hVar.f2549g = button2;
                                                            hVar.f2550h = linearLayout2;
                                                            hVar.i = textView4;
                                                            hVar.f2551j = button3;
                                                            this.H0 = hVar;
                                                            return frameLayout;
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
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
