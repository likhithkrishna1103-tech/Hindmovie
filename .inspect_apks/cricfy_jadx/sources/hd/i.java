package hd;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ d8.j f5946w;

    public /* synthetic */ i(d8.j jVar, dd.e eVar, int i) {
        this.f5945v = i;
        this.f5946w = jVar;
    }

    private final void a() {
        d8.j jVar = this.f5946w;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((ArrayList) jVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        d8.j jVar = this.f5946w;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((ArrayList) jVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        d8.j jVar = this.f5946w;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((ArrayList) jVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5945v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            case 1:
                b();
                return;
            case 2:
                c();
                return;
            default:
                d8.j jVar = this.f5946w;
                synchronized (jVar.f3553c) {
                    try {
                        Iterator it = ((ArrayList) jVar.f).iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
