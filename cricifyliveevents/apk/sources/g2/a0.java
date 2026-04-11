package g2;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.SparseBooleanArray;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4619v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f4620w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4623z;

    public /* synthetic */ a0(int i, Object obj, Object obj2, Object obj3, boolean z10) {
        this.f4619v = i;
        this.f4621x = obj;
        this.f4620w = z10;
        this.f4622y = obj2;
        this.f4623z = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        switch (this.f4619v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Context context = (Context) this.f4621x;
                boolean z10 = this.f4620w;
                g0 g0Var = (g0) this.f4622y;
                h2.l lVar = (h2.l) this.f4623z;
                MediaMetricsManager mediaMetricsManagerF = h2.j.f(context.getSystemService("media_metrics"));
                h2.k kVar = mediaMetricsManagerF == null ? null : new h2.k(context, mediaMetricsManagerF.createPlaybackSession());
                if (kVar == null) {
                    y1.b.p("ExoPlayerImpl", "MediaMetricsService unavailable.");
                    return;
                }
                if (z10) {
                    h2.f fVar = g0Var.O;
                    fVar.getClass();
                    fVar.A.a(kVar);
                }
                LogSessionId sessionId = kVar.f5515d.getSessionId();
                synchronized (lVar) {
                    pc.c cVar = lVar.f5537b;
                    cVar.getClass();
                    LogSessionId logSessionId = (LogSessionId) cVar.f10180v;
                    LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                    y1.d.g(logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE));
                    cVar.f10180v = sessionId;
                }
                return;
            case 1:
                k4.b0 b0Var = (k4.b0) this.f4621x;
                boolean z11 = this.f4620w;
                k4.s sVar = (k4.s) this.f4622y;
                Runnable runnable = (Runnable) this.f4623z;
                k4.d1 d1Var = b0Var.f6912g;
                if (z11) {
                    k4.k1 k1Var = new k4.k1("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", Bundle.EMPTY);
                    try {
                        k4.j1 j1VarK = d1Var.f6944e.k(sVar);
                        if (j1VarK != null) {
                            i = j1VarK.b(k4.b0.B).C;
                        } else if (b0Var.h(sVar)) {
                            w1.d.l(new k4.o1(0));
                            i = 0;
                        } else {
                            w1.d.l(new k4.o1(-100));
                        }
                        k4.r rVar = sVar.f7160d;
                        if (rVar != null) {
                            rVar.b(i, k1Var);
                        }
                    } catch (DeadObjectException unused2) {
                        d1Var.f6944e.p(sVar);
                        w1.d.l(new k4.o1(-100));
                    } catch (RemoteException e9) {
                        y1.b.q("MediaSessionImpl", "Exception in " + sVar, e9);
                        w1.d.l(new k4.o1(-1));
                    }
                }
                runnable.run();
                d1Var.f6944e.e(sVar);
                return;
            default:
                com.bumptech.glide.manager.u uVar = (com.bumptech.glide.manager.u) this.f4621x;
                k4.t tVar = (k4.t) this.f4622y;
                boolean z12 = this.f4620w;
                k4.s sVar2 = (k4.s) this.f4623z;
                k4.b0 b0Var2 = ((k4.l0) uVar.f2291x).f7060g;
                k4.h1 h1Var = b0Var2.f6924t;
                ab.b.B(h1Var, tVar);
                int iE = h1Var.E();
                if (iE == 1) {
                    if (h1Var.Z(2)) {
                        h1Var.b();
                    }
                } else if (iE == 4 && h1Var.Z(4)) {
                    h1Var.V();
                }
                if (z12 && h1Var.Z(1)) {
                    h1Var.T();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                for (int i10 : new int[]{31, 2}) {
                    y1.d.g(!false);
                    sparseBooleanArray.append(i10, true);
                }
                if (z12) {
                    y1.d.g(!false);
                    sparseBooleanArray.append(1, true);
                }
                y1.d.g(!false);
                b0Var2.p(sVar2);
                return;
        }
    }

    public /* synthetic */ a0(com.bumptech.glide.manager.u uVar, k4.t tVar, boolean z10, k4.s sVar) {
        this.f4619v = 2;
        this.f4621x = uVar;
        this.f4622y = tVar;
        this.f4620w = z10;
        this.f4623z = sVar;
    }
}
