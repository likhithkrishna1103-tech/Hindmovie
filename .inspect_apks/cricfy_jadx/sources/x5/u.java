package x5;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.emoji2.text.v;
import androidx.fragment.app.y;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.z3;
import i2.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import l4.c0;
import o.t3;
import v1.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class u extends y {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public hd.e f14384s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public String f14385t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public String f14386u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public l4.a f14387v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public t f14388w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f14389x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f14390y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f14391z0 = 1;

    @Override // androidx.fragment.app.y
    public final void G(View view) {
        if (this.f14391z0 == 0) {
            ((Button) this.f14384s0.f5927c).setVisibility(0);
            final int i = 0;
            ((Button) this.f14384s0.f5927c).setOnClickListener(new View.OnClickListener(this) { // from class: x5.s

                /* JADX INFO: renamed from: w, reason: collision with root package name */
                public final /* synthetic */ u f14383w;

                {
                    this.f14383w = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    t3 t3Var;
                    switch (i) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u uVar = this.f14383w;
                            if (!uVar.f14389x0) {
                                ((Button) uVar.f14384s0.f5931h).setVisibility(8);
                                ((Button) uVar.f14384s0.f5930g).setVisibility(8);
                                ((Button) uVar.f14384s0.f5927c).setVisibility(8);
                                uVar.f14388w0.a();
                                return;
                            }
                            l4.a aVar = uVar.f14387v0;
                            Context contextJ = uVar.j();
                            l4.a aVar2 = uVar.f14387v0;
                            Context contextK = uVar.K();
                            String str = uVar.f14386u0;
                            aVar2.getClass();
                            File fileS = l4.a.s(contextK, str);
                            aVar.getClass();
                            l4.a.A(contextJ, fileS);
                            return;
                        case 1:
                            u uVar2 = this.f14383w;
                            try {
                                uVar2.Q(new Intent("android.intent.action.VIEW", Uri.parse(uVar2.f14385t0)));
                                return;
                            } catch (ActivityNotFoundException | IllegalArgumentException | NullPointerException | SecurityException e9) {
                                Toast.makeText(uVar2.j(), e9.getMessage(), 1).show();
                                return;
                            }
                        default:
                            u uVar3 = this.f14383w;
                            if (uVar3.f14387v0 == null) {
                                l4.a aVar3 = new l4.a();
                                uVar3.f14387v0 = aVar3;
                                Context contextJ2 = uVar3.j();
                                ge.i.e(contextJ2, "context");
                                Context applicationContext = contextJ2.getApplicationContext();
                                cd.f fVar = ld.a.f7954h;
                                cd.g gVar = ld.a.f7949b;
                                d5.a aVar4 = ld.a.f7955j;
                                cd.d dVar = ld.a.i;
                                ge.i.d(applicationContext, "appContext");
                                i2.k kVar = new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                                cd.i iVar = ld.a.f;
                                if (aVar4 != null) {
                                    aVar4.getClass();
                                    if (aVar4.f3391w.equals("fetch2")) {
                                        aVar4.f3391w = "LibGlobalFetchLib";
                                    }
                                } else {
                                    aVar4.getClass();
                                }
                                cd.c cVar = new cd.c(applicationContext, fVar, gVar, aVar4, dVar, kVar, iVar);
                                synchronized (hd.g.f5939a) {
                                    try {
                                        LinkedHashMap linkedHashMap = hd.g.f5940b;
                                        hd.f fVar2 = (hd.f) linkedHashMap.get("LibGlobalFetchLib");
                                        if (fVar2 != null) {
                                            t3Var = new t3(cVar, fVar2.f5932a, fVar2.f5933b, fVar2.f5934c, fVar2.f5935d, fVar2.f5936e, fVar2.f, fVar2.f5937g);
                                        } else {
                                            md.j jVar = new md.j();
                                            com.bumptech.glide.manager.e eVar = new com.bumptech.glide.manager.e(1);
                                            dd.g gVar2 = new dd.g(new dd.f(applicationContext, aVar4, new ed.a[]{new ed.a(1, 2, 2), new ed.a(2, 3, 5), new ed.a(3, 4, 4), new ed.a(4, 5, 1), new ed.a(5, 6, 0), new ed.a(6, 7, 3)}, eVar, new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                            id.a aVar5 = new id.a(gVar2);
                                            c0 c0Var = new c0(21);
                                            v vVar = new v(aVar5);
                                            Handler handler = hd.g.f5941c;
                                            d8.j jVar2 = new d8.j(vVar, aVar5, handler);
                                            t3Var = new t3(cVar, jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2);
                                            linkedHashMap.put("LibGlobalFetchLib", new hd.f(jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2, (x) t3Var.A));
                                        }
                                        ((md.j) t3Var.f9368w).c();
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                cd.c cVar2 = (cd.c) t3Var.f9367v;
                                aVar3.f7697v = new hd.e(cVar2, (md.j) t3Var.f9368w, (Handler) t3Var.f9370y, (hd.a) t3Var.B, cVar2.f2158d, (d8.j) t3Var.f9371z, (dd.g) t3Var.f9369x);
                                uVar3.f14387v0.H(new l4.a(uVar3));
                                uVar3.R();
                            } else {
                                uVar3.R();
                            }
                            ((LinearLayout) uVar3.f14384s0.f5925a).setVisibility(0);
                            return;
                    }
                }
            });
        } else {
            ((Button) this.f14384s0.f5927c).setVisibility(8);
        }
        final int i10 = 1;
        ((Button) this.f14384s0.f5931h).setOnClickListener(new View.OnClickListener(this) { // from class: x5.s

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ u f14383w;

            {
                this.f14383w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                t3 t3Var;
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        u uVar = this.f14383w;
                        if (!uVar.f14389x0) {
                            ((Button) uVar.f14384s0.f5931h).setVisibility(8);
                            ((Button) uVar.f14384s0.f5930g).setVisibility(8);
                            ((Button) uVar.f14384s0.f5927c).setVisibility(8);
                            uVar.f14388w0.a();
                            return;
                        }
                        l4.a aVar = uVar.f14387v0;
                        Context contextJ = uVar.j();
                        l4.a aVar2 = uVar.f14387v0;
                        Context contextK = uVar.K();
                        String str = uVar.f14386u0;
                        aVar2.getClass();
                        File fileS = l4.a.s(contextK, str);
                        aVar.getClass();
                        l4.a.A(contextJ, fileS);
                        return;
                    case 1:
                        u uVar2 = this.f14383w;
                        try {
                            uVar2.Q(new Intent("android.intent.action.VIEW", Uri.parse(uVar2.f14385t0)));
                            return;
                        } catch (ActivityNotFoundException | IllegalArgumentException | NullPointerException | SecurityException e9) {
                            Toast.makeText(uVar2.j(), e9.getMessage(), 1).show();
                            return;
                        }
                    default:
                        u uVar3 = this.f14383w;
                        if (uVar3.f14387v0 == null) {
                            l4.a aVar3 = new l4.a();
                            uVar3.f14387v0 = aVar3;
                            Context contextJ2 = uVar3.j();
                            ge.i.e(contextJ2, "context");
                            Context applicationContext = contextJ2.getApplicationContext();
                            cd.f fVar = ld.a.f7954h;
                            cd.g gVar = ld.a.f7949b;
                            d5.a aVar4 = ld.a.f7955j;
                            cd.d dVar = ld.a.i;
                            ge.i.d(applicationContext, "appContext");
                            i2.k kVar = new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                            cd.i iVar = ld.a.f;
                            if (aVar4 != null) {
                                aVar4.getClass();
                                if (aVar4.f3391w.equals("fetch2")) {
                                    aVar4.f3391w = "LibGlobalFetchLib";
                                }
                            } else {
                                aVar4.getClass();
                            }
                            cd.c cVar = new cd.c(applicationContext, fVar, gVar, aVar4, dVar, kVar, iVar);
                            synchronized (hd.g.f5939a) {
                                try {
                                    LinkedHashMap linkedHashMap = hd.g.f5940b;
                                    hd.f fVar2 = (hd.f) linkedHashMap.get("LibGlobalFetchLib");
                                    if (fVar2 != null) {
                                        t3Var = new t3(cVar, fVar2.f5932a, fVar2.f5933b, fVar2.f5934c, fVar2.f5935d, fVar2.f5936e, fVar2.f, fVar2.f5937g);
                                    } else {
                                        md.j jVar = new md.j();
                                        com.bumptech.glide.manager.e eVar = new com.bumptech.glide.manager.e(1);
                                        dd.g gVar2 = new dd.g(new dd.f(applicationContext, aVar4, new ed.a[]{new ed.a(1, 2, 2), new ed.a(2, 3, 5), new ed.a(3, 4, 4), new ed.a(4, 5, 1), new ed.a(5, 6, 0), new ed.a(6, 7, 3)}, eVar, new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                        id.a aVar5 = new id.a(gVar2);
                                        c0 c0Var = new c0(21);
                                        v vVar = new v(aVar5);
                                        Handler handler = hd.g.f5941c;
                                        d8.j jVar2 = new d8.j(vVar, aVar5, handler);
                                        t3Var = new t3(cVar, jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2);
                                        linkedHashMap.put("LibGlobalFetchLib", new hd.f(jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2, (x) t3Var.A));
                                    }
                                    ((md.j) t3Var.f9368w).c();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            cd.c cVar2 = (cd.c) t3Var.f9367v;
                            aVar3.f7697v = new hd.e(cVar2, (md.j) t3Var.f9368w, (Handler) t3Var.f9370y, (hd.a) t3Var.B, cVar2.f2158d, (d8.j) t3Var.f9371z, (dd.g) t3Var.f9369x);
                            uVar3.f14387v0.H(new l4.a(uVar3));
                            uVar3.R();
                        } else {
                            uVar3.R();
                        }
                        ((LinearLayout) uVar3.f14384s0.f5925a).setVisibility(0);
                        return;
                }
            }
        });
        final int i11 = 2;
        ((Button) this.f14384s0.f5930g).setOnClickListener(new View.OnClickListener(this) { // from class: x5.s

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ u f14383w;

            {
                this.f14383w = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                t3 t3Var;
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        u uVar = this.f14383w;
                        if (!uVar.f14389x0) {
                            ((Button) uVar.f14384s0.f5931h).setVisibility(8);
                            ((Button) uVar.f14384s0.f5930g).setVisibility(8);
                            ((Button) uVar.f14384s0.f5927c).setVisibility(8);
                            uVar.f14388w0.a();
                            return;
                        }
                        l4.a aVar = uVar.f14387v0;
                        Context contextJ = uVar.j();
                        l4.a aVar2 = uVar.f14387v0;
                        Context contextK = uVar.K();
                        String str = uVar.f14386u0;
                        aVar2.getClass();
                        File fileS = l4.a.s(contextK, str);
                        aVar.getClass();
                        l4.a.A(contextJ, fileS);
                        return;
                    case 1:
                        u uVar2 = this.f14383w;
                        try {
                            uVar2.Q(new Intent("android.intent.action.VIEW", Uri.parse(uVar2.f14385t0)));
                            return;
                        } catch (ActivityNotFoundException | IllegalArgumentException | NullPointerException | SecurityException e9) {
                            Toast.makeText(uVar2.j(), e9.getMessage(), 1).show();
                            return;
                        }
                    default:
                        u uVar3 = this.f14383w;
                        if (uVar3.f14387v0 == null) {
                            l4.a aVar3 = new l4.a();
                            uVar3.f14387v0 = aVar3;
                            Context contextJ2 = uVar3.j();
                            ge.i.e(contextJ2, "context");
                            Context applicationContext = contextJ2.getApplicationContext();
                            cd.f fVar = ld.a.f7954h;
                            cd.g gVar = ld.a.f7949b;
                            d5.a aVar4 = ld.a.f7955j;
                            cd.d dVar = ld.a.i;
                            ge.i.d(applicationContext, "appContext");
                            i2.k kVar = new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp");
                            cd.i iVar = ld.a.f;
                            if (aVar4 != null) {
                                aVar4.getClass();
                                if (aVar4.f3391w.equals("fetch2")) {
                                    aVar4.f3391w = "LibGlobalFetchLib";
                                }
                            } else {
                                aVar4.getClass();
                            }
                            cd.c cVar = new cd.c(applicationContext, fVar, gVar, aVar4, dVar, kVar, iVar);
                            synchronized (hd.g.f5939a) {
                                try {
                                    LinkedHashMap linkedHashMap = hd.g.f5940b;
                                    hd.f fVar2 = (hd.f) linkedHashMap.get("LibGlobalFetchLib");
                                    if (fVar2 != null) {
                                        t3Var = new t3(cVar, fVar2.f5932a, fVar2.f5933b, fVar2.f5934c, fVar2.f5935d, fVar2.f5936e, fVar2.f, fVar2.f5937g);
                                    } else {
                                        md.j jVar = new md.j();
                                        com.bumptech.glide.manager.e eVar = new com.bumptech.glide.manager.e(1);
                                        dd.g gVar2 = new dd.g(new dd.f(applicationContext, aVar4, new ed.a[]{new ed.a(1, 2, 2), new ed.a(2, 3, 5), new ed.a(3, 4, 4), new ed.a(4, 5, 1), new ed.a(5, 6, 0), new ed.a(6, 7, 3)}, eVar, new i2.k(applicationContext, applicationContext.getFilesDir().getAbsoluteFile() + "/_fetchData/temp")));
                                        id.a aVar5 = new id.a(gVar2);
                                        c0 c0Var = new c0(21);
                                        v vVar = new v(aVar5);
                                        Handler handler = hd.g.f5941c;
                                        d8.j jVar2 = new d8.j(vVar, aVar5, handler);
                                        t3Var = new t3(cVar, jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2);
                                        linkedHashMap.put("LibGlobalFetchLib", new hd.f(jVar, gVar2, aVar5, vVar, handler, c0Var, jVar2, (x) t3Var.A));
                                    }
                                    ((md.j) t3Var.f9368w).c();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            cd.c cVar2 = (cd.c) t3Var.f9367v;
                            aVar3.f7697v = new hd.e(cVar2, (md.j) t3Var.f9368w, (Handler) t3Var.f9370y, (hd.a) t3Var.B, cVar2.f2158d, (d8.j) t3Var.f9371z, (dd.g) t3Var.f9369x);
                            uVar3.f14387v0.H(new l4.a(uVar3));
                            uVar3.R();
                        } else {
                            uVar3.R();
                        }
                        ((LinearLayout) uVar3.f14384s0.f5925a).setVisibility(0);
                        return;
                }
            }
        });
        ((LinearLayout) this.f14384s0.f5925a).setVisibility(8);
    }

    public final void R() {
        l4.a aVar = this.f14387v0;
        Context contextJ = j();
        String str = this.f14386u0;
        aVar.getClass();
        if (contextJ == null || str == null) {
            return;
        }
        cd.k kVar = new cd.k(str, l4.a.s(contextJ, str).getAbsolutePath());
        kVar.f2183y = cd.h.f2173x;
        kVar.f2184z = cd.g.f2169y;
        final hd.e eVar = (hd.e) aVar.f7697v;
        b0 b0Var = new b0(19);
        final b0 b0Var2 = new b0(19);
        eVar.getClass();
        final List listX = n5.a.x(kVar);
        final c8.b bVar = new c8.b(eVar, b0Var2, b0Var, 4);
        synchronized (eVar.f) {
            ((md.j) eVar.f5925a).d(new fe.a() { // from class: hd.c
                @Override // fe.a
                public final Object b() {
                    ArrayList arrayList;
                    List list = listX;
                    e eVar2 = eVar;
                    c8.b bVar2 = bVar;
                    try {
                        HashSet hashSet = new HashSet();
                        arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (hashSet.add(((cd.k) obj).G)) {
                                arrayList.add(obj);
                            }
                        }
                    } catch (Exception e9) {
                        ((d5.a) eVar2.f5928d).getClass();
                        ge.i.e("Failed to enqueue list " + list, "message");
                        ((Handler) eVar2.f5926b).post(new d8.a(b0Var2, com.bumptech.glide.c.m(e9.getMessage())));
                    }
                    if (arrayList.size() != list.size()) {
                        throw new a9.l("request_list_not_distinct");
                    }
                    a aVar2 = (a) eVar2.f5927c;
                    d5.a aVar3 = (d5.a) eVar2.f5928d;
                    l lVar = (l) ((d8.j) eVar2.f5929e).i;
                    ArrayList arrayListQ = aVar2.q(list);
                    int size = arrayListQ.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayListQ.get(i);
                        i++;
                        dd.e eVar3 = (dd.e) ((rd.f) obj2).f10993v;
                        int iOrdinal = eVar3.E.ordinal();
                        if (iOrdinal == 1) {
                            dd.e eVar4 = new dd.e();
                            z3.x(eVar3, eVar4);
                            eVar4.E = cd.l.G;
                            lVar.e(eVar4);
                            aVar3.b("Added " + eVar3);
                            lVar.f(eVar3, false);
                            aVar3.b("Queued " + eVar3 + " for download");
                        } else if (iOrdinal == 4) {
                            lVar.b(eVar3);
                            aVar3.b("Completed download " + eVar3);
                        } else if (iOrdinal == 9) {
                            lVar.e(eVar3);
                            aVar3.b("Added " + eVar3);
                        }
                    }
                    ((Handler) eVar2.f5926b).post(new androidx.fragment.app.d(bVar2, arrayListQ));
                    return rd.l.f11003a;
                }
            });
        }
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        f6.c cVar = (f6.c) new v(J()).r(f6.c.class);
        this.f14385t0 = cVar.f;
        this.f14386u0 = cVar.f3981e;
        this.f14390y0 = cVar.f3983h;
        this.f14388w0 = cVar.f3980d;
        String str = cVar.f3982g;
        if (str == null) {
            return;
        }
        try {
            for (String str2 : str.split(",")) {
                if (Integer.parseInt(str2.trim()) == this.f14390y0) {
                    this.f14391z0 = 0;
                    return;
                }
            }
        } catch (IllegalArgumentException unused) {
            this.f14391z0 = 1;
        }
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(q5.l.fragment_update, (ViewGroup) null, false);
        int i = q5.k.close_btn;
        if (((ImageButton) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
            i = q5.k.download_layout;
            LinearLayout linearLayout = (LinearLayout) android.support.v4.media.session.b.l(viewInflate, i);
            if (linearLayout != null) {
                i = q5.k.download_progress;
                ProgressBar progressBar = (ProgressBar) android.support.v4.media.session.b.l(viewInflate, i);
                if (progressBar != null) {
                    i = q5.k.later_btn;
                    Button button = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                    if (button != null) {
                        i = q5.k.message_txt_update;
                        if (((TextView) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
                            i = q5.k.progress_percent;
                            TextView textView = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                            if (textView != null) {
                                i = q5.k.progress_txt;
                                TextView textView2 = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                                if (textView2 != null) {
                                    i = q5.k.size_txt;
                                    TextView textView3 = (TextView) android.support.v4.media.session.b.l(viewInflate, i);
                                    if (textView3 != null) {
                                        i = q5.k.updateBtn;
                                        Button button2 = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                                        if (button2 != null) {
                                            i = q5.k.update_ly;
                                            if (((LinearLayout) android.support.v4.media.session.b.l(viewInflate, i)) != null) {
                                                i = q5.k.web_btn;
                                                Button button3 = (Button) android.support.v4.media.session.b.l(viewInflate, i);
                                                if (button3 != null) {
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                    this.f14384s0 = new hd.e(constraintLayout, linearLayout, progressBar, button, textView, textView2, textView3, button2, button3);
                                                    return constraintLayout;
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
