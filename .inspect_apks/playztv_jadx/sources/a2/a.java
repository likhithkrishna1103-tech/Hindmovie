package a2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.widget.LinearLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.ui.DefaultTimeBar;
import com.google.android.material.navigation.NavigationView;
import com.playz.tv.activities.LandscapeActivity;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.SplashActivity;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f151u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f152v;

    public /* synthetic */ a(int i, Object obj) {
        this.f151u = i;
        this.f152v = obj;
    }

    private final void a() {
        androidx.emoji2.text.t tVar = (androidx.emoji2.text.t) this.f152v;
        synchronized (tVar.f1201x) {
            try {
                if (tVar.B == null) {
                    return;
                }
                try {
                    n0.i iVarD = tVar.d();
                    int i = iVarD.f8633e;
                    if (i == 2) {
                        synchronized (tVar.f1201x) {
                        }
                    }
                    if (i != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i + ")");
                    }
                    try {
                        Method method = m0.k.f8288b;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        lb.e eVar = tVar.f1200w;
                        Context context = tVar.f1198u;
                        eVar.getClass();
                        n0.i[] iVarArr = {iVarD};
                        i5.a aVar = i0.g.f6168a;
                        com.bumptech.glide.d.e("TypefaceCompat.createFromFontInfo");
                        try {
                            Typeface typefaceJ = i0.g.f6168a.j(context, iVarArr, 0);
                            Trace.endSection();
                            MappedByteBuffer mappedByteBufferG = q1.c.G(tVar.f1198u, iVarD.f8629a);
                            if (mappedByteBufferG == null || typefaceJ == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            try {
                                Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                ub.o oVar = new ub.o(typefaceJ, com.bumptech.glide.c.r(mappedByteBufferG));
                                Trace.endSection();
                                synchronized (tVar.f1201x) {
                                    try {
                                        cf.d dVar = tVar.B;
                                        if (dVar != null) {
                                            dVar.u(oVar);
                                        }
                                    } finally {
                                    }
                                }
                                tVar.b();
                            } finally {
                                Method method2 = m0.k.f8288b;
                            }
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (tVar.f1201x) {
                        try {
                            cf.d dVar2 = tVar.B;
                            if (dVar2 != null) {
                                dVar2.t(th2);
                            }
                            tVar.b();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0112 A[LOOP:0: B:27:0x0057->B:76:0x0112, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116 A[EDGE_INSN: B:94:0x0116->B:77:0x0116 BREAK  A[LOOP:0: B:27:0x0057->B:76:0x0112], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b() {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.b():void");
    }

    private final void c() {
        fd.a aVar = (fd.a) this.f152v;
        synchronized (aVar.f4816a) {
            try {
                Iterator it = aVar.f4816a.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        j2.h hVar = (j2.h) this.f152v;
        synchronized (hVar.f6690a) {
            try {
                if (hVar.f6700m) {
                    return;
                }
                long j5 = hVar.f6699l - 1;
                hVar.f6699l = j5;
                if (j5 > 0) {
                    return;
                }
                if (j5 < 0) {
                    hVar.b(new IllegalStateException());
                } else {
                    hVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i = 3;
        int i10 = 0;
        switch (this.f151u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c cVar = (c) this.f152v;
                ((Context) cVar.f173v).unregisterReceiver((b) cVar.f174w);
                return;
            case 1:
                b bVar = (b) this.f152v;
                if (bVar.f160c.f172u) {
                    bVar.f158a.f312u.P1(3, false);
                    return;
                }
                return;
            case 2:
                o0 o0Var = (o0) this.f152v;
                n.p pVar = o0Var.Z;
                Context context = o0Var.f369z;
                int i11 = s1.b0.f11647a;
                Integer numValueOf = Integer.valueOf(q1.c.C(context).generateAudioSessionId());
                pVar.f = numValueOf;
                s1.c cVar2 = new s1.c(pVar, numValueOf, i10);
                s1.y yVar = (s1.y) pVar.f8477c;
                if (yVar.f11718a.getLooper().getThread().isAlive()) {
                    yVar.c(cVar2);
                    return;
                }
                return;
            case 3:
                x1 x1Var = (x1) this.f152v;
                try {
                    synchronized (x1Var) {
                    }
                    try {
                        x1Var.f509a.b(x1Var.f511c, x1Var.f512d);
                        return;
                    } finally {
                        x1Var.a(true);
                    }
                } catch (q e10) {
                    s1.b.h("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e10);
                    throw new RuntimeException(e10);
                }
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                a();
                return;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                androidx.lifecycle.c0 c0Var = (androidx.lifecycle.c0) this.f152v;
                androidx.lifecycle.u uVar = c0Var.f1454z;
                if (c0Var.f1450v == 0) {
                    c0Var.f1451w = true;
                    uVar.d(androidx.lifecycle.m.ON_PAUSE);
                }
                if (c0Var.f1449u == 0 && c0Var.f1451w) {
                    uVar.d(androidx.lifecycle.m.ON_STOP);
                    c0Var.f1452x = true;
                    return;
                }
                return;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                b2.h hVar = (b2.h) this.f152v;
                hVar.W(hVar.R(), 1028, new s(29));
                hVar.f1747z.d();
                return;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                c.j jVar = (c.j) this.f152v;
                Runnable runnable = jVar.f2172v;
                if (runnable != null) {
                    runnable.run();
                    jVar.f2172v = null;
                    return;
                }
                return;
            case 8:
                c.n.b((c.n) this.f152v);
                return;
            case 9:
                c2.e0 e0Var = (c2.e0) this.f152v;
                if (e0Var.f2280j0 >= 300000) {
                    e0Var.f2291s.n();
                    e0Var.f2280j0 = 0L;
                    return;
                }
                return;
            case 10:
                ((com.google.android.material.timepicker.e) this.f152v).m();
                return;
            case 11:
                Activity activity = (Activity) this.f152v;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = e0.b.f4242g;
                Method method = e0.b.f;
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i12 != 26 && i12 != 27) || method != null) && (e0.b.f4241e != null || e0.b.f4240d != null)) {
                    try {
                        Object obj2 = e0.b.f4239c.get(activity);
                        if (obj2 != null && (obj = e0.b.f4238b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            e0.a aVar = new e0.a(activity);
                            application.registerActivityLifecycleCallbacks(aVar);
                            handler.post(new ea.t(aVar, i, obj2));
                            int i13 = 4;
                            try {
                                if (i12 == 26 || i12 == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new ea.t(application, i13, aVar));
                                return;
                            } finally {
                                handler.post(new ea.t(application, i13, aVar));
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 12:
                b();
                return;
            case 13:
                f2.e eVar = (f2.e) this.f152v;
                if (eVar.f4725w) {
                    return;
                }
                f2.h hVar2 = eVar.f4724v;
                if (hVar2 != null) {
                    hVar2.c(eVar.f4723u);
                }
                eVar.f4726x.G.remove(eVar);
                eVar.f4725w = true;
                return;
            case 14:
                ((f2.c) this.f152v).c(null);
                return;
            case 15:
                c();
                return;
            case 16:
                ((u5.c) this.f152v).i();
                return;
            case 17:
                LandscapeActivity landscapeActivity = (LandscapeActivity) this.f152v;
                int i14 = LandscapeActivity.f3596a0;
                landscapeActivity.getClass();
                uc.b.k(landscapeActivity);
                return;
            case 18:
                ((MainActivity) this.f152v).f3619x0 = false;
                return;
            case 19:
                MainActivity.w(((hc.k) this.f152v).f6046a, "");
                return;
            case 20:
                SplashActivity splashActivity = (SplashActivity) this.f152v;
                splashActivity.Y++;
                splashActivity.Z = false;
                ((LinearLayout) splashActivity.W.f).setVisibility(0);
                return;
            case 21:
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) this.f152v;
                int i15 = DefaultTimeBar.f1593m0;
                defaultTimeBar.d(false);
                return;
            case 22:
                ((i4.s) this.f152v).o();
                return;
            case 23:
                ub.o oVar = (ub.o) this.f152v;
                ((j7.g) ((k7.c) oVar.f12871y)).G(new f0(25, oVar));
                return;
            case 24:
                ((ae.a) this.f152v).b();
                return;
            case 25:
                d();
                return;
            case 26:
                x5.g.b((ByteArrayInputStream) this.f152v);
                return;
            case 27:
                ((l5.c0) this.f152v).d();
                return;
            case 28:
                a7.b bVar2 = (a7.b) this.f152v;
                k9.c cVar3 = (k9.c) bVar2.f618v;
                if (cVar3 != null) {
                    cVar3.b((NavigationView) bVar2.f619w, (NavigationView) bVar2.f620x, true);
                    return;
                }
                return;
            default:
                ((m2.c) this.f152v).z();
                return;
        }
    }

    public /* synthetic */ a(x0 x0Var, x1 x1Var) {
        this.f151u = 3;
        this.f152v = x1Var;
    }

    public /* synthetic */ a(fd.a aVar, List list, id.o oVar, zc.e eVar) {
        this.f151u = 15;
        this.f152v = aVar;
    }
}
