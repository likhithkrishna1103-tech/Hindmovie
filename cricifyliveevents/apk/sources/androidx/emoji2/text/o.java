package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.c f875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f876d;

    public o(com.bumptech.glide.c cVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f875c = cVar;
        this.f876d = threadPoolExecutor;
    }

    @Override // com.bumptech.glide.c
    public final void A(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f876d;
        try {
            this.f875c.A(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // com.bumptech.glide.c
    public final void B(b6.f fVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f876d;
        try {
            this.f875c.B(fVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
