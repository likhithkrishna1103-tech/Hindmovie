package a2;

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
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.internal.measurement.k4;
import com.playz.tv.CustomLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f237u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f239w;

    public /* synthetic */ g0(g4.b0 b0Var, g4.s sVar, Runnable runnable) {
        this.f237u = 15;
        this.f238v = b0Var;
        this.f239w = runnable;
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
        throw new UnsupportedOperationException("Method not decompiled: a2.g0.a():void");
    }

    private final void b() {
        k4 k4Var = (k4) this.f238v;
        synchronized (((h) this.f239w)) {
        }
        c2.j jVar = (c2.j) k4Var.f3071v;
        int i = s1.b0.f11647a;
        b2.h hVar = ((l0) jVar).f312u.N;
        hVar.W(hVar.S((o2.d0) hVar.f1745x.f), 1013, new b2.d(6));
    }

    private final void c() {
        nb.a aVar;
        na.p pVar = (na.p) this.f238v;
        nb.b bVar = (nb.b) this.f239w;
        if (pVar.f8913b != na.p.f8911d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (pVar) {
            aVar = pVar.f8912a;
            pVar.f8912a = null;
            pVar.f8913b = bVar;
        }
        aVar.c(bVar);
    }

    private final void d() {
        na.o oVar = (na.o) this.f238v;
        nb.b bVar = (nb.b) this.f239w;
        synchronized (oVar) {
            try {
                if (oVar.f8909b == null) {
                    oVar.f8908a.add(bVar);
                } else {
                    oVar.f8909b.add(bVar.get());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long j5;
        boolean z2;
        id.k kVar;
        dd.b bVar;
        ed.d dVar;
        g4.q1 q1Var;
        final int i = 0;
        final int i10 = 1;
        switch (this.f237u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                o0 o0Var = (o0) this.f238v;
                u0 u0Var = (u0) this.f239w;
                int i11 = o0Var.f344c0 - u0Var.f443b;
                o0Var.f344c0 = i11;
                if (u0Var.f445d) {
                    o0Var.f345d0 = u0Var.f446e;
                    o0Var.f346e0 = true;
                }
                if (i11 == 0) {
                    p1.f1 f1Var = ((u1) u0Var.f).f448a;
                    if (!o0Var.D0.f448a.p() && f1Var.p()) {
                        o0Var.E0 = -1;
                        o0Var.F0 = 0L;
                    }
                    if (!f1Var.p()) {
                        List listAsList = Arrays.asList(((z1) f1Var).f528k);
                        s1.d.g(listAsList.size() == o0Var.K.size());
                        for (int i12 = 0; i12 < listAsList.size(); i12++) {
                            ((n0) o0Var.K.get(i12)).f337c = (p1.f1) listAsList.get(i12);
                        }
                    }
                    long j8 = -9223372036854775807L;
                    if (o0Var.f346e0) {
                        if (((u1) u0Var.f).f449b.equals(o0Var.D0.f449b) && ((u1) u0Var.f).f451d == o0Var.D0.f464s) {
                            i10 = 0;
                        }
                        if (i10 != 0) {
                            if (f1Var.p() || ((u1) u0Var.f).f449b.b()) {
                                j8 = ((u1) u0Var.f).f451d;
                            } else {
                                u1 u1Var = (u1) u0Var.f;
                                o2.d0 d0Var = u1Var.f449b;
                                long j10 = u1Var.f451d;
                                Object obj = d0Var.f9090a;
                                p1.c1 c1Var = o0Var.J;
                                f1Var.g(obj, c1Var);
                                j8 = j10 + c1Var.f9680e;
                            }
                        }
                        j5 = j8;
                        z2 = i10;
                    } else {
                        j5 = -9223372036854775807L;
                        z2 = 0;
                    }
                    o0Var.f346e0 = false;
                    o0Var.Q1((u1) u0Var.f, 1, z2, o0Var.f345d0, j5, -1, false);
                    return;
                }
                return;
            case 1:
                ab.d dVar2 = (ab.d) this.f238v;
                CountDownLatch countDownLatch = (CountDownLatch) this.f239w;
                try {
                    c7.t.a().f2585d.e(((c7.j) dVar2.f789h.f14945u).b(z6.d.f14893w), 1);
                    break;
                } catch (Exception unused) {
                }
                countDownLatch.countDown();
                return;
            case 2:
                ((b2.n) this.f238v).f1766d.reportTrackChangeEvent((TrackChangeEvent) this.f239w);
                return;
            case 3:
                ((b2.n) this.f238v).f1766d.reportNetworkEvent((NetworkEvent) this.f239w);
                return;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((b2.n) this.f238v).f1766d.reportPlaybackErrorEvent((PlaybackErrorEvent) this.f239w);
                return;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ((b2.n) this.f238v).f1766d.reportPlaybackMetrics((PlaybackMetrics) this.f239w);
                return;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ((b2.n) this.f238v).f1766d.reportPlaybackStateEvent((PlaybackStateEvent) this.f239w);
                return;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                zc.e eVar = (zc.e) this.f238v;
                bd.a aVar = (bd.a) this.f239w;
                try {
                    Thread.currentThread().setName(eVar.f14951v + "-" + eVar.f14950u);
                    break;
                } catch (Exception unused2) {
                }
                try {
                    try {
                        bd.b bVarH = aVar.H(eVar);
                        synchronized (aVar.D) {
                            if (aVar.H.containsKey(Integer.valueOf(eVar.f14950u))) {
                                bVarH.J(new ed.b(aVar.f2013x, (dd.p) aVar.f2015z.i));
                                aVar.H.put(Integer.valueOf(eVar.f14950u), bVarH);
                                aVar.f2014y.D(eVar.f14950u, bVarH);
                                aVar.f2011v.b("DownloadManager starting download " + eVar);
                                i = 1;
                            }
                        }
                        if (i != 0) {
                            bVarH.run();
                        }
                        aVar.J(eVar);
                        aVar.C.m();
                        aVar.J(eVar);
                        dVar = aVar.F;
                    } catch (Exception e10) {
                        aVar.f2011v.c("DownloadManager failed to start download " + eVar, e10);
                        aVar.J(eVar);
                        ed.d dVar3 = aVar.F;
                        if (dVar3 == null) {
                            return;
                        }
                        kVar = dVar3.f4681u;
                        bVar = new dd.b(dVar3, i10, "LibGlobalFetchLib");
                    }
                    if (dVar != null) {
                        kVar = dVar.f4681u;
                        bVar = new dd.b(dVar, i10, "LibGlobalFetchLib");
                        kVar.d(bVar);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    aVar.J(eVar);
                    ed.d dVar4 = aVar.F;
                    if (dVar4 != null) {
                        dVar4.f4681u.d(new dd.b(dVar4, i10, "LibGlobalFetchLib"));
                    }
                    throw th;
                }
            case 8:
                a();
                return;
            case 9:
                h.j jVar = (h.j) this.f238v;
                jVar.f4244u.a(new c.g((c.c0) this.f239w, jVar));
                return;
            case 10:
                b();
                return;
            case 11:
                ((c2.n) this.f238v).C((c2.k) this.f239w);
                return;
            case 12:
                dd.e eVar2 = (dd.e) this.f238v;
                ArrayList arrayList = (ArrayList) this.f239w;
                ArrayList arrayList2 = new ArrayList(od.k.U(arrayList));
                int size = arrayList.size();
                int i13 = 0;
                while (i13 < size) {
                    Object obj2 = arrayList.get(i13);
                    i13++;
                    nd.f fVar = (nd.f) obj2;
                    zc.e eVar3 = (zc.e) fVar.f8983u;
                    yc.j jVar2 = new yc.j(eVar3.f14952w, eVar3.f14953x);
                    jVar2.f14682v = eVar3.f14954y;
                    jVar2.f14683w.putAll(eVar3.A);
                    yc.f fVar2 = eVar3.F;
                    be.h.e(fVar2, "<set-?>");
                    jVar2.f14685y = fVar2;
                    yc.g gVar = eVar3.f14955z;
                    be.h.e(gVar, "<set-?>");
                    jVar2.f14684x = gVar;
                    yc.a aVar2 = eVar3.I;
                    be.h.e(aVar2, "<set-?>");
                    jVar2.A = aVar2;
                    jVar2.f14681u = eVar3.J;
                    jVar2.B = eVar3.K;
                    id.g gVar2 = eVar3.L;
                    be.h.e(gVar2, "value");
                    jVar2.D = new id.g(od.t.J(gVar2.f6577u));
                    int i14 = eVar3.M;
                    if (i14 < 0) {
                        throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
                    }
                    jVar2.C = i14;
                    arrayList2.add(new nd.f(jVar2, fVar.f8984v));
                }
                dd.h hVar = (dd.h) eVar2.f4142v;
                final ia.b bVar2 = (ia.b) eVar2.f4143w;
                final ia.b bVar3 = (ia.b) eVar2.f4144x;
                ArrayList arrayList3 = arrayList2;
                be.h.e(arrayList3, "result");
                if (arrayList3.isEmpty()) {
                    ((Handler) hVar.f4152b).post(new dd.c(bVar2));
                    return;
                }
                final nd.f fVar3 = (nd.f) od.i.X(arrayList3);
                if (fVar3.f8984v != yc.b.f14650x) {
                    ((Handler) hVar.f4152b).post(new Runnable(bVar2, fVar3, i) { // from class: dd.g

                        /* JADX INFO: renamed from: u, reason: collision with root package name */
                        public final /* synthetic */ int f4149u;

                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                        public final /* synthetic */ nd.f f4150v;

                        {
                            this.f4149u = i;
                            this.f4150v = fVar3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (this.f4149u) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    return;
                } else {
                    ((Handler) hVar.f4152b).post(new Runnable(bVar3, fVar3, i10) { // from class: dd.g

                        /* JADX INFO: renamed from: u, reason: collision with root package name */
                        public final /* synthetic */ int f4149u;

                        /* JADX INFO: renamed from: v, reason: collision with root package name */
                        public final /* synthetic */ nd.f f4150v;

                        {
                            this.f4149u = i10;
                            this.f4150v = fVar3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (this.f4149u) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    return;
                }
            case 13:
                f2.e eVar4 = (f2.e) this.f238v;
                p1.q qVar = (p1.q) this.f239w;
                f2.f fVar4 = eVar4.f4726x;
                if (fVar4.I == 0 || eVar4.f4725w) {
                    return;
                }
                Looper looper = fVar4.M;
                looper.getClass();
                eVar4.f4724v = fVar4.a(looper, eVar4.f4723u, qVar, false);
                fVar4.G.add(eVar4);
                return;
            case 14:
                ((h2.b) ((g2.k) ((g2.q) this.f238v).f4925w.f12782v).f4889v.f5663x.get(((g2.j) this.f239w).G)).c(true);
                return;
            case 15:
                g4.b0 b0Var = (g4.b0) this.f238v;
                Runnable runnable = (Runnable) this.f239w;
                b0Var.getClass();
                runnable.run();
                return;
            case 16:
                ((ea.e0) this.f239w).k(Boolean.valueOf(((g4.b0) this.f238v).o()));
                return;
            case 17:
                g4.b0 b0Var2 = (g4.b0) this.f238v;
                g4.j1 j1Var = (g4.j1) this.f239w;
                g4.m0 m0Var = b0Var2.f4962h;
                b0Var2.f4973t = j1Var;
                g4.z zVar = new g4.z(b0Var2, j1Var);
                j1Var.J(zVar);
                b0Var2.f4974u = zVar;
                try {
                    m0Var.i.q(0, j1Var);
                    break;
                } catch (RemoteException e11) {
                    s1.b.h("MediaSessionImpl", "Exception in using media1 API", e11);
                }
                ((h4.t) m0Var.f5118k.f5867v).f5847a.setActive(true);
                b0Var2.f4972s = new g4.h1(j1Var.k(), 0, j1Var.b(), j1Var.a(), j1Var.a(), 0, j1Var.h(), j1Var.v0(), j1Var.C0(), j1Var.U(), j1Var.x(), 0, j1Var.e0(18) ? j1Var.O() : p1.j0.K, j1Var.e0(22) ? j1Var.Y() : 1.0f, j1Var.e0(21) ? j1Var.a0() : p1.d.f9682h, j1Var.e0(28) ? j1Var.S() : r1.c.f11270d, j1Var.g0(), j1Var.e0(23) ? j1Var.l() : 0, j1Var.e0(23) && j1Var.x0(), j1Var.C(), 1, j1Var.s0(), j1Var.I(), j1Var.P(), j1Var.c(), j1Var.B(), j1Var.V0(), j1Var.q(), j1Var.N(), j1Var.e0(30) ? j1Var.L() : p1.n1.f9950b, j1Var.E0());
                b0Var2.f(j1Var.w());
                return;
            case 18:
                ea.v vVar = (ea.v) this.f238v;
                ResultReceiver resultReceiver = (ResultReceiver) this.f239w;
                try {
                    q1Var = (g4.q1) vVar.f4635u;
                    s1.d.e(q1Var, "SessionResult must not be null");
                    break;
                } catch (InterruptedException e12) {
                    e = e12;
                    s1.b.q("MediaSessionLegacyStub", "Custom command failed", e);
                    q1Var = new g4.q1(-1);
                } catch (CancellationException e13) {
                    s1.b.q("MediaSessionLegacyStub", "Custom command cancelled", e13);
                    q1Var = new g4.q1(1);
                } catch (ExecutionException e14) {
                    e = e14;
                    s1.b.q("MediaSessionLegacyStub", "Custom command failed", e);
                    q1Var = new g4.q1(-1);
                }
                resultReceiver.send(q1Var.f5189a, q1Var.f5190b);
                return;
            case 19:
                g4.f1 f1Var2 = (g4.f1) this.f238v;
                g4.j jVar3 = (g4.j) this.f239w;
                ub.o oVar = f1Var2.f5006e;
                g4.s sVarX = oVar.x(jVar3.asBinder());
                if (sVarX != null) {
                    oVar.P(sVarX);
                    return;
                }
                return;
            case 20:
                ((g4.f1) this.f238v).f5006e.r((g4.s) this.f239w);
                return;
            case 21:
                h.o oVar2 = (h.o) this.f238v;
                Runnable runnable2 = (Runnable) this.f239w;
                oVar2.getClass();
                try {
                    runnable2.run();
                    return;
                } finally {
                    oVar2.b();
                }
            case 22:
                ((h0.b) this.f238v).i((Typeface) this.f239w);
                return;
            case 23:
                h2.b bVar4 = (h2.b) this.f238v;
                Uri uri = (Uri) this.f239w;
                bVar4.C = false;
                bVar4.e(uri);
                return;
            case 24:
                JobInfoSchedulerService jobInfoSchedulerService = (JobInfoSchedulerService) this.f238v;
                JobParameters jobParameters = (JobParameters) this.f239w;
                int i15 = JobInfoSchedulerService.f2866u;
                jobInfoSchedulerService.jobFinished(jobParameters, false);
                return;
            case 25:
                nc.c cVar = (nc.c) this.f238v;
                oc.c cVar2 = (oc.c) this.f239w;
                nc.p pVar = (nc.p) cVar.f8921v;
                pVar.f8962v0.remove(cVar2);
                pVar.f8961u0.g(pVar.f8962v0);
                if (pVar.f8962v0.isEmpty()) {
                    ((TextView) pVar.f8960t0.f5867v).setVisibility(0);
                    return;
                }
                return;
            case 26:
                c();
                return;
            case 27:
                d();
                return;
            case 28:
                nc.m mVar = (nc.m) this.f238v;
                StringBuilder sb2 = (StringBuilder) this.f239w;
                mVar.getClass();
                mVar.X(sb2.toString());
                return;
            default:
                nc.p pVar2 = (nc.p) this.f238v;
                List<rc.c> list = (List) this.f239w;
                if (list == null || list.isEmpty()) {
                    ((TextView) pVar2.f8960t0.f5867v).setVisibility(0);
                }
                ArrayList arrayList4 = new ArrayList();
                if (list != null) {
                    for (rc.c cVar3 : list) {
                        oc.c cVar4 = new oc.c();
                        boolean zIsEmpty = TextUtils.isEmpty(cVar3.f11567e);
                        String string = cVar3.f11566d;
                        if (!zIsEmpty) {
                            try {
                                JSONObject jSONObject = new JSONArray(string).getJSONObject(0);
                                jSONObject.put("playlist", cVar3.f11567e);
                                string = new JSONArray().put(jSONObject).toString();
                                break;
                            } catch (ArrayIndexOutOfBoundsException | JSONException unused3) {
                            }
                        }
                        cVar4.f9515a = cVar3.f11564b;
                        cVar4.f9516b = cVar3.f11565c;
                        cVar4.f9517c = string;
                        cVar4.f9518d = !zIsEmpty ? "m3u" : "custom";
                        arrayList4.add(cVar4);
                        Log.e("Pro link", string);
                    }
                }
                pVar2.f8962v0 = arrayList4;
                if (arrayList4.isEmpty()) {
                    ((TextView) pVar2.f8960t0.f5867v).setVisibility(0);
                    return;
                }
                ((TextView) pVar2.f8960t0.f5867v).setVisibility(8);
                ic.g gVar3 = pVar2.f8961u0;
                if (gVar3 != null) {
                    gVar3.g(pVar2.f8962v0);
                    ((RecyclerView) pVar2.f8960t0.f5868w).j0(0);
                    return;
                }
                ic.g gVar4 = new ic.g(pVar2.G(), pVar2.f8962v0);
                pVar2.f8961u0 = gVar4;
                gVar4.f6509h = new nc.c(i10, pVar2);
                ((RecyclerView) pVar2.f8960t0.f5868w).setAdapter(gVar4);
                RecyclerView recyclerView = (RecyclerView) pVar2.f8960t0.f5868w;
                pVar2.H();
                recyclerView.setLayoutManager(new CustomLayoutManager(pVar2.P() ? 5 : 3));
                return;
        }
    }

    public /* synthetic */ g0(Object obj, int i, Object obj2) {
        this.f237u = i;
        this.f238v = obj;
        this.f239w = obj2;
    }

    public /* synthetic */ g0(nc.c cVar, boolean z2, oc.c cVar2) {
        this.f237u = 25;
        this.f238v = cVar;
        this.f239w = cVar2;
    }
}
