package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends cf.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf.d f1189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1190e;

    public n(cf.d dVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1189d = dVar;
        this.f1190e = threadPoolExecutor;
    }

    @Override // cf.d
    public final void t(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f1190e;
        try {
            this.f1189d.t(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // cf.d
    public final void u(ub.o oVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f1190e;
        try {
            this.f1189d.u(oVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
