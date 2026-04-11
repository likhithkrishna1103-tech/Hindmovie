package androidx.fragment.app;

import android.app.job.JobParameters;
import android.graphics.Typeface;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.StrictMode;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import g2.i1;
import g2.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import k4.o1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f959x;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f957v = i;
        this.f958w = obj;
        this.f959x = obj2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:126:0x0208
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private final void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d.a():void");
    }

    private final void b() {
        hc.a aVar;
        hb.p pVar = (hb.p) this.f958w;
        hc.b bVar = (hc.b) this.f959x;
        if (pVar.f5909b != hb.p.f5907d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (pVar) {
            aVar = pVar.f5908a;
            pVar.f5908a = null;
            pVar.f5909b = bVar;
        }
        aVar.j(bVar);
    }

    private final void c() {
        hb.o oVar = (hb.o) this.f958w;
        hc.b bVar = (hc.b) this.f959x;
        synchronized (oVar) {
            try {
                if (oVar.f5905b == null) {
                    oVar.f5904a.add(bVar);
                } else {
                    oVar.f5905b.add(bVar.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        i2.k kVar = (i2.k) this.f958w;
        synchronized (((g2.f) this.f959x)) {
        }
        i2.l lVar = (i2.l) kVar.f6086w;
        int i = y1.a0.f14551a;
        h2.f fVar = ((g2.d0) lVar).f4651v.O;
        fVar.W(fVar.S((s2.c0) fVar.f5497y.f), 1013, new h2.b(14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        md.j jVar;
        ff.h hVar;
        id.d dVar;
        long j4;
        boolean z10;
        o1 o1Var;
        final int i = 1;
        final int i10 = 0;
        switch (this.f957v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = (ArrayList) this.f958w;
                e1 e1Var = (e1) this.f959x;
                if (arrayList.contains(e1Var)) {
                    arrayList.remove(e1Var);
                    View view = e1Var.f975c.f1103b0;
                    int i11 = e1Var.f973a;
                    ge.i.d(view, "view");
                    q4.a.b(view, i11);
                    return;
                }
                return;
            case 1:
                h.j jVar2 = (h.j) this.f958w;
                jVar2.f5437v.a(new c.g((c.f0) this.f959x, jVar2));
                return;
            case 2:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f958w;
                JobParameters jobParameters = (JobParameters) this.f959x;
                int i12 = JobInfoSchedulerService.f2301v;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                return;
            case 3:
                dd.e eVar = (dd.e) this.f958w;
                fd.a aVar = (fd.a) this.f959x;
                try {
                    Thread.currentThread().setName(eVar.f3677w + "-" + eVar.f3676v);
                    break;
                } catch (Exception unused) {
                }
                int i13 = 2;
                try {
                    try {
                        fd.b bVarC = aVar.C(eVar);
                        synchronized (aVar.E) {
                            if (aVar.I.containsKey(Integer.valueOf(eVar.f3676v))) {
                                bVarC.Q(new id.b(aVar.f4563y, (hd.l) aVar.A.i));
                                aVar.I.put(Integer.valueOf(eVar.f3676v), bVarC);
                                aVar.f4564z.n(eVar.f3676v, bVarC);
                                aVar.f4561w.b("DownloadManager starting download " + eVar);
                            } else {
                                i = 0;
                            }
                            break;
                        }
                        if (i != 0) {
                            bVarC.run();
                        }
                        aVar.J(eVar);
                        aVar.D.k();
                        aVar.J(eVar);
                        dVar = aVar.G;
                    } catch (Exception e9) {
                        aVar.f4561w.c("DownloadManager failed to start download " + eVar, e9);
                        aVar.J(eVar);
                        id.d dVar2 = aVar.G;
                        if (dVar2 == null) {
                            return;
                        }
                        jVar = dVar2.f6444v;
                        hVar = new ff.h(i13, dVar2, "LibGlobalFetchLib");
                    }
                    if (dVar != null) {
                        jVar = dVar.f6444v;
                        hVar = new ff.h(i13, dVar, "LibGlobalFetchLib");
                        jVar.d(hVar);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    aVar.J(eVar);
                    id.d dVar3 = aVar.G;
                    if (dVar3 != null) {
                        dVar3.f6444v.d(new ff.h(i13, dVar3, "LibGlobalFetchLib"));
                    }
                    throw th;
                }
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                a();
                return;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                g2.g0 g0Var = (g2.g0) this.f958w;
                g2.l0 l0Var = (g2.l0) this.f959x;
                int i14 = g0Var.f4692d0 - l0Var.f4793b;
                g0Var.f4692d0 = i14;
                if (l0Var.f4795d) {
                    g0Var.f4693e0 = l0Var.f4796e;
                    g0Var.f4694f0 = true;
                }
                if (i14 == 0) {
                    v1.f1 f1Var = ((i1) l0Var.f).f4750a;
                    if (!g0Var.E0.f4750a.p() && f1Var.p()) {
                        g0Var.F0 = -1;
                        g0Var.G0 = 0L;
                    }
                    if (!f1Var.p()) {
                        List listAsList = Arrays.asList(((n1) f1Var).f4816k);
                        y1.d.g(listAsList.size() == g0Var.L.size());
                        for (int i15 = 0; i15 < listAsList.size(); i15++) {
                            ((g2.f0) g0Var.L.get(i15)).f4680c = (v1.f1) listAsList.get(i15);
                        }
                    }
                    long j7 = -9223372036854775807L;
                    if (g0Var.f4694f0) {
                        if (((i1) l0Var.f).f4751b.equals(g0Var.E0.f4751b) && ((i1) l0Var.f).f4753d == g0Var.E0.f4766s) {
                            i = 0;
                        }
                        if (i != 0) {
                            if (f1Var.p() || ((i1) l0Var.f).f4751b.b()) {
                                j7 = ((i1) l0Var.f).f4753d;
                            } else {
                                i1 i1Var = (i1) l0Var.f;
                                s2.c0 c0Var = i1Var.f4751b;
                                long j10 = i1Var.f4753d;
                                Object obj = c0Var.f11156a;
                                v1.c1 c1Var = g0Var.K;
                                f1Var.g(obj, c1Var);
                                j7 = j10 + c1Var.f12620e;
                            }
                        }
                        j4 = j7;
                        z10 = i;
                    } else {
                        j4 = -9223372036854775807L;
                        z10 = 0;
                    }
                    g0Var.f4694f0 = false;
                    g0Var.N1((i1) l0Var.f, 1, z10, g0Var.f4693e0, j4, -1, false);
                    return;
                }
                return;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                h.o oVar = (h.o) this.f958w;
                Runnable runnable = (Runnable) this.f959x;
                oVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    oVar.b();
                }
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                ((h2.k) this.f958w).f5515d.reportTrackChangeEvent((TrackChangeEvent) this.f959x);
                return;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                ((h2.k) this.f958w).f5515d.reportNetworkEvent((NetworkEvent) this.f959x);
                return;
            case 9:
                ((h2.k) this.f958w).f5515d.reportPlaybackErrorEvent((PlaybackErrorEvent) this.f959x);
                return;
            case 10:
                ((h2.k) this.f958w).f5515d.reportPlaybackMetrics((PlaybackMetrics) this.f959x);
                return;
            case 11:
                ((h2.k) this.f958w).f5515d.reportPlaybackStateEvent((PlaybackStateEvent) this.f959x);
                return;
            case 12:
                b();
                return;
            case 13:
                c();
                return;
            case 14:
                c8.b bVar = (c8.b) this.f959x;
                ArrayList arrayList2 = (ArrayList) this.f958w;
                ArrayList arrayList3 = new ArrayList(sd.l.f0(arrayList2, 10));
                int size = arrayList2.size();
                int i16 = 0;
                while (i16 < size) {
                    Object obj2 = arrayList2.get(i16);
                    i16++;
                    rd.f fVar = (rd.f) obj2;
                    dd.e eVar2 = (dd.e) fVar.f10993v;
                    cd.k kVar = new cd.k(eVar2.f3678x, eVar2.f3679y);
                    kVar.f2181w = eVar2.f3680z;
                    kVar.f2182x.putAll(eVar2.B);
                    cd.g gVar = eVar2.G;
                    ge.i.e(gVar, "<set-?>");
                    kVar.f2184z = gVar;
                    cd.h hVar2 = eVar2.A;
                    ge.i.e(hVar2, "<set-?>");
                    kVar.f2183y = hVar2;
                    cd.a aVar2 = eVar2.J;
                    ge.i.e(aVar2, "<set-?>");
                    kVar.B = aVar2;
                    kVar.f2180v = eVar2.K;
                    kVar.C = eVar2.L;
                    md.g gVar2 = eVar2.M;
                    ge.i.e(gVar2, "value");
                    kVar.E = new md.g(sd.s.C(gVar2.f8433v));
                    int i17 = eVar2.N;
                    if (i17 < 0) {
                        throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
                    }
                    kVar.D = i17;
                    arrayList3.add(new rd.f(kVar, fVar.f10994w));
                }
                hd.e eVar3 = (hd.e) bVar.f2117y;
                final v1.b0 b0Var = (v1.b0) bVar.f2116x;
                final v1.b0 b0Var2 = (v1.b0) bVar.f2115w;
                ArrayList arrayList4 = arrayList3;
                ge.i.e(arrayList4, "result");
                if (arrayList4.isEmpty()) {
                    ((Handler) eVar3.f5926b).post(new d8.a(b0Var));
                    return;
                }
                final rd.f fVar2 = (rd.f) sd.j.h0(arrayList4);
                if (fVar2.f10994w != cd.b.f2152y) {
                    ((Handler) eVar3.f5926b).post(new Runnable(b0Var, fVar2, i10) { // from class: hd.d

                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                        public final /* synthetic */ int f5923v;

                        /* JADX INFO: renamed from: w, reason: collision with root package name */
                        public final /* synthetic */ rd.f f5924w;

                        {
                            this.f5923v = i10;
                            this.f5924w = fVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (this.f5923v) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    return;
                } else {
                    ((Handler) eVar3.f5926b).post(new Runnable(b0Var2, fVar2, i) { // from class: hd.d

                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                        public final /* synthetic */ int f5923v;

                        /* JADX INFO: renamed from: w, reason: collision with root package name */
                        public final /* synthetic */ rd.f f5924w;

                        {
                            this.f5923v = i;
                            this.f5924w = fVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (this.f5923v) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    return;
                }
            case 15:
                d();
                return;
            case 16:
                ((i2.p) this.f958w).e((i2.m) this.f959x);
                return;
            case 17:
                ib.a aVar3 = (ib.a) this.f958w;
                Runnable runnable2 = (Runnable) this.f959x;
                Process.setThreadPriority(aVar3.f6386c);
                StrictMode.ThreadPolicy threadPolicy = aVar3.f6387d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable2.run();
                return;
            case 18:
                Callable callable = (Callable) this.f958w;
                ib.g gVar3 = (ib.g) ((p6.c) this.f959x).f10035w;
                try {
                    gVar3.j(callable.call());
                    return;
                } catch (Exception e10) {
                    gVar3.k(e10);
                    return;
                }
            case 19:
                ((k0.b) this.f958w).i((Typeface) this.f959x);
                return;
            case 20:
                k4.b0 b0Var3 = (k4.b0) this.f958w;
                Runnable runnable3 = (Runnable) this.f959x;
                b0Var3.getClass();
                runnable3.run();
                return;
            case 21:
                ((ya.c0) this.f959x).k(Boolean.valueOf(((k4.b0) this.f958w).o()));
                return;
            case 22:
                k4.b0 b0Var4 = (k4.b0) this.f958w;
                k4.h1 h1Var = (k4.h1) this.f959x;
                k4.l0 l0Var2 = b0Var4.f6913h;
                b0Var4.f6924t = h1Var;
                k4.z zVar = new k4.z(b0Var4, h1Var);
                h1Var.T0(zVar);
                b0Var4.f6925u = zVar;
                try {
                    l0Var2.i.q(0, h1Var);
                    break;
                } catch (RemoteException e11) {
                    y1.b.h("MediaSessionImpl", "Exception in using media1 API", e11);
                }
                ((l4.w) l0Var2.f7063k.f7705w).f7765a.setActive(true);
                b0Var4.f6923s = new k4.f1(h1Var.h(), 0, h1Var.C(), h1Var.B(), h1Var.B(), 0, h1Var.d(), h1Var.u0(), h1Var.C0(), h1Var.R(), h1Var.f0(), 0, h1Var.Z(18) ? h1Var.L() : v1.j0.K, h1Var.Z(22) ? h1Var.U() : 1.0f, h1Var.Z(21) ? h1Var.W() : v1.c.f12586h, h1Var.Z(28) ? h1Var.P() : x1.c.f14266d, h1Var.c0(), h1Var.Z(23) ? h1Var.i() : 0, h1Var.Z(23) && h1Var.w0(), h1Var.w(), 1, h1Var.r0(), h1Var.E(), h1Var.M(), h1Var.a(), h1Var.A0(), h1Var.W0(), h1Var.o(), h1Var.J(), h1Var.Z(30) ? h1Var.G() : v1.n1.f12880b, h1Var.E0());
                b0Var4.f(h1Var.u());
                return;
            case 23:
                ya.u uVar = (ya.u) this.f958w;
                ResultReceiver resultReceiver = (ResultReceiver) this.f959x;
                try {
                    o1Var = (o1) uVar.f15016v;
                    y1.d.e(o1Var, "SessionResult must not be null");
                    break;
                } catch (InterruptedException e12) {
                    e = e12;
                    y1.b.q("MediaSessionLegacyStub", "Custom command failed", e);
                    o1Var = new o1(-1);
                } catch (CancellationException e13) {
                    y1.b.q("MediaSessionLegacyStub", "Custom command cancelled", e13);
                    o1Var = new o1(1);
                } catch (ExecutionException e14) {
                    e = e14;
                    y1.b.q("MediaSessionLegacyStub", "Custom command failed", e);
                    o1Var = new o1(-1);
                }
                resultReceiver.send(o1Var.f7123a, o1Var.f7124b);
                return;
            case 24:
                k4.d1 d1Var = (k4.d1) this.f958w;
                k4.j jVar3 = (k4.j) this.f959x;
                b6.f fVar3 = d1Var.f6944e;
                k4.s sVarH = fVar3.h(((k4.i) jVar3).f7039d);
                if (sVarH != null) {
                    fVar3.p(sVarH);
                    return;
                }
                return;
            case 25:
                ((k4.d1) this.f958w).f6944e.e((k4.s) this.f959x);
                return;
            case 26:
                l2.e eVar4 = (l2.e) this.f958w;
                v1.p pVar = (v1.p) this.f959x;
                l2.f fVar4 = eVar4.f7659y;
                if (fVar4.J == 0 || eVar4.f7658x) {
                    return;
                }
                Looper looper = fVar4.N;
                looper.getClass();
                eVar4.f7657w = fVar4.a(looper, eVar4.f7656v, pVar, false);
                fVar4.H.add(eVar4);
                return;
            case 27:
                ((n2.b) ((m2.l) ((m2.r) this.f958w).f8131x.f7483w).f8084w.f8640y.get(((m2.k) this.f959x).H)).c(true);
                return;
            case 28:
                n2.b bVar2 = (n2.b) this.f958w;
                Uri uri = (Uri) this.f959x;
                bVar2.D = false;
                bVar2.d(uri);
                return;
            default:
                ((nb.l) this.f958w).c((String) this.f959x, Boolean.FALSE);
                return;
        }
    }

    public /* synthetic */ d(c8.b bVar, ArrayList arrayList) {
        this.f957v = 14;
        this.f959x = bVar;
        this.f958w = arrayList;
    }

    public /* synthetic */ d(ArrayList arrayList, e1 e1Var, l lVar) {
        this.f957v = 0;
        this.f958w = arrayList;
        this.f959x = e1Var;
    }

    public /* synthetic */ d(k4.b0 b0Var, k4.s sVar, Runnable runnable) {
        this.f957v = 20;
        this.f958w = b0Var;
        this.f959x = runnable;
    }
}
