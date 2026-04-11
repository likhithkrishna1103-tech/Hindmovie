package oa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9463u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f9464v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Runnable f9465w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ u5.d f9466x;

    public /* synthetic */ d(e eVar, Runnable runnable, u5.d dVar, int i) {
        this.f9463u = i;
        this.f9464v = eVar;
        this.f9465w = runnable;
        this.f9466x = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9463u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ExecutorService executorService = this.f9464v.f9467u;
                final int i = 0;
                final Runnable runnable = this.f9465w;
                final u5.d dVar = this.f9466x;
                executorService.execute(new Runnable() { // from class: oa.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) dVar.f12784v).k(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e11) {
                                    ((g) dVar.f12784v).k(e11);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                g gVar = (g) dVar.f12784v;
                                try {
                                    runnable2.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e12) {
                                    gVar.k(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                ExecutorService executorService2 = this.f9464v.f9467u;
                final int i10 = 2;
                final Runnable runnable2 = this.f9465w;
                final u5.d dVar2 = this.f9466x;
                executorService2.execute(new Runnable() { // from class: oa.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i10) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) dVar2.f12784v).k(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e11) {
                                    ((g) dVar2.f12784v).k(e11);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                g gVar = (g) dVar2.f12784v;
                                try {
                                    runnable22.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e12) {
                                    gVar.k(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                ExecutorService executorService3 = this.f9464v.f9467u;
                final int i11 = 1;
                final Runnable runnable3 = this.f9465w;
                final u5.d dVar3 = this.f9466x;
                executorService3.execute(new Runnable() { // from class: oa.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i11) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) dVar3.f12784v).k(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e11) {
                                    ((g) dVar3.f12784v).k(e11);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                g gVar = (g) dVar3.f12784v;
                                try {
                                    runnable22.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e12) {
                                    gVar.k(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
