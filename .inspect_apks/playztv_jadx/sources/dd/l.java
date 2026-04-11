package dd;

import a2.f0;
import a2.h0;
import aa.l0;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.SparseBooleanArray;
import androidx.media3.decoder.DecoderInputBuffer;
import g4.b0;
import g4.m0;
import g4.s;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4171u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4173w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4174x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4175y;

    public /* synthetic */ l(l0 l0Var, int i, List list, s sVar) {
        this.f4174x = l0Var;
        this.f4172v = i;
        this.f4173w = list;
        this.f4175y = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4171u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p) this.f4174x).j((zc.e) this.f4175y, (List) this.f4173w, this.f4172v);
                return;
            case 1:
                l0 l0Var = (l0) this.f4174x;
                List list = (List) this.f4173w;
                s sVar = (s) this.f4175y;
                b0 b0Var = ((m0) l0Var.f707x).f5115g;
                int i = this.f4172v;
                if (i == -1) {
                    b0Var.f4973t.u0(list);
                } else {
                    b0Var.f4973t.v(i, list);
                }
                new SparseBooleanArray().append(20, true);
                b0Var.p(sVar);
                return;
            default:
                b7.s sVar2 = (b7.s) this.f4174x;
                c7.j jVar = (c7.j) this.f4175y;
                int i10 = this.f4172v;
                Runnable runnable = (Runnable) this.f4173w;
                k7.c cVar = (k7.c) sVar2.f;
                try {
                    try {
                        j7.d dVar = (j7.d) sVar2.f1900c;
                        Objects.requireNonNull(dVar);
                        ((j7.g) cVar).G(new f0(23, dVar));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((Context) sVar2.f1898a).getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((j7.g) cVar).G(new h0(sVar2, i10, jVar));
                        } else {
                            sVar2.e(jVar, i10);
                        }
                        break;
                    } catch (k7.a unused) {
                        ((a7.b) sVar2.f1901d).C(jVar, i10 + 1, false);
                        break;
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
        }
    }

    public /* synthetic */ l(b7.s sVar, c7.j jVar, int i, Runnable runnable) {
        this.f4174x = sVar;
        this.f4175y = jVar;
        this.f4172v = i;
        this.f4173w = runnable;
    }

    public /* synthetic */ l(p pVar, zc.e eVar, List list, int i) {
        this.f4174x = pVar;
        this.f4175y = eVar;
        this.f4173w = list;
        this.f4172v = i;
    }
}
