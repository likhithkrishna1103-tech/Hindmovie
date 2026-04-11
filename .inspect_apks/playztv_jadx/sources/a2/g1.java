package a2;

import android.content.Context;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g1 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f243x;

    public /* synthetic */ g1(Object obj, Object obj2, Object obj3, int i) {
        this.f240u = i;
        this.f241v = obj;
        this.f242w = obj2;
        this.f243x = obj3;
    }

    private final void a() {
        wb.c cVar = (wb.c) this.f241v;
        cf.d dVar = (cf.d) this.f242w;
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f243x;
        try {
            androidx.emoji2.text.u uVarE = b8.h.e((Context) cVar.f14088v);
            if (uVarE == null) {
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            }
            androidx.emoji2.text.t tVar = (androidx.emoji2.text.t) ((androidx.emoji2.text.l) uVarE.f1175b);
            synchronized (tVar.f1201x) {
                tVar.f1203z = threadPoolExecutor;
            }
            ((androidx.emoji2.text.l) uVarE.f1175b).a(new androidx.emoji2.text.n(dVar, threadPoolExecutor));
        } catch (Throwable th) {
            dVar.t(th);
            threadPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b2  */
    /* JADX WARN: Type inference failed for: r1v14, types: [f2.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.net.HttpURLConnection] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.g1.run():void");
    }
}
