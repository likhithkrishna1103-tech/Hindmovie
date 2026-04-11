package hd;

import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5917v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f5918w;

    public /* synthetic */ b(e eVar) {
        this.f5918w = eVar;
    }

    private final void a() {
        e eVar = this.f5918w;
        synchronized (eVar.f) {
        }
        a aVar = (a) eVar.f5927c;
        ((Handler) eVar.f5926b).post(new b(eVar, aVar.s(true), aVar.s(false)));
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5917v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            default:
                e eVar = this.f5918w;
                synchronized (eVar.f) {
                }
                Iterator it = ((LinkedHashSet) eVar.f5930g).iterator();
                if (it.hasNext()) {
                    throw q4.a.l(it);
                }
                eVar.b();
                eVar.c();
                return;
        }
    }

    public /* synthetic */ b(e eVar, boolean z10, boolean z11) {
        this.f5918w = eVar;
    }
}
