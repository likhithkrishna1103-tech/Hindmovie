package a2;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.SparseBooleanArray;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f277u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f278v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f279w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f280x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f281y;

    public /* synthetic */ i0(com.bumptech.glide.manager.s sVar, g4.t tVar, boolean z2, g4.s sVar2) {
        this.f277u = 2;
        this.f279w = sVar;
        this.f280x = tVar;
        this.f278v = z2;
        this.f281y = sVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        switch (this.f277u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Context context = (Context) this.f279w;
                boolean z2 = this.f278v;
                o0 o0Var = (o0) this.f280x;
                b2.o oVar = (b2.o) this.f281y;
                MediaMetricsManager mediaMetricsManagerE = b2.l.e(context.getSystemService("media_metrics"));
                b2.n nVar = mediaMetricsManagerE == null ? null : new b2.n(context, mediaMetricsManagerE.createPlaybackSession());
                if (nVar == null) {
                    s1.b.p("ExoPlayerImpl", "MediaMetricsService unavailable.");
                    return;
                }
                if (z2) {
                    b2.h hVar = o0Var.N;
                    hVar.getClass();
                    hVar.f1747z.a(nVar);
                }
                LogSessionId sessionId = nVar.f1766d.getSessionId();
                synchronized (oVar) {
                    u5.c cVar = oVar.f1788b;
                    cVar.getClass();
                    LogSessionId logSessionId = (LogSessionId) cVar.f12782v;
                    LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                    s1.d.g(logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE));
                    cVar.f12782v = sessionId;
                }
                return;
            case 1:
                g4.b0 b0Var = (g4.b0) this.f279w;
                boolean z10 = this.f278v;
                g4.s sVar = (g4.s) this.f280x;
                Runnable runnable = (Runnable) this.f281y;
                g4.f1 f1Var = b0Var.f4961g;
                if (z10) {
                    g4.m1 m1Var = new g4.m1("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", Bundle.EMPTY);
                    try {
                        g4.l1 l1VarC = f1Var.f5006e.C(sVar);
                        if (l1VarC != null) {
                            i = l1VarC.b(g4.b0.B).B;
                        } else if (b0Var.h(sVar)) {
                            b8.h.r(new g4.q1(0));
                            i = 0;
                        } else {
                            b8.h.r(new g4.q1(-100));
                        }
                        g4.r rVar = sVar.f5202d;
                        if (rVar != null) {
                            rVar.j(i, m1Var);
                        }
                    } catch (DeadObjectException unused2) {
                        f1Var.f5006e.P(sVar);
                        b8.h.r(new g4.q1(-100));
                    } catch (RemoteException e10) {
                        s1.b.q("MediaSessionImpl", "Exception in " + sVar, e10);
                        b8.h.r(new g4.q1(-1));
                    }
                }
                runnable.run();
                f1Var.f5006e.r(sVar);
                return;
            default:
                com.bumptech.glide.manager.s sVar2 = (com.bumptech.glide.manager.s) this.f279w;
                g4.t tVar = (g4.t) this.f280x;
                boolean z11 = this.f278v;
                g4.s sVar3 = (g4.s) this.f281y;
                g4.b0 b0Var2 = ((g4.m0) sVar2.f2861v).f5115g;
                g4.j1 j1Var = b0Var2.f4973t;
                z7.a.C(j1Var, tVar);
                int I = j1Var.I();
                if (I == 1) {
                    if (j1Var.e0(2)) {
                        j1Var.d();
                    }
                } else if (I == 4 && j1Var.e0(4)) {
                    j1Var.Z();
                }
                if (z11 && j1Var.e0(1)) {
                    j1Var.X();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                for (int i10 : new int[]{31, 2}) {
                    s1.d.g(!false);
                    sparseBooleanArray.append(i10, true);
                }
                if (z11) {
                    s1.d.g(!false);
                    sparseBooleanArray.append(1, true);
                }
                s1.d.g(!false);
                b0Var2.p(sVar3);
                return;
        }
    }

    public /* synthetic */ i0(Object obj, boolean z2, Object obj2, Object obj3, int i) {
        this.f277u = i;
        this.f279w = obj;
        this.f278v = z2;
        this.f280x = obj2;
        this.f281y = obj3;
    }
}
