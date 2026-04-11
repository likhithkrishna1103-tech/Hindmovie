package ib;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6396v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f6397w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Runnable f6398x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ p6.c f6399y;

    public /* synthetic */ d(e eVar, Runnable runnable, p6.c cVar, int i) {
        this.f6396v = i;
        this.f6397w = eVar;
        this.f6398x = runnable;
        this.f6399y = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6396v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ExecutorService executorService = this.f6397w.f6400v;
                final int i = 0;
                final Runnable runnable = this.f6398x;
                final p6.c cVar = this.f6399y;
                executorService.execute(new Runnable() { // from class: ib.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e9) {
                                    ((g) cVar.f10035w).k(e9);
                                    throw e9;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) cVar.f10035w).k(e10);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                g gVar = (g) cVar.f10035w;
                                try {
                                    runnable2.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e11) {
                                    gVar.k(e11);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                ExecutorService executorService2 = this.f6397w.f6400v;
                final int i10 = 2;
                final Runnable runnable2 = this.f6398x;
                final p6.c cVar2 = this.f6399y;
                executorService2.execute(new Runnable() { // from class: ib.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i10) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e9) {
                                    ((g) cVar2.f10035w).k(e9);
                                    throw e9;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) cVar2.f10035w).k(e10);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                g gVar = (g) cVar2.f10035w;
                                try {
                                    runnable22.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e11) {
                                    gVar.k(e11);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                ExecutorService executorService3 = this.f6397w.f6400v;
                final int i11 = 1;
                final Runnable runnable3 = this.f6398x;
                final p6.c cVar3 = this.f6399y;
                executorService3.execute(new Runnable() { // from class: ib.b
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i11) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e9) {
                                    ((g) cVar3.f10035w).k(e9);
                                    throw e9;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e10) {
                                    ((g) cVar3.f10035w).k(e10);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                g gVar = (g) cVar3.f10035w;
                                try {
                                    runnable22.run();
                                    gVar.j(null);
                                    return;
                                } catch (Exception e11) {
                                    gVar.k(e11);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
